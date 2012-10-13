/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel;

import com.cdstoreserver.ws.orderprocess.OrderProcessWS;
import com.cdstoreserver.ws.orderprocess.OrderProcessWS_Service;


/**
 *
 * @author Vaibhav
 */
public class CartModel {

    OrderProcessWS_Service serviceReference = null;
    OrderProcessWS webServicePort = null;
    
    public CartModel() {
        if(serviceReference == null) {
            serviceReference = new OrderProcessWS_Service();
            webServicePort = serviceReference.getOrderProcessWSPort();
        }
    }
    
    public OrderProcessWS getServicePort() {
        if(serviceReference == null) {
            serviceReference = new OrderProcessWS_Service();
            webServicePort = serviceReference.getOrderProcessWSPort();
        }
        return webServicePort;
    }
    
//    public CategoryList getCategoryList() {
//        CategoryList list = null;
//        
//        ProductCatalogWS_Service serviceReference = new ProductCatalogWS_Service();
//        ProductCatalogWS webServicePort = serviceReference.getProductCatalogWSPort();
//        
//        list = webServicePort.getCategoryList();
//        
//        return list;
//    }
    
}
