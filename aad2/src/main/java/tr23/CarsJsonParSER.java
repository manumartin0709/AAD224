package tr23;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import tr22.Json;

public class CarsJsonParSER 
{
	public static void main(String[] args) throws IOException{
		String fileContent = FileUtils.readFileToString(new File("cars.json"), "UTF-8");
		JsonNode rootJsonNode = Json.mapper().readTree(fileContent);
		if(rootJsonNode.isArray())
		{
			JsonNode rootArrayJsonNode = (ArrayNode) rootJsonNode;
			final Iterator<JsonNode> iterator = rootArrayJsonNode.elements();
			while(iterator.hasNext())
			{
				final JsonNode carJsonNode = iterator.next();
				if(carJsonNode.has("marca"))
				{
					final JsonNode markNode = carJsonNode.get("marca");
					System.out.println(markNode.asText());
				}
				if(carJsonNode.has("modelo"))
				{
					final JsonNode markNode = carJsonNode.get("modelo");
					System.out.println(markNode.asText());
				}
				if(carJsonNode.has("motor")) 
				{
					final JsonNode motorNode = carJsonNode.get("motor");
					if(motorNode.has("revoluciones"))
					{
						final JsonNode revolucionesNode = motorNode.get("revoluciones");
						System.out.println(revolucionesNode.asText());
					}
					if(motorNode.has("tipo"))
					{
						final JsonNode typeNode = motorNode.get("tipo");
						System.out.println(typeNode.asText());
					}
					
				}
				if(carJsonNode.has("puertas")) 
				{
					final JsonNode doorNode = carJsonNode.get("puertas");
					System.out.println(doorNode.asText());
				}
				if(carJsonNode.has("kilometros")) 
				{
					final JsonNode kmNode = carJsonNode.get("kilometros");
					System.out.println(kmNode.asText());
				}
				System.out.println(" ");
				
			}
			}
		}
	}
	


