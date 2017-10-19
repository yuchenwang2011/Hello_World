////https://reactjs.org/docs/lists-and-keys.html
function Blog(props){
  const posts = props.posts;
  const sidebar = (
    <ul>
      {
        posts.map(post => 
          <li key={post.id}>{post.title}</li>         
        )
      }
    </ul>
  );
  const content = posts.map(post => 
    <div key = {post.id}>
        <h3>{post.title}</h3> <p>{post.content}</p>
    </div>                         
  );
  
  return (
    <div>
      {sidebar}
      <hr />
      {content}
    </div>
  );
}

const posts = [
  {id: 1, title: 'hello world', content: 'welcome to react'},
  {id: 2, title: 'installation', content: 'install from npm'}
];
ReactDOM.render(
  <Blog posts={posts} />,
  document.getElementById('root')
);