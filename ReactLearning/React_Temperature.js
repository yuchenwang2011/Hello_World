//https://reactjs.org/docs/lifting-state-up.html
const scaleNames = {
  c: 'Celsius',
  f: 'Fahrenheit'
};

function BoilingVerdict(props) {
  if (props.celsius >= 100) {
    return <p>The water would boil.</p>;
  }
  return <p>The water would not boil.</p>;
}

function tryConvert(temperature, convert){
  const input = parseFloat(temperature);
  if(Number.isNaN(input)) {
    return "";
  }
  const output = convert(temperature);
  const rounded = Math.round(output * 1000) / 1000;
  return rounded.toString();
}

function toCelsius(fahrenheit) {
  return (fahrenheit - 32) * 5 / 9;
}

function toFahrenheit(celsius) {
  return (celsius * 9 / 5) + 32;
}

class TemperatureInput extends React.Component{
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
  }
  
  handleChange(e) {
    //this is very hard to understand
    //it calls the ancestor function, which calls another function, here you need provide it a value
    this.props.onTemperatureChange(e.target.value);
  }
  
  render(){
    return (
      <fieldset>
        <legend>Enter temperature here in {scaleNames[this.props.scale]}</legend>
        <input type="number" value={this.props.temperature} onChange={this.handleChange} />
      </fieldset>
    );
  }
}


class Calculator extends React.Component{
  constructor(props){
    super(props);
    this.state={
      scale: 'c',
      temperature: ""
    };
    this.handleCelsiusChange= this.handleCelsiusChange.bind(this);
    this.handleFahrenheitChange= this.handleFahrenheitChange.bind(this);
  }
  
  handleCelsiusChange(temperature){
    this.setState({
      scale: 'c',
      temperature: temperature
    });
  }
  handleFahrenheitChange(temperature){
    this.setState({
      scale: 'f',
      temperature: temperature
    });
  }
  
  render(){
    const scale = this.state.scale;
    const temperature = this.state.temperature;
    const celsius = scale === 'f' ? tryConvert(temperature, toCelsius) : temperature;
    const fahrenheit = scale === 'c' ? tryConvert(temperature, toFahrenheit) : temperature;
    
    return (
      <div>
        <TemperatureInput 
          scale='c'
          temperature={celsius}
          onTemperatureChange={this.handleCelsiusChange}
          />
        <TemperatureInput 
          scale='f'
          temperature={fahrenheit}
          onTemperatureChange={this.handleFahrenheitChange}
          />
        <BoilingVerdict celsius={celsius} />
      </div>
    );
  }
}

ReactDOM.render(
  <Calculator />,
  document.getElementById('root')
);