/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 13, 2018
 */
package com.verizon.iprom.orders.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.eds.intrada.CommonServer.Exception.NoRowsException;
import com.eds.intrada.CommonServer.Exception.ValidationException;
import com.eds.intrada.CommonServer.Utility.MessageLogger;
import com.eds.intrada.IXplusServer.Exception.IXplusException;
import com.eds.intrada.IntradaServer.BusinessObject.Common.CustomerBO;
import com.eds.intrada.IntradaServer.BusinessObject.Common.FilterView;
import com.eds.intrada.IntradaServer.BusinessObject.Common.IntradaBusinessObjectBase;
import com.eds.intrada.IntradaServer.BusinessObject.Common.IntradaOrderBO;
import com.eds.intrada.IntradaServer.BusinessObject.Common.IntradaOrderSearchResponseRBO;
import com.eds.intrada.IntradaServer.BusinessObject.Common.OrderLogBO;
import com.eds.intrada.IntradaServer.BusinessObject.Common.StatusRBO;
import com.eds.intrada.IntradaServer.BusinessObject.Common.UserBO;
import com.eds.intrada.IntradaServer.BusinessObject.Server.FilterHelper;
import com.eds.intrada.IntradaServer.BusinessObject.Server.FilterableByCustomer;
import com.eds.intrada.IntradaServer.BusinessObject.Server.FilterableIntradaOrderSearchResponseRBO;
import com.eds.intrada.IntradaServer.BusinessProcess.GARMFilter.GARMFilterProcessor;
import com.eds.intrada.IntradaServer.DataAccess.Mapper.CustomerMapper;
import com.eds.intrada.IntradaServer.DataAccess.Mapper.IntradaOrderMapper;
import com.eds.intrada.IntradaServer.DataAccess.Mapper.OrderLogMapper;
import com.eds.intrada.IntradaServer.DataAccess.Mapper.StatusMapper;
import com.eds.intrada.IntradaServer.DataAccess.Mapper.UserMapper;
import com.eds.intrada.IntradaServer.Exception.IntradaDBException;
import com.verizon.iprom.commons.logging.AppLogger;
import com.verizon.iprom.orders.constants.OrderConstants;
import com.verizon.iprom.orders.entity.CanceledReasonEntity;
import com.verizon.iprom.orders.entity.CenterEntity;
import com.verizon.iprom.orders.entity.GenericCodeEntity;
import com.verizon.iprom.orders.entity.LocalOrderEntity;
import com.verizon.iprom.orders.entity.OrderEntity;
import com.verizon.iprom.orders.entity.SalesRepEntity;
import com.verizon.iprom.orders.model.CancelOrderRequest;
import com.verizon.iprom.orders.model.CancelOrderResponse;
import com.verizon.iprom.orders.model.CustomerDetails;
import com.verizon.iprom.orders.model.GenericCode;
import com.verizon.iprom.orders.model.IntradaOrderDetails;
import com.verizon.iprom.orders.model.LocalOrder;
import com.verizon.iprom.orders.model.SalesRepDetails;
import com.verizon.iprom.orders.model.ViewOrderReponse;
import com.verizon.iprom.orders.repository.CanceledReasonRepository;
import com.verizon.iprom.orders.repository.CenterRepository;
import com.verizon.iprom.orders.repository.GenericCodeRepository;
import com.verizon.iprom.orders.repository.LocalOrderRepository;
import com.verizon.iprom.orders.repository.OrderRepository;
import com.verizon.iprom.orders.repository.SalesRepRepository;



/**
 * OrderService Implementation
 * This class is also responsible for converting Domain entities to DTOs 
 *
 */
@Service
@Validated
@Transactional
public class OrderServiceImpl implements OrderService {
	
	/**
	 * The number of times the findIntradaOrderByIntradaOrderId Methods have
	 * been called
	 */
	private long findIntradaOrderByIntradaOrderIdCount = 0;
    private static final AppLogger LOGGER = new AppLogger(OrderServiceImpl.class);
    
