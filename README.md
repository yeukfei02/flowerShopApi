# flowerShopApi

Help you to record and find flower + shop

documentation: https://documenter.getpostman.com/view/3827865/SzfCU5nA?version=latest

## Requirement:

 - install java (1.8+)

## Testing and run:

```
// build jar
$ ./gradlew stage --warning-mode all

// run jar
$ java -jar build/libs/flowerShopApi-1.0.0.jar

// start project - run Main.kt

// run test case - run MainTest
```

open project in intellij idea

open localhost:7000

## Docker:

- Dockerfile

build images and start container
```
docker build -t <username>/flower-shop-api:<tag> .
docker run -p 7000:7000 -d <username>/flower-shop-api:<tag>
docker exec -it <containerId> /bin/bash
docker logs <containerId>
```

check images and container
```
docker images
docker ps
docker ps -a
```

open localhost:7000

- docker-compose.yml

build images and start container
```
docker-compose build
docker-compose up
```

build images and start container in one line
```
docker-compose up -d --build
```

stop container
```
docker-compose stop
```

add tag to docker images
```
$ docker tag <imageId> <dockerHubUserName>/<imageName>:<tag>
```

push docker images to docker hub
```
$ docker push <dockerHubUserName>/<imageName>:<tag>
```

open localhost:7000

## Contributing

Please refer to [CONTRIBUTING.md](https://github.com/yeukfei02/flowerShopApi/blob/master/CONTRIBUTING.md)