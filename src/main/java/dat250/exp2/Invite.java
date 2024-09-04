package dat250.exp2;

public class Invite {
	User fromUser;
	User toUser;
	Poll poll;

	public Invite(User from, User to, Poll poll){
		this.fromUser = from;
		this.toUser = to;
		this.poll = poll;
	}
}
