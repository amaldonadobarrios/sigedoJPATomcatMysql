CREATE TABLE `almacen_archivo` (
  `id_almacen_documento` int(11) NOT NULL AUTO_INCREMENT,
  `id_archivo` int(11) NOT NULL,
  `id_archivador_oficina` int(11) NOT NULL,
  `etiqueta_archivador` varchar(40) NOT NULL,
  `secuencia_archivador` varchar(20) NOT NULL,
  `year_archivador` varchar(4) NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_almacen_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `archivo` (
  `id_archivo` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoja_tramite` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL,
  `id_movimiento` int(11) NOT NULL,
  `fecha_reg` date NOT NULL,
  `usuario_reg` int(11) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '0' COMMENT '1 registrado 0 pendiente',
  `id_unidad` int(11) NOT NULL,
  `id_fichero_archivo` int(11) DEFAULT NULL,
  `palabras_clave` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_archivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `centro_trabajo` (
  `id_centro_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  `id_unidad` int(11) NOT NULL,
  `id_oficina` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`id_centro_trabajo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `clas_contenido_doc` (
  `id_clas_contenido_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_clas_contenido_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `clas_funcion_doc` (
  `id_clas_funcion_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_clas_funcion_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `codeqr` (
  `id_codigoQr` int(11) NOT NULL AUTO_INCREMENT,
  `id_Hoja_tramite` int(11) NOT NULL,
  `codeQr` blob,
  PRIMARY KEY (`id_codigoQr`)
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

CREATE TABLE `documento` (
  `id_documento` int(11) NOT NULL AUTO_INCREMENT,
  `id_clas_funcion_doc` int(11) NOT NULL,
  `id_tipo_doc` int(11) NOT NULL,
  `id_estado_doc` int(11) NOT NULL,
  `id_clas_contenido_doc` int(11) NOT NULL,
  `id_fichero_doc` int(11) DEFAULT NULL,
  `id_prioridad_doc` int(11) NOT NULL,
  `asunto` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `siglas` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_doc` date NOT NULL,
  `numero` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_unidad_remite` int(11) NOT NULL,
  `usu_reg` int(11) NOT NULL,
  `id_unidad_registra` int(11) NOT NULL,
  PRIMARY KEY (`id_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `estado_doc` (
  `id_estado_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_estado_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `estado_ht` (
  `id_estado_ht` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_estado_ht`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `estado_movimiento_ht` (
  `id_estado_movimiento_ht` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_estado_movimiento_ht`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=ucs2;

CREATE TABLE `fichero_doc` (
  `id_fichero_doc` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(1000) COLLATE utf8_spanish_ci DEFAULT NULL,
  `size` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fichero` longblob,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_fichero_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `hoja_tramite` (
  `id_hoja_tramite` int(11) NOT NULL AUTO_INCREMENT,
  `id_estado_ht` int(11) NOT NULL,
  `asunto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `id_unidad_registro` int(11) NOT NULL,
  `id_usuario_registro` int(11) NOT NULL,
  `id_oficina_registro` int(11) NOT NULL,
  `id_documento_inicio` int(11) DEFAULT NULL,
  `id_unidad_destino` int(11) NOT NULL,
  PRIMARY KEY (`id_hoja_tramite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `movimiento_ht` (
  `id_movimiento_ht` int(11) NOT NULL AUTO_INCREMENT,
  `id_unidad_destino` int(11) DEFAULT NULL,
  `id_oficina_destino` int(11) DEFAULT NULL,
  `id_usuario_destino` int(11) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `id_usuario_registro` int(11) DEFAULT NULL,
  `id_unidad_registro` int(11) DEFAULT NULL,
  `id_oficina_registro` int(11) DEFAULT NULL,
  `id_hoja_tramite` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL,
  `id_estado_movimiento_ht` int(11) NOT NULL,
  `observaciones` varchar(1000) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_movimiento_ht`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `oficina` (
  `id_oficina` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `usu_reg` int(11) DEFAULT NULL,
  `usu_mod` int(11) DEFAULT NULL,
  `fecha_reg` datetime DEFAULT NULL,
  `fecha_mod` datetime DEFAULT NULL,
  PRIMARY KEY (`id_oficina`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `cip` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ape_pat` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ape_mat` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombres` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `grado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dni` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `celular` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usu_reg` int(11) DEFAULT NULL,
  `usu_mod` int(11) DEFAULT NULL,
  `fecha_reg` datetime DEFAULT NULL,
  `fecha_mod` datetime DEFAULT NULL,
  `id_centro_trabajo` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `prioridad_doc` (
  `id_prioridad_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_prioridad_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `tipo_doc` (
  `id_tipo_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `unidad` (
  `id_unidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `usu_reg` int(11) DEFAULT NULL,
  `usu_mod` int(11) DEFAULT NULL,
  `fecha_reg` datetime DEFAULT NULL,
  `fecha_mod` datetime DEFAULT NULL,
  PRIMARY KEY (`id_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_usuario_crea` int(11) DEFAULT NULL,
  `id_usuario_mod` int(11) DEFAULT NULL,
  `fecha_reg` datetime DEFAULT NULL,
  `fecha_mod` datetime DEFAULT NULL,
  `fecha_caducidad` datetime NOT NULL,
  `dias_vigencia` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `id_persona` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


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

