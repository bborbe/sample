'use strict';

var myServices = angular.module('myServices', ['ngResource']);

myServices.factory('Result', ['$resource',
	function ($resource) {
		return $resource('rest/results/:resultId', {}, {
			query: {method: 'GET', params: {}, isArray: true}
		});
	}]);