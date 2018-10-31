'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'ngSanitize',
    'myApp.order',
    'myApp.event',
    'myApp.eventFactory',
    'myApp.version',
    'myApp.guestlist',
    'myApp.report',
    'myApp.eventManagement',
    'myApp.eventManagementFactory',
    'myApp.location',
    'myApp.locationFactory'
]).
config(['$locationProvider', '$routeProvider', '$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/event'});

  //$httpProvider.defaults.headers.post = {};
  //$httpProvider.defaults.useXDomain = true;
  
}]).
filter('to_trusted', ['$sce', function($sce){
        return function(text) {
            return $sce.trustAsHtml(text);
        };
    }]);
