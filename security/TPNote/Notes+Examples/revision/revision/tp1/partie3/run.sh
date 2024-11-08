# Reset
rm ./keystore.jks ./Source_Signed.jar

# Génère un keystore
keytool -genkeypair \
  -alias SourceKeyAlias \
  -keyalg RSA \
  -keysize 2048 \
  -keystore keystore.jks \
  -validity 365

# Compilation
javac ./Source.java

# Créer un fichier MANIFEST.MF avec l'attribut Main-Class
echo "Main-Class: Source" > MANIFEST.MF

# Crée le fichier JAR non signé avec le MANIFEST.MF modifié
jar cmf MANIFEST.MF Source.jar Source.class

# Convertir en fichier JAR signé
jarsigner -keystore keystore.jks \
  -signedjar Source_Signed.jar Source.jar SourceKeyAlias

# Supprime les artéfacts
rm ./Source.class ./Source.jar MANIFEST.MF

# Essaye d'exécuter ton fichier JAR signé
java -jar Source_Signed.jar
