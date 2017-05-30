'use strict';

app.service('UserService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("UserService...")
	var BASE_URL='http://localhost:8081/FindUrFriendControllerRest/'
		return {
		createUser : function(user) {
			console.log("Creating user in UserService")
			return $http.post(BASE_URL+'addUser/',user)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    });
		},
	loginUser : function(user){
		console.log("Login user in Userservice")
		return $http.post(BASE_URL+'loginvalidate/',user)
		.then(
				function(response){
					console.log("User Validated")
                    return response.data;
                }, 
                function(errResponse){
                    console.error('Error while logging in user');
                    return $q.reject(errResponse);
                });
	},
	logoutUser : function(user){
		console.log("Logout user in UserService")
		return $http.post(BASE_URL+'logoutuser/',user)
		.then(
				function(){
                    return '';
                }, 
                function(errResponse){
                    console.error('Error while logging out user');
                    return $q.reject(errResponse);
                });
	}
		
	}
	}])