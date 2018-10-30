'use strict';

angular.module('myApp.report', ['ngRoute', 'ngSanitize'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/report/events', {
                templateUrl: 'report/showEvents.html',
                controller: 'ReportCtrl'
            })
            .when('/report/locations', {
                templateUrl: 'report/showLocations.html',
                controller: 'EventReportCtrl'
            })
            .when('/report/eventReport/:eventId', {
                templateUrl: 'report/showEventReport.html',
                controller: 'ReportCtrl'
            })
            .when('/report/locationReport/:locationId', {
                templateUrl: 'report/showLocationReport.html',
                controller: 'LocationReportCtrl'
            });
    }])

    .controller('ReportCtrl', ['$scope', '$http', '$location', function($scope, $http, $location) {
        $scope.events=[];
        $scope.locations=[];

        function showEvents() {
            var getEventsUrl = 'http://localhost:8080/';
            $http.get(getEventsUrl).then(function(response) {
                // $scope.events = response.data;
                $scope.events = [
                    {
                        "id": 1,
                        "name": "Jan Smit",
                        "locationName": "Arena"
                    },
                    {
                        "id": 2,
                        "name": "Marco Borsato",
                        "locationName": "Ziggo Dome"
                    }
                ];
            }, function (response) {
                console.log('Error: ', response);
            });
        }

        $scope.openEventReport = function(eventId) {
            console.log(eventId);
            $location.path('/report/eventReport/'+eventId);
        };

        function showLocations() {
            var getLocationsUrl = 'http://localhost:8080/';
            $http.get(getLocationsUrl).then(function(response) {
                // $scope.locations = response.data;
                $scope.locations = [
                    {
                        "id": 1,
                        "name": "Arena"
                    },
                    {
                        "id": 2,
                        "name": "Ziggo Dome"
                    }
                ];
            }, function (response) {
                console.log('Error: ', response);
            });
        }

        $scope.openLocationReport = function(eventId) {
            $location.path('/report/locationReport/'+eventId);
        };

        showEvents();
        showLocations();
    }])

    .controller('EventReportCtrl', ['$scope', '$http', '$location', '$routeParams', function($scope, $http, $location, $routeParams) {
        $scope.selectedEventId = $routeParams.eventId;
        $scope.report = {};

        function fetchReport() {
            var getEventReportUrl = 'http://localhost:8080/';
            $http.get(getEventReportUrl).then(function(response) {
                // $scope.report = response.data;
                $scope.report = {
                    "name": "Jan Smit",
                    "totalNumberOfTicketsSold": 150,
                    "ticketsPerType": [
                        {
                            "ticketType": "Early bird ticket",
                            "number": 15,
                            "totalAmount": "750,00"
                        },
                        {
                            "ticketType": "Junior ticket",
                            "number": 4,
                            "totalAmount": "160,00"
                        },
                        {
                            "ticketType": "Senior ticket",
                            "number": 15,
                            "totalAmount": "900,00"
                        },
                        {
                            "ticketType": "Group ticket (5 persons)",
                            "number": "7",
                            "totalAmount": "2450,00"
                        },
                        {
                            "ticketType": "Regular ticket",
                            "number": "81",
                            "totalAmount": "6075,00"
                        }
                    ],
                    "totalAmount": "10.335,00"
                };
                console.log('We have the report now');
            }, function (response) {
                console.log('Error: ', response);
            });
        }

        $scope.backToList = function() {
            $location.path('/report/events');
        };

        fetchReport();
    }])

    .controller('LocationReportCtrl', ['$scope', '$http', '$location', '$routeParams', function($scope, $http, $location, $routeParams) {
        $scope.selectedLocationId = $routeParams.locationId;

        $scope.report = {};

        function fetchReport() {
            var getEventReportUrl = 'http://localhost:8080/';
            $http.get(getEventReportUrl).then(function(response) {
                // $scope.report = response.data;
                $scope.report = {
                    "name": "Arena",
                    "totalNumberOfTicketsSold": 150,
                    "ticketsPerType": [
                        {
                            "ticketType": "Early bird ticket",
                            "number": 15,
                            "totalAmount": "750,00"
                        },
                        {
                            "ticketType": "Junior ticket",
                            "number": 4,
                            "totalAmount": "160,00"
                        },
                        {
                            "ticketType": "Senior ticket",
                            "number": 15,
                            "totalAmount": "900,00"
                        },
                        {
                            "ticketType": "Group ticket (5 persons)",
                            "number": "7",
                            "totalAmount": "2450,00"
                        },
                        {
                            "ticketType": "Regular ticket",
                            "number": "81",
                            "totalAmount": "6075,00"
                        }
                    ],
                    "totalAmount": "10.335,00"
                };
                console.log('We have the report now');
            }, function (response) {
                console.log('Error: ', response);
            });
        }

        $scope.backToList = function() {
            $location.path('/report/locations');
        };

        fetchReport();
    }]);
