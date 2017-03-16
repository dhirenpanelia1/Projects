var express = require('express');
var router = express.Router();

var Article = require('../model/article');

/* GET article */
router.get('/', function(req, res, next) {
  Article.getArticles(function(err, articles){
  	if(err){
  		console.log(err);
  	}
  	res.json(articles);
  })
});

router.get('/:id', function(req, res, next) {
  Article.getArticlesById(req.params.id, function(err, article){
  	if(err){
  		console.log(err);
  	}
  	res.json(article);
  })
});

router.get('/category/:category', function(req, res, next) {
  Article.getArticleByCategory(req.params.category, function(err, article){
  	if(err){
  		console.log(err);
  	}
  	res.json(article);
  })
});

router.post('/',function(req, res, next){
	//get form values
	var title = req.body.title;
	var body = req.body.body;
	var category = req.body.category;

	var newArticle = new Article({
		title : title,
		category : category,
		body : body
	});

	//create article
	Article.createArticle(newArticle, function(err, article){
		if(err){
			console.log(err);
		}

		res.location('/articles');
		res.redirect('/articles');
	});
});

//update article
router.put('/',function(req, res, next){
	//get id
	var id = req.params.id;
	
	var data = {
		title : req.body.title,
		category : req.body.category,
		body : req.body.body
	}

		//update article
	Article.updateArticle(id, data, function(err, article){
		if(err){
			console.log(err);
		}

		res.location('/articles');
		res.redirect('/articles');
	});
});


//remove article

router.delete('/:id',function(req, res, next){
	//get id
	var id = req.params.id;

		//remove article
	Article.removeArticle(id, function(err, article){
		if(err){
			console.log(err);
		}

		res.location('/articles');
		res.redirect('/articles');
	});
});


module.exports = router;
