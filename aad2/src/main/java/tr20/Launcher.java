package tr20;

import java.util.List;

public class Launcher
{
    public static void main(String[] args)
	{

    	ParseXmlAlumnos parseXmlAlumnos = new ParseXmlAlumnos("alumnos.xml");
    	List<Alumno> alumnos = parseXmlAlumnos.parseXmlListaAlumnos();
    	
    	ParseAlumnoXml parseAlumnoXml = new ParseAlumnoXml("alumno_out.xml");
    	parseAlumnoXml.parseListaAlumnosXml(alumnos);
    	
		
	}
}
