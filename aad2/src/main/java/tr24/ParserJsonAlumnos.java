package tr24;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ParserJsonAlumnos 
{
	public void parserJsonAlumnos(List<String> alumnosPendientes, List<Double> notasAlumnos, Map<String, Double> mapaAlumnos)
			throws IOException, JsonProcessingException, JsonMappingException {
		String fileContent;
		Alumno alumno;
		JsonNode rootJsonNode;
		fileContent    = FileUtils.readFileToString(new File("alumnos.json"), "UTF-8");
		rootJsonNode   = Json.mapper().readTree(fileContent);
		if(rootJsonNode.isArray())
		{
			
			JsonNode rootArrayJsonNode = (ArrayNode) rootJsonNode;
			final Iterator<JsonNode> iterator = rootArrayJsonNode.elements();
			
			while(iterator.hasNext())
			{
				alumno = new Alumno();
				final JsonNode alumnoJsonNode = iterator.next();
				if(alumnoJsonNode.has("nombre"))
				{
					final JsonNode markNode = alumnoJsonNode.get("nombre");
					alumno.setNombre(markNode.asText());
					
				}
				if(alumnoJsonNode.has("edad"))
				{
					final JsonNode markNode = alumnoJsonNode.get("edad");
					alumno.setEdad(Integer.parseInt(markNode.asText()));
				}
				if(alumnoJsonNode.has("calificacion"))
				{
					final JsonNode markNode = alumnoJsonNode.get("calificacion");
					alumno.setCalificacion(Double.parseDouble(markNode.asText()));
				}
				if(alumnoJsonNode.has("unidadesPendientes"))
				{
					final JsonNode markNode = alumnoJsonNode.get("unidadesPendientes");
					alumno.setUnidadesPedientes(Boolean.parseBoolean(markNode.asText()));
				}
				mapaAlumnos.put(alumno.getNombre(), alumno.getCalificacion());
				notasAlumnos.add(alumno.getCalificacion());
				if(alumno.getUnidadesPedientes())
				{
					alumnosPendientes.add(alumno.getNombre());
				}
			}
		}
	}

}
