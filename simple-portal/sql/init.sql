

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for page_style
-- ----------------------------
DROP TABLE IF EXISTS `page_style`;
CREATE TABLE `page_style`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id 自增',
                               `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标题',
                               `footer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '底部',
                               `enable` tinyint(1) NULL DEFAULT NULL COMMENT '是否可用',
                               `component_length` int(11) NULL DEFAULT NULL COMMENT '组件长度',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of page_style
-- ----------------------------
INSERT INTO `page_style` VALUES (1, '项目统一管理中心', '<div class=\"template-box\" style=\"text-align: center;margin: 49px;\">\r\n        <span> power by: boommanpro </span>\r\n        <br>\r\n        <span>©️2019 good good study , day day up.</span><span class=\"point\"></span>\r\n    </div>', 1, 6);

-- ----------------------------
-- Table structure for view_category
-- ----------------------------
DROP TABLE IF EXISTS `view_category`;
CREATE TABLE `view_category`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id自增',
                                  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '显示名称',
                                  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型Code',
                                  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '描述',
                                  `view_order` int(11) NULL DEFAULT 0 COMMENT '显示顺序',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_category
-- ----------------------------
INSERT INTO `view_category` VALUES (1, '一键部署', 'ONE_CLICK_DEPLOY', '一键部署', 0);
INSERT INTO `view_category` VALUES (2, '项目预览', 'PROJECT_PREVIEW', '项目预览', 1);
INSERT INTO `view_category` VALUES (3, '项目资料', 'PROJECT_DATA', '项目资料', 0);

-- ----------------------------
-- Table structure for view_data
-- ----------------------------
DROP TABLE IF EXISTS `view_data`;
CREATE TABLE `view_data`  (
                              `id` int(11) NOT NULL COMMENT '主键id 自增',
                              `view_category_id` int(11) NOT NULL COMMENT '类型id',
                              `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
                              `link` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '链接',
                              `type` enum('LINK','JENKINS') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型 是否是AJAX',
                              `view_order` int(11) NOT NULL DEFAULT 0 COMMENT '显示顺序',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_data
-- ----------------------------
INSERT INTO `view_data` VALUES (1, 1, '前端部署', 'http://xxx_server/job/xxx/build?token=boommanpro', 'JENKINS', 0);
INSERT INTO `view_data` VALUES (2, 1, '后端部署', 'http://xxx_serverjob/xxx/build?token=boommanpro', 'JENKINS', 0);
INSERT INTO `view_data` VALUES (3, 1, '组件部署', 'http://xxx_server/job/xxx/build?token=boommanpro', 'JENKINS', 0);
INSERT INTO `view_data` VALUES (4, 2, '项目Demo预览', 'http://demo.com', 'LINK', 0);
INSERT INTO `view_data` VALUES (5, 2, 'Yapi接口文档', 'http://yapi.com/project/54/interface/api', 'LINK', 0);
INSERT INTO `view_data` VALUES (6, 2, 'GitLab', 'http://gitlab..com/', 'LINK', 0);
INSERT INTO `view_data` VALUES (7, 3, '项目原型', 'http://server.com/', 'LINK', 0);
INSERT INTO `view_data` VALUES (8, 2, '项目现场环境', 'http://server.demo.com:81/', 'LINK', 0);

SET FOREIGN_KEY_CHECKS = 1;
