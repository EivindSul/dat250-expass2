package dat250.exp2;

import java.util.Date;

public class Vote {
	private Date publishedAt;
	private VoteOption option;

	public Vote(){}

	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	public VoteOption getOption() {
		return option;
	}
	public void setOption(VoteOption option) {
		this.option = option;
	}
}

