> # 향상된 일정관리 프로그램 만들기!

<h1>🖥️ 프로젝트 소개</h1>

---

- JAVA로 일정관리 프로그램을 만들어보자!<br>

---

<h1>🕰️ 개발 기간</h1>

---
- 25.03.27일 - 25.04.04일

---
<h1>⚙️ 개발 환경</h1>

- `JAVA`
- `JDK 17.0.14`
- `Spring`
- `build.gradle`
- `Mysql`
- `JDBC`
  
---

<h1>📌 주요 기능</h1>

- 일정 기록
- 일정 목록 전체 조회
- 일정 제목 변경
- 일정삭제
- 유저 등록
- 유저 단건 조회
- 유저 비밀번호 변경
- 유저 삭제
- 로그인
  
<h1>일정관리 프로그램 프로젝트 구상</h1>

- 유저 생성
- 로그인
- 로그인으로 인증 후
- 일정 등록 및 일정 제목 변경
- 유저 비밀번호 변경

---

0️⃣ Lv 0. API와 ERD 만들기 !

![develop ERD](https://github.com/user-attachments/assets/d5531cc4-6b53-45c0-9944-016365b31905)

![develop UserAPI](https://github.com/user-attachments/assets/49e46c30-d320-493e-a02f-91f5feeb4d89)

![develop schedule API](https://github.com/user-attachments/assets/18eafd2b-8bab-4c5a-a819-7113a8cdfb29)

-SQL 스크립트[schedule.sql](schedule.sql)

---

1️⃣ Lv 1. 일정 CRUD

일정의 CRUD

C 일정 생성 
R 일정 전체 조회
U 일정 제목 수정
D 삭제

필드 : 작성자, 할일 제목, 할일 내용, (작성일 ,수정일)

---

2️⃣ Lv 2. 유저 CRUD

유저의 CRUD

C 유저 등록
R 유저 단건 조회
U 유저 비밀번호 수정
D 삭제

필드 : 유저명, 이메일, (작성일, 수정일)

---

3️⃣ Lv 3. 회원 가입

비밀번호 필드 추가

---

4️⃣ Lv 4. 로그인(인증)

로그인기능을 추가 (이메일과 비밀번호로 로그인)
이후
일정을 수정과 삭제를 id값이 아닌 로그인으로 수정및 삭제 가능

---

<h2>트러블 슈팅⚽</h2>

- hibernate.ddl-auto=update로 설정 이후 설정된 null 값이면 안되는 데이터 테이블이 null 로 저장된 값이 생기면서 오류 발생.
 -> hibernate.ddl-auto=update를 create로 설정 하거나 Entity 설정에 변경이 있다면 테이블 삭제를 해서 다시 테스트.


  
