/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel;

import com.cdstoreclient.exception.CDCartException;
import com.cdstoreserver.ws.productcatalog.CategoryBean;
import com.cdstoreserver.ws.productcatalog.CategoryList;
import com.cdstoreserver.ws.productcatalog.CdBean;
import com.cdstoreserver.ws.productcatalog.CdList;
import com.cdstoreserver.ws.productcatalog.ProductCatalogWS;
import com.cdstoreserver.ws.productcatalog.ProductCatalogWS_Service;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class ProductModel {
    
    ProductCatalogWS_Service serviceReference = null;
    ProductCatalogWS webServicePort = null;

    public ProductModel() {
        if(serviceReference == null) {
            serviceReference = new ProductCatalogWS_Service();
            webServicePort = serviceReference.getProductCatalogWSPort();
        }
    }
    
    public ProductCatalogWS getServicePort() {
        if(serviceReference == null) {
            serviceReference = new ProductCatalogWS_Service();
            webServicePort = serviceReference.getProductCatalogWSPort();
        }
        return webServicePort;
    }
    
    public ArrayList<CategoryBean> getCategoryList() throws CDCartException {
        CategoryList serviceResponseObject = webServicePort.getCategoryList();
        ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
        
        if(serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            if(!serviceResponseObject.getStatus().equals("success")) {
                throw new CDCartException(404, serviceResponseObject.getErrormessage());
            } else {
                for(CategoryBean categoryBean : serviceResponseObject.getCategory()) {
                    categoryList.add(categoryBean);
                }
                return categoryList;
            }
        }
    }
    
    public CdBean getProductInfo(int productId) throws CDCartException {
        CdBean serviceResponseObject = webServicePort.getProductInfo(productId);
        
        if(serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            if(!serviceResponseObject.getStatus().equals("success")) {
                throw new CDCartException(404, serviceResponseObject.getErrormessage());
            } else {
                return serviceResponseObject;
            }
        }
    }
    
    public ArrayList<CdBean> getProductList(int categoryId) throws CDCartException {
        CdList serviceResponseObject = webServicePort.getProductList(categoryId);
        ArrayList<CdBean> cdList = new ArrayList<CdBean>();
        
        if(serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            if(!serviceResponseObject.getStatus().equals("success")) {
                throw new CDCartException(404, serviceResponseObject.getErrormessage());
            } else {
                for(CdBean cdBean : serviceResponseObject.getCd()) {
                    cdList.add(cdBean);
                }
                return cdList;
            }
        }
    }
    
}
