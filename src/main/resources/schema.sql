DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS recipes;

CREATE TABLE recipes(
                        recipe_id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
                        recipe_name varchar(255) not null,
                        recipe_description varchar(255) not null
);

CREATE TABLE ingredients(
                            ingredient_id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
                            name varchar(255) NOT NULL,
                            quantity integer not null,
                            recipe_id uuid NOT NULL,
                            recipe_key integer not null,
                            FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id)
);