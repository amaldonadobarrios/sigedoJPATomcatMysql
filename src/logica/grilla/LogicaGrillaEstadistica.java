package logica.grilla;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.estadistica.EstDocumentoRecibido;
import entity.estadistica.PostTest;
import entity.estadistica.Pretest;
import entity.lista.Bandeja;
import logica.LogicaEstadistica;

public class LogicaGrillaEstadistica {

	// PATRON SINGLETON INI
	private static LogicaGrillaEstadistica instance = null;

	public static synchronized LogicaGrillaEstadistica getInstance() {
		if (instance == null) {
			instance = new LogicaGrillaEstadistica();
		}
		return instance;
	}

	private LogicaGrillaEstadistica() {
	}
	// PATRON SINGLETON FIN
	private String INI_TABLA14 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable14\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
	private String INI_TABLA15 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable15\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
	private String INI_TABLA16 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable16\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
	private String INI_TABLA17 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable17\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
	private String INI_TABLA18 = "<table class=\"table  table-bordered table-hover table-condensed\" id=\"dataTable18\" width=\"100%\" cellspacing=\"0\" style=\"font-size:11px\">";
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
    
    
    public String GrillaIndicador1ACTUALIZADO ()
    
   	{
       	NumberFormat formatterResp = new DecimalFormat("#0");
       	NumberFormat formatterValor = new DecimalFormat("#0");
   		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		List<Pretest> lista=null;
   		lista=LogicaEstadistica.getInstance().listarindicador1ACTUALIZADO();
   		StringBuilder str = new StringBuilder();
   		str.append("<div id =\"tpretest1\">");
   		str.append(INI_TABLA14);
   		StringBuilder cabecera = new StringBuilder();
   		cabecera.append(INI_THEAD);
   		cabecera.append(INI_TR);
   		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha de Documento");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Siglas");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Evaluación");			cabecera.append(FINI_TH);
   		cabecera.append(FINI_TR);
   		cabecera.append(FIN_THEAD);
   		int i=0;
   		double io=0;
   		double contador_inapropiado=0;
   		double rpta=0;
   		str.append(cabecera.toString());
   		str.append(INI_TBODY);
   		if(  lista!=null && lista.size()>0 )
   		{
                       
   			for(Pretest fila : lista  )
   			{
   				i++;
   				io++;
   				str.append(INI_TRBody);
   				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFechadoc()));				str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getSiglas().toUpperCase());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getAsunto().toUpperCase());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getEva1());			str.append(FIN_TD);
   				str.append(FINI_TR);
   				if (fila.getEva1().equals("INAPROPIADO")) {
   					contador_inapropiado++;
				}
   			}	
   		}
   		
   		str.append(FIN_TBODY);
   		str.append(FIN_TABLA);
   		str.append("</div>");
   		
   		rpta=(contador_inapropiado/io)*100;
   		System.out.println("RESPUESTA: "+rpta);
   		return str.toString()+"||"+i+"||"+formatterValor.format(contador_inapropiado)+"||"+formatterValor.format(i)+"||"+formatterResp.format(rpta);
   	}
    public String GrillaIndicador2 ()
   	{
       	NumberFormat formatterResp = new DecimalFormat("#0");
       	NumberFormat formatterValor = new DecimalFormat("#0");
   		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		List<Pretest> lista=null;
   		lista=LogicaEstadistica.getInstance().listarindicador2();
   		StringBuilder str = new StringBuilder();
   		str.append("<div id =\"tpretest2\">");
   		str.append(INI_TABLA15);
   		StringBuilder cabecera = new StringBuilder();
   		cabecera.append(INI_THEAD);
   		cabecera.append(INI_TR);
   		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha de Documento");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Siglas");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Duracion de la busqueda de documentos para su consulta( EN MINUTOS)");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Consultas contestadas a documentos dentro del plazo de 15 min");			cabecera.append(FINI_TH);
   		cabecera.append(FINI_TR);
   		cabecera.append(FIN_THEAD);
   		int i=0;
   		double io=0;
   		double contador_SI=0;
   		double rpta=0;
   		str.append(cabecera.toString());
   		str.append(INI_TBODY);
   		if(  lista!=null && lista.size()>0 )
   		{
                       
   			for(Pretest fila : lista  )
   			{
   				i++;
   				io++;
   				str.append(INI_TRBody);
   				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFechadoc()));				str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getSiglas().toUpperCase());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getAsunto().toUpperCase());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getEva1());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getEva2());			str.append(FIN_TD);
   				str.append(FINI_TR);
   				if (fila.getEva2().equals("SI")) {
   					contador_SI++;
				}
   			}	
   		}
   		
   		str.append(FIN_TBODY);
   		str.append(FIN_TABLA);
   		str.append("</div>");
   		
   		rpta=(contador_SI/io)*100;
   		return str.toString()+"||"+i+"||"+formatterValor.format(contador_SI)+"||"+formatterValor.format(i)+"||"+formatterResp.format(rpta);
   	}
    public String GrillaEstadisticaDocumentosRecibidos (int id_unidad,String fecha1, String fecha2)
   	{
   		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		List<EstDocumentoRecibido> lista=null;
   		lista=LogicaEstadistica.getInstance().listarDocumentoRecibidoEst(id_unidad, fecha1, fecha2);
   		StringBuilder str = new StringBuilder();
   		str.append("<div id =\"tEstDocRec\">");
   		str.append(INI_TABLA16);
   		StringBuilder cabecera = new StringBuilder();
   		cabecera.append(INI_THEAD);
   		cabecera.append(INI_TR);
   		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha de Documento");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Siglas");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Asunto");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Nro HT");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha Recibido");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Estado HT");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Estado actualización");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha actualización");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("observaciones");			cabecera.append(FINI_TH);
   		cabecera.append(FINI_TR);
   		cabecera.append(FIN_THEAD);
   		int i=0;
   		str.append(cabecera.toString());
   		str.append(INI_TBODY);
   		if(  lista!=null && lista.size()>0 )
   		{           
   			for(EstDocumentoRecibido fila : lista  )
   			{
   				i++;
   				str.append(INI_TRBody);
   				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFechadoc()));				str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getDocumento().toUpperCase());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getAsunto().toUpperCase());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getId_hoja_tramite());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFechareg()));			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getEstht());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getEstmax());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFecharegmax()));			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getObservaciones());			str.append(FIN_TD);
   				str.append(FINI_TR);
   				
   			}	
   		}
   		
   		str.append(FIN_TBODY);
   		str.append(FIN_TABLA);
   		str.append("</div>");
   		
   		return str.toString()+"||"+i;
   	}
    public String GrillaLocalizacion_doc(int id_unidad,String fecha1, String fecha2)
   	{
   		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		NumberFormat formatterValor = new DecimalFormat("#0.00");
   		NumberFormat formatterValorE = new DecimalFormat("#0");
   		double totaldoc=0;
   		double totalenc=0;
   		double totindicador=0;
   		double contraindicador=0;
   		List<PostTest> lista=null;
   		lista=LogicaEstadistica.getInstance().Localizacion_Doc_PostTest(id_unidad, fecha1, fecha2);
   		StringBuilder str = new StringBuilder();
   		str.append("<div id =\"tIndicador1\">");
   		str.append(INI_TABLA17);
   		StringBuilder cabecera = new StringBuilder();
   		cabecera.append(INI_THEAD);
   		cabecera.append(INI_TR);
   		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Cantidad de Documentos Consultados (CDC)");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Cantidad de documentos Localizados (CDL)");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Localización de documentos (LD)");			cabecera.append(FINI_TH);
 		cabecera.append(FINI_TR);
   		cabecera.append(FIN_THEAD);
   		int i=0;
   		str.append(cabecera.toString());
   		str.append(INI_TBODY);
   		if(  lista!=null && lista.size()>0 )
   		{           
   			for(PostTest fila : lista  )
   			{
   				i++;
   				str.append(INI_TRBody);
   				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFecha()));				str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getCant_total());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getCant_encontrada());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getIndicador());			str.append(FIN_TD);
   				str.append(FINI_TR);
   				totaldoc=totaldoc+fila.getCant_total();
   				totalenc=totalenc+fila.getCant_encontrada();
   			}	
   			totindicador=(totalenc/totaldoc)*100;
   			contraindicador=100-totindicador;
   		}
   		
   		str.append(FIN_TBODY);
   		str.append(FIN_TABLA);
   		str.append("</div>");
   		return str.toString()+"||"+i+"||"+formatterValor.format(totindicador)+"||"+formatterValorE.format(totaldoc)+"||"+formatterValorE.format(totalenc)+"||"+fecha1+"||"+fecha2+"||"+formatterValor.format(contraindicador);
   	}
    public String GrillaNivelServicio(int id_unidad,String fecha1, String fecha2)
   	{
   		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		NumberFormat formatterValor = new DecimalFormat("#0.00");
   		NumberFormat formatterValorE = new DecimalFormat("#0");
   		double totaldoc=0;
   		double totalenc=0;
   		double totindicador=0;
   		double contraindicador=0;
   		List<PostTest> lista=null;
   		lista=LogicaEstadistica.getInstance().Nivel_Serv_PostTest(id_unidad, fecha1, fecha2);
   		StringBuilder str = new StringBuilder();
   		str.append("<div id =\"tIndicador2\">");
   		str.append(INI_TABLA18);
   		StringBuilder cabecera = new StringBuilder();
   		cabecera.append(INI_THEAD);
   		cabecera.append(INI_TR);
   		cabecera.append(INI_TH);	cabecera.append("N°");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Fecha");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Documentos Recibidos - Peticiones Recibidas (PR)");	cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Documentos tramitados -Peticiones atendidas (PA)");			cabecera.append(FINI_TH);
   		cabecera.append(INI_TH);	cabecera.append("Nivel de Servicio (NS)");			cabecera.append(FINI_TH);
 		cabecera.append(FINI_TR);
   		cabecera.append(FIN_THEAD);
   		int i=0;
   		str.append(cabecera.toString());
   		str.append(INI_TBODY);
   		if(  lista!=null && lista.size()>0 )
   		{           
   			for(PostTest fila : lista  )
   			{
   				i++;
   				str.append(INI_TRBody);
   				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( df.format(fila.getFecha()));				str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getCant_total());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getCant_encontrada());			str.append(FIN_TD);
   				str.append(INI_TD);	str.append( fila.getIndicador());			str.append(FIN_TD);
   				str.append(FINI_TR);
   				totaldoc=totaldoc+fila.getCant_total();
   				totalenc=totalenc+fila.getCant_encontrada();
   			}	
 			totindicador=(totalenc/totaldoc)*100;
   			contraindicador=100-totindicador;
   		}
   		
   		str.append(FIN_TBODY);
   		str.append(FIN_TABLA);
   		str.append("</div>");
   		return str.toString()+"||"+i+"||"+formatterValor.format(totindicador)+"||"+formatterValorE.format(totaldoc)+"||"+formatterValorE.format(totalenc)+"||"+fecha1+"||"+fecha2+"||"+formatterValor.format(contraindicador);
   	}


}


