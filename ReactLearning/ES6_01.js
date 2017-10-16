//a online console to run JS code https://repl.it/M2qi/1
//This is a very easy to understand blog 
//https://github.com/metagrover/ES6-for-humans
//The translate version:
//http://www.barretlee.com/blog/2016/07/09/a-kickstarter-guide-to-writing-es6/
//A very helpful video
//https://www.youtube.com/watch?v=IEf1KAcK6A8
var check = true;
if(check){
	let x = 10;
	document.write("x = " + x);
}
document.write("x = " + x);


var materials = [
  'Hydrogen',
  'Helium',
  'Lithium',
  'Beryllium'
];

materials.map(function(material) { 
  return material.length; 
}); // [8, 6, 7, 9]

materials.map((material) => {
  return material.length;
}); // [8, 6, 7, 9]

materials.map(material => material.length); // [8, 6, 7, 9]
document.write(`${materials[0]} ${materials[1]}`);

//you should have no space in between =>
var price = function(){
	return 10;
}
var price => () => 10;

var fn = a => a + 5;
fn(10);
setTimeout( ()=>console.log('hello'),1000);

var arr = ["apple","banana","egg"];
var breakfirst = arr.map(fruit=>{
	return fruit + 's';
});
var breakfirst = arr.map(fruit => fruit + "ss");

let getFinalPrice = (price, tax=0.7) => price + price * tax;
getFinalPrice(500); // 850

function foo(...args) {
  console.log(args);
}
foo( 1, 2, 3, 4, 5); // [1, 2, 3, 4, 5]


//Destructuing array
function foo() {
  return [1,2,3];
}
let arr = foo(); // [1,2,3]
let [a, b, c] = foo();
console.log(a, b, c); // 1 2 3
function bar() {
  return {
    x: 4,
    y: 5,
    z: 6
  };
}
let {x: x, y: y, z: z} = bar();
console.log(x, y, z); // 4 5 6

let numbers = [1,2,3];
let [a,...b]=numbers;
console.log(b);

let a = 5;
let b = 6;
[b,a] = [a,b];
console.log(b);

var parent = {
  foo() {
    console.log("Hello from the Parent");
  }
}
var child = {
  foo() {
    super.foo();
    console.log("Hello from the Child");
  }
}
Object.setPrototypeOf(child, parent);
child.foo(); // Hello from the Parent
             // Hello from the Child
             
let user = 'Barret';
console.log(`Hi ${user}!`); // Hi Barret!


let nicknames = ['di', 'boo', 'punkeye'];
nicknames.size = 3;
for (let nickname of nicknames) {
  console.log(nickname);
}
Result: di, boo, punkeye


let nicknames = ['di', 'boo', 'punkeye'];
nicknames.size = 3;
for (let nickname in nicknames) {
  console.log(nickname);
}
//Result: 0, 1, 2, size

mySet.forEach((item) => {
  console.log(item);
    // 1
    // 2
    // 3
    // 'strings'
    // Object { a: 1, b: 2 }
});
for (let value of mySet) {
  console.log(value);
    // 1
    // 2
    // 3
    // 'strings'
    // Object { a: 1, b: 2 }
}

var arr = [11,12,13];
var itr = arr[Symbol.iterator]();
itr.next(); // { value: 11, done: false }
itr.next(); // { value: 12, done: false }
itr.next(); // { value: 13, done: false }
itr.next(); // { value: undefined, done: true }

//using arrow function, "this" is kept where it was defined.
