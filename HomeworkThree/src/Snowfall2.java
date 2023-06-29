import java.util.LinkedList;

class Snowfall2 {
  Snowfall2(){}

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
		for (int day = 0; day < 31; day++) {
			for (int i = 0; i < sensorData.size()-1; i++)
			{
				if ((sensorData.get(i) == (month*100+day)))
					{
					double max = -1;
					for (int x = i+1; (sensorData.get(x)<100)&&(x < sensorData.size()-1); x++) 
							{
								if ((sensorData.get(x)>0)&&(max < sensorData.get(x)))
									{
										max = sensorData.get(x);
									}
							}
				if (max!=-1)
					{
						report.add(new MaxInchReport((month*100+day),max));
					}
					}
			}
	}
		return report;
	}
	
}