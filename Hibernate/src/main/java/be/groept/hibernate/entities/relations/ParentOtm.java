package be.groept.hibernate.entities.relations;

import java.util.ArrayList;
import java.util.List;

public class ParentOtm {

	private Long id;
	private String parentName;

	private List<ChildOtm> childs = new ArrayList<ChildOtm>();

	public List<ChildOtm> getChilds() {
		return childs;
	}

	public void setChilds(List<ChildOtm> childs) {
		this.childs = childs;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
