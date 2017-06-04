'use strict';

app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("BlogService...")
	var BASE_URL='http://localhost:8081/FindUrFriendControllerRest/'
		return {
		getBlogbyId : function(blogId) {
			console.log("Getting blog by id")
			return $http.post(BASE_URL+'getBlogById/'+blogId)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting blog');
                        return $q.reject(errResponse);
                    });
		},
		createBlog : function(blog) {
			console.log("Creatin blog")
			return $http.post(BASE_URL+'createBlog/',blog)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting blog');
                        return $q.reject(errResponse);
                    });
		},
		updateBlog : function(blog){
			console.log("Updating blog")
			return $http.post(BASE_URL+'updateBlog/',blog)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting blog');
                        return $q.reject(errResponse);
                    });
		},
		addComment : function(comment) {
			console.log("Adding comment")
			return $http.get(BASE_URL+'addComment/',comment.commentUserId,'/',comment.blogID,'/',comment.commentText)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting blog');
                        return $q.reject(errResponse);
                    });
		},
		deleteBlogbyId : function(blogId) {
			console.log("Deleting blog")
			return $http.get(BASE_URL+'removeBlog/',blogId)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while Deleting blog');
                        return $q.reject(errResponse);
                    });
		}
	}
}])