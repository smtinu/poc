/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 16, 2018
 */
package com.verizon.iprom.orders.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * TODO Describe the purpose of this class.
 *
 */
public class ViewOrderReponse
{
    
    private IntradaOrderDetails intradaOrderDetails;
    private CustomerDetails customerDetails;
    private List<LocalOrder> localOrders;
    private String responseCode = "000";
    private String status = "SUCCESS";
    /**
     * 
     */
    public ViewOrderReponse()
    {

    }
    /**
     * @return the intradaOrderDetails
     */
    @JsonGetter("IntradaOrderDetails")
    public IntradaOrderDetails getIntradaOrderDetails()
    {
        return intradaOrderDetails;
    }
    /**
     * @param intradaOrderDetailsParm the intradaOrderDetails to set
     */
    public void setIntradaOrderDetails(IntradaOrderDetails intradaOrderDetailsParm)
    {
        intradaOrderDetails = intradaOrderDetailsParm;
    }
    /**
     * @return the customerDetails
     */
    public CustomerDetails getCustomerDetails()
    {
        return customerDetails;
    }
    /**
     * @param customerDetailsParm the customerDetails to set
     */
    public void setCustomerDetails(CustomerDetails customerDetailsParm)
    {
        customerDetails = customerDetailsParm;
    }
    /**
     * @return the localOrders
     */
    public List<LocalOrder> getLocalOrders()
    {
        return localOrders;
    }
    /**
     * @param localOrdersParm the localOrders to set
     */
    public void setLocalOrders(List<LocalOrder> localOrdersParm)
    {
        localOrders = localOrdersParm;
    }
    
    /**
     * @param localOrderParm the localOrder to add to localOrders
     */
    public void addtLocalOrder(LocalOrder localOrderParm)
    {
        localOrders.add(localOrderParm);
    }
    
    /**
     * @return the responseCode
     */
    public String getResponseCode()
    {
        return responseCode;
    }
    /**
     * @param responseCodeParm the responseCode to set
     */
    public void setResponseCode(String responseCodeParm)
    {
        responseCode = responseCodeParm;
    }
    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * @param statusParm the status to set
     */
    public void setStatus(String statusParm)
    {
        status = statusParm;
    }


}
