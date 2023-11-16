package tr18;

import java.io.FileOutputStream;


import java.io.IOException;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Launch 
{
	private static Coche createNewCar() 
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce la marca del coche: ");
		String marca = scanner.next();
		System.out.println("Introduce el modelo del coche");
		String modelo = scanner.next();
		System.out.println("Introduce el numero de puertas que tiene el coche");
		int puertas = scanner.nextInt();
		System.out.println("Introduce el kilometraje del coche");
		int kilometros = scanner.nextInt();
		System.out.println("Introduce las revoluciones del motor");
		int revoluciones = scanner.nextInt();
		System.out.println("Introduce el tipo del motor");
		String tipo = scanner.next();
		Motor motor = new Motor(revoluciones, tipo);
		Coche coche = new Coche(marca, modelo, puertas, kilometros, motor );
		return coche;
		

	}
	public static void main(String[] args) 
	{
		Scanner scanner2 = new Scanner(System.in);
		
		boolean bandera = false;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		FileOutputStream output;
		Document document;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			output = new FileOutputStream("car_out.xml");
			document = documentBuilder.newDocument();
			Element carsElement = document.createElement("coches");
			while(bandera != true) 
			{
					Coche coche = createNewCar();
					Element carElement =  document.createElement("coche");
					
					Element carMarkElement = document.createElement("marca");
					carMarkElement.setTextContent(coche.getMarca());
					
					Element carModelElement = document.createElement("modelo");
					carModelElement.setTextContent(coche.getModelo());
					
					Element carDoorsElement = document.createElement("puertas");
					carDoorsElement.setTextContent(String.valueOf(coche.getPuertas()));
					
					Element carKilometersElement = document.createElement("kilometros");
					carKilometersElement.setTextContent(String.valueOf(coche.getKilometros()));
					
					carElement.appendChild(carMarkElement);
					carElement.appendChild(carModelElement);
					carElement.appendChild(carDoorsElement);
					carElement.appendChild(carKilometersElement);
					
					Element carEngineElement = document.createElement("motor");
					
					Element carEngineRevolutionsElement = document.createElement("revoluciones");
					carEngineRevolutionsElement.setTextContent(String.valueOf(coche.getMotor().getRevoluciones()));
					
					Element carEngineTypeElement = document.createElement("tipo");
					carEngineTypeElement.setTextContent(coche.getMotor().getTipo());
					
					carEngineElement.appendChild(carEngineRevolutionsElement);
					carEngineElement.appendChild(carEngineTypeElement);
					
					carElement.appendChild(carEngineElement);
					
					carsElement.appendChild(carElement);
					
					
					System.out.println("Quieres seguir introducuendo coches?(si/no)");
					String respuesta = scanner2.next();
					if(respuesta.equals("no")) 
					{
						bandera = true;
					}
				
			}
			document.appendChild(carsElement);
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

