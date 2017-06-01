'use strict';
app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("BlogService...")
	var BASE_URL='http://localhost:8081/StudentsMeetControllerRest/'
		return {
		createBlog : function(blog){
			console.log("Creating blog in BlogService")
			return $http.post(BASE_URL+'createBlog/',blog)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating blog');
                        return $q.reject(errResponse);
                    });
		}
	}
}])