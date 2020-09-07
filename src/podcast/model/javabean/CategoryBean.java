package podcast.model.javabean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Category")
public class CategoryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int categoryId;
	private String categoryName;

	// 無參數建構子
	public CategoryBean() {
	}

	// 帶參數建構子
	public CategoryBean(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	@Id
	@Column(name = "CATEGORYID")
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CATEGORYNAME")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
