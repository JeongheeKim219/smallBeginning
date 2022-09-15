# smallBeginning
## 프로젝트 소개
<p>To-do 리스트 형식의 간단한 일정정리 웹 애플리케이션</p>
<p>달별로 해당 날짜의 To-do 리스트를 확인하고 관리하는 캘린더</p>

<br>
<br>

## 프로젝트 기간
<p>기획: 2022.01 ~ 2022.07</p>
<p>개발: 2022.07 ~ 2022.08</p>
<p>배포: 2022.08 ~ 2022.09</p>

<br>
<br>

## 기술 스택
#### Language  
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black">

#### Framework
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

#### Tools
<img src="https://img.shields.io/badge/Gradle-000000?style=for-the-badge&logo=Gradle&logoColor=white"/><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white"/><img src="https://img.shields.io/badge/Miro-050038?style=for-the-badge&logo=Miro&logoColor=white"/>


#### Database
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/Amazon RDS-527FFF?style=for-the-badge&logo=Amazon RDS&logoColor=white">

#### Server
<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white"/>

#### front
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"><img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">

<br>
<br>

## ERD
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbvZn59%2FbtrL22Zgxwb%2FnqI5yoMQ31ENmjxjvy8k1k%2Fimg.png" width="70%" height="70%" title="ERD" alt="ERD"></img>


<br>
<br>

## 주요 기능
#### 회원가입/로그인
![](https://velog.velcdn.com/images/kiiim/post/fa44a42d-3f07-43df-8a89-f030360a6044/image.gif)  

<br>

- 아이디, 비밀번호, 닉네임, 이메일을 입력 뒤 회원가입  
- 회원가입이 완료되면 자동으로 login 페이지로 이동  
- 아이디와 비밀번호가 DB에 저장된 회원정보와 일치하면 세션 생성 뒤 calendar 페이지로 이동
- calendar 페이지 내에서 상단의 로그아웃 버튼으로 로그아웃을 할 수 있음

<br>

#### To-do CRUD
![](https://velog.velcdn.com/images/kiiim/post/6e5d45ce-4f46-4e93-b1ac-d63731d6a2c6/image.gif)  

로그인 후에 캘린더 페이지에서 To-do를 조회, 생성, 수정, 삭제가 가능함  

<br>

- 회원별 To-do를 조회할 때 회원이 직접 지정한 To-do 색상이 적용된 상태에서 조회
- To-do에 대한 내용, 해당 날짜, 색상을 지정한 뒤 input 버튼을 누르면 To-do 생성
- 생성이 된 To-do는 해당 날짜가 우측 달력에서 선택되면 달력과 좌측 input 버튼 밑에서 확인 가능
- 좌측에서 edit 버튼을 클릭한 뒤 색상, 내용를 변경 뒤 submit을 클릭하면 수정이 완료
- status(진행여부 0은 실행하지 않은 상태, 1은 완료한 상태)는 숫자를 클릭하면 상태가 변경됨
- status가 변경될 시 우측 캘린더에서 완료 표시로 취소선이 그어지고 폰트 색상이 변경됨
- 좌측 delete 클릭 시 해당 To-do 삭제
- To-do 생성 및 삭제의 경우 ajax를 통한 비동기 방식으로 진행
- To-do 수정의 경우 페이지가 새로고침되며 변경된 내용을 확인할 수 있음

<br>

## 트러블슈팅
#### (1) Java version issue
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-01-02-Issue.md

#### (2) Mybatis connection
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-01-07-smallBeginJava11Fourth.md

#### (3) ajax 데이터 받아올때 select 태그 공란 필요
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-02-03-ajaxForm.md

#### (4) constructor error (DTO)
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-02-03-ajaxForm.md

#### (5) whitelabel error page
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-02-09-view.md

#### (6) Spring EI Error (TypeError)
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-02-14-SpringElError.md

#### (7) Java bean 생성 에러
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-03-16-javabean.md

#### (8) isEmpty()
https://github.com/allogrooming/allogrooming.github.io/blob/master/_posts/2022-03-18-calendarProcess.md

<br>

## 4. 개선점
