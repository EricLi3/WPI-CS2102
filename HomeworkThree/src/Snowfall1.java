import java.util.LinkedList;

class Snowfall1 {
  Snowfall1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum >= 101; } // Jan 1st
  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) { return ((int)( dateNum / 100)); }
 
  /**
   * Produces a list of reports (MaxInchReport) indicating the greatest snowfall reading for each day in that month.
   * @param sensorData
   * @param month
   * @return a list of reports with the greatest snowfall reading for each day of the given month
   */
	public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> sensorData, int month) {
		if (sensorData.size() == 0)
			return null;
		LinkedList<MaxInchReport> report = new LinkedList<MaxInchReport>();
		LinkedList<Double> justMax = JustMax(sensorData, month);
		LinkedList<Double> JustDays = JustDays(sensorData, month);
		for (int i = 0; i < JustDays.size(); i++)
		{
			report.add(new MaxInchReport(JustDays.get(i),justMax.get(i)));
		}
		return report;
	}
	
	/**
	 * Gets the maximums from the list from sensorData in a given month for each day
	 * @param sensorData
	 * @param month
	 * @return List containing maximums from the given month
	 */
	public LinkedList<Double> JustMax(LinkedList<Double> sensorData, int month){
		LinkedList<Double> justMax = new LinkedList<Double>();
		for (int i = 0; i < sensorData.size()-1; i++)
		{
			if ((sensorData.get(i)>=month*100)&&(sensorData.get(i)<(1+month)*100)) {
				int max = i;
				for (int x = i+1; (sensorData.get(x)<100)&&(x < sensorData.size()-1); x++) {
					if ((sensorData.get(x)>0)&&((sensorData.get(max) < sensorData.get(x))))
					{
					max = x;
					}
					justMax.add(sensorData.get(max));
				}
			}
		}
		return justMax;
	}
	
	/**
	 * Gets the dates from the given month
	 * @param sensorData
	 * @param month
	 * @return a list with the dates from the given month
	 */
	public LinkedList<Double> JustDays(LinkedList<Double> sensorData, int month){
		LinkedList<Double> JustDays = new LinkedList<Double>();
		for (int i = 0; i < sensorData.size(); i++)
		{
			if ((sensorData.get(i)>=month*100)&&(sensorData.get(i)<(1+month)*100)) {
				JustDays.add((sensorData.get(i)));
				
			}
		}
		return JustDays;
	}
}  

