# Compile Java files
javac \
  sample/SampleAcn.java \
  sample/module/SampleLoginModule.java \
  sample/principal/SamplePrincipal.java

# Execute 
java -Djava.security.auth.login.config==jaas.config sample.SampleAcn

# Reset
rm \
  ./sample/MyCallbackHandler.class \
  ./sample/SampleAcn.class \
  ./sample/module/SampleLoginModule.class \
  ./sample/principal/SamplePrincipal.class