-- 1번
-- 춘 기술대학교의 학과 이름과 계열을 표시하시오. 
-- 단, 출력 헤더는 "학과 명", "계열"
SELECT DEPARTMENT_NAME "학과 명", CATEGORY "계열"
FROM TB_DEPARTMENT;

-- 2번
-- 
SELECT DEPARTMENT_NAME || '의 정원은' || ''
FROM TB_DEPARTMENT;