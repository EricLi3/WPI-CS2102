import java.util.LinkedList;


 public class WritingResult extends AbsWP implements IChallenge {
	//LinkedList<Double> chapterNumber;
	//int dayOfNov; // from 1 to 30
		
	public WritingResult(double d, int currentDay) {
		
		this.currentDay = currentDay;
		this.chapterNumber = new LinkedList<Double>();
		chapterNumber.add(d);
	}
	
	//JAVADOCS
	/**
	 * Adds a chapter to a literarian's writing result
	 * @return The WritingResult
	 */
	public WritingResult nextChapter(double aChapter) {
		this.chapterNumber.add(aChapter);
		return this;
	}
	
	//JAVADOCS
	/**
	 * Calculates the average words written
	 * @return A double which is the average words written
	 */
	public double averagePerDay() {
		return this.generalAveragePerDay();
	}
	
	/*
	 * helper function that calculates the total words written
	 */
	public double total() {
		double sum = 0.0;
	    for (Double words: chapterNumber) {
	        sum += words;
	    }
	    return sum;   
	}
	
	
	//JAVADOCS
	/**
	 * Calculates the difference from the goal of 50000 words written
	 * @return A double which is the difference from the goal for words written
	 */
	public double differenceFromGoal() {
		return((50000.0 - total()) / (30 - this.currentDay + 1));
	}
}

