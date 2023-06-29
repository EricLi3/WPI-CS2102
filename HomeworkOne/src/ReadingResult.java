
 public class ReadingResult implements IChallenge{
    int goal;
	BooksRead fictionNumber;
	BooksRead nonFictionNumber;
	
	
	ReadingResult(Integer goal, BooksRead fictionNumber, BooksRead nonFictionNumber) {
		this.goal = goal;
		this.fictionNumber = fictionNumber;
		this.nonFictionNumber = nonFictionNumber;
	}
	public double averagePerDay() {
		return ((this.fictionNumber.booksRead + 
				this.nonFictionNumber.booksRead) / 31);
	}
	
	public double differenceFromGoal() {
		
		if((this.goal - averagePerDay()) < 0) {
			return 0;
		}
		else {
			
		return (this.goal - averagePerDay());
		}	
	}
		
}
