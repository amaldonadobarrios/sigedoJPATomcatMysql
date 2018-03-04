package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.CentroTrabajo;
import entity.Oficina;
import entity.Persona;
import entity.Usuario;
import entity.lista.Administrativo;
import logica.LogicaCentroTrabajo;
import logica.LogicaOficina;
import logica.LogicaPersona;
import logica.LogicaUsuario;
import util.HtmlUtil;

/**
 * Servlet implementation class ServAdmnistracionAJAX
 */
@WebServlet("/ServAdmnistracionAJAX")
public class ServAdministracionAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServAdministracionAJAX() {
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
						case "COMBO_OFICINA":
							System.out.println("hdEvento :  COMBO_OFICINA");
							ComboOficina(request, response);
							break;
						case "CONSULTAR_USUARIO":
							System.out.println("hdEvento :  CONSULTAR_USUARIO");
							ConsultarUsuarioCip(request, response);
							break;
						case "COMBO_ADMINISTRATIVO":
							System.out.println("hdEvento :  COMBO_ADMINISTRATIVO");
							ComboAdministrativo(request, response);
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

	private void ComboAdministrativo(HttpServletRequest request, HttpServletResponse response) {
		String id_unidad = request.getParameter("id_unidad");
		String id_oficina = request.getParameter("id_oficina");
		System.out.println("LA UNIDAD ES: "+id_unidad + " La Oficina es : "+id_oficina);
		JsonArray array = null;
		List<Administrativo> usu = null;
		if (id_unidad != null) {
			try {
				usu = LogicaUsuario.getInstance().listaAdministrativosActivos(Integer.parseInt(id_unidad), Integer.parseInt(id_oficina));
			} catch (Exception e) {
				System.out.println("NO hay oficinas");
			}

		}
		if (usu != null) {
			array = new JsonArray();
			for (Administrativo Administrativo : usu) {
				JsonObject object = new JsonObject();
				object.addProperty("id", Administrativo.getId_usuario());
				object.addProperty("detalle", Administrativo.getDetalle());
				array.add(object);
			}
		}
		if (array != null) {
			HtmlUtil.getInstance().escrituraHTML(response, array.toString());
		} else {
			HtmlUtil.getInstance().escrituraHTML(response, "VACIO");
		}
		
	}

	private void ConsultarUsuarioCip(HttpServletRequest request, HttpServletResponse response) {
		String cip = request.getParameter("cip");
		Persona per = null;
		Usuario usu = null;
		CentroTrabajo ct=null;
		JsonArray array = null;
		String json = "";
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		if (cip != null) {
			array = new JsonArray();
			per = new Persona();
			if (user!=null) {
				//SI EL USUARIO ES ADMINISTRADOR SOLO MODIFICA A USUARIOS BASICOS
				if (user.getIdPerfil()==1) {
					per = LogicaPersona.getInstance().BuscarxCipSinPrivilegios(cip);	
				}else {
					//SINO TIENE PRIVILEGIO DE SUPER ADMINISTRADOR MODIFICA TODO
					per = LogicaPersona.getInstance().Buscarxcip(cip);
				}
			}
			usu = new Usuario();
			if (per != null) {
				ct= new CentroTrabajo();
				ct=LogicaCentroTrabajo.getInstance().BuscarporId(per.getIdCentroTrabajo());
				usu = LogicaUsuario.getInstance().BuscarUsuarioxIdPersona(per.getIdPersona());
				Gson gson = new Gson();
				json = gson.toJson(per);
				array.add(json);
				json = gson.toJson(usu);
				array.add(json);
				json = gson.toJson(ct);
				array.add(json);
				List<Oficina> ofi = null;
				ofi = LogicaOficina.getInstance().BuscarporIdUnidad(ct.getIdUnidad());
				json = gson.toJson(ofi);
				array.add(json);
				// System.out.println(json);
			}else {
				HtmlUtil.getInstance().escrituraHTML(response, "VACIO");	
			}
		}
		if (array != null) {
			HtmlUtil.getInstance().escrituraHTML(response, array.toString());
		} else {
			HtmlUtil.getInstance().escrituraHTML(response, "VACIO");
		}

	}

	private void ComboOficina(HttpServletRequest request, HttpServletResponse response) {
		String id_unidad = request.getParameter("id_unidad");
		System.out.println("LA UNIDAD ES: "+id_unidad);
		JsonArray array = null;
		List<Oficina> ofi = null;
		if (id_unidad != null) {
			try {
				ofi = LogicaOficina.getInstance().BuscarporIdUnidad(Integer.parseInt(id_unidad));
			} catch (Exception e) {
				System.out.println("NO hay oficinas");
			}

		}
		if (ofi != null) {
			array = new JsonArray();
			for (Oficina oficina : ofi) {
				JsonObject object = new JsonObject();
				object.addProperty("id", oficina.getUsuReg());
				object.addProperty("detalle", oficina.getDescripcion());
				array.add(object);
			}
		}
		if (array != null) {
			HtmlUtil.getInstance().escrituraHTML(response, array.toString());
		} else {
			HtmlUtil.getInstance().escrituraHTML(response, "VACIO");
		}
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
