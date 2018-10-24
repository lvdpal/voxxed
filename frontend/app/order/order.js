'use strict';

angular.module('myApp.order', ['ngRoute', 'ngSanitize'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/order', {
    templateUrl: 'order/order.html',
    controller: 'OrderCtrl'
  });
}])

.controller('OrderCtrl', ['$scope', '$http', function($scope, $http) {
	$scope.orderId = {};

	$scope.startOrder = function() {
		console.log('order your tickets here');
		createOrder();
	}

    function createOrder() {
    	console.log('create order');
    	var urlCreateOrder = 'http://localhost:8080/';
    	$http.get(urlCreateOrder).then(function(response) {
            $scope.orderId = response.data;
            console.log('created order: ' + $scope.orderId);
        }, function (response) {
            console.log('Error: ', response);
        });
    }
}]);
