package netrunner;

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
	
	abstract void stealAgenda(Runner runner);
	abstract void scoreAgenda(Corporation corp);

}
