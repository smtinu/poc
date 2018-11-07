/**
 * 
 */
package com.verizon.iprom.orders.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManjunathShivashimpi
 *
 */
@Entity
@Table(name = "IN_ORDER")
public class OrderEntity {

	@Id
	@Column(name = "ORDER_ID")
	private BigInteger orderId;
	
	@Column(name = "TRACKER_ID")
	private String trackerId;
	
	@Column(name = "SALES_ENG_ID")
	private String salesEngId;
	
	@Column(name = "CANCELED_REASON_CODE")
	private Integer cancelledReasonCode;
	
	@Column(name = "CENTER_ID")
	private Integer centerId;
	
	@Column(name = "CUSTOMER_ID")
	private BigInteger customerId;
	
	@Column(name = "CANCELED")
	private String cancelled;
	
	@Column(name = "STATUS_ID")
	private BigInteger statusId;
	
	@Column(name = "AFFILIATE_ID")
	private String affiliateId;
	
	@Column(name = "SALES_REP_ID")
	private String salesRepId;
	
	@Column(name = "SIGNED_DATE")
	private Timestamp signedDate;
	
	@Column(name = "REFERRED_TO")
	private String referredTo;
	
	@Column(name = "DOCUMENT")
	private String document;
	
	@Column(name = "ORDER_NAME")
	private String orderName;
	
	@Column(name = "LAST_UPDATE_USER")
	private String lastUpdateUser;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;
	
	@Column(name = "REVISION_NUMBER")
	private Integer revisionNumber;
	
	@Column(name = "SUB_TYPE_CODE")
	private String subTypeCode;
	
	@Column(name = "MASTER_ACCOUNT_NUMBER")
	private BigInteger masterAccountNumber;
	
	@Column(name = "TIN_VERSION")
	private Integer tinVersion;
	
	@Column(name = "WORK_ORDER")
	private Integer workOrder;
	
	@Column(name = "FIELD_TRACKING_ID")
	private String fieldTrackingId;
	
	@Column(name = "ORDER_NAME_UC")
	private String orderNameUc;
	
	@Column(name = "MANUAL_TIN_FLAG")
	private String manualTinflag;
	
	@Column(name = "CIS_CUSTOMER_ID")
	private String cisCustomerId;
	
	@Column(name = "CIS_ADDRESS_ID")
	private String cisAddressId;
	
	@Column(name = "PROJECT_NBR")
	private String projectNbr;
	
	@Column(name = "IDX_BIL_SYS")
	private String IdxbilSys;
	
	@Column(name = "TIN")
	private String tin;
	
	@Column(name = "RELATED_ORDER_ID")
	private BigInteger relatedOrderId;
	
	@Column(name = "UNO_SRV_ORD_ID")
	private String unoSrvOrdId;
	
	@Column(name = "UNO_SRV_ORD_ID_VER")
	private Integer unoSrvOrdIdVer;
	
	@Column(name = "WO_NUMBER")
	private BigInteger woNumber;
	
	@Column(name = "WO_VERSION")
	private Integer woVersion;
	
	@Column(name = "CIS_OFFICE_ID")
	private String cisOfficeId;
	
	@Column(name = "LEGACY_MIG_DATE")
	private Timestamp legacyMigDate;

	/**
	 * @return the orderId
	 */
	public BigInteger getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the trackerId
	 */
	public String getTrackerId() {
		return trackerId;
	}

	/**
	 * @param trackerId the trackerId to set
	 */
	public void setTrackerId(String trackerId) {
		this.trackerId = trackerId;
	}

	/**
	 * @return the salesEngId
	 */
	public String getSalesEngId() {
		return salesEngId;
	}

	/**
	 * @param salesEngId the salesEngId to set
	 */
	public void setSalesEngId(String salesEngId) {
		this.salesEngId = salesEngId;
	}

	/**
	 * @return the cancelledReasonCode
	 */
	public Integer getCancelledReasonCode() {
		return cancelledReasonCode;
	}

