'user strict';
app.controller('BlogController',['$scope','BlogService','$location','$rootScope','$cookieStore','$http',
	function($scope, BlogService, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside blogController")
	this.comment={
			blogID : '',
			commentUserId : '',
			commentDate : '',
			commentText : '',
			reportComment : ''
	}
	this.blog={
		blogID : '',
		blogName : '',
		blogCreatorId : '',
		blogData : '',
		blogDescription : '',
		lastUpdateDate : '',
		blogComments : []
	}
	this.blogs=[];
	this.getBlog= function(){
		console.log("Getting blog");
		BlogService.getBlogbyId($scope.blogEditId)
		.then(
				function(d) {
					$rootScope.currentblog=d;
					$location.path("/goViewBlog")
				},
				function(errResponse) {
					console.error('Error while getting blog');
				});
	};
	this.createBlog =function(blog){
		console.log("Creating Blog");
		BlogService.createBlog(blog)
		.then(
				function(d) {
			$location.path("/")
		},
		function(errResponse) {
			console.error('Error while creating user');
		});
	};
	this.submitBlog=  function(){
		console.log("Submitting new Blog");
		this.createBlog(this.blog);
	};
	this.selectEditBlog =function(){
		console.log("Getting blog");
		BlogService.getBlogbyId($scope.blogUpdaeId)
		.then(
				function(d) {
					$rootScope.currentblog=d;
					$location.path("/goBlogEdit")
				},
				function(errResponse) {
					console.error('Error while getting blog');
				});
	};
	this.editBlog = function(blog){
		console.log("Updating blog");
		BlogService.updateBlog(this.blog)
		.then(
				function(d) {
					$rootScope.currentblog=d;
					$location.path("/goViewBlog")
				},
				function(errResponse) {
					console.error('Error while updating blog');
				});
	};
	this.deleteBlog =function(){
		console.log("Deleting blog");
		BlogService.deleteBlogbyId($scope.blogDeleteId)
		.then(
				function() {
					$location.path("/")
				},
				function(errResponse) {
					console.error('Error while deleting blog');
				});
	}
}])