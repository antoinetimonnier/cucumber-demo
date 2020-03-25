SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE ingredient;
TRUNCATE TABLE cocktail;
SET REFERENTIAL_INTEGRITY TRUE;


insert into cocktail (id, nom, prix) values 
(1, 'Mojito', 7),
(2, 'Daiquiri', 5),
(3, 'Tequila sunrise', 8.5),
(4, 'Mosco mule', 9.5);

insert into ingredient (id, nom, contains_alcool) values 
(1,'menthe', false),
(2,'rhum', true),
(3,'perrier', false),
(4,'citron vert', false),
(5,'sucre canne', false),
(6,'glace pilée', false),
(7,'tequila', true),
(8,'grenadine', false),
(9,'citron', false),
(10,'jus d''orange', false),
(11,'vodka', true),
(12,'ginger beer', false);

insert into cocktail_ingredient(id_cocktail, id_ingredient) values
(1,1),(1,2),(1,3),(1,4),(1,5),
(2,2),(2,4),(2,5),(2,6),
(3,7),(3,8),(3,9),(3,10),(3,4),
(4,11),(4,12),(4,4);