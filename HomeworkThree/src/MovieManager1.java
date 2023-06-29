import java.util.LinkedList;

class MovieManager1 {
	
	MovieManager1() {}

	/**
	 * Consumes a list of Movies and produces a Programme containing all 
	 * of the matinee, primetime, and soiree shows in the list that are not simulcasts 
	 * @param movies
	 * @return a Programme containing all shows in the list that aren't similcasts
	 */
	/*
	Matinees have a start time at or after 7:00 am and before 12:00 pm (noon). 
	Primetime shows have a start time at or after 12:00 pm (noon) and before 8:00 pm. 
	Soiree shows have a start time at or after 8:00 pm and before 2:00 am. 
	*/
	
	public Programme organizeMovies(LinkedList<Movie> movies)	{
		Programme report = new Programme();
		
		for(Movie m : movies) {
			
			if(m.showtime >= 700 && m.showtime <= 1200	&&	m.simulcast == false) {
				report.matinee.add(m);
			}
			else if(m.showtime >= 1200 && m.showtime <= 2000	&&	m.simulcast == false) {
				report.primetime.add(m);
			}
			else if((m.showtime >= 2000 || m.showtime <= 200) &&	m.simulcast == false) {
				report.soiree.add(m);
			}
			
		}
		return report;
	}
	
}
