/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel;

import com.cdstoreserver.ws.productcatalog.CategoryList;
import com.cdstoreserver.ws.productcatalog.CdList;
import com.cdstoreserver.ws.productcatalog.ProductCatalogWS;
import com.cdstoreserver.ws.productcatalog.ProductCatalogWS_Service;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;

/**
 *
 * @author Vaibhav
 */
public class ProductModel {

    public ProductModel() {
    }
    
    public CategoryList getCategoryList() {
        CategoryList list = null;
        
        ProductCatalogWS_Service serviceReference = new ProductCatalogWS_Service();
        ProductCatalogWS webServicePort = serviceReference.getProductCatalogWSPort();
        
        webServicePort.getCategoryList();
        
        return list;
    }
    
}
