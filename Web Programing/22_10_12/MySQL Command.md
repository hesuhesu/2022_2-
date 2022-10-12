# MySQL 명령어 실습

### 첫 실행과 방법

+ 우선 설정한 비밀번호를 입력한다.

+ 최초 시행 시 create database mydb; 로 저장소를 생성한다

+ use mydb; 를 입력해줘서 실행한다. (참고로 다시 켜면 매번 해줘야함)

+ 테이블 생성 과정이다 아래 참조.

create table Member (

id varchar(10) not null,

pw varchar(10) not null,

name varchar(30) not null,

phone varchar(15) not null,

balance int not null,

rdate datetime not null,

primary key(id)

);

이런 식으로 테이블 생성이 가능하다. 수정이 안되므로 메모장에 기입해서 복붙하거나,
drop table member;로 삭제하고 재생성하자

### 여러가지 tip 명령어

+ show tables;
위의 명령어는 테이블이 있는지 확인한다.

+ show variables like 'lower_case_table_names';
위의 명령어는 0인지 1인지 출력해주는데, 1이면 대소문자 구분 x 이며 0이면 구분한다.
0이라면 desc Member; 처럼 구분해주자.



### Record 추가(insert) 및 조회(select)

insert into member values

('ann','1111','빨강머리 앤', '010-999-9999',0, now());

insert into member values

('dooli','5252','둘리 사우르스', '곧 구입 예정 ',0, now());

insert into member values

('james','7777','제임스 본드', '007-007-7777',1000000, now()); // 레코드 추가

+ select id,name from member;  // 필요한 컬럼만 본다.
+ select * from member;        // 모든 컬럼을 본다.
+ select * from member where pw ='7777';   // 특정 row만 보겠다
