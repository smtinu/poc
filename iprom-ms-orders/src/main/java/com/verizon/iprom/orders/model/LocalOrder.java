/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 16, 2018
 */
package com.verizon.iprom.orders.model;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * TODO Describe the purpose of this class.
 *
 */
public class LocalOrder
{
    
    private String localOrderNum;
    private String isLockedToUser;
    private String lockedUserName;
    private String localOrderStatus;
    private String isBillingLock;
    private String billingStatus;
    private String orderAction;
    private String product;
    private String version;
    private String CDDD;
    
    /**
     * 
     */
    public LocalOrder()
    {

    }
    /**
     * @return the localOrderNum
     */
    public String getLocalOrderNum()
    {
        return localOrderNum;
    }
    /**
     * @param localOrderNumParm the localOrderNum to set
     */
    public void setLocalOrderNum(String localOrderNumParm)
    {
        localOrderNum = localOrderNumParm;
    }
    /**
     * @return the isLockedToUser
     */
    public String getIsLockedToUser()
    {
        return isLockedToUser;
    }
    /**
     * @param isLockedToUserParm the isLockedToUser to set
     */
    public void setIsLockedToUser(String isLockedToUserParm)
    {
        isLockedToUser = isLockedToUserParm;
    }
    /**
     * @return the lockedUserName
     */
    public String getLockedUserName()
    {
        return lockedUserName;
    }
    /**
     * @param lockedUserNameParm the lockedUserName to set
     */
    public void setLockedUserName(String lockedUserNameParm)
    {
        lockedUserName = lockedUserNameParm;
    }
    /**
     * @return the localOrderStatus
     */
    public String getLocalOrderStatus()
    {
        return localOrderStatus;
    }
    /**
     * @param localOrderStatusParm the localOrderStatus to set
     */
    public void setLocalOrderStatus(String localOrderStatusParm)
    {
        localOrderStatus = localOrderStatusParm;
    }

    /**
     * @return the isBillingLock
     */
    public String getIsBillingLock()
    {
        return isBillingLock;
    }
    /**
     * @param isBillingLockParm the isBillingLock to set
     */
    public void setIsBillingLock(String isBillingLockParm)
    {
        isBillingLock = isBillingLockParm;
    }   
    
    
    /**
     * @return the billingStatus
     */
    public String getBillingStatus()
    {
        return billingStatus;
    }
    /**
     * @param billingStatusParm the billingStatus to set
     */
    public void setBillingStatus(String billingStatusParm)
    {
        billingStatus = billingStatusParm;
    }
    /**
     * @return the orderAction
     */
    public String getOrderAction()
    {
        return orderAction;
    }
    /**
     * @param orderActionParm the orderAction to set
     */
    public void setOrderAction(String orderActionParm)
    {
        orderAction = orderActionParm;
    }
    /**
     * @return the product
     */
    public String getProduct()
    {
        return product;
    }
    /**
     * @param productParm the product to set
     */
    public void setProduct(String productParm)
    {
        product = productParm;
    }
    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }
    /**
     * @param versionParm the version to set
     */
    public void setVersion(String versionParm)
    {
        version = versionParm;
    }
    /**
     * @return the cDDD
     */
    @JsonGetter("CDDD")
    public String getCDDD()
    {
        return CDDD;
    }
    /**
     * @param cDDDParm the cDDD to set
     */
    public void setCDDD(String cDDDParm)
    {
        CDDD = cDDDParm;
    }

}
