import React, { useState } from 'react';

const Print = (props) => {

    return(
        <div className='print-area'>
                <h2 className='print-text-area'>{props.print}</h2>
        </div>
    );
};

const InputPrint = () => {

    const [input, setInput] = useState('');

    const [print, setPrint] = useState("위 텍스트 필드에 값을 입력하신 후 버튼을 누르시면 이곳에 출력됩니다.");

    const printInput = () =>{
        setPrint(input);
    };

    return(

        <>
            <input type='text' onChange={e=>{setInput(e.target.value)}}/>
            <button onClick={printInput}>보내기</button>
            
            <Print print={print}/>
            
        </>
    );
};

export default InputPrint;
