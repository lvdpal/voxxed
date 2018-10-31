'use strict';

angular.module('myApp.locationFactory', ['ngRoute', 'ngSanitize'])
    
.factory("locationFactory", function() {
    var selectedLocation = {};

    function setLocation(data) {
        selectedLocation = data;
    }
    function getLocation() {
        return selectedLocation;
    }

    return {
        setLocation: setLocation,
        getLocation: getLocation
    }
});