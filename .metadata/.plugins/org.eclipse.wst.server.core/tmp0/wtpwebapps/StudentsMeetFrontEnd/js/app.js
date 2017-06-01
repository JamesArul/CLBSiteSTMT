var app = angular.module("myApp",['ngRoute','ngCookies']);
app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'Common/CommonHome.html'	
	})
	.when('/goRegister', {
		templateUrl : 'User/Register.html',
		controller : 'UserController'
	})
	.when('/goLogin',{
		templateUrl: 'User/Login.html',
		controller : 'UserController'
	})
	.when('/goUserHome',{
		templateUrl:'User/UserHome.html',
		controller:'UserController'
	})
	.when('/goBlogHome',{
		templateUrl:'Blog/BlogHome.html',
		controller:'BlogController'
	})
	.when('/goBlogCreate',{
		templateUrl: 'Blog/BlogCreate.html',
		controller : 'BlogController'
	})
	.when('/goBlogView',{
		templateUrl: 'Blog/BlogView.html',
		controller : 'BlogController'
	})
	.when('/goBlogViewAll',{
		templateUrl : 'Blog/BlogViewAll.html',
		controller : 'BlogController'
	})
	.when('/goBlogsUser',{
		templateUrl:'Blog/BlogUpdate.html',
		controller : 'BlogController'
	})
	.when('/goBlogEdit',{
		templateUrl : 'Blog/BlogEdit.html',
		controller : 'BlogController'
	})
	.otherwise({
		redirectTo : '/'
	});
});
app.run( function ($rootScope, $location, $cookies, $cookieStore, $http,UserService) {
	
	$rootScope.$on('$locationChangeStart', function (event, next, current) {
		console.log("$locationChangeStart")		
		$rootScope.currentUser= $cookieStore.get('currentUser') || {};
		var userPage=['/goUserHome']
		var adminPage=[]
		var currentPage=$location.path()
		var isUserPage = $.inArray(currentPage, userPage)
		var isAdminPage = $.inArray(currentPage, adminPage)
		var isLoggedIn=$rootScope.currentUser.userID;
		console.log("isLoggedIn:" +isLoggedIn)
	    console.log("isUserPage:" +isUserPage)
	    console.log("isAdminPage:" +isAdminPage)
	    if(angular.isUndefined(isLoggedIn))
	        	{
	    			  $rootScope.notLogged=true;
	    			  $rootScope.isUser=false;
	    			  $rootScope.isAdmin=false;
	    			  if(isUserPage===0 || isAdminPage ===0)
	    				  {
		        	  console.log("Navigating to login page:")
		        	  alert("You need to loggin to do this operation")
		        	  $rootScope.notLogged=true;
					  $location.path('/goLogin');
	    				  }
	        	}
		if(isLoggedIn===""){
			$rootScope.notLogged=true;
			$rootScope.isUser=false;
			$rootScope.isAdmin=false;
			if(isUserPage===0 || isAdminPage ===0)
			  {
  	  console.log("Navigating to login page:")
  	  alert("You need to loggin to do this operation")
		  $location.path('/goLogin');
			  }
		}
	    else{
	    	var role=$rootScope.currentUser.userRole;
	    	if(role==='ROLE_USER'){
	    	$rootScope.isUser=true;
	    	$rootScope.notLogged=false;
	    	$rootScope.isAdmin=false;
	    	if(isAdminPage===0){
	    		alert("You do not access to this operatiob")
	    		$location.path('/goUserHome');
	    	}
	    	}
	    	if(role==='ROLE_ADMIN'){
	    		$rootScope.notLogged=true;
				$rootScope.isUser=false;
				$rootScope.isAdmin=false;
	    	}
	    }
	});
});