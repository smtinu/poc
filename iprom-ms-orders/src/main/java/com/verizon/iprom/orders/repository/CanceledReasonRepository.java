/**
 * 
 */
package com.verizon.iprom.orders.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.verizon.iprom.orders.entity.CanceledReasonEntity;

/**
 * @author ManjunathShivashimpi
 *
 */
public interface CanceledReasonRepository extends CrudRepository<CanceledReasonEntity, BigInteger>{
	
	@Query(value = "SELECT CANCELED_DESCRIPTION FROM IN_CANCELED_REASON WHERE CANCELED_REASON_CODE=?", nativeQuery = true)
	public String getCanceledReasonDescription(BigInteger canceledReasonCode);
}
