-- SQL 한 주 주석

/*
범위
주석
*/

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- CTRL + ENTER : 선택한 SQL 수행

-- 사용자 계정 생성
CREATE USER kh_sjy IDENTIFIED BY "oracle_sjy5599";

-- 사용자 계정에 권한 부여
GRANT RESOURCE, CONNECT TO kh_sjy;

-- 객체가 생성될 수 있는 공간 할당량 지정
ALTER USER kh_sjy DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;




