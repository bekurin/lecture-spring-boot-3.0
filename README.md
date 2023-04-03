## build a practical project using spring boot 3.0, kotlin and AWS

스프링 부트, 코틀린 소개
- 스프링 부트 3.0
- 코틀린을 사용하는 이유

스프링 부트, 코틀린 프로젝트 시작하기
- 인텔리제이 소개
- 인텔리제이 설치하기
- 프로젝트 생성하기
  - spring web
  - actuator
- HelloController 작성하기
- 인텔리제이에서 깃허브 사용하기

github actions, docker hub를 사용하여 코드 통합하기
aws를 사용하여 코드 배포하기
 - 우아하게 종료하기
 - ec2 인스턴스를 사용하여 컴퓨터 대여하기

ci / cd 파이프라인 동작 확인 및 정리
- /hello로 요청 보내기
- 파이프라인 정리

JPA와 querydsl을 사용하여 데이터를 다뤄보자.
- spring data JPA 소개
  - spring jpa
  - querydsl
- 요구사항 분석
- CRUD API 만들기
- JPA auditing을 사용하여 필요한 컬럼 통합하기
- querydsl을 사용하여 JPA와 비교하기
- 테스트 코드 작성하기

aws 환경에서 데이터베이스를 사용해보자.
- rds 인스턴스 생성하기
- 내 pc에서 rds 접속하기
- iam 역할을 생성하여 인스턴스에 권한 부여
- secretmanager로 보안 사항 숨기기
- 동작 확인

통합 테스트와 유닛 테스트 환경
- testcontainers를 사용하여 운영 환경과 같은 환경 구성하기
- gradle 명령어를 사용하여 유닛 테스트, 통합 테스트를 물리적으로 분리하기

스프링 시큐리티와 oauth2 사용하여 로그인하기
- oauth2 구조
  - spring security 의존성 추가하기
- keycloak을 리소스 서버로 구성하기
- 서비스 등록 및 역할 생성하기
- 로그인 구현하기
  - JWT 토큰
  - JWTTokenConverter 생성 및 등록하기
- 테스트 코드 작성하기

