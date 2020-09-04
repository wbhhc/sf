#!/bin/bash
#这个是shell！替换配置文件并发布，然后配置文件还原。
if [ x$1 != x ]
then
    echo '开始修改bootstrap.yml'
    sed -i "" "s/active:[ ].*/active: $1/g" web/src/main/resources/bootstrap.yml
    sed -i "" "s/active:[ ].*/active: $1/g" sso/src/main/resources/bootstrap.yml
    sed -i "" "s/active:[ ].*/active: $1/g" api-gateway/src/main/resources/bootstrap.yml

    echo '开始修改pom.xml'
    sed -i "" "s/<!--this is publish pos-->/<includes><include>bootstrap.yml<\/include><include>application-$1.yml<\/include><include>bootstrap-$1.yml<\/include><include>**\/*.xml<\/include><include>\/static\/**<\/include><include>\/templates\/**<\/include><\/includes>/g" web/pom.xml
    sed -i "" "s/<!--this is publish pos-->/<includes><include>bootstrap.yml<\/include><include>application-$1.yml<\/include><include>bootstrap-$1.yml<\/include><include>**\/*.xml<\/include><include>\/static\/**<\/include><include>\/templates\/**<\/include><\/includes>/g" sso/pom.xml
    sed -i "" "s/<!--this is publish pos-->/<includes><include>bootstrap.yml<\/include><include>application-$1.yml<\/include><include>bootstrap-$1.yml<\/include><include>**\/*.xml<\/include><include>\/static\/**<\/include><include>\/templates\/**<\/include><\/includes>/g" api-gateway/pom.xml


    echo '开始打包'$1
    mvn clean package -Dmaven.test.skip=true

    echo '正在复制文件到publish目录...'
    cp web/target/user-platform-web.jar publish/user-platform-web.jar
    cp sso/target/user-platform-sso.jar publish/user-platform-sso.jar
    cp api-gateway/target/api-gateway.jar publish/api-gateway.jar



    echo 'over.'
else
    echo '请输入一个参数，例如./build publish'
fi



