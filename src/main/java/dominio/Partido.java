package dominio;

public class Partido {

	String codigo;
	String equipoLocal;
	String equipoVisitante;
	String puntosLocal;
	String puntosVisitante;
	String temporada;
	
	public Partido(String codigo, String eqLocal, String eqVisitante, String puntLocal, String puntVisitante, String temporada) {
		
		this.codigo = codigo;
		this.equipoLocal = eqLocal;
		this.equipoVisitante = eqVisitante;
		this.puntosLocal = puntLocal;
		this.puntosVisitante = puntVisitante;
		this.temporada = temporada;
		
	}

	@Override
	public String toString() {
		return codigo + ", " + equipoLocal + ", " + equipoVisitante	+ ", " + puntosLocal + ", " + puntosVisitante + ", " + temporada;
	}
	
	
	
}
