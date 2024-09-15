package dat250.exp2;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Poll {
	private Integer id;
	private String owner;
	private String question;
	private List<VoteOption> options;
	
	// These attributes are specified in the
	// task description, but I chose to 
	// omit them for now to simplify development.
	
	// private boolean isPrivate;
	// private int maxVotes;
	
	// Attributes not set by request.
	private LocalDateTime publishedAt;
	private LocalDateTime validUntil;
	private HashMap<String, Vote> votes;	

	public Poll(){
		votes = new HashMap<String, Vote>();	
		publishedAt = LocalDateTime.now();
		validUntil = LocalDateTime.now().plusDays(1);
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

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public LocalDateTime getValidUntil() {
		return validUntil;
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
	public void setOptions(List<VoteOption> options) {
		this.options = options;
	}

	public Collection<Vote> getVotes() {
		return votes.values();
	}

	public boolean addVote(Vote vote){

		LocalDateTime voteTime = vote.getPublishedAt();

		if (voteTime.isBefore(this.getPublishedAt())){
			System.out.println("Vote is too early, invalid!");
			return false;
		}

		if (voteTime.isAfter(this.getValidUntil())){
			System.out.println("Vote is too late, invalid!");
			return false;
		}

		votes.put(vote.getUser(), vote);
		return true;
	}
}

