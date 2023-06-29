
/**
 * 
 */
public class Survey {
	private int rank;
	private int downloadsSince;
	
	public Survey(int rank, int downloadsSince) {
		this.rank = rank; // int >= 1
		this.downloadsSince = downloadsSince; // int >= 0
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int getDownloadsSince() {
		return this.downloadsSince;
	}
	
}
