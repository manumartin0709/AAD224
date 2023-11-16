package tr20;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXmlAlumnos
{

	private String path;

	private static Logger log = LogManager.getLogger();

	/**
	 * @param path
	 */
	public ParseXmlAlumnos(String path)
	{
		this.path = path;
	}

	public List<Alumno> parseXmlListaAlumnos()
	{

		List<Alumno> ListaAlumnos = new ArrayList<Alumno>();

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;

		Alumno alumno = null;
		try
		{

			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new File(this.path));
			Element rootElement = document.getDocumentElement();
			NodeList nodeListAlumno = rootElement.getElementsByTagName("alumno");

			for (int i = 0 ; i < nodeListAlumno.getLength() ; i++)
			{
				Element nodeAlumno = (Element) nodeListAlumno.item(i);

				Element nodeNotas = (Element) nodeAlumno.getElementsByTagName("calificacion").item(i);

				String nombre = nodeAlumno.getAttributes().getNamedItem("nombre").getTextContent();
				int edad = Integer.valueOf(nodeAlumno.getAttributes().getNamedItem("edad").getTextContent());
				double calificacion = Double.valueOf(nodeNotas.getTextContent());
				boolean unidadesPendientes = Boolean.valueOf(nodeNotas.getTextContent());

				alumno = new Alumno(nombre, edad, calificacion, unidadesPendientes);
				ListaAlumnos.add(alumno);
			}

		} catch (ParserConfigurationException parserConfigurationException)
		{
			String message = "Error";
			log.error(message, parserConfigurationException);
		} catch (SAXException saxException)
		{
			String message = "Error";
			log.error(message, saxException);
		} catch (IOException ioException)
		{
			String message = "Error";
			log.error(message, ioException);
		}

		return ListaAlumnos;
	}

}