   /* @Autowired
    private LocalOrderRepository localOrderRepository;
    
    @Autowired
    private GenericCodeRepository genericCodeRepository;
    
    @Autowired
    CenterRepository centerRepository;
    
    @Autowired
    SalesRepRepository salesRepRepository;
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    CanceledReasonRepository canceledReasonRepository;*/
    
//    @Override
//    public ViewOrderReponse getIntradaOrder(int orderIdParm)
//    {
//        ViewOrderReponse viewOrderReponse = new ViewOrderReponse();
//        
//        IntradaOrderDetails intradaOrderDetails = new IntradaOrderDetails();
//        OrderEntity orderEntity = orderRepository.getOrderById(new BigInteger(orderIdParm+""));
//        CenterEntity centerEntity = null;
//        if(orderEntity.getSubTypeCode() != null && !(orderEntity.getSubTypeCode().isEmpty())) {
//        	intradaOrderDetails.setOrderType(genericCodeRepository.findDescription(OrderConstants.ORDER_TYPE_CODE_TYPE, orderEntity.getSubTypeCode()));
//        	intradaOrderDetails.setOrderTypeCode(orderEntity.getSubTypeCode());
//        }
//        if(orderEntity.getCenterId() != null) {
//        	centerEntity = centerRepository.getCenterById(orderEntity.getCenterId()+"");
//        }
//        intradaOrderDetails.setOrderName(orderEntity.getOrderName());
//        intradaOrderDetails.setBillingSys(orderEntity.getIdxbilSys());
//        intradaOrderDetails.setCanceled(orderEntity.getCancelled());
//        if(centerEntity != null) {
//        	intradaOrderDetails.setCenter(centerEntity.getCenterDescription());
//        	intradaOrderDetails.setCenterId(new Integer(centerEntity.getCenterId()));
//        }
//        if(orderEntity.getDocument() != null && !orderEntity.getDocument().trim().isEmpty()) {
//        	intradaOrderDetails.setServiceType(genericCodeRepository.findDescription(OrderConstants.SERVICE_CODE_TYPE, orderEntity.getDocument().trim()));
//        }
//       	intradaOrderDetails.setServiceTypeId((orderEntity.getDocument().trim()));
//        intradaOrderDetails.setProjectNumber(orderEntity.getProjectNbr());
//        intradaOrderDetails.setReferredTo(orderEntity.getReferredTo());
//        intradaOrderDetails.setSalesRepId(orderEntity.getSalesRepId());
//        intradaOrderDetails.setTin(orderEntity.getTin());
//        intradaOrderDetails.setVersion(orderEntity.getTinVersion());
//
//        CustomerDetails customerDetails = new CustomerDetails();
//        customerDetails.setCustomerName("Beckey");
//        customerDetails.setContactName("Beckey Renolds");
//        customerDetails.setContactPhone("(0835) 888 - 9999");
//        customerDetails.setAlternatePhone("");
//        
//        List<LocalOrderEntity>  localOrderEntities = localOrderRepository.getByOrderId(orderIdParm);
//        
//        List<LocalOrder> localOrders = new ArrayList<>();
//        String[] strings = {"true", "false"};
//        for (LocalOrderEntity localOrderEntity: localOrderEntities)
//        {
//            LocalOrder localOrder = new LocalOrder();
//            localOrder.setLocalOrderNum(localOrderEntity.getLocalOrderNum());
//            //localOrder.setIsLockedToUser("true");
//            localOrder.setIsLockedToUser(strings[(new Random()).nextInt(strings.length)]);
//            String lockedUserName = localOrderEntity.getLockedUserName();
//            lockedUserName = lockedUserName!=null?lockedUserName:"";
//            localOrder.setLockedUserName(lockedUserName);
//            localOrder.setLocalOrderStatus(localOrderEntity.getLocalOrderStatus());
//            //localOrder.setIsBillingLock("true");
//            localOrder.setIsBillingLock(strings[(new Random()).nextInt(strings.length)]);
//            localOrder.setBillingStatus("OE");
//            localOrder.setOrderAction(localOrderEntity.getOrderAction());
//            localOrder.setProduct(localOrderEntity.getProduct());
//            localOrder.setVersion(localOrderEntity.getVersion());
//            DateFormat dateFormat = new SimpleDateFormat("yyyy MM / dd");
//            String formattedDate = dateFormat.format(localOrderEntity.getCDDD());
//            localOrder.setCDDD(formattedDate);
//            
//            localOrders.add(localOrder);
//        }
//        
//        viewOrderReponse.setIntradaOrderDetails(intradaOrderDetails);
//        viewOrderReponse.setCustomerDetails(customerDetails);
//        viewOrderReponse.setLocalOrders(localOrders);
//        
//        return viewOrderReponse;
//    }

