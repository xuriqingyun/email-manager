#!/bin/sh

cd /apps/java-apps/email-manager
git pull
mvn clean package -Dmaven.test.skip=true
cd /apps/java-apps/email-manager/target
ps -ef |grep email-manager-0.0.1-SNAPSHOT.jar |awk '{print $2}'|xargs kill -9
java -jar email-manager-0.0.1-SNAPSHOT.jar &
echo "deploy progress is complete!"
