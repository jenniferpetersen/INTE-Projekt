package netrunner;

public class ProfilerTest {

	public static void main(String[] args) {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		Runner runner = new Runner();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToHQ(c);
		corp.addCardToArchives(c);
		corp.addCardToRD(c);
		runner.attemptRun(corp, "HQ");
		runner.gainCredits(11);
		runner.attemptRun(corp, "Archives");
		runner.attemptRun(corp, "RD");
		corp.addCardToHQ(c);
		runner.attemptRun(corp, "HQ");
	}	
}
