# Reset
rm \
  ./SampleAcn.jar \
  ./SampleAction.jar \
  ./SampleLM.jar

# Compile
javac \
  sample/SampleAction.java \
  sample/SampleAzn.java \
  sample/module/SampleLoginModule.java \
  sample/principal/SamplePrincipal.java

# Créé les JAR SampleAzn, SampleAction, SampleLM
jar -cvf SampleAzn.jar sample/SampleAzn.class sample/MyCallbackHandler.class
jar -cvf SampleAction.jar sample/SampleAction.class
jar -cvf SampleLM.jar sample/module/SampleLoginModule.class sample/principal/SamplePrincipal.class

# Enlève les artéfacts
rm \
  ./sample/SampleAction.class \
  ./sample/SampleAzn.class \
  ./sample/MyCallbackHandler.class \
  ./sample/module/SampleLoginModule.class \
  ./sample/principal/SamplePrincipal.class

# Executer
java -classpath SampleAzn.jar:SampleAction.jar:SampleLM.jar \
 -Djava.security.manager \
 -Djava.security.policy==azn.policy \
 -Djava.security.auth.login.config==jaas.config sample.SampleAzn