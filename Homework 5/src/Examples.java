import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class Examples {
	// RadioStation radioXMNINE = new RadioStation();

	public Examples() {

	}

	Survey s1 = new Survey(1, 5000);
	Survey s2 = new Survey(2, 4500);
	Survey s3 = new Survey(5, 3000);
	Survey s4 = new Survey(6, 2450); 
	Survey s5 = new Survey(9, 1234);
	Survey s6 = new Survey(10, 1200);
	Survey s7 = new Survey(3, 4753);
	Survey s8 = new Survey(7, 1324);
	Survey s9 = new Survey(8, 1111);
	Survey s10 = new Survey(11, 300);
	Survey s11 = new Survey(15, 20);

	GregorianCalendar date1 = new GregorianCalendar(2020, 1, 1);
	GregorianCalendar date2 = new GregorianCalendar(2020, 1, 2);
	GregorianCalendar date3 = new GregorianCalendar(2020, 2, 1);
	GregorianCalendar date4 = new GregorianCalendar(2020, 2, 2);

	GregorianCalendar date5 = new GregorianCalendar(2019, 1, 1);
	GregorianCalendar date6 = new GregorianCalendar(2019, 1, 2);
	GregorianCalendar date7 = new GregorianCalendar(2019, 2, 1);
	GregorianCalendar date8 = new GregorianCalendar(2019, 2, 2);

	LinkedList<Integer> rankingsL1 = new LinkedList<Integer>();
	LinkedList<Integer> rankingsL2 = new LinkedList<Integer>();
	LinkedList<Integer> downloadsL1 = new LinkedList<Integer>();
	LinkedList<Integer> downloadsL2 = new LinkedList<Integer>();

	LinkedList<Survey> ListOfsurveys1 = new LinkedList<Survey>();
	LinkedList<Survey> ListOfsurveys2 = new LinkedList<Survey>();

	TodaysRatings todaysRatings1 = new TodaysRatings();
	TodaysRatings todaysRatings2 = new TodaysRatings();
	TodaysRatings todaysRatings3 = new TodaysRatings();
	TodaysRatings todaysRatings4 = new TodaysRatings();

	LinkedList<TodaysRatings> LinkedListOfTodaysRatings1 = new LinkedList<TodaysRatings>();
	LinkedList<TodaysRatings> LinkedListOfTodaysRatings2 = new LinkedList<TodaysRatings>();
	LinkedList<TodaysRatings> LinkedListOfTodaysRatings3 = new LinkedList<TodaysRatings>();

	RadioStation RadioStation1 = new RadioStation();
	RadioStation RadioStation2 = new RadioStation();// normal
	

	LLRadioStation LLRadioStation1 = new LLRadioStation();

	@Before
	public void setUp() {
		ListOfsurveys1.add(s1);
		ListOfsurveys1.add(s2);
		ListOfsurveys1.add(s3);
		ListOfsurveys1.add(s4);

		ListOfsurveys2.add(s5);
		ListOfsurveys2.add(s6);
		ListOfsurveys2.add(s7);
		ListOfsurveys2.add(s8);

		rankingsL1.add(s1.getRank());
		rankingsL1.add(s2.getRank());
		rankingsL1.add(s3.getRank());

		rankingsL2.add(s4.getRank());
		rankingsL2.add(s5.getRank());

		downloadsL1.add(s1.getDownloadsSince());
		downloadsL1.add(s2.getDownloadsSince());
		downloadsL1.add(s3.getDownloadsSince());

		downloadsL2.add(s3.getDownloadsSince());
		downloadsL2.add(s5.getDownloadsSince());
		

		todaysRatings1 = new TodaysRatings(date1, rankingsL1, downloadsL1);
		todaysRatings2 = new TodaysRatings(date2, rankingsL2, downloadsL2);
		//todaysRatings3 = new TodaysRatings(date3, rankingsL1, downloadsL2);

		LinkedListOfTodaysRatings1.add(todaysRatings1);
		
		LinkedListOfTodaysRatings2.add(todaysRatings2);
		LinkedListOfTodaysRatings2.add(todaysRatings3);
		//LinkedListOfTodaysRatings3.add(todaysRatings3);

		LLRadioStation1 = new LLRadioStation(LinkedListOfTodaysRatings3, date1);
		RadioStation2 = new RadioStation(LLRadioStation1, date1);

		RadioStation2.addTodaysSurveys(ListOfsurveys1);
		RadioStation2.addTodaysSurveys(ListOfsurveys2);

	}
	//Tests for BestRankThisMonth

	@Test
	public void testBestRankThisMonthNormal() {

		int answer = RadioStation2.bestRankThisMonth();

		assertEquals(1, answer);
	}
	
	@Test
	public void testBestRankThisMonthEmptyNoData() {

		int answer = RadioStation1.bestRankThisMonth();

		assertEquals(-1, answer);
	}
	

	//Tests for totalMonthSongDownloads.
	@Test
	public void testtotalMonthSongDownloadsNormalValidMonth() {

		int answer = RadioStation2.totalMonthSongDownloads(1, 2020);

		assertEquals(23461, answer);
	}
	
	@Test
	public void testtotalMonthSongDownloadsAnotherValidMonth() {
		
		
		int answer = RadioStation2.totalMonthSongDownloads(2, 2020);

		assertEquals(0, answer);
	}
	
	@Test
	public void testtotalMonthSongDownloadsInvalidMonth() {

		int answer = RadioStation2.totalMonthSongDownloads(12, 2020);

		assertEquals(-1, answer);
	}
	
	
	//Tests rightMonth Helper method in TodaysRatings Class.
	@Test
	public void testRightMonthGoodData() {
		assertTrue(todaysRatings1.rightMonth(1, 2020));
	}
	
	@Test
	public void testRightMonthFalseCase() {
		assertFalse(todaysRatings2.rightMonth(3, 2017));
	}
	
	
	//Testing TodaysRatings totalDownloads() method
	@Test
	public void testTotalDownloadsValid() {
		assertEquals(12500, todaysRatings1.totalDownloads());
	}
	
	//Tests TodaysRatings getElementRankings() method
	@Test
	public void testGetElementRakings() {
		int answer =  todaysRatings2.getElementRankings(1);
		assertEquals(9, answer);
	}
	@Test
	public void testGetElementRakingsInvalidExpected() {
		int answer =  todaysRatings2.getElementRankings(1);
		assertFalse(2 == answer);
	}
	
	

}
