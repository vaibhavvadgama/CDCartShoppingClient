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
 */
public class CartModel {

    OrderProcessWS_Service serviceReference = null;
    OrderProcessWS webServicePort = null;

    public CartModel() {
        if (serviceReference == null) {
            serviceReference = new OrderProcessWS_Service();
            webServicePort = serviceReference.getOrderProcessWSPort();
        }
    }

    public OrderProcessWS getServicePort() {
        if (serviceReference == null) {
            serviceReference = new OrderProcessWS_Service();
            webServicePort = serviceReference.getOrderProcessWSPort();
        }
        return webServicePort;
    }

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
}
