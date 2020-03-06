SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE ingredient;
TRUNCATE TABLE cocktail;
SET REFERENTIAL_INTEGRITY TRUE;


insert into cocktail (id, nom, prix) values 
(1, 'Mojito', 7),
(2, 'Daiquiri', 5),
(3, 'Tequila sunrise', 8.5),
(4, 'Mosco mule', 9.5);

insert into ingredient (id, nom, quantite, is_alcool, id_cocktail) values 
(1,'menthe', 2, false, 1),
(2,'rhum', 8, true, 1),
(3,'perrier', 9, false, 1),
(4,'citron vert', 2, false, 1),
(5,'rhum', 7, true, 2),
(6,'citron vert', 1, false, 2),
(7,'sucre canne', 2, false, 2),
(8,'glace pilée', 3, false, 2),
(9,'tequila', 5, true, 3),
(10,'grenadine', 3, false, 3),
(11,'citron', 6, false, 3),
(12,'jus d''orange', 12, false, 3),
(13,'vodka', 1, true, 4),
(14,'citron vert', 2, false, 4),
(15,'ginger beer', 4, false, 4);


