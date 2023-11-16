package tr25;


import java.sql.Time;
import java.util.Date;

public class Partido
{
	int matchId;
	Date matchDate;
	Competition competition;
	Season season;
	Teams namehomeTeam;
	Teams nameAwayTeam;
	CompetitionStage competitionStage;
	public Partido()
	{
		super();
		this.matchId = matchId;
		this.matchDate = matchDate;
		this.competition = competition;
		this.season = season;
		this.namehomeTeam = namehomeTeam;
		this.nameAwayTeam = nameAwayTeam;
		this.competitionStage = competitionStage;
	}
	public int getMatchId()
	{
		return matchId;
	}
	public void setMatchId(int matchId)
	{
		this.matchId = matchId;
	}
	public Date getMatchDate()
	{
		return matchDate;
	}
	public void setMatchDate(Date matchDate)
	{
		this.matchDate = matchDate;
	}
	public Competition getCompetition()
	{
		return competition;
	}
	public void setCompetition(Competition competition)
	{
		this.competition = competition;
	}
	public Season getSeason()
	{
		return season;
	}
	public void setSeason(Season season)
	{
		this.season = season;
	}
	public Teams getNamehomeTeam()
	{
		return namehomeTeam;
	}
	public void setNamehomeTeam(Teams namehomeTeam)
	{
		this.namehomeTeam = namehomeTeam;
	}
	public Teams getNameAwayTeam()
	{
		return nameAwayTeam;
	}
	public void setNameAwayTeam(Teams nameAwayTeam)
	{
		this.nameAwayTeam = nameAwayTeam;
	}
	public CompetitionStage getCompetitionStage()
	{
		return competitionStage;
	}
	public void setCompetitionStage(CompetitionStage competitionStage)
	{
		this.competitionStage = competitionStage;
	}
	
	
	
	
}
//nombre de los equipos{home_team{home teamname}, away_team{away_team_name}} que jugaron la final de la{competition_stage{name}} eurocopa 2020{season{season_name}
//nombre de los entrenadores{hometeam{manager{manager_name} cuya nacionalidad {hometeam{manager{country{country name}}} no coincide con el pais que representa{home_team{country{countryname}}
//partidos(los 2 equipos) {home team{name}{awayteam{name}que se jugaron despues del 1 de julio de 2021{match_date}