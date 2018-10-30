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
	$scope.selectedEvent = eventFactory.getEvent();
	$scope.selectedTicketType = eventFactory.getTicketType();

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

    function showTicketTypes() {
	    var getTicketTypesUrl = 'http://localhost:8080';

	    $http.get(getTicketTypesUrl).then(function(response) {
	        $scope.ticketTypes = [
                {
                    "name": "Early bird ticket",
                    "price": "50"
                },
                {
                    "name": "Junior ticket",
                    "price": "40"
                },
                {
                    "name": "Senior ticket",
                    "price": "60"
                },
                {
                    "name": "Group ticket (5 persons)",
                    "price": "350"
                },
                {
                    "name": "Regular ticket",
                    "price": "75"
                }
            ];
        });
    }

    $scope.openDetails = function(event) {
        $location.path('/event/details');
        eventFactory.setEvent(event);
    };
    $scope.backToList = function() {
        $location.path('/event');
    };

    $scope.orderTicket = function(event, ticketType) {
        $location.path('/order');
        eventFactory.setEvent(event);
        eventFactory.setTicketType(ticketType);
    };

    showEvents();
    showTicketTypes();
}]);
