package dat250.exp2;

import java.util.HashMap;

public class DomainManager {
	private HashMap<String, User> users;	
	private HashMap<Integer, Poll> polls;	
	private HashMap<User, Invite> invites;	

	public HashMap<String, User> getUsers(){
		return this.users;
	}

	public HashMap<String, Poll> getPolls(){
		return this.polls;
	}

	public HashMap<User, Invite> getInvites(){
		return this.invites;
	}

	public void addUser(User user){
		users.put(user.username, user);
	}

	public void addPoll(Poll poll){
		polls.put(poll.id, poll);
	}
	
}
