package paquete.covid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AccesoDatos {
private static String ruta_base="T:\\ficheros\\";
private static String fichero_entrada="datos_ccaas.csv";
	public static HashMap<String, ArrayList<DatosCovid>> leerFichero() {
		HashMap<String, ArrayList<DatosCovid>> mapa=new HashMap<String, ArrayList<DatosCovid>>();
		try {
			FileReader fr=new FileReader(ruta_base+fichero_entrada);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();//Paso de estya linea
			linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(",");
				String codigo_ca=datos[0];
				String fecha=datos[1];
				int num_casos=Integer.parseInt(datos[2]);
				int num_casos_pcr=Integer.parseInt(datos[3]);
				DatosCovid c=new DatosCovid(fecha, num_casos, num_casos_pcr);
				if (mapa.containsKey(codigo_ca))
				{
					mapa.get(codigo_ca).add(c);
				}
				else
				{
					ArrayList<DatosCovid> lista_datos=new ArrayList<DatosCovid>();
					lista_datos.add(c);
					mapa.put(codigo_ca, lista_datos);
				}
				linea=br.readLine();	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapa;
	}
	public static void crearFicheros(HashMap<String, String> mapa_tablas) {
		String cabecera="<html><head></head><body>";
		String pie="</body></html>";
		String link_volver="<a href=indice.html>VOLVER</a>";
		FileWriter fw_indice=null;
		try {
			fw_indice = new FileWriter(ruta_base+"indice.html");
			fw_indice.write(cabecera);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(String ca: mapa_tablas.keySet())
		{
			try {
				fw_indice.write("<br><a href="+ca+".html>Ver COVID en "+ca+"</a>");
				FileWriter fw=new FileWriter(ruta_base+ca+".html");
				fw.write(cabecera+link_volver+mapa_tablas.get(ca)+pie);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fw_indice.write(pie);
			fw_indice.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
