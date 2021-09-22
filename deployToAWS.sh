./gradlew buildZip
aws lambda update-function-code --function-name javaFunction --zip-file fileb://build/distributions/basicJoker-1.0-SNAPSHOT.zip > /dev/null
aws lambda update-function-configuration --function-name javaFunction --handler io.nellis.MainFunction > /dev/null