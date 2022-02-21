import React from 'react'

// 하나의 component
const Green = (props) => {
  let {a} = props;
  console.log(props);
    return (
    <div>그린컴퓨터</div>
  )         
}

export default Green