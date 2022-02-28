import React, { useState } from 'react'

const IteratorSample = () => {
    // 문제1) 배열에 문자열을 저장하고
    // map을 이용하여 아래 코드를 간결화
    const [names, setNames] = useState([
        {id:1, text:"눈사람"},
        {id:2, text:"얼음"},
        {id:3, text:"눈"},
        {id:4, text:"바람"},
    ]);
    const [inputText, setInputText] = useState("");
    const [nextId, setNextId] = useState(5);
    const nameList = names.map((i,j) => <li key={i.id}>{i.text}</li>);
    
  return (
    <div>
        <input value={inputText} onChange={onchange} />
        <button onClick={onClick}>추가</button>
        <ul>{nameList}</ul>
    </div>
  )
}

export default IteratorSample