import java.util.LinkedList;

public class ReadingResult implements IChallenge {
	LinkedList<BooksRead> genres;
	int goal;

	public ReadingResult(Integer goal, BooksRead booksReadOne, BooksRead booksReadTwo) {
		this.goal = goal;

		this.genres = new LinkedList<BooksRead>();
		genres.add(booksReadOne);
		genres.add(booksReadTwo);
	}

	// JAVADOCS
	/**
	 * Determines the genre of the best books read
	 * @param consider
	 * @return genre string of the best books read
	 */
	
	public String bestGenreByType(boolean consider) {
		if (genres.size() == 0)
			return null;
		BooksRead book = genres.get(0);
		for (BooksRead object : genres) {
			int i = 0;
			if (!(consider == true  && object.skimmed == true)) {
				if (i==0)
					book=object;
				else {
				if (object.numBooks > book.numBooks) {
					book = object;
				} else if (object.numBooks == book.numBooks) {
					book = object;
				}
				}
				i++;
			}
			if (i==0) {
			return null;
			}
		}
		return book.genre;
	}

	// JAVADOCS
	/**
	 * Adds a BooksRead object to a literarian's reading result to the list of genres
	 * @param Object
	 * @return The WritingResult
	 */
	public ReadingResult readSomeBooks(BooksRead Object) {
		this.genres.add(Object);
		return this;
	}

	// JAVADOCS
	/**
	 * Calculates average books read
	 * @return A double which is the average books read
	 */
	public double averagePerDay() {

		double sum1 = 0.0;
		for (BooksRead books : genres) {
			sum1 = sum1 + books.numBooks;
		}
		
		return (sum1 / 31);
	}

	// JAVADOCS
	/**
	 * Calculates the difference from a set goal of books read
	 * @return A double which is the difference from a set goal of books read
	 */
	public double differenceFromGoal() {

		if ((this.goal - averagePerDay()) < 0) {
			return 0;
		} 
		
		else {

			return (this.goal - averagePerDay());
		}
	}

}
