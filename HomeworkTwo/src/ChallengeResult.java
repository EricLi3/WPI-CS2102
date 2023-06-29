
public class ChallengeResult {
	ReadingResult rr;
	WritingResult wr;
	
	ChallengeResult (ReadingResult rr, WritingResult wr){
		this.rr = rr;
		this.wr = wr;
	}
	
	public double howClose () {
		return ((rr.differenceFromGoal() * 10000) 
				+ wr.differenceFromGoal());
	}
	
}
