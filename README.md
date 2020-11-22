# petclinic-kakaopay-devops

* 이 프로젝트는 [spring-petclinic-data-jdbc](https://github.com/spring-petclinic/spring-petclinic-data-jdbc)를 빌드하고 쿠버네티스 클러스터에 배포하는 방법을 제공합니다.
* 이 프로젝트를 쿠버네티스 클러스터에서 실행시키기 위한 몇 가지 단계를 기술합니다.

<br/>

## 1. jib 빌드 및 저장소에 이미지 생성

`build.gradle` 파일이 있는 경로에서 다음 명령어를 수행합니다.

```
$ gradle clean jib
```

<br/>

## 2. Kubernetes 클러스터에 배포
동일한 경로에서 다음을 수행합니다.

1. (생략 가능) Ingress Controller 실행

    배포할 클러스터에 이미 실행중인 incress-controller가 있다면, 이 단계는 생략합니다.

    ```
    $ kubectl apply -f ./manifest/ingress-nginx/ingress-nginx.yaml
    ```

1. manifest 배포

    아래 명령어를 통해 `ingress.yaml`, `mysql.yaml`, `petclinic.yaml`을 클러스터에 배포합니다.

    ```
    $ kubectl apply -f ./manifest/
    ```

<br/>

## 3. Application 실행 결과 확인
다음 명령어를 이용해 ingress-controller의 `EXTERNAL-IP`를 확인한 후(생략 가능), 브라우저에 `http://[EXTERNAL-IP]/` 입력하여 애플리케이션 실행 결과를 확인합니다. 

```            
$ kubectl -n ingress-nginx get svc ingress-nginx-controller
```

<br/>

## 참고
이 프로젝트는 uid=1000 인 USER가 생성되어있는 이미지 [openjdk-11-adduser](https://hub.docker.com/r/lssang0000/openjdk-11-adduser/tags)를 사용합니다. 해당 이미지를 빌드하기 위한 Dockerfile은 `./openjdk-11-adduser`에서 확인할 수 있습니다.




