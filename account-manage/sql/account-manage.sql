DROP TABLE IF EXISTS `user_account_table`;
CREATE TABLE user_account_table(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  user_id INT COMMENT '用户主键',
  amount DOUBLE(14,2) DEFAULT '0.00'

)COMMENT '用户账户'ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO user_account_table(user_id, amount) VALUES (11, 10000.01);




DROP TABLE IF EXISTS `user_account_spending_table`;
CREATE TABLE user_account_spending_table(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  user_account_id INT COMMENT '用户主键',
  type INT COMMENT '消费类型：1表示收入，2表示支出',
  spending_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  amount DOUBLE(14,2) DEFAULT '0.00'

)COMMENT '消费记录'ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
