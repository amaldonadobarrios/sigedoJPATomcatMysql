package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.Oficina;
import logica.LogicaCentroTrabajo;
import logica.LogicaOficina;
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

	private void ComboOficina(HttpServletRequest request, HttpServletResponse response) {
		String id_unidad = request.getParameter("id_unidad");
		JsonArray array =null;
		List<Oficina> ofi = null;
		if (id_unidad != null) {
			try {
				ofi=LogicaOficina.getInstance().BuscarporIdUnidad(Integer.parseInt(id_unidad));	
			} catch (Exception e) {
				System.out.println("NO hay oficinas");
			}
			
		
		}
		if (ofi!=null) {
				array= new JsonArray();
			for (Oficina oficina : ofi) {
				JsonObject object = new JsonObject();
				object.addProperty("id", oficina.getUsuReg());
				object.addProperty("detalle",oficina.getDescripcion());
				array.add(object);
			}			
		}
		if (array!=null) {
			HtmlUtil.getInstance().escrituraHTML(response, array.toString());	
		}else {
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
