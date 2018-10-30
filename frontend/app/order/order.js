'use strict';

angular.module('myApp.order', ['ngRoute', 'ngSanitize'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider
      .when('/order', {
        templateUrl: 'order/order.html',
        controller: 'OrderCtrl'
      })
      .when('/myOrders', {
          templateUrl: 'order/list.html',
          controller: 'OrderCtrl'
      });
}])

.controller('OrderCtrl', ['$scope', '$http', 'eventFactory', function($scope, $http, eventFactory) {
    $scope.selectedEvent = eventFactory.getEvent();
    $scope.selectedTicketType = eventFactory.getTicketType();
    $scope.ticket = {
        "name": "",
        "partySize": "",
        "event": $scope.selectedEvent,
        "ticketType": $scope.selectedTicketType
    };
    $scope.orders = [];

	$scope.order = function(ticket) {
		console.log('order your tickets here');
		createOrder(ticket);
	};

    function createOrder(ticket) {
    	console.log('create order');
    	var urlCreateOrder = 'http://localhost:8080/order/createOrder';
    	$http.post(urlCreateOrder, ticket).then(function(response) {
            $scope.orderId = response.data;
            console.log('created order: ' + $scope.orderId);
        }, function (response) {
            console.log('Error: ', response);
        });
    };

    function showOrders() {
        var urlFetchOrders = 'http://localhost:8080/';
        $http.get(urlFetchOrders).then(function(response) {
            $scope.orders = [
                {
                    "name": "Jan Smit",
                    "location": "Arena",
                    "groupSize": "1",
                    "ticketType": "Early bird"
                },
                {
                    "name": "Marco Borsato",
                    "locationName": "Ziggo Dome",
                    "groupSize": "5",
                    "ticketType": "Group ticket (5 persons)"
                }
            ];
        })
    }

    showOrders();
}]);
