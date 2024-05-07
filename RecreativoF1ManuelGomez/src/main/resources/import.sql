insert into carrera (id, longitud_por_vuelta, longitud_total, localizacion, nombre_circuito, tipo_asfaltado) values (1, 5.0, 55, 'Monaco', 'Monaco', 'Nuevo');

insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (1, 'Lucho', 'Sutherden', 'Abata', 16430.99, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (2, 'Dory', 'Thieme', 'Aivee', 54769.92, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (3, 'Grissel', 'Macallam', 'Yoveo', 44096.63, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (4, 'Blondie', 'Simenot', 'Skyndu', 72597.04, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (5, 'Berkeley', 'Mawdsley', 'Yamia', 24000.62, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (6, 'Chucho', 'Burree', 'Jabbercube', 70437.55, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (7, 'Jo-anne', 'Hudspeth', 'Dabfeed', 9409.82, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (8, 'Shea', 'Roobottom', 'Jetwire', 73821.48, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (9, 'Cele', 'Gathercoal', 'Viva', 99070.69, 20.0, 1);
insert into empleado (id_empleado, nombre, apellidos, dni, salario, incentivo, carrera_empleado_id) values (10, 'Kane', 'MacMurray', 'Kamba', 26255.46, 20.0, 1);


insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche) values (false, 2, 1, 1);
insert into coche (esta_daniado, posicion_carrera, carrera_coche_id, id_coche) values (false, 3, 1, 2);


insert into jefe_equipo (id_empleado) values (2);

insert into componente (id_componente, tipo_componente, durabilidad, precio, marca, carrera_componente_id, coche_componente_id_coche, jefe_componente_id_empleado) values (1, 'Motor', 15, 1500.0, 'Honda', 1, 1,2);


insert into mecanico(coche_mecanico_id_coche, id_empleado) values (1, 1);

insert into piloto (posicion_carrera, coche_piloto_id_coche, id_empleado) values (5, 1, 3);
insert into piloto (posicion_carrera, coche_piloto_id_coche, id_empleado) values (5, 2, 4);


ALTER SEQUENCE empleado_seq RESTART WITH (60);

