CREATE TABLE recipe (
    id bigserial NOT NULL PRIMARY KEY,
    type character (20),
    name character(40),
    ingredients character (1000),
    instructions character (1000),
    duration character (30)

);


INSERT INTO recipe ( type, name, ingredients, instructions, duration)
VALUES ('Breakfast', 'Omleta in pita', '1 lingurita de ulei,2 linguri de ceapa tocata marunt, 1/4 ceasca de ardei rosu tocat marunt, 2 oua, sare, piper, 2 linguri branza feta maruntita, 2 linguri de humus' 'Se amesteca ingredientele (mai putin humusul) ca pentru omleta si se prajeste. Omleta se introduce in pita taiata partial pe jumatate', '30 minute');

INSERT INTO recipe ( type, name, ingredients, instructions, duration)
VALUES ('Desert', 'Briose cu banane', '2 oua , 1/2 lingurita esenta de vanilie,  110 g zahar brun, 2 banane mari coapte, pasate,  50 ml ulei vegetal,  60 ml lapte integral 3,5% grasime,  170 g faina integrala,  1 lingurita praf de copt,  1/2 lingurita scortisoara', 'Cuptorul se incalzeste la 180 grade Celsius. Hartia pentru briose se repartizeaza in formele tavii de briose.  Ouale se bat bine cu zaharul si esenta de vanilie, apoi se adauga banana, laptele si uleiul. Faina se amesteca cu praful de copt si scortisoara si se adauga in bolul cu oua si banane, omogenizandu-se. Se toarna compozitia in forme.', '30 minute');

DELETE FROM recipe
WHERE name = null;