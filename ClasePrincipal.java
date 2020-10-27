package paquete.covid;
import java.util.*;
public class ClasePrincipal {
public static void main(String[] args) {
	HashMap<String, ArrayList<DatosCovid>> mapa_datos=AccesoDatos.leerFichero();
	HashMap <String, String> mapa_tablas=PintarHTML.crearTablas(mapa_datos);
	AccesoDatos.crearFicheros(mapa_tablas);
}
}
