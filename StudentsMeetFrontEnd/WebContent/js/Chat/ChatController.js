'use strict';
app.controller('ChatController',['$scope','ChatService','$location','$rootScope','$cookieStore','$http',
	function($scope, ChatService, $location, $rootScope,$cookieStore, $http){
	console.log("Inside ChatController")
	this.chat={
		chatId :'',
		creatorID : '',
		isPrivateChat :'',
		reportChat :'',
		chatTopic :'',
		chat_Messages : []
	};
	this.friend={
			friendId :'',
			isOnline :'',
			friendStatus :''
	};
	this.chatID='';
	this.user={
			errorCode : '',
			errorMsg : '',
			userID : '',
			userName : '',
			userPassword : '',
			userQualification : {
				tenthPercentage : '',
				twelfthPercentage : '',
				bachelorCGPAPercentage : ''
			},
			isOnline : '' ,
			lastSeenOnline : '',
			userRole : '',
			userFriends : [],
			userImage : ''
		};
	this.createChat=function(){
		console.log("Creating chat")
		this.user=$cookieStore.get('currentUser');
		this.chat.creatorID=this.user.userID;
		this.getFriends();
		ChatService.createChat(this.chat)
		.then(
				function(d){
					$rootScope.chat=d;
					$location.path("/goChatPage")
				},
				function(errResponse){
					console.error('Error while creating chat');
				});
	};
	this.getFriends=function(){
		console.log("Getting friends");
		this.user=$cookieStore.get('currentUser');
		this.chat.creatorID=this.user.userID;
		ChatService.getUserFriends(this.user.userID)
		.then(
				function(d){
					$rootScope.friends=d;
				},
				function(errResponse){
					console.error('Error while creating chat');
				});
	};
	this.getAllAvailableChat=function(){
		console.log("getting all open chats")
		ChatService.getOpenChats()
			.then(
					function(d){
						$rootScope.chats=d;
						$location.path("/goChatViewOpen")
					},
					function(errResponse){
						console.error('Error while creating chat');
					});
	};
	this.joinOpenChat=function(chatID){
		
	}
}])