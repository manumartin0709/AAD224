package tr25;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Launch 
{
	public static void main(String[] args)
	{
		File myFile;
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		String fileContent;
		Competition competition = null;
		
		try 
		{
			myFile = new File("partidos.txt");
			fileWriter = new FileWriter(myFile);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			fileContent = FileUtils.readFileToString(new File("43.json"), "UTF-8");
			JsonNode rootJsonNode = Json.mapper().readTree(fileContent);
			if (rootJsonNode.isArray())
			{	
				JsonNode rootArrayJsonNode = (ArrayNode) rootJsonNode;
				final Iterator<JsonNode> iterator = rootArrayJsonNode.elements();
				while(iterator.hasNext())
				{
					final JsonNode equiposJsonNode = iterator.next();
					
					if(equiposJsonNode.has("home_team"))
					{
						final JsonNode homeTeamNode = equiposJsonNode.get("home_team").get("home_team_name");
						
						if(equiposJsonNode.has("competition_stage"))
						{
							final JsonNode comepetitionStageNode = equiposJsonNode.get("competition_stage").get("name");	
							if(comepetitionStageNode.asText().equals("Final"))
							{
								bufferedWriter.write("Los equipos que jugaron la final son: ");
								bufferedWriter.write(homeTeamNode.asText());
							}
						}	
					}
					
					if(equiposJsonNode.has("away_team"))
					{
						final JsonNode awayTeamNode = equiposJsonNode.get("away_team").get("away_team_name");
						
						if(equiposJsonNode.has("competition_stage"))
						{
							final JsonNode comepetitionStageNode = equiposJsonNode.get("competition_stage").get("name");	
							if(comepetitionStageNode.asText().equals("Final"))
							{	
								bufferedWriter.write(" - ");
								bufferedWriter.write(awayTeamNode.asText());
							}
						}	
					}
				
				
				
					if(equiposJsonNode.has("home_team"))
					{
						final JsonNode homeTeamJsonNode = equiposJsonNode.get("home_team");
						if(homeTeamJsonNode.has("country"))
						{	
							final JsonNode homeTeamCountryJsonNode = homeTeamJsonNode.get("country");
							if(homeTeamCountryJsonNode.has("name"))
							{
								final JsonNode homeTeamCountryNameJsonNode = homeTeamCountryJsonNode.get("name");
								JsonNode managersJsonNode = Json.mapper().readTree(fileContent);
								if (managersJsonNode.isArray())
								{	
									JsonNode managersArrayJsonNode = (ArrayNode) managersJsonNode;
									final Iterator<JsonNode> iterator2 = managersArrayJsonNode.elements();
									while(iterator2.hasNext())
									{
										JsonNode managerJsonNode = iterator2.next();
										if(managerJsonNode.has("managers"))
										{
											final JsonNode manager = managerJsonNode.get("managers");
											if(manager.has("name"))
											{
												final JsonNode homeTeamManagerName = manager.get("name");
												if(manager.has("country"))
												{
													final JsonNode homeTeamManagerCountry = managerJsonNode.get("country");
													if(homeTeamManagerCountry.has("name"))
													{
														final JsonNode homeTeamManagerCountryName = homeTeamManagerCountry.get("name");
														if(homeTeamManagerCountryName.asText().equals(homeTeamCountryNameJsonNode.asText()))
														{
															bufferedWriter.write(homeTeamManagerName.asText());	
														}
													}		
												}
											}					
										}		
									}	
								}	
							}
						}
					}
					
					/**
					if(equiposJsonNode.has("home_team"))
					{
						JsonNode homeTeamName = equiposJsonNode.get("home_team").get("home_team_name");
						if(equiposJsonNode.has("match_date"))
						{
							JsonNode matchDateNode = equiposJsonNode.get("match_date");
							Date fechaEnunciado = new Date(2021/06/01);
							Date dateMatch = new SimpleDateFormat("yyy-MM-dd").parse(matchDateNode.asText());
							if(dateMatch.after(fechaEnunciado))
							{
								System.out.println(homeTeamName.asText());
							}
							
						}
					}
					
					if(equiposJsonNode.has("away_team"))
					{
						JsonNode awayTeamName = equiposJsonNode.get("away_team").get("away_team_name");
						if(equiposJsonNode.has("match_date"))
						{
							JsonNode matchDateNode = equiposJsonNode.get("match_date");
							Date fechaEnunciado = new Date(2021/06/01);
							Date dateMatch = new SimpleDateFormat("yyy-MM-dd").parse(matchDateNode.asText());
							if(dateMatch.after(fechaEnunciado))
							{
								System.out.println(awayTeamName.asText());
							}
							
						}
					}**/
			
				}
			}
			bufferedWriter.close();
		}
		
		/**
		catch ( ParseException parseException ) {
			parseException.printStackTrace();
		}**/
		
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
		}
		
	}

}
