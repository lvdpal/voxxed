'use strict';

angular.module('myApp.eventFactory', ['ngRoute', 'ngSanitize'])
    
.factory("eventFactory", function() {
    var selectedEvent = {};
    var selectedTicketType = {};

    function setEvent(data) {
        selectedEvent = data;
    }
    function getEvent() {
        return selectedEvent;
    }

    function setTicketType(data) {
        selectedTicketType = data;
    }
    function getTicketType() {
        return selectedTicketType;
    }

   return {
       setEvent: setEvent,
       getEvent: getEvent,
       setTicketType: setTicketType,
       getTicketType: getTicketType
   }
});