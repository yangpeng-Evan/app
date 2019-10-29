/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : app

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-29 08:36:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_category`
-- ----------------------------
DROP TABLE IF EXISTS `app_category`;
CREATE TABLE `app_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `category_name` varchar(16) NOT NULL COMMENT '分类的名字',
  `parent_id` bigint(20) NOT NULL COMMENT '分类的父id',
  `is_parent` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否是父节点',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COMMENT='APP分类';

-- ----------------------------
-- Records of app_category
-- ----------------------------
INSERT INTO `app_category` VALUES ('1', '全部应用', '0', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('2', '全部游戏', '0', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('3', '系统工具', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('4', '桌面插件', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('5', '主题美化', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('6', '社交聊天', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('7', '资讯阅读', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('8', '通讯网络', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('9', '影音娱乐', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('10', '摄影图片 ', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('11', '生活服务', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('12', '实用工具 ', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('13', '文档商务', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('14', '金融财经', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('15', '运动健康', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('16', '学习教育 ', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('17', '旅行交通', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('18', '购物', '1', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('19', '休闲游戏', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('20', '益智游戏', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('21', '棋牌游戏', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('22', '体育赛车', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('23', '动作射击', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('24', '掌上网游', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('25', '策略塔防', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('26', '角色扮演', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('27', '模拟经营 ', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('28', '音乐游戏 ', '2', '1', '2016-08-12 18:11:47', '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES ('29', '输入法', '3', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:33');
INSERT INTO `app_category` VALUES ('30', '文件管理', '3', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:34');
INSERT INTO `app_category` VALUES ('31', '清理优化', '3', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:34');
INSERT INTO `app_category` VALUES ('32', '安全防护', '3', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:35');
INSERT INTO `app_category` VALUES ('33', '备份还原', '3', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:35');
INSERT INTO `app_category` VALUES ('34', '辅助加强', '3', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:36');
INSERT INTO `app_category` VALUES ('35', '桌面', '4', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:37');
INSERT INTO `app_category` VALUES ('36', '插件', '4', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:37');
INSERT INTO `app_category` VALUES ('37', '锁屏', '4', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:39');
INSERT INTO `app_category` VALUES ('38', '跳舞', '19', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:40');
INSERT INTO `app_category` VALUES ('39', '涂鸦', '19', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:08');
INSERT INTO `app_category` VALUES ('40', '虐心', '19', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:07');
INSERT INTO `app_category` VALUES ('41', '冒险', '19', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:06');
INSERT INTO `app_category` VALUES ('42', '消除', '20', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:05');
INSERT INTO `app_category` VALUES ('43', '解谜', '20', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:04');
INSERT INTO `app_category` VALUES ('44', '物理', '20', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:04');
INSERT INTO `app_category` VALUES ('45', '麻将', '21', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:03');
INSERT INTO `app_category` VALUES ('46', '扑克', '21', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:02');
INSERT INTO `app_category` VALUES ('47', '赛车', '22', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:01');
INSERT INTO `app_category` VALUES ('48', '足球', '22', '0', '2016-08-12 18:11:47', '2018-11-29 14:15:00');
INSERT INTO `app_category` VALUES ('49', '篮球', '22', '0', '2016-08-12 18:11:47', '2018-11-29 14:14:58');
INSERT INTO `app_category` VALUES ('50', '摩托', '22', '0', '2016-08-12 18:11:47', '2018-11-29 14:14:57');
INSERT INTO `app_category` VALUES ('51', '落地成盒', '23', '0', '2018-10-16 17:19:55', '2018-11-29 14:14:56');
INSERT INTO `app_category` VALUES ('52', '北京购物网', '18', '0', '2018-11-29 14:58:15', '2018-11-29 15:00:03');
INSERT INTO `app_category` VALUES ('53', '河北购物', '18', '0', '2018-11-29 14:59:28', '2018-11-29 15:00:08');
INSERT INTO `app_category` VALUES ('54', '劲乐团', '28', '0', '2019-08-03 17:52:00', '2019-08-03 17:52:22');
INSERT INTO `app_category` VALUES ('56', '劲舞团', '28', '0', '2019-08-07 15:49:20', '2019-08-07 15:49:20');

-- ----------------------------
-- Table structure for `app_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `software_name` varchar(32) NOT NULL COMMENT '软件名称',
  `apk_name` varchar(128) NOT NULL COMMENT 'apk安装包的名字',
  `support_rom` varchar(16) NOT NULL COMMENT '支持的ROM版本',
  `interface_language` varchar(16) NOT NULL COMMENT '界面语言',
  `software_size` varchar(8) NOT NULL COMMENT '软件大小(单位:M)',
  `app_info` text NOT NULL COMMENT '软件简介',
  `app_status` bigint(20) NOT NULL COMMENT 'APP的状态:待审核 , 审核通过 , 审核驳回 , 上架 , 下架.',
  `on_sale_date` date DEFAULT NULL COMMENT '上架时间',
  `off_sale_date` date DEFAULT NULL COMMENT '下架时间',
  `flatform_id` bigint(20) NOT NULL COMMENT 'APP的所属平台:手机 , 平板 , 通用',
  `downloads` bigint(20) NOT NULL DEFAULT '0' COMMENT '下载次数',
  `category_level1` bigint(20) NOT NULL COMMENT '一级分类',
  `category_level2` bigint(20) NOT NULL COMMENT '二级分类',
  `category_level3` bigint(20) NOT NULL COMMENT '三级分类',
  `dev_id` bigint(20) NOT NULL COMMENT '录入者,关联dev_user表的主键',
  `pic_path` varchar(256) NOT NULL COMMENT '图片访问路径',
  `version_id` bigint(20) DEFAULT NULL COMMENT '版本id,关联app_version的主键',
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='APP信息表';

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('1', '王者荣耀', 'com.qq.wz', '2.3及更高版本', '简体中文', '1234.00', '王者农药，又称打农药，并不是给农作物打农药的意思，而是代指的一款名为《王者荣耀》的手机游戏，因为农药和荣耀读音相似，最主要是玩这款游戏的玩家上瘾严重，网友就戏称是王者农药。', '4', '2015-10-16', '2018-10-16', '3', '3000', '2', '20', '44', '1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539691481236&di=45b30d0181b10274ac28281edef73f35&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fbafcc0d48642348b1eb7f88d1cd19a04b5e28c7c.jpg', '9', '2018-10-16 17:17:16', '2018-11-01 17:24:42');
INSERT INTO `app_info` VALUES ('2', '绝地求生online', 'com.qq.juediqiusheng', '2.3及更高版本', '简体中文', '2135.00', '《绝地求生》(PUBG) 是一款战术竞技型射击类沙盒游戏。', '4', '2017-10-16', '2018-10-16', '3', '5000', '2', '23', '51', '1', 'https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=2044d97ba16eddc432eabca958b2dd98/78310a55b319ebc499f581078e26cffc1f17169a.jpg', '2', '2018-10-16 17:20:20', '2018-10-18 13:22:15');
INSERT INTO `app_info` VALUES ('3', '地下城与勇士', 'com.qq.dnf', '2.3及更高版本', '简体中文', '12341.00', '该游戏是一款2D卷轴式横版格斗过关网络游戏，大量继承了众多家用机、街机2D格斗游戏的特色。以任务引导角色成长为中心，结合副本、PVP、PVE为辅，与其他网络游戏同样具有装备与等级的改变，并拥有共500多种装备道具。每个人物有8个道具装备位置，在游戏中可以允许最多4个玩家进行组队挑战关卡，同样也可以进行4对4的PK。', '4', '2007-10-16', null, '1', '8000', '2', '19', '43', '1', 'https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=f913ccb809f79052fb124f6c6d9abcaf/c75c10385343fbf26ba61988b07eca8064388f97.jpg', '7', '2018-10-16 17:23:45', '2018-11-01 17:24:50');
INSERT INTO `app_info` VALUES ('4', '搜狗输入法', 'com.sogo.shurufa', '1.5及更高版本', '简体中文', '8456.00', '搜狗输入法是搜狗(Sogou)公司于2006年6月推出的一款汉字输入法工具。 [1] \r\n与传统输入法不同，搜狗输入法是第一款为互联网而生的输入法——它通过搜索引擎技术，将互联网变成了一个巨大的“活”词库。 [2]  网民们不仅仅只是词库的使用者，同时也是词库的生产者。 [2] \r\n搜狗输入法在词库的广度 [3]  、首选词准确度等数据指标上都远远领先于其他输入法。 [3] \r\n作为中国国内主流的汉字拼音输入法之一，搜狗输入法长期占据最高的市场份额，是使用范围及受欢迎程度最高的输入法。 [4] \r\n2009年9月开始，搜狗输入法陆续推出Android、iOS版本，成为智能手机时代最强大的第三方输入法之一。', '4', '2002-10-16', null, '3', '3000', '1', '3', '29', '1', 'https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=dd94200925738bd4d02cba63c0e2ecb3/7dd98d1001e93901261fd2ea70ec54e737d196c0.jpg', '4', '2018-10-16 17:25:29', '2018-10-18 13:22:20');
INSERT INTO `app_info` VALUES ('5', '360安全卫士', 'com.360.www', '2.3及更高版本', '简体中文', '1234.00', '很神奇的安全卫士.特别神奇.', '4', '2001-10-16', null, '3', '2400', '1', '3', '32', '1', 'https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=65fc242ddaa20cf4529df68d17602053/80cb39dbb6fd5266ec689fbea118972bd50736dc.jpg', '5', '2018-10-16 17:28:13', '2018-10-18 13:23:16');
INSERT INTO `app_info` VALUES ('6', '劲乐团U:O2Jam U', 'com.momocorp.o2jamu', '2.3及更高版本', '英文软件', '56.00', '劲乐团U O2Jam U是一款音乐节拍游戏，跟着音乐的节奏点击屏幕即可，就是跳舞机，需要网络支持。\r\n注意：部分机型会卡死在启动界面或fc，结束进程后重新开启游戏就正常了。', '4', null, null, '3', '1000', '2', '19', '38', '1', 'http://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=245055dade2a283457ab3e593adca28f/c8177f3e6709c93d34c64b30953df8dcd00054c4.jpg', '6', '2016-08-22 13:07:11', '2019-08-03 17:47:23');
INSERT INTO `app_info` VALUES ('7', 'LBE安全大师', 'com.lbe.security', '2.2及更高版本', '简体中文', '9.00', '欢迎您使用LBE安全大师，Android平台上首款主动式防御软件，第一款具备实时监控与拦截能力的安全软件。\r\n安全大师基于业界首创的API拦截技术，能够实时监控与拦截系统中的敏感操作，动态拦截来自已知和未知的各种威胁。避免各类吸费软件，广告软件乃至木马病毒窃取您手机内的隐私信息以及可能产生的经济损失。\r\n安全大师同时提供了强大的定制功能与完善的提示机制，您更可以精确控制系统中每一个应用的权限，同时不放过任何一次可疑的操作。对于没有获取root权限的用户，您依旧可以使用我们的流量控制，电话短信防火墙，系统优化清理等功能。', '4', null, null, '1', '2000', '1', '3', '32', '1', 'https://baike.baidu.com/pic/lbe%E5%AE%89%E5%85%A8%E5%A4%A7%E5%B8%88/9330644/0/e61190ef76c6a7efabfdbf98f8faaf51f2de66b0?fr=lemma&ct=single#aid=0&pic=e61190ef76c6a7efabfdbf98f8faaf51f2de66b0', '11', '2016-08-22 13:07:11', '2019-08-03 17:47:23');
INSERT INTO `app_info` VALUES ('8', '应用锁:Smart App Protector', 'com.sp.protector.free', '2.3及更高版本', '简体中文', '3.00', 'Smart App Protector是一款应用锁定程序，可以实现当您打开某个应用时进行密码保护，从而保护用户的隐私问题。', '4', null, null, '1', '5000', '1', '3', '32', '1', 'https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=eb6d7375f703918fc3dc359830544df2/3b292df5e0fe9925347b4dc534a85edf8db1712b.jpg', null, '2016-08-22 13:07:11', '2019-08-03 17:47:30');
INSERT INTO `app_info` VALUES ('9', '谷歌拼音输入法', 'com.google.pinyin', '4.2及更高版本', '简体中文', '16.00', '谷歌拼音输入法是一款专门用于输入中文的输入法，提供了多种方便的输入方式：\r\n- 全键盘拼音支持中文滑行输入和智能纠错\r\n- 9键键盘拼音支持中文滑行输入\r\n- 笔画键盘\r\n- 全屏和半屏手写键盘\r\n- 英文键盘\r\n- 模糊拼音\r\n- 双拼\r\n- 针对各种不同屏幕尺寸优化的UI布局\r\n- 语音输入\r\n不仅支持输入简体中文、繁体中文，还支持标点符号、表情符号、拉丁字符和数字。语音输入法使用基于互联网的语音识别服务，以提供高精度的输入匹配。\r\n\r\n注意：要在你的Android设备上使用该输入法，请在 “设置”→“语言和输入法”中开启。\r\n\r\n如需输入粤语，请下载谷歌粤语输入法\r\nhttps://play.google.com/store/apps/details?id=com.google.android.apps.inputmethod.cantonese\r\n\r\n如需使用注音或者倉頡输入繁体中文，请下载谷歌注音输入法\r\nhttps://play.google.com/store/apps/details?id=com.google.android.apps.inputmethod.zhuyin', '4', null, null, '1', '8200', '1', '3', '29', '1', 'https://baike.baidu.com/pic/%E8%B0%B7%E6%AD%8C%E6%8B%BC%E9%9F%B3%E8%BE%93%E5%85%A5%E6%B3%95/3083105/0/6f061d950a7b020892bb27e06ed9f2d3572cc845?fr=lemma&ct=single#aid=0&pic=6f061d950a7b020892bb27e06ed9f2d3572cc845', null, '2016-08-22 13:07:11', '2019-08-03 17:47:46');
INSERT INTO `app_info` VALUES ('10', 'RE管理器:Root Explorer', 'com.speedsoftware.rootexplorer', '2.3及更高版本', '简体中文', '3.00', 'RootExplorer 需要 ROOT 权限，新建文件夹，查看 / 编辑文件，软件安装，RootExplorer 具备普通文件管理器的各项基本功能，另外还添加了搜索功能，在手机上找东西变得更加方便。此外，RootExplorer 最大的特点在于它能够删除手机中自带的应用程序，如 GOOGLEMAP,CONTACTS,MARKET,GTALK 等等。', '2', null, null, '1', '2340', '1', '3', '30', '1', 'https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=9bb808679682d158af8f51e3e16372bd/8718367adab44aed64c2306db91c8701a08bfbaf.jpg', null, '2016-08-22 13:07:11', '2018-11-22 16:08:34');
INSERT INTO `app_info` VALUES ('11', '关屏锁定:Screen Off and Lock', 'com.katecca.screenofflockdonate', '2.2及更高版本', '简体中文', '3.00', '关屏锁定Screen Off and Lock能实现只需点击一下即可关闭屏幕及锁定手机，支持设定关屏动画及音效 ，不是widget，可以放在任何地方，同时支持通知栏激活或者长按搜索键激活。', '1', null, null, '1', '20', '1', '4', '37', '1', 'https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=9bb808679682d158af8f51e3e16372bd/8718367adab44aed64c2306db91c8701a08bfbaf.jpg', '23', '2016-08-22 13:07:11', '2018-11-27 15:51:30');
INSERT INTO `app_info` VALUES ('12', '沙盘玩具:The Powder Toy', 'com.doodleapps.powdertoy', '2.2及更高版本', '英文软件', '3.00', '沙盘玩具The Powder Toy是一款模拟类游戏。想过自己建造核电站吗？或者自己做一个CPU？你甚至可以创建一个虚拟网络。沙盘玩具可以模拟空气的压力，速度，热，重力和无数的不同物质之间的相互作用，游戏提供各种形态的建材，用以构建复杂的机器或是电子元件，你可以模拟超酷的爆炸或是布线出复杂的机器人。欢迎提交您的作品。', '2', null, null, '3', '2000', '2', '20', '44', '1', 'https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=9bb808679682d158af8f51e3e16372bd/8718367adab44aed64c2306db91c8701a08bfbaf.jpg', null, '2016-08-22 13:07:11', '2019-08-03 16:51:42');
INSERT INTO `app_info` VALUES ('13', '机械世界:Apparatus', 'com.bithack.apparatus', '1.6及更高版本', '英文软件', '11.00', '在机械世界Apparatus游戏中你需要利用木板、钉子、绳索、圆轮等等各种道具搭建从简单到复杂的机械结构，使得小球可以最终滚落到蓝色方框中。可以利用的可不止重力，包括杠杆原理、滑轮等等，尤其是后面的关卡，你需要足够灵活的头脑才能解决问题，可玩性还是非常高的。', '2', null, null, '3', '255', '2', '20', '44', '1', 'https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=9bb808679682d158af8f51e3e16372bd/8718367adab44aed64c2306db91c8701a08bfbaf.jpg', '12', '2016-08-22 13:07:11', '2018-11-22 16:14:53');
INSERT INTO `app_info` VALUES ('14', 'Dont Starve饥荒', 'com.doNotStarvePocket', '4.0.3及更高版本', '英文软件', '11.00', 'Don`t Starve: Pocket Edition移动版将深受超过4百万玩家喜爱的热门PC游戏移植到了安卓平台。现在你可以随时随地进入充满科学和魔法元素的世界，体验原汁原味的荒野生存游戏！\r\n你扮演威尔逊，一位被困住并传送到神秘荒野世界的勇敢无畏的绅士科学家。如果威尔逊希望逃出生天并找到回家的路，他必须充分利用所处的环境及这里的各种生物。\r\n进入一个光怪陆离而未经探索的世界，这里充满了奇怪的生物以及形形色色的危险和意外。收集资源以制作符合你的生存风格的物品和建筑。一路解开这块奇怪大陆上的各种谜团。', '4', null, null, '3', '390', '2', '19', '41', '1', 'https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=9bb808679682d158af8f51e3e16372bd/8718367adab44aed64c2306db91c8701a08bfbaf.jpg', null, '2016-08-22 13:07:11', '2019-08-03 16:47:20');
INSERT INTO `app_info` VALUES ('15', '重力锁屏:Gravity Screen Off Pro', 'com.plexnor.gravityscreenoffpro', '2.2及更高版本', '英文软件', '1.00', '重力锁屏Gravity Screen Off Pro可以让手机在特定的条件下自动开启/关闭屏幕（例如放入口袋、放在桌面上、在传感器前挥手、移动手机等），而且识别度相当准确，你可以在设置中随意设置任意角度，当你把手机按这个角度（或者比这个角度小）放入口袋、桌面上时，屏幕就会自动关闭。日常使用起来节省了不少手动开屏/关屏的时间，这个才是真正的与科技接轨！\r\n功能说明：\r\n* 支持识别手机是否在口袋中，可以自定义在口袋中识别设备放置的角度、方向；\r\n* 支持识别手机是否在桌面上，可以自定义在桌面上识别设备放置的角度；\r\n* 识别设备正面、反面放置；\r\n* 可以是使用距离传感器、重力传感器进行识别；\r\n* 可以通过识别动作（例如挥手、移动手机等）来开启/关闭屏幕）；\r\n* 可以自定识别灵敏度；\r\n* 支持在插入而且后启用传感器来自动开启/关闭屏幕；\r\n* 支持开机自动启用服务；\r\n* 可以在通知栏显示启用/停用服务的快捷方式。', '4', null, null, '1', '300', '1', '4', '23', '1', 'https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=9bb808679682d158af8f51e3e16372bd/8718367adab44aed64c2306db91c8701a08bfbaf.jpg', null, '2016-08-22 13:07:11', '2019-08-06 15:15:08');
INSERT INTO `app_info` VALUES ('16', '武侠乂', 'com.wuxiayi.起码', '安卓 9以上', '中国字', '900', '《武侠乂》由Dreamgame工作室采用虚幻4引擎开发,是一款武侠题材、自由开放、多人在线参与的沙盒游戏,目前游戏正在紧张制作中,计划将于2018年下半年下市。', '4', null, null, '1', '9000', '2', '20', '44', '1', 'http://192.168.37.161/group1/M00/00/00/wKgloVvhWW-EHMV3AAAAAGcc4GU231.jpg', '10', '2018-11-01 16:57:25', '2019-08-06 15:14:31');
INSERT INTO `app_info` VALUES ('17', 'APEX', 'com.apex.zhulinfeng', '安卓 8以上', '简体中文', '866', '这是一款落地成和的游戏!!', '3', null, null, '3', '55555', '2', '23', '51', '1', 'http://192.168.37.161/group1/M00/00/00/wKgloVx-FlKEKlWsAAAAAK6VCDo280.JPG', null, '2019-03-05 14:25:39', '2019-08-03 17:32:46');
INSERT INTO `app_info` VALUES ('20', '饥荒', 'com.jihuang', '安卓 8以上', '简体中文', '123', '打奶牛!!!', '1', null, null, '3', '5555', '2', '19', '41', '1', 'http://192.168.37.161/group1/M00/00/00/wKgloVyAyfuEWt9vAAAAAFJ8GLc648.JPG', null, '2019-03-07 15:36:25', '2019-03-07 15:36:25');
INSERT INTO `app_info` VALUES ('21', '流浪汉', 'com.liulanghan', '安卓 8以上', '简体中文', '5', '这个哥们有点狠~~~', '1', null, null, '3', '999999', '2', '19', '40', '1', 'http://192.168.37.161/group1/M00/00/00/wKgloVyAylyEHSx0AAAAANtib7c698.JPG', null, '2019-03-07 15:38:02', '2019-03-07 15:38:02');
INSERT INTO `app_info` VALUES ('22', 'APEX', 'com.apex', '安卓 8以上', '简体中文', '44', '测试~', '1', null, null, '3', '543', '2', '19', '39', '1', 'http://192.168.37.161/group1/M00/00/00/wKgloVyAy5WEb45UAAAAAFIe4V4759.jpg', null, '2019-03-07 15:43:15', '2019-03-07 15:43:15');
INSERT INTO `app_info` VALUES ('25', '斗鱼直播', 'com.douyu.www', '搜星', '简体中文', '500', '&nbsp;你老婆是乔.....', '3', null, null, '3', '0', '1', '4', '35', '2', 'http://localhost/img/8f09ff8e-0ab8-4681-a4f8-0ea565332f98.jpg', null, '2019-08-05 15:31:08', '2019-08-07 12:09:53');

-- ----------------------------
-- Table structure for `app_version`
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `app_id` bigint(20) NOT NULL COMMENT '对应APP的主键',
  `version_no` varchar(32) NOT NULL COMMENT '版本号',
  `version_info` text NOT NULL COMMENT '版本信息',
  `publish_status` bigint(20) NOT NULL COMMENT '发布状态',
  `download_link` varchar(256) NOT NULL COMMENT 'apk安装包的下载链接.',
  `version_size` varchar(8) NOT NULL COMMENT '版本大小',
  `apk_file_name` varchar(64) NOT NULL COMMENT '当前版本APK文件名',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COMMENT='APP版本';

-- ----------------------------
-- Records of app_version
-- ----------------------------
INSERT INTO `app_version` VALUES ('1', '1', 'S1', '英雄战迹!', '2', 'http://www.baidu.com', '250.00', 'com.qq.wangzhenongyao', '2018-10-23 17:11:59', '2018-10-25 18:45:06');
INSERT INTO `app_version` VALUES ('2', '2', '1.0.23', '商城新增了一大批万圣节皮肤，还有新的宝箱!\r\n\r\n游戏中新增了一把蝎式手枪\r\n\r\n还有全新的自定义对抗模式\r\n\r\n日常的一些BUG修复和日常优化！', '2', 'http://image.9game.cn/2018/10/24/26557521.jpg', '238.00', 'cn.9game.www', '2018-10-25 18:33:08', '2018-10-25 18:45:44');
INSERT INTO `app_version` VALUES ('3', '3', '安图恩', '使徒!', '2', 'http://ossweb-img.qq.com/upload/adw/image/20181017/fd66cb85de792dd4707daf778f5f8e2b.jpgl', '123.00', 'webplat.com.qq.dnf', '2018-10-25 18:34:38', '2018-10-25 18:45:45');
INSERT INTO `app_version` VALUES ('4', '4', '9.1.0.2657', '皮肤、表情、词库合作 邮箱：ImePOM-stickers@sogou-inc.com', '2', 'https://img02.sogoucdn.com/app/a/11130001/dictrec_1daxuexiaoban.jpg', '42.19', 'com.sougou.pinyin', '2018-10-25 18:35:41', '2018-10-25 18:45:46');
INSERT INTO `app_version` VALUES ('5', '5', '10.3.1.2', '安全防卫,层层把关!', '2', 'https://dl.360safe.com/360/inst.exe', '186.21', 'cn.360.weishi', '2018-10-25 18:37:37', '2018-10-25 18:45:47');
INSERT INTO `app_version` VALUES ('6', '6', 'O2', '《劲乐团》是韩国 O2Media 游戏公司开发的一款 MMOMPG (Massive Multi Online Music Play Game) 游戏。 它是世界上第一款以 MP3音乐为游戏平台的休闲音乐游戏，巧妙地结合了音乐与娱乐，让你在弹奏歌曲时不知不觉融入到无限音乐美好中', '2', 'http://s2.doyo.cn/img/58/4f/d1ce9e9e78cd66000062.jpg', '377.7', '726.game.cn.doyo.ww', '2018-10-25 18:40:12', '2018-10-25 18:45:47');
INSERT INTO `app_version` VALUES ('7', '3', '帝国竞技场', '帝国竞技场，有人说这座巨大建筑物是帝国的荣光与繁华，也有人说这是帝国的结痂的伤口。\r\n但不可否认的是，帝国的人们总是非常乐意欣赏那些在竞技场中殊死搏杀的战斗。\r\n这些战斗有的是为了财富和荣誉，\r\n有的是为了获得更强的力量与威权，\r\n也有的只是为了生存与自由。\r\n无数观众围观着这里，见证着帝国的喧嚣。\r\n比赛结束，夜已深，喧闹如同潮水一样迅速褪去，\r\n难得的寂静会短暂地降临在竞技场上，空旷而又血腥', '2', 'http://dnf.qq.com/cp/a20181018version/?e_code=444262&idataid=233670', '868.3', 'com.qq.dnf', '2018-10-25 18:41:54', '2018-10-25 18:45:48');
INSERT INTO `app_version` VALUES ('8', '1', 'S2', '王者联盟!', '2', 'http://i1.letvimg.com/lc07_crawler/201709/15/19/12/1505473934670-0.jpg', '342.1', 'com.qq.wzlm', '2018-10-25 18:43:34', '2018-10-25 18:45:50');
INSERT INTO `app_version` VALUES ('9', '1', 'S3', '王者荣耀!', '2', 'http://i1.letvimg.com/lc07_crawler/201709/15/19/12/1505473934670-0.jpg', '412.1', 'com.qq.wzny', '2018-10-25 18:44:18', '2018-10-25 18:45:49');
INSERT INTO `app_version` VALUES ('10', '16', 'V1.1', '  《武侠乂》是一款国产的武侠吃鸡游戏，现在已经在WEgame和STEAM上正式登录，下面就为大家带来新手操作与常识介绍', '3', '/apk/com.wuxiayi.起码.V1.1.apk', '500.0', 'com.wuxiayi.起码.V1.1.apk', '2018-11-08 17:16:22', '2018-11-08 17:16:22');
INSERT INTO `app_version` VALUES ('11', '7', 'U1.1', '真好用!', '3', '/apk/com.lbe.security.U1.1.apk', '200.0', 'com.lbe.security.U1.1.apk', '2018-11-08 17:29:08', '2018-11-08 17:29:08');
INSERT INTO `app_version` VALUES ('12', '13', 'S1', '测试审核操作', '3', '/apk/com.bithack.apparatus.S1.apk', '500.0', 'com.bithack.apparatus.S1.apk', '2018-11-22 16:14:07', '2018-11-22 16:14:07');
INSERT INTO `app_version` VALUES ('13', '11', 'S1', '测试一哈websocket', '3', '/apk/com.katecca.screenofflockdonate.S1.apk', '50.0', 'com.katecca.screenofflockdonate.S1.apk', '2018-11-27 15:33:51', '2018-11-27 15:33:51');
INSERT INTO `app_version` VALUES ('14', '11', 'S2', '测试', '3', '/apk/com.katecca.screenofflockdonate.S2.apk', '50.0', 'com.katecca.screenofflockdonate.S2.apk', '2018-11-27 15:34:30', '2018-11-27 15:34:30');
INSERT INTO `app_version` VALUES ('15', '11', 'S2', '测试', '3', '/apk/com.katecca.screenofflockdonate.S2.apk', '60.0', 'com.katecca.screenofflockdonate.S2.apk', '2018-11-27 15:35:51', '2018-11-27 15:35:51');
INSERT INTO `app_version` VALUES ('16', '11', 'S4', '测试', '3', '/apk/com.katecca.screenofflockdonate.S4.apk', '70.0', 'com.katecca.screenofflockdonate.S4.apk', '2018-11-27 15:37:29', '2018-11-27 15:37:29');
INSERT INTO `app_version` VALUES ('17', '11', 'S5', '测试音乐', '3', '/apk/com.katecca.screenofflockdonate.S5.apk', '70.0', 'com.katecca.screenofflockdonate.S5.apk', '2018-11-27 15:41:58', '2018-11-27 15:41:58');
INSERT INTO `app_version` VALUES ('18', '11', 'S6', '测试', '3', '/apk/com.katecca.screenofflockdonate.S6.apk', '40.0', 'com.katecca.screenofflockdonate.S6.apk', '2018-11-27 15:42:52', '2018-11-27 15:42:52');
INSERT INTO `app_version` VALUES ('19', '11', 'S7', '123', '3', '/apk/com.katecca.screenofflockdonate.S7.apk', '34.0', 'com.katecca.screenofflockdonate.S7.apk', '2018-11-27 15:45:04', '2018-11-27 15:45:04');
INSERT INTO `app_version` VALUES ('20', '11', 'S8', '12312312', '3', '/apk/com.katecca.screenofflockdonate.S8.apk', '122.0', 'com.katecca.screenofflockdonate.S8.apk', '2018-11-27 15:45:41', '2018-11-27 15:45:41');
INSERT INTO `app_version` VALUES ('21', '11', 'S9', '213', '3', '/apk/com.katecca.screenofflockdonate.S9.apk', '123.0', 'com.katecca.screenofflockdonate.S9.apk', '2018-11-27 15:50:24', '2018-11-27 15:50:24');
INSERT INTO `app_version` VALUES ('22', '11', 'S10', '1231231', '3', '/apk/com.katecca.screenofflockdonate.S10.apk', '123.0', 'com.katecca.screenofflockdonate.S10.apk', '2018-11-27 15:51:07', '2018-11-27 15:51:07');
INSERT INTO `app_version` VALUES ('23', '11', 'S13', '42342', '3', '/apk/com.katecca.screenofflockdonate.S13.apk', '123.0', 'com.katecca.screenofflockdonate.S13.apk', '2018-11-27 15:51:30', '2018-11-27 15:51:30');
INSERT INTO `app_version` VALUES ('24', '27', 'S1', '有事问百度!!!!', '3', 'http://www.baidu.com', '500', 'xxx.apk', '2019-08-06 11:47:52', '2019-08-06 11:47:52');
INSERT INTO `app_version` VALUES ('25', '27', 'S2', '测试！', '3', 'http://localhost/apk/xxx.apk', '444', 'xxx.apk', '2019-08-06 11:59:52', '2019-08-06 11:59:52');
INSERT INTO `app_version` VALUES ('26', '27', 'S3', 'xxxxxxxxxxxxxx', '3', 'http://localhost/apk/xxx.apk', '666', 'xxx.apk', '2019-08-06 12:07:22', '2019-08-06 12:07:22');
INSERT INTO `app_version` VALUES ('27', '27', 'S1', '有事问百度!!!!', '3', 'http://www.baidu.com', '500', 'xxx.apk', '2019-08-13 15:43:33', '2019-08-13 15:43:33');
INSERT INTO `app_version` VALUES ('28', '27', 'S1', '有事问百度!!!!', '3', 'http://www.baidu.com', '500', 'xxx.apk', '2019-08-13 16:00:10', '2019-08-13 16:00:10');

-- ----------------------------
-- Table structure for `backend_perm`
-- ----------------------------
DROP TABLE IF EXISTS `backend_perm`;
CREATE TABLE `backend_perm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `perm_name` varchar(128) NOT NULL COMMENT '权限信息',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`perm_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of backend_perm
-- ----------------------------
INSERT INTO `backend_perm` VALUES ('1', 'back:app:exam', '2018-11-17 16:25:53', '2019-06-08 20:16:50');
INSERT INTO `backend_perm` VALUES ('2', 'back:app-cate:update', '2019-03-16 16:09:01', '2019-10-28 16:40:01');
INSERT INTO `backend_perm` VALUES ('3', 'back:app-cate:insert', '2019-06-08 20:18:12', '2019-10-28 16:40:01');
INSERT INTO `backend_perm` VALUES ('4', 'back:app-cate:delete', '2019-06-08 20:18:24', '2019-10-28 16:40:02');
INSERT INTO `backend_perm` VALUES ('5', 'back:app-cate:select', '2019-06-08 20:18:34', '2019-10-28 16:40:04');
INSERT INTO `backend_perm` VALUES ('6', 'back:app:select', '2019-06-08 20:22:59', '2019-10-28 16:40:05');
INSERT INTO `backend_perm` VALUES ('7', 'back:data:insert', '2019-10-28 16:42:22', '2019-10-28 16:42:53');
INSERT INTO `backend_perm` VALUES ('8', 'back:data:update', '2019-10-28 16:42:35', '2019-10-28 16:42:54');
INSERT INTO `backend_perm` VALUES ('9', 'back:data:delete', '2019-10-28 16:42:42', '2019-10-28 16:42:55');
INSERT INTO `backend_perm` VALUES ('10', 'back:data:select', '2019-10-28 16:42:50', '2019-10-28 16:42:57');

-- ----------------------------
-- Table structure for `backend_role`
-- ----------------------------
DROP TABLE IF EXISTS `backend_role`;
CREATE TABLE `backend_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(16) NOT NULL COMMENT '角色',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='后台管理用户角色表';

-- ----------------------------
-- Records of backend_role
-- ----------------------------
INSERT INTO `backend_role` VALUES ('1', '超级管理员', '2019-10-28 15:17:56', '2019-10-28 15:17:56');
INSERT INTO `backend_role` VALUES ('2', '财务', '2019-10-28 15:17:59', '2019-10-28 15:17:59');
INSERT INTO `backend_role` VALUES ('3', '市场', '2019-10-28 15:18:01', '2019-10-28 15:18:13');
INSERT INTO `backend_role` VALUES ('4', '运营', '2019-10-28 15:18:06', '2019-10-28 15:18:06');
INSERT INTO `backend_role` VALUES ('5', '销售', '2019-10-28 15:18:10', '2019-10-28 15:18:10');

-- ----------------------------
-- Table structure for `backend_role_perm`
-- ----------------------------
DROP TABLE IF EXISTS `backend_role_perm`;
CREATE TABLE `backend_role_perm` (
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `role_perm` (`role_id`,`perm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台管理用户角色表';

-- ----------------------------
-- Records of backend_role_perm
-- ----------------------------
INSERT INTO `backend_role_perm` VALUES ('1', '1', '2019-10-28 16:43:32', '2019-10-28 16:43:32');
INSERT INTO `backend_role_perm` VALUES ('1', '2', '2019-10-28 16:43:35', '2019-10-28 16:43:35');
INSERT INTO `backend_role_perm` VALUES ('1', '3', '2019-10-28 16:43:39', '2019-10-28 16:43:39');
INSERT INTO `backend_role_perm` VALUES ('1', '4', '2019-10-28 16:43:42', '2019-10-28 16:43:42');
INSERT INTO `backend_role_perm` VALUES ('1', '5', '2019-10-28 16:43:44', '2019-10-28 16:43:44');
INSERT INTO `backend_role_perm` VALUES ('1', '6', '2019-10-28 16:43:47', '2019-10-28 16:43:47');
INSERT INTO `backend_role_perm` VALUES ('1', '7', '2019-10-28 16:43:50', '2019-10-28 16:43:50');
INSERT INTO `backend_role_perm` VALUES ('1', '8', '2019-10-28 16:43:53', '2019-10-28 16:43:53');
INSERT INTO `backend_role_perm` VALUES ('1', '9', '2019-10-28 16:43:56', '2019-10-28 16:43:56');
INSERT INTO `backend_role_perm` VALUES ('1', '10', '2019-10-28 16:44:02', '2019-10-28 16:44:02');
INSERT INTO `backend_role_perm` VALUES ('4', '2', '2019-10-28 16:44:38', '2019-10-28 16:44:38');
INSERT INTO `backend_role_perm` VALUES ('4', '3', '2019-10-28 16:44:40', '2019-10-28 16:44:40');
INSERT INTO `backend_role_perm` VALUES ('4', '4', '2019-10-28 16:44:43', '2019-10-28 16:44:43');
INSERT INTO `backend_role_perm` VALUES ('4', '5', '2019-10-28 16:44:45', '2019-10-28 16:44:45');

-- ----------------------------
-- Table structure for `backend_user`
-- ----------------------------
DROP TABLE IF EXISTS `backend_user`;
CREATE TABLE `backend_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `backend_code` varchar(16) NOT NULL COMMENT '用户账号',
  `backend_password` varchar(32) NOT NULL COMMENT '用户密码',
  `backend_salt` varchar(36) NOT NULL COMMENT '盐',
  `backend_name` varchar(16) NOT NULL COMMENT '真实姓名',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `backend_code` (`backend_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='后台管理员用户表';

-- ----------------------------
-- Records of backend_user
-- ----------------------------
INSERT INTO `backend_user` VALUES ('1', 'admin', 'cc19a8325ae9894682b34e779e967141', '28d5b3fa-fa6b-4dd3-bd62-0e6f2a7ff72d', '王老板', '2018-10-25 18:47:38', '2019-07-31 10:16:28');
INSERT INTO `backend_user` VALUES ('2', 'caiwu', 'cc19a8325ae9894682b34e779e967141', '28d5b3fa-fa6b-4dd3-bd62-0e6f2a7ff72d', '李财务', '2018-11-22 16:03:18', '2019-08-07 10:39:14');
INSERT INTO `backend_user` VALUES ('3', 'yunying', 'cc19a8325ae9894682b34e779e967141', '28d5b3fa-fa6b-4dd3-bd62-0e6f2a7ff72d', '赵运营', '2019-10-28 16:46:10', '2019-10-28 16:46:16');

-- ----------------------------
-- Table structure for `backend_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `backend_user_role`;
CREATE TABLE `backend_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `user_role` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台管理用户角色表';

-- ----------------------------
-- Records of backend_user_role
-- ----------------------------
INSERT INTO `backend_user_role` VALUES ('1', '1', '2019-10-28 16:39:17', '2019-10-28 16:39:17');
INSERT INTO `backend_user_role` VALUES ('2', '2', '2019-10-28 16:39:21', '2019-10-28 16:39:21');
INSERT INTO `backend_user_role` VALUES ('2', '3', '2019-10-28 16:39:25', '2019-10-28 16:39:25');

-- ----------------------------
-- Table structure for `data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_code` varchar(16) NOT NULL COMMENT '对应不同的类型. ',
  `type_name` varchar(16) NOT NULL COMMENT '对应不同类型的名字',
  `value_id` bigint(20) NOT NULL COMMENT '映射不用类型的id',
  `value_name` varchar(16) NOT NULL COMMENT '状态名字',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='字典表';

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------
INSERT INTO `data_dictionary` VALUES ('1', 'APP_STATUS', 'APP状态', '1', '待审核', '2016-08-12 18:11:47', '2019-10-28 15:18:26');
INSERT INTO `data_dictionary` VALUES ('2', 'APP_STATUS', 'APP状态', '2', '审核通过', '2016-08-12 18:11:47', '2019-10-28 15:18:26');
INSERT INTO `data_dictionary` VALUES ('3', 'APP_STATUS', 'APP状态', '3', '审核驳回', '2016-08-12 18:11:47', '2019-10-28 15:18:27');
INSERT INTO `data_dictionary` VALUES ('4', 'APP_STATUS', 'APP状态', '4', '已上架', '2016-08-12 18:11:47', '2019-10-28 15:18:28');
INSERT INTO `data_dictionary` VALUES ('5', 'APP_STATUS', 'APP状态', '5', '已下架', '2016-08-12 18:11:47', '2019-10-28 15:18:30');
INSERT INTO `data_dictionary` VALUES ('6', 'APP_FLATFORM', '所属平台', '1', '手机', '2016-08-12 18:11:47', '2019-10-28 15:18:31');
INSERT INTO `data_dictionary` VALUES ('7', 'APP_FLATFORM', '所属平台', '2', '平板', '2016-08-12 18:11:47', '2019-10-28 15:18:32');
INSERT INTO `data_dictionary` VALUES ('8', 'APP_FLATFORM', '所属平台', '3', '通用', '2016-08-12 18:11:47', '2019-10-28 15:18:32');
INSERT INTO `data_dictionary` VALUES ('9', 'PUBLISH_STATUS', '发布状态', '1', '不发布', '2016-08-12 18:11:47', '2019-10-28 15:18:33');
INSERT INTO `data_dictionary` VALUES ('10', 'PUBLISH_STATUS', '发布状态', '2', '已发布', '2016-08-12 18:11:47', '2019-10-28 15:18:37');
INSERT INTO `data_dictionary` VALUES ('11', 'PUBLISH_STATUS', '发布状态', '3', '预发布', '2016-08-12 18:11:47', '2019-10-28 15:18:35');

-- ----------------------------
-- Table structure for `dev_user`
-- ----------------------------
DROP TABLE IF EXISTS `dev_user`;
CREATE TABLE `dev_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dev_username` varchar(16) NOT NULL COMMENT '账号',
  `dev_password` varchar(32) NOT NULL COMMENT '密码',
  `dev_salt` varchar(36) NOT NULL,
  `dev_email` varchar(32) NOT NULL COMMENT 'email',
  `dev_code` varchar(72) DEFAULT NULL COMMENT '邮件激活code',
  `dev_birthday` date NOT NULL COMMENT '出生日期',
  `dev_state` int(11) NOT NULL DEFAULT '0' COMMENT '0 - 账号锁定,  1 - 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dev_code` (`dev_username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='开发者用户表';

-- ----------------------------
-- Records of dev_user
-- ----------------------------
INSERT INTO `dev_user` VALUES ('2', 'admin', '87b042c91716221a41f8c4e300e55add', '120bba18-b732-4b50-88bb-edd02b38edb9', '402424668@qq.com', null, '2019-06-05', '1', '2019-06-09 12:29:50', '2019-08-02 12:15:13');
INSERT INTO `dev_user` VALUES ('3', 'admin123', '043dd65dc2a1dbeff2f52c3162eba793', 'ab43a8d2-7fd0-4bab-8bac-19575858b169', '402424668@qq.com', null, '2019-07-16', '1', '2019-07-31 08:38:33', '2019-07-31 08:38:33');
INSERT INTO `dev_user` VALUES ('4', 'zhangsan', 'cc19a8325ae9894682b34e779e967141', '28d5b3fa-fa6b-4dd3-bd62-0e6f2a7ff72d', '402424668@qq.com', null, '2019-07-16', '1', '2019-07-31 10:10:41', '2019-07-31 10:10:41');
INSERT INTO `dev_user` VALUES ('6', 'lisilisi', 'f0091a84055ee8b88512f185ad997f87', '696598c9-3457-4e57-b842-97fa330ee277', '402424668@qq.com', null, '2019-07-10', '1', '2019-07-31 15:53:52', '2019-07-31 15:53:52');
INSERT INTO `dev_user` VALUES ('8', 'qweqwe', 'd7d78265829dd9121d9bd968721c047f', 'd77118a9-b4f6-4256-89fd-52af54d803ab', '402424668@qq.com', null, '2019-08-06', '1', '2019-08-02 10:09:13', '2019-08-02 12:15:27');

-- ----------------------------
-- Table structure for `filter_chain`
-- ----------------------------
DROP TABLE IF EXISTS `filter_chain`;
CREATE TABLE `filter_chain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `filter` varchar(255) NOT NULL,
  `ordered` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of filter_chain
-- ----------------------------
INSERT INTO `filter_chain` VALUES ('1', '/dev/**', 'authc', '50', '2019-10-28 16:46:44', '2019-10-28 16:46:44');
INSERT INTO `filter_chain` VALUES ('2', '/backend/**', 'authc', '50', '2019-10-28 16:46:59', '2019-10-28 16:46:59');
INSERT INTO `filter_chain` VALUES ('3', '/dev/user/**', 'anon', '25', '2019-10-28 16:47:11', '2019-10-28 16:47:11');
INSERT INTO `filter_chain` VALUES ('4', '/backend/user/**', 'anon', '25', '2019-10-28 16:47:22', '2019-10-28 16:47:22');

-- ----------------------------
-- View structure for `app_maintain`
-- ----------------------------
DROP VIEW IF EXISTS `app_maintain`;
CREATE ALGORITHM=UNDEFINED DEFINER=`skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `app_maintain` AS (select `a`.`id` AS `id`,`a`.`software_name` AS `software_name`,`a`.`support_rom` AS `support_rom`,`a`.`interface_language` AS `interface_language`,`a`.`software_size` AS `software_size`,`a`.`app_status` AS `app_status`,`d1`.`value_name` AS `app_status_name`,`a`.`flatform_id` AS `flatform_id`,`d2`.`value_name` AS `flatform_name`,`a`.`downloads` AS `downloads`,`a`.`category_level1` AS `category_level1`,`c1`.`category_name` AS `category_level_one_name`,`a`.`category_level2` AS `category_level2`,`c2`.`category_name` AS `category_level_two_name`,`a`.`category_level3` AS `category_level3`,`c3`.`category_name` AS `category_level_three_name`,`v`.`version_no` AS `version_no`,`a`.`created` AS `created`,`a`.`updated` AS `updated` from ((((((`app_info` `a` join `data_dictionary` `d1` on(((`d1`.`value_id` = `a`.`app_status`) and (`d1`.`type_code` = 'APP_STATUS')))) join `data_dictionary` `d2` on(((`d2`.`value_id` = `a`.`flatform_id`) and (`d2`.`type_code` = 'APP_FLATFORM')))) join `app_category` `c1` on((`c1`.`id` = `a`.`category_level1`))) join `app_category` `c2` on((`c2`.`id` = `a`.`category_level2`))) join `app_category` `c3` on((`c3`.`id` = `a`.`category_level3`))) left join `app_version` `v` on((`v`.`id` = `a`.`version_id`)))) ;
