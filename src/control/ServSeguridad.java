package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import logica.LogicaSeguridad;

/**
 * Servlet implementation class ServSeguridad
 */
@WebServlet(description = "Validacion de Usuarios", urlPatterns = { "/ServSeguridad" })
public class ServSeguridad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServSeguridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet: " + this.getClass().getName());
		String usu = request.getParameter("username").trim();
		String pas = request.getParameter("password").trim();

		if (usu == null || pas == null) {
			redireccionar(request, response, "index.jsp");
		} else {
			if (usu != "" && pas != "") {
				try {
					if (validar(usu, pas)) {
						System.out.println("BIENVENIDO AL SISTEMA");
						request.setAttribute("body", "home");
						redireccionar(request, response, "jsp/template.jsp");
					} else {
						System.out.println("ERROR DE VALIDACION");
						redireccionar(request, response, "index.jsp");
					}
				} catch (SQLException e) {
					System.out.println("ERROR DE SISTEMA");
					redireccionar(request, response, "index.jsp");
					e.printStackTrace();

				}
			}
		}

	}

	private void redireccionar(HttpServletRequest request, HttpServletResponse response, String string)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(string);
		rd.forward(request, response);

	}

	private boolean validar(String usu, String pas) throws SQLException {
		System.out.println("Validar : usu : " + usu + " Pass: " + pas);
		return LogicaSeguridad.getInstance().Validacion(usu, pas);
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
