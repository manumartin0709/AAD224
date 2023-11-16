package tr20;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class ParseAlumnoXml
{

	private String path;

	private static Logger log = LogManager.getLogger();

	/**
	 * @param path
	 */
	public ParseAlumnoXml(String path)
	{
		this.path = path;
	}

	public void parseListaAlumnosXml(List<Alumno> listaAlumnos)
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		try
		{
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document doc = documentBuilder.newDocument();
			Element alumnos = doc.createElement("alumnos");

			for (Alumno alumno : listaAlumnos)
			{
				Element elementAlumno = this.parseAlumnoXml(doc, alumno);
				alumnos.appendChild(elementAlumno);
			}

			doc.appendChild(alumnos);
			
			this.writeAlumnoXml(doc);
			

		} catch (ParserConfigurationException parserConfigurationException)
		{
			String message = "Error";
			log.error(message, parserConfigurationException);
		} 
	}
	
	private Element parseAlumnoXml(Document document, Alumno alumno) {
		
		Element elementAlumno = document.createElement("alumno");

		Attr nombre = document.createAttribute("nombre");
		nombre.setValue(alumno.getNombre());
		elementAlumno.setAttributeNode(nombre);

		Attr edad = document.createAttribute("edad");
		edad.setValue(String.valueOf(alumno.getEdad()));
		elementAlumno.setAttributeNode(edad);

		Element calificacion = document.createElement("clasificacion");
		calificacion.setTextContent(String.valueOf(alumno.getCalificacion()));
		elementAlumno.appendChild(calificacion);

		Element unidadesPendientes = document.createElement("unidadesPendientes");
		unidadesPendientes.setTextContent(String.valueOf(alumno.isUnidadesPendientes()));
		elementAlumno.appendChild(unidadesPendientes);
		
		return elementAlumno;
		
	}

	private void writeAlumnoXml(Document document)
	{
		FileOutputStream output;
		try
		{
			output = new FileOutputStream(this.path);
			writeXml(document, output);
		} catch (FileNotFoundException fileNotFoundException)
		{
			String message = "Error";
			log.error(message, fileNotFoundException);
		} catch (TransformerException transformerException)
		{
			String message = "Error";
			log.error(message, transformerException);
		}
	}

	private void writeXml(Document document, OutputStream outputStream) throws TransformerException
	{

		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();

		DOMSource xmlAsObject = new DOMSource(document);

		StreamResult xmlAsFile = new StreamResult(outputStream);

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		transformer.transform(xmlAsObject, xmlAsFile);

	}
}