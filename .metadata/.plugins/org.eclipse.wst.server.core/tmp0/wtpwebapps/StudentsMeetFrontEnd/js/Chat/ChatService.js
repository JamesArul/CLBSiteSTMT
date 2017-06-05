'use strict';
app.service('ChatService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("ChatService...")
	var BASE_URL='http://localhost:8081/StudentsMeetControllerRest/';
		return {
			createChat : function(chat){
				console.log("Creating chat..ChatService");
				return $http.post(BASE_URL+'createChat/',chat)
				.then(
						function(response){
	                        return response.data;
	                    }, 
	                    function(errResponse){
	                        console.error('Error while creating chat..ChatService');
	                        return $q.reject(errResponse);
	                    });
			},
			getUserFriends : function(userId){
				console.log("Getting friends..ChatService");
				return $http.get(BASE_URL+'getFriendsOfUser/'+userId)
				.then(
						function(response){
	                        return response.data;
	                    }, 
	                    function(errResponse){
	                        console.error('Error while getting friends in chat..ChatService');
	                        return $q.reject(errResponse);
	                    });
			},
			getOpenChats : function(){
				console.log("getting open chats..ChatService")
				return $http.get(BASE_URL+'getOpenChat/')
				.then(
						function(response){
	                        return response.data;
	                    }, 
	                    function(errResponse){
	                        console.error('Error while getting open chat..ChatService');
	                        return $q.reject(errResponse);
	                    });
			}
		}
}])