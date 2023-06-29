import static org.junit.Assert.*;

import org.junit.Test;

// Eric Li and Daniel Zhang
public class Examples {

	VotingData setup1() {

		VotingData vd = new VotingData();

		// put candidates on the ballot
		try {
			vd.nominateCandidate("gompei");
			vd.nominateCandidate("husky");
			vd.nominateCandidate("ziggy");
		} catch (Exception e) {
		}

		// cast votes
		try {
			vd.submitVote("gompei", "husky", "ziggy");
			vd.submitVote("gompei", "ziggy", "husky");
			vd.submitVote("husky", "gompei", "ziggy");

		} catch (Exception e) {
		}
		return (vd);
	}

	//////////////////////////////////////
	VotingData TieScenario() {
		VotingData VD = new VotingData();
		// put candidates on the ballot
		try {
			VD.nominateCandidate("gompei");
			VD.nominateCandidate("husky");
			VD.nominateCandidate("ziggy");
		} catch (Exception e) {
		}
		// cast votes
		try {
			VD.submitVote("gompei", "husky", "ziggy");
			VD.submitVote("ziggy", "gompei", "husky");
			VD.submitVote("husky", "ziggy", "gompei");
		} catch (Exception e) {
		}
		return (VD);
	}
	//////////////////////////////////////

	VotingData ballotHasBill() {
		VotingData VD = new VotingData();
		// put candidates on the ballot
		try {
			VD.nominateCandidate("gompei");
			VD.nominateCandidate("husky");
			VD.nominateCandidate("ziggy");
			VD.nominateCandidate("Bill");
		} catch (Exception e) {
		}
		// cast votes
		try {
			VD.submitVote("Bill", "husky", "ziggy");
			VD.submitVote("Bill", "gompei", "husky");
			VD.submitVote("Bill", "ziggy", "gompei");
		} catch (Exception e) {
		}
		return (VD);
	}

	//////////////////////////////////// TESTS/////////////////////////////////////
	// Tests for mostFirstWinner method
	@Test
	public void testMostFirstWinner() {
		assertEquals("gompei", this.setup1().pickWinnerMostFirstChoice());
	}

	@Test
	public void testMostFirstWinnerTie() {
		assertEquals("*Requires Runoff Poll*", this.TieScenario().pickWinnerMostFirstChoice());
	}

	// Tests for pickWinnerMostAgreeable method
	@Test
	public void testpickWinnerMostAgreeable() {
		assertEquals("gompei", this.setup1().pickWinnerMostAgreeable());
	}

	@Test
	public void testpickWinnerMostAgreeableTie() {
		assertEquals("gompei", this.TieScenario().pickWinnerMostAgreeable());
	}

	@Test
	public void testpickWinnerMostAgreeableBill() {
		assertEquals("Bill", this.ballotHasBill().pickWinnerMostAgreeable());
	}

	// Tests for the exceptions for the submitVote method.
	@Test(expected = CandidateNotFoundException.class)
	public void testUnknownCandidate() throws CandidateNotFoundException, CandidateChosenMoreThanOnceException {
		setup1().submitVote("gompei", "steve", "husky");
	}

	@Test(expected = CandidateChosenMoreThanOnceException.class)
	public void testDuplicateVotes() throws CandidateNotFoundException, CandidateChosenMoreThanOnceException {
		setup1().submitVote("gompei", "gompei", "husky");
	}

	// Tests for the nominateCandidate method.
	@Test(expected = RedundantCandidateException.class)
	public void testRedundantCandidate() throws RedundantCandidateException {
		setup1().nominateCandidate("gompei");
	}

	@Test
	public void testNominateCandidate() throws RedundantCandidateException {
		setup1().nominateCandidate("bill");
		assertFalse(setup1().equals(ballotHasBill()));
	}

}
