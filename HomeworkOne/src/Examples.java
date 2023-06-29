//Eric Li and Daniel Zhang

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

	// making Objects for BooksRead
	BooksRead fictionNumberOne = new BooksRead(2.5);
	BooksRead nonFictionNumberOne = new BooksRead(3.5);
	BooksRead fictionNumberTwo = new BooksRead(0.0);
	BooksRead nonFictionNumberTwo = new BooksRead(40.3);

	// making Objects for ReadingResult
	ReadingResult ReadingResultOne = new ReadingResult(100, fictionNumberOne, nonFictionNumberOne);
	ReadingResult ReadingResultTwo = new ReadingResult(50, fictionNumberTwo, nonFictionNumberOne);
	ReadingResult ReadingResultThree= new ReadingResult (62, fictionNumberTwo, nonFictionNumberTwo);
	ReadingResult ReadingResultFour = new ReadingResult (20, fictionNumberOne, nonFictionNumberTwo);

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
	Literarian LiterarianOne = new Literarian(ChallengeResultOne);
	Literarian LiterarianTwo = new Literarian(ChallengeResultTwo);
	Literarian LiterarianThree = new Literarian(ChallengeResultThree);

	// tests for BooksRead
	@Test
	public void TestForStoringNumberInBooksReadOne() {
		assertEquals(2.5, fictionNumberOne.booksRead, 0.01);
	}

	@Test
	public void TestForStoringNumberInBooksReadTwo() {
		assertEquals(0.0, fictionNumberTwo.booksRead, 0.01);
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
		double expected = (50000.0 - 10000)/(30 - 10 + 1);
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