//this is an example on official website
//https://codepen.io/gaearon/pen/PGEjdG?editors=0010
//Type this a few times because the syntax is not familiar
const user = {
	firstName: 'john',
	lastName: 'doe'
};

const element = (
	<h1>
		hello {formatName(user)}!
	</h1>
);

function formatName(user){
	return user.firstName + " " + user.lastName;
}

ReactDOM.render(
	element,
	document.getElementById('root')
);
