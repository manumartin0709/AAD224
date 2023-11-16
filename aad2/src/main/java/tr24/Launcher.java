package tr24;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exception.Unit1Exception;

public class Launcher
{
	private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws Unit1Exception
    {
        File myFile;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter  = null;
        List<String> alumnosPendientes = new ArrayList<String>(); 
        List<Double> notasAlumnos      = new ArrayList<Double>();
		Double suma                    = 0.0;
		Media media                    = new Media();
		ParserJsonAlumnos parser       = new ParserJsonAlumnos();
		Map<String, Double> mapaAlumnos = new HashMap<>();
		try
		{
			myFile         = new File("salida-alumnos.txt");
			fileWriter     = new FileWriter(myFile);
		    bufferedWriter = new BufferedWriter(fileWriter);
		    //parseamos el json
			parser.parserJsonAlumnos(alumnosPendientes, notasAlumnos, mapaAlumnos);
			//ordenamos la lista alfabeticamente inversa
			Collections.sort(alumnosPendientes, Collections.reverseOrder());
			bufferedWriter.write("Alumnos con unidades pedientes ordenados alfabeticamente inversos: "+"\n");
			//escribimos los alumnos con asignaturas pendientes en el fichero
			for(String alumnoNombre : alumnosPendientes) 
			{
				bufferedWriter.write(alumnoNombre);
                bufferedWriter.newLine();			
			}
			Double notaMedia = 	media.calcularMedia(notasAlumnos, suma);
			
			//Nombre del alumnos con la nota mas cercano
	        String alumnoMasCercano = null;
	        double diferenciaNotaMasCercana = Double.MAX_VALUE;

	        //Buscamos el alumnos con la nota media en el mapa alumnos
	        for (Map.Entry<String, Double> notas : mapaAlumnos.entrySet()) {
	            double diferencia = Math.abs(notas.getValue() - notaMedia);

	            if (diferencia < diferenciaNotaMasCercana) {
	                alumnoMasCercano = notas.getKey();
	                diferenciaNotaMasCercana = diferencia;
	            }
	        }

	        // Escribimos el resultado en el fichero
	        bufferedWriter.write("El alumno más cercano a la nota media " + notaMedia+
	                " es: " + alumnoMasCercano + "con una nota de:"  + mapaAlumnos.get(alumnoMasCercano));
		}catch (IndexOutOfBoundsException indexOutOfBoundsException) 
		{
			
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			String error ="file not found myFile.txt";			
			logger.error(error, fileNotFoundException);
			throw new Unit1Exception(error, fileNotFoundException);
		}
		catch (IOException ioException) 
		{
			String error ="entry and exit error";			
			logger.error(error, ioException);
			throw new Unit1Exception(error, ioException);// TODO: handle exception
		}
		finally
		{
			try
			{
				if(bufferedWriter != null)
				{
					bufferedWriter.close();
				}
			}
			catch (IOException ioException) 
			{
				String error ="entry and exit error";			
				logger.error(error, ioException);
			}
		}
		
    }

	

	
}