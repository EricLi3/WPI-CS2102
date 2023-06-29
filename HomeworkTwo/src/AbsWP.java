import java.util.LinkedList;
/**
 * AbsWP contains a method generalAveragePerDay which calculates average books read
 */
public abstract class AbsWP implements IChallenge{
	// ADD common fields for the PoemResult and WritingResult classes
	LinkedList<Double> chapterNumber;
	int currentDay;
	
	
	/**
	 * Calculates average books read
	 * @return A double which is the average books read
	 */
	public double generalAveragePerDay() {
		
			double sum = 0.0;
		    for (Double words: chapterNumber) {
		        sum += words;
		    }
		    return sum / this.currentDay;   
		}
		
	}

