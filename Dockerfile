FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
# workspace
WORKDIR /Users/rinshadkt/IdeaProjects/Container

ADD target/selenium-docker.jar      selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs                      libs

ADD TestNg.xml TestNg.xml

ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh

#ENTRYPOINT java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
