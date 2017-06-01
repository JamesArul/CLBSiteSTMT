'use strict';
app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("BlogService...")
	var BASE_URL='http://localhost:8081/StudentsMeetControllerRest/'
		return {
		createBlog : function(blog){
			console.log("Creating blog in BlogService..BlogService")
			return $http.post(BASE_URL+'createBlog/',blog)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating blog..BlogService');
                        return $q.reject(errResponse);
                    });
		},
		getAllBlog : function(){
			console.log("Retrieve all blog..BlogService")
			return $http.get(BASE_URL+'getAllBlog')
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting all blog..BlogService');
                        return $q.reject(errResponse);
                    });
		},
		getBlogByID : function(blogID){
			console.log("Getting blog with id..BlogService")
			return $http.get(BASE_URL+'getBlogById/'+blogID)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting blog..BlogService');
                        return $q.reject(errResponse);
                    });
		},
		getBlogOfUser : function(userID){
			console.log("Getting blogs of user..BlogService")
			return $http.get(BASE_URL+'getBlogOfUser/'+userID)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting blogs of user..BlogService');
                        return $q.reject(errResponse);
                    });
		},
		updateBlog : function(blog){
			console.log("Updating blog..BlogService")
			return $http.post(BASE_URL+'updateBlog/',blog)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while updating blog..BlogService');
                        return $q.reject(errResponse);
                    });
		}
	}
}])