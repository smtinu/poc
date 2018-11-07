/**
 * 
 */
package com.verizon.iprom.orders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManjunathShivashimpi
 *
 */
@Entity
@Table(name = "IN_GENERIC_CODE")
public class GenericCodeEntity {

	@Id
    @Column(name = "ID")
    private Long id; // The row number!

	@Column(name = "CODE_TYPE")
	private String codeType;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DEFAULT_FLAG")
	private String defaultFlag;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the defaultFlag
	 */
	public String getDefaultFlag() {
		return defaultFlag;
	}

	/**
	 * @param defaultFlag the defaultFlag to set
	 */
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
}

