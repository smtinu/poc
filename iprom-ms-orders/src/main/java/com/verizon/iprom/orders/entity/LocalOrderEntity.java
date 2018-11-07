/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 16, 2018
 */
package com.verizon.iprom.orders.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO Describe the purpose of this class.
 *
 */

@Entity
@Table(name = "OSSR_ORD")
public class LocalOrderEntity
{

    @Id
    @Column(name = "IDX_ORD")
    private String idxOrd;

    @Column(name = "ORDER_ID", length=10)
    private int orderId;
    
    @Column(name = "NBR_ORD")
    private String localOrderNum;

    @Column(name = "LOCKED_USER")
    private String lockedUserName;

    @Column(name = "CDE_STS_ORD")
    private String localOrderStatus;

    @Column(name = "IND_ATN_ORD")
    private String orderAction;

    @Column(name = "TYP_ORD")
    private String product;

    @Column(name = "IDX_SPN_ORD")
    private String version;

    @Column(name = "DTX_DUE_DRE_CUS")
    private Timestamp CDDD;
    
    /**
     * @return the idxOrd
     */
    public String getIdxOrd()
    {
        return idxOrd;
    }

    /**
     * @param idxOrdParm the idxOrd to set
     */
    public void setIdxOrd(String idxOrdParm)
    {
        idxOrd = idxOrdParm;
    }
    
    /**
     * @return the orderId
     */
    public int getOrderId()
    {
        return orderId;
    }

    /**
     * @param orderIdParm the orderId to set
     */
    public void setOrderId(int orderIdParm)
    {
        orderId = orderIdParm;
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
    public Timestamp getCDDD()
    {
        return CDDD;
    }

    /**
     * @param cDDDParm the cDDD to set
     */
    public void setCDDD(Timestamp cDDDParm)
    {
        CDDD = cDDDParm;
    }

    @Override
    public boolean equals(Object obj)
    { 
        if (!(obj instanceof LocalOrderEntity))
        {
            return false;
        }        
        if (this == obj)
        {
            return true;
        }
        LocalOrderEntity other = (LocalOrderEntity) obj;

        return Objects.equals(getIdxOrd(), other.getIdxOrd());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(idxOrd);
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "LocalOrderEntity [idxOrd=" + idxOrd + ", orderId=" + orderId + ", localOrderNum=" + localOrderNum + ", lockedUserName=" + lockedUserName
                + ", localOrderStatus=" + localOrderStatus + ", lorderAction=" + orderAction + ", product=" + product + ", version=" + version
                + ", CDDD=" + CDDD + "]";
    }

}
