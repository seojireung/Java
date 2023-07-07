import React,{useState} from "react";

// 순서 4
const Id = ({handler}) => {

    // react 기능 중 하나. 이해 말고 받아들이기
    // props로 전달한 값 중 key가 handler인 요소의 value

    // console.log(handler);
    // console.log(props.handler);
    return(
        <>
            {/* className -> 요소.add.classList 실행 */}
            <div className="wrapper">
                    {/* html의 for 속성 */}
                <label htmlFor="id">ID : </label>
                                            {/* 순서 4 */}
                <input type="text" id="id" onChange={handler}/>
            </div>
        </>
    );
};
const Pw = ({handler}) => {
    return(
        <>
            {/* className -> 요소.add.classList 실행 */}
            <div className="wrapper">
                    {/* html의 for 속성 */}
                <label htmlFor="pw">PW : </label>
                <input type="password" id="pw" onChange={handler}/>
            </div>
        </>
    );
};

// 상태 끌어올리기
const StateLiftingUp = () => {

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    // 순서 1 (자식이 변하는걸 감지할 수 있는 함수)
    const idHandler = (e) => { // id값 변경 함수
        setId(e.target.value);
    }
    const pwHandler = (e) => { // pw값 변경 함수
        setPw(e.target.value);
    }

    // 순서 5-1 (확인)
    console.log("id : " + id);
    console.log("pw : " + pw);

    return(
        <>
            {/* 순서 2 : 리렌더링 할 수 있는 값을 자식 한테 보냄 -> 자식이 바꼈을 때 리렌더링 하면서 바뀐 값 인식 */}
            <Id handler={idHandler}/>
            <Pw handler={pwHandler}/>

            <div className="wrapper">
                {/* 순서 5-2 : 활용 */}
                <button disabled={id.length === 0 || pw.length === 0 }>Login</button>
            </div>
        </>
    );
}

export default StateLiftingUp;