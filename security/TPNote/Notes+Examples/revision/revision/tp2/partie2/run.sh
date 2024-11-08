# Reset
rm \
  ./SampleAcn.jar \
  ./SampleLM.jar

# Compile Java files
javac \
  sample/SampleAcn.java \
  sample/module/SampleLoginModule.java \
  sample/principal/SamplePrincipal.java

# Crée deux fichier Jar (SampleAcn et SampleLM)
jar -cvf SampleAcn.jar sample/SampleAcn.class sample/MyCallbackHandler.class
jar -cvf SampleLM.jar sample/module/SampleLoginModule.class sample/principal/SamplePrincipal.class

# Supprime les artéfacts
rm \
  ./sample/MyCallbackHandler.class \
  ./sample/SampleAcn.class \
  ./sample/module/SampleLoginModule.class \
  ./sample/principal/SamplePrincipal.class \

# Exécute
java -classpath SampleAcn.jar:SampleLM.jar \
  -Djava.security.manager \
  -Djava.security.policy==.policy \
  -Djava.security.auth.login.config==jaas.config \
  sample.SampleAcn