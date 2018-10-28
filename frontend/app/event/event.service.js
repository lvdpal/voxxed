(function () {

    'use strict';
    angular.module('myApp.event')
        .factory('EventService', EventService);

    /* @ngInject */
    function EventService(Restangular) {
        var service = {
        	showEvents: showEvents
        };
        return service;
        //----------------------------------------------------------------------------//

        function showEvents() {
        	return Restangular.all('event/showEvents').get().then(_cleanResponse);
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
