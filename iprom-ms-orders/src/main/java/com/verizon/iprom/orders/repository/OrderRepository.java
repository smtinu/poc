/**
 * 
 */
package com.verizon.iprom.orders.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.verizon.iprom.orders.entity.OrderEntity;

/**
 * @author ManjunathShivashimpi
 *
 */
public interface OrderRepository extends JpaRepository<OrderEntity, BigInteger>{
	
	@Query(value = "SELECT MAX(ORDER_ID) FROM IN_ORDER", nativeQuery = true)
	public BigInteger getNextOrderId();
	
	@Query(value = "SELECT * FROM IN_ORDER WHERE ORDER_ID = ?", nativeQuery = true)
	public OrderEntity getOrderById(BigInteger orderId);
}
