package netrunner;

abstract class Agenda extends CorpCard{
	
	private int agendaPoints;
	private int advancementTokens;

	public Agenda(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness, int agendaPoints) {
		
		super(title, "agenda", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		this.agendaPoints = agendaPoints;
		advancementTokens = 0;
	}
	
	public int getAgendaPoints() {
		return agendaPoints;
	}
	
	public int getAdvancementTokens() {
		return advancementTokens;
	}
	
	protected void advance() {
		advancementTokens += 1;
	}
	
	abstract void stealAgenda(Corporation corp, Runner runner, String accessedServer);
	abstract void scoreAgenda(Corporation corp);

}
