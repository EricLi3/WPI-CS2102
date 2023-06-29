import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * This class manages how trends are calculated. It has methods
 * bestRanksThisMonth(), totalSongDownloads(), and addTodaysSurveys() to
 * accomplish this.
 */
public class RadioStation {
	private IRatings dailyFinalRatings;
	// private LinkedList<TodaysRatings> dailyFinalRatings;
	private GregorianCalendar currentDate;

	public RadioStation(IRatings dailyFinalRatings, GregorianCalendar currentDate) {
		this.dailyFinalRatings = dailyFinalRatings;
		this.currentDate = currentDate;
	}

	public RadioStation() {
		dailyFinalRatings = new LLRadioStation();

	}

	/**
	 * Finds the smallest rank (int) this month.
	 * 
	 * @return the smallest rank this month. If there is no data returns -1.
	 */
	public int bestRankThisMonth() {
		return dailyFinalRatings.bestRankForMonth();
	}

	/**
	 * Produces the total song downloads over all days that month.
	 * 
	 * @param month
	 * @param year
	 * @return an int representing the total song downloads over all days that
	 *         month. returns -1 in a case of an invalid month
	 */
	public int totalMonthSongDownloads(int month, int year) {
		return dailyFinalRatings.totalDownloadsForMonth(month, year);
	}

	/**
	 * Stores a TodaysRatings in dailyFinalRatings and adds 1 day to the current
	 * date.
	 * 
	 * @param ratings
	 */
	public void addTodaysSurveys(LinkedList<Survey> ratings) {

		LinkedList<Integer> ranks = new LinkedList<>();
		LinkedList<Integer> downloads = new LinkedList<>();

		GregorianCalendar newDate = new GregorianCalendar(currentDate.get(GregorianCalendar.YEAR),
				currentDate.get(GregorianCalendar.MONTH), currentDate.get(GregorianCalendar.DAY_OF_MONTH));

		for (Survey survey : ratings) {
			ranks.add(survey.getRank());
			downloads.add(survey.getDownloadsSince());
		}
		currentDate.add(GregorianCalendar.DAY_OF_YEAR, 1);
		TodaysRatings r = new TodaysRatings(newDate, ranks, downloads);
		dailyFinalRatings.add(r);

	}

}
//Answer for Short answer questions
/*
 * 1) A potential better data structure for RadioStation other than LinkedList<TodaysRatings> could be a BST.
 * 	  We feel like a BST might be a better data structure because using a BST cuts down the search time on average,
 * 	  allowing us to in theory look up specific TodaysRatings quicker on average compared looking thorough a Linked List.
 * 
 * 2) If we were to implement a class to encapsulate the BST data structure, the method implementations
 *    would be tailored for the BST data structure. In general, the implemented class will contain 
 *    methods made especially for their data structure. For example in a class with a LinkedList Data type, 
 *    we would have a for loop somewhere in the class to look through it. 
 *    
 * 3) We feel like it's possible to implement all the methods on the interface for a different data structure. Maybe 
 *    just not all the time where we can do that. Based on my limited knowledge, I'm pretty sure that there is some combination
 *    of data structures where you will need to modify the interface you designed for the other data structure.
 */
