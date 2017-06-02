'use strict';

app.service('ChatForumService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("ChatForumService...")
	var BASE_URL='http://localhost:8081/FindUrFriendControllerRest/'
		return {
		getAllForums : function(){
			console.log("Getting all Forums")
			return $http.get(BASE_URL+'getAllChatForum')
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting all ChatForum');
                        return $q.reject(errResponse);
                    });
		},
		getForumById : function(chatForumId){
			console.log("Getting Forum by id")
			return $http.get(BASE_URL+'getChatForumById/'+chatForumId)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting ChatForum');
                        return $q.reject(errResponse);
                    });
		},
		createForum : function(forum) {
			console.log("Creating forum")
			return $http.post(BASE_URL+'createChatForum/',forum)
			.then(
					function(reponse){
						return response.data;
					},
					function(errResponse){
						console.error('Error while creating Forum');
						return $q.reject(errResponse);
					});
		},
		addMessage : function(message) {
			console.log("Adding message")
			return $http.post(BASE_URL+'addMessage/',message)
			.then(
					function(response){
						return response.data;	
					},
					function(errResponse){
						console.error('Error while adding message');
						return$q.reject(errResponse);
					});
		},
		deleteForum : function(forumID) {
			console.log("Deleting forum")
			return $http.post(BASE_URL+'removeChatForum/'+forumID)
			.then(
					function(reponse){
						return response.data;
					},
					function(errResponse){
						console.error('Error while deleting Forum');
						return $q.reject(errResponse);
					});
		}
	}
}])	