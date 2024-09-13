package dat250.exp2;

import java.time.LocalDateTime;

public class Vote {
	private String user;
	private Integer pollId;
	private VoteOption option;

	private LocalDateTime publishedAt;

	public Vote(){
		this.publishedAt = LocalDateTime.now();
	}

	public Integer getPollId() {
		return pollId;
	}

	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public VoteOption getOption() {
		return option;
	}

	public void setOption(VoteOption option) {
		this.option = option;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}

