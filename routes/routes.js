module.exports = function(app) {

    /* ---------------------------------------------
       Index Routes 
       ---------------------------------------------*/
    app.get('/ugly', function(req, res) {
        console.log('-------------------------------------------');
        console.log('>>> GET - Page accessed: ' + req.url);
        console.log('-------------------------------------------');

        var html = '<h1>Page accessed via GET</h1>';
        html += '<h2>This page is ugly because we are not working with a templating engine (e.g. Jade, Mustache, EJS etc). </h2>';
        html += '<br /><br /><br />';
        html += '<p>Take a look on NodeJS console to see the log.</p>';
        html += '<br /><br /><br />';
        html += "<a href='index.html'>Return</a>";

        res.send(html);
    });

    app.post('/form', function(req, res) {
        console.log('-------------------------------------------');
        console.log('>>> POST - Submitted page: ' + req.url + '<<<');
        console.log('');
        console.log('First Name: ' + req.body.field1);
        console.log('Last Name: ' + req.body.field2);
        console.log('Sex: ' + req.body.field3);
        console.log('-------------------------------------------');

        var html = '<h1>Form submitted successfuly!</h1>';
        html += '<h2>Name: ' + req.body.field1 + ' '+ req.body.field2 + '</h2>';
        html += '<h2>Sex: ' + req.body.field3 + '</h2>';
        html += '<br /><br /><br />';
        html += '<p>Take a look on NodeJS console to see the log.</p>';
        html += '<br /><br /><br />';
        html += "<a href='index.html'>Return</a>";

        res.send(html);
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