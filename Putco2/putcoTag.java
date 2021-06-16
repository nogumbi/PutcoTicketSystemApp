package putcoTicketingSystem;

public class putcoTag {

	private String userName;
	private String endPoint;
	private String startPoint;
	private String tagTerm;
	public putcoTag(String userName,String endPoint, String startPoint, String tagTerm) {
		super();
		this.userName = userName;
		this.endPoint = endPoint;
		this.startPoint = startPoint;
		this.tagTerm = tagTerm;

	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endPoint == null) ? 0 : endPoint.hashCode());
		result = prime * result + ((startPoint == null) ? 0 : startPoint.hashCode());
		result = prime * result + ((tagTerm == null) ? 0 : tagTerm.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		putcoTag other = (putcoTag) obj;
		if (endPoint == null) {
			if (other.endPoint != null)
				return false;
		} else if (!endPoint.equals(other.endPoint))
			return false;
		if (startPoint == null) {
			if (other.startPoint != null)
				return false;
		} else if (!startPoint.equals(other.startPoint))
			return false;
		if (tagTerm == null) {
			if (other.tagTerm != null)
				return false;
		} else if (!tagTerm.equals(other.tagTerm))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\n"
				+ "username :" + userName +"\n"
				+ "end point :" + endPoint +"\n"
				+ "start point :" + startPoint +"\n"
				+ "tag term :" + tagTerm +"\n";	
	}
	public void printRoutes() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
}
