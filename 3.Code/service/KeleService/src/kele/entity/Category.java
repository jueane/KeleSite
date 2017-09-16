package kele.entity;

import javax.persistence.Entity;

@Entity
public class Category extends BaseEntity {

	private int parentId;
	private String flag;
	private String name;
	private String display;

	// @OneToMany()
	// @JoinColumn(name="ParentId",
	// referencedColumnName="Id",insertable=false,updatable=false)
	// private List<Category> children;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}