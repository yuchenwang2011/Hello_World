const http = require('http');
const server = http.createServer(function(req, res){
	res.writeHeader("200", {"Content-Type":"text/plain"});
	res.end("hello world\n");
});
server.listen(8000);
console.log("open localhost:8000 and run this file by: node hello.js");