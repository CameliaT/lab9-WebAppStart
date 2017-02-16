CREATE TABLE recepes (
    id bigserial NOT NULL PRIMARY KEY,
    type character (20),
    name character(20),
    ingredients character (600),
    instructions character (300),
    duration character (30),
    date DATE not null default CURRENT_DATE,

);


INSERT INTO recipes ( name, ingredients, instructions, duration) VALUES ('Omleta in pita', '1 lingurita de ulei,2 linguri de ceapa tocata marunt, 1/4 ceasca de ardei rosu tocat marunt, 2 oua, sare, piper, 2 linguri branza feta maruntita, 2 linguri de humus' 'Se amesteca ingredientele (mai putin humusul) ca pentru omleta si se prajeste. Omleta se introduce in pita taiata partial pe jumatate', '30 minute', '2017-01-15');
