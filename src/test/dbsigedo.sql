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

CREATE TABLE `tipo_doc` (
  `id_tipo_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `prioridad_doc` (
  `id_prioridad_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_prioridad_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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

CREATE TABLE `movimiento_ht` (
  `id_movimiento_ht` int(11) NOT NULL AUTO_INCREMENT,
  `id_unidad_destino` int(11) DEFAULT NULL,
  `id_oficina_destino` int(11) DEFAULT NULL,
  `id_ usuario_destino` int(11) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `id_usuario_registro` int(11) DEFAULT NULL,
  `id_unidad_registro` int(11) DEFAULT NULL,
  `id_oficina_registro` int(11) DEFAULT NULL,
  `id_hoja_tramite` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL,
  `id_estado_movimiento_ht` int(11) NOT NULL,
  PRIMARY KEY (`id_movimiento_ht`)
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `fichero_doc` (
  `id_fichero_doc` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `size` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fichero` longblob,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_fichero_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `estado_movimiento_ht` (
  `id_estado_movimiento_ht` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_estado_movimiento_ht`)
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

CREATE TABLE `estado_ht` (
  `id_estado_ht` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_estado_ht`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `estado_doc` (
  `id_estado_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_estado_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `codeqr` (
  `id_codigoQr` int(11) NOT NULL AUTO_INCREMENT,
  `id_Hoja_tramite` int(11) NOT NULL,
  `codeQr` blob,
  PRIMARY KEY (`id_codigoQr`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=ucs2;

CREATE TABLE `clas_funcion_doc` (
  `id_clas_funcion_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_clas_funcion_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `clas_contenido_doc` (
  `id_clas_contenido_doc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_clas_contenido_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `centro_trabajo` (
  `id_centro_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  `id_unidad` int(11) NOT NULL,
  `id_oficina` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`id_centro_trabajo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

