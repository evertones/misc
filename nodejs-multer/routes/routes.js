var multer = require('multer');
var fs     = require('fs');

module.exports = function(app) {

  /* ---------------------------------------------
     Set up the file storage for Multer
     ---------------------------------------------*/
    var storageUserProfile = multer.diskStorage({
        destination: function (req, file, callback) {
            callback(null, 'files')
        },
        filename: function (req, file, callback) {
            var shortDate = Date.now().toString().substring(0, 11);
            var extension = file.mimetype;
            extension = extension.substring(extension.indexOf("/")+1, extension.length);

            var filename = "File_" + shortDate + "." + extension;
            console.log('Generated filename: ' + filename);
            callback(null, filename);
        }
    });
    var upload = multer({ storage : storageUserProfile }).single('upload_file');


    /* ---------------------------------------------
       Index Routes
       ---------------------------------------------*/
    app.post('/file', function(req, res) {
        var html = 'File not processed';
        upload(req, res, function(err) {
            if (err) {
                html = '<h1>Error to upload file: ' + err + '</h1>';
                res.send(html);
            } else {
                html  = '<h1>File successfully uploaded</h1>';
                html += '<h2>Filename: </h2>' + req.file.filename;
                res.send(html);
            }
        });
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
