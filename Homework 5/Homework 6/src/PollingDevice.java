import java.util.Scanner;

/**
 * Class that acts as the voting machine which the user interfaces with
 */

public class PollingDevice {

	VotingData myElection = new VotingData();
	Scanner keyboard = new Scanner(System.in);

	/**
	 * Prints what the candidates are as part of the user interface.
	 */
	public void printBallot() {
		System.out.println("The candidates are ");
		for (String s : myElection.getBallot()) {
			System.out.println(s);
		}
	}

	/**
	 * Functions as the user interface for voting, takes keyboard input for the first, second and third choice votes
	 */
	public void screen() {
		this.printBallot();
		System.out.println("Who do you want to vote for first?");
		String firstVote = keyboard.next();

		System.out.println("Who do you want to vote for second?");
		String secondVote = keyboard.next();

		System.out.println("Who do you want to vote for third?");
		String thirdVote = keyboard.next();

		try {
			myElection.submitVote(firstVote, secondVote, thirdVote);
		} 
		catch (CandidateNotFoundException e) {
			System.out.println("Candidate" + e.getName() + "is not currently in the ballot. "
					+ "Would you like to add them to the ballot? <Y/N> ");

			String yesOrNo = keyboard.next();

			if (yesOrNo.equalsIgnoreCase("Y")) {
				addWriteIn(e.getName());
			} else {
				System.out.println("Please try voting again.");
			}
			this.screen();
			return;
		}

		catch (CandidateChosenMoreThanOnceException e) {
			System.out.println("Candidate" + e.getName() + "has been voted for more than one time. "
					+ "Please vote again with unique candidates.");
			this.screen();
			return;
		}

		System.out.println("You voted for:");
		System.out.println("First: " + firstVote);
		System.out.println("Second: " + secondVote);
		System.out.println("Third: " + thirdVote);

	}

	/**
	 * Used when a candidate not in the ballot is voted for, adds them to ballot if not in there
	 * @param name
	 */
	private void addWriteIn(String name) {
		try {
			myElection.nominateCandidate(name);
		} 
		catch (RedundantCandidateException e) {
			System.out.println("Candidate " + e.getRedundantName() + " is already in the ballot.");
		}
		System.out.println("Candidate " + name + " has been successfully added to the ballot.");

	}

}
