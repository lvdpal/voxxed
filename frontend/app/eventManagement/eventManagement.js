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

        $scope.editEvent = function(event) {
            eventManagementFactory.setEvent(event);
            $location.path('/eventManagement/edit');
        };

        $scope.deleteEvent = function(eventId) {
            console.log('delete event');
            var urlCreateEvent = 'http://localhost:8080/';
            $http.delete(urlCreateEvent, eventId).then(function(response) {
                console.log('deleted event: ' + eventId);
            }, function (response) {
                console.log('Error: ', response);
            });

            showEvents();
        };

        $scope.addEvent = function() {
            $location.path('/eventManagement/add');
        };
        $scope.createEvent = function(event) {
            console.log('create event');
            var urlCreateEvent = 'http://localhost:8080/';
            $http.post(urlCreateEvent, event).then(function(response) {
                $scope.eventId = response.data;
                console.log('created event: ' + $scope.eventId);
            }, function (response) {
                console.log('Error: ', response);
            });
        };

        showEvents();
    }])

    .controller('EventManagementEditCtrl', ['$scope', '$http', '$location', 'eventManagementFactory', function($scope, $http, $location, eventManagementFactory) {
        $scope.selectedEvent = eventManagementFactory.getEvent();

        $scope.saveEvent = function(event) {
            console.log('update event');
            var urlCreateEvent = 'http://localhost:8080/';
            $http.post(urlCreateEvent, event).then(function(response) {
                $scope.eventId = response.data;
                console.log('updated event: ' + $scope.eventId);
            }, function (response) {
                console.log('Error: ', response);
            });

            $location.path('/eventManagement/events');
        };
    }])
;
