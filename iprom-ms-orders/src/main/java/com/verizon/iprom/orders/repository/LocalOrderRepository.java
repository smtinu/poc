/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 13, 2018
 */

package com.verizon.iprom.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.verizon.iprom.orders.entity.LocalOrderEntity;

@Repository
public interface LocalOrderRepository extends JpaRepository<LocalOrderEntity, Integer> {
	
   
    // Query Type = Method Signature
    @Query("SELECT localOrder FROM LocalOrderEntity localOrder where localOrder.orderId = :orderId")
    List<LocalOrderEntity> getByOrderId(@Param("orderId") int orderId);
    	
    //Query Type = Native SQL
    //@Query(value="select * from OSSR_ORD where NBR_ORD='18671169'", nativeQuery=true)

    //Query Type = JPQL
    //@Query("SELECT localOrderEntity FROM LocalOrderEntity localOrderEntity where localOrderEntity.orderId=3924640")

}
