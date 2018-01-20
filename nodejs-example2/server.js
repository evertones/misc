/* NodeJS or NPM libs */
var express        = require('express'),
    path           = require('path'),
    bodyParser     = require('body-parser'),
    app            = express();

/* Set EJS template engine to be used with Express using the folder 'views' to store the pages */
app.set('view options', { layout: false });
app.set('views', './views');
app.set('view engine', 'ejs');

/* Init static folder for libs included using Bower */
app.use('/components', express.static(path.join(__dirname, 'bower_components')));

/* Init bodyParser settings to access request.body */
app.use(bodyParser.urlencoded({ extended: true })); //support x-www-form-urlencoded
app.use(bodyParser.json());
	
/* Routes (set on a /routes/routes.js file) */
routes = require('./routes/routes')(app);

/* Init http service */
var serverPort = 3000;
var serverIpAaddress = '127.0.0.1';

var server = app.listen(serverPort, serverIpAaddress, function() {
    console.log("HTTP Server started on port %s", server.address().port);
});
