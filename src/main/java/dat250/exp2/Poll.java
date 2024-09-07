package dat250.exp2;

import java.util.ArrayList;
import java.util.Date;

public class Poll {
	private Integer id;
	private Date publishedAt;
	private Date validUntil;
	private String question;
	// VoteOption[] options;
	private ArrayList<VoteOption> options;
	private boolean isPrivate;
	private int maxVotes;

	public Poll(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ArrayList<VoteOption> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<VoteOption> options) {
		this.options = options;
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

	
}

