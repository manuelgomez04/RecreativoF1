insert into presupuesto (id_presupuesto, gastos_fijos, gastos_variables, ingresos_fijos, ingresos_variables, presupuesto_inicial) values (1, 0 , 0 , ROUND(RANDOM()*10000000) , 0 , ROUND(RANDOM()*10000000));

insert into carrera (id, longitud_por_vuelta, longitud_total ,localizacion, nombre_circuito, tipo_asfaltado, descripcion, presupuesto_id_presupuesto, imagen_carrera, num_vueltas, texto_alternativo) values (1, 5.0, 0,  'Mónaco', 'Mónaco', 'Nuevo', 'Debido a su especial configuración con curvas cerradas y rectas cortas, lo que prima en él es la habilidad de los pilotos frente a la potencia de los motores.',1, 'https://lebalap.academy/wp-content/uploads/2021/02/esquema-circuito-de-monaco.png',65, 'Imagen de la carrera');


insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre, foto_coche, texto_alternativo) values (false, ROUND(RANDOM()*20)+1, 1, 1, 'Coche 1','https://i.ebayimg.com/images/g/V04AAOSwPddlMohi/s-l1200.webp', 'Imagen del coche');
insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre, foto_coche, texto_alternativo) values (true, (SELECT posicion_2 FROM (SELECT ROUND(RANDOM() * 20) + 1 AS posicion_2) AS almacenar_resultado WHERE posicion_2 NOT IN (SELECT posicion_carrera FROM Coche) LIMIT 1), 1, 2, 'Coche 2', 'https://i.ebayimg.com/images/g/V04AAOSwPddlMohi/s-l1200.webp', 'Imagen del coche');



insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (1, 'Lucho',  'Abata','23912309b', 16430.99, 20.0, 1, 'usuario', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false,'https://www.aulafacil.com/uploads/cursos/694/editor/l31imagen1.png',0, 'Imagen no encontrada', '1997-03-25');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (2, 'Dory',  'Aivee', '23949345l', 54769.92, 20.0, 1, 'admin', '{bcrypt}$2y$10$t.wCNb.Mw/VgQmc6oi7VA.ampHhvm/rlAY3U1hhgmqGWbdGfoUZc6',true, false,false,'https://imgs.search.brave.com/c0ao0NbcJSc_vkiee6G32RHkc_KVmHla451mG8RO-g0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jb25j/ZXB0by5kZS93cC1j/b250ZW50L3VwbG9h/ZHMvMjAxOC8wOC9w/ZXJzb25hLWUxNTMz/NzU5MjA0NTUyLmpw/Zw',0, 'Imagen no encontrada','1990-06-21');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (3, 'Fernando', 'Alonso', '23949309x', 44096.63, 20.0, 1, 'usuario2', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true, 'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg',0, 'Imagen no encontrada', '1998-12-31');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (4, 'Carlos', 'Sainz', '29567823Y', 72597.04, 20.0, 1, 'usuario3', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true, 'https://cdn-8.motorsport.com/images/mgl/63vnZMbY/s8/carlos-sainz-ferrari.jpg',0, 'Imagen no encontrada', '2004-01-01');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (5, 'Jesús',  'Abata','23912309b', 16430.99, 20.0, 1, 'usuario4', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false,'https://www.aulafacil.com/uploads/cursos/694/editor/l31imagen1.png',0, 'Imagen no encontrada', '2002-02-28');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (6, 'José',  'Aivee', '23949345l', 54769.92, 20.0, 1, 'usuario5', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi',false, true,false,'https://imgs.search.brave.com/c0ao0NbcJSc_vkiee6G32RHkc_KVmHla451mG8RO-g0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jb25j/ZXB0by5kZS93cC1j/b250ZW50L3VwbG9h/ZHMvMjAxOC8wOC9w/ZXJzb25hLWUxNTMz/NzU5MjA0NTUyLmpw/Zw',0, 'Imagen no encontrada','2004-02-22');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (7, 'Miguel', 'Campos', '23949309x', 44096.63, 20.0, 1, 'usuario6', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false, 'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg',0, 'Imagen no encontrada','1973-05-26');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (8, 'Víctor', 'Medina', '29567823Y', 72597.04, 20.0, 1, 'usuario7', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false, 'https://cdn-8.motorsport.com/images/mgl/63vnZMbY/s8/carlos-sainz-ferrari.jpg',0, 'Imagen no encontrada','1998-10-31');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (9, 'Carlos',  'Román','23912309b', 16430.99, 20.0, 1, 'usuario8', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false,'https://www.aulafacil.com/uploads/cursos/694/editor/l31imagen1.png',0, 'Imagen no encontrada', '1996-09-30');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (10, 'Bruno',  'Delgado', '23949345l', 54769.92, 20.0, 1, 'usuario9', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi',false, true,false,'https://imgs.search.brave.com/c0ao0NbcJSc_vkiee6G32RHkc_KVmHla451mG8RO-g0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jb25j/ZXB0by5kZS93cC1j/b250ZW50L3VwbG9h/ZHMvMjAxOC8wOC9w/ZXJzb25hLWUxNTMz/NzU5MjA0NTUyLmpw/Zw',0, 'Imagen no encontrada','1988-06-16');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (11, 'Moisés', 'Dorado', '23949309x', 44096.63, 20.0, 1, 'usuario10', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false, 'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg',0, 'Imagen no encontrada', '1970-01-18');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado, texto_alternativo, fecha_nacimiento) values (12, 'Pedro', 'Sánchez', '29567823Y', 72597.04, 20.0, 1, 'usuario11', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false, 'https://cdn-8.motorsport.com/images/mgl/63vnZMbY/s8/carlos-sainz-ferrari.jpg',0, 'Imagen no encontrada', '1989-05-30');





insert into jefe_equipo (id_empleado) values (2);

insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (1, 'Motor', 15, 150000.0, 'Honda', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (2, 'Alerón delantero', 15, 200000.0, 'Ferrari', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (3, 'Alerón trasero', 15, 50000.0, 'RedBull', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (4, 'Fondo Plano', 15, 225000.0, 'Mclaren', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (5, 'Chasis', 15, 299999.0, 'Mercedes', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (6, 'Discos de freno', 15, 150000.0, 'Sauber', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (7, 'DRS', 15, 200000.0, 'Hass', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (8, 'Batería', 15, 175000.0, 'Endesa', 1,1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (9, 'Neumáticos', 15, 180000.0, 'Michelín', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (10, 'Motor', 15, 150000.0, 'Honda', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (11, 'Alerón delantero', 15, 200000.0, 'Ferrari', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (12, 'Alerón trasero', 15, 50000.0, 'RedBull', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (13, 'Fondo Plano', 15, 225000.0, 'Mclaren', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (14, 'Chasis', 15, 299999.0, 'Mercedes', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (15, 'Discos de freno', 15, 150000.0, 'Sauber', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (16, 'DRS', 15, 200000.0, 'Hass', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (17, 'Batería', 15, 175000.0, 'Endesa', 1,2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (18, 'Neumáticos', 15, 180000.0, 'Michelín', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (19, 'Motor', 15, 150000.0, 'Honda', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (20, 'Alerón delantero', 15, 200000.0, 'Ferrari',1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (21, 'Alerón trasero', 15, 50000.0, 'RedBull', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (22, 'Fondo Plano', 15, 225000.0, 'Mclaren', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (23, 'Chasis', 15, 299999.0, 'Mercedes', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (24, 'Discos de freno', 15, 150000.0, 'Sauber', 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (25, 'DRS', 15, 200000.0, 'Hass', 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (26, 'Batería', 15, 175000.0, 'Endesa', 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (27, 'Neumáticos', 15, 180000.0, 'Michelín', 1,2, false);


insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 1);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 5);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 6);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 7);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 8);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (2, 9);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (2, 10);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (2, 11);
insert into mecanico(coche_mecanico_id_coche, id_empleado) values (2, 12);



insert into piloto (coche_piloto_id_coche, id_empleado) values (1, 3);
insert into piloto (coche_piloto_id_coche, id_empleado) values (2, 4);



ALTER SEQUENCE empleado_seq RESTART WITH (62);
ALTER SEQUENCE coche_seq RESTART WITH (52);
ALTER SEQUENCE componente_seq RESTART WITH (77);
ALTER SEQUENCE presupuesto_seq RESTART WITH (59);
ALTER SEQUENCE carrera_seq RESTART WITH (51);

