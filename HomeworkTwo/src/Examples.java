import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class Examples {

	// making Objects for BooksRead
	BooksRead fictionNumberOne = new BooksRead(2.5, "fiction", false);
	BooksRead nonFictionNumberOne = new BooksRead(3.5, "nonfiction", true);
	BooksRead cartoonOne = new BooksRead(0.0, "cartoon", false);
	BooksRead comedyOne = new BooksRead(40.3, "comedy", true);

	// making Objects for ReadingResult
	ReadingResult ReadingResultOne = new ReadingResult(100, fictionNumberOne, nonFictionNumberOne);
	ReadingResult ReadingResultTwo = new ReadingResult(50, cartoonOne, nonFictionNumberOne);
	ReadingResult ReadingResultThree= new ReadingResult (62, cartoonOne, comedyOne);
	ReadingResult ReadingResultFour = new ReadingResult (20, fictionNumberOne, comedyOne);

	// making Objects for WritingResult
	WritingResult WritingResultOne = new WritingResult(10000.0, 10);
	WritingResult WritingResultTwo = new WritingResult(20000.0, 15);
	WritingResult WritingResultThree = new WritingResult (50000.0, 31);
	WritingResult WritingResultFour = new WritingResult (2000.0, 1);
	WritingResult WritingResultFive = new WritingResult (0.0, 1);
	// one where the object surpasses the goal.... maybe
	
	// making Objects for ChallengeResult
	ChallengeResult ChallengeResultOne = new ChallengeResult(ReadingResultOne, WritingResultTwo);
	ChallengeResult ChallengeResultTwo = new ChallengeResult(ReadingResultTwo, WritingResultOne);
    ChallengeResult ChallengeResultThree = new ChallengeResult (ReadingResultFour, WritingResultFour);
    ChallengeResult ChallengeResultFour = new ChallengeResult (ReadingResultOne, WritingResultFive);
	
	// making Objects for Literarian
	Literarian LiterarianOne = new Literarian("John", ChallengeResultOne);
	Literarian LiterarianTwo = new Literarian("Bob", ChallengeResultTwo);
	Literarian LiterarianThree = new Literarian("Kev", ChallengeResultThree);
	
	////////////////////////////HW2 Objects/////////////////////////////////
	
	// making objects for PoemResult
	PoemResult PoemResultOne = new PoemResult(100.0, 5, 2);
	PoemResult PoemResultTwo = new PoemResult(250.0, 12, 4);
	PoemResult PoemResultThree = new PoemResult(0.0, 1, 0);
	PoemResult PoemResultFour = new PoemResult(1.0, 1, 1);	
	
	LinkedList<Double> chapterNumberWriting = new LinkedList<Double>();
	LinkedList<BooksRead> genres = new LinkedList<BooksRead>();
	LinkedList<Double> chapterNumberPoem = new LinkedList<Double>();
	
	WritingResult WritingR = new WritingResult(0.0, 0);
	PoemResult PoemR = new PoemResult(0.0, 0, 0);
	
	
	public Examples(){
	chapterNumberWriting.add(1.0);
	chapterNumberWriting.add(2.0);
	
	genres.add(fictionNumberOne);
	genres.add(nonFictionNumberOne);
	genres.add(cartoonOne);
	genres.add(comedyOne);
	
	
	
	}
	
//TESTS FOR METHODS MADE FOR HW2
	
	//Testing nextChapter method in WritingResult class*****************************************
	@Test
	public void testNextChapterOne() {
		
		assertEquals(WritingResultOne.nextChapter(3.0).chapterNumber.size(), 2);
	
	}
	
	
	
	//TESTING ReadingResult bestGenreByType*****************************
	@Test
	public void testBestGenreByTypeOne() {
		
	}
	
	
	//TESTING ReadingResult readSomeBooks*********************************
	
	@Test
	public void testReadSomeBooksOne() {
		
		assertEquals(ReadingResultOne.readSomeBooks(fictionNumberOne).genres.size(), 3);
	}
	@Test
	public void testReadSomeBooksTwo() {
		
		assertEquals(ReadingResultTwo.readSomeBooks(cartoonOne).genres.size(), 3);
	}
	
	//Testing ABSWP class generalAveragePerDay 
	@Test
	public void testgeneralAveragePerDayWriting() {
		
		assertEquals(WritingResultOne.generalAveragePerDay(), 1000.0, 0.01);
	}
	@Test
	public void testgeneralAveragePerDayPoem() {
		
		assertEquals(PoemResultOne.generalAveragePerDay(), 20.0, 0.01);
	}
	
//////////////////////////////////////////Test methods for PoemResult class///////////////////////////////////////////
	
	// Test nextPoem method
	@Test
	public void testNextPoemOne() {
		
		assertEquals(PoemResultOne.nextPoem(4.0, true).chapterNumber.size(), 2);//*************************************8
		assertEquals(PoemResultOne.nextPoem(4.0, true).weeksSubmitPoem, 4);
	}
	
	
	//Test averagePerDay method
	@Test
	public void testAveragePerDayPoemOne() {
		
		assertEquals(PoemResultOne.averagePerDay(), 20.0, 0.01);
	}
	@Test
	public void testAveragePerDayPoemTwo() {
		
		assertEquals(PoemResultTwo.averagePerDay(), 20.83, 0.01);
	}
	@Test
	public void testAveragePerDayPoemThree() {
		
		assertEquals(PoemResultThree.averagePerDay(), 0, 0.01);
	}
	@Test
	public void testAveragePerDayPoemFour() {
		
		assertEquals(PoemResultFour.averagePerDay(), 1.0, 0.01);
	}
	//Test differenceFromGoal
	@Test
	public void testDifferenceFromGoalPoemOne() {
		assertEquals(PoemResultOne.differenceFromGoal(), 0.74, 0.01);
	}
	@Test
	public void testDifferenceFromGoalPoemTwo() {
		assertEquals(PoemResultTwo.differenceFromGoal(), 0.0, 0.01);
	}
	@Test
	public void testDifferenceFromGoalPoemThree() {
		assertEquals(PoemResultThree.differenceFromGoal(), 0.0, 0.01);
	}
	
/*---------------------------------------------------------------------------------------*/
	
//TESTS REGARDING METHODS FROM HW1
	
	// tests for BooksRead
	@Test
	public void testForStoringNumberInBooksReadOne() {
		assertEquals(2.5, fictionNumberOne.numBooks, 0.01);
	}

	@Test
	public void testForStoringNumberInBooksReadTwo() {
		assertEquals(0.0, cartoonOne.numBooks, 0.01);
	}

	// test cases for averagePerDay() for ReadingResult
	@Test
	public void RTestAveragePerDayOne() {
		double expected = ((2.5 + 3.5) / 31);
		assertEquals(expected, ReadingResultOne.averagePerDay(), 0.01);
	}

	@Test
	public void RTestAveragePerDayTwo() {
		double expected = ((0.0 + 3.5) / 31);
		assertEquals(expected, ReadingResultTwo.averagePerDay(), 0.01);
	}

	// test cases for differenceFromGoal() for ReadingResult
	@Test
	public void RTestDifferenceFromGoalOne() {
		double expected = 100 - ((2.5 + 3.5) / 31);
		assertEquals(expected, ReadingResultOne.differenceFromGoal(), 0.01);
	}

	@Test
	public void RTestDifferenceFromGoalTwo() {
		double expected = 50 - ((0.0+3.5) / 31);
		assertEquals(expected, ReadingResultTwo.differenceFromGoal(), 0.01);
	}

	// test cases for averagePerDay() for WritingResult
	@Test
	public void WTestAverageOne() {
		double expected = 10000.0 / 10;
		assertEquals(expected, WritingResultOne.averagePerDay(), 0.01);
	}

	@Test
	public void WTestAverageTwo() {
		double expected = 20000.0 / 15;
		assertEquals(expected, WritingResultTwo.averagePerDay(), 0.01);
	}

	// test cases for differenceFromGoal() for WritingResult
	@Test
	public void WTestDifferenceFromGoalOne() {
		double expected = (50000.0 - 10000) / (30 - 10 + 1);
		assertEquals(expected, WritingResultOne.differenceFromGoal(), 0.01);
	}

	@Test
	public void WTestDifferenceFromGoalTwo() {
		double expected = (50000.0 - 20000) / (30 - 15 + 1);
		assertEquals(expected, WritingResultTwo.differenceFromGoal(), 0.01);
	}
	
	// test cases for howClose() for ChallengeResult
	@Test
	public void TestHowCloseOne() {
		assertEquals(999939.52, ChallengeResultOne.howClose(), 0.01);
	}

	@Test
	public void TestHowCloseTwo() {
		assertEquals(500775.73, ChallengeResultTwo.howClose(), 0.01);
	}
	@Test
	public void TestHowCloseThree() {
		assertEquals(999731.18, ChallengeResultFour.howClose(), 0.01);
	}
	
	
	// test cases for betterBookworm for Literarian
	@Test
	public void TestBetterBookwormOne() {
		assertFalse(LiterarianOne.betterBookworm(LiterarianTwo));
	}
	@Test
	public void TestBetterBookwormTwo() {
		assertTrue(LiterarianTwo.betterBookworm(LiterarianOne));
	}
	@Test
	public void TestBetterBookwormThree() {
		assertFalse(LiterarianOne.betterBookworm(LiterarianOne));
	}
	
	// test cases for wittierWordsmith() for Literarian
	@Test
	public void TestWittierWordsmithOne() {
		assertTrue(LiterarianTwo.betterBookworm(LiterarianOne));
	}
	@Test
	public void TestWittierWordsmithTwo() {
		assertFalse(LiterarianOne.betterBookworm(LiterarianTwo));
	}
	@Test
	public void TestWittierWordsmithThree() {
		assertFalse(LiterarianOne.betterBookworm(LiterarianOne));
	}
	
	// test cases for successfulScholar() for Literarian
	@Test
	public void TestSuccessfulScholarOne() {
		assertTrue(LiterarianTwo.successfulScholar(LiterarianOne));
	}
	@Test
	public void TestSuccessfulScholarTwo() {
		assertTrue(LiterarianOne.successfulScholar(LiterarianTwo));
	}
	@Test
	public void TestSuccessfulScholarThree() {
		assertFalse(LiterarianOne.successfulScholar(LiterarianThree));
	}
	@Test
	public void TestSuccessfulScholarFour() {
		assertFalse(LiterarianTwo.successfulScholar(LiterarianTwo));
	}
			
}