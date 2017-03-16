var app = angular.module('kB',['ngRoute'])

.config(['$routeProvider', '$locationProvider', function($routeProvider,$locationProvider){
	  $locationProvider.hashPrefix('!');
	$routeProvider
		.when('/categories',{
			templateUrl : 'views/categories.view.html',
			controllers : 'CategoriesCtrl'
		})
		.when('/articles',{
			templateUrl : 'views/articles.view.html',
			controllers : 'ArticlesCtrl'
		})
		.when('/articles/details/:id',{
			templateUrl : 'views/article_details.view.html',
			controllers : 'ArticleDetailsCtrl'
		})
		.when('/articles/category/:category',{
			templateUrl : 'views/cat_articles.view.html',
			controllers : 'ArticlesCategoryCtrl'
		})
		.when('/articles/add',{
			templateUrl : 'views/add_article.view.html',
			controllers : 'ArticlesCreateCtrl'
		})
		.when('/articles/edit/:id',{
			templateUrl : 'views/edit_article.view.html',
			controllers : 'ArticlesEditCtrl'
		})
		.otherwise({redirectTo : '/categories'})
		
}])