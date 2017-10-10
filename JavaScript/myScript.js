function showDate() {
	document.getElementById("showDate").innerHTML = Date();
}

function hideElement() {
	//Property needs to be in quote because it's manipulating the CSS
	document.getElementById('hide').style.display = "none";
}


/*
 * JavaScript display date in different ways
 * 1. Writing into an HTML element, using innerHTML
 * 2. Writing into the HTML output using document.write()
 * 3. Writing into an alert box, using window.alert()
 * 4. Writing into the browser console, using console.log()
 */

//the value of a is undefined
var a;
//object use curly bracket, array use square bracket
var person = {first_name: "John", last_name: "doe"};
var arry = ["a","b","c"];
arry.push("d"); //like a stack
arry.pop();     //like a stack
arry.shift();   //like a queue, removes the first one
Array.isArray(arry);

var x = new Number(500);             
var y = new Number(500);
// (x == y) is false because objects cannot be compared

var points = [40, 100, 1, 5, 25, 10];
points.sort(function(a, b){return a - b});

//https://www.w3schools.com/js/js_type_conversion.asp 
//very useful knowledge about JS types
//very difficult
//A closure is a function having access to the parent scope, even after the parent function has closed.