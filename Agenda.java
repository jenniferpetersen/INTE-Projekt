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
	
	public int getAdvancementTokens(){
		return advancementTokens;
	}
	
	public void addAdvancementTokens(int advancementTokens){
		if (advancementTokens < 0){
			throw new IllegalArgumentException();
		}
		else{
			this.advancementTokens += advancementTokens;
		}
	}
	
	public void removeAdvancementTokens(int advancementTokens){
		if(advancementTokens <= 0){
			throw new IllegalArgumentException();
		}
		if (this.advancementTokens <= 0){
			throw new IllegalArgumentException();
		}
		else{
			this.advancementTokens -= advancementTokens;
		}
	}
	
	public void buyAdvancementTokens(Corporation corp){
		if(corp.getCredits() < 1){
			throw new IllegalArgumentException("Not enough credits!");
		}else{
			corp.useClick();
			corp.loseCredits(1);
			addAdvancementTokens(1);
		}
	}
	
	abstract void stealAgenda(Corporation corp, Runner runner, String accessedServer);
	abstract void scoreAgenda(Corporation corp);

}