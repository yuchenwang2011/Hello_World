//https://reactjs.org/docs/conditional-rendering.html
function UserGreeting(){
  return (
    <h1>
      welcome back
    </h1>
  );  
}
function GuestGreeting(){
  return (
    <h1>
      please sign up
    </h1>
  );
}
function Greeting(props){  
  const login = props.isLoggedIn;
  if(login){
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}
function LoginButton(props){
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}
function LogoutButton(props){
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}
class LoginControl extends React.Component{
  constructor(props){
    super(props);
    this.state={
      isLoggedIn: false
    };
    this.handleLoginClick=this.handleLoginClick.bind(this);
    this.handleLogoutClick=this.handleLogoutClick.bind(this);
  }
  
  handleLoginClick(){
    this.setState({isLoggedIn: true});
  }
  handleLogoutClick(){
    this.setState({isLoggedIn: false});
  }
  
  render(){
    const isLoggedIn = this.state.isLoggedIn;
    let button = null;
    if(isLoggedIn){
      button = <LogoutButton onClick={this.handleLogoutClick} />;
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />;
    }
    return (
      <div>
        <Greeting isLoggedIn={isLoggedIn} />
        {button}
      </div>
    );
  }
}

ReactDOM.render(
  <LoginControl />,
  document.getElementById('root')
);