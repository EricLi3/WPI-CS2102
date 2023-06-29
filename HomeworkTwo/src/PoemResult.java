import java.util.LinkedList;

//JAVADOCS
/**
 * PoemResult contains method nextPoem which adds the number of words to the linked list of words written and modifies the 
 * integer field for the weeks a poem has been submitted if the poem was submitted. There is also a method averagePerDay 
 * which calculates how many more words are needed. We also have a method differenceFromGoal which calculates how many 
 * more words per day are needed to reach 4 poems.
 */
public class PoemResult extends AbsWP implements IChallenge{
	//LinkedList<Double> wordsWritten;
	
	//int currentDay; // from 1 to 31
	int weeksSubmitPoem; // 0 when the poet doens't submit anything, 4 when the poet submits 4 weeks 
	
	public PoemResult(double p, int currentDay, int weeksSubmitPoem) {
		this.chapterNumber = new LinkedList<Double>();
		chapterNumber.add(p);
		
		this.currentDay = currentDay;
		this.weeksSubmitPoem = weeksSubmitPoem; 
	}
	
	//JAVADOCS
	/**
	 * Adds the number of words to the linked list of words written and modifies the 
	 * integer field for the weeks a poem has been submitted if the poem was submitted
	 * @param words
	 * @param submitted
	 * @return PoemResult
	 */
	public PoemResult nextPoem(double words, boolean submitted) {
		
		this.chapterNumber.add(words);
		
		if(submitted == true) {
			this.weeksSubmitPoem = this.weeksSubmitPoem + 1;
		}
		else {
			this.weeksSubmitPoem = this.weeksSubmitPoem + 0;
		}
		return this;
	}
	
	
	
	@Override
	//JAVADOCS
	/**
	 * Calculates the total average words written
	 * @return A double which is the total words written
	 */
	
	public double averagePerDay() {
		return this.generalAveragePerDay();
	}

	@Override
	//JAVADOCS
	/**
	 * Calculates how many more words per day are needed to reach 4 poems
	 * @return A double which is the representing words-per-day
	 */
	public double differenceFromGoal() {
		if(this.weeksSubmitPoem == 0) {
			return ((((averagePerDay() / 1)) * (4 - this.weeksSubmitPoem)) 
					/ (31 - this.currentDay + 1));
		}
		else {
			return (((averagePerDay() / (this.weeksSubmitPoem)) * (4 - this.weeksSubmitPoem)) 
				/ (31 - this.currentDay + 1));
		}
	}
}
