/**
 * Exception thrown when the name of a candidate already in the ballot is
 * entered again
 */

public class RedundantCandidateException extends Exception {
	private String redundantName;

	RedundantCandidateException(String name) {
		this.redundantName = name;
	}

	public String getRedundantName() {
		return redundantName;
	}
}
