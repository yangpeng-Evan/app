package com.qf.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "app_info")
public class AppInfo  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "software_name")
	@NotBlank(message = "软件名称不能为空！")
	private String softwareName;

	@Column(name = "apk_name")
	@NotBlank(message = "apk名称不能为空！")
	private String apkName;

	@Column(name = "support_rom")
	@NotBlank(message = "支持ROM不能为空！")
	private String supportRom;

	@Column(name = "interface_language")
	@NotBlank(message = "界面语言不能为空！")
	private String interfaceLanguage;

	@Column(name = "software_size")
	@NotBlank(message = "软件大小不能为空！")
	private String softwareSize;

	@Column(name = "app_info")
	private String appInfo;

	@Column(name = "app_status")
	private Integer appStatus;

	@Column(name = "on_sale_date")
	private java.util.Date onSaleDate;

	@Column(name = "off_sale_date")
	private java.util.Date offSaleDate;

	@Column(name = "flatform_id")
	@NotNull(message = "软件所属平台不能为空！")
	private Integer flatformId;

	private Long downloads;

	@Column(name = "category_level1")
	@NotNull(message = "一级分类不能为空！")
	private Integer categoryLevel1;

	@Column(name = "category_level2")
	@NotNull(message = "二级分类不能为空！")
	private Integer categoryLevel2;

	@Column(name = "category_level3")
	@NotNull(message = "三级分类不能为空！")
	private Integer categoryLevel3;

	@Column(name = "dev_id")
	private Integer devId;

	@Column(name = "pic_path")
//	@NotBlank(message = "图片不能为空！")
	private String picPath;

	@Column(name = "version_id")
	private Integer versionId;

	private java.util.Date created;

	private java.util.Date updated;

}
