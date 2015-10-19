package netrunner;

import java.util.ArrayList;

abstract class Agenda extends CorpCard{
	
	private int agendaPoints;

	public Agenda(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness, int agendaPoints) {
		
		super(title, "agenda", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		this.agendaPoints = agendaPoints;
	}
	
	public int getAgendaPoints() {
		return agendaPoints;
	}
	
	abstract void stealAgenda(Corporation corp, Runner runner, String accessedServer);
	abstract void scoreAgenda(Corporation corp, String server);

}
