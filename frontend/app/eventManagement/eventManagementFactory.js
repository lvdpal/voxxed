'use strict';

angular.module('myApp.eventManagementFactory', ['ngRoute', 'ngSanitize'])
    
.factory("eventManagementFactory", function() {
    var selectedEvent = {};

    function setEvent(data) {
        selectedEvent = data;
    }
    function getEvent() {
        return selectedEvent;
    }

    return {
        setEvent: setEvent,
        getEvent: getEvent
    }
});