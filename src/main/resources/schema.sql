CREATE TABLE IF NOT EXISTS cocktail (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  prix BIGINT NOT NULL,
  CONSTRAINT UC_cocktail UNIQUE (id,nom)
);

CREATE TABLE IF NOT EXISTS ingredient (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  is_alcool boolean NOT NULL,
  quantite INT NOT NULL,
  id_cocktail INT NOT NULL,
  foreign key (id_cocktail) references cocktail(id)
);