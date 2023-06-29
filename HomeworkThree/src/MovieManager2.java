import java.util.LinkedList;

class MovieManager2 {

	MovieManager2() {
		
	}

	/**
	 * Consumes a list of Movies and produces a Programme containing all of the
	 * matinee, primetime, and soiree shows in the list that are not simulcasts
	 * 
	 * @param movies
	 * @return a Programme containing all shows in the list that aren't similcasts
	 */
	/*
	 * Matinees have a start time at or after 7:00 am and before 12:00 pm (noon).
	 * Primetime shows have a start time at or after 12:00 pm (noon) and before 8:00
	 * pm. Soiree shows have a start time at or after 8:00 pm and before 2:00 am.
	 */

	public Programme organizeMovies(LinkedList<Movie> movies) {

		//LinkedList<Movie> result = cleaned(movies);

		LinkedList<Movie> matineeResult = seperateMatinee(movies);
		LinkedList<Movie> primetimeResult = seperatePrimetime(movies);
		LinkedList<Movie> soireeResult = seperateSoiree(movies);

		Programme reportMade = new Programme(matineeResult, primetimeResult, soireeResult);
		
		return reportMade;
	}

	// Helpers that separate matinee, primtime and soiree shows

	/**
	 * Separates matinee results from linked list of movies puts all the matinee movies
	 * that aren't similcasts in a list
	 * @param sm
	 * @return a LinkedList containing all shows in the filtered list that aren't similcasts. 
	 */
	LinkedList<Movie> seperateMatinee(LinkedList<Movie> sm) {
		LinkedList<Movie> matineeResult = new LinkedList<Movie>();

		for (Movie m : sm) {
			if (m.showtime >= 700 && m.showtime <= 1200 && m.simulcast == false) {
				matineeResult.add(m);
			}
		}
		return matineeResult;
	}
	/**
	 * Separates primetime results from linked list of movies puts all the primetime movies
	 * that aren't similcasts in a list
	 * @param sp
	 * @return a LinkedList containing all shows in the filtered list that aren't similcasts. 
	 */
	LinkedList<Movie> seperatePrimetime(LinkedList<Movie> sp) {
		LinkedList<Movie> primetimeResult = new LinkedList<Movie>();

		for (Movie pt : sp) {
			if (pt.showtime >= 1200 && pt.showtime <= 2000 && pt.simulcast == false) {
				primetimeResult.add(pt);
			}
		}
		return primetimeResult;
	}
	/**
	 * Separates soiree results from linked list of movies puts all the soiree movies
	 * that aren't similcasts in a list
	 * @param ss
	 * @return a LinkedList containing all shows in the filtered list that aren't similcasts. 
	 */
	LinkedList<Movie> seperateSoiree(LinkedList<Movie> ss) {
		LinkedList<Movie> soireeResult = new LinkedList<Movie>();

		for (Movie sm : ss) {
			if ((sm.showtime >= 2000 || sm.showtime <= 200) && sm.simulcast == false) {
				soireeResult.add(sm);
			}
		}
		return soireeResult;
	}

}
