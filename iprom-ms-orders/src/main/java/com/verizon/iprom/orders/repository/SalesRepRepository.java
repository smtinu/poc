/**
 * 
 */
package com.verizon.iprom.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.verizon.iprom.orders.entity.SalesRepEntity;

/**
 * @author ManjunathShivashimpi
 *
 */
public interface SalesRepRepository extends JpaRepository<SalesRepEntity, String>{

	@Query(value = "SELECT * FROM IN_SALES_REP WHERE REP_TYPE = 'O'", nativeQuery = true)
	public List<SalesRepEntity> getSalesRepDetails();
}
