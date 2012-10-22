/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel;

import com.cdstoreclient.exception.CDCartException;
import com.cdstoreserver.ws.orderprocess.AddressBean;
import com.cdstoreserver.ws.orderprocess.CdBean;
import com.cdstoreserver.ws.orderprocess.OrderProcessWS;
import com.cdstoreserver.ws.orderprocess.OrderProcessWS_Service;
import com.cdstoreserver.ws.orderprocess.ProcessedOrdersBean;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 * Desc:functions to call order related web service using rpc approach
 */
public class CartModel {
    
    static {
	    //for localhost testing only
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    new javax.net.ssl.HostnameVerifier(){
 
                @Override
	        public boolean verify(String hostname,
	                javax.net.ssl.SSLSession sslSession) {
	            return true;
	        }
	    });
	}

    OrderProcessWS_Service serviceReference = null;
    OrderProcessWS webServicePort = null;

    public CartModel() {
        if (serviceReference == null) {
            serviceReference = new OrderProcessWS_Service();
            webServicePort = serviceReference.getOrderProcessWSPort();
        }
    }
   //Getting service port
    public OrderProcessWS getServicePort() {
        if (serviceReference == null) {
            serviceReference = new OrderProcessWS_Service();
            webServicePort = serviceReference.getOrderProcessWSPort();
        }
        return webServicePort;
    }
   
    //Calling createorder webservice by passing orderitems and shipping info
    public ProcessedOrdersBean createOrder(ArrayList<CdBean> orderItems, AddressBean shippingInfo) throws CDCartException {
        ProcessedOrdersBean serviceResponseObject = webServicePort.createOrder(orderItems, shippingInfo);

        if (serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            if (!serviceResponseObject.getStatus().equals("success")) {
                throw new CDCartException(404, serviceResponseObject.getErrormessage());
            } else {
                return serviceResponseObject;
            }
        }
    }
    
    
    //Calling confirmorder webservice by passing orderinfo and payment info
    public ProcessedOrdersBean confirmOrder(ProcessedOrdersBean purchasedOrder, Boolean paymentInfo) throws CDCartException {
        ProcessedOrdersBean serviceResponseObject = webServicePort.confirmOrder(purchasedOrder, paymentInfo);

        if (serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            if (!serviceResponseObject.getStatus().equals("success")) {
                throw new CDCartException(404, serviceResponseObject.getErrormessage());
            } else {
                return serviceResponseObject;
            }
        }
    }
    
     public static double getTotalPrice(ArrayList<CdBean> Product){
        double price = 0;
        for (int i=0; i<Product.size(); i++) {
                CdBean product = Product.get(i);
                double productPrice = product.getCdPrice();
                double taxPer = product.getTaxPer();
                price = price + productPrice  + ((productPrice*taxPer)/100);            
        }
            return price; 
    }

    
}
