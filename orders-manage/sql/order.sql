-- ----------------------------
-- Table structure for order_info_table
-- ----------------------------
DROP TABLE IF EXISTS `order_info_table`;
CREATE TABLE order_info_table
(
  UUID         INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  cinema_id    INT COMMENT '影院编号',
  field_id     INT COMMENT '放映场次编号',
  film_id      INT COMMENT '电影编号',
  seats_ids    VARCHAR(50) COMMENT '已售座位编号',
  seats_name   VARCHAR(200) COMMENT '已售座位名称',
  order_price  DOUBLE COMMENT '订单总金额',
  order_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  order_user   INT COMMENT '下单人',
  order_status INT       DEFAULT 0 COMMENT '0-待支付,1-已支付,2-已关闭'
) COMMENT '订单信息表' ENGINE = INNODB
                  AUTO_INCREMENT = 1
                  CHARACTER SET = utf8
                  COLLATE = utf8_general_ci
                  ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of order_info_table
-- ----------------------------
INSERT INTO order_info_table(UUID, cinema_id, field_id, film_id, seats_ids, seats_name, order_price,
                             order_user)
VALUES (1, 1, 1, 2, '1,2,3,4', '第一排1座,第一排2座,第一排3座,第一排4座', 126.4, 1);

