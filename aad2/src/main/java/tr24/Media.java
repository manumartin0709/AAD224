package tr24;

import java.util.List;

public class Media 
{
	public Double calcularMedia(List<Double> notasAlumnos, Double suma) 
	{
		for(Double nota : notasAlumnos)
		{
			suma += nota;
		}
		Double media = suma/ notasAlumnos.size();
		return media;
	}
	
}
