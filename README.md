
 # cucumber-demo
 
 Ce projet est un projet de démonstration pour l'utilisation de **cucumber**.
 Il contient une api rest en **springboot 2** et **Java 11** avec une bdd embarquée **H2**.
 
 L'api "cocktail" expose 3 endpoints :
 - **GET** sur /api/cocktails => récupération de l'ensemble des cocktails
 - **POST** sur /api/cocktails => enregistrement d'un cocktail et de ses ingrédients
 - **POST** sur /api/cocktails/ingredient => récupération des cocktails contenant l'ingrédient passé dans le body de la requête
 
 Ci-dessous un schéma d'architecture du projet :
 ![Test Image 1](https://github.com/antoinetimonnier/cucumber-demo/blob/master/src/main/resources/images/architecture_api.png)
 
 Ci-dessous un schéma des entités de la partie DAO :
 ![Test Image 2](https://github.com/antoinetimonnier/cucumber-demo/blob/master/src/main/resources/images/uml_cocktails.png)
 
 ## Test cucumbers
 
 La partie test est gérée en **B**ehavior **D**riven **D**evelopment via **Cucumber**
 
 Ci-dessous un schéma explicatif de l'architecture de la partie test :
 ![Test Image 2](https://github.com/antoinetimonnier/cucumber-demo/blob/master/src/main/resources/images/cucumber_testing.png)
