package ec.edu.ups.examen.Final.services;

public class ErrorMensaje {

	private int id;
	private String mensaje;
	

	
	public ErrorMensaje(int id, String mensaje) {
		super();
		this.id = id;
		this.mensaje = mensaje;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