	/**
	 * @param cancelledReasonCode the cancelledReasonCode to set
	 */
	public void setCancelledReasonCode(Integer cancelledReasonCode) {
		this.cancelledReasonCode = cancelledReasonCode;
	}

	/**
	 * @return the centerId
	 */
	public Integer getCenterId() {
		return centerId;
	}

	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	/**
	 * @return the customerId
	 */
	public BigInteger getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the cancelled
	 */
	public String getCancelled() {
		return cancelled;
	}

	/**
	 * @param cancelled the cancelled to set
	 */
	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}

	/**
	 * @return the statusId
	 */
	public BigInteger getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(BigInteger statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the affiliateId
	 */
	public String getAffiliateId() {
		return affiliateId;
	}

	/**
	 * @param affiliateId the affiliateId to set
	 */
	public void setAffiliateId(String affiliateId) {
		this.affiliateId = affiliateId;
	}

	/**
	 * @return the salesRepId
	 */
	public String getSalesRepId() {
		return salesRepId;
	}

	/**
	 * @param salesRepId the salesRepId to set
	 */
	public void setSalesRepId(String salesRepId) {
		this.salesRepId = salesRepId;
	}

	/**
	 * @return the signedDate
	 */
	public Timestamp getSignedDate() {
		return signedDate;
	}

	/**
	 * @param signedDate the signedDate to set
	 */
	public void setSignedDate(Timestamp signedDate) {
		this.signedDate = signedDate;
	}

	/**
	 * @return the refferredTo
	 */
	public String getReferredTo() {
		return referredTo;
	}

	/**
	 * @param refferredTo the refferredTo to set
	 */
	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return the lastUpdateUser
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * @param lastUpdateUser the lastUpdateUser to set
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the revisionNumber
	 */
	public Integer getRevisionNumber() {
		return revisionNumber;
	}

	/**
	 * @param revisionNumber the revisionNumber to set
	 */
	public void setRevisionNumber(Integer revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	/**
	 * @return the subTypeCode
	 */
	public String getSubTypeCode() {
		return subTypeCode;
	}

	/**
	 * @param subTypeCode the subTypeCode to set
	 */
	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	/**
	 * @return the masterAccountNumber
	 */
	public BigInteger getMasterAccountNumber() {
		return masterAccountNumber;
	}

	/**
	 * @param masterAccountNumber the masterAccountNumber to set
	 */
	public void setMasterAccountNumber(BigInteger masterAccountNumber) {
		this.masterAccountNumber = masterAccountNumber;
	}

	/**
	 * @return the tinVersion
	 */
	public Integer getTinVersion() {
		return tinVersion;
	}

	/**
	 * @param tinVersion the tinVersion to set
	 */
	public void setTinVersion(Integer tinVersion) {
		this.tinVersion = tinVersion;
	}

	/**
	 * @return the workOrder
	 */
	public Integer getWorkOrder() {
		return workOrder;
	}

	/**
	 * @param workOrder the workOrder to set
	 */
	public void setWorkOrder(Integer workOrder) {
		this.workOrder = workOrder;
	}

	/**
	 * @return the fieldTrackingId
	 */
	public String getFieldTrackingId() {
		return fieldTrackingId;
	}

	/**
	 * @param fieldTrackingId the fieldTrackingId to set
	 */
	public void setFieldTrackingId(String fieldTrackingId) {
		this.fieldTrackingId = fieldTrackingId;
	}

	/**
	 * @return the orderNameUc
	 */
	public String getOrderNameUc() {
		return orderNameUc;
	}

	/**
	 * @param orderNameUc the orderNameUc to set
	 */
	public void setOrderNameUc(String orderNameUc) {
		this.orderNameUc = orderNameUc;
	}

	/**
	 * @return the manualTinflag
	 */
	public String getManualTinflag() {
		return manualTinflag;
	}

	/**
	 * @param manualTinflag the manualTinflag to set
	 */
	public void setManualTinflag(String manualTinflag) {
		this.manualTinflag = manualTinflag;
	}

	/**
	 * @return the cisCustomerId
	 */
	public String getCisCustomerId() {
		return cisCustomerId;
	}

	/**
	 * @param cisCustomerId the cisCustomerId to set
	 */
	public void setCisCustomerId(String cisCustomerId) {
		this.cisCustomerId = cisCustomerId;
	}

	/**
	 * @return the cisAddressId
	 */
	public String getCisAddressId() {
		return cisAddressId;
	}

	/**
	 * @param cisAddressId the cisAddressId to set
	 */
	public void setCisAddressId(String cisAddressId) {
		this.cisAddressId = cisAddressId;
	}

	/**
	 * @return the projectNbr
	 */
	public String getProjectNbr() {
		return projectNbr;
	}

	/**
	 * @param projectNbr the projectNbr to set
	 */
	public void setProjectNbr(String projectNbr) {
		this.projectNbr = projectNbr;
	}

	/**
	 * @return the idxbilSys
	 */
	public String getIdxbilSys() {
		return IdxbilSys;
	}

	/**
	 * @param idxbilSys the idxbilSys to set
	 */
	public void setIdxbilSys(String idxbilSys) {
		IdxbilSys = idxbilSys;
	}

	/**
	 * @return the tin
	 */
	public String getTin() {
		return tin;
	}

	/**
	 * @param tin the tin to set
	 */
	public void setTin(String tin) {
		this.tin = tin;
	}

	/**
	 * @return the relatedOrderId
	 */
	public BigInteger getRelatedOrderId() {
		return relatedOrderId;
	}

	/**
	 * @param relatedOrderId the relatedOrderId to set
	 */
	public void setRelatedOrderId(BigInteger relatedOrderId) {
		this.relatedOrderId = relatedOrderId;
	}

	/**
	 * @return the unoSrvOrdId
	 */
	public String getUnoSrvOrdId() {
		return unoSrvOrdId;
	}

	/**
	 * @param unoSrvOrdId the unoSrvOrdId to set
	 */
	public void setUnoSrvOrdId(String unoSrvOrdId) {
		this.unoSrvOrdId = unoSrvOrdId;
	}

	/**
	 * @return the unoSrvOrdIdVer
	 */
	public Integer getUnoSrvOrdIdVer() {
		return unoSrvOrdIdVer;
	}

	/**
	 * @param unoSrvOrdIdVer the unoSrvOrdIdVer to set
	 */
	public void setUnoSrvOrdIdVer(Integer unoSrvOrdIdVer) {
		this.unoSrvOrdIdVer = unoSrvOrdIdVer;
	}

	/**
	 * @return the woNumber
	 */
	public BigInteger getWoNumber() {
		return woNumber;
	}

	/**
	 * @param woNumber the woNumber to set
	 */
	public void setWoNumber(BigInteger woNumber) {
		this.woNumber = woNumber;
	}

	/**
	 * @return the woVersion
	 */
	public Integer getWoVersion() {
		return woVersion;
	}

	/**
	 * @param woVersion the woVersion to set
	 */
	public void setWoVersion(Integer woVersion) {
		this.woVersion = woVersion;
	}

	/**
	 * @return the cisOfficeId
	 */
	public String getCisOfficeId() {
		return cisOfficeId;
	}

	/**
	 * @param cisOfficeId the cisOfficeId to set
	 */
	public void setCisOfficeId(String cisOfficeId) {
		this.cisOfficeId = cisOfficeId;
	}

	/**
	 * @return the legacyMigDate
	 */
	public Timestamp getLegacyMigDate() {
		return legacyMigDate;
	}

	/**
	 * @param legacyMigDate the legacyMigDate to set
	 */
	public void setLegacyMigDate(Timestamp legacyMigDate) {
		this.legacyMigDate = legacyMigDate;
	}
}
