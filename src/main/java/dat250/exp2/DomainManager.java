package dat250.exp2;

import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class DomainManager implements PollRepository {
	private HashMap<String, User> users;	
	private HashMap<Integer, Poll> polls;	
	private HashMap<User, Invite> invites;	

	public DomainManager() {
		this.users = new HashMap<>();
		this.polls = new HashMap<>();
		this.invites = new HashMap<>();
		User initUser = new User();
		initUser.setUsername("Eivind");
		initUser.setPassword("BestePassord");
		initUser.setEmail("beste.epost@mail.com");
		this.addUser(initUser);
	}

	@Override
	public HashMap<String, User> getUsers(){
		return this.users;
	}

	@Override
	public HashMap<Integer, Poll> getPolls(){
		return this.polls;
	}

	@Override
	public HashMap<User, Invite> getInvites(){
		return this.invites;
	}

	@Override
	public void addUser(User user){
		users.put(user.getUsername(), user);
	}

	@Override
	public void addPoll(Poll poll){
		polls.put(poll.getId(), poll);
	}

	@Override
	public void addInvite(Invite invite) {
		throw new UnsupportedOperationException("Unimplemented method 'addInvite'");
	}
	
}
