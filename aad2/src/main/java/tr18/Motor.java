package tr18;

public class Motor 
{
	int revoluciones;
	String tipo;
	public Motor(int revoluciones, String tipo) {
		super();
		this.revoluciones = revoluciones;
		this.tipo = tipo;
	}
	public int getRevoluciones() {
		return revoluciones;
	}
	public void setRevoluciones(int revoluciones) {
		this.revoluciones = revoluciones;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
