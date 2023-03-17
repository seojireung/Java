-- JDBC

--부서명을 입력 받아
--해당 부서에 존재하는 사원의
--사번, 이름, 급여, 부서명을 
--사번 오름차순으로 조회 

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '총무부'
ORDER BY EMP_ID;

-- null 입력 시 
-- 해결 방법1: 상황에 따른 SQL 구문 조립 -> 이클립스 jdbc1 - edu.kh.jdbc.dao - SelectDepartmentTitleDAO
-- 해결 방법2: SQL을 바꾸는 방법
SELECT * FROM (
   SELECT EMP_ID, EMP_NAME, SALARY, NVL(DEPT_TITLE, 'null') DEPT_TITLE
   FROM EMPLOYEE 
   LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
   ORDER BY EMP_ID )
WHERE DEPT_TITLE = 'null';

--직급명을 입력 받아 일치하는 사원의
--부서명, 직급명, 이름, 이메일을  이름 오름 차순으로 조회
SELECT DEPT_TITLE, 