import React from "react";
import Green from "./components/Green";

const App = () => {  
  // javascript 함수
  // 리액트는 콤포넌트의 결합, 콤포넌트는 무조건 대문자로 시작해야 리액트가 콤포넌트로 인식함
  let a = 7;
  console.log(a);
  let data = [
    {id:1, num:7},
    {id:2, num:71},
    {id:3, num:17},
    {id:4, num:73},
  ]

  return (
    // jsx 문법, 하나의 태그로 감싸야 한다
    <React.Fragment>
      <h1>리액트 안녕</h1>
      <h2>잘 작동한다</h2>
      {data.map((i,j) => {
          console.log("data : ",i,"idx",j);
          return <Green key={i.id}></Green>
        }
      )}
    </React.Fragment>
  );
};

export default App;
