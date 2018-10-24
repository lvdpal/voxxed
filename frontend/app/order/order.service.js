(function () {

    'use strict';
    angular.module('myApp.order')
        .factory('OrderService', OrderService);

    /* @ngInject */
    function OrderService(Restangular) {
        var service = {
        	createOrder: createOrder
        };
        return service;
        //----------------------------------------------------------------------------//

        function createOrder() {
        	return Restangular.all('order/createOrder').get().then(_cleanResponse);
        }

        function _boolean(response) {
            if (angular.isUndefined(response)) {
                return false;
            }
            return response;
        }

        function _cleanResponse(response) {
            return Restangular.stripRestangular(response);
        }
    }
}());
