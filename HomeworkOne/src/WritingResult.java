
 public class WritingResult implements IChallenge {
	double wordsWritten;
	int dayOfNov; // from 1 to 30
	
	
	WritingResult(Double wordsWritten, Integer dayOfNov) {
		this.wordsWritten = wordsWritten;
		this.dayOfNov = dayOfNov;
	}
	public double averagePerDay() {
		return (this.wordsWritten / this.dayOfNov);
	}
	
	public double differenceFromGoal() {
		return((50000 - this.wordsWritten) / (30 - this.dayOfNov + 1));
	}
}
