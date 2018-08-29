FROM java:8
VOLUME /tmp
ADD mp-1.0.jar mp.jar
RUN sh -c 'touch /mp.jar'
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mp.jar" ]