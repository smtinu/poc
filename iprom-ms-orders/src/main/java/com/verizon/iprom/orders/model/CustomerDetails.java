/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 16, 2018
 */
package com.verizon.iprom.orders.model;

/**
 * TODO Describe the purpose of this class.
 *
 */
public class CustomerDetails
{
    private String customerName;
    private String contactName;
    private String contactPhone;
    private String alternatePhone;
    
    /**
     * 
     */
    public CustomerDetails()
    {

    }
    /**
     * @return the customerName
     */
    public String getCustomerName()
    {
        return customerName;
    }
    /**
     * @param customerNameParm the customerName to set
     */
    public void setCustomerName(String customerNameParm)
    {
        customerName = customerNameParm;
    }
    /**
     * @return the contactName
     */
    public String getContactName()
    {
        return contactName;
    }
    /**
     * @param contactNameParm the contactName to set
     */
    public void setContactName(String contactNameParm)
    {
        contactName = contactNameParm;
    }
    /**
     * @return the contactPhone
     */
    public String getContactPhone()
    {
        return contactPhone;
    }
    /**
     * @param contactPhoneParm the contactPhone to set
     */
    public void setContactPhone(String contactPhoneParm)
    {
        contactPhone = contactPhoneParm;
    }
    /**
     * @return the alternatePhone
     */
    public String getAlternatePhone()
    {
        return alternatePhone;
    }
    /**
     * @param alternatePhoneParm the alternatePhone to set
     */
    public void setAlternatePhone(String alternatePhoneParm)
    {
        alternatePhone = alternatePhoneParm;
    }

}
