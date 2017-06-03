'use strict';
app.service('UserService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("UserService...")
	var BASE_URL='http://localhost:8081/StudentsMeetControllerRest/'
		return {
		createUser : function(user) {
			console.log("Creating user in UserService")
			return $http.post(BASE_URL+'createUser/',user)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    });
		},
		login : function(user){
			console.log("Login user")
			return $http.post(BASE_URL+'validateUser/',user)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while login');
						return $q.reject(errResponse);
					});
		},
		logout : function(user){
			console.log("Logout user")
			return $http.get(BASE_URL+'userLogout/'+user.userID)
		},
		getFriends : function(userID){
			console.log("Getting user Friends..UserService")
			return $http.get(BASE_URL+'getAllFriendsOfUser/'+userID)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while getting freinds..UserService');
						return $q.reject(errResponse);
					});
		},
		getAllUsers : function(){
			console.log("Gettting all users")
			return $http.get(BASE_URL+'getAllUsers')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while getting users..UserService');
						return $q.reject(errResponse);
					});
		}
	}
	}])