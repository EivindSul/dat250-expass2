package dat250.exp2;

public class VoteOption {
	private String caption;
	private int presentationOrder;

	public VoteOption(String caption){
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public int getPresentationOrder() {
		return presentationOrder;
	}

	public void setPresentationOrder(int presentationOrder) {
		this.presentationOrder = presentationOrder;
	}
}
