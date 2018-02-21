package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Documento;
import logica.LogicaCombos;

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

		Documento doc = new Documento();
		doc.setIdClasContenidoDoc(Integer.parseInt(cbxcontenido));
		doc.setIdClasFuncionDoc(Integer.parseInt(cbxfuncion));
		doc.setIdEstadoDoc(1);
		doc.setIdFicheroDoc(Integer.parseInt(id_fichero));
		doc.setIdPrioridadDoc(Integer.parseInt(cbxprioridad));
		doc.setIdTipoDoc(Integer.parseInt(tipo));
System.out.println(doc.toString());
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
