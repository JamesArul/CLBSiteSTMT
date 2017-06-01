'user strict';
app.controller('UserController',['$scope','UserService','$cookies','$location','$rootScope','$cookieStore','$http',
	function($scope, UserService,$cookies, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside UserController")
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
	$rootScope.currentUser ={
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
	this.users = [];
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	this.createUser = function(user) {
		console.log("Creating user");
		UserService.createUser(user)
		.then(
				function(d) {
					$location.path("/")
					this.user=d;
				},
				function(errResponse) {
					console.error('Error while creating user');
				});
	};
	this.reset = function() {
		this.user = {
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
				userFriends : []
		};
		$scope.regForm.$setPristine(); 
	};
	this.submit = function() {
		{
			console.log('Saving New User');
			this.createUser(this.user);
		}
		this.reset();
	};
	this.login =function(){
		console.log('Performing Login operations');
		UserService.login(this.user)
		.then(
				function(d){
					$cookieStore.put('currentUser',d);
					$rootScope.currentUser=d;
					$location.path("/goUserHome")
				},
				function(errResponse) {
					console.error('Error while login');
				});
	};
	this.logout=function(){
		console.log('Logout User');
		user=$cookieStore.get('currentUser');
		UserService.logout(user)
		.then(
				function(){
					$cookieStore.remove('currentUser');
					$location.path("/")
				},
				function(errResponse) {
					console.error('Error while logout');
				});
	};
}])