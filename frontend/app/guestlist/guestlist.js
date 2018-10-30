'use strict';

angular.module('myApp.guestlist', ['ngRoute', 'ngSanitize'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/guestlist/events', {
            templateUrl: 'guestlist/guestlistEvents.html',
            controller: 'GuestlistEventCtrl'
        })
        .when('/guestlist/:eventId', {
            templateUrl: 'guestlist/guestlist.html',
            controller: 'GuestlistCtrl'
        });
}])

.controller('GuestlistEventCtrl',
            ['$scope', '$http', '$location', '$routeParams',
                function($scope, $http, $location, $routeParams) {
    $scope.events = {};
    $scope.selectedEventId = $routeParams.eventId;

    function showEvents() {
        var getEventsUrl = 'http://localhost:8080/';
        // var getEventsUrl = 'http://localhost:8080/event/getAll';
        $http.get(getEventsUrl).then(function(response) {
            // $scope.events = response.data;
            $scope.events = [
                {
                    "id": 1,
                    "name": "Jan Smit"
                },
                {
                    "id": 2,
                    "name": "Marco Borsato"
                }
            ];
        }, function (response) {
            console.log('Error: ', response);
        });
    }

    $scope.openDetails = function(eventId) {
        console.log(eventId);
        $location.path('/guestlist/'+eventId);
    };

    showEvents();
}])

.controller('GuestlistCtrl',
            ['$scope', '$http', '$location', '$routeParams',
            function($scope, $http, $location, $routeParams) {
    $scope.guestlist = [];
    $scope.selectedEventId = $routeParams.eventId;

    function showGuestlist() {
        var getGuestlistUrl = 'http://localhost:8080/';
        // var getGuestlistUrl = 'http://localhost:8080/event/getAll';
        $http.get(getGuestlistUrl).then(function(response) {
            // $scope.guestlist = response.data;
            $scope.guestlist = [
                {
                    "name": "Amerongen, Piet van",
                    "partySize": 1
                },
                {
                    "name": "Borsato, Marco",
                    "partySize": 2
                },
                {
                    "name": "Pietersen, Piet",
                    "partySize": 5
                },
                {
                    "name": "Zwan, Jan",
                    "partySize": 1
                }
            ];
        }, function (response) {
            console.log('Error: ', response);
        });
    }

    $scope.backToList = function() {
        $location.path('/guestlist/events');
    };

    showGuestlist();
}]);
