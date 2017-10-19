//React Inline If Condition
//https://reactjs.org/docs/conditional-rendering.html
function Mailbox(props){
  const unreadMessages = props.unreadMessages;
  return (
    <div>
       <h1>Hello</h1>
       {
         unreadMessages.length > 0 && 
           <h2>
             you have {unreadMessages.length} messages to read
           </h2>
       }
    </div>
  );
}

const messages = ['React','Re: React','Re:Re: React'];
ReactDOM.render(
  <Mailbox unreadMessages={messages}/>,
  document.getElementById('root')
);