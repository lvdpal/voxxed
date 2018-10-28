'use strict';

angular.module('myApp.eventFactory', ['ngRoute', 'ngSanitize'])
    
.factory("eventFactory", function() {
   var selectedEvent = [];
   function set(data) {
       selectedEvent = data;
   }
   function get() {
       return selectedEvent;
   }

   return {
       set: set,
       get: get
   }
});