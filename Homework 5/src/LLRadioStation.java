import java.util.GregorianCalendar;
import java.util.LinkedList;

public class LLRadioStation implements IRatings {

	private LinkedList<TodaysRatings> dailyFinalRatings;
	private GregorianCalendar currentDate;
	
	public LLRadioStation(LinkedList<TodaysRatings> dailyFinalRatings, GregorianCalendar currentDate) {
		this.dailyFinalRatings = dailyFinalRatings;
		this.currentDate = currentDate;
	}

	public LLRadioStation() {
		dailyFinalRatings = new LinkedList<TodaysRatings>();
	}
	
	
	/**
	 * Finds the size of the dailyFinalRatings
	 * 
	 * @return integer representing the size of the dailyFinalRatings
	 */
	@Override
	public int size() {
		return dailyFinalRatings.size();
	}

	
	/**
	 * Finds the best rank for a month in a year and returns it.
	 * 
	 * @return integer representing the best rank for a month in a year. (lowest rank) 
	 * 		   rank is positive integer. 1 being the best
	 */
	@Override
	public int bestRankForMonth() {
		if (dailyFinalRatings.size() == 0)
			return -1;

		//Filters the original list in a way, by adding certain TodaysRatings.
		LinkedList<TodaysRatings> filteredByCurrentDate = new LinkedList<TodaysRatings>();

		for (int i = 0; i < dailyFinalRatings.size(); i++) {
			if (dailyFinalRatings.get(i).getDate().get(GregorianCalendar.MONTH) == currentDate.get(GregorianCalendar.MONTH)
					&& dailyFinalRatings.get(i).getDate().get(GregorianCalendar.YEAR) == currentDate.get(GregorianCalendar.YEAR)) {
				
				filteredByCurrentDate.add(dailyFinalRatings.get(i));
			}
		}
		
		// Gets the bestRank from the "filtered" list. 
		int bestRank = 1;
		
		for (int k = 0; k < filteredByCurrentDate.size(); k++) {
			if (dailyFinalRatings.get(k).getElementRankings(k) <= bestRank) {
				bestRank = dailyFinalRatings.get(k).getElementRankings(k);
			}
		}
		return bestRank;
	}

	/*
	 * @Override public int totalDownloadsForMonth(int month, int year) { if (month
	 * < 0 || month > 11) { return -1; }
	 * 
	 * int downloadTotal = 0;
	 * 
	 * for (TodaysRatings todayRating : dailyFinalRatings) { if
	 * (todayRating.getDate().get(GregorianCalendar.MONTH) == month &&
	 * todayRating.getDate().get(GregorianCalendar.YEAR) == year) { downloadTotal +=
	 * todayRating.totalDownloads(); } }
	 * 
	 * return downloadTotal; }
	 */
	
	/**
	 * Produces the total song downloads over all days that month.
	 * 
	 * @param month number such as 0 being January.
	 * @param year
	 * @return an int representing the total song downloads over all days that
	 *         month. returns -1 in a case of an invalid month
	 */
	@Override
	public int totalDownloadsForMonth(int month, int year) {
		if (month < 0 || month > 11) {
			return -1;
		}

		int downloadTotal = 0;

		for (TodaysRatings todayRating : dailyFinalRatings) {
			if (todayRating.rightMonth(month, year)) {
				downloadTotal += todayRating.totalDownloads();
			}
		}

		return downloadTotal;
	}
	
	/**
	 * Stores a today rating in dailyFinalRatings.
	 * @param r
	 */
	@Override
	public void add(TodaysRatings r) {
		dailyFinalRatings.add(r);
	}

}
