package paquete.covid;

public class DatosCovid {
private String fecha;
private int numero_casos, numero_casos_pcr;

public DatosCovid(String fecha, int numero_casos, int numero_casos_pcr) {
	super();
	this.fecha = fecha;
	this.numero_casos = numero_casos;
	this.numero_casos_pcr = numero_casos_pcr;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public int getNumero_casos() {
	return numero_casos;
}
public void setNumero_casos(int numero_casos) {
	this.numero_casos = numero_casos;
}
public int getNumero_casos_pcr() {
	return numero_casos_pcr;
}
public void setNumero_casos_pcr(int numero_casos_pcr) {
	this.numero_casos_pcr = numero_casos_pcr;
}

}
