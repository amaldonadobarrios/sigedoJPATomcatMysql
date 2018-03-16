package logica.grilla;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.lista.Bandeja;
import entity.lista.BandejaArchivador;
import entity.lista.Trazabilidad;
import logica.LogicaBandeja;

public class LogicaGrillaBandeja {
	// PATRON SINGLETON INI
	private static LogicaGrillaBandeja instance = null;

	public static synchronized LogicaGrillaBandeja getInstance() {
		if (instance == null) {
			instance = new LogicaGrillaBandeja();
		}
		return instance;
	}

	private LogicaGrillaBandeja() {
	}
	// PATRON SINGLETON FIN
    private String INI_TABLA0 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA1 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable1\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA2 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable2\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA3 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable3\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA4 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable4\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA5 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable5\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA6 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable6\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA7 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable7\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA8 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable8\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA9 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable9\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA10 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable10\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA11 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable11\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_TABLA12 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable12\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
    private String INI_THEAD = "<thead>";
    private String INI_TR = "<tr>";
    private String INI_TRBody = "<tr>";
    private String INI_TH = "<th>";
    private String FINI_TH = "</th>";
    private String FINI_TR = "</tr>";
    private String FIN_THEAD = "</thead>";
    private String INI_TBODY = "<tbody>";
    private String FIN_TBODY = "</tbody>";
    private String FIN_TABLA = "</table>";
    private String INI_TD = "<td nowrap>";
    private String FIN_TD = "</td>";
    
