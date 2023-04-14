// 계산 버튼 클릭 시
// input 태그에 작성된 값을 모두 읽어와 합한 결과를 alert로 출력

const calc = document.getElementById("calc");

// 계산
calc.addEventListener("click", () => {
    
    // **계산 버튼이 클릭되는 시점의 .in input 태그들을 모두 읽어옴**
    // (함수보다 먼저 읽어올 경우 최초 input 갯수 만큼만 저장한 것 불러옴)
    const numList = document.getElementsByClassName("in");

    let sum = 0;

    for(let i=0; i<numList.length; i++){
        sum += Number(numList[i].value); // value는 함수 안에서 부르기
    }
    // 향상된 for문
    // for(let input of numList){
    //     sum += Number(input.value);
    // }
    alert(sum);
});

// ----------------------------------

// 추가 버튼이 클릭 되었을 때

// .container 요소의 마지막 자식으로
// <div class="row">
//      <input type="number" class="in">
// </div>
// 위 요소를 만들어서 추가하기

const add = document.getElementById("add");

add.addEventListener("click", () => {
    // 요소 만들기 : document.createElement("태그명") 
    // 요소 제거하기 : 요소.remove();

    // 요소의 클래스 목록 확인하기 : 요소.classList

    // 요소에 class 추가 : 요소.classList.add("클래스명")
    // 요소에 class 제거 : 요소.classList.remove("클래스명")

    // 요소에 속성, 값 추가  : 요소.setAttribute("속성명", "값");
    // 요소에 속성 자체 제거 : 요소.removeAttribute("속성명");

    // 부모요소.append(자식요소) : 
    //  부모 요소의 마지막 자식으로 자식 요소를 추가(덧붙이기)
    // 부모요소.prepend(자식요소) : 
    //  부모 요소의 첫 번째 자식으로 자식 요소를 추가(덧붙이기)

    // A.after(B) : A의 다음 요소로 B를 추가
    // A.before(B) : A의 이전 요소로 B를 추가

    // ----------------------------------------------
    // div 요소 만들기
    const div = document.createElement("div");
    div.classList.add("row"); // div에 row 클래스 추가
    
    // ----------------------------------------------
    // input 요소 만들기
    const input = document.createElement("input");
    input.classList.add("in"); // input에 in 클래스 추가
    input.setAttribute("type", "number"); // input에 type="number" 속성 추가

    // ----------------------------------------------
    // span 요소 만들기
    const span = document.createElement("span");
    span.classList.add("remove-row"); 
    span.innerHTML = "&times;"; 

    // 만들어진 span 요소에 이벤트리스너 추가
    span.addEventListener("click", e => {
        // 클릭된 요소의 부모 요소를 삭제 == row 삭제
        e.target.parentElement.remove();
    });

    // ----------------------------------------------

    // div의 자식으로 input 추가
    // div.append(input);
    div.prepend(input);

    // div의 마지막 자식으로 span 추가
    div.append(span);

    // -----------------------------------------------

    // .container의 마지막 자식으로 div 추가
    document.querySelector(".container").append(div);
});

// 삭제 버튼 동작 테스트

// 클래스가 remove-row인 요소 중 첫 번째 요소
document.querySelector(".remove-row").addEventListener("click", e => {
    console.log(e.target); // 이벤트가 발생한 요소 (클릭된 버튼)

    // 이벤트가 발생한 요소의 부모 요소(.row)
    console.log(e.target.parentElement);

    // 이벤트가 발생한 요소의 부모 요소를 제거(remove)
    e.target.parentElement.remove();
});



