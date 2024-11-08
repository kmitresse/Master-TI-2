# Compile Java file
javac ./GetProps.java

# Execute with security manager and policy file
java -Djava.security.manager \
  -Djava.security.policy=.policy \
  GetProps

# Remove compiled file
rm ./GetProps.class