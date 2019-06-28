mvn clean install deploy -DskipTests=true -Dmaven.javadoc.skip=true -B -V -P s3 -s .travis.settings.xml -DAWS_DEFAULT_REGION=us-east-1 
