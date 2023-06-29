import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * This class manages information for a collection of todaysSurveys
 */
public class TodaysRatings {
	private GregorianCalendar date;
	private LinkedList<Integer> rankings;
	private LinkedList<Integer> downloads;

	public TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankings, LinkedList<Integer> downloads) {
		this.date = date;
		this.rankings = rankings;
		this.downloads = downloads;
	}

	public TodaysRatings() {
		this.rankings = new LinkedList<Integer>();
		this.downloads = new LinkedList<Integer>();
	}

	/**
	 * Gets a ranking at index (k) from the LinkedList of rankings.
	 * 
	 * @return A integer representing a ranking at index k.
	 */
	public Integer getElementRankings(int k) {
		return rankings.get(k);
	}

	/**
	 * Checks if two dates are the same month in regard for month and year.
	 * 
	 * @param otherDate
	 * @return Boolean indicating if two dates are the same in respect to the month
	 *         and year.
	 */
	public boolean rightMonth(int month, int year) {
		return this.getDate().get(GregorianCalendar.MONTH) == month
				&& this.getDate().get(GregorianCalendar.YEAR) == year;
	}

	/**
	 * Gets the Date for a todaysRatings
	 * 
	 * @return GregorianCalendar object which is the date for a todaysRatings.
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * Calculates the total Downloads 
	 * Return an integer representing the total downloads.
	 */
	public int totalDownloads() {
		int sum = 0;
		for (int download : downloads) {
			sum += download;
		}
		return sum;

		// With a for loop here return an int representing the total downloads
	}

}
