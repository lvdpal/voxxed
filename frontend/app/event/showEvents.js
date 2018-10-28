'use strict';

angular.module('myApp.event', ['ngRoute', 'ngSanitize'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/event', {
    templateUrl: 'event/showEvents.html',
    controller: 'EventCtrl'
  });
}])

.controller('EventCtrl', ['$scope', '$http', function($scope, $http) {
	$scope.events = {};

	$scope.allEvents = function() {
		console.log('fetching all events');
        fetchEvents();
    };

    function showEvents() {
    	var getEventsUrl = 'http://localhost:8080/';
    	// var getEventsUrl = 'http://localhost:8080/event/getAll';
    	$http.get(getEventsUrl).then(function(response) {
            console.log('We have retrieved the events');
    	    // $scope.events = response.data;
            $scope.events = [
                {
                    "name": "Jan Smit",
                    "locationName": "Arena"
                },
                {
                    "name": "Marco Borsato",
                    "locationName": "Ziggo Dome"
                }
            ];


            console.log('retrieved events ' + $scope.events);
        }, function (response) {
            console.log('Error: ', response);
        });
    }

    showEvents();
}]);
