#!/bin/bash

# Reset
rm -rf ./CA
rm ./client/certificat_request.csr \
  ./client/certificat_signed.cer \
  ./client/certificat.cer \
  ./client/keystore.jks \
  ./client/Source_Signed.jar

##########################################

# Création des dossiers CA et client s'ils n'existent pas déjà
mkdir -p CA client

# Génération de la clé privée de la CA
openssl genrsa -out CA/ca.key 2048
echo "[CA] - génération de la clé privée : OK"

# Génération du certificat auto-signé de la CA
openssl req -x509 -new -nodes \
  -key CA/ca.key -sha256 -days 365 \
  -out CA/ca.crt \
  -subj "/CN=SimulatedCA/O=MyCA/C=FR"
echo "[CA] - génération du certificat auto-signé : OK"

# Génération du keystore du client
keytool -genkeypair \
  -alias KeyAlias \
  -keyalg RSA \
  -keysize 2048 \
  -keystore client/keystore.jks \
  -validity 365 \
  -dname "CN=ClientName, OU=ClientUnit, O=ClientOrg, L=ClientCity, S=ClientState, C=FR" \
  -storepass changeit \
  -keypass changeit
echo "[Client] - Génération du keystore : OK"

# Génération de la demande de certificat (CSR) pour le client
keytool -certreq \
  -alias KeyAlias \
  -keystore client/keystore.jks \
  -file client/certificat_request.csr \
  -storepass changeit
echo "[Client] - Génération de la demande de certification : OK"

# La CA signe la demande de certificat du client
openssl x509 -req \
  -in client/certificat_request.csr \
  -CA CA/ca.crt -CAkey CA/ca.key -CAcreateserial \
  -out client/certificat_signed.cer -days 365 -sha256
echo "[CA] - Signature de la demande de certificat : OK"

# Importation du certificat de la CA dans le keystore du client
keytool -import \
  -trustcacerts \
  -alias SimulatedCA \
  -file CA/ca.crt \
  -keystore client/keystore.jks \
  -noprompt \
  -storepass changeit
echo "[Client] - Import du certificat du CA : OK"

# Importation du certificat signé dans le keystore du client
keytool -import \
  -alias KeyAlias \
  -keystore client/keystore.jks \
  -file client/certificat_signed.cer \
  -noprompt \
  -storepass changeit
echo "[Client] - Import du certificat signé : OK"

# Exportation du certificat signé pour distribution
keytool -export \
  -alias KeyAlias \
  -keystore client/keystore.jks \
  -file client/certificat.cer \
  -storepass changeit
echo "[Client] - Export du certificat signé : OK"

##########################################

cd  ./client/

# Compile notre fichier java
javac ./Source.java
echo "[Client] - Compilation du .java : OK"

# Créer un fichier MANIFEST.MF avec l'attribut Main-Class
echo "Main-Class: Source" > ./MANIFEST.MF

# Créé le fichier Jar non signé
jar cmf ./MANIFEST.MF ./Source.jar ./Source.class
echo "[Client] - Creation du fichier .jar : OK"

# Convertis en fichier jar signé
jarsigner -keystore ./keystore.jks \
  -storepass changeit \
  -signedjar ./Source_Signed.jar ./Source.jar KeyAlias
echo "[Client] - Creation du fichier .jar signé : OK"

# Supprime les artéfacts
rm ./Source.class ./Source.jar ./MANIFEST.MF

# On peut vérifier que notre certificat est bien valide
jarsigner -verify ./Source_Signed.jar
echo "[Client] - Vérification du certificat : OK"

cd ..

# Executer le jar signé
java -jar ./client/Source_Signed.jar
