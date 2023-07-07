import React from 'react';
// node-modules에서 react라는 걸 갖다 쓰겠다는 의미

// props : *부모 컴포넌트가 *자식 컴포넌트에게
// 데이터 전달 시 사용하는 객체
// *** props는 자식 -> 부모 데이터 전달은 불가능 ***

// 2. 순서대로 해석할 때 있으면 기억해뒀던 함수 위치 소환해서 함수 호출
test()

// 3. 순서상 그 담에..

const ChildComponent = (props) => {
    return(
        <>
            <ul>
                <li>이름 : {props.name}</li>
                <li>나이 : {props.age}</li>
            </ul>
        </>
    )
}

const MenuPrint = (props) => {
    return (
        <h4>김밥 : {props.김밥}, 떡볶이 : {props.떡볶이}</h4>
    );
}

const PropsEx = (props) => {
    // props 매개변수 : 부모로부터 전달 받은 값이 담겨있는 객체
    
    console.log(props);
    console.log(props.name);

    const menu = {'김밥':3000, '떡볶이':4000};

    return (
        <>
            <h1>{props.name}</h1>
            <ChildComponent name={props.name} age={props.name === '홍길동' ? 20 : 25}/>
            <MenuPrint {...menu}/>
        </>
        );
        
    }
    
    // 1. 컴파일링 할 때 function()을 가장 먼저 해석하고 위치 기억해둠    
    function test(){
        console.log("먼저 호출 되나?");
    }

export default PropsEx;
// 어디선가 PropsEx를 import 하면 PropsEx의 return 구문이 나가게 됨
// PropsEx를 호출한다고 써놔서 App.js에서 ChildComponent 바로 소환은 안되고
// PropsEx에서 ChildComponent를 호출해야됨
// = Props Drilling