var express = require('express');
var router = express.Router();


var Category = require('../model/categorie');

/* GET categories */
router.get('/', function(req, res, next) {
  Category.getCategories(function(err, categories){
  	if(err){
  		console.log(err);
  	}
  	res.json(categories);
  })
});

router.get('/:id', function(req, res, next) {
  Category.getCategoryById(req.params.id, function(err, category){
  	if(err){
  		console.log(err);
  	}
  	res.json(category);
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


module.exports = router;
