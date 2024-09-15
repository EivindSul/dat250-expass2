package dat250.exp2;

public class VoteOption {
	private String caption;
	
	// This attribute was specified in the
	// task description, but I chose to 
	// omit it for now to simplify development.
	
	// private int presentationOrder;

	public VoteOption(){}

	public VoteOption(String caption){
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
