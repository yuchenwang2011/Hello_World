const http = require('http');
const url = require('url');

function start(route){
	function onRequest(req, res){
		var pathName = url.parse(req.url).pathname;
		console.log("Request for: " + pathName + " received");
		//route(pathName);

		res.writeHead("200",{"Content-Type":"text/plain"});
		res.write("hello world\n");
		res.end();
	}
	http.createServer(onRequest).listen(8000);
	console.log("server has started");
}

exports.start=start;