drop table cocktail_ingredient if exists cascade;
drop table cocktail if exists cascade;
drop table ingredient if exists cascade;

CREATE TABLE IF NOT EXISTS cocktail (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  prix BIGINT NOT NULL,
  CONSTRAINT UC_cocktail UNIQUE (nom,prix)
);

CREATE TABLE IF NOT EXISTS ingredient (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  contains_alcool boolean NOT NULL,
  CONSTRAINT UC_ingredient UNIQUE (nom,contains_alcool)
);

CREATE TABLE IF NOT EXISTS cocktail_ingredient (
  id_cocktail INT NOT NULL,
  id_ingredient INT NOT NULL,
  primary key (id_cocktail, id_ingredient),
  foreign key (id_cocktail) references cocktail(id),
  foreign key (id_ingredient) references ingredient(id)
);