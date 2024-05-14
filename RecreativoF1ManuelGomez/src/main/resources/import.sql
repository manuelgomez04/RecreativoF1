insert into presupuesto (id_presupuesto, gastosfijos, gastosvariables, ingresos_fijos, ingresos_variables) values (1, 200, 500, 34, 67);

insert into carrera (id, longitud_por_vuelta, longitud_total, localizacion, nombre_circuito, tipo_asfaltado, descripcion, presupuesto_id_presupuesto, imagen_carrera) values (1, 5.0, 55, 'Mónaco', 'Mónaco', 'Nuevo', 'Debido a su especial configuración con curvas cerradas y rectas cortas, lo que prima en él es la habilidad de los pilotos frente a la potencia de los motores.',1, 'https://lebalap.academy/wp-content/uploads/2021/02/esquema-circuito-de-monaco.png');


insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre, foto_coche) values (false, 2, 1, 1, 'Coche 1','https://i.ebayimg.com/images/g/V04AAOSwPddlMohi/s-l1200.webp');
insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre, foto_coche) values (true, 3, 1, 2, 'Coche 2','https://i.ebayimg.com/images/g/V04AAOSwPddlMohi/s-l1200.webp');


insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto) values (1, 'Lucho', 'Sutherden', 'Abata', 16430.99, 20.0, 1, 'juanjo', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false,'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto) values (2, 'Dory', 'Thieme', 'Aivee', 54769.92, 20.0, 1, 'jefe', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi',true, false,false,'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto, foto) values (3, 'Grissel', 'Macallam', 'Yoveo', 44096.63, 20.0, 1, 'piloto1', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true, 'https://cdn-4.motorsport.com/images/mgl/0ZRQbbN0/s800/fernando-alonso-aston-martin-r.jpg');
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto, foto) values (4, 'Blondie', 'Simenot', 'Skyndu', 72597.04, 20.0, 1, 'piloto2', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true, 'https://cdn-8.motorsport.com/images/mgl/63vnZMbY/s8/carlos-sainz-ferrari.jpg');





insert into jefe_equipo (id_empleado) values (2);

insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (1, 'Motor', 15, 1500.0, 'Honda', 1, 1,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (2, 'Motor', 15, 1500.0, 'Honda', 1, 2,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (3, 'Motor', 15, 1500.0, 'Honda', 1, 1,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (4, 'Motor', 15, 1500.0, 'Honda', 1, 2,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (5, 'Motor', 15, 1500.0, 'Honda', 1, 1,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (6, 'Motor', 15, 1500.0, 'Honda', 1, 2,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (7, 'Motor', 15, 1500.0, 'Honda', 1, 1,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (8, 'Motor', 15, 1500.0, 'Honda', 1, 2,2);
insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (9, 'Motor', 15, 1500.0, 'Honda', 1, 1,2);


insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 1);

insert into piloto (posicion_carrera, coche_piloto_id_coche, id_empleado) values (5, 1, 3);
insert into piloto (posicion_carrera, coche_piloto_id_coche, id_empleado) values (5, 2, 4);



ALTER SEQUENCE empleado_seq RESTART WITH (60);
ALTER SEQUENCE coche_seq RESTART WITH (52);
ALTER SEQUENCE componente_seq RESTART WITH (59);
ALTER SEQUENCE presupuesto_seq RESTART WITH (59);
ALTER SEQUENCE carrera_seq RESTART WITH (51);

