package dat250.exp2;

import java.util.HashMap;

public interface PollRepository {
	
	public HashMap<String, User> getUsers();
	public HashMap<Integer, Poll> getPolls();
	public HashMap<User, Invite> getInvites();

	public void addUser(User user);
	public void addPoll(Poll poll);
	public void addInvite(Invite invite);
}
