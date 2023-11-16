package tr16;

import java.io.Serializable;

public class Alumno implements Serializable
{
	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 2129098879463300463L;
	private String nombre;
	private int edad;
	private float calificacion;
	private boolean unidadesPendientes;
	public Alumno(String nombre, int edad, float calificacion, boolean unidadesPendientes)
	{
		
		this.nombre = nombre;
		this.edad = edad;
		this.calificacion = calificacion;
		this.unidadesPendientes = unidadesPendientes;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getEdad()
	{
		return edad;
	}
	public void setEdad(int edad)
	{
		this.edad = edad;
	}
	public float getCalificacion()
	{
		return calificacion;
	}
	public void setCalificacion(float calificacion)
	{
		this.calificacion = calificacion;
	}
	public boolean isUnidadesPendientes()
	{
		return unidadesPendientes;
	}
	public void setUnidadesPendientes(boolean unidadesPendientes)
	{
		this.unidadesPendientes = unidadesPendientes;
	}
	@Override
	public String toString()
	{
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", calificacion=" + calificacion
				+ ", unidadesPendientes=" + unidadesPendientes + "]";
	}
	
}