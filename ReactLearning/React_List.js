//https://reactjs.org/docs/lists-and-keys.html
function NumberList(props){
  const numbers = props.numbers;
  //you need to include key when creating lists of elements (use key when there's map)
  const listItems = numbers.map( number => 
    <li key = {number.toString()}>
      {number}
    </li>
  );
  return (
    <ul>{listItems}</ul>
  );
}

const numbers = [1,2,3,4,5];
ReactDOM.render(
  <NumberList numbers={numbers} />,
  document.getElementById('root')
);