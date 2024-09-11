package dat250.exp2;

import java.util.Collection;
import java.util.HashMap;

public interface PollRepository {
	
	public HashMap<String, User> getUsers();
	public HashMap<Integer, Poll> getPolls();
	public HashMap<User, Invite> getInvites();

	public Collection<User> getAllUsers();
	public void addUser(User user);
	public void removeUser(String username);
	public Collection<Poll> getAllPolls();
	public void addPoll(Poll poll);
	public Collection<Vote> getVotes(Integer pollId);
	public void addVote(Vote vote);
	public void removePoll(Integer pollId);
	public void addInvite(Invite invite);
}
