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
            console.log('editing event');
            eventManagementFactory.setEvent(event);
            $location.path('/eventManagement/edit');
        };

        $scope.deleteEvent = function(event) {
            console.log('delete event');
            var urlCreateEvent = 'http://localhost:8085/programming/deleteEvent';
            $http.delete(urlCreateEvent, event).then(function(response) {
                console.log('deleted event: ' + event);
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
            var urlCreateEvent = 'http://localhost:8085/programming/addEvent';
            $http.post(urlCreateEvent, event).then(function(response) {
                $scope.selectedEvent = response.data;
                console.log('created event: ' + $scope.selectedEvent.id);
            }, function (response) {
                console.log('Error: ', response);
            });

            showEvents();
            $location.path('/eventManagement/events');
        };

        showEvents();
    }])

    .controller('EventManagementEditCtrl', ['$scope', '$http', '$location', 'eventManagementFactory', function($scope, $http, $location, eventManagementFactory) {
        $scope.selectedEvent = eventManagementFactory.getEvent();

        $scope.saveEvent = function(event) {
            console.log('update event');
            var urlCreateEvent = 'http://localhost:8085/programming/updateEvent';
            $http.post(urlCreateEvent, event).then(function(response) {
                $scope.selectedEvent = response.data;
                console.log('updated event: ' + $scope.event);
            }, function (response) {
                console.log('Error: ', response);
            });

            $location.path('/eventManagement/events');
        };
    }])
;
