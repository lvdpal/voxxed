'use strict';

angular.module('myApp.event', ['ngRoute', 'ngSanitize'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider
      .when('/event', {
        templateUrl: 'event/showEvents.html',
        controller: 'EventCtrl'
      })
      .when('/event/details', {
        templateUrl: 'event/details.html',
        controller: 'EventCtrl'
      });
}])

.controller('EventCtrl', ['$scope', '$http', '$location', 'eventFactory', function($scope, $http, $location, eventFactory) {
	$scope.events = {};
	$scope.selectedEvent = eventFactory.get();

	$scope.allEvents = function() {
		console.log('fetching all events');
        fetchEvents();
    };

    function showEvents() {
    	var getEventsUrl = 'http://localhost:8080/';
    	// var getEventsUrl = 'http://localhost:8080/event/getAll';
    	$http.get(getEventsUrl).then(function(response) {
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
        }, function (response) {
            console.log('Error: ', response);
        });
    }

    $scope.openDetails = function(event) {
        $location.path('/event/details');
        eventFactory.set(event);
    };
    $scope.backToList = function() {
        $location.path('/event');
    };

    $scope.orderTicket = function(id) {
        $location.path('/order');
        eventFactory.set(event);
    }
    showEvents();
}]);
