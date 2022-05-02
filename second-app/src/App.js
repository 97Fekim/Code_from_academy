import React, {Component} from "react";
import './App.css';
import Increment from "./components/Increment";
import Decrement from "./components/Decrement";
import MyComponent from "./components/MyComponent";


class App extends Component{  // 클래스 기반의 콤포넌트, 현재는 함수형 기반의 콤포넌트로 하라고 권고함

  render() {
    return(
    <>
       <Increment></Increment>
       <Decrement></Decrement>
    </>
    )
  }
  
};

export default App;
