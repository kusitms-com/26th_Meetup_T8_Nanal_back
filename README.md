# 26th_T8_Nanal Backend

## 개발 환경과 사용 기술 스택

### Spring 선정 이유

1️⃣ **쉬운 개발환경을 제공하는 프레임워크**       
스프링은 자바 및 JVM 환경의 대체언어들의 효율적이고 쉬운 엔터프라이즈 애플리케이션 개발 환경을 제공합니다.

2️⃣ **구조 설계에 유용한 프레임워크**         
기존의 웹, 또는 하드웨어, 데이터베이스등 전문적인 영역만 지원하는 프레임워크들과 다르게, 스프링은 전체를 설계하는 용도로 사용할 수 있습니다.

3️⃣ **트렌디한 개발 프레임워크**           
Spring은 최근의 트렌드, 혹은 더 나은 프로그래밍 방법을 찾기 위해 트렌드에 맞추어 개발자들이 좀 더 능동적으로 개발할 수 있는 다양한 모듈들과 방법론을 적용시키고 있습니다.

4️⃣ **오픈소스의 호환성을 제공하는 프레임워크**              
스프링은 오픈소스로써 지속적인 업데이트가 되고 있으며 이전 버전들에 대한 강력한 호환성을 지원합니다.

5️⃣ **직관적이고 유연한 프레임워크**                    
스프링은 직관적인 API를 제공하며, 만들고자하는 애플리케이션의 요구사항과 목적에 따라 유연하게 적용시킬수 있습니다.

### 기타 서버 및 배포 도구 관련(AWS EC2, Github Actions) 선정 이유
|    AWS EC2 Github Actions    |       Docker       |     DB (mariaDB)     | DB 접근기술  Spring Data JPA |  Redis   |
|:----------------------------:|:------------------:|:--------------------:|:------------------------:|:--------:|
| -프로토타입 개발에 적합<br>  -작업환경 간소화 | 개발환경 통일 <br>-배포 용이 | -데이터 특성<br>-상업용 라이센스 |         -생산성 증가          | -토큰관리 용이 |
### 📝 커밋 컨벤션

**✨ 커밋 제목**
- 최소한의 기능을 기준으로 issue를 생성
- 이슈 이름은 `[커밋 타입] 기능 설명` 으로 통일
  ex) [feat] 검색 뷰 통신 연결
- 이슈 템플릿을 활용해 작업 설명과 진행 상황을 작성
- 진행 상황은 checkbox(todo)로 작성한다.

**📌 커밋 메세지**
<br> feat: 새로운 기능 구현
<br> fix: 오류, 버그 해결
<br> add: feat 이외의 부수적인 코드 추가, 라이브러리 추가
<br> docs: README나 WIKI 같은 문서 개정
<br> chore: 간단한 코드 수정, 내부 파일 수정
<br> rename: 파일 이름 변경이 있을 때 사용
<br> del: 쓸모없는 코드 삭제
<br> style: 코드 스타일 혹은 포맷 등에 관한 커밋
<br> refact:  코드 리팩토링에 대한 커밋
<br> test : 테스트 코드 수정에 대한 커밋

## 아키텍처
![KakaoTalk_20221014_222429596](https://user-images.githubusercontent.com/115769126/195902499-86655519-bf4b-4741-b533-e74c242a8b93.png)


## 주요 기능 명세서
![개발팀 기능명세서](https://user-images.githubusercontent.com/115769126/195903251-91c4a8c0-c1f0-40cd-abf0-581f34209d50.JPG)

## ERD
![Kusitms_NN](https://user-images.githubusercontent.com/80163835/203531892-e9809a67-9681-460a-a4b9-3bb639f0acef.png)

## 서버 메트릭 모니터링 방법
✓ Jennifer 를 사용한 핵심 지표 및 트래픽 모니터링
<br>✓ 웹 어플리케이션 서버(WAS) 최소한의 부하로 서비스 및 리소스에 대한 실시간 모니터링,
성능 및 장애 분석, 통계 데이터 분석, 보고서 작성이 가능

## 개발부터 배포까지의 워크플로우
✓ 코드 머지 - Github Actions 플로우 실행 - 빌드를 통한 이미지 생성 - Docker Hub 에 이미지 업로드 - EC2 접속 - EC2에서 Docker Hub에 업로드한 이미지 다운로드 - 이미지 기반으로 컨테이너 실행 - 서버 배포
<br>✓ 브랜치 머지부터 배포까지 걸리는 시간은 대략 **1분 30초**

## 데이터 로깅과 시각화 방법 - 지표 추적 방법
|                    진행                    |                                                                                                                     미래(추후 적용)                                                                                                                     |    
|:----------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| : Spring AOP 이용<br>(데이터 로그를 출력 및 DB에 저장) |                                                                                       : Google Analytics 이용<br>(데이터 로깅에 따른 시각화 및 분석을 더욱 용이하게 할 수 있도록 할 예정)                                                                                        |
|저장된 데이터를 토대로 앞서 기재한 서비스 핵심 지표를 분석하는 방법 | - 구글에서 제공하는 웹 분석 서비스, API 와 프로젝트를 연결하여 상단에 기재된 지표 추적 가능<br>- 구글 클라우드 플랫폼에서 구글 애널리틱스에 접근하기 위한 계정을 생성 후 Google Analytics Reporting API 라이브러리를 연동<br>- 구글 태그 매니저(GTM)의 연동을 통해, 다양한 태그를 관리하여 이벤트 트래킹을 진행. GTM 은 개발자가 정의하지 않아도 기획자 마케터가 직접 정의하여 데이터 획득 |
