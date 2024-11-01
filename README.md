# Pokémon API Demo

## Description
Ce projet est une démonstration d'une API Spring Boot qui permet de récupérer des informations sur les Pokémon à partir d'un fichier JSON. L'application expose un endpoint qui retourne les détails d'un Pokémon en fonction de son numéro.

## Fonctionnalités
- Lecture d'un fichier JSON contenant des données sur les Pokémon
- Endpoint REST pour récupérer les informations d'un Pokémon spécifique
- Gestion des erreurs pour les cas de fichier non trouvé, erreurs d'E/S et erreurs de parsing

## Technologies utilisées
- Java
- Spring Boot
- JSON Simple

## Installation
1. Clonez ce dépôt
2. Assurez-vous d'avoir Java et Maven installés sur votre machine
3. Placez le fichier `pokedexgenonecards.json` dans le dossier `assets` à la racine du projet

## Utilisation
1. Lancez l'application avec la commande : `mvn spring-boot:run`
2. Accédez à l'API via `http://localhost:8080/hello?pokemonNb=X` où X est le numéro du Pokémon

## Exemple

GET http://localhost:8080/hello?pokemonNb=1

Retournera les informations du premier Pokémon dans le fichier JSON.

## Structure du projet
- `DemoApplication.java` : Classe principale contenant la logique de l'application
- `assets/pokedexgenonecards.json` : Fichier JSON contenant les données des Pokémon

## Gestion des erreurs
L'application gère les exceptions suivantes :
- `FileNotFoundException` : Si le fichier JSON n'est pas trouvé
- `IOException` : Pour les erreurs d'entrée/sortie
- `ParseException` : Pour les erreurs de parsing du JSON

## Auteur
Codé avec passion & amour par Elodie GUYARD
