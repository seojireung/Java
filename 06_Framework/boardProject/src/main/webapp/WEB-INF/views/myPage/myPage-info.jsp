<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="/resources/css/myPage/myPage-style.css">

</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="myPage-content">

            <jsp:include page="/WEB-INF/views/myPage/sideMenu.jsp" />

            <section class="myPage-main">

                <h1 class="myPage-title">내 정보</h1>
                <span class="myPage-subject">원하는 회원 정보를 수정할 수 있습니다.</span>

                <%-- 현재 페이지 : http://localhost/myPage/info --%>
                <%-- 제일 뒤에 info 지우고 action에 작성된 경로 추가 --%>
                    <%-- 상대 경로 --%>
                <form action="info" method="POST" name="myPageFrm">

                    <div class="myPage-row">
                        <label>닉네임</label>
                        <input type="text" name="memberNickname"  maxlength="10" 
                        value="${loginMember.memberNickname}">
                    </div>

                    <div class="myPage-row">
                        <label>전화번호</label>
                        <input type="text" name="memberTel"  maxlength="11"
                        value="${loginMember.memberTel}">
                    </div>

                    <div class="myPage-row info-title">
                        <span>주소</span>
                    </div>
                    <%-- ${fn:split(loginMemeber.memberAddress, '^^^')[0]}
                    ${fn:split(loginMemeber.memberAddress, '^^^')[1]}
                    ${fn:split(loginMemeber.memberAddress, '^^^')[2]} --%>

                    <%--  
                        ${fn:split(문자열, 구분자)}
                        문자열을 구분자로 나누어배열 형태로 반환
                    --%>

                    <c:set var="addr" value=${fn:split(loginMemeber.memberAddress, '^^^')}"/>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress" placeholder="우편번호" value="${addr[0]}" id="sample6_postcode">
                        <button type="button" onclick="sample6_execDaumPostcode()">검색</button>
                    </div>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress"  placeholder="도로명/지번 주소" value="${addr[1]}" id="sample6_address">                
                    </div>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress"  placeholder="상세 주소" value="${addr[2]}" id="sample6_detailAddress">                
                    </div>

                    <button class="myPage-submit">수정하기</button>
                </form>

            </section>

        </section>

    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <!-- 다음 주소 api 추가 -->
    
</body>
</html>