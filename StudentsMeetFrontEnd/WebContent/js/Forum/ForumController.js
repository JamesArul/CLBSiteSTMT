'user strict';
app.controller('ForumController',['$scope','ForumService','$cookies','$location','$rootScope','$cookieStore','$http',
	function($scope, ForumService, $cookies, $location, $rootScope, $cookieStore, $http) {
	console.log("Inside ForumController")
	this.forum={
		forumId : '',
		forumName : '',
		messages : []
	};
	this.createForum=function(){
		console.log("Creating forum")
		ForumService.createForum(this.forum)
		.then(
				function(d){
					$rootScope.forums=d;
					$location.path("/goForumViewAll")
				},
				function(errResponse){
					console.error('Error while creating Forum');
				});
	}
}])