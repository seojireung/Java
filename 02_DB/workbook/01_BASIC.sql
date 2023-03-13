-- 1번
-- 춘 기술대학교의 학과 이름과 계열을 표시하시오. 
-- 단, 출력 헤더는 "학과 명", "계열"으로 표시.
SELECT DEPARTMENT_NAME "학과 명", CATEGORY "계열"
FROM TB_DEPARTMENT;

-- 2번
-- 학과의 학과 정원을 다음과 같은 형태로 화면에 출력한다.
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || ' 명 입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT;

-- 3번
-- "국어국문학과"에 다니는 /여학생 /중 현재 휴학중인/ 여학생을 찾기.
-- (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회)
SELECT STUDENT_NAME 
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
AND ABSENCE_YN = 'Y'
AND SUBSTR(STUDENT_SSN,8,1) = '2';

-- 4번
-- 학번이 다음과 같을 때 대상자들을 조회.
-- A513079 A513090 A513091 A513110 A513119
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079','A513090','A513091','A513110','A513119');

-- 5번
-- 입학정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열 출력.
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6번
-- 춘 기술대학교는 총장을 제외하고 모든 교수들이 소속 학과 가지고 있음, 
-- 춘 기술대학교 총장의 이름 조회
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7번
-- 혹시 전산상의 착오로 학과가 지정되어 있지 않은 학생 있는지 확인.
SELECT * 
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8번
-- 수강신청 - 선수과목이 존재하는 과목들 과목번호 조회
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9번 
-- 춘 대학의 계열 (CATEGORY) 조회
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 10번
-- 02학번/ 전주 거주자들의 모임.
-- 휴학한 사람들 제외/ 재학중 학생들 학번, 이름, 주민번호 출력.
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%전주%' --
AND ABSENCE_YN = 'N'
AND SUBSTR(TO_CHAR(ENTRANCE_DATE, 'YY-MM-DD'),1,2) = '02';

--AND SUBSTR(STUDENT_SSN,8,1) = '2'