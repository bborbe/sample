'use strict';

var myControllers = angular.module('myControllers', []);

myControllers.controller('ResultListCtrl', ['$scope', 'Result', function ($scope, Result) {
	$scope.results = Result.query();
}]);