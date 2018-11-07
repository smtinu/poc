/**
 * 
 */
package com.verizon.iprom.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verizon.iprom.orders.entity.GenericCodeEntity;

/**
 * @author ManjunathShivashimpi
 *
 */
@Repository
public interface GenericCodeRepository extends JpaRepository<GenericCodeEntity, Long>{
	
	@Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY CODE) AS ID, IN_GENERIC_CODE.* FROM IN_GENERIC_CODE WHERE CODE_TYPE=?1", nativeQuery = true)
	public List<GenericCodeEntity> findGenericCodeByCodeType(String codeType);

	@Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY CODE) AS ID, IN_GENERIC_CODE.* FROM IN_GENERIC_CODE WHERE CODE_TYPE=?1 AND CODE = ?2", nativeQuery = true)
	public GenericCodeEntity findServiceType(String codeType, String serviceTypeId);
	
	@Query(value = "SELECT DESCRIPTION FROM IN_GENERIC_CODE WHERE CODE_TYPE=?1 AND CODE = ?2", nativeQuery = true)
	public String findDescription(String codeType, String code);
	
	@Query(value = "SELECT CODE FROM IN_GENERIC_CODE WHERE CODE_TYPE=?1 AND CODE = ?2", nativeQuery = true)
	public String findCode(String codeType, String code);
	
}
