import React, { useState } from 'react'

const Color = ({no}) => {
    const [color, setColor] = useState('#');
    const [input, setInput] = useState("");
    const [final, setFinal] = useState("112233");
    const f = (e) => {
        console.log(e.target.value);
        setInput(e.target.value);    
    }
    const g = (e) => {
        setColor(color + input);
        if(color.length >= 7){  // 6글자가 결합되면
            setFinal(color);    // 현재의 color를 final에 저장하고 그것을 button에 적용
            setColor('#');
        }
    }
    console.log(color, final);
  return (
    <div>
        <label htmlFor="">{no}번</label>
        <input type="text" onKeyPress={f}/>
        <button style={{backgroundColor: final}} onClick={g}>
            {no}번{" "}
        </button>
    </div>
  )
}

export default Color