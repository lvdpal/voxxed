'use strict';

angular.module('myApp.location', ['ngRoute', 'ngSanitize'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/location', {
                templateUrl: 'location/showLocations.html',
                controller: 'locationCtrl'
            })
            .when('/location/add', {
                templateUrl: 'location/addLocation.html',
                controller: 'locationCtrl'
            })
            .when('/location/edit', {
                templateUrl: 'location/editLocation.html',
                controller: 'locationEditCtrl'
            });
    }])

    .controller('locationCtrl', ['$scope', '$http', '$location', 'locationFactory', function($scope, $http, $location, locationFactory) {
        $scope.locations = {};

        function showLocations() {
            var getLocationsUrl = 'http://localhost:8083/location/getLocations';
            $http.get(getLocationsUrl).then(function(response) {
                $scope.locations = response.data;
            }, function (response) {
                console.log('Error: ', response);
            });
        }

        $scope.editLocation = function(location) {
            locationFactory.setLocation(location);
            $location.path('/location/edit');
        };

        $scope.deleteLocation = function(location) {
            var urlDeleteLocation = 'http://localhost:8083/location/deleteLocation/'+location.id;
            $http.delete(urlDeleteLocation).then(function(response) {
                showLocations();
            }, function (response) {
                console.log('Error: ', response);
            });
        };

        $scope.addLocation = function() {
            $location.path('/location/add');
        };
        $scope.createLocation = function(location) {
            var urlCreateLocation = 'http://localhost:8083/location/addLocation';
            $http.post(urlCreateLocation, location).then(function(response) {
                showLocations();
                $location.path('/location');
            }, function (response) {
                console.log('Error: ', response);
            });
        };

        showLocations();
    }])

    .controller('locationEditCtrl', ['$scope', '$http', '$location', 'locationFactory', function($scope, $http, $location, locationFactory) {
        $scope.selectedLocation = locationFactory.getLocation();

        $scope.saveLocation = function(location) {
            var urlCreateLocation = 'http://localhost:8083/location/updateLocation';
            $http.post(urlCreateLocation, location).then(function(response) {
                $location.path('/location');
            }, function (response) {
                console.log('Error: ', response);
            });
        };
    }])
;
