package com.qf.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "app_version")
public class AppVersion  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "app_id")
	@NotNull(message = "appId不能为空！")
	private Integer appId;

	@Column(name = "version_no")
	@NotBlank(message = "版本号不能为空！")
	private String versionNo;

	@Column(name = "version_info")
	//@NotBlank(message = "版本信息不能为空！")
	private String versionInfo;

	@Column(name = "publish_status")
	private Integer publishStatus;

	@Column(name = "download_link")
	@NotBlank(message = "文件不能为空！")
	private String downloadLink;

	@Column(name = "version_size")
	@NotBlank(message = "版本大小不能为空！")
	private String versionSize;

	@Column(name = "apk_file_name")
	private String apkFileName;

	private java.util.Date created;

	private java.util.Date updated;

	@Transient
	private String softwareName;

	@Transient
	private String publishStatusName;

}
