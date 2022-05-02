import React, { Component } from 'react'

export default class Increment extends Component {

    constructor(props){
        super(props);
        // state의 초기값 설정하기
        this.state = {
            number : 0
        }
    }

  render() {
      const {number} = this.state;
    return (
        
        <div>
          <h1>{number}</h1>
          <button onClick={()=>{this.setState({number:number+1})}}>
              Counter
          </button>
        </div>
    )
  }
}
