// 리액트 js는 자바의 클래스 개념 -> 이름 맨 앞 대문자!

import React, { Component } from 'react';
// node-modules 폴더에 있는 react 패키지를 가져옴

// 클래스형 컴포넌트 만들기
// 1. Component 상속 받기
// 2. render() 함수 작성하기(필수)
// 3. 만든 class를 export default로 지정하기
class Exam1 extends Component {
    constructor(props){
        super(props);
        this.state = {count : 0};
    }

    // function handleClick(){}과 같음
    handleClick = () => {
        this.setState({count:this.state.count+1});
    }

    // 화면 렌더링 시 
    // render() 함수에서 반환된 값 출력
    render() {
        return(
            <>
                <h2>클래스형 컴포넌트</h2>
                <h1>Count : {this.state.count}</h1>
                <button onClick={this.handleClick}>Increment</button>
            </>
        );
    }
}
// 이 클래스를 내보냄
export default Exam1;