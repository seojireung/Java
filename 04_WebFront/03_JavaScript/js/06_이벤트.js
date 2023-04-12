// 인라인 이벤트 모델 확인하기
function test1(el){ // el == element == 전달 받은 요소 == this
    el.style.backgroundColor = 'black';
    el.style.color = 'white';
}

// 고전 이벤트 모델 확인하기

// 아이디가 'test2a'인 요소를 얻어오기

console.log(document.getElementById('test2a').onclick); 
// -> (console) null 출력 (아직 click 했을 때 동작할 함수(이벤트 핸들러)가 없음)

document.getElementById('test2a').onclick = function(){

    // function(){} : 익명 함수(이름이 없는 함수)
    //                재사용 목적이 아닌
    //                특정 이벤트에 대한 기능을 만들 때 주로 사용

    alert("고전 이벤트 모델로 출력된 내용입니다");
    // 버튼 클릭 됐을 때 alert 실행
}

// test2a의 클릭 이벤트 동작 제거(이벤트 삭제)
document.getElementById('test2b').onclick = function(){
    document.getElementById('test2a').onclick = null;
    alert("이벤트를 제거하였습니다.");
} 

// 고전 이벤트 모델 단점 확인하기
// -> 한 요소에 여러 이벤트 핸들러를 연결할 수 없음
//    왜? 마지막을 작성한 핸들러가 앞서 작성된 핸들러를 덮어 씌움

const c = document.getElementById('test2c'); // 버튼 요소를 얻어옴

c.onclick = function(){
    c.style.backgroundColor = "pink"; // 배경색 핑크
}

c.onclick = function(){
    c.style.fontSize = "40px"; // 폰트 크기 40px
}

// 표준 이벤트 모델 확인하기
/* 
    [표준 이벤트 모델 작성 방법]

    요소.addEventListener(감지할 이벤트, 이벤트 핸들러);

    ex)
    test3.addEventListener("click", function(){});
                                    익명 함수
*/

const test3 = document.getElementById('test3');

// #test3 클릭 시 width를 20px 만큼 증가
test3.addEventListener("click", function(){
    console.log("a");

    // 요소.clientWidth  : 요소의 너비 (CSS로 지정된 값도 읽어옴, readonly)
    // 요소.clientHeight : 요소의 높이 (CSS로 지정된 값도 읽어옴, readonly)
    
    test3.style.width = test3.clientWidth + 20 +"px";
                        /* 현재 너비 */
});

// 중간에 코드 2만줄 .....

test3.addEventListener("click", function(){
    console.log("b");

    // this : 이벤트가 발생한 요소 (여기서는 #test3)
    this.style.height = this.clientHeight + 20 + "px";
});

test3.addEventListener("click", function(e){
    console.log("c");

    // 이벤트 핸들러의 매개변수 e 또는 event
    // -> 현재 발생한 이벤트에 대한 모든 정보를 담고있는 객체
    // == 이벤트 객체

    // e.target : 이벤트가 발생한 현재 요소 (==this)

    // console.log(e);

    const currentWidth = e.target.clientWidth;

    console.log(currentWidth);

    // 현재 너비가 500px을 초과하면 너비/높이를 200px로 초기화
    if(currentWidth > 500 - 20){ // 이전 너비
        e.target.style.width = "200px";
        e.target.style.height = "200px";
    }
});

// 간이계산기 만들기 (표준 이벤트 모델)

const num1 = document.getElementById('num1');
const num2 = document.getElementById('num2');
const result = document.getElementById('result');

//-----plus만 봤을 때-----
/*
plus.addEventListener("click", function(e){
    result.innerText 
    = new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
});
*/

//-----계산기 전체-배열-for of 구문-----

// 클래스가 op인 요소를 모두 찾아 배열로 반환
const opList = document.getElementsByClassName('op');

// for of 구문(향상된 for문)
// -> 배열(Array), 유사 배열(HTMLCollection, NodeList, ...)
//    위와 같이 배열 형태의 요소를 순차 접근하는 용도의 반복문

for(let op of opList){
// for(let i=0; i<opList.length; i++){

    // 배열의 각 요소 == 각각의 버튼에 click 되었을 때의 동작을 추가
    op.addEventListener('click', function(e){
        result.innerText 
        = new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
    });
}

// 입력하는 값으로 박스 색 변화

const boxList = document.getElementsByClassName('box'); // 배열
const colorList = document.getElementsByClassName('color'); // 배열

for(let i=0; i<boxList.length; i++){ // i == 0 ~ 4

    // input 태그 i번째에 키가 올라올 때 == 입력된 후
    colorList[i].addEventListener('keyup', function(e){
        // e.target == keyup이 발생한 input 요소

        boxList[i].style.backgroundColor = e.target.value;
        // boxList[i].style.backgroundColor = colorList[i].value;
    });
}
// 참고 (for of 구문)
for(let color of colorList){
    color.addEventListener("keyup", function(e){
        //previousElementSibling : 이전 형제 요소
        e.target.previousElementSibling.style.backgroundColor = e.target.value;
    })
}

// a태그 기본 이벤트 제거
document.getElementById('moveGoogle').addEventListener("click", function(e){

    // e : 이벤트 객체
    e.preventDefault(); // 기본 이벤트를 막아버림

    // Default : 기본 / 기본값
    // prevent : 막다 / 예방하다
});

// -> form 태그 기본 이벤트 제거 1
// -> submit 버튼을 없애고
//    일반 button이 클릭 되었을 때 조건이 맞으면 submit 하게 만들기
/*
document.getElementById('btn').addEventListener("click", function(){

    // 작성된 아이디, 비밀번호 얻어오기
    const id = document.querySeleftor("[name='id']").value;
    const pw = document.querySeleftor("[name='pw']").value;

    if(id == 'user01' && pw == 'pass01'){
        // 아이디, 비밀번호가 일치할 때 for, 태그 제출

        // submit() : form 태그 제출
        document.testForm.submit();
    }
});*/

// form 태그 기본 이벤트 제거 방법2 (인라인 이벤트 모델)
function fnCheck(){

    // 작성된 아이디, 비밀번호 얻어오기
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;

    if(id == 'user01' && pw == 'pass01'){
        // 아이디, 비밀번호가 일치할 때 form 태그 제출

        return true; // true를 반환해서 제출 수행
    }
    return false; // false를 반환해서 제출을 막음
}

// form 태그 기본 이벤트 제거 방법3 (표준 이벤트 모델)
// -> name이 testForm인 form태그에서 submit 이벤트가 발생 했을 때
document.testForm.addEventListener("submit", function(e){
    
    // e : 이벤트 객체
    e.preventDefault(); // 기본 이벤트 막기
});
