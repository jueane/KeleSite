package kele.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Message extends BaseEntity {
	private int categoryId;
	private String title;
	@Column(length = 1024)
	private String content;
	private String author;
	private String email;

	// @OneToMany()
	// @JoinColumn(name="ParentId",
	// referencedColumnName="Id",insertable=false,updatable=false)
	// private List<Category> children;

	@OneToMany
	@JoinColumn(name = "messageId")
	private List<Reply> replyList;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

}
