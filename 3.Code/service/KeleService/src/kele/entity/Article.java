package kele.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Article extends BaseEntity {

	private String title;
	private String author;
	private String summary;
	@Column(columnDefinition = "TEXT", nullable = true)
	private String content;
	private String keywords;
	private String image;
	private String hits;// 点击数
	private boolean isTop;
	private boolean isPublication;
	private boolean isRecommand;

//	@ManyToOne(targetEntity = Category.class)
//	@JoinColumn(name = "categoryId", insertable = false, updatable = false, nullable = false)
	//private Category category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getPicture() {
		return image;
	}

	public void setPicture(String picture) {
		this.image = picture;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public boolean isPublication() {
		return isPublication;
	}

	public void setPublication(boolean isPublication) {
		this.isPublication = isPublication;
	}

	public boolean isRecommand() {
		return isRecommand;
	}

	public void setRecommand(boolean isRecommand) {
		this.isRecommand = isRecommand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}


}
