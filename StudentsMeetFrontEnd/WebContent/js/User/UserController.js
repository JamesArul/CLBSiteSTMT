'user strict';
app.controller('UserController',['$scope','UserService','$location','$rootScope','$cookieStore','$http',
	function($scope, UserService, $location, $rootScope,$cookieStore, $http) {
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
	this.currentUser ={
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
		$scope.myForm.$setPristine(); 
	};
	this.submit = function() {
		{
			console.log('Saving New User');
			this.createUser(this.user);
		}
		this.reset();
	};
}])