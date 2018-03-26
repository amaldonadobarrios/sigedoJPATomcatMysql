package logica.grilla;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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
    
    public String GrillaIndicador1 ()
	{
    	NumberFormat formatterResp = new DecimalFormat("#0.0");
    	NumberFormat formatterValor = new DecimalFormat("#0");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Pretest> lista=null;
		lista=LogicaEstadistica.getInstance().listarindicador1();
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
		cabecera.append(INI_TH);	cabecera.append("Evaluación 1 : Alexander Maldonado Barrios");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Evaluación 2 : Jorge Leopoldo Liza Vilca");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Evaluación 3 : Luis Arnaldo Alvarado Cepeda");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Total de Documentos Clasficados inapropiadamente");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Total de documentos clasificados");			cabecera.append(FINI_TH);
		cabecera.append(INI_TH);	cabecera.append("Porcentade de documentos clasificados inapropiadamente");			cabecera.append(FINI_TH);
		cabecera.append(FINI_TR);
		cabecera.append(FIN_THEAD);
		int i=0;
		double sumval1=0;
		double sumval2=0;
		double rpta=0;
		str.append(cabecera.toString());
		str.append(INI_TBODY);
		if(  lista!=null && lista.size()>0 )
		{
                    
			for(Pretest fila : lista  )
			{
				i++;			
				str.append(INI_TRBody);
				str.append(INI_TD);	str.append( i );			str.append(FIN_TD);
				str.append(INI_TD);	str.append( df.format(fila.getFechadoc()));				str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getSiglas().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getAsunto().toUpperCase());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getEva1());			str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getEva2());		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getEva3());		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getValor1());		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getValor2());		str.append(FIN_TD);
				str.append(INI_TD);	str.append( fila.getRespuesta());		str.append(FIN_TD);
				str.append(FINI_TR);	
				sumval1=sumval1+fila.getValor1();
				sumval2=sumval2+fila.getValor2();
			}	
		}
		
		str.append(FIN_TBODY);
		str.append(FIN_TABLA);
		str.append("</div>");
		rpta=((sumval1/sumval2)*100);
		return str.toString()+"||"+i+"||"+formatterValor.format(sumval1)+"||"+formatterValor.format(sumval2)+"||"+formatterResp.format(rpta);
	}
}
