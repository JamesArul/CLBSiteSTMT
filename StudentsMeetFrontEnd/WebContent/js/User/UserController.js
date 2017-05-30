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
		userFriends : []
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
			userFriends : []
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
	
	this.login = function()
	{
		console.log("Login user");
		UserService.loginUser(this.user)
		.then(
				function(d) {
					this.user=d;
					if(this.user.errorCode=="404")
						{
						alert("Invalid Login")
						this.user.userID = "";
						}
					if(this.user.userRole=="ROLE_ADMIN")
					{
						console.log("Admin logged in")
						$cookieStore.put('currentUser',this.user);
						$http.defaults.headers.common['Authorization'] = 'Basic'+ $rootScope.currentUser;
						$location.path('/')						
					}
					if(this.user.userRole=="ROLE_USER")
						{
						console.log("User logged in")
					$cookieStore.put('currentUser',this.user);
					$http.defaults.headers.common['Authorization'] = 'Basic'+ $rootScope.currentUser;
					$location.path('/')
						}
				},
				function(errResponse) {
					console.error('Error while logging in user');
				});
	};
	this.logout = function()
	{
		user=$cookieStore.get('currentUser');
		console.log("Logout user");
		UserService.logoutUser(user)
		.then(
			function(){
				$cookieStore.remove('currentUser');
				$location.path("/")
			},
			function(errResponse) {
				console.error('Error while creating user');
			});
	};
	this.submit = function() {
		{
			console.log('Saving New User');
			this.createUser(this.user);
		}
		this.reset();
	};
}])