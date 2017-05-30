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
		}
	}
	}])