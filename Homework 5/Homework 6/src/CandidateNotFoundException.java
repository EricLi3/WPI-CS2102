/**
 * Exception that is thrown when an indicated candidate is not present in the
 * ballot
 */

public class CandidateNotFoundException extends Exception {
	private String candidate;

	CandidateNotFoundException(String candidate) {
		this.candidate = candidate;
	}

	public String getName() {
		return this.candidate;
	}

}
