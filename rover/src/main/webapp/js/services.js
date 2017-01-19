'use strict';

/* Services */

var services = angular.module('rover.services', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/rover/rest/rover', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});
