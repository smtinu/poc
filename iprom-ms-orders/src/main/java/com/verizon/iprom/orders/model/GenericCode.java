/**
 * 
 */
package com.verizon.iprom.orders.model;

/**
 * @author ManjunathShivashimpi
 *
 */
public class GenericCode {
	
	private String code;
	private String desc;
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
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenericCode [code=" + code + ", desc=" + desc + "]";
	}
}
