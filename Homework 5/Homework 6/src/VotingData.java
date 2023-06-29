import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
/**
 * Class which holds all voting data and related handling functions
 */

public class VotingData {

	private LinkedList<String> ballot = new LinkedList<String>();

	private HashMap<String, Integer> firstVotes = new HashMap<String, Integer>(); // Votes for first place for a
																					// candidate
	private HashMap<String, Integer> secondVotes = new HashMap<String, Integer>(); // Votes for second place for a
																					// candidate
	private HashMap<String, Integer> thirdVotes = new HashMap<String, Integer>(); // Votes for third place for a
																					// candidate
	Scanner keyboard = new Scanner(System.in);

	VotingData() {
	}

	/**
	 * Getter for the ballot.
	 * 
	 * @return LinkedList of type string contains the candidates in the ballot
	 */
	public LinkedList<String> getBallot() {
		return ballot;
	}

	/**
	 * Adds a single voter's choices for first, second, and third choice for
	 * candidates votes to each candidate.
	 * 
	 * @param firstChoice
	 * @param secondChoice
	 * @param thirdChoice
	 */
	public void submitVote(String firstChoice, String secondChoice, String thirdChoice)
			throws CandidateNotFoundException, CandidateChosenMoreThanOnceException {

		if (!(firstVotes.containsKey(firstChoice))) {
			throw new CandidateNotFoundException(firstChoice);
		}
		if (!(secondVotes.containsKey(secondChoice))) {
			throw new CandidateNotFoundException(secondChoice);
		}
		if (!(thirdVotes.containsKey(thirdChoice))) {
			throw new CandidateNotFoundException(thirdChoice);
		}

		if (firstChoice.equals(secondChoice) || firstChoice.equals(thirdChoice)) {
			throw new CandidateChosenMoreThanOnceException(firstChoice);
		}
		if (secondChoice.equals(firstChoice) || secondChoice.equals(thirdChoice)) {
			throw new CandidateChosenMoreThanOnceException(secondChoice);
		}
		if (thirdChoice.equals(firstChoice) || thirdChoice.equals(secondChoice)) {
			throw new CandidateChosenMoreThanOnceException(thirdChoice);
		}

		firstVotes.replace(firstChoice, firstVotes.get(firstChoice) + 1);
		secondVotes.replace(secondChoice, secondVotes.get(secondChoice) + 1);
		thirdVotes.replace(thirdChoice, thirdVotes.get(thirdChoice) + 1);
	}

	/**
	 * A method that takes one string (for the name of a candidate) and adds the
	 * candidate to the ballot, returning void.
	 * 
	 * @param name
	 * @throws RedundantCandidateException
	 */

	public void nominateCandidate(String name) throws RedundantCandidateException {
		if (ballot.contains(name)) {
			throw new RedundantCandidateException(name);
		}
		ballot.add(name);
		firstVotes.put(name, 0);
		secondVotes.put(name, 0);
		thirdVotes.put(name, 0);
	}

	/**
	 * Checks if a candidate has more than 50% of the first place votes.
	 * 
	 * @return the candidate if said candidate has more than 50% of the first place
	 *         votes.
	 */
	public String pickWinnerMostFirstChoice() {
		int totalVotes = 0;
		int maxVotes = 0;
		String currWinner = "N/A";

		for (String candidate : firstVotes.keySet()) {
			int currVotes = firstVotes.get(candidate);
			totalVotes += currVotes;
			if (currVotes > maxVotes) {
				maxVotes = currVotes;
				currWinner = candidate;
			}
		}

		if (maxVotes > totalVotes / 2.0) {
			return currWinner;
		} else {

			return "*Requires Runoff Poll*";
		}
	}

	/**
	 * Finds the winner which is the candidate with the most points
	 * 
	 * @return the Candidate which won. When there is a tie, return the first
	 *         candidate.
	 */
	public String pickWinnerMostAgreeable() {
		int mostPoints = 0;
		int points = 0;
		String winner = "N/A";

		// Calculates the points of a candidate
		for (String candidate : ballot) {
			if ((firstVotes.get(candidate) > secondVotes.get(candidate))
					|| firstVotes.get(candidate) > thirdVotes.get(candidate)) {
				points = firstVotes.get(candidate);
			} else if (secondVotes.get(candidate) > firstVotes.get(candidate)
					|| secondVotes.get(candidate) > thirdVotes.get(candidate)) {
				points = secondVotes.get(candidate);
			} else if (thirdVotes.get(candidate) > firstVotes.get(candidate)
					|| thirdVotes.get(candidate) > secondVotes.get(candidate)) {
				points = thirdVotes.get(candidate);
			} else if (firstVotes.get(candidate) == secondVotes.get(candidate)
					|| secondVotes.get(candidate) == thirdVotes.get(candidate)
					|| thirdVotes.get(candidate) == firstVotes.get(candidate)) {
				points = firstVotes.get(candidate);
			}

			if (points > mostPoints) {
				mostPoints = points;
				winner = candidate;
			}
		}
		return winner;

	}

}