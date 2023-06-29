
public class DataBSTRadioStation2 implements IRatings {
	int data;
	IBinTree left;
	IBinTree right;

	@Override

	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	

	@Override
	public int bestRankForMonth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalDownloadsForMonth(int month, int year) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(TodaysRatings r) {
		// TODO Auto-generated method stub

	}

}
