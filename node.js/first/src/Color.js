import React, { useState } from 'react'

const Color = ({no}) => {
    const [color, setColor] = useState('#');
    const [input, setInput] = useState("");
    const f = (e) => {
        console.log(e.target.value);
        setInput(e.target.value);    
    }
    const g = (e) => {
        setColor(color + input);
        if(color.length>7)
            setColor('#');
    }
    console.log(color);
  return (
    <div>
        <label htmlFor="">{no}번</label>
        <input type="text" onKeyPress={f}/>
        <button style={{backgroundColor: "#f4ee11"}} onClick={g}>{no}번{" "}</button>
    </div>
  )
}

export default Color