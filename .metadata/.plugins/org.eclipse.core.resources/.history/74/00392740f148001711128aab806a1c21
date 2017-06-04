'user strict';
app.controller('ChatForumController',['$scope','ChatForumService','$location','$rootScope','$cookieStore','$http',
	function($scope, ChatForumService, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside ChatForumController")
	this.forum={
		chatForumId : '',
		messages : [],
		isChatorForum : '',
		name : ''
	}
	this.message={
		chatForumId : '',
		userId : '',
		msgData : '',
		msgTime : '',
		reportMessage : ''
	}
	this.forums = [];
	this.getAllForums = function (){
		console.log("Getting all forums")
		ChatForumService.getAllForums()
		.then(
				function(d) {
					$rootScope.forums=d;
					$location.path("/goForumViewAll");
				},
				function(errResponse) {
					console.log("Error while getting all ChatForums")
				});
	};
	this.getForumById =function (chatForumId){
		console.log("Getting Forum by Id")
		ChatForumService.getForumById(chatForumId)
		.then(
				function(d) {
					$rootScope.forum=d;
					$location.path("/goForumView")
				},
				function(errResponse) {
					console.log("Error while getting Forum by id")
				});
	};
	this.createForum=function(){
		console.log("Creating Forum")
		ChatForumService.createForum(this.forum)
		.then(
				function(d) {
					this.forum=d;
					$location.path("/goForum")
				},
				function(errResponse) {
					console.log("Error while creating ChatForum")
				});
	};
	this.postMessage=function(){
		console.log("Adding Message")
		this.message.chatForumId=$rootScope.forum.chatForumId;
		ChatForumService.addMessage(this.message)
		.then(
				function(d) {
					$rootScope.forum=d;
					$location.path("/goForumView")
				},
				function(errResponse) {
					console.log("Error while adding message to Forum")
				});
	};
	this.deleteForum=function(){
		console.log("Deleting Forum")
		ChatForumService.deleteForum(this.forum.chatForumId)
		.then(
				function(d) {
					this.forum=d;
					$location.path("/goForum")
				},
				function(errResponse) {
					console.log("Error while Deleting ChatForum")
				});
	}
}])