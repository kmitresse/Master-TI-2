# Master-TI-2
Dans ce dossier, vous trouverez les résultats pour l'ensemble des td/tp du master Technologies de l'internet de l'université de Pau.<br>
Ces travaux couvrent l'ensemble des exercices de la promotion suivante:<br>
M2 : 2024-2025

## Organisation des branches :
Les cours, les TD et les TP seront disponible sur la branche principale: __main__ 

Les projets de chaques bînomes seront sous forme de sous projets que nous relierons au projet de initial:

## Commit :
Chaque commit effectué doit être nommé en respectant le format suivant: <br>
[**conventionWord**] : Nom UE - Rapide description

***Exemple:*** [feat] : Prog Android - TD1 : Exo 1 à 3 ajoutés

### ConventionWord :<br> 
 - Feat    -> Amène une nouvelle fonctionnalité<br>
 - Fix     -> Corrige un bogue dans le code<br>
 - Refacto -> Factorisation / Optimisation du code + Mise en forme des fichiers texte 
 - Add     -> Ajout de documents (slide, sujet de TD / TP)
 - Draft   -> Test / Brouillon
 


--------------------------------------------------------------
## Liste des tutos github

Un site très intéréssant pour avoir les bases de github : 
[Learn git Branching](https://learngitbranching.js.org/?locale=fr_FR)

[Transferer un projet vers un repo github](/Tutoriels/Git/Transfer_repo.md)
[Les bases du git](/Tutoriels/Git/Base_git.md)
[Synchroniser gitHub et gitLab](/Tutoriels/Git/Synchronize_github_&_gitlab_repo.md)

___ATTENTION___ : Pensez à toujours effectuer un pull avant de faire quoi que ce soit sur le git. En cas d'oubli ajouter l'option --rebase pour faire remonter votre travail (meilleure solution mais pas sans risque de perdre ce que vous avez fait)

```bash
##### Avant de travailler #####

# Récupération des travaux sur le git
git pull 

# Récupération des travaux si le pull n'a pas été fait en amont
git pull --rebase

##### Après tout travaux ######

# Lister tout les éléments modifiés
git status

# Préparer les fichiers pour un commit (*)
git add fichier_1 fichier_2 ... # Juste quelques fichiers par commit
git add .                       # Tout les fichiers sur un seul commit

# Préparer le commit (**)
git commit -m "mon message de commit"

# Pousser le(s) commit(s)
git push

```

___Remarque___ : Il est possible de push plusieurs commmit en même temps. Pour cela au lieu d'ajouter tout les fichiers en un seul commit, répetez les actions (*) et (**) avant de push

Exemple :
```bash
$ git status
> modified : fichier_1.py
             fichier_2.py
             fichier_3.py
  added    : ReadMe.md

$ git add ReadMe.md
> 
$ git commit -m "[add} - Ajout d'un readMe"
>
$ git add fichier_1.py fichier_2.py
>
$ git commit -m "[feat] - Modification principale"
>
$ git add fichier_3.py
>
$ git commit -m "[refacto] - Modification secondaire"
>
$ git push
```