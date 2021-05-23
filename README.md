### Microservices

This project contains 3 microservices. The first, connects to twitter and fetches a user's number of tweets. The second, connects to github and looks for the amount of a user's repositories. And the third, calls the others microsservices and adds up this information.

#### Run the application 
* Docker and docker-compose must be installed. If you don't have it, [click here](https://docs.docker.com/get-docker/) and [here](https://docs.docker.com/compose/install/)

* Download the source code, extract to a directory and access the project folder.
* Open the terminal / command line from that folder.

* Execute the command `./gradlew build -x test` for each microservice (totalizer, twitter-consumer and githubconsumer)
* After this, run `docker-compose build` and `docker-compose up`
---
To make the requests, we will use **curl**, which is a free and open source tool.
curl is a tool to transfer data from or to a server, using different protocols ([click here](https://curl.haxx.se/) for more information).

* Totalizer (replace isagiongo and isagiongo with the username you want in Twitter and GitHub, respectively)
``` 
curl --location --request GET 'http://localhost:8083/totalizers/?twitter=isagiongo&github=isagiongo'
``` 
* Count twitts by name
```
curl --location --request GET 'http://totalizer:8083/totalizers/twitts/isagiongo'
``` 
* Count respositories by name
```
curl --location --request GET 'http://totalizer:8083/totalizers/repositories/isagiongo
``` 

##### References
* https://imasters.com.br/apis-microsservicos/consumindo-servicos-de-forma-facil-com-spring-cloud-feign
* https://medium.com/@bdias.ti/criando-arquitetura-microservi%C3%A7o-utilizando-spring-boot-9973f7d16591
* https://www.codeflow.site/pt/article/twitter4j
* https://github-api.kohsuke.org/
* https://wiwi-gitlab.uni-muenster.de/pi-examples/acse-docker-simple-service
* https://springframework.guru/manage-docker-containers-with-docker-compose/

* https://blog.codecentric.de/en/2017/02/integration-testing-strategies-spring-boot-microservices/
