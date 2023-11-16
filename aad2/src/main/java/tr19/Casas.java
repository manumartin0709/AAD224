package tr19;

public class Casas
{
	String ciudad;
	String tipo;
	int metrosCuadrados;
	int plantas;
	int habitaciones;
	boolean zonasComunes;
	public Casas(String ciudad, String tipo, int metrosCuadrados, int plantas, int habitaciones, boolean zonasComunes)
	{
		super();
		this.ciudad = ciudad;
		this.tipo = tipo;
		this.metrosCuadrados = metrosCuadrados;
		this.plantas = plantas;
		this.habitaciones = habitaciones;
		this.zonasComunes = zonasComunes;
	}
	public String getCiudad()
	{
		return ciudad;
	}
	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public int getMetrosCuadrados()
	{
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(int metrosCuadrados)
	{
		this.metrosCuadrados = metrosCuadrados;
	}
	public int getPlantas()
	{
		return plantas;
	}
	public void setPlantas(int plantas)
	{
		this.plantas = plantas;
	}
	public int getHabitaciones()
	{
		return habitaciones;
	}
	public void setHabitaciones(int habitaciones)
	{
		this.habitaciones = habitaciones;
	}
	public boolean isZonasComunes()
	{
		return zonasComunes;
	}
	public void setZonasComunes(boolean zonasComunes)
	{
		this.zonasComunes = zonasComunes;
	}
	
	

}
