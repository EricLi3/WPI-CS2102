import java.util.LinkedList;

/**
 * LitJam contains method readingDNF, which determines whether a literarian met the goal for number of genres read or not.
 * There is also a method finalScoreForLiterarian which calculates a final score value for a given literarian. We also 
 * have a method anyImprovement, which determines if literarian improved across two Litjams.
 */
public class LitJam {
	int numGenreGoal;
	LinkedList<Literarian> literarians;

	public LitJam(Integer numGenreGoal, LinkedList<Literarian> literarians) {
		this.literarians = literarians;
		this.numGenreGoal = numGenreGoal;
	}

	// JAVADOCS
	/**
	 * Determines whether a literarian met the goal for number of genres read or not.
	 * @return a linked list of literarians who did not explore the preset goal for
	 *         number of genres read.
	 */
	public LinkedList<String> readingDNF() {

		LinkedList<String> holder = new LinkedList<String>();
		for (Literarian lit : this.literarians) {
			if (lit.resultOfChallenge.rr.genres.size() < this.numGenreGoal) {
				holder.add(lit.penName);
			}
		}
		return holder;
	}

	// JAVADOCS
	/**
	 * Calculates a final score value for a given Literarian
	 * @param name
	 * @return A integer value which is the Literarian's final score
	 */
	public int finalScoreForLiterarian (String name) {
		int currentScore = 0;
		
		for(Literarian lite : literarians) {
			if(name.equals(lite.penName)) {
				if(lite.resultOfChallenge.rr.genres.size() >= this.numGenreGoal) {
					currentScore = currentScore + 25;
				}
				for(BooksRead hi :lite.resultOfChallenge.rr.genres) {
					if (hi.skimmed == false)
					currentScore = currentScore + 5;
				}
				if(lite.resultOfChallenge.rr.averagePerDay() >= this.numGenreGoal) {
					currentScore = currentScore + 5;
				}
				if(lite.resultOfChallenge.wr.averagePerDay() >= 50000) {
					currentScore = currentScore + 25 + (5 * (30 - lite.resultOfChallenge.wr.currentDay));
				}
				
					
			}
		}
		return currentScore;
	}

	//JAVADOCS
	/**
	 * Determines if Literarian improved across two Litjams
	 * @param other
	 * @return A boolean representing whether a Literarian improved or not
	 */
	
	boolean anyImprovement(LitJam other) {
		
		for (Literarian liter : literarians) {
			for (Literarian liter2 : other.literarians) {
				if ((liter.penName.equals(liter2.penName))
						&& (this.finalScoreForLiterarian(liter.penName) < other.finalScoreForLiterarian(liter.penName))) {
					return true;
				}
			}
		}
		return false;
	}
	
}
