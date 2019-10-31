package com.qf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "app_category")
public class AppCategory  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "parent_id")
	@JsonIgnore
	private Integer parentId;

	@Column(name = "is_parent")
	@JsonIgnore
	private String isParent;

	@JsonIgnore
	private java.util.Date created;

	@JsonIgnore
	private java.util.Date updated;

}
