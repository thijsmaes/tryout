package be.groept.hibernate.entities.relations;

public class ChildMtm {

	private Long id;

	private String childName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

}
