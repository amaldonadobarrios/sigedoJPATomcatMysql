package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Unidad;
import entity.Usuario;
import logica.LogicaCombos;
import logica.LogicaOficina;
import logica.LogicaPerfil;
import logica.LogicaUnidad;
import logica.grilla.LogicaGrillaBandeja;

/**
 * Servlet implementation class SPage
 */
@WebServlet("/SPage")
public class SPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SPage() {
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

					String action = request.getParameter("action") != null ? request.getParameter("action") : "";

					switch (action) {

					case "pagehome":
						this.pagehome(request, response);
						break;
					case "login":
						this.pagelogin(request, response);
						break;
					case "key":
						this.pagekey(request, response);
						break;
					case "searchHT":
						this.pagesearchHT(request, response);
						break;
					case "searchARCH":
						this.pagesearchARCH(request, response);
						break;
					case "BandejaMP":
						this.pageBandejaMP(request, response);
						break;
					case "RegdocMP":
						this.pageregdocMP(request, response);
						break;
					case "BandJefe":
						this.pageBandJefe(request, response);
						break;
					case "BandArchiv":
						this.pageBandArchiv(request, response);
						break;
					case "BandAdministrativo":
						this.pageBandAdministrativo(request, response);
						break;
					case "GestCenTrabajo":
						this.GestCenTrabajo(request, response);
						break;
					case "RegUsu":
						this.RegUsu(request, response);
						break;
					case "ModUsu":
						this.ModUsu(request, response);
						break;
					case "RegOfi":
						this.RegOfi(request, response);
						break;
					case "RegUni":
						this.RegUni(request, response);
						break;
					case "EnvdocMP":
						this.EnvdocMP(request, response);
						break;	
					default:
						this.pagelogin(request, response);
						break;

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

	private void pagesearchARCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Consultar Archivo");
		request.setAttribute("body", "consARCH");
		forwar("jsp/template.jsp", request, response);
		
	}

	private void EnvdocMP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cargar combos
				request.setAttribute("combounid", LogicaCombos.getInstance().ListaUnidad());
				request.setAttribute("combotipo", LogicaCombos.getInstance().ListaTipoDoc());
				request.setAttribute("combocont", LogicaCombos.getInstance().ListaClasContenidoDoc());
				request.setAttribute("combofunc", LogicaCombos.getInstance().ListaClasFuncionDoc());
				request.setAttribute("comboprio", LogicaCombos.getInstance().ListaPrioridadDoc());
				request.setAttribute("breadcrumb", "Enviar Documento");
				request.setAttribute("body", "EnvdocMP");
				forwar("jsp/template.jsp", request, response);
		
	}

	private void pageBandAdministrativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Bandeja de Administrativo");
		request.setAttribute("body", "bandejaADM");
		forwar("jsp/template.jsp", request, response);
		
	}

	private void RegUni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lstUnidad", LogicaCombos.getInstance().ListaUnidad());
		request.setAttribute("breadcrumb", "Registrar Unidad");
		request.setAttribute("body", "frm_reg_unidad");
		forwar("jsp/template.jsp", request, response);

	}

	private void RegOfi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lstOfi", LogicaOficina.getInstance().ListarOficina());
		request.setAttribute("breadcrumb", "Registrar Oficina");
		request.setAttribute("body", "frm_reg_oficina");
		forwar("jsp/template.jsp", request, response);

	}

	private void ModUsu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lstuni", LogicaUnidad.getInstance().ListaUnidad());
		request.setAttribute("breadcrumb", "Modificar Usuario");
		request.setAttribute("body", "frm_mod_usuario");
		forwar("jsp/template.jsp", request, response);

	}

	private void RegUsu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lstuni",LogicaUnidad.getInstance().ListaUnidad());
		//request.setAttribute("lstPerfil",LogicaPerfil.getInstance().Listar());
		request.setAttribute("breadcrumb", "Registrar Usuario");
		request.setAttribute("body", "frm_reg_usuario");
		forwar("jsp/template.jsp", request, response);

	}

	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(jsp).forward(req, resp);
	}

	private void GestCenTrabajo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("lstOfi", LogicaOficina.getInstance().ListarOficina());
		request.setAttribute("breadcrumb", "Gestionar Centro de Trabajo");
		request.setAttribute("body", "frmGestCentroTrabajo");
		try {
			request.setAttribute("combouni", LogicaCombos.getInstance().ListaUnidad());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forwar("jsp/template.jsp", request, response);

	}

	private void pagehome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setAttribute("objResumen",
		// LogicResumenRNSP.getInstance().getResumen());
		request.setAttribute("breadcrumb", "Principal");
		request.setAttribute("body", "home");
		forwar("jsp/template.jsp", request, response);
	}

	private void pagelogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		forwar("index.jsp", request, response);
	}

	private void pagekey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Cambiar Contraseña");
		request.setAttribute("body", "modkey");
		forwar("jsp/template.jsp", request, response);
	}

	private void pagesearchHT(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Consultar Hoja de trámite");
		request.setAttribute("body", "consHT");
		forwar("jsp/template.jsp", request, response);
	}

	private void pageBandejaMP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		request.setAttribute("lstpendiente", LogicaGrillaBandeja.getInstance().BandejaPendiente(1,uni.getIdUnidad()));
		request.setAttribute("breadcrumb", "Bandeja  de documentos de la Unidad");
		request.setAttribute("body", "bandejaMP");
		forwar("jsp/template.jsp", request, response);
	}

	private void pageregdocMP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//cargar combos
		request.setAttribute("combounid", LogicaCombos.getInstance().ListaUnidad());
		request.setAttribute("combotipo", LogicaCombos.getInstance().ListaTipoDoc());
		request.setAttribute("combocont", LogicaCombos.getInstance().ListaClasContenidoDoc());
		request.setAttribute("combofunc", LogicaCombos.getInstance().ListaClasFuncionDoc());
		request.setAttribute("comboprio", LogicaCombos.getInstance().ListaPrioridadDoc());
		request.setAttribute("breadcrumb", "Registrar Documento");
		request.setAttribute("body", "regdocMP");
		forwar("jsp/template.jsp", request, response);
	}

	private void pageBandJefe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Bandeja  de documentos de Jefe");
		request.setAttribute("body", "bandejaJF");
		forwar("jsp/template.jsp", request, response);
	}



	private void pageBandArchiv(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Bandeja de Archivador");
		request.setAttribute("body", "bandejaARCH");
		forwar("jsp/template.jsp", request, response);
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
