'user strict';
app.controller('BlogController',['$scope','BlogService','$cookies','$location','$rootScope','$cookieStore','$http',
	function($scope, BlogService,$cookies, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside BlogController")
	this.blog={
		blogID :'',
		blogName : '',
		blogCreatorId : '',
		blogData :'',
		blogDescription : '',
		lastUpdateDate : '',
		comments : []
	};
	this.editblog={
			blogID :'',
			blogName : '',
			blogCreatorId : '',
			blogData :'',
			blogDescription : '',
			lastUpdateDate : '',
			comments : []
		};
	this.blogID='';
	this.user={
			errorCode : '',
			errorMsg : '',
			userID : '',
			userName : '',
			userPassword : '',
			userQualification : {
				tenthPercentage : '',
				twelfthPercentage : '',
				bachelorCGPAPercentage : ''
			},
			isOnline : '' ,
			lastSeenOnline : '',
			userRole : '',
			userFriends : [],
			userImage : ''
		};
	this.blogs=[];
	this.createBlog=function(){
		console.log("Creating Blog");
		this.user=$cookieStore.get('currentUser');
		this.blog.blogCreatorId=this.user.userID;
		BlogService.createBlog(this.blog)
		.then(
				function(d) {
					this.getAllBlog();
					$rootScope.blog=d;
					$location.path("/goBlogViewAll")					
				},
				function(errResponse) {
					console.error('Error while creating blog');
				});
	};
	this.getAllBlog=function(){
		console.log("Getting all blogs");
		BlogService.getAllBlog()
		.then(
				function(d){
					this.blogs=d;
				},
				function(errResponse){
					console.error('Error while getting all blogs');
				});
	};
	this.viewBlog=function(){
		console.log("Getting this blog");
		BlogService.getBlogByID(this.blogID)
		.then(
				function(d){
					this.blog=d;
					$location.path("/goBlogView")
				},
				function(errResponse){
					console.error('Error while getting blog');
				});
	};
	this.getMyBlogs=function(){
		console.log("getting blogs of user");
		this.user=$cookieStore.get('currentUser');
		BlogService.getBlogOfUser(this.user.userID)
		.then(
				function(d){
					this.blogs=d;
					$location.path=("/goBlogsUser")
				},
				function(errResponse){
					console.error('Error while getting blogs of User');
				});
	}
	this.editBlog=function(){
		console.log("Getting this blog");
		this.editblog={
				blogID :'',
				blogName : '',
				blogCreatorId : '',
				blogData :'',
				blogDescription : '',
				lastUpdateDate : '',
				comments : []
			};
		BlogService.getBlogByID(this.blogID)
		.then(
				function(d){
					this.editblog=d;
					$location.path("/goBlogEdit")
				},
				function(errResponse){
					console.error('Error while getting blog');
				});
	};
	this.updateBlog=function(){
		console.log("Updating blog");
		BlogService.updateBlog(this.editblog)
		.then(
				function(d){
					this.editblog=d;
					$location.path("/goBlogEdit")
				},
				function(errResponse){
					console.error('Error while updating blog');
				});
	}
}])