
public interface IRatings {

	/**
	 * Finds the size of the dailyFinalRatings
	 * 
	 * @return integer representing the size of the dailyFinalRatings
	 */
	public int size();

	/**
	 * Finds the best rank for a month in a year and returns it.
	 * 
	 * @return integer representing the best rank for a month in a year. (lowest rank) 
	 * 		   rank is positive integer. 1 being the best
	 */
	public int bestRankForMonth();

	/**
	 * Produces the total song downloads over all days that month.
	 * 
	 * @param month number such as 0 being January.
	 * @param year
	 * @return an int representing the total song downloads over all days that
	 *         month. returns -1 in a case of an invalid month
	 */
	public int totalDownloadsForMonth(int month, int year);

	/**
	 * Stores a today rating in dailyFinalRatings.
	 * @param r
	 */
	public void add(TodaysRatings r);
}
