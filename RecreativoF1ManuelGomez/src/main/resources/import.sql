insert into presupuesto (id_presupuesto, gastos_fijos, gastos_variables, ingresos_fijos, ingresos_variables, presupuesto_inicial) values (1, 0 , 0 , ROUND(RANDOM()*10000000) , 0 , ROUND(RANDOM()*10000000));

insert into carrera (id, longitud_por_vuelta, longitud_total ,localizacion, nombre_circuito, tipo_asfaltado, descripcion, presupuesto_id_presupuesto, imagen_carrera, num_vueltas) values (1, 5.0, 0,  'Mónaco', 'Mónaco', 'Nuevo', 'Debido a su especial configuración con curvas cerradas y rectas cortas, lo que prima en él es la habilidad de los pilotos frente a la potencia de los motores.',1, 'https://lebalap.academy/wp-content/uploads/2021/02/esquema-circuito-de-monaco.png',65);


insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre, foto_coche) values (false, ROUND(RANDOM()*20)+1, 1, 1, 'Coche 1','https://i.ebayimg.com/images/g/V04AAOSwPddlMohi/s-l1200.webp');
insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre, foto_coche) values (true, (SELECT posicion_2 FROM (SELECT ROUND(RANDOM() * 20) + 1 AS posicion_2) AS almacenar_resultado WHERE posicion_2 NOT IN (SELECT posicion_carrera FROM Coche) LIMIT 1), 1, 2, 'Coche 2', 'https://i.ebayimg.com/images/g/V04AAOSwPddlMohi/s-l1200.webp');



insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado) values (1, 'Lucho', 'Sutherden', 'Abata', 16430.99, 20.0, 1, 'juanjo', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false,'https://www.aulafacil.com/uploads/cursos/694/editor/l31imagen1.png',0);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado) values (2, 'Dory', 'Thieme', 'Aivee', 54769.92, 20.0, 1, 'jefe', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi',true, false,false,'https://www.aulafacil.com/uploads/cursos/694/editor/l31imagen1.png',0);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado) values (3, 'Grissel', 'Macallam', 'Yoveo', 44096.63, 20.0, 1, 'piloto1', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true, 'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg',0);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto, incentivo_calculado) values (4, 'Blondie', 'Simenot', 'Skyndu', 72597.04, 20.0, 1, 'piloto2', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true, 'https://cdn-8.motorsport.com/images/mgl/63vnZMbY/s8/carlos-sainz-ferrari.jpg',0);





insert into jefe_equipo (id_empleado) values (2);

insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (1, 'Motor', 15, 15000.0, 'Honda', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (2, 'Alerón delantero', 15, 1500.0, 'Ferrari', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (3, 'Alerón trasero', 15, 1500.0, 'RedBull', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (4, 'Fondo Plano', 15, 1500.0, 'Mclaren', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (5, 'Chasis', 15, 1500.0, 'Mercedes', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (6, 'Discos de freno', 15, 1500.0, 'Sauber', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (7, 'DRS', 15, 1500.0, 'Hass', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (8, 'Batería', 15, 1500.0, 'Endesa', 1, 2,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado, esta_daniado) values (9, 'Neumáticos', 15, 1500.0, 'Michelín', 1, 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (10, 'Motor', 15, 15000.0, 'Honda', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (11, 'Alerón delantero', 15, 1500.0, 'Ferrari',1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (12, 'Alerón trasero', 15, 1500.0, 'RedBull', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (13, 'Fondo Plano', 15, 1500.0, 'Mclaren', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (14, 'Chasis', 15, 1500.0, 'Mercedes', 1, 2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (15, 'Discos de freno', 15, 1500.0, 'Sauber', 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (16, 'DRS', 15, 1500.0, 'Hass', 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (17, 'Batería', 15, 1500.0, 'Endesa', 1,2, false);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, jefe_componente_id_empleado, esta_daniado) values (18, 'Neumáticos', 15, 1500.0, 'Michelín', 1,2, false);


insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 1);

insert into piloto (coche_piloto_id_coche, id_empleado) values (1, 3);
insert into piloto (coche_piloto_id_coche, id_empleado) values (2, 4);



ALTER SEQUENCE empleado_seq RESTART WITH (60);
ALTER SEQUENCE coche_seq RESTART WITH (52);
ALTER SEQUENCE componente_seq RESTART WITH (68);
ALTER SEQUENCE presupuesto_seq RESTART WITH (59);
ALTER SEQUENCE carrera_seq RESTART WITH (51);

