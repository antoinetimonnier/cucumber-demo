Feature: récupération des cocktails contenant un ingrédient particulier
    Scénarios liés à la récupération des cocktails contenant un ingrédient passé en paramètre (POST /ingredient)

  Scenario: Récupération des cocktails contenant un ingrédient particulier (uid:11a11067-d05f-48cd-912f-4f6dc98b4a3f)
    Given la base de donnée est vide
    And Le client ajoute les cocktails suivants :
      | nom | prix | ingredients |
      | mojito | 7 | [{''nom'':''menthe'', ''containsAlcool'': false},{''nom'':''rhum'', ''containsAlcool'': true}, {''nom'':''perrier'', ''containsAlcool'': false}, {''nom'':''citron vert'', ''containsAlcool'': false},{''nom'':''sucre canne'', ''containsAlcool'': false}] |
      | Daiquiri | 5 | [{''nom'':''rhum'', ''containsAlcool'': true},{''nom'':''citron vert'', ''containsAlcool'': false},{''nom'':''sucre canne'', ''containsAlcool'': false},{''nom'':''glace pilée'', ''containsAlcool'': false}] |
      | Tequila sunrise | 8 | [{''nom'':''tequila'', ''containsAlcool'': true},{''nom'':''grenadine'', ''containsAlcool'': false},{''nom'':''citron'', ''containsAlcool'': false},{''nom'':''jus orange'', ''containsAlcool'': false}, {''nom'':''citron vert'', ''containsAlcool'': false}] |
    When le client récupère lensemble des cocktails avec comme ingrédient "rhum"
    Then le client doit avoir un retour avec status 200
    And le client doit avoir en retour les cocktails suivants :
      | nom | prix | ingredients |
      | mojito | 7 | [{''nom'':''menthe'', ''containsAlcool'': false},{''nom'':''rhum'', ''containsAlcool'': true}, {''nom'':''perrier'', ''containsAlcool'': false}, {''nom'':''citron vert'', ''containsAlcool'': false},{''nom'':''sucre canne'', ''containsAlcool'': false}] |
      | Daiquiri | 5 | [{''nom'':''rhum'', ''containsAlcool'': true},{''nom'':''citron vert'', ''containsAlcool'': false},{''nom'':''sucre canne'', ''containsAlcool'': false},{''nom'':''glace pilée'', ''containsAlcool'': false}] |

  Scenario: Récupération des cocktails contenant un ingrédient qui nexiste pas en BDD (uid:ca8a0482-e797-4cac-94ca-b231f51dd3f6)
    Given la base de donnée est vide
    When le client récupère lensemble des cocktails avec comme ingrédient "rhum"
    Then le client doit avoir un retour avec status 400
    And le client doit avoir un retour avec une error "Bad Request"
    And le message de lexception doit être "L'ingrédient rhum n'existe pas"
