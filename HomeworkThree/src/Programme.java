import java.util.LinkedList;

class Programme {

	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;

	Programme() {
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}

	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree) {
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}

	//JAVADOCS
	/**
	 * Overrides the default equals to the conditions states in the method equalsHelper. 
	 * @return boolean representing our updated conditions for equality
	 */
	
	@Override
	public boolean equals(Object obj) {

		Programme aProgram = (Programme) obj;

		return (this.equalsHelper(this.matinee, aProgram.matinee)
				&& this.equalsHelper(this.primetime, aProgram.primetime)
				&& this.equalsHelper(this.soiree, aProgram.soiree));

	}

	//JAVADOCS
	/**
	 * Helper for equals, has desired conditions for overiding equals 
	 * @param thesePrograms
	 * @param otherPrograms
	 * @return boolean representing whether two programs have the same size, and movies
	 * with the same movies being if the title is the same and the showtime is the same.
	 */
	
	private boolean equalsHelper(LinkedList<Movie> thesePrograms, LinkedList<Movie> otherPrograms) {

		if (thesePrograms.size() != otherPrograms.size()) {
			return false;

		}

		for (int i = 0; i < thesePrograms.size(); i++) {

			Movie thisMovie = thesePrograms.get(i);
			Movie otherMovie = otherPrograms.get(i);

			if (!thisMovie.title.equals(otherMovie.title)) {
				return false;
			} else if (thisMovie.showtime != otherMovie.showtime) {
				return false;
			}
		}
		return true;
	}
}
