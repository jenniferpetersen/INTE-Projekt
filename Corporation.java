package netrunner;

import java.util.ArrayList;


abstract class Corporation extends Player{
	
	private int badPublicity;
	private int noOfRemoteServers;
	private ArrayList<Card> researchAndDevelopment = new ArrayList<>();
	private ArrayList<Card> HQ = new ArrayList<>();
	private ArrayList<Card> archives = new ArrayList<>();
	
	
	public Corporation() {
		super(3);
		badPublicity = 0;
		noOfRemoteServers = 0;
	} 
	
	protected ArrayList<Card> createRemoteServer() {
		ArrayList<Card> remoteServer = new ArrayList<>();
		noOfRemoteServers += 1;
		return remoteServer;
	}
	
	protected ArrayList<Card> installCardNewRemote(Card a) {
		ArrayList<Card> remoteServer = createRemoteServer();
		remoteServer.add(a);
		return remoteServer;
	}
	
	protected void installCardExistingRemote(Card a, ArrayList<Card> remote) {
		remote.add(a);
	}
	
	protected void advanceAgenda(Agenda a) {
		if (a == null) {
			throw new NullPointerException();
		}
		else {
			a.buyAdvancementTokens(this);
		}
	}
	
	protected void addBadPublicity(int bp){
		if (bp < 0){
			throw new IllegalArgumentException();
		}
		else{
			badPublicity += bp;
		}
	}
	
	public void removeBadPublicity(int bp){
		if (bp <= 0 || badPublicity - bp < 0){
			throw new IllegalArgumentException();
		}
		else{
			badPublicity -= bp;
		}
	}
	
	public int getBadPublicity() {
		return badPublicity;
	}
	
	public void addCardToRD(Card c) {
		researchAndDevelopment.add(c);
	}
	
	public void addCardToArchives(Card c) {
		archives.add(c);
	}
	
	public void addCardToHQ(Card c) {
		HQ.add(c);
	}
	
	public boolean isRDEmpty() {
		return researchAndDevelopment.isEmpty();
	}

	public boolean compareTopCardRD(Card c) {
		return c.equals(researchAndDevelopment.get(0));
	}
	
	public Card getTopCardRD() {
		return researchAndDevelopment.get(0);
	}
	
	public Card getLastCardHQ() {
		return HQ.get(HQ.size()-1);
	}
	
	public boolean compareLastCardHQ(Card c) {
		return c.equals(HQ.get(HQ.size()-1));
	}
	
	public void drawCard() {
		if(researchAndDevelopment.size() > 0) {
			HQ.add(getTopCardRD());
			researchAndDevelopment.remove(getTopCardRD());
		}
		else {
			setLoser(true);
		}
	}
	
	public boolean isCardInHQ(Card c) {
		return HQ.contains(c);
	}
	
	protected boolean isCardInArchives(Card c) {
		return archives.contains(c);
	}
	
	public void trashCardFromHQ(Card c) {
		if(isCardInHQ(c)) {
			archives.add(c);
			HQ.remove(c);
		}
		else {
			throw new java.lang.IllegalArgumentException();
		}
	}
	
	public void removeCardFromRD(Card c) {
		researchAndDevelopment.remove(c);
	}
	
	public void removeCardFromHQ(Card c) {
		HQ.remove(c);
	}
	
	public void removeCardFromArchives(Card c) {
		archives.remove(c);
	}
	
	public int getSizeArchives() {
		return archives.size();
	}
	
	public int getSizeHQ() {
		return HQ.size();
	}
	
	public int getNoOfRemoteServers() {
		return noOfRemoteServers;
	}
	
	public Card exposeRandomHQCard(int i){
		Card c = HQ.get(i);
		return c;
	}
	
	public ArrayList<Card> successfulRunOnArchives(){
		ArrayList<Card> cardlist = new ArrayList<>();
		for(Card c : archives){
			cardlist.add(c);
		}
		return cardlist;
	}
}
