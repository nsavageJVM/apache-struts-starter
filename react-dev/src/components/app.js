import React, { Component } from 'react';
import DayPickerInput from 'react-day-picker/DayPickerInput';
import 'react-day-picker/lib/style.css';
import axios from 'axios';
 

export default class App extends Component {




  constructor(props) {
    super(props);
    this.state = {
	  note: '', 
    currentDate: new Date(),
    calEntryDate: new Date(),
    };  
    
    this.headers = { 'dataType': 'json', 
                     'Content-Type': 'application/json' };
 
  }


  componentDidMount() {
    this.timerID = setInterval(
      () => this.tick(),
      1000
    );
  }

  tick() {
    this.setState({
      currentDate: new Date()
    });
  }


  componentWillUnmount() {
    clearInterval(this.timerID);
  }


  handleSubmit = event => {
    event.preventDefault();

    const localCalDto = {
      note: this.state.note,
      calEntryDate : this.state.calEntryDate 
    };

    console.log(localCalDto.note);
    console.log(localCalDto.localDate);

    axios.post(`/ajax/createCalanderAction`, localCalDto ,  this.headers)
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
  }

  handleChange = event => {
    this.setState({ note: event.target.value });
  }
 
  onCalChange = day => this.setState({ calEntryDate: day   })


  render() {
    const styles = {
      color: "red",
      fontSize: "18px"
  };

    return (
      <div className="container">
            <div className="row">
                <h3 className="indigo-text"> Calander Submission </h3>
                <h5>Local time is {this.state.currentDate.toLocaleTimeString()}.</h5>  
            </div>
            <div className="row">
                    <form onSubmit={this.handleSubmit}  >
                      <div className="container col s10 z-depth-1 grey lighten-4">
                        <div className="row">
                              <span  className="col s2 "  style={styles} > Note:</span>
                              <input type="text" name="note" onChange={this.handleChange} 
                              className=" col s8 input-field validate"  style={styles}/>
                        </div>
                        <div className="row">
                            <label className="col s2"  style={styles} > Day:</label>
                            <DayPickerInput  onDayChange={day =>  this.onCalChange} 
                                    className=" col s8 input-field validate green"  style={styles}/>
                        </div>
                     </div>
                     <div className="row"></div>
                     <div className="container col s10  ">
                            <div className="row">
                                 <div className="col s2 offset-s1">
                                      <button  className="btn waves-effect waves-light indigo" type="submit">Add
                                      <i className="material-icons right">send</i></button>
                                  </div>
                            </div>
                    </div>
                  </form>
          </div>
        </div>
    );
  }
}