	public String BandejaRecibido (int estado_movimiento,int id_unidad_destino)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"trecibido\">");
		str.append(INI_TABLA0);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Recibido");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Derivar");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Archivar");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
				
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Derivar\" onclick=\"fnlistarOficinax('1');fnderivar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Archivar\" onclick=\"fnarchivar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_usuario_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
				
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}
	public String BandejaPendiente (int estado_movimiento,int id_unidad_destino)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tpendiente\">");
		str.append(INI_TABLA1);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Pendiente");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Operaciones");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
						str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Recibir\" onclick=\"fnrecibir('"+fila.getId_hoja_tramite()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_oficina_registro()+"','"+fila.getId_usuario_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}
	public String BandejaDerivado (int estado_movimiento,int id_unidad_destino)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tderivado\">");
		str.append(INI_TABLA2);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Pendiente");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Oficina Asignada");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Usuario Asignado");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("ReDerivar");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
						str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getOfi_destino());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getPersona_destino());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"ReDerivar\" onclick=\"fnlistarOficinax('1');fnderivar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}
	public String BandejaAdministrativo (int id_unidad_destino,int id_usuario)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandejaAdministrativo(id_unidad_destino, id_usuario);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tadmnistrativo\">");
		str.append(INI_TABLA8);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Pendiente");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Oficina Asignada");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Usuario Asignado");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Devolver");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Responder");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getOfi_destino());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getPersona_destino());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Devolver\" onclick=\"fnDevolver('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Responder\" onclick=\"fnResponder('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}
	public String BandejaRespondido (int estado_movimiento,int id_unidad_destino)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"trespuesta\" >");
		str.append(INI_TABLA7);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Respuesta");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Operacion");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/doc.png\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"downloadfile('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Validar Respuesta\" onclick=\"fnvalidar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"','"+fila.getId_usuario_registro()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);
				
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String BandejaAprobado(int estado_movimiento,int id_unidad_destino, int id_perfil) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"taprobado\" >");
		str.append(INI_TABLA4);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Respuesta");			cabecera.append(FINI_TH);
		if (id_perfil==2) {
			cabecera.append(INI_TH);	cabecera.append("Operaciones");			cabecera.append(FINI_TH);	
		}
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/doc.png\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"downloadfile('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
								if (id_perfil==2) {
									str.append(INI_TD);	str.append( "<input id=\"btncontestar\" type=\"button\" value=\"Contestar\" onclick=\"fn_combocontestar();fnContestar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"','"+fila.getId_usuario_registro()+"');\" />");		str.append(FIN_TD);
								}
								
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
			}	
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String BandejaDesestimado(int id_unidad_destino, int id_usuario) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandejaAdministrativoDesaprobado(id_unidad_destino, id_usuario);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tdesaprobado\" >");
		str.append(INI_TABLA9);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Respuesta");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Devolver");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Responder");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/doc.png\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"downloadfile('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
								str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Devolver\" onclick=\"fnDevolver('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
								str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Responder\" onclick=\"fnResponder('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String BandejaDevuelto(int estado_movimiento,int id_unidad_destino)  {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tdevuelto\" >");
		str.append(INI_TABLA3);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Recibido");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Derivar");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Archivar");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Derivar\" onclick=\"fnlistarOficinax('"+id_unidad_destino+"');fnderivar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_unidad_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Archivar\" onclick=\"fnarchivar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_usuario_registro()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String BandejaContestado(int estado_movimiento,int id_unidad_registro) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandejaContestados(estado_movimiento, id_unidad_registro);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tcontestado\" >");
		str.append(INI_TABLA5);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Contestado");			cabecera.append(FINI_TH);
		
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		 int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                   
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
						"					alt=\"Brand\" class=\"img\"\r\n" + 
						"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_ini()+"')\">");		str.append(FIN_TD);
						str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String BandejaArchivado(int estado_movimiento,int id_unidad_destino)  {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento, id_unidad_destino);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"tarchivado\">");
		str.append(INI_TABLA6);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		 int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                   
			for(Bandeja fila : lista  )
			{
				i++;
				if (fila.getId_prioridad()==3 ||  fila.getId_prioridad()==2 ) {
					INI_TRBody = "<tr bgcolor=\"#fdbba4\">";	
				}else {
					INI_TRBody = "<tr bgcolor= \"#cbfcb0\">";	
				}
			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				
				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				str.append(FINI_TR);	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String BandejaUsuarioArchivador(int idUnidad, int estado) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<BandejaArchivador> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandejaArchivador(idUnidad, estado);
		StringBuilder str = new StringBuilder();
		if (estado==1) {
			str.append("<div id =\"tarchivodigitalizado\">");
			str.append(INI_TABLA11);
		}
		if (estado==0) {
			str.append("<div id =\"tarchivopendiente\">");
			str.append(INI_TABLA10);	
		}
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("F.Archivo");			cabecera.append(FINI_TH);
		if (estado==1) {
			cabecera.append(INI_TH);	cabecera.append("F. Digitalizado");			cabecera.append(FINI_TH);	
		}
		if (estado==0) {
			cabecera.append(INI_TH);	cabecera.append("Digitalizar CARGO");			cabecera.append(FINI_TH);	
		}
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		if (estado==1) {
			cabecera.append(INI_TH);	cabecera.append("Palabras");			cabecera.append(FINI_TH);	
		}
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		 int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                   
			for(BandejaArchivador fila : lista  )
			{
				i++;
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento());			str.append(FIN_TD);
				str.append(INI_TD);	str.append(  df.format(fila.getFecha_doc()));		str.append(FIN_TD);
				str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				if (estado==1) {
					str.append(INI_TD);	str.append("<img\r\n" + 
							"					alt=\"Brand\" class=\"img\"\r\n" + 
							"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
							"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_archivo()+"')\">");		str.append(FIN_TD);
					str.append(INI_TD);	str.append( fila.getObservacionesDigitalizacion());			str.append(FIN_TD);
					str.append(INI_TD);	str.append( fila.getPalabras());			str.append(FIN_TD);
				}
				if (estado==0) {
					str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Digitalizar\" onclick=\"fnlistarOficinax('"+idUnidad+"');fndigitalizar('"+fila.getId_hoja_tramite()+"','"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_archivo()+"','"+fila.getId_documento()+"')\" />");		str.append(FIN_TD);
					str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
				}
				str.append(FINI_TR);	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}

	public String Trazabilidad(int id_ht) {
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");
		DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		List<Trazabilidad> lista=null;
		lista=LogicaBandeja.getInstance().ListarTrazabilidad(id_ht);
		StringBuilder str = new StringBuilder();
			str.append("<div id =\"ttrazatalizado\">");
			str.append(INI_TABLA12);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Origen");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Oficina Registra");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Usuario Registra");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Motivo");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Destino");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Oficina Destino");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Usuario Destino");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Observaciones");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fichero");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		 int i=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                   
			for(Trazabilidad fila : lista  )
			{
				i++;
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df2.format(fila.getFecha_reg()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getUni_reg().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getOfi_reg().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getUsu_reg().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDesc_movimiento().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getDocumento().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df2.format(fila.getFechadoc()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getUni_des().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getOfi_des().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getUsu_des().toUpperCase());			str.append(FIN_TD);
				if (fila.getObs_archivo()=="INTERNO") {
					str.append(INI_TD);	str.append( fila.getObs_movimiento().toUpperCase());			str.append(FIN_TD);	
				} else {
					str.append(INI_TD);	str.append( fila.getObs_archivo().toUpperCase());			str.append(FIN_TD);
				}
				if (fila.getId_fichero_archivo()>0) {
					str.append(INI_TD);	str.append("<img\r\n" + 
							"					alt=\"Brand\" class=\"img\"\r\n" + 
							"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
							"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero_archivo()+"')\">");		str.append(FIN_TD);	
				} else {
					if (fila.getId_est_mov_ht()==4 ||fila.getId_est_mov_ht()==5 || fila.getId_est_mov_ht()==6) {
						str.append(INI_TD);	str.append("<img\r\n" + 
								"					alt=\"Brand\" class=\"img\"\r\n" + 
								"					src=\"images/doc.png\" width=\"25\"\r\n" + 
								"					height=\"20\" onclick=\"downloadfile('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);	
					}else {
					str.append(INI_TD);	str.append("<img\r\n" + 
							"					alt=\"Brand\" class=\"img\"\r\n" + 
							"					src=\"images/pdf.jpg\" width=\"25\"\r\n" + 
							"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);			
					}
				}
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString()+"||"+i;
	}
}
