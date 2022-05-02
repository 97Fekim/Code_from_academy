import React from "react";
import Green from "./components/Green";

const App = () => {  

  var a = "hello";
  var b = "이재오";

  return (
    <>
      <h1>리액트 안녕</h1>
      <h2>잘 작동한다</h2>
      {
        // a==="hello" ? console.log(a+b) : console.log("홍길동")
        
        /* short circuit(단축연산) */
        // a === 'hello' && <h1>리액트입니다.</h1>
        // a === '' || <h1>앵귤러입니다.</h1>
      }
    </>
  );
};

export default App;
