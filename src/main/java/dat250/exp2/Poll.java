package dat250.exp2;

import java.util.ArrayList;
import java.util.Date;

public class Poll {
	String question;
	Date publishedAt;
	Date validUntil;
	// VoteOption[] options;
	ArrayList<VoteOption> options;
	boolean _private;
	int maxVotes;
}

