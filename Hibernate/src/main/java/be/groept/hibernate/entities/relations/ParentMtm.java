package be.groept.hibernate.entities.relations;

import java.util.ArrayList;
import java.util.List;

public class ParentMtm {

	private Long id;
	private String parentName;
	private List<ChildMtmDetail> childDetails = new ArrayList<ChildMtmDetail>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<ChildMtmDetail> getChildDetails() {
		return childDetails;
	}

	public void setChildDetails(List<ChildMtmDetail> childDetails) {
		this.childDetails = childDetails;
	}
}
