/**
 * 
 */
package com.verizon.iprom.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.verizon.iprom.orders.entity.CenterEntity;

/**
 * @author ManjunathShivashimpi
 *
 */
public interface CenterRepository extends CrudRepository<CenterEntity, String>{

	@Query(value = "SELECT * FROM IN_CENTER WHERE ACTIVE_FLAG='Y'", nativeQuery = true)
	public List<CenterEntity> findActiveCenters();
	
	@Query(value = "SELECT * FROM IN_CENTER WHERE ACTIVE_FLAG='Y' AND CENTER_ID = ?", nativeQuery = true)
	public CenterEntity getCenterById(String centerId);
	
}
