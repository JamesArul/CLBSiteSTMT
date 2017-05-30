var app = angular.module("myApp",['ngRoute','ngCookies']);
app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'Common/CommonHome.html'	
	})
	.when('/goRegister', {
		templateUrl : 'User/Register.html',
		controller : 'UserController'
	})

	.otherwise({
		redirectTo : '/'
	});
});
app.run( function ($rootScope, $location,$cookieStore, $http) {
	
});