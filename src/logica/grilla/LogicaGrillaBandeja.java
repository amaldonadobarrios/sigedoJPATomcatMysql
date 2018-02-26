package logica.grilla;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.lista.Bandeja;
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
    private String INI_TABLA = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
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
    
	public String BandejaRecibido (int estado_movimiento)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"trecibido\" class=\"table-responsive\">");
		str.append(INI_TABLA);
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
		cabecera.append(INI_TH);	cabecera.append("F.Actual");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Operaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    int i=1;
			for(Bandeja fila : lista  )
			{
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
						"					height=\"20\" onclick=\"fnVerPDF('"+fila.getId_fichero()+"')\">");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Seleccionar\" onclick=\"fnSeleccionarCliente('"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_fichero()+"')\" />");		str.append(FIN_TD);
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Seleccionar\" onclick=\"fnSeleccionarCliente('"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_fichero()+"')\" />");		str.append(FIN_TD);
				str.append(FINI_TR);
			i++;	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString();
	}
	public String BandejaPendiente (int estado_movimiento)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"trecibido\" class=\"table-responsive\">");
		str.append(INI_TABLA);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Operaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    int i=1;
			for(Bandeja fila : lista  )
			{
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
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Seleccionar\" onclick=\"fnSeleccionarCliente('"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_fichero()+"')\" />");		str.append(FIN_TD);
				str.append(FINI_TR);
			i++;	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString();
	}
	public String BandejaDerivado (int estado_movimiento)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Bandeja> lista=null;
		lista=LogicaBandeja.getInstance().ListarBandeja(estado_movimiento);
		StringBuilder str = new StringBuilder();
		str.append("<div id =\"trecibido\" class=\"table-responsive\">");
		str.append(INI_TABLA);
		StringBuilder cabecera = new StringBuilder();
		cabecera.append(INI_THEAD);
		cabecera.append(INI_TR);
		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha de Registro");	cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("N° HT");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Fecha Documento");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Operaciones");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    int i=1;
			for(Bandeja fila : lista  )
			{
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
				str.append(INI_TD);	str.append( "<input type=\"button\" value=\"Seleccionar\" onclick=\"fnSeleccionarCliente('"+fila.getAsunto()+"','"+fila.getDocumento()+"','"+fila.getId_fichero()+"')\" />");		str.append(FIN_TD);
				str.append(FINI_TR);
			i++;	
			}
			
			
		}
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		return str.toString();
	}
}
