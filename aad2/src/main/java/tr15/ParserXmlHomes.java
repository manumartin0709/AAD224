package tr15;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserXmlHomes 
{
	public static void main(String[] args) 
	{
		DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
		try 
		{

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new File("homes.xml"));
			Element rootElement = document.getDocumentElement();
			NodeList nodeListHome = rootElement.getElementsByTagName("casa");
			for(int i = 0; i < nodeListHome.getLength(); i++)
			{
				Element nodeHome = (Element) nodeListHome.item(i);
				String ciudad      = nodeHome.getAttributes().getNamedItem("ciudad").getTextContent();
				String tipo     = nodeHome.getAttributes().getNamedItem("tipo").getTextContent();
				int metrosCuadrados    =Integer.valueOf( nodeHome.getAttributes().getNamedItem("metrosCuadrados").getTextContent());
				int plantas = Integer.valueOf( nodeHome.getAttributes().getNamedItem("plantas").getTextContent());
				int habitaciones = Integer.valueOf( nodeHome.getAttributes().getNamedItem("habitaciones").getTextContent());
				boolean zonasComunes = Boolean.valueOf( nodeHome.getAttributes().getNamedItem("zonasComunes").getTextContent());
				System.out.println("Ciudad: "+ciudad+", tipo: "+tipo+", metrosCuadrados: "+metrosCuadrados+", plantas: "+plantas+", habiatacionies: "+habitaciones+" , zonasComunes: "+zonasComunes);
				
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
	}

}
