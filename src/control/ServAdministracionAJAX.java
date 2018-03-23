package control;

import java.io.IOException;
import java.sql.SQLException;
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
import entity.ClasContenidoDoc;
import entity.ClasFuncionDoc;
import entity.Oficina;
import entity.Persona;
import entity.PrioridadDoc;
import entity.TipoDoc;
import entity.Unidad;
import entity.Usuario;
import entity.lista.Administrativo;
import logica.LogicaCentroTrabajo;
import logica.LogicaCombos;
import logica.LogicaGrafico;
import logica.LogicaOficina;
import logica.LogicaPersona;
import logica.LogicaSeguridad;
import logica.LogicaUsuario;
import util.BatEncriptador;
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
						case "COMBOS_CONTESTAR":
							System.out.println("hdEvento :  COMBOS_CONTESTAR");
							CombosContestar(request, response);
							break;
						case "VER_GRAFICOS":
							System.out.println("hdEvento :  VER_GRAFICOS");
							verGraficos(request, response);
							break;
						case "CAMBIAR_CLAVE":
							System.out.println("hdEvento :  CAMBIAR_CLAVE");
							try {
								cambiarClave(request, response);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "CAMBIAR_CLAVEADM":
							System.out.println("hdEvento :  CAMBIAR_CLAVEADM");
							try {
								cambiarClaveADM(request, response);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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

	
	
	
	private void cambiarClaveADM(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("void cambiarClaveADM");
		String html = null;
		boolean resp=false;
		String act=request.getParameter("act").trim();
		String id_usuario=request.getParameter("id_usuario").trim();
		Usuario user= new Usuario();
		user.setIdUsuario(Integer.parseInt(id_usuario));
		user.setPassword(BatEncriptador.getInstance().Encripta(act));
		resp=LogicaUsuario.getInstance().ModificarClave(user);
		if (resp) {
		html="1";
		}else {
			html="0";	
		}
		HtmlUtil.getInstance().escrituraHTML(response, html);
		
	}

	private void cambiarClave(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("void cambiarClave");
		String html = null;
		boolean resp=false;
		String act=request.getParameter("act").trim();
		String new1=request.getParameter("new1");
		String new2=request.getParameter("new2");
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Usuario user = (Usuario) SesionUsuario.get(0);
		boolean est=LogicaSeguridad.getInstance().ValidacionClave(user.getIdUsuario(), act);
		if (est==true) {
			if (new1.equals(new2)) {
				user.setPassword(BatEncriptador.getInstance().Encripta(new1));
				resp=LogicaUsuario.getInstance().ModificarClave(user);
				if (resp) {
					html="1";
				}
			}else {
				html="0";
			}
		}else {
			html="0";
		}
		HtmlUtil.getInstance().escrituraHTML(response, html);	
	}

	private void verGraficos(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession();
		ArrayList<Object> SesionUsuario = (ArrayList<Object>) sesion.getAttribute("usuario");
		Unidad uni = (Unidad) SesionUsuario.get(3);
		HtmlUtil.getInstance().escrituraHTML(response, LogicaGrafico.getInstance().GenerarGraficos(uni.getIdUnidad()));	
		
	}

	private void CombosContestar(HttpServletRequest request, HttpServletResponse response) {
		String Array=null;
		JsonArray arrayTipoDoc = null;
		JsonArray arrayClasConDoc = null;
		JsonArray arrayClasFunDoc = null;
		JsonArray arrayPrioridadDoc = null;
		JsonArray arrayDestinoDoc = null;
		List<TipoDoc> tdoc = null;
		List<ClasContenidoDoc> clascon = null;
		List<ClasFuncionDoc> clasfun = null;
		List<PrioridadDoc> Prioridad = null;
		List<Unidad> unidad = null;
		
		try {
			tdoc=LogicaCombos.getInstance().ListaTipoDoc();
			clascon=LogicaCombos.getInstance().ListaClasContenidoDoc();
			clasfun=LogicaCombos.getInstance().ListaClasFuncionDoc();
			Prioridad=LogicaCombos.getInstance().ListaPrioridadDoc();
			unidad=LogicaCombos.getInstance().ListaUnidad();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (tdoc != null) {
			arrayTipoDoc = new JsonArray();
			for (TipoDoc t : tdoc) {
				JsonObject object = new JsonObject();
				object.addProperty("id", t.getIdTipoDoc());
				object.addProperty("detalle", t.getDescripcion());
				arrayTipoDoc.add(object);
			}
		}
		if (clascon != null) {
			arrayClasConDoc = new JsonArray();
			for (ClasContenidoDoc t : clascon) {
				JsonObject object = new JsonObject();
				object.addProperty("id", t.getIdClasContenidoDoc());
				object.addProperty("detalle", t.getDescripcion());
				arrayClasConDoc.add(object);
			}
		}
		if (clasfun != null) {
			arrayClasFunDoc = new JsonArray();
			for (ClasFuncionDoc t : clasfun) {
				JsonObject object = new JsonObject();
				object.addProperty("id", t.getIdClasFuncionDoc());
				object.addProperty("detalle", t.getDescripcion());
				arrayClasFunDoc.add(object);
			}
		}
		if (Prioridad != null) {
			arrayPrioridadDoc = new JsonArray();
			for (PrioridadDoc t : Prioridad) {
				JsonObject object = new JsonObject();
				object.addProperty("id", t.getIdPrioridadDoc());
				object.addProperty("detalle", t.getDescripcion());
				arrayPrioridadDoc.add(object);
			}
		}
		if (unidad != null) {
			arrayDestinoDoc = new JsonArray();
			for (Unidad t : unidad) {
				JsonObject object = new JsonObject();
				object.addProperty("id", t.getIdUnidad());
				object.addProperty("detalle", t.getDescripcion());
				arrayDestinoDoc.add(object);
			}
		}
		
		Array=arrayTipoDoc.toString()+"||"+
		arrayClasConDoc+"||"+
		arrayClasFunDoc+"||"+
		arrayPrioridadDoc+"||"+
		arrayDestinoDoc;

		HtmlUtil.getInstance().escrituraHTML(response, Array);	
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
