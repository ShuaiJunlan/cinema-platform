package cn.shuaijunlan.orderservices.dao.repository;

import cn.shuaijunlan.orderservices.dao.model.OrderInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 1:40 PM 1/15/19.
 */
public interface OrderRepository extends JpaRepository<OrderInfoTable, Integer> {
}
