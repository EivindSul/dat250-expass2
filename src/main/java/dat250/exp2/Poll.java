package dat250.exp2;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Poll {
	private Integer id;
	private String owner;
	private Date publishedAt;
	private Date validUntil;
	private String question;
	private List<VoteOption> options;
	private boolean isPrivate;
	private int maxVotes;

	private HashMap<String, Vote> votes;	

	public Poll(){
		votes = new HashMap<String, Vote>();	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<VoteOption> getOptions() {
		return options;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public int getMaxVotes() {
		return maxVotes;
	}

	public void setMaxVotes(int maxVotes) {
		this.maxVotes = maxVotes;
	}

	public void setOptions(List<VoteOption> options) {
		this.options = options;
	}

	public Collection<Vote> getVotes() {
		return votes.values();
	}

	public boolean addVote(Vote vote){

		Date voteTime = vote.getPublishedAt();

		if (voteTime.before(this.getPublishedAt())){
			System.out.println("Vote is too early, invalid!");
			return false;
		}

		if (voteTime.after(this.getValidUntil())){
			System.out.println("Vote is too late, invalid!");
			return false;
		}

		votes.put(vote.getUser(), vote);
		return true;
	}

	public void setVotes(HashMap<String, Vote> votes) {
		this.votes = votes;
	}

	
}

