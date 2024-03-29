-- 01. example 계정을 생성하고, 개채생성, 변경, 제거 권한과, DB연결 권한을 추가하고
-- example2 계정을 생성하고 DB연결 권한과 view 생성 권한을 추가
 
-- ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER example IDENTIFIED BY "password";

--GRANT SESSION TO example; -- db 연결
GRANT RESOURCE TO example; --개체생성, 변경, 제거 권한
GRANT CONNECT TO example; --DB연결 권한
--GRANT CREATE TABLE TO example;
--GRANT SELECT, INSERT TO example;


CREATE USER example2 IDENTIFIED BY "password2";

GRANT CONNECT TO example2;
GRANT CREATE VIEW TO example2;

-- 02. example2 계정의 DB연결 권한을 회수 후 계정 삭제
REVOKE CONNECT FROM example2;
DROP USER example2 CASCADE;

-- 03. example계정으로 접속해서 테이블 정의서를 참고하여 
-- MEMEBER 테이블과 BOARD 테이블을 생성
sqlplus example/password

CREATE TABLE "MEMBER"(
	MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY NOT NULL,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PASSWORD VARCHAR2(30) NOT NULL,
	PHONE_NUMBER VARCHAR2(20),
	DELETE_YN CHAR(1) CONSTRAINT YN_CHK CHECK(DELETE_YN IN ('Y','N')) DEFAULT 'N'
);

COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PASSWORD IS '비밀번호';
COMMENT ON COLUMN MEMBER.PHONE_NUMBER IS '핸드폰번호';
COMMENT ON COLUMN MEMBER.DELETE_YN IS '삭제여부';

---------------BOARD---------------
CREATE TABLE "BOARD" (
	"BOARD_NO" NUMBER CONSTRAINT BOARD_PK PRIMARY KEY NOT NULL,
	"BOARD_TITLE" VARCHAR2(300)	NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000) NOT NULL,
	"BOARD_WRITER" NUMBER,
	"CREATE_DATE" DATE DEFAULT SYSDATE,
	"BOARD_WRITER" CONSTRAINT BOARD_WRITER_FK
	FOREIGN KEY("MEMBER_NO") REFERENCES "MEMBER" (MEMBER_NO)
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '글번호';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '글제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '글내용';
COMMENT ON COLUMN "BOARD"."BOARD_WRITER" IS '작성자';
COMMENT ON COLUMN "BOARD"."CREATE_DATE" IS '작성일자';

-- 04. MEMBER 테이블과 BOARD 테이블에 다음과 같은 데이터를 추가
-- 단, 회원번호와 글번호는 시퀀스를 생성하여 추가.
-- 시퀀스 : SEQ_MEMBER_NO : 100부터 시작하여 100씩 증가 
--		  SEQ_BOARD_NO : 1부터 시작하여 1씩 증가

-- 시퀀스 추가
CREATE SEQUENCE SEQ_MEMBER_NO
START WITH 100
INCREMENT BY 100
NOCACHE;

CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;

--데이터 inserst
INSERT INTO "MEMBER"
VALUES (SEQ_MEMBER_NO.NEXTVAL, 'step1', 'step11', NULL, DEFAULT);
INSERT INTO "MEMBER"
VALUES (SEQ_MEMBER_NO.NEXTVAL, 'step2', 'step22', '010-1111-2222', DEFAULT);
INSERT INTO "MEMBER"
VALUES (SEQ_MEMBER_NO.NEXTVAL, 'step3', 'step33', NULL, DEFAULT);

INSERT INTO "BOARD"
VALUES (SEQ_BOARD_NO.NEXTVAL, '첫 글', '스텝평가', 100, '2023-03-12');
INSERT INTO "BOARD"
VALUES (SEQ_BOARD_NO.NEXTVAL, '두 번째 글', '재밌다', 300, '2023-03-12');
INSERT INTO "BOARD"
VALUES (SEQ_BOARD_NO.NEXTVAL, '세 번째 글', '하하하', 200, '2023-03-12');

-- 05. select문
SELECT BOARD_NO 글번호, BOARD_TITLE 제목, BOARD_TITLE 내용, MEMBER_ID 작성자, TO_CHAR(CREATE_DATE, 'YY/MM/DD') 작성일
FROM "BOARD"
RIGHT JOIN "MEMBER" ON (BOARD_WRITER = MEMBER_NO)
ORDER BY BOARD_NO DESC;




