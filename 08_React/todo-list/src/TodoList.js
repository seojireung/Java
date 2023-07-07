import React, { useState,useContext } from 'react';
import { TodoListContext } from './App';

const TodoList = () => {

    const {setTodoList, todoList, loginMember} = useContext(TodoListContext);
    const [inputTodo, setInputTodo] = useState('');

    let keyIndex = 0;

    // 할 일 추가
    const handleAddTodo = () => {
        if(inputTodo.trim().length===0){
            alert("할 일을 입력해주세요.");
            return;
        }
        fetch("/todo",{
            method : 'post',
            headers : {'Content-type':'application/json'},
            body : JSON.stringify({
                title : inputTodo,
                todoMemberNo : loginMember.todoMemberNo
            })
        })
        .then(resp=>resp.text())
        .then(todoNo=>{
            if(Number(todoNo)===0){ // 삽입 실패 시
                return;
            }

            // 기존 todoList + 새로 추가된 Todo를 이용해
            // 새 배열을 만들어
            // todoList에 대입

            // 새로 추가된 Todo 만들기
            const newTodo = {
                todoNo : todoNo,
                title : inputTodo,
                isDone : 'X',
                todoMemberNo : loginMember.todoMemberNo
            };

            // 기존 todoList + newTodo를 이용해 새 배열 만들기
            // ... : 전개연산자(가장 바깥쪽 배열 풀어줌)
            const newTodoList = [...todoList, newTodo];

            // todoList에 대입
            setTodoList(newTodoList);
            setInputTodo(''); // 입력했던 거 없어지게

        })
        .catch(e=>console.log(e));
    };

    // O,X 업데이트
    const handleToggleTodo = (todo,index) => {
        // console.log(todo);
        // console.log(index);

        fetch("/",{
            method : 'put',
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify({
                todoNo : todo.todoNo,
                isDone : todo.isDone === 'O' ? 'X' : 'O'
            })
        })
        .then(resp=>resp.text())
        .then(result=>{
            if(result === '0'){
                console.log("업데이트 실패");
                return;
            }

            // 수정 성공 시 todoList 값을 변경해서 리렌더링

            // todoList를 깊은 복사(똑같은 배열을 하나 더 만듦)
            const newTodoList = [...todoList];

            // index번째 요소의 O,X를 반대로 변경
            newTodoList[index].isDone = newTodoList[index].isDone === 'O' ? 'X' : 'O';

            // 바뀐 데이터으로 리렌더링
            setTodoList(newTodoList);
        })
        .catch(e=>console.log(e));
    };

    // 할 일 삭제
    const handleDeleteTodo = (todoNo,index) => {
        fetch("/todo",{
            method : 'delete',
            headers : {'Content-Type' : 'application/json'},
            body : todoNo
        })
        .then(resp => resp.text())
        .then(result=>{
            if(result==='0'){
                console.log("삭제 실패");
                return;
            }

            const newTodoList = [...todoList]; // 배열 깊은 복사

            // 배열.splice(인덱스, 몇칸)
            // -> 배열의 인덱스 번째 요소 부터
            //    몇칸을 잘라내서 반환할지 지정
            // --> 배열에서 잘라내진 부분이 사라짐
            newTodoList.splice(index, 1);

            setTodoList(newTodoList); //리렌더링
        })
        .catch(e=>console.log(e));
    };

    return(
        <>
            <h1>{loginMember.name}의 Todo List</h1>
            <div className="todo-container">

            <h3>할 일(Todo) 입력</h3>
            <div>
                <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)}/>
                <button onClick={handleAddTodo}>Todo 추가</button>
            </div>

            <ul>
                {/* (자바스크립트)배열.map : 기존 배열을 이용해서 새로운 배열 만들기 */}
                {/* 아래 컴포넌트를 담은 새로운 map */}

                {/* todo : list에서 꺼낸 하나의 객체, index : 꺼낸 객체의 순서 */}
                {todoList.map((todo, index) => (
                    <li key={keyIndex++}>
                        <div>
                            <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                            <span>
                                <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                            </span>
                        </div>
                    </li>
                ))}
            </ul>

            </div>
        </>
    );
};

export default TodoList;
