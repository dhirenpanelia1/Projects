angular.module('kB')
.controller('ArticlesCtrl', ['$scope', '$http', function($scope, $http){


$http.get('/articles').then(successCallback, errorCallback);

function successCallback(response){
    //success code
    //console.log(response);
    $scope.articles = response.data;
}
function errorCallback(error){
    //error code
    console.log(error);
}

}])

.controller('ArticlesCategoryCtrl', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){


$http.get('/articles/category/' + $routeParams.category).then(successCallback, errorCallback);

function successCallback(response){
    //success code
    //console.log(response);
    $scope.cat_articles = response.data;
    $scope.category = $routeParams.category;
    //console.log($scope.category);
}
function errorCallback(error){
    //error code
    console.log(error);
}

}])

.controller('ArticleDetailsCtrl', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){

//console.log($routeParams.id);
$http.get('/articles/'+$routeParams.id).then(successCallback, errorCallback);

function successCallback(response){
    //success code
   // console.log($routeParams.id);
    $scope.article = response.data;
}
function errorCallback(error){
    //error code
    console.log(error);
}

}])

.controller('ArticleCreateCtrl', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams,$location){

$http.get('/categories').then(successCallback, errorCallback);

function successCallback(response){
    //success code
    //console.log(response);
    $scope.categories = response.data;
}
function errorCallback(error){
    //error code
    console.log(error);
}

  $scope.addArticle = function(){
  		var data = {
  			title : $scope.title,
  			body : $scope.body,
  			category : $scope.category
  		}

  		$http.post('/articles', data).then(successCallback, errorCallback);

	function successCallback(data,status){
    //success code
    console.log(status);
  	 
	}
	function errorCallback(error){
    //error code
   		 console.log(error);
	}

	$location.path('/articles');
  }
}])

.controller('ArticleEditCtrl', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams,$location){
console.log('hello');
$http.get('/categories').then(successCallback, errorCallback);

function successCallback(response){
    //success code
    console.log(response);
    $scope.categories = response.data;
}
function errorCallback(error){
    //error code
    console.log(error);
}


$http.get('/articles/'+$routeParams.id).then(successCallback, errorCallback);
console.log('hello');
function successCallback(response){
    //success code
   // console.log(response);
    $scope.article = response.data;
}
function errorCallback(error){
    //error code
    console.log(error);
}

  $scope.updateArticle = function(){
  		var data = {
  			id: 		$routeParams.id,
  			title : 	$scope.article.title,
  			body :  	$scope.article.body,
  			category :  $scope.article.category
  		}

  		$http.put('/articles', data).then(successCallback, errorCallback);
console.log('hello');
	function successCallback(data,status){
    //success code
    console.log(status);
  	 
	}
	function errorCallback(error){
    //error code
   		 console.log(error);
	}

	$location.path('/articles');
  }
}])
