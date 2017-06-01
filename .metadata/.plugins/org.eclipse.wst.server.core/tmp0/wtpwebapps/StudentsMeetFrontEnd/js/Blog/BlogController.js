'user strict';
app.controller('BlogController',['$scope','BlogService','$cookies','$location','$rootScope','$cookieStore','$http',
	function($scope, UserService,$cookies, $location, $rootScope,$cookieStore, $http) {
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
		}
	this.createBlog=function(){
		console.log("Creating Blog");
		this.user=$cookieStore.get('currentUser');
		this.blog.blogCreatorId=this.user.userID;
		BlogService.createBlog(this.blog)
		.then(
				function(d) {
					$location.path("/goBlogView")
					$rootScope.blog=d;
				},
				function(errResponse) {
					console.error('Error while creating blog');
				});
	};
}])