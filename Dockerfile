FROM tomcat:9.0.1-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps
COPY ./classes/artifacts/JSFTest3_war/JSFTest3_war.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]