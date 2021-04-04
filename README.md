# flowerShopApi

Help you to record and find flower + shop

documentation: <https://documenter.getpostman.com/view/3827865/SzfCU5nA?version=latest>

## Requirement

- install java (1.8+)

## Testing and run

```zsh
// build jar
$ ./gradlew stage --warning-mode all

// run jar
$ java -jar build/libs/flowerShopApi-1.0.0.jar

// start project - run Main.kt

// run test case - run MainTest.kt
```

open project in intellij idea

open localhost:7000

## Docker

```zsh
// build images and start container in one line
docker-compose up -d --build

// go inside container
docker exec -it <containerId> /bin/bash

// check container logs
docker logs <containerId>

// remove and stop container
docker-compose down
```

open localhost:7000

## Contributing

Please refer to [CONTRIBUTING.md](https://github.com/yeukfei02/flowerShopApi/blob/master/CONTRIBUTING.md)
