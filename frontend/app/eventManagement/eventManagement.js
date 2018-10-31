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
            .when('/eventManagement/addSeating', {
                templateUrl: 'eventManagement/addSeating.html',
                controller: 'EventManagementCtrl'
            })
            .when('/eventManagement/editSeating', {
                templateUrl: 'eventManagement/editSeating.html',
                controller: 'EventManagementSeatingCtrl'
            });
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

        $scope.editSeating = function(seating) {
            eventManagementFactory.setSeating(seating);
            $location.path('/eventManagement/editSeating');
        };

        $scope.deleteEvent = function(event) {
            var urlCreateEvent = 'http://localhost:8085/programming/deleteEvent/'+event.id;
            $http.delete(urlCreateEvent).then(function(response) {
                showEvents();
            }, function (response) {
                console.log('Error: ', response);
            });
        };

        $scope.deleteSeating = function(seating) {
            var urlCreateEvent = 'http://localhost:8085/programming/deleteSeating/'+seating.id;
            $http.delete(urlCreateEvent).then(function(response) {
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

        $scope.addSeating = function(event) {
            eventManagementFactory.setEvent(event);
            $location.path('/eventManagement/addSeating');
        };

        $scope.createSeating = function(seating, event) {
            seating.programmingEvent = eventManagementFactory.getEvent();
            var urlCreateSeating = 'http://localhost:8085/programming/addSeating';
            $http.post(urlCreateSeating, seating).then(function(response) {
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

    .controller('EventManagementSeatingCtrl', ['$scope', '$http', '$location', 'eventManagementFactory', function($scope, $http, $location, eventManagementFactory) {
        $scope.selectedSeating = eventManagementFactory.getSeating();

        $scope.saveSeating = function(seating) {
            var urlCreateSeating = 'http://localhost:8085/programming/updateSeating';
            $http.post(urlCreateSeating, seating).then(function(response) {
                $location.path('/eventManagement/events');
            }, function (response) {
                console.log('Error: ', response);
            });
        };
    }])
;
