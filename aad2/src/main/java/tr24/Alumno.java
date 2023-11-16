package tr24;

public class Alumno 
{
	String Nombre;
	int Edad;
	double Calificacion;
	Boolean unidadesPedientes;
	
	public Alumno() 
	{
		
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public int getEdad() {
		return this.Edad;
	}

	public void setEdad(int edad) {
		this.Edad = edad;
	}

	public double getCalificacion() {
		return this.Calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.Calificacion = calificacion;
	}

	public Boolean getUnidadesPedientes() {
		return this.unidadesPedientes;
	}

	public void setUnidadesPedientes(Boolean unidadesPedientes) {
		this.unidadesPedientes = unidadesPedientes;
	}
	
	

}
