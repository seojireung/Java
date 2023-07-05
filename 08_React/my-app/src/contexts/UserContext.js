import React, {createContext} from "react";

// 외부에 만든 전역변수(컴포넌트 개념x)
// createContext(초기값) : Context 생성 (여러개 생성 가능)
const UserContext = createContext();

export default UserContext;