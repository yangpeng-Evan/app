package com.qf.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "filter_chain")
public class FilterChain  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String url;

	private String filter;

	private Integer ordered;

	private java.util.Date created;

	private java.util.Date updated;

}
