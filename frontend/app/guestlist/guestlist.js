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
        var getEventsUrl = 'http://localhost:8082/guestList/getEvents';
        $http.get(getEventsUrl).then(function(response) {
            $scope.events = response.data;
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
        var getGuestlistUrl = 'http://localhost:8082/guestList/getGuestsForEvent/' + $scope.selectedEventId;
        $http.get(getGuestlistUrl).then(function(response) {
            $scope.guestlist = response.data;
        }, function (response) {
            console.log('Error: ', response);
        });
    }

    $scope.backToList = function() {
        $location.path('/guestlist/events');
    };

    showGuestlist();
}]);
