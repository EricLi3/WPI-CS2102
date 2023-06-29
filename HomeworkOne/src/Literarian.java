	
public class Literarian {
	ChallengeResult resultOfChallenge;
	
	Literarian (ChallengeResult resultOfChallenge){
		this.resultOfChallenge = resultOfChallenge;
	}
	
	public boolean betterBookworm (Literarian anotherLiterarian) {
		return (this.resultOfChallenge.rr.differenceFromGoal() < 
			    anotherLiterarian.resultOfChallenge.rr.differenceFromGoal());
	}
	
	public boolean wittierWordsmith (Literarian anotherLiterarian) {
		return (this.resultOfChallenge.wr.averagePerDay() > 
			    anotherLiterarian.resultOfChallenge.wr.averagePerDay());
	}
	
	public boolean successfulScholar (Literarian anotherLiterarian) {
		return (betterBookworm (anotherLiterarian) || wittierWordsmith(anotherLiterarian));
			
			
	
	}
}
