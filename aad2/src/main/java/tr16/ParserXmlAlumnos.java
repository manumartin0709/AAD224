package tr16;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserXmlAlumnos 
{
	public static void main(String[] args) 
	{
		DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
		try 
		{

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document               = documentBuilder.parse(new File("alumnos.xml"));
			Element rootElement             = document.getDocumentElement();
			NodeList nodeListAlumno         = rootElement.getElementsByTagName("alumno");
			
			for(int i = 0; i < nodeListAlumno.getLength(); i++)
			{
				Element nodeAlumno                = (Element) nodeListAlumno.item(i);
				String nombre                     = nodeAlumno.getAttributes().getNamedItem("nombre").getTextContent();
				int edad                          = Integer.valueOf(nodeAlumno.getAttributes().getNamedItem("edad").getTextContent());

				Element clasificaionElement       = (Element) nodeAlumno.getElementsByTagName("clasificaion").item(0);
				//trimap orden alfabetico
				double clasificaion               = Double.parseDouble(clasificaionElement.getTextContent());
				Element unidadesPendientesElement = (Element) nodeAlumno.getElementsByTagName("unidadesPendientes").item(0);

				boolean unidadesPendientes = Boolean.parseBoolean(unidadesPendientesElement.getTextContent());
				System.out.println("Nombre: "+nombre+", edad: "+edad+", clasificaion: "+clasificaion+", unidadesPendientes: "+unidadesPendientes);
				
			}
		}
		catch (ParserConfigurationException parserConfigurationException) 
		{
			parserConfigurationException.printStackTrace();
			
		}
		catch (SAXException saxeException) 
		{
			saxeException.printStackTrace();
			
		}
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
			
		}
		finally 
		{
			
			
		}		
	}
}
