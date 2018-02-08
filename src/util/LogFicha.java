package util;

import java.util.HashMap;
import java.util.Map;

public class LogFicha 
{
	
	private static LogFicha instance = null;
	//*******************************************************************************************************************
	//*******************************************************************************************************************
	
	public static synchronized LogFicha getInstance() {
		if (instance == null) {		instance = new LogFicha();		}
		return instance;
	}
	
	
	Map<Integer, String> HsPaginas ;
	
	
	
	public LogFicha()
	{
		this.HsPaginas = new HashMap<Integer, String>();
		this.HsPaginas.put(100, "/index.jsp");
		this.HsPaginas.put(101, "/jsp/form/consultaEfectivos.jsp");
		this.HsPaginas.put(102, "/jsp/form/DatosFamiliares.jsp");
		this.HsPaginas.put(103, "/jsp/form/Unidad.jsp");
		this.HsPaginas.put(104, "/jsp/form/Estudios_Cursos.jsp");
		this.HsPaginas.put(105, "/jsp/form/ingreso_usuarios.jsp");
		
		
		
		
		
	}
	
	public void mostrarConsola(String... parametro )
	{
		
		StringBuffer strcad = new  StringBuffer("");
		if(parametro.length>0  )
		{
			for( int i=0; i< parametro.length ; i++  )
			{
				strcad.append( " "+parametro[i] );
			}
		}
		
		System.out.println( strcad.toString() );
		
	}
	
	
	public void mostrarConsolaDato(String clase, String metodo , String... parametro )
	{
		
		StringBuffer strcad = new  StringBuffer("");
		strcad.append("clase:"+clase);
		strcad.append(" metodo:"+metodo);
		
		
		if(parametro.length>0  )
		{
			for( int i=0; i< parametro.length ; i++  )
			{
				strcad.append( " "+parametro[i] );
			}
		}
		
		System.out.println( strcad.toString() );
		
	}
	
	
	public String  getPagina(int idpagina )
	{
		
		String pagina = HsPaginas.get(idpagina);
		if( pagina ==null  )
		{  pagina = ConstantSIGEDO.JSP_INI ; }
		
		return pagina;
		
	}
	
	
	

}
