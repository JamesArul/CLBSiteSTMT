'use strict';
app.service('ForumService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("ForumService...")
	var BASE_URL='http://localhost:8081/StudentsMeetControllerRest/';
		return {
			createForum : function(forum){
				console.log("Creating forum..ForumService")
				return $http.post(BASE_URL+'createForum/',forum)
				.then(
						function(response){
	                        return response.data;
	                    }, 
	                    function(errResponse){
	                        console.error('Error while creating forum..ForumService');
	                        return $q.reject(errResponse);
	                    });
			}
		}
}])