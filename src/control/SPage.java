package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.LogicaCombos;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "BandejaMP":
                this.pageBandejaMP(request, response);
                break;
            case "RegdocMP":
                this.pageregdocMP(request, response);
                break;
            case "BandJefe":
                this.pageBandJefe(request, response);
                break;
            case "RegordenJF":
                this.pageRegordenJF(request, response);
                break;
            case "BandArchiv":
                this.pageBandArchiv(request, response);
                break;
            case "GestCenTrabajo":
            	this.GestCenTrabajo(request, response);
            	break;
            default:
                this.pagelogin(request, response);
                break;

        }
	}
	
	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(jsp).forward(req, resp);
    }
	private void GestCenTrabajo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		request.setAttribute("breadcrumb", "Gestionar Centro de Trabajo");
        request.setAttribute("body", "frmGestCentroTrabajo");
        try {
			request.setAttribute("combouni", LogicaCombos.getInstance().ListaUnidad());
			request.setAttribute("comboofi", LogicaCombos.getInstance().ListaOficina());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        forwar("jsp/template.jsp", request, response);
		
	}

    private void pagehome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setAttribute("objResumen", LogicResumenRNSP.getInstance().getResumen());
        request.setAttribute("breadcrumb", "Principal");
        request.setAttribute("body", "home");
        forwar("template.jsp", request, response);
    }

     private void pagelogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwar("jsp/dinamico/login.html", request, response);
    }

    private void pagekey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Cambiar Contraseña");
        request.setAttribute("body", "modkey");
        forwar("template.jsp", request, response);
    }

    private void pagesearchHT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Consultar Hoja de trámite");
        request.setAttribute("body", "consHT");
        forwar("template.jsp", request, response);
    }

    private void pageBandejaMP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Bandeja  de documentos de la Unidad");
        request.setAttribute("body", "bandejaMP");
        forwar("template.jsp", request, response);
    }

    private void pageregdocMP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Registrar Documento");
        request.setAttribute("body", "regdocMP");
        forwar("template.jsp", request, response);
    }

    private void pageBandJefe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Bandeja  de documentos de Jefe");
        request.setAttribute("body", "bandejaJF");
        forwar("template.jsp", request, response);
    }

    private void pageRegordenJF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Registrar Orden");
        request.setAttribute("body", "regordenJF");
        forwar("template.jsp", request, response);
    }

    private void pageBandArchiv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("breadcrumb", "Bandeja de Archivador");
        request.setAttribute("body", "bandejaARCH");
        forwar("template.jsp", request, response);
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
