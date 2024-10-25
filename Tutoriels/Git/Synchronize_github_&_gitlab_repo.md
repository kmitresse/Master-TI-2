# Synchroniser son travail sur deux dépôt git d'hebergeur différents (GitLab & GitHub)

## GitLab -> GitHub

- Depuis l'interface gitlab, selectionner le projet et se diriger vers la page "settings -> repository"

- Ouvrir l'onglet "mirrorir repository" puis cliquer sur "add new"

- Vous devrez ensuite donner un nom à ce miroir, l'adresse du dépôt github et vos identifiants de connexion github

___Remarque___ : Github ne validera pas la connexion si vous utilisez votre mot de passe personnel. Vous devez renseigner ici un token que vous aurez généré depuis github. Ce token doit permttre les droit de lecture, d'ecriture, de pull et de push. 

- Valider et c'est gagné.

## Github -> GitLab

Github ne propose pas de système de miroir, il va falloir passer par un workflow de type action.

# SUITE EN CONSTRUCTION