package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Oficina;
import logica.LogicaCombos;
import logica.LogicaOficina;

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

	private void Servicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		String evento2=request.getParameter("hdEvento2");
		if (evento2!=null|| evento2!="") {
			
			switch (evento2) {
			case "BUSCAR_OFICINA":
				System.out.println("hdEvento2 :  BUSCAR_OFICINA");
				BuscarOficina(request,response);
				break;
			default:
				break;
			}
			
			
			
		}
		
	
		
	}

	private void BuscarOficina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_unidad=request.getParameter("cbxunidad");
		List<Oficina> of=null;
		int id=0;
		of=new ArrayList<Oficina>();
		if (id_unidad!=null) {
			 id=Integer.parseInt(id_unidad);
			 of=LogicaOficina.getInstance().BuscarporIdUnidad(id);
			 	request.setAttribute("VcomboUnidad", id);
			 	request.setAttribute("listaoficina", of);
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
		
		
		
	}
	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(jsp).forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
