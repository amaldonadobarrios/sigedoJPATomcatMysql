package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OficinaDAO;
import dao.impl.OficinaDAOImpl;
import entity.Oficina;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Servicio(request, response);
	}

	private void Servicio(HttpServletRequest request, HttpServletResponse response) {
		OficinaDAO dao=new OficinaDAOImpl();
		Oficina o=new Oficina();
		o.setDescripcion("AYUDANTIA");
		o.setEstado(1);
		o.setFechaMod(new Date());
		o.setFechaReg(new Date());
		o.setUsuMod(1);
		o.setUsuReg(1);
		int id=dao.save(o);
		System.out.println("OficinaDAO.save : id----: "+id );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
