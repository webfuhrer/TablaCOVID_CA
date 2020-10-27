package paquete.covid;

import java.util.ArrayList;
import java.util.HashMap;

public class PintarHTML {

	public static HashMap<String, String> crearTablas(HashMap<String, ArrayList<DatosCovid>> mapa_datos) {
		HashMap<String, String> mapa_tablas=new HashMap();
		for (String ca: mapa_datos.keySet())
		{
			String html_tabla="<table border=1>"
					+ "<tr><th>Comunidad: "+ca+"</th><th>Num casos</th>"
							+ "<th>Num casos PCR</th></tr>";
			ArrayList<DatosCovid> lista_datos=mapa_datos.get(ca);
			for(DatosCovid d: lista_datos)
			{
				html_tabla+="<tr><td>"+d.getFecha()+"</td>";
				html_tabla+="<td>"+d.getNumero_casos()+"</td>";
				html_tabla+="<td>"+d.getNumero_casos_pcr()+"</td></tr>";
				
			}
			html_tabla+="</table>";
			mapa_tablas.put(ca, html_tabla);
		}
		return mapa_tablas;
	}

}
