import React, { useState } from 'react'

const InputSample2 = () => {

    const [inputs, setInputs] = useState({
        name : '',
        nickname : ''
    });

    const {name, nickname} = inputs;

    const onChange = (e) => {
        const {value, name} = e.target;
        setInputs({
            ...inputs,
            [name]:value
        });
    };

    const onReset = () => {
        setInputs({
            name:'',
            nickname:''
        })
    };

  return (
    <div>
        <input placeholder='이름' />
        <input placeholder='닉네임' />
        <button onClick={onReset}>초기화</button>
        <div>
            <b>값 : </b>
            이름 (닉네임)
        </div>
    </div>
  )
}

export default InputSample2