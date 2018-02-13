package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.CentroTrabajo;
import entity.Oficina;
import entity.Unidad;
import entity.Usuario;
import logica.LogicaCentroTrabajo;
import logica.LogicaCombos;
import logica.LogicaOficina;
import logica.LogicaUnidad;

/**
 * Servlet implementation class ServAdministracion
 */
@WebServlet("/ServAdministracion")
public class ServAdministracion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServAdministracion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Servicio(request, response);
	}

	private void Servicio(HttpServletRequest request, HttpServletResponse response)
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
						case "BUSCAR_OFICINA":
							System.out.println("hdEvento :  BUSCAR_OFICINA");
							BuscarOficina(request, response);
							break;
						case "AGREGAR_UNIDAD":
							System.out.println("hdEvento :  AGREGAR_UNIDAD");
							AgregarUnidad(request, response);
							break;
						case "AGREGAR_OFICINA":
							System.out.println("hdEvento :  AGREGAR_OFICINA");
							AgregarOficina(request, response);
							break;
						case "ASIGNAR_OFICINA":
							System.out.println("hdEvento :  ASIGNAR_OFICINA");
							AsignarOficina(request, response);
							break;
						case "AGREGAR_USUARIO":
							System.out.println("hdEvento :  AGREGAR_USUARIO");
							AgregarUsuario(request, response);
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

			}else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				System.out.println("DESTINO:" + "index.jsp");
				forwar("index.jsp", request, response);
			}
		}else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			System.out.println("DESTINO:" + "index.jsp");
			forwar("index.jsp", request, response);
		}

	}

	private void AgregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("void AgregarUsuario");
		
		
		
		
	}

	private void AsignarOficina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getName() + " : AsignarOficina");
		String id_oficina = request.getParameter("cbxoficina");
		String id_unidad = request.getParameter("cbxunidad");
		boolean existencia = false;
		boolean estadoGrabar = false;
		int id_uni = Integer.parseInt(id_unidad);
		int id_ofi = Integer.parseInt(id_oficina);
		CentroTrabajo ct = null;
		if (id_oficina != null && id_unidad != null) {
			existencia = LogicaCentroTrabajo.getInstance().ExisteCentroTrabajo(id_uni, id_ofi);
			if (existencia) {
				request.setAttribute("msgnok", "Oficina ya está asignada");
				System.out.println("Oficina ya está asignada");
			} else {
				ct = new CentroTrabajo();
				ct.setIdOficina(id_ofi);
				ct.setIdUnidad(id_uni);
				ct.setEstado(1);
				estadoGrabar = LogicaCentroTrabajo.getInstance().AgregarCentroTrabajo(ct);
				if (estadoGrabar) {
					request.setAttribute("msgok", "Oficina asignada");
				}
			}
		}
		request.setAttribute("breadcrumb", "Gestionar Centro de Trabajo");
		request.setAttribute("body", "frmGestCentroTrabajo");
		request.setAttribute("lstOfi", LogicaOficina.getInstance().ListarOficina());
		request.setAttribute("combouni", LogicaCombos.getInstance().ListaUnidad());
		forwar("jsp/template.jsp", request, response);

	}

	private void AgregarOficina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txtoficina = request.getParameter("txtoficina");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario usu = (Usuario) SesionUsuario.get(0);
		boolean existencia = false;
		boolean estadoGrabar = false;
		Oficina uni = null;
		if (txtoficina != null) {
			existencia = LogicaOficina.getInstance().ExisteOficina(txtoficina);
			if (existencia) {
				request.setAttribute("msgnok", "Oficina ya existe");
				System.out.println("Oficina ya existe");
			} else {
				uni = new Oficina();
				uni.setDescripcion(txtoficina.toUpperCase());
				uni.setUsuReg(usu.getIdUsuario());
				uni.setEstado(1);
				uni.setFechaReg(new Date());
				System.out.println("ID DE USUARIO REGISTRA: " + usu.getIdUsuario());
				estadoGrabar = LogicaOficina.getInstance().AgregarOficina(uni);
				if (estadoGrabar) {
					request.setAttribute("msgok", "Unidad Registrada");
				}
			}
		}
		request.setAttribute("lstOfi", LogicaOficina.getInstance().ListarOficina());
		request.setAttribute("breadcrumb", "Registrar Oficina");
		request.setAttribute("body", "frm_reg_oficina");
		forwar("jsp/template.jsp", request, response);
	}

	private void AgregarUnidad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txtunidad = request.getParameter("txtunidad");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario usu = (Usuario) SesionUsuario.get(0);
		boolean existencia = false;
		boolean estadoGrabar = false;
		Unidad uni = null;
		if (txtunidad != null) {
			existencia = LogicaUnidad.getInstance().ExisteUnidad(txtunidad);
			if (existencia) {
				request.setAttribute("msgnok", "Unidad ya existe");
				System.out.println("Unidad ya existe");
			} else {
				uni = new Unidad();
				uni.setDescripcion(txtunidad.toUpperCase());
				uni.setUsuReg(usu.getIdUsuario());
				uni.setEstado(1);
				uni.setFechaReg(new Date());
				System.out.println("ID DE USUARIO REGISTRA: " + usu.getIdUsuario());
				estadoGrabar = LogicaUnidad.getInstance().AgregarUnidad(uni);
				if (estadoGrabar) {
					request.setAttribute("msgok", "Unidad Registrada");
				}
			}
		}
		request.setAttribute("lstUnidad", LogicaUnidad.getInstance().ListaUnidad());
		request.setAttribute("breadcrumb", "Registrar Unidad");
		request.setAttribute("body", "frm_reg_unidad");
		forwar("jsp/template.jsp", request, response);

	}

	private void BuscarOficina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_unidad = request.getParameter("cbxunidad");
		List<Oficina> of = null;
		int id = 0;
		of = new ArrayList<Oficina>();
		if (id_unidad != null) {
			id = Integer.parseInt(id_unidad);
			of = LogicaOficina.getInstance().BuscarporIdUnidad(id);
			request.setAttribute("VcomboUnidad", id);
			request.setAttribute("listaoficina", of);
			request.setAttribute("breadcrumb", "Gestionar Centro de Trabajo");
			request.setAttribute("body", "frmGestCentroTrabajo");
			request.setAttribute("lstOfi", LogicaOficina.getInstance().ListarOficina());
			request.setAttribute("combouni", LogicaCombos.getInstance().ListaUnidad());
			forwar("jsp/template.jsp", request, response);
		}

	}

	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(jsp).forward(req, resp);
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
