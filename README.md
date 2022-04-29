# MSA Team - Board Domain Server

`현재 접근하신 Repository는 게시판 Domain Server 입니다.`

### [Eureka Server Link](https://github.com/powerstar13/msa-team-eureka)
Port: 8761
### [Gateway Server Link](https://github.com/powerstar13/msa-team-gateway)
Port: 8080
### [회원 Domain Server Link](https://github.com/powerstar13/msa-team-member)
Port: 8081
### [게시판 Domain Server Link](https://github.com/qpyu66/msa-community)
Port: 8082
### [강의 Domain Server Link](https://github.com/brightchul/CodestatesTeam2LectureService)
Port: 8083

# 도메인 모델
![DDD 도메인 과제 - 도메인 모델](https://user-images.githubusercontent.com/53042885/164647974-3815559b-298f-44f7-b7ba-d67c26d89320.jpg)

# Entity&Value-Object
![Entity Value-Object](https://user-images.githubusercontent.com/53042885/164648463-b47d5977-7357-4aad-b090-4bf4681bdd97.png)


#### Kafka 실습 시나리오
게시물 저장 -> 게시물 저장 이벤트 전달 (Producer) -> Kafka -> 저장 정보를 받아 게시물 리스트 출력 (consumer)

![image](https://user-images.githubusercontent.com/62865808/165917418-86939f6e-97b9-4a06-b18d-dfe3fd283707.png)
