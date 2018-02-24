package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Codeqr;
import entity.Documento;
import entity.HojaTramite;
import entity.Oficina;
import entity.Unidad;
import entity.Usuario;
import logica.LogicaCombos;
import logica.LogicaDocumento;
import logica.LogicaHojaTramite;
import logica.LogicaQR;
import util.DirTexto;

/**
 * Servlet implementation class ServGestionDocumento
 */
@WebServlet("/ServGestionDocumento")
public class ServGestionDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServGestionDocumento() {
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
						case "REGISTRAR_DOCUMENTO_MP":
							System.out.println("hdEvento :  REGISTRAR_DOCUMENTO_MP");
							REGISTRAR_DOCUMENTO_MP(request, response);
							break;
						default:
							break;
						}
					}
				} else {
					request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
					sesion.invalidate();
					System.out.println("DESTINO:" + "index.jsp");
					forwar("index.jsp", request, response);

				}

			} else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				System.out.println("DESTINO:" + "index.jsp");
				forwar("index.jsp", request, response);
			}
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			System.out.println("DESTINO:" + "index.jsp");
			forwar("index.jsp", request, response);
		}
	}

	private void REGISTRAR_DOCUMENTO_MP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("void REGISTRAR_DOCUMENTO_MP");
		String Qr=null;
		Date FECHA_DOC = null;
		String id_fichero = request.getParameter("id_fichero");
		String tipo = request.getParameter("cbxdocumento");
		String txtnumero = request.getParameter("txtnumero");
		String txtsiglas = request.getParameter("txtsiglas");
		String txtfechadoc = request.getParameter("txtfechadoc");
		String cbxcontenido = request.getParameter("cbxcontenido");
		String cbxfuncion = request.getParameter("cbxfuncion");
		String cbxprioridad = request.getParameter("cbxprioridad");
		String cbxremitente = request.getParameter("cbxremitente");
		String asunto = request.getParameter("txtasunto");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		Unidad uni = (Unidad) SesionUsuario.get(3);
		Oficina ofi = (Oficina) SesionUsuario.get(4);
		Documento doc = new Documento();
		doc.setIdClasContenidoDoc(Integer.parseInt(cbxcontenido));
		doc.setIdClasFuncionDoc(Integer.parseInt(cbxfuncion));
		doc.setIdEstadoDoc(1);
		doc.setIdFicheroDoc(Integer.parseInt(id_fichero));
		doc.setIdPrioridadDoc(Integer.parseInt(cbxprioridad));
		doc.setIdTipoDoc(Integer.parseInt(tipo));
		doc.setAsunto(DirTexto.getInstance().cambiarFormatoUTF8(asunto));
		doc.setSiglas(DirTexto.getInstance().cambiarFormatoUTF8(txtsiglas));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			FECHA_DOC = formatter.parse(txtfechadoc);
		} catch (Exception e) {
			// TODO: handle exception
		}
		doc.setFecha(FECHA_DOC);
		doc.setNumero(txtnumero);
		doc.setIdUnidad(Integer.parseInt(cbxremitente));
		doc.setUsuReg(user.getIdUsuario());
		doc.setIdUnidadReg(uni.getIdUnidad());
		// Grabar Documento
		System.out.println(doc);
		System.out.println("string :" + txtfechadoc + " date:" + doc.getFecha());
		int id = LogicaDocumento.getInstance().grabarDocumento(doc);
		if (id > 0) {

			// Generar HT
			HojaTramite ht = new HojaTramite();
			ht.setAsunto(DirTexto.getInstance().cambiarFormatoUTF8(asunto));
			ht.setFechaRegistro(new Date());
			ht.setIdEstadoHt(1);
			ht.setIdOficinaRegistro(ofi.getIdOficina());
			ht.setIdUnidadRegistro(uni.getIdUnidad());
			ht.setIdUsuarioRegistro(user.getIdUsuario());
			ht.setIdDocumentoInicio(id);
			ht.setIdUnidadDestino(uni.getIdUnidad());
			int id_ht = LogicaHojaTramite.getInstance().grabarHT(ht);
			if (id_ht > 0) {
				Codeqr qr=new Codeqr();
				qr.setId_Hoja_tramite(id_ht);
				Qr=LogicaQR.getInstance().GrabarCodeQr(qr);
				request.setAttribute("msgok", "DOCUMENTO GRABADO EXITOSAMENTE - SE GENERO LA HT N° "+id_ht);
			} else {
				request.setAttribute("msgnok", "DOCUMENTO NO SE GRABÓ");
			}
		}

		// cargar combos
		request.setAttribute("combounid", LogicaCombos.getInstance().ListaUnidad());
		request.setAttribute("combotipo", LogicaCombos.getInstance().ListaTipoDoc());
		request.setAttribute("combocont", LogicaCombos.getInstance().ListaClasContenidoDoc());
		request.setAttribute("combofunc", LogicaCombos.getInstance().ListaClasFuncionDoc());
		request.setAttribute("comboprio", LogicaCombos.getInstance().ListaPrioridadDoc());
		request.setAttribute("breadcrumb", "Registrar Documento");
		request.setAttribute("body", "regdocMP");
		forwar("jsp/template.jsp", request, response);

	}

	private void forwar(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(jsp).forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
