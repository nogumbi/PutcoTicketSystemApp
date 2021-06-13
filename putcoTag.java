package putcoTicketingSystem;

public class putcoTag {

	private String endPoint;
	private String startPoint;
	private String tagTerm;
	public putcoTag(String endPoint, String startPoint, String tagTerm) {
		super();
		this.endPoint = endPoint;
		this.startPoint = startPoint;
		this.tagTerm = tagTerm;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getTagTerm() {
		return tagTerm;
	}
	public void setTagTerm(String tagTerm) {
		this.tagTerm = tagTerm;
	}
	@Override
	public String toString() {
		return "\n"
				+ "endPoint :" + endPoint +"\n"
				+ "startPoint :" + startPoint +"\n"
				+ "tagTerm :" + tagTerm +"\n";
	}
}
