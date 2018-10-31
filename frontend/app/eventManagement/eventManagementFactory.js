'use strict';

angular.module('myApp.eventManagementFactory', ['ngRoute', 'ngSanitize'])
    
.factory("eventManagementFactory", function() {
    var selectedEvent = {};
    var selectedSeating = {};

    function setEvent(data) {
        selectedEvent = data;
    }
    function getEvent() {
        return selectedEvent;
    }

    function setSeating(data) {
        selectedSeating = data;
    }
    function getSeating() {
        return selectedSeating;
    }

    return {
        setEvent: setEvent,
        getEvent: getEvent,
        setSeating: setSeating,
        getSeating: getSeating
    }
});