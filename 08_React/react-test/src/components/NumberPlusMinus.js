import React, { useState } from 'react';

const NumberPlusMinus = () => {

    const [number, setNumber] = useState('0');


    return(
        <>
            <div className='box'>
                <button className='minus' onClick={()=>{setNumber(Number(number)-1)}}>-</button>
                <div>{number}</div>
                <button className='plus' onClick={()=>{setNumber(Number(number)+1)}}>+</button>
            </div>
        </>

    );
};

export default NumberPlusMinus;
