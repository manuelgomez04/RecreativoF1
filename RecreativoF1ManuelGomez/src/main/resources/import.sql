insert into presupuesto (id_presupuesto, gastosfijos, gastosvariables, ingresos_fijos, ingresos_variables) values (1, 200, 500, 34, 67);

insert into carrera (id, longitud_por_vuelta, longitud_total, localizacion, nombre_circuito, tipo_asfaltado, descripcion, presupuesto_id_presupuesto) values (1, 5.0, 55, 'Monaco', 'Monaco', 'Nuevo', 'Vaya pasada que es el circuito de mónaco chaval',1);


insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre) values (false, 2, 1, 1, 'Coche 1');
insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche, nombre) values (true, 3, 1, 2, 'Coche 2');


insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto) values (1, 'Lucho', 'Sutherden', 'Abata', 16430.99, 20.0, 1, 'juanjo', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, true, false);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto) values (2, 'Dory', 'Thieme', 'Aivee', 54769.92, 20.0, 1, 'jefe', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi',true, false,false);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id, username, password, is_admin, is_mecanico, is_piloto) values (3, 'Grissel', 'Macallam', 'Yoveo', 44096.63, 20.0, 1, 'piloto1', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id,username, password, is_admin, is_mecanico, is_piloto) values (4, 'Blondie', 'Simenot', 'Skyndu', 72597.04, 20.0, 1, 'piloto2', '{bcrypt}$2y$10$xkjea62LwBUHc9ZdigB8j.Dic/HBXjoFYOqK6J3KqYxiW9SJ6cdyi', false, false, true);





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

