import React, { useState } from 'react'

const Say = () => {
   
    return (
        <div>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
        </div>
        );
};

export default Say