/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 13, 2018
 */

package com.verizon.iprom.orders.rest;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eds.intrada.IntradaServer.BusinessObject.Common.FilterView;
import com.eds.intrada.IntradaServer.BusinessObject.Common.IntradaOrderSearchResponseRBO;
import com.verizon.iprom.commons.logging.AppLogger;
import com.verizon.iprom.commons.rest.RestConfig;
import com.verizon.iprom.orders.constants.OrderConstants;
import com.verizon.iprom.orders.model.CancelOrderRequest;
import com.verizon.iprom.orders.model.CancelOrderResponse;
import com.verizon.iprom.orders.model.CreateOrderRequest;
import com.verizon.iprom.orders.model.CreateOrderResponse;
import com.verizon.iprom.orders.model.GenericCode;
import com.verizon.iprom.orders.model.ModifyOrderResponse;
import com.verizon.iprom.orders.model.SalesRepDetails;
import com.verizon.iprom.orders.model.ViewOrderReponse;
import com.verizon.iprom.orders.service.OrderService;

/**
 * OrderController
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(RestConfig.BASE_PATH)
public class OrderController {
	
    private static final AppLogger LOGGER = new AppLogger(OrderController.class);
    
	@Autowired
	private OrderService orderService;
		
	
    @GetMapping("/orders/intrada-orders/v1/{order-id}")
    public ResponseEntity<FilterView<IntradaOrderSearchResponseRBO>> findIntradaOrderByIntradaOrderId(@PathVariable("order-id")  String orderId) {
        LOGGER.debug("getIntradaOrder: orderId", orderId);
        FilterView<IntradaOrderSearchResponseRBO> viewOrderReponse = orderService.findIntradaOrderByIntradaOrderId(Long.valueOf(orderId),"sanlop25");
        return new ResponseEntity< FilterView<IntradaOrderSearchResponseRBO>>(viewOrderReponse, HttpStatus.OK);
    }
	
	
	/*@GetMapping("/orders/intrada-orders/v1/{order-id}")
    public ResponseEntity<ViewOrderReponse> getIntradaOrder(@PathVariable("order-id") int orderId) {
        LOGGER.debug("getIntradaOrder: orderId", orderId);
        ViewOrderReponse viewOrderReponse = orderService.getIntradaOrder(orderId);
        return new ResponseEntity<>(viewOrderReponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/service-types/v1")
    public ResponseEntity<CreateOrderResponse> getServiceTypes() {
    	CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        LOGGER.debug("Start of getServiceTypes");
        try {
			List<GenericCode> serviceTypes = orderService.getGenericCodes(OrderConstants.SERVICE_CODE_TYPE);
			createOrderResponse.setServiceTypes(serviceTypes);
			createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			createOrderResponse.setErrorMessage(e.getMessage());
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getServiceTypes");
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/billing-systems/v1")
    public ResponseEntity<CreateOrderResponse> getBillingSystems() {
    	CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        LOGGER.debug("Start of getBillingSystems");
        try {
			List<GenericCode> billingSystems = orderService.getGenericCodes(OrderConstants.BILLING_SYSTEM_CODE_TYPE);
			createOrderResponse.setBillingSystems(billingSystems);
			createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			createOrderResponse.setErrorMessage(e.getMessage());
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getBillingSystems");
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/order-types/v1")
    public ResponseEntity<CreateOrderResponse> getOrderTypes() {
    	CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        LOGGER.debug("Start of getOrderTypes");
        try {
			List<GenericCode> orderTypes = orderService.getGenericCodes(OrderConstants.ORDER_TYPE_CODE_TYPE);
			createOrderResponse.setOrderTypes(orderTypes);
			createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			createOrderResponse.setErrorMessage(e.getMessage());
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getOrderTypes");
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/centers/v1")
    public ResponseEntity<CreateOrderResponse> getCenters() {
    	CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        LOGGER.debug("Start of getCenters");
        try {
			List<GenericCode> centers = orderService.getCenters();
			createOrderResponse.setCenters(centers);
			createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			createOrderResponse.setErrorMessage(e.getMessage());
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getCenters");
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/salesreps/v1")
    public ResponseEntity<CreateOrderResponse> getSalesRepDetails() {
    	CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        LOGGER.debug("Start of getSalesRepDetails");
        try {
			List<SalesRepDetails> salesRepDetails = orderService.getSalesRepDetails();
			createOrderResponse.setSalesRepDetails(salesRepDetails);
			createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			createOrderResponse.setErrorMessage(e.getMessage());
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getSalesRepDetails");
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/init-data/v1")
    public ResponseEntity<CreateOrderResponse> getInitData() {
    	CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        LOGGER.debug("Start of getInitData");
        try {
			List<GenericCode> serviceTypes = orderService.getGenericCodes(OrderConstants.SERVICE_CODE_TYPE);
			List<GenericCode> billingSystems = orderService.getGenericCodes(OrderConstants.BILLING_SYSTEM_CODE_TYPE);
			List<GenericCode> orderTypes = orderService.getGenericCodes(OrderConstants.ORDER_TYPE_CODE_TYPE);
			List<GenericCode> centers = orderService.getCenters();
			List<SalesRepDetails> salesRepDetails = orderService.getSalesRepDetails();
			createOrderResponse.setServiceTypes(serviceTypes);
			createOrderResponse.setCenters(centers);
			createOrderResponse.setOrderTypes(orderTypes);
			createOrderResponse.setSalesRepDetails(salesRepDetails);
			createOrderResponse.setBillingSystems(billingSystems);
			createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			createOrderResponse.setErrorMessage(e.getMessage());
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getInitData");
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @PostMapping(value = "/orders/intrada-orders/create-order/v1")
    public ResponseEntity<CreateOrderResponse> persistOrder(@RequestBody CreateOrderRequest createOrderRequest){
		CreateOrderResponse createOrderResponse = new CreateOrderResponse();
		try {
			if (createOrderRequest.getIntradaOrder() != null) {
				BigInteger orderId = orderService.createOrder(createOrderRequest.getIntradaOrder());
				createOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
				createOrderResponse.setStatus(OrderConstants.SUCCESS);
				createOrderResponse.setOrderId(orderId);
			} else {
				createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
				createOrderResponse.setStatus(OrderConstants.FAILURE);
				createOrderResponse.setErrorMessage("Request is Empty!");
			}
		} catch (Exception ex) {
			createOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			createOrderResponse.setStatus(OrderConstants.FAILURE);
			createOrderResponse.setErrorMessage(ex.getMessage());
			LOGGER.debug(OrderConstants.EXCEPTION + ":" + ex.getMessage());
		}
    	return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }
    
    @GetMapping("/orders/intrada-orders/canceled-reasons/v1")
    public ResponseEntity<CancelOrderResponse> getCanceledReasons() {
    	CancelOrderResponse cancelOrderResponse = new CancelOrderResponse();
        LOGGER.debug("Start of getCanceledReasons");
        try {
			List<GenericCode> canceledReasons = orderService.getCanceledReasons();
			cancelOrderResponse.setCanceledReasons(canceledReasons);
			cancelOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
			cancelOrderResponse.setStatus(OrderConstants.SUCCESS);
		} catch (Exception e) {
			cancelOrderResponse.setErrorMessage(e.getMessage());
			cancelOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			cancelOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
		}
        LOGGER.debug("End of getCanceledReasons");
        return new ResponseEntity<>(cancelOrderResponse, HttpStatus.OK);
    }
    
    @PostMapping("/orders/intrada-orders/cancel-order/v1")
    public ResponseEntity<CancelOrderResponse> cancelOrder(@RequestBody CancelOrderRequest cancelOrderRequest){
    	LOGGER.debug("Start of cancelOrder");
    	CancelOrderResponse cancelOrderResponse = new CancelOrderResponse();
    	try {
    		cancelOrderResponse = orderService.cancelOrder(cancelOrderRequest);
    	}catch(Exception e) {
    		cancelOrderResponse.setErrorMessage(e.getMessage());
			cancelOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			cancelOrderResponse.setStatus(OrderConstants.FAILURE);
			LOGGER.debug(OrderConstants.EXCEPTION +":"+ e.getMessage());
    	}
    	LOGGER.debug("End of cancelOrder");
    	return new ResponseEntity<>(cancelOrderResponse, HttpStatus.OK);
    }
    
    @PutMapping(value = "/orders/intrada-orders/modify-order/v1")
    public ResponseEntity<ModifyOrderResponse> modifyOrder(@RequestBody CreateOrderRequest createOrderRequest){
    	LOGGER.debug("Start of modifyOrder");
    	ModifyOrderResponse modifyOrderResponse = new ModifyOrderResponse();
		try {
			if (createOrderRequest.getIntradaOrder() != null) {
				orderService.modifyOrder(createOrderRequest.getIntradaOrder());
				modifyOrderResponse.setResponseCode(OrderConstants.SUCCESS_RESPONSE_CODE);
				modifyOrderResponse.setStatus(OrderConstants.SUCCESS);
			} else {
				modifyOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
				modifyOrderResponse.setStatus(OrderConstants.FAILURE);
				modifyOrderResponse.setErrorMessage("Request is Empty!");
			}
		} catch (Exception ex) {
			modifyOrderResponse.setResponseCode(OrderConstants.FAILURE_RESPONSE_CODE);
			modifyOrderResponse.setStatus(OrderConstants.FAILURE);
			modifyOrderResponse.setErrorMessage(ex.getMessage());
			LOGGER.debug(OrderConstants.EXCEPTION + ":" + ex.getMessage());
		}
		LOGGER.debug("End of modifyOrder");
    	return new ResponseEntity<>(modifyOrderResponse, HttpStatus.OK);
    }*/

}
