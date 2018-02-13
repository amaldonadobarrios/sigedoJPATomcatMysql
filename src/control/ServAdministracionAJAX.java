package control;

import java.io.IOException;
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

import entity.Oficina;
import entity.Persona;
import entity.Usuario;
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

	private void ConsultarUsuarioCip(HttpServletRequest request, HttpServletResponse response) {
		String cip = request.getParameter("cip");
		Persona per = null;
		Usuario usu = null;
		JsonArray array = null;
		String json = "";
		if (cip != null) {
			array = new JsonArray();
			per = new Persona();
			per = LogicaPersona.getInstance().Buscarxcip(cip);
			usu = new Usuario();
			if (per != null) {
				usu = LogicaUsuario.getInstance().BuscarUsuarioxIdPersona(per.getIdPersona());
				Gson gson = new Gson();
				json = gson.toJson(per);
				array.add(json);
				json = gson.toJson(usu);
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
