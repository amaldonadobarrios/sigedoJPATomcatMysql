package control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.AlmacenArchivo;
import entity.Archivo;
import entity.Documento;
import entity.FicheroDoc;
import entity.MovimientoHt;
import entity.Oficina;
import entity.Unidad;
import entity.Usuario;
import logica.LogicaAlmacenArchivo;
import logica.LogicaArchivo;
import logica.LogicaDocumento;
import logica.LogicaFichero;
import logica.LogicaHojaTramite;
import logica.LogicaMovimientoHT;
import logica.LogicaOficina;
import logica.grilla.LogicaGrillaBandeja;
import util.DirTexto;
import util.HtmlUtil;

/**
 * Servlet implementation class ServBandejaAJAX
 */
@WebServlet("/ServBandejaAJAX")
public class ServBandejaAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServBandejaAJAX() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {

					String evento = request.getParameter("hdEvento");
					if (evento != null || evento != "") {
						switch (evento) {
						case "BANDEJA_RECIBIDO":
							System.out.println("hdEvento :  BANDEJA_RECIBIDO");
							BandejaRecibido(request, response);
							break;
						case "BANDEJA_PENDIENTE":
							System.out.println("hdEvento :  BANDEJA_PENDIENTE");
							BandejaPendiente(request, response);
							break;
						case "BANDEJA_DERIVADO":
							System.out.println("hdEvento :  BANDEJA_DERIVADO");
							BandejaDerivado(request, response);
							break;
						case "BANDEJA_RESPONDIDO":
							System.out.println("hdEvento :  BANDEJA_RESPONDIDO");
							BandejaRespondido(request, response);
							break;
						case "BANDEJA_APROBADO":
							System.out.println("hdEvento :  BANDEJA_APROBADO");
							BandejaAprobado(request, response);
							break;
						case "BANDEJA_DESESTIMADO":
							System.out.println("hdEvento :  BANDEJA_DESESTIMADO");
							BandejaDesestimado(request, response);
							break;
						case "BANDEJA_DEVUELTO":
							System.out.println("hdEvento :  BANDEJA_DEVUELTO");
							BandejaDevuelto(request, response);
							break;
						case "BANDEJA_CONTESTADO":
							System.out.println("hdEvento :  BANDEJA_CONTESTADO");
							BandejaContestado(request, response);
							break;
						case "BANDEJA_ARCHIVADO":
							System.out.println("hdEvento :  BANDEJA_ARCHIVADO");
							BandejaArchivado(request, response);
							break;
						case "BANDEJA_ADMINISTRATIVO":
							System.out.println("hdEvento :  BANDEJA_ADMINISTRATIVO");
							BandejaAdministrativo(request, response);
							break;
						case "BANDEJA_ARCHIVO_PENDIENTE":
							System.out.println("hdEvento :  BANDEJA_ARCHIVO_PENDIENTE");
							BandejaUsuarioArchivador(request, response);
							break;
						case "BANDEJA_ARCHIVO_DIGITALIZADO":
							System.out.println("hdEvento :  BANDEJA_ARCHIVO_DIGITALIZADO");
							BandejaUsuarioArchivadorDigitalizado(request, response);
							break;
						case "VER_PDF":
							System.out.println("hdEvento :  VER_PDF");
							VerPdf(request, response);
							break;
						case "DOWNLOAD":
							System.out.println("hdEvento :  DOWNLOAD");
							Download(request, response);
							break;
						case "RECIBIR":
							System.out.println("hdEvento :  RECIBIR");
							Recibir(request, response);
							break;
						case "DERIVAR":
							System.out.println("hdEvento :  DERIVAR");
							Derivar(request, response);
							break;
						case "ARCHIVAR":
							System.out.println("hdEvento :  ARCHIVAR");
							Archivar(request, response);
							break;
						case "VALIDAR RESPUESTA":
							System.out.println("hdEvento :  VALIDAR RESPUESTA");
							ValidarRespuesta(request, response);
							break;
						case "DEVOLVER":
							System.out.println("hdEvento :  DEVOLVER");
							Devolver(request, response);
							break;
						case "RESPONDER":
							System.out.println("hdEvento :  RESPONDER");
							Responder(request, response);
							break;
						case "CONTESTAR":
							System.out.println("hdEvento :  CONTESTAR");
							Contestar(request, response);
							break;
						case "DIGITALIZAR":
							System.out.println("hdEvento :  DIGITALIZAR");
							Digitalizar(request, response);
							break;
						default:
							break;
						}
					}
				} else {
					request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
					sesion.invalidate();
					HtmlUtil.getInstance().escrituraHTML(response, "NOSESION");

				}

			} else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				HtmlUtil.getInstance().escrituraHTML(response, "NOSESION");

			}
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			HtmlUtil.getInstance().escrituraHTML(response, "NOSESION");

		}

	}

	private void BandejaUsuarioArchivadorDigitalizado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaUsuarioArchivadorDigitalizado");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaUsuarioArchivador(uni.getIdUnidad(),1);
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void Digitalizar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Digitalizar");
		int i=0;
		int id_almacen=0;
		Date FECHA_DOC = null;
		String  idht=request.getParameter("id_ht");
		String  iddoc=request.getParameter("iddoc");
		String  id_archivo=request.getParameter("id_archivo");
		String  cbxarchivador=request.getParameter("cbxarchivador");
		String  seleccionaAnyo=request.getParameter("seleccionaAnyo");
		String  secuencia=request.getParameter("secuencia");
		String  txtpalabras=request.getParameter("txtpalabras");
		String  txtobservaciones=request.getParameter("txtobservaciones");
		String  id_fichero=request.getParameter("id_fichero");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		//Actualiza obj Archivo 
		Archivo ar =new Archivo();
		ar.setIdArchivo(Integer.parseInt(id_archivo));
		ar.setId_fichero_archivo(Integer.parseInt(id_fichero));
		ar.setEstado(1);
		ar.setPalabras_clave(DirTexto.getInstance().cambiarFormatoUTF8(txtpalabras).toUpperCase());
		ar.setObservaciones(DirTexto.getInstance().cambiarFormatoUTF8(txtobservaciones).toUpperCase());
		ar.setUsuarioReg(user.getIdUsuario());
		ar.setFechaReg(new Date());
		i=LogicaArchivo.getInstance().updateArchivo(ar);
		if (i>0) {
			//Genera AlmacenArchivo
			AlmacenArchivo alm=new AlmacenArchivo();
			Oficina ofic=LogicaOficina.getInstance().BuscarporId(Integer.parseInt(cbxarchivador));
			alm.setEtiquetaArchivador(ofic.getDescripcion());
			alm.setIdArchivadorOficina(Integer.parseInt(cbxarchivador));
			alm.setIdArchivo(i);
			alm.setObservaciones(txtobservaciones);
			alm.setSecuenciaArchivador(secuencia);
			alm.setYearArchivador(seleccionaAnyo);
			id_almacen=LogicaAlmacenArchivo.getInstance().insertAlmacenArchivo(alm);	
		}
		HtmlUtil.getInstance().escritura(response, String.valueOf(id_almacen));	
	}

	private void BandejaUsuarioArchivador(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaUsuarioArchivador");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaUsuarioArchivador(uni.getIdUnidad(),0);
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void Contestar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Contestar");
		int i=0;
		Date FECHA_DOC = null;
		String  idht=request.getParameter("id_ht");
		String  cbxdocumentoContestar=request.getParameter("cbxdocumentoContestar");
		String  txtnumero=request.getParameter("txtnumero");
		String  txtsiglas=request.getParameter("txtsiglas");
		String  txtfechadoc=request.getParameter("txtfechadoc");
		String  cbxcontenido=request.getParameter("cbxcontenido");
		String  cbxfuncion=request.getParameter("cbxfuncion");
		String  cbxprioridad=request.getParameter("cbxprioridad");
		String  cbxdestino=request.getParameter("cbxdestino");
		String  txtasuntoContestar=request.getParameter("txtasuntoContestar");
		String  txtobservacionesContestar=request.getParameter("txtobservacionesContestar");
		String  id_fichero=request.getParameter("id_fichero");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		//Genero documento Contestar
		Documento doc=new Documento();
		doc.setIdClasContenidoDoc(Integer.parseInt(cbxcontenido));
		doc.setIdClasFuncionDoc(Integer.parseInt(cbxfuncion));
		doc.setIdEstadoDoc(1);
		doc.setIdFicheroDoc(Integer.parseInt(id_fichero));
		doc.setIdPrioridadDoc(Integer.parseInt(cbxprioridad));
		doc.setIdTipoDoc(Integer.parseInt(cbxdocumentoContestar));
		doc.setAsunto(DirTexto.getInstance().cambiarFormatoUTF8(txtasuntoContestar).toUpperCase());
		doc.setSiglas(DirTexto.getInstance().cambiarFormatoUTF8(txtsiglas).toUpperCase());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			FECHA_DOC = formatter.parse(txtfechadoc);
		} catch (Exception e) {
			// TODO: handle exception
		}
		doc.setFecha(FECHA_DOC);
		doc.setNumero(txtnumero);
		doc.setIdUnidad(Integer.parseInt(cbxdestino));
		doc.setUsuReg(user.getIdUsuario());
		doc.setIdUnidadReg(uni.getIdUnidad());
		int iddocumento=LogicaDocumento.getInstance().grabarDocumento(doc);
		if (iddocumento>0) {
			MovimientoHt mov=new MovimientoHt();
			mov.setFechaRegistro(new Date());
			mov.setId_usuarioDestino(0);
			mov.setIdDocumento(iddocumento);
			mov.setIdEstadoMovimientoHt(8);//contestado
			mov.setIdHojaTramite(Integer.parseInt(idht));
			mov.setIdOficinaDestino(0);
			mov.setIdOficinaRegistro(ofi.getIdOficina());
			mov.setIdUnidadDestino(Integer.parseInt(cbxdestino));
			mov.setIdUnidadRegistro(uni.getIdUnidad());
			mov.setIdUsuarioRegistro(user.getIdUsuario());
			mov.setObservaciones(txtobservacionesContestar.toUpperCase());
			try {
			i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
			} catch (Exception e) {
				System.out.println("ServBandejaAJAX.Contestar()"+e.getMessage());
			}
			if (i>0) {
				Archivo archiv=new Archivo();
				archiv.setEstado(0);
				archiv.setFechaReg(new Date());
				archiv.setIdDocumento(iddocumento);
				archiv.setIdHojaTramite(Integer.parseInt(idht));
				archiv.setIdMovimiento(i);
				archiv.setUsuarioReg(user.getIdUsuario());
				archiv.setIdUnidad(uni.getIdUnidad());	
				LogicaArchivo.getInstance().insertArchivo(archiv);
			}
		}
	HtmlUtil.getInstance().escritura(response, String.valueOf(i));	
		
	}

	private void Responder(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Responder");
		int i=0;
		String  idht=request.getParameter("id_ht");
		String  id_usuario_destino=request.getParameter("id_usuario_destino");
		String  id_unidad_destino=request.getParameter("id_unidad_destino");
		String  id_oficina_destino=request.getParameter("id_oficina_destino");
		String  observaciones=request.getParameter("observaciones");
		String id_fichero=request.getParameter("id_fichero");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		//Genero documento Respuesta
		Documento docresp=new Documento();
		docresp.setAsunto("Documento Respuesta");
		docresp.setFecha(new Date());
		docresp.setFechaReg(new Date());
		docresp.setIdClasContenidoDoc(1);
		docresp.setIdClasFuncionDoc(1);
		docresp.setIdEstadoDoc(2);
		docresp.setIdFicheroDoc(Integer.parseInt(id_fichero));
		docresp.setIdPrioridadDoc(1);
		docresp.setIdTipoDoc(7);
		docresp.setNumero("S/N");
		docresp.setIdUnidad(Integer.parseInt(id_unidad_destino));
		docresp.setIdUnidadReg(uni.getIdUnidad());
		docresp.setSiglas("");
		docresp.setUsuReg(user.getIdUsuario());
		int iddocumento=LogicaDocumento.getInstance().grabarDocumento(docresp);
		if (iddocumento>0) {
			MovimientoHt mov=new MovimientoHt();
			mov.setFechaRegistro(new Date());
			mov.setId_usuarioDestino(Integer.parseInt(id_usuario_destino));
			mov.setIdDocumento(iddocumento);
			mov.setIdEstadoMovimientoHt(4);//respondido
			mov.setIdHojaTramite(Integer.parseInt(idht));
			mov.setIdOficinaDestino(Integer.parseInt(id_oficina_destino));
			mov.setIdOficinaRegistro(ofi.getIdOficina());
			mov.setIdUnidadDestino(Integer.parseInt(id_unidad_destino));
			mov.setIdUnidadRegistro(uni.getIdUnidad());
			mov.setIdUsuarioRegistro(user.getIdUsuario());
			mov.setObservaciones(observaciones.toUpperCase());
			try {
			i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
			} catch (Exception e) {
				System.out.println("ServBandejaAJAX.Archivar()"+e.getMessage());
			}
		}
	HtmlUtil.getInstance().escritura(response, String.valueOf(i));	
	}

	private void Devolver(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Devolver");
		int i=0;
		String  idht=request.getParameter("id_ht");
		String  iddoc=request.getParameter("id_doc");
		String  id_usuario_destino=request.getParameter("id_usuario_destino");
		String  id_unidad_destino=request.getParameter("id_unidad_destino");
		String  id_oficina_destino=request.getParameter("id_oficina_destino");
		String  observaciones=request.getParameter("observaciones");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		MovimientoHt mov=new MovimientoHt();
		mov.setFechaRegistro(new Date());
		mov.setId_usuarioDestino(Integer.parseInt(id_usuario_destino));
		mov.setIdDocumento(Integer.parseInt(iddoc));
		mov.setIdEstadoMovimientoHt(7);//devolver
		mov.setIdHojaTramite(Integer.parseInt(idht));
		mov.setIdOficinaDestino(Integer.parseInt(id_oficina_destino));
		mov.setIdOficinaRegistro(ofi.getIdOficina());
		mov.setIdUnidadDestino(Integer.parseInt(id_unidad_destino));
		mov.setIdUnidadRegistro(uni.getIdUnidad());
		mov.setIdUsuarioRegistro(user.getIdUsuario());
		mov.setObservaciones(observaciones.toUpperCase());
		try {
		i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
		} catch (Exception e) {
			System.out.println("ServBandejaAJAX.Devolver()"+e.getMessage());
		}
		
	HtmlUtil.getInstance().escritura(response, String.valueOf(i));
		
	}

	private void BandejaAdministrativo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaAdministrativo");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Usuario usu= (Usuario)SesionUsuario.get(0);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaAdministrativo(uni.getIdUnidad(),usu.getIdUsuario());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void ValidarRespuesta(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ValidarRespuesta");
		int i=0;
		String  idht=request.getParameter("id_ht");
		String  iddoc=request.getParameter("id_doc");
		String  id_usuario_destino=request.getParameter("id_usu");
		String  id_unidad_destino=request.getParameter("id_uni");
		String  id_estado_validacion=request.getParameter("id_estado_validacion");
		String  observaciones=request.getParameter("observaciones");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		MovimientoHt mov=new MovimientoHt();
		mov.setFechaRegistro(new Date());
		if (id_estado_validacion.equals("5")) {
			mov.setId_usuarioDestino(0);
		}else {
			mov.setId_usuarioDestino(Integer.parseInt(id_usuario_destino));
		}
		mov.setIdDocumento(Integer.parseInt(iddoc));
		mov.setIdEstadoMovimientoHt(Integer.parseInt(id_estado_validacion));//Aprobado - Desaprobado
		mov.setIdHojaTramite(Integer.parseInt(idht));
		mov.setIdOficinaDestino(0);
		mov.setIdOficinaRegistro(ofi.getIdOficina());
		mov.setIdUnidadDestino(Integer.parseInt(id_unidad_destino));
		mov.setIdUnidadRegistro(uni.getIdUnidad());
		mov.setIdUsuarioRegistro(user.getIdUsuario());
		mov.setObservaciones(observaciones.toUpperCase());
		try {
		i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
		} catch (Exception e) {
			System.out.println("ServBandejaAJAX.ValidarRespuesta()"+e.getMessage());
		}
		HtmlUtil.getInstance().escritura(response, String.valueOf(i));
	}

	private void Archivar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Archivar");
		int i=0;
		String  idht=request.getParameter("id_ht");
		String  iddoc=request.getParameter("id_doc");
		String  id_usuario_destino=request.getParameter("id_usuario_destino");
		String  id_unidad_destino=request.getParameter("id_unidad_destino");
		String  id_oficina_destino=request.getParameter("id_oficina_destino");
		String  observaciones=request.getParameter("observaciones");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		MovimientoHt mov=new MovimientoHt();
		mov.setFechaRegistro(new Date());
		mov.setId_usuarioDestino(Integer.parseInt(id_usuario_destino));
		mov.setIdDocumento(Integer.parseInt(iddoc));
		mov.setIdEstadoMovimientoHt(9);//archivado
		mov.setIdHojaTramite(Integer.parseInt(idht));
		mov.setIdOficinaDestino(Integer.parseInt(id_oficina_destino));
		mov.setIdOficinaRegistro(ofi.getIdOficina());
		mov.setIdUnidadDestino(Integer.parseInt(id_unidad_destino));
		mov.setIdUnidadRegistro(uni.getIdUnidad());
		mov.setIdUsuarioRegistro(user.getIdUsuario());
		mov.setObservaciones(observaciones.toUpperCase());
		try {
		i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
		} catch (Exception e) {
			System.out.println("ServBandejaAJAX.Archivar()"+e.getMessage());
		}
		if (i>0) {
			Archivo archiv=new Archivo();
			archiv.setEstado(0);
			archiv.setFechaReg(new Date());
			archiv.setIdDocumento(Integer.parseInt(iddoc));
			archiv.setIdHojaTramite(Integer.parseInt(idht));
			archiv.setIdMovimiento(i);
			archiv.setUsuarioReg(user.getIdUsuario());
			archiv.setIdUnidad(uni.getIdUnidad());	
			LogicaArchivo.getInstance().insertArchivo(archiv);
			LogicaHojaTramite.getInstance().ArchivarEstadoHT(Integer.parseInt(idht));	
		}
	HtmlUtil.getInstance().escritura(response, String.valueOf(i));
		
	}

	private void Derivar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Derivar");
		int i=0;
		String  idht=request.getParameter("id_ht");
		String  iddoc=request.getParameter("id_doc");
		String  id_usuario_destino=request.getParameter("id_usuario_destino");
		String  id_unidad_destino=request.getParameter("id_unidad_destino");
		String  id_oficina_destino=request.getParameter("id_oficina_destino");
		String  observaciones=request.getParameter("observaciones");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		MovimientoHt mov=new MovimientoHt();
		mov.setFechaRegistro(new Date());
		mov.setId_usuarioDestino(Integer.parseInt(id_usuario_destino));
		mov.setIdDocumento(Integer.parseInt(iddoc));
		mov.setIdEstadoMovimientoHt(3);//derivado
		mov.setIdHojaTramite(Integer.parseInt(idht));
		mov.setIdOficinaDestino(Integer.parseInt(id_oficina_destino));
		mov.setIdOficinaRegistro(ofi.getIdOficina());
		mov.setIdUnidadDestino(Integer.parseInt(id_unidad_destino));
		mov.setIdUnidadRegistro(uni.getIdUnidad());
		mov.setIdUsuarioRegistro(user.getIdUsuario());
		mov.setObservaciones(observaciones.toUpperCase());
		try {
		i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
		} catch (Exception e) {
			System.out.println("ServBandejaAJAX.Derivar()"+e.getMessage());
		}
	HtmlUtil.getInstance().escritura(response, String.valueOf(i));
		
	}

	private void Recibir(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Recibir");
		int i=0;
		String  idht=request.getParameter("id_ht");
		String  iddoc=request.getParameter("id_doc");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		MovimientoHt mov=new MovimientoHt();
		mov.setFechaRegistro(new Date());
		mov.setId_usuarioDestino(user.getIdUsuario());
		mov.setIdDocumento(Integer.parseInt(iddoc));
		mov.setIdEstadoMovimientoHt(2);//recibido
		mov.setIdHojaTramite(Integer.parseInt(idht));
		mov.setIdOficinaDestino(ofi.getIdOficina());
		mov.setIdOficinaRegistro(ofi.getIdOficina());
		mov.setIdUnidadDestino(uni.getIdUnidad());
		mov.setIdUnidadRegistro(uni.getIdUnidad());
		mov.setIdUsuarioRegistro(user.getIdUsuario());
		mov.setObservaciones("Hoja de tramite Recibida".toUpperCase());
		try {
		i=LogicaMovimientoHT.getInstance().grabarMovimientoHT(mov);	
		} catch (Exception e) {
			System.out.println("ServGestionDocumento.REGISTRAR_DOCUMENTO_MP()"+e.getMessage());
		}
	HtmlUtil.getInstance().escritura(response, String.valueOf(i));	
	}

	private void BandejaArchivado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaArchivado");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaArchivado(9,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaContestado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaContestado");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaContestado(8,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaDevuelto(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaDevuelto");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaDevuelto(7,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaDesestimado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaDesestimado");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Usuario usu= (Usuario)SesionUsuario.get(0);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaDesestimado(uni.getIdUnidad(),usu.getIdUsuario());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaAprobado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaAprobado");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Usuario usu= (Usuario)SesionUsuario.get(0);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaAprobado(5,uni.getIdUnidad(),usu.getIdPerfil());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaRespondido(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaRespondido");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaRespondido(4,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaDerivado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaDerivado");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaDerivado(3,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void BandejaPendiente(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaPendiente");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaPendiente(8,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);
		
	}

	private void Download(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Download");
		String id = request.getParameter("id");
		int id_fichero = Integer.parseInt(id);
		FicheroDoc doc = null;
		doc = LogicaFichero.getInstance().Download(id_fichero);
		if (id != null) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ServletOutputStream sos = null;

			try {
				baos.write(doc.getBlob());
				// "application/octet-stream"
				response.setContentType(doc.getTipo());
				response.addHeader("Content-Disposition", "attachment; filename=" + doc.getNombre());
				response.setContentLength(baos.size());
				sos = response.getOutputStream();
				baos.writeTo(sos);
			} catch (IOException e) {
			}
		}
	}

	private void VerPdf(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("VerPdf");
		String rutaPDF = "VACIO";
		String id = request.getParameter("id_fichero");
		int id_fichero = Integer.parseInt(id);
		rutaPDF = LogicaFichero.getInstance().RutaVerPDF(id_fichero);
		HtmlUtil.getInstance().escrituraHTML(response, rutaPDF);
	}

	private void BandejaRecibido(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BandejaRecibido");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		String tabla=LogicaGrillaBandeja.getInstance().BandejaRecibido(2,uni.getIdUnidad());
		HtmlUtil.getInstance().escritura(response, tabla);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
