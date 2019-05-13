package dominio;

public class Estadistica {

	String temporada;
	String jugador;
	String puntosPartido;
	String asistenciasPartido;
	String taponesPartido;
	String rebotesPartido;
	
	public Estadistica(String temporada, String jugador, String asistPartido, String taponPartido, String rebotPartido) {
		
		this.temporada          = temporada;
		this.jugador            = jugador;
		this.asistenciasPartido = asistPartido;
		this.taponesPartido     = taponPartido;
		this.rebotesPartido     = rebotPartido;
		
	}

	@Override
	public String toString() {
		return temporada + ", " + jugador + ", " + puntosPartido + ", " + asistenciasPartido + ", " + taponesPartido + ", " + rebotesPartido;
	}
	
	
	
}
