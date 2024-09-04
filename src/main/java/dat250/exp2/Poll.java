package dat250.exp2;

import java.util.ArrayList;
import java.util.Date;

public class Poll {
	public Integer id;
	public Date publishedAt;
	public Date validUntil;
	String question;
	// VoteOption[] options;
	ArrayList<VoteOption> options;
	boolean _private;
	int maxVotes;
}

