package be.groept.hibernate.entities.relations;

public class ChildOtm {

	private Long id;
	private String childName;
	private ParentOtm parent;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ParentOtm getParent() {
		return parent;
	}

	public void setParent(ParentOtm parent) {
		this.parent = parent;
	}

}
