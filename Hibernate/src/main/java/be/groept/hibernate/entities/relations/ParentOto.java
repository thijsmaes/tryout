package be.groept.hibernate.entities.relations;

public class ParentOto {

	private Long id;

	private ChildOto child;
	private String parentName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChildOto getChild() {
		return child;
	}

	public void setChild(ChildOto child) {
		this.child = child;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
