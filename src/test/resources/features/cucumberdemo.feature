Feature: cucumber-demo
    Scénarios de test pour l'api cocktail

  Scenario Outline: Ajouter un cocktail et vérifier le status de la réponse (<hiptest-uid>)
    L'utilisateur ajoute un cocktail, on doit vérifier que le status de la réponse est bien en 200
    Given la base de donnée est vide
    When Le client ajoute un cocktail avec le nom = "<nom>", le prix = "<prix>", les ingrédients = "<ingredients>"
    Then le client doit avoir un retour avec status 200

    Examples:
      | nom | prix | ingredients | hiptest-uid |
      | mojito | 7 | [{''nom'':''menthe'', ''containsAlcool'': false},{''nom'':''rhum'', ''containsAlcool'': true}, {''nom'':''perrier'', ''containsAlcool'': false}, {''nom'':''citron vert'', ''containsAlcool'': false},{''nom'':''sucre canne'', ''containsAlcool'': false}] | uid:85a67ae5-ea84-4fbb-8b3c-a87d0bf0b236 |
      | Daiquiri | 5 | [{''nom'':''rhum'', ''containsAlcool'': true},{''nom'':''citron vert'', ''containsAlcool'': false},{''nom'':''sucre canne'', ''containsAlcool'': false},{''nom'':''glace pilée'', ''containsAlcool'': false}] | uid:14269a53-7df8-4984-ae0f-05e5fabffc2b |
