# NutriCI

Mini-projet de Génie Logiciel réalisé en binôme.

NutriCI est une application full-stack de gestion et de consultation de compléments alimentaires. Le backend expose une API REST Spring Boot et le frontend utilise uniquement HTML, CSS et JavaScript natif avec `fetch()`, sans framework frontend.

## Membres du binôme

- Kple David — compte GitHub `trackssp`
- Abdoul Kone — compte GitHub `memoblknetflix-debug`

## Technologies

- Java 17
- Spring Boot 4.0.7
- Maven
- Spring Web MVC
- Spring Data JPA / Hibernate
- MySQL ou MariaDB avec XAMPP
- HTML5, CSS3 et JavaScript natif
- Postman pour la validation de l’API
- JUnit pour les tests

## Configuration de la base de données

- Nom de la base : `nutrici`
- Serveur : `localhost`
- Port : `3306`
- Utilisateur : `root`
- Mot de passe : vide

Configuration utilisée dans `nutrici-api/src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nutrici?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

## Procédure d’installation et de déploiement local

### 1. Prérequis

Installer :

- JDK 17
- XAMPP avec MySQL/MariaDB
- Git

### 2. Récupérer le projet

```bash
git clone https://github.com/trackssp/NutriCI.git
cd NutriCI
```

### 3. Préparer la base de données

1. Ouvrir XAMPP Control Panel.
2. Démarrer MySQL.
3. Ouvrir `http://localhost/phpmyadmin`.
4. Cliquer sur **Importer**.
5. Sélectionner le fichier `nutrici.sql` situé à la racine du projet.
6. Lancer l’importation.

Le script crée la base `nutrici`, la table `produit` et un catalogue de 40 produits de démonstration.

## Comptes de démonstration

### Administrateur

- Email : `admin@nutrici.com`
- Mot de passe : `123456`
- Rôle : `ADMIN`

### Client

- Email : `client@nutrici.com`
- Mot de passe : `client123`
- Rôle : `CLIENT`

### 4. Lancer les tests

Sous Windows :

```powershell
cd nutrici-api
.\mvnw.cmd test
```

Résultat attendu :

```text
BUILD SUCCESS
```

### 5. Lancer l’application

Sous Windows :

```powershell
cd nutrici-api
.\mvnw.cmd spring-boot:run
```

Attendre le message indiquant que Tomcat a démarré sur le port `8080`.

### 6. Ouvrir l’application

- Interface web : `http://localhost:8080`
- Liste JSON des produits : `http://localhost:8080/api/produits`

## Fonctionnalités

- consultation du catalogue ;
- recherche et filtrage des produits ;
- gestion des alertes de stock ;
- gestion du panier et calcul du total ;
- gestion des commandes ;
- paiement, livraison et historique ;
- comptes utilisateurs et authentification ;
- favoris, avis et notifications ;
- promotions, nutrition et statistiques.

## API et tests Postman

Les scénarios Postman sont disponibles dans le dossier `postman`. Ils permettent notamment de tester les produits, le panier, les commandes et le paiement.

## Frontend sans framework

L’interface se trouve dans :

```text
nutrici-api/src/main/resources/static/index.html
```

Elle est développée uniquement en HTML, CSS et JavaScript natif. Aucun framework frontend n’est utilisé.

## Preuve du travail en binôme

Les branches, commits et pull requests du dépôt GitHub conservent l’historique des contributions des deux membres du binôme.
