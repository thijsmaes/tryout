package be.groept.hibernate.entities.relations;

public class ChildMtmDetail {

	private ParentMtm parentMtm;
	private ChildMtm childMtm;
	private String amount;

	public ParentMtm getParentMtm() {
		return parentMtm;
	}

	public void setParentMtm(ParentMtm parentMtm) {
		this.parentMtm = parentMtm;
	}

	public ChildMtm getChildMtm() {
		return childMtm;
	}

	public void setChildMtm(ChildMtm childMtm) {
		this.childMtm = childMtm;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
