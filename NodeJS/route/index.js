var server = require('./server');
var route = require('./route');

server.start(route.route);

//in the console it's 
//server has started
//then you go to browser, the output on localhost:8000 is hello world
//then it gives output
//Request for: / received
//About to route a request for /
//Request for: /favicon.ico received
//About to route a request for /favicon.ico