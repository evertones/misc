module.exports = function(app) {

    app.get('/', function(req, res) {
        res.render('pages/index');
    });

    app.get('/index', function(req, res) {
        res.render('pages/index');
    });

    app.get('/simple', function(req, res) {
        res.render('pages/simple');
    });

    app.get('/form', function(req, res) {
        res.render('pages/form');
    });

    app.post('/form', function(req, res) {
        res.render('pages/formResponse', { 'firstName':req.body.field1, 'lastName':req.body.field2, 'sex':req.body.field3 });
    });
    
    /* ---------------------------------------------
       Error handling
       ---------------------------------------------*/
    app.use(function(req, res, next) {
        console.log("Error 404 - Page not found: " + req.url);
        res.status(404).send("Error 404 - Page not found.");
    });

    app.use(function(req, res, next) {
        console.log("Erro 500 - Unexpected error on " + req.url);
        res.status(500).render("Error 500 - Unexpected error.");
    });
};