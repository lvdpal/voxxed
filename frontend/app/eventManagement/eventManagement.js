'use strict';

angular.module('myApp.eventManagement', ['ngRoute', 'ngSanitize'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/eventManagement/events', {
                templateUrl: 'eventManagement/showEvents.html',
                controller: 'EventManagementCtrl'
            })
            .when('/eventManagement/add', {
                templateUrl: 'eventManagement/addEvent.html',
                controller: 'EventManagementCtrl'
            })
            .when('/eventManagement/edit', {
                templateUrl: 'eventManagement/editEvent.html',
                controller: 'EventManagementEditCtrl'
            })
        ;
    }])

    .controller('EventManagementCtrl', ['$scope', '$http', '$location', 'eventManagementFactory', function($scope, $http, $location, eventManagementFactory) {
        $scope.events = {};

        function showEvents() {
            var getEventsUrl = 'http://localhost:8085/programming/getEvents';
            $http.get(getEventsUrl).then(function(response) {
                $scope.events = response.data;
            }, function (response) {
                console.log('Error: ', response);
            });
        }

        $scope.editEvent = function(event) {
            eventManagementFactory.setEvent(event);
            $location.path('/eventManagement/edit');
        };

        $scope.deleteEvent = function(event) {
            var urlCreateEvent = 'http://localhost:8085/programming/deleteEvent';
            $http.delete(urlCreateEvent, event).then(function(response) {
                console.log('deleted event: ' + event);
                showEvents();
            }, function (response) {
                console.log('Error: ', response);
            });
        };

        $scope.addEvent = function() {
            $location.path('/eventManagement/add');
        };
        $scope.createEvent = function(event) {
            var urlCreateEvent = 'http://localhost:8085/programming/addEvent';
            $http.post(urlCreateEvent, event).then(function(response) {
                showEvents();
                $location.path('/eventManagement/events');
            }, function (response) {
                console.log('Error: ', response);
            });
        };

        showEvents();
    }])

    .controller('EventManagementEditCtrl', ['$scope', '$http', '$location', 'eventManagementFactory', function($scope, $http, $location, eventManagementFactory) {
        $scope.selectedEvent = eventManagementFactory.getEvent();

        $scope.saveEvent = function(event) {
            var urlCreateEvent = 'http://localhost:8085/programming/updateEvent';
            $http.post(urlCreateEvent, event).then(function(response) {
                $location.path('/eventManagement/events');
            }, function (response) {
                console.log('Error: ', response);
            });
        };
    }])
;
