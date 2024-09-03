# Transferer un sous dossier d'un repo git vers un repo github

Ce tuto permet de récuperer un projet sur une branche et de transferer l'integraliter des commits sur le projet

### ___Attention:___ Si vous n'êtes pas sur de vos manipulation, faite un fork du repo initial et effectuez les démarches depuis ce fork afin de ne pas altérer le git. Pensez à supprimer le fork par la suite si vous n'en avez plus besoin

#### Etape 1 : Installer git-filter

```bash
pip install git filter
```

#### Etape 2 : Se placer sur le repo et sur la branche ou se trouve le projet

```bash
# Si besoin cloner le repo git
    # Depuis ssh (si vous avez renseigné une clé ssh sur gitlab)
git clone git@git.univ-pau.fr:kmitresse/Master-TI-2.git

    # Depuis https
git clone https://git.univ-pau.fr/kmitresse/Master-TI-2.git

# Se placer dans le repo
cd  Master-TI-2

# Se placer sur la bonne branche
git checkout nom_de_la_branche_du_projet
```

#### Etape 3 : Isoler les commits concernant le projet dans l'historique des commit

```bash
git filter-repo --path votre/sous_dossier --force

# Vérifier la liste commits isolés si besoin
git log --oneline
```
! Ne pas fermer cette fenêtre

#### Etape 4 : Préparer le repo git depuis gitHub

Sur github, créer un nouveau projet vide et sans readMe (!très important).
Générer ensuite un token : 
- Aller dans setting -> Developper settings -> Personnal access Token 
- Cliquer sur générer un nouveau Token 
- Donner un nom à ce token et une date d'expiration de ce token
- Cliquer sur générer Token 

Un token devrait maintenant apparaître. Attention, il n'apparaitra qu'une seule fois, si vous souhaitez le réutiliser, conservez le dans une note protégée car sinon vous devrez en regénerer un.

Pour les besoin du tuto nous appelerons le token: TOKEN

#### Transferer le projet

Revenir sur votre console bash

```bash
# Ajouter le nouveau dépôt gitHub comme dépôt distant
    # Avec ssh (si vous avez renseigné une clé ssh sur github)
git remote add origin git@github:nom_utilisateur_github/nom_nouveau_depot.git
    # Avec https
git remote add origin https://github.com/nom_utilisateur/nom_nouveau_depot.git

# Pousser les commits
git push -u
```
A ce stade, il est demander de renseigner ses identifiants de connexion gitHub

- Username :  Votre nom d'utilisateur gitHub
- Password :  TOKEN

#### Conclusion

Normalement vous devriez avoir votre projet sur github sans avoir altéré le repo initial. Il vous suffira ensuite de cloner votre nouveau repo github afin de refacto les dossiers. En effet votre projet sur github devrait suivre l'arborescence originale

Nom_UE/Projet/*

Vous pouvez ainsi refacto pour mettre le contenu de * à la racine du projet