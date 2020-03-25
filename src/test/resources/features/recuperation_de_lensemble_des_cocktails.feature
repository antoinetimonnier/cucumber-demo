Feature: récupération de l'ensemble des cocktails
    Scénarios liés à la récupération des cocktails (GET)

  Scenario: Création puis récupération de l'ensemble des cocktails (uid:522f4420-e767-45e0-bf62-71d423af8e89)
    Given la base de donnée est vide
    And le client crée un cocktail avec le nom "Mojito" et le prix 10
    When le client récupère lensemble des cocktails
    Then le client doit avoir un retour avec status 200
    And la liste de cocktail doit contenir 1 cocktail avec le nom "Mojito" et le prix 10
