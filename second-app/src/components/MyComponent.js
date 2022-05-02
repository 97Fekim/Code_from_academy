import React from 'react'
import propTypes from "prop-types";


const MyComponent = ({children, name, favoriteNumber}) => {    // properties => props (속성들)

  return (
    <div>
      <div>안녕하세요 제 이름은{name}</div>
      <div>children 값은 {children}</div>
      <div>최애값은 {favoriteNumber}</div>
    </div>
  )
}

MyComponent.defaultProps = {
  name : "기본이름",
}

MyComponent.propTypes = {
  // name의 타입이 문자열이 아니면 오류 발생
  // 리액트 => props(읽기 전용, 단방향), state
  name : propTypes.string,
  favoriteNumber: propTypes.number.isRequired,
}

export default MyComponent