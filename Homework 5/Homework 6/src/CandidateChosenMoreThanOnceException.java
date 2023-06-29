/**
 * Exception thrown when voting for a candidate more than once in a single form
 */

public class CandidateChosenMoreThanOnceException extends Exception {
	private String candidate;

	CandidateChosenMoreThanOnceException(String candidate) {
		this.candidate = candidate;
	}

	public String getName() {
		return this.candidate;
	}
}
