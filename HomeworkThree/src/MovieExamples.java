import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MovieExamples
{
	MovieManager1 mm1 = new MovieManager1();
	MovieManager2 mm2 = new MovieManager2();
	LinkedList<Movie> movies = new LinkedList<Movie>();
	Programme programme1 = new Programme();

	Movie starTrek = new Movie("Star Trek Into Darkness", 1400, 132, false);
	Movie pinicchio = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
	Movie swampThing = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
	Movie sevenSamurai = new Movie("Seven Samurai", 0, 207, false);

	public MovieExamples()
	{
		movies.add(starTrek);
		programme1.primetime.add(starTrek);

		movies.add(pinicchio);
		programme1.matinee.add(pinicchio);

		movies.add(swampThing);
		programme1.soiree.add(swampThing);

		movies.add(sevenSamurai);
		programme1.soiree.add(sevenSamurai);
	}

	@Test
	public void instructorTestProgramme_EmptyReport() {
		Programme report2 = new Programme();
		assertFalse(programme1.equals(report2));
	}


	@Test
	public void instructorTestProgramme_WrongOrder() {
		Programme programme2 = new Programme();

		programme2.primetime.add(starTrek);
		programme2.matinee.add(pinicchio);
		programme2.soiree.add(sevenSamurai);
		programme2.soiree.add(swampThing);


		assertFalse(programme1.equals(programme2));
	}
	
	@Test
	public void TestEqualsIdentical() {
		Programme programme2 = new Programme();

		programme2.primetime.add(starTrek);
		programme2.matinee.add(pinicchio);
		programme2.soiree.add(swampThing);
		programme2.soiree.add(sevenSamurai);


		assertTrue(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_DifferentInstances() {
		Programme programme2 = new Programme();

		Movie starTrek2 = new Movie("Star Trek Into Darkness", 1400, 132, false);
		Movie pinocchio2 = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
		Movie swampThing2 = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
		Movie sevenSamurai2 = new Movie("Seven Samurai", 0, 207, false);

		programme2.primetime.add(starTrek2);
		programme2.matinee.add(pinocchio2);
		programme2.soiree.add(swampThing2);
		programme2.soiree.add(sevenSamurai2);

		assertTrue(programme1.equals(programme2));
		//assertFalse(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_SameInstances() {
		Programme programme2 = programme1;
		assertTrue(programme1.equals(programme2));
	}


	@Test
	public void TestOneForOrganizeMoviesMethodOne()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}
	
	@Test
	public void TestTwoForOrganizeMoviesMethodOne()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(sevenSamurai); 
		assertFalse(programme1.equals(programme2));
	}
	
	@Test
	public void TestOneForOrganizeMoviesMethodTwo()
	{
		Programme programme2 = mm2.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}
	
	@Test
	public void TestTwoForOrganizeMoviesMethodTwo()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(sevenSamurai); 
		assertFalse(programme1.equals(programme2));
	}
}
	
/*
 * Subtasks for Problem One
 * - Determine which category a movie falls in specific categories
 * - Check the simulcast field, on its boolean. (false is when the movie is not a simulcast
 * - Returns a Programme report 
 * */
