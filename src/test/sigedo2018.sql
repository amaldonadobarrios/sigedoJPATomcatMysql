
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (1,'Secretaria',1,1,null,'2018-02-10 16:41:18',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (2,'Jefatura',1,1,null,'2018-02-10 16:41:33',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (3,'Operaciones',1,1,null,'2018-02-10 16:41:45',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (4,'Recursos Humanos',1,1,null,'2018-02-10 16:41:58',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (5,'Logística',1,1,null,'2018-02-10 16:42:25',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (6,'Educación',1,1,null,'2018-02-10 16:42:40',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (7,'Administración',1,1,null,'2018-02-10 16:42:54',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (8,'Economía',1,1,null,'2018-02-10 16:43:02',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (10,'Inteligencia',1,1,0,'2018-02-11 18:49:48',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (11,'Ayudantia',1,1,0,'2018-02-11 18:59:40',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (12,'PSICOLOGÃ­A',1,1,0,'2018-02-11 19:05:29',null);
insert into `oficina`(`id_oficina`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (13,'PSICOLOGIA',1,1,0,'2018-02-11 19:05:54',null);



insert into `perfil`(`id_perfil`,`descripcion`) values (1,'Administrador');
insert into `perfil`(`id_perfil`,`descripcion`) values (2,'Mesa de Partes');
insert into `perfil`(`id_perfil`,`descripcion`) values (3,'Administrativo');
insert into `perfil`(`id_perfil`,`descripcion`) values (4,'Archivador');
insert into `perfil`(`id_perfil`,`descripcion`) values (5,'Jefe');
insert into `perfil`(`id_perfil`,`descripcion`) values (6,'Super Administrador');



insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (1,1,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (2,1,2,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (3,1,3,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (4,2,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (5,2,2,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (6,1,3,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (7,1,3,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (8,2,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (9,2,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (10,1,2,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (11,1,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (12,1,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (13,1,5,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (14,3,1,1);
insert into `centro_trabajo`(`id_centro_trabajo`,`id_unidad`,`id_oficina`,`estado`) values (15,3,5,1);


insert into `clas_contenido_doc`(`id_clas_contenido_doc`,`descripcion`) values (1,'COMÚN');
insert into `clas_contenido_doc`(`id_clas_contenido_doc`,`descripcion`) values (2,'SECRETO');
insert into `clas_contenido_doc`(`id_clas_contenido_doc`,`descripcion`) values (3,'RESERVADO');
insert into `clas_contenido_doc`(`id_clas_contenido_doc`,`descripcion`) values (4,'CONFIDENCIAL');


insert into `unidad`(`id_unidad`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (1,'DIRTIC',1,1,0,'2018-02-02 01:57:20','2018-02-02 02:09:15');
insert into `unidad`(`id_unidad`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (2,'DEXA',1,2,null,'2018-02-02 02:06:55',null);
insert into `unidad`(`id_unidad`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (3,'DIRTIC',1,0,null,'2018-02-02 02:09:14',null);
insert into `unidad`(`id_unidad`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (4,'DINOES',1,1,null,'2018-02-11 13:35:58',null);
insert into `unidad`(`id_unidad`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (5,'DIRANDRO',1,1,0,'2018-02-11 18:07:11',null);
insert into `unidad`(`id_unidad`,`descripcion`,`estado`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`) values (6,'ESCUADRON VERDE',1,1,0,'2018-02-11 18:44:15',null);


insert into `prioridad_doc`(`id_prioridad_doc`,`descripcion`) values (1,'COMÚN');
insert into `prioridad_doc`(`id_prioridad_doc`,`descripcion`) values (2,'URGENTE');
insert into `prioridad_doc`(`id_prioridad_doc`,`descripcion`) values (3,'MUY URGENTE');


insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (1,'Enviado');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (2,'Recibido');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (3,'Derivado');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (4,'Respondido');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (5,'Aprobado');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (6,'Desaprobado');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (7,'Devuelto');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (8,'Contestado');
insert into `estado_movimiento_ht`(`id_estado_movimiento_ht`,`descripcion`) values (9,'Archivado');


insert into `clas_funcion_doc`(`id_clas_funcion_doc`,`descripcion`) values (1,'COMUNES');
insert into `clas_funcion_doc`(`id_clas_funcion_doc`,`descripcion`) values (2,'ESPECIALIZADOS');



insert into `persona`(`id_persona`,`cip`,`ape_pat`,`ape_mat`,`nombres`,`grado`,`dni`,`celular`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`,`id_centro_trabajo`,`estado`) values (1,'31424836','MALDONADO','BARRIOS','ALEXANDER','S1 PNP','44263869','966407298',1,1,'2018-02-09 20:37:29','2018-02-14 01:03:19',2,1);
insert into `persona`(`id_persona`,`cip`,`ape_pat`,`ape_mat`,`nombres`,`grado`,`dni`,`celular`,`usu_reg`,`usu_mod`,`fecha_reg`,`fecha_mod`,`id_centro_trabajo`,`estado`) values (2,'30254531','ALVAREZ','MALDONADO','WALTER','S2 PNP','44342324','966237626',1,1,'2018-02-14 01:32:03','2018-02-14 01:36:41',3,1);


insert into `estado_doc`(`id_estado_doc`,`descripcion`) values (1,'Digitalizado');
insert into `estado_doc`(`id_estado_doc`,`descripcion`) values (2,'Interno');



insert into `usuario`(`id_usuario`,`usuario`,`password`,`id_usuario_crea`,`id_usuario_mod`,`fecha_reg`,`fecha_mod`,`fecha_caducidad`,`dias_vigencia`,`estado`,`id_persona`,`id_perfil`) values (1,'31424836','489d535d29404d2e',1,1,'2018-02-09 02:16:21','2018-02-14 01:03:19','2018-02-09 02:16:21',360,1,1,6);
insert into `usuario`(`id_usuario`,`usuario`,`password`,`id_usuario_crea`,`id_usuario_mod`,`fecha_reg`,`fecha_mod`,`fecha_caducidad`,`dias_vigencia`,`estado`,`id_persona`,`id_perfil`) values (2,'30254531','489d535d29404d2e',1,1,'2018-02-14 01:32:03','2018-02-14 01:36:41','2019-02-09 01:32:03',360,1,2,3);


insert into `estado_ht`(`id_estado_ht`,`descripcion`) values (1,'Pendiente');
insert into `estado_ht`(`id_estado_ht`,`descripcion`) values (2,'Archivado');


insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (1,'SOLICITUD');
insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (2,'OFICIO');
insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (3,'MEMORANDUM');
insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (4,'INFORME');
insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (5,'CARTA');
insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (6,'ORDEN TELEFÓNICA');
insert into `tipo_doc`(`id_tipo_doc`,`descripcion`) values (7,'RESPUESTA');



insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (1,'2017-07-01','Oficio 484-IG-PNP','Dispone el uso correcto del armamento de fuego',15,5,20,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (2,'2017-07-01','Solicitud','Solicita permiso a cuenta de vacaciones  por motivo que se indica',12,14,18,0,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (3,'2017-07-02','Memorandum 318 - DGPNP','Dispone la correcta presentación del uniforme policial',22,24,13,1,1,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (4,'2017-07-03','Oficio 465-DIROES-PNP','Dispone se remita la relación del personal que participará en apoyo policial',16,19,21,0,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (5,'2017-07-03','Solicitud','Solicita codificar, registrar y anexar al legajo personal curso de capacitación',28,10,18,1,1,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (6,'2017-07-04','Memorandum 321 - DGPNP','Sobre cambio de Jefes de unidad',23,24,16,1,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (7,'2017-07-05','Oficio 438-DIRTIC','Solicita inventario de equipos de comunicación',19,26,17,1,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (8,'2017-07-05','Solicitud','Solicita vacaciones por motivos personales',23,9,14,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (9,'2017-07-05','Oficio 468-DIROES-PNP','Disposiciones sobre el uso del uniforme camuflado',19,18,17,0,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (10,'2017-07-06','Oficio 469-DIROES-PNP','Dispone se remita informe técnico sobre los avances del desminado en la frontera norte con el Ecuador',21,22,24,0,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (11,'2017-07-06','Oficio 471-DIROES-PNP','Remite relación de personal que no paso lista de revista de armamento de fuego',9,8,7,1,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (12,'2017-07-07','Oficio 473-DIROES-PNP','Sobre visitar inopinadas del jefe de inspectorÃ­a',5,15,13,1,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (13,'2017-07-08','Oficio 474-DIROES-PNP','Sobre el uso de la fuerza',17,15,13,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (14,'2017-07-09','Oficio 477-DIROES-PNP','Solicita relación del personal',17,18,46,1,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (15,'2017-07-10','Oficio 478-DIROES-PNP','Dispone pintado de instalaciones',24,26,47,1,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (16,'2017-07-11','Oficio 481-DIROES-PNP','Dispone actualización de hoja de datos',12,25,45,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (17,'2017-07-12','Oficio 482-DIROES-PNP','Comunica  designación del Jefe Diroes PNP',13,11,4,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (18,'2017-07-14','Oficio 483-DIROES-PNP','Solicita relación de personal que se encuentra en aptitud B y C',5,10,7,0,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (19,'2017-07-15','Oficio 499-IG-PNP','Solicita Cartas funcionales actualizadas',7,19,13,0,1,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (20,'2017-07-16','Solicitud','Solicita permiso por motivo de  paternidad',14,12,17,0,1,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (21,'2017-07-18','Solicitud','Solicita renovación de  CIP',16,11,10,0,1,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (22,'2017-07-18','Solicitud','Solicita vacaciones reglamentarias  por motivo que se indica',24,8,14,0,0,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (23,'2017-07-19','Memorandum 324 - DGPNP','Sobre  el cumplimiento del horario  de servicio y relevo',26,16,13,0,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (24,'2017-07-21','Memorandum 326 - DGPNP','Sobre el correcto abastecimiento de los vehí­culos policiales',9,16,4,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (25,'2017-07-22','Memorandum 327 - DGPNP','Sobre el envio de las rendiciones de cuenta en el plazo que establece la ley.',17,13,12,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (26,'2017-07-22','Memorandum 329 - DGPNP','Dispone instrucción al personal policial',19,5,12,1,1,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (27,'2017-07-24','Memorandum 330 - DGPNP','Dispone designación del oficial de informes',17,12,19,1,1,0);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (28,'2017-07-26','Oficio 351-IG-PNP','Sobre el uso del libro de reclamaciones',13,12,19,1,0,1);
insert into `pretest`(`id_pretest`,`fecha_doc`,`siglas`,`asunto`,`EVA1I2`,`EVA2I2`,`EVA3I2`,`EVA1I1`,`EVA2I1`,`EVA3I1`) values (29,'2017-07-28','Oficio 234-DIRNOP-PNP','Sobre cumplimiento de la O/O MAZUCO 2018',16,4,15,1,0,1);


