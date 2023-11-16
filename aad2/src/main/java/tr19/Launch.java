package tr19;

import java.io.FileOutputStream;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Launch
{
	private static Casas createNewCasas(List<Casas> listaDeCasas)
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdice la ciudad de la casa: ");
		String ciudad = scanner.next();
		System.out.println("Introduce el tipo de casa: ");
		String tipo = scanner.next();
		System.out.println("Introduce el numero de metros cuadrados de la casa: ");
		int metrosCuadrados = scanner.nextInt();
		System.out.println("Introduce el numero de plantas que tiene la casa");
		int plantas = scanner.nextInt();
		System.out.println("Introduce el numero de habitaciones que tiene la casa: ");
		int habitaciones = scanner.nextInt();
		System.out.println("Tiene zonas comunes");
		boolean zonasComunes = scanner.nextBoolean();
		Casas casa = new Casas(ciudad, tipo,metrosCuadrados, plantas, habitaciones, zonasComunes);
		listaDeCasas.add(casa);
		return casa;
	}
	public static void main(String[] args) 
	{
		Scanner scanner2 = new Scanner(System.in);
		
		boolean bandera = false;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		FileOutputStream output;
		Document document;
		List<Casas> listaDeCasas =  null; 
		try
		{
			listaDeCasas = new ArrayList<>();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			output = new FileOutputStream("casas_out.xml");
			document = documentBuilder.newDocument();
			Element homesElement = document.createElement("casas");
			while(bandera != true) 
			{
					Casas casa = createNewCasas(listaDeCasas);
					for (int i = 0; i < listaDeCasas.size(); i++) 
					{
			             casa = listaDeCasas.get(i);
			             Element homeElement =  document.createElement("casa");
							
							Attr homeCityAttribute = document.createAttribute("ciudad");
							homeCityAttribute.setValue(casa.getCiudad());
							
							Attr homeModelAttribute = document.createAttribute("tipo");
							homeModelAttribute.setValue(casa.getTipo());
							
							Attr homePlantAttribute = document.createAttribute("plantas");
							homePlantAttribute.setValue(String.valueOf(casa.getPlantas()));
							
							Attr homeMeterAttribute = document.createAttribute("metrosCuadrados");
							homeMeterAttribute.setValue(String.valueOf(casa.getMetrosCuadrados()));
							
							Attr homeRoomsAttribute = document.createAttribute("habitaciones");
							homeRoomsAttribute.setValue(String.valueOf(casa.getHabitaciones()));
							
							Attr homeCommonsAttribute = document.createAttribute("zonasComunes");
							homeCommonsAttribute.setValue(String.valueOf(casa.isZonasComunes()));
							homeElement.setAttributeNode(homeCityAttribute);
							homeElement.setAttributeNode(homeModelAttribute);
							homeElement.setAttributeNode(homePlantAttribute);
							homeElement.setAttributeNode(homeMeterAttribute);
							homeElement.setAttributeNode(homeRoomsAttribute);
							homeElement.setAttributeNode(homeCommonsAttribute);		
							homesElement.appendChild(homeElement);
							
			        }
					
					System.out.println("Quieres seguir introducuendo casas?(si/no)");
					String respuesta = scanner2.next();
					if(respuesta.equals("no")) 
					{
						bandera = true;
					}
				
			}
			document.appendChild(homesElement);
			writeXml(document,output);
			scanner2.close();
		}
		catch(ParserConfigurationException | TransformerException | IOException xmlException)
		{
			xmlException.printStackTrace();
		}
		
		
		
	}
	private static void writeXml(Document document, FileOutputStream output) throws TransformerException 
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource xmlAsObject = new DOMSource(document);
		StreamResult xmlAsFile = new StreamResult(output);
		transformer.transform(xmlAsObject, xmlAsFile);
		
		
	}

}
