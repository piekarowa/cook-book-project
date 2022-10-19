insert into recipe (id, recipe_name, description, ingredients, directions, tag, release_date) values (1, 'sernik', 'z malinami', 'twaróg, jaja, masło, maliny, cukier', 'wymieszać, upiec', 'ciasto', '2021-12-23');
insert into recipe (id, recipe_name, description, ingredients, directions, tag, release_date) values (2, 'zupa ogórkowa', 'zupa z kiszonych ogórków', 'ogórki kiszone, bulion, masło', 'gotować na wolnym ogniu', 'zupa', '2021-10-23');
insert into recipe (id, recipe_name, description, ingredients, directions, tag, release_date) values (3, 'bułki', 'pszenne z otrębami', 'mąka, mleko, drożdże, cukier, sól', 'wymieszać, upiec', 'pieczywo', '2021-12-10');
insert into recipe (id, recipe_name, description, ingredients, directions, tag, release_date) values (4, 'jabłecznik', 'z kruszonką', 'mąka, jabłka, masło, cukier', 'wymieszać, upiec', 'ciasto', '2021-12-13');
insert into recipe (id, recipe_name, description, ingredients, directions, tag, release_date) values (5, 'sernik', 'z karmelem', 'twaróg, jaja, masło, karmel, cukier', 'wymieszać, upiec', 'ciasto', '2021-12-23');

insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'USER');

insert into user (id, username, email, password) values(1, 'admin', 'admin@gmail.com', '$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK');
insert into user (id, username, email, password) values(2, 'user', 'user@gmail.com', '$2a$10$m7BBzoGFKzb8e3/q5AK/SuC.qNKnyh.GcHkKnJYXsvJGQREhZe0Zu');

insert into user_role (user_id, role_id) values(1,1);
insert into user_role (user_id, role_id) values(2,2);

