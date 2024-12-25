FROM openjdk:8-jre-slim

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/mcdd-ai-chat.jar /mcdd-ai-chat.jar

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /mcdd-ai-chat.jar $PARAMS"]
