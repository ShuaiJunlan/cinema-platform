-- ----------------------------
-- Table structure for film_actor_table
-- ----------------------------
DROP TABLE IF EXISTS `film_actor_table`;
CREATE TABLE film_actor_table(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  film_id INT COMMENT '影片编号,对应film_table',
  actor_id INT COMMENT '演员编号,对应actor_table',
  role_name VARCHAR(100) COMMENT '角色名称'
) COMMENT '影片与演员映射表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of film_actor_table
-- ----------------------------
INSERT INTO film_actor_table(UUID,film_id,actor_id,role_name)
	values(1,2,1,'演员1');
INSERT INTO film_actor_table(UUID,film_id,actor_id,role_name)
	values(2,2,2,'演员2');
INSERT INTO film_actor_table(UUID,film_id,actor_id,role_name)
	values(3,2,3,'演员3');
INSERT INTO film_actor_table(UUID,film_id,actor_id,role_name)
	values(4,2,4,'演员4');