    /***************************************************************************
    Format an IntradaOrderSearchResponseRBO instance that has an Intrada Order
    Id matching the aIntradaOrderId parameter.

    <p>Preconditions:   None.</p>

    <p>Postconditions:  None.</p>

    @param      aIntradaOrderId  Intrada Order Id to use when querying the
                                 database.

                                 <p>
    @param      userId           DOCUMENT ME!

    @return     IntradaOrderSearchResponseRBO object with the given Intrada
                Order Id.  This object will be empty if no
                IntradaOrderSearchResponseRBO exists with the given Intrada
                Order Id.

                <p>

    @exception  IntradaDBException        Thrown when the Intrada Order Id
                                          parameter is null or thrown by the
                                          associated Mapper(s).
    @exception  ValidationException       Thrown if any database error are
                                          encountered.
    @exception  java.rmi.RemoteException  Thrown if any problems are encountered
                                          with RMI communications.
    @exception  NoRowsException           Thrown if no row is found for the
                                          passed primary key value(s).

                                          <p>

    @see        com.eds.intrada.IntradaServer.DataAccess.Mapper.IntradaOrderMapper#inflate
    ***************************************************************************/
    public FilterView<IntradaOrderSearchResponseRBO> findIntradaOrderByIntradaOrderId(
        Long aIntradaOrderId, String userId)
        
            
    {
        final String METHOD_NAME = "findIntradaOrderByIntradaOrderId()";

        FilterView<IntradaOrderSearchResponseRBO> filterResult = null;  //Aldea 153213 - GARM

        // Set success flag to false
        boolean successFlag = false;

        // Increment statistics for this service
        incrementFindIntradaOrderByIntradaOrderIdCount();

        try
        {
            // Begin the Service
          //  beginService(METHOD_NAME);

            // Get the Intrada Order BO for the supplied key
            IntradaOrderBO aIntradaOrderBO = IntradaOrderMapper.inflate(aIntradaOrderId);

            // put the single IntradaOrderBO on an array
            IntradaOrderBO[] foundBOs = { aIntradaOrderBO };

            // allocate a return array for the format method
            IntradaOrderSearchResponseRBO[] newIOSResponseBOs = null;

            // invoke format method
            newIOSResponseBOs = formatSearchResponseBO(foundBOs);

            // Since 8.3 GARM - Apply GARM Filter proccess
            filterResult = performGARMFilter(newIOSResponseBOs, userId);

            //  Set the success flag to true
            successFlag = true;
        }
        catch (NoRowsException e)
        {
         e.printStackTrace();
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
        catch (IntradaDBException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        finally
        {
            // Key fields for informational message
            String identifier = "order_id = " + aIntradaOrderId + " user_id =" + userId;

            //  End the service
          //  endService(successFlag, identifier, METHOD_NAME, filterResult);
        }

        return filterResult;
    }
    
    
    /***************************************************************************
    Common routine to format the IntradaOrderSearchResponseRBO for the array of
    Intrada Order BOs passed into the routine.

    <p>Preconditions:   None.</p>

    <p>Postconditions:  None.</p>

    @param      passedBOs  The Array containing the IntradaOrderBOs to use.

                           <p>

    @return     An array of IntradaOrderSearchResponseRBO objects which have the
                given Intrada Order Id.  This object will be empty if no
                IntradaOrderSearchResponseRBO exists with the given Intrada
                Order Id.

                <p>

    @exception  IntradaDBException   Thrown when no rows with the specified key
                                     are found.
    @exception  ValidationException  Thrown when the Intrada Order Id parameter
                                     is null.
    @exception  NoRowsException      Thrown when a database error is
                                     encountered.

                                     <p>

    @see        com.eds.intrada.IntradaServer.DataAccess.Mapper.OrderLogMapper#findByIntradaOrderId
    @see        com.eds.intrada.IntradaServer.DataAccess.Mapper.StatusMapper#inflate
    @see        com.eds.intrada.IntradaServer.DataAccess.Mapper.CustomerMapper#inflate
    ***************************************************************************/
    private IntradaOrderSearchResponseRBO[] formatSearchResponseBO(
        IntradaOrderBO[] passedBOs)
        throws IntradaDBException,
            ValidationException,
            NoRowsException
    {
        IntradaOrderSearchResponseRBO[] formattedBOs = null;
        OrderLogBO[] aOrderLogBOs = null;
        int j;
        int k = 0;

        // allocate array to return
        formattedBOs = new IntradaOrderSearchResponseRBO[passedBOs.length];

        // interate through intrada Order BOs
        for (j = 0; j < formattedBOs.length; j++)
        {
            // initialize control variables
            String foundUserId = null;
            Long foundStatusId = new Long(0);
            Long theIntradaOrderId = passedBOs[j].getIntradaOrderId();

            // initialize the formattedBO element
            formattedBOs[j] = new IntradaOrderSearchResponseRBO();

            // get/set Search Response BO data
            formattedBOs[j].setBillingSystemId(passedBOs[j].getBillingSystemId());  //131801
            formattedBOs[j].setIntradaOrderId(theIntradaOrderId);
            formattedBOs[j].setOrderName(passedBOs[j].getOrderName());
            formattedBOs[j].setRelatedOrderId(passedBOs[j].getRelatedOrderId());//164818

            // Get array of OrderLogBO
            aOrderLogBOs = OrderLogMapper.findByIntradaOrderId(theIntradaOrderId,
                    IntradaBusinessObjectBase.FULL_COPY);

            int arrayLength = aOrderLogBOs.length;

            // Set up loop to obtain Order Log BO info
            for (k = 0; k < arrayLength; k++)
            {
                // retrieve Status Date and User Id from the Order Log BO array
                if (aOrderLogBOs[k].getStatusId().equals(passedBOs[j].getStatusId()))
                {
                    formattedBOs[j].setCurrentStatusDate(aOrderLogBOs[k]
                        .getDateUpdated());
                    foundUserId = (aOrderLogBOs[k].getUserId());
                    foundStatusId = (aOrderLogBOs[k].getStatusId());

                    break;
                }
            }

            // get StatusRBO for the status from the Order Log BO
            if (foundStatusId != null)
            {
                StatusRBO newStatusRBO = StatusMapper.inflate(foundStatusId);
                formattedBOs[j].setCurrentStatus(newStatusRBO.getStatusDescription());
                formattedBOs[j].setCurrentStatusTeam(newStatusRBO.getTeam());
            }

            // get UserBO for the UserId from the Order Log BO
            if (foundUserId != null)
            {
                // set Current Status User
                formattedBOs[j].setUserId(foundUserId);
            }

            // get CustomerBO for the CustomerId from the Intrada Order BO
            if (passedBOs[j].getCustomerId() != null)
            {
                CustomerBO newCustomerBO = CustomerMapper.inflate(passedBOs[j]
                        .getCustomerId());
                formattedBOs[j].setCustomerName(newCustomerBO.getCustomerName());
                formattedBOs[j].setAccountNumber(newCustomerBO.getAccountNumber());
                formattedBOs[j].setEnvironmentNumber(newCustomerBO
                    .getEnvironmentNumber());
            }
        }

        return formattedBOs;
    }


    /***************************************************************************
    Increment the number of times the findIntradaOrderByIntradaOrderId Method
    has been called.

    <p>Preconditions:   None</p>

    <p>Postconditions:  The findIntradaOrderByIntradaOrderIdCount variable is
    incremented</p>
    ***************************************************************************/
    private synchronized void incrementFindIntradaOrderByIntradaOrderIdCount()
    {
        findIntradaOrderByIntradaOrderIdCount++;
    }
    
    
    /***************************************************************************
    This method creates a FilterView<IntradaOrderSearchResponseRBO> after to:
    <br>
    - Instantiate a UserBO to obtain his approvalLevel.<br>
    - Apply GARMFilter proccess to IntradaOrderSearchResponseRBO[] passed as
    parameter.<br>

    <p>Postconditions: None.</p>

    @param      foundRBOsArray  Array containing a collection of
                                IntradaOrderSearchResponseRBO to be filtered by
                                GARMFilter
    @param      userId          User' ID who is logged in into IPro Client

    @return     FilterView<IntradaOrderSearchResponseRBO> Generic class
                containing all Intrada Orders that meet the search criteria and
                Flag indicating if SensivityLevel filter was applied.

                <p>If no match is found, an empty array will be returned.

    @throws     IXplusException      DOCUMENT ME!
    @exception  ValidationException  Thrown for missing or invalid parameters or
                                     other non database errors.
    @exception  Exception            Thrown when a database error is
                                     encountered.
    ***************************************************************************/
    private static FilterView<IntradaOrderSearchResponseRBO> performGARMFilter(
        IntradaOrderSearchResponseRBO[] foundRBOsArray, String userId)
        throws IXplusException,
            ValidationException,
            Exception
    {
        FilterView<IntradaOrderSearchResponseRBO> filterApplied = null;

        //Aldea 153213 - GARM
        UserBO userBO = UserMapper.inflate(userId);
        String approvalLevel = userBO.getGarmApprovalLevel();

        // Create a FilterHelper to allow use the method to convertions
        FilterHelper<IntradaOrderSearchResponseRBO> intradaOrderSearchResponseRBOFilterHelper =  
        	new FilterHelper<IntradaOrderSearchResponseRBO>();
        
        //Create RBO Helper objects from the foundBOs - Aldea 153213 - GARM
        FilterableByCustomer[] foundFilterables = 
        	intradaOrderSearchResponseRBOFilterHelper.createFilterableList(
        			foundRBOsArray, FilterableIntradaOrderSearchResponseRBO.FULL_CLASS_NAME, IntradaOrderSearchResponseRBO.FULL_CLASS_NAME);
     
        boolean e2Ei=false;
        try{
		for (int i = 0; i < foundFilterables.length; i++) {
			if (foundFilterables[i].getCustomerId() != null) {
				CustomerBO requestBO = CustomerMapper
						.inflate(foundFilterables[i].getCustomerId());
				if ("PBR".equals(requestBO.getBillingSystemId())) {
					e2Ei = true;
					break;
				}
			}
		}}catch(Exception e){}


        
        
        //Filter out the filterables that are not approved - Aldea 153213 - GARM
        FilterableByCustomer[] filteredFilterables = GARMFilterProcessor.applyGARMFilter(
                foundFilterables, approvalLevel);

        //Set the filtered orderBOs in the result - Aldea 153213 - GARM
        filterApplied = new FilterView<IntradaOrderSearchResponseRBO>();
        filterApplied.setList(intradaOrderSearchResponseRBOFilterHelper.createBOList(
        		filteredFilterables, IntradaOrderSearchResponseRBO.FULL_CLASS_NAME));
        
        boolean isFiltered = filteredFilterables.length < foundRBOsArray.length;

        filterApplied.setFilterFlag(isFiltered);

        if(e2Ei)
        	filterApplied.setE2Eiflag(true);

		MessageLogger.write(MessageLogger.MESSAGE_LEVEL_MIN,
                "xxx",
                "Perform GARM",
                "Last filterResult is"+filterApplied.isFiltered());

        return filterApplied;
    }



//	@Override
//	public List<GenericCode> getGenericCodes(String codeType) throws Exception {
//		LOGGER.debug("Start of method getGenericCodes");
//		List<GenericCodeEntity> genericCodes = genericCodeRepository.findGenericCodeByCodeType(codeType);
//		List<GenericCode> generiCodesList = new ArrayList<>();
//		for (GenericCodeEntity genericCodeEntity : genericCodes) {
//			GenericCode genericCode = new GenericCode();
//			genericCode.setCode(genericCodeEntity.getCode());
//			genericCode.setDesc(genericCodeEntity.getDescription());
//			generiCodesList.add(genericCode);
//		}
//		LOGGER.debug("End of method getGenericCodes");
//		return generiCodesList;
//	}
//
//
//	@Override
//	public List<GenericCode> getCenters() throws Exception {
//		LOGGER.debug("Start of method getCenters");
//		List<CenterEntity> centers = centerRepository.findActiveCenters();
//		List<GenericCode> generiCodesList = new ArrayList<>();
//		for (CenterEntity centerEntity : centers) {
//			GenericCode genericCode = new GenericCode();
//			genericCode.setCode(centerEntity.getCenterId());
//			genericCode.setDesc(centerEntity.getCenterDescription());
//			generiCodesList.add(genericCode);
//		}
//		LOGGER.debug("End of method getCenters");
//		return generiCodesList;
//	}
//
//
//	@Override
//	public List<SalesRepDetails> getSalesRepDetails() throws Exception {
//		LOGGER.debug("Start of method getSalesRepDetails");
//		List<SalesRepEntity> salesRepEntities = salesRepRepository.getSalesRepDetails();
//		List<SalesRepDetails> salesRepDetails = new ArrayList<>();
//		for(SalesRepEntity salesRepEntity : salesRepEntities) {
//			SalesRepDetails salesRepDetail = new SalesRepDetails();
//			salesRepDetail.setBranchId(salesRepEntity.getBranchId());
//			salesRepDetail.setSalesRepFax(salesRepEntity.getSalesRepFax());
//			salesRepDetail.setSalesRepId(salesRepEntity.getSalesRepId());
//			salesRepDetail.setSalesRepName(salesRepEntity.getSalesRepName());
//			salesRepDetail.setSalesRepPhone(salesRepEntity.getSalesRepPhone());
//			salesRepDetail.setSalesRepType(salesRepEntity.getSalesRepType());
//			salesRepDetails.add(salesRepDetail);
//		}
//		LOGGER.debug("End of method getSalesRepDetails");
//		return salesRepDetails;
//	}
//
//
//	@Override
//	public BigInteger createOrder(IntradaOrderDetails intradaOrderDetails) throws Exception {
//		LOGGER.debug("Start of method createOrder");
//		BigInteger seqNo = orderRepository.getNextOrderId(); 
//		OrderEntity orderEntity = new OrderEntity();
//		BigInteger orderId = seqNo.add(new BigInteger("1"));
//		orderEntity.setOrderId(orderId);
//		orderEntity.setCenterId(intradaOrderDetails.getCenterId());
//		orderEntity.setDocument(intradaOrderDetails.getServiceTypeId().trim());
//		orderEntity.setIdxbilSys(intradaOrderDetails.getBillingSys());
//		orderEntity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
//		orderEntity.setSubTypeCode(intradaOrderDetails.getOrderTypeCode());
//		orderEntity.setTin(intradaOrderDetails.getTin());
//		orderEntity.setProjectNbr(intradaOrderDetails.getProjectNumber());
//		orderEntity.setReferredTo(intradaOrderDetails.getReferredTo());
//		orderEntity.setSalesRepId(intradaOrderDetails.getSalesRepId());
//		orderEntity.setMasterAccountNumber(intradaOrderDetails.getAccountName());
//		orderEntity.setOrderName(intradaOrderDetails.getOrderName());
//		orderEntity.setTinVersion(intradaOrderDetails.getVersion());
//		orderEntity.setCancelled("N");
//		orderEntity.setManualTinflag("Y");
//		orderEntity.setLastUpdateUser("sanlop25");
//		LOGGER.debug("End of method createOrder");
//		orderRepository.save(orderEntity);
//		return orderId;
//	}
//
//
//	@Override
//	public List<GenericCode> getCanceledReasons() throws Exception {
//		LOGGER.debug("Start of method getCanceledReasons");
//		Iterable<CanceledReasonEntity> canceledReasonEntities = canceledReasonRepository.findAll();
//		List<GenericCode> canceledResons = new ArrayList<>();
//		for(CanceledReasonEntity canceledReasonEntity : canceledReasonEntities) {
//			GenericCode canceledReason = new GenericCode();
//			canceledReason.setCode(canceledReasonEntity.getCanceledReasonCode()+"");
//			canceledReason.setDesc(canceledReasonEntity.getCanceledDescription());
//			canceledResons.add(canceledReason);
//		}
//		LOGGER.debug("End of method getCanceledReasons");
//		return canceledResons;
//	}
//
//
//	@Override
//	public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) throws Exception {
//		LOGGER.debug("Start of method cancelOrder");
//		CancelOrderResponse cancelOrderResponse = new CancelOrderResponse();
//		OrderEntity orderEntity = orderRepository.getOrderById(cancelOrderRequest.getOrderId());
//		if(orderEntity == null) {
//			cancelOrderResponse.setErrorMessage("Order does not exists");
//			cancelOrderResponse.setStatus(OrderConstants.FAILURE);
//			cancelOrderResponse.setStatus(OrderConstants.FAILURE_RESPONSE_CODE);
//			return cancelOrderResponse;
//		}
//		orderEntity.setCancelled("Y");
//		orderEntity.setCancelledReasonCode(cancelOrderRequest.getCanceledReasonCode());
//		orderRepository.save(orderEntity);
//		cancelOrderResponse.setCancelReason(canceledReasonRepository.getCanceledReasonDescription(new BigInteger(cancelOrderRequest.getCanceledReasonCode()+"")));
//		cancelOrderResponse.setOrderId(orderEntity.getOrderId());
//		cancelOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
//		cancelOrderResponse.setStatus(OrderConstants.SUCCESS);
//		LOGGER.debug("End of method cancelOrder");
//		return cancelOrderResponse;
//	}
//
//
//	@Override
//	public void modifyOrder(IntradaOrderDetails intradaOrderDetails) throws Exception {
//		LOGGER.debug("Start of method modifyOrder");
//		OrderEntity orderEntity = orderRepository.getOrderById(intradaOrderDetails.getOrderId());
//		orderEntity.setCenterId(intradaOrderDetails.getCenterId());
//		orderEntity.setDocument(intradaOrderDetails.getServiceTypeId().trim());
//		orderEntity.setIdxbilSys(intradaOrderDetails.getBillingSys());
//		orderEntity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
//		orderEntity.setSubTypeCode(intradaOrderDetails.getOrderTypeCode());
//		orderEntity.setTin(intradaOrderDetails.getTin());
//		orderEntity.setProjectNbr(intradaOrderDetails.getProjectNumber());
//		orderEntity.setReferredTo(intradaOrderDetails.getReferredTo());
//		orderEntity.setSalesRepId(intradaOrderDetails.getSalesRepId());
//		orderEntity.setMasterAccountNumber(intradaOrderDetails.getAccountName());
//		orderEntity.setOrderName(intradaOrderDetails.getOrderName());
//		orderEntity.setTinVersion(intradaOrderDetails.getVersion());
//		orderRepository.save(orderEntity);
//		LOGGER.debug("End of method modifyOrder");
//	}
}
