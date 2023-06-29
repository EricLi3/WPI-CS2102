import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  Snowfall1 E1 = new Snowfall1();
  Snowfall2 E2 = new Snowfall2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<Double> twoDates = new LinkedList<Double>();  
  LinkedList<Double> sevenDates = new LinkedList<Double>();  
  LinkedList<MaxInchReport> expectedThree = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> expectedTwo = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> expectedSeven = new LinkedList<MaxInchReport>();
  LinkedList<Double> expectedSevenJustMax = new LinkedList<Double>();
  LinkedList<Double> expectedTwoJustMax = new LinkedList<Double>();
  LinkedList<Double> expectedSevenJustDays = new LinkedList<Double>();
  LinkedList<Double> expectedTwoJustDays = new LinkedList<Double>();
  
  public SnowfallExamples() {
    threeDates.add(1113.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(1120.0);
    threeDates.add(4.0);
    threeDates.add(5.0);
    threeDates.add(4.5);
    threeDates.add(1201.0);
    threeDates.add(6.0);
    threeDates.add(-0.5);
    expectedThree.add(new MaxInchReport(1201.0,6.0));
    twoDates.add(901.0);
    twoDates.add(9.0);
    twoDates.add(11.0);
    twoDates.add(902.0);
    twoDates.add(3.0);
    twoDates.add(10.0);
    twoDates.add(11.5);
    twoDates.add(-3.7);
    expectedTwo.add(new MaxInchReport(901.0,11.0));
    expectedTwo.add(new MaxInchReport(902.0,11.5));
    sevenDates.add(101.0);
    sevenDates.add(1.4);
    sevenDates.add(2.7);
    sevenDates.add(13.5);
    sevenDates.add(-1.7);
    sevenDates.add(102.0);
    sevenDates.add(2.0);
    sevenDates.add(5.7);
    sevenDates.add(6.5);
    sevenDates.add(-6.8);
    sevenDates.add(103.0);
    sevenDates.add(8.0);
    sevenDates.add(9.8);
    sevenDates.add(7.0);
    sevenDates.add(7.7);
    sevenDates.add(107.0);
    sevenDates.add(6.3);
    sevenDates.add(5.1);
    sevenDates.add(1.5);
    sevenDates.add(20.7);
    sevenDates.add(108.0);
    sevenDates.add(-1.0);
    sevenDates.add(7.7);
    sevenDates.add(10.5);
    sevenDates.add(15.7);
    sevenDates.add(201.0);
    sevenDates.add(9.0);
    sevenDates.add(2.9);
    sevenDates.add(7.0);
    sevenDates.add(9.5);
    sevenDates.add(110.0);
    sevenDates.add(9.0);
    sevenDates.add(8.8);
    sevenDates.add(11.5);
    sevenDates.add(-6.2);
    expectedSeven.add(new MaxInchReport(101.0,13.5));
    expectedSeven.add(new MaxInchReport(102.0,6.5));
    expectedSeven.add(new MaxInchReport(103.0,9.8));
    expectedSeven.add(new MaxInchReport(107.0,20.7));
    expectedSeven.add(new MaxInchReport(108.0,15.7));
    expectedSeven.add(new MaxInchReport(110.0,11.5));
    expectedSevenJustMax.add(13.5);
    expectedSevenJustMax.add(6.5);
    expectedSevenJustMax.add(9.8);
    expectedSevenJustMax.add(20.7);
    expectedSevenJustMax.add(15.7);
    expectedSevenJustMax.add(11.5);
    expectedSevenJustDays.add(101.0);
    expectedSevenJustDays.add(102.0);
    expectedSevenJustDays.add(103.0);
    expectedSevenJustDays.add(107.0);
    expectedSevenJustDays.add(108.0);
    expectedSevenJustDays.add(110.0);
    expectedTwoJustDays.add(901.0);
    expectedTwoJustDays.add(902.0);
    expectedTwoJustMax.add(11.0);
    expectedTwoJustMax.add(11.5);
    
  }
  @Test
  public void instructorTestTwoSnowFall1() { 
	    assertEquals(expectedTwo,
	                 E1.dailyMaxForMonth(twoDates, 9));
	  }
  @Test
  public void instructorTestSevenSnowFall1() { 
	    assertEquals(expectedSeven,
	                 E1.dailyMaxForMonth(sevenDates, 1));
	  }
  @Test
  public void instructorTestThreeSnowFall2() { 
    assertEquals(expectedThree,
                 	E2.dailyMaxForMonth(threeDates, 12));
  }
  @Test
  public void instructorTestTwoSnowFall2() { 
	    assertEquals(expectedTwo,
	                 E2.dailyMaxForMonth(twoDates, 9));
	  }
  @Test
  public void instructorTestSevenSnowFall2() { 
	    assertEquals(expectedSeven,
	                 E2.dailyMaxForMonth(sevenDates, 1));
	  }
  @Test
  public void instructorTestThreenowFall1() { 
	    assertEquals(expectedThree,
	                 E1.dailyMaxForMonth(threeDates, 12));
	  }
  @Test
  public void instructorTestThreeSnowFall2noData() { 
    assertEquals(null,
                 	E2.dailyMaxForMonth(noData, 10));
  }
  @Test
  public void instructorTestThreeSnowFall1noData() { 
    assertEquals(null,
                 	E1.dailyMaxForMonth(noData, 10));
  }
  @Test
  public void instructorTestSevennowFall1JustMax() { 
    assertEquals(expectedSevenJustMax,
                 	E1.JustMax(sevenDates, 1));
  }
  @Test
  public void instructorTestSevennowFall1JustDays() { 
    assertEquals(expectedSevenJustDays,
                 	E1.JustDays(sevenDates, 1));
  }
  @Test
  public void instructorTestTwonowFall1JustMax() { 
    assertEquals(expectedTwoJustMax,
                 	E1.JustMax(twoDates, 9));
  }
  @Test
  public void instructorTestTwonowFall1JustDays() { 
    assertEquals(expectedTwoJustDays,
                 	E1.JustDays(twoDates, 9));
  }

}

/*
 * Ignore negative numbers and numbers from the wrong month
 * Find max after each month
 * return max of the corresponding date
 * Return list of maxInch objects. 
 */
