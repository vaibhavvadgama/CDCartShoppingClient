/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel.driver;

import com.cdstoreclient.SystemLogger;
import com.cdstoreclient.servicemodel.ProductModel;
import com.cdstoreserver.ws.productcatalog.CategoryBean;
import com.cdstoreserver.ws.productcatalog.CategoryList;
import com.cdstoreserver.ws.productcatalog.CdBean;
import com.cdstoreserver.ws.productcatalog.CdList;

/**
 *
 * @author Vaibhav
 */
public class ProductModelDriver {

    public static void main(String[] args) {
        ProductModelDriver driver = new ProductModelDriver();

        driver.testgetCategoryList();
        driver.testGetProductList(1);
        driver.testGetProductInfo(1);
    }

    public void testgetCategoryList() {
        ProductModel model = new ProductModel();
        CategoryList list = null;
        try {
            list = model.getCategoryList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Check 1");
        if (list != null) {
            System.out.println("Check 2");
            if (list.getCategory() != null) {
                System.out.println("Size : " + list.getCategory().size());
                for (CategoryBean category : list.getCategory()) {
                    SystemLogger.out(category.getCategoryName());
                }
            }
        }
    }

    public void testGetProductList(int categoryNo) {
        ProductModel model = new ProductModel();
        CdList list = null;
        try {
            list = model.getProductList(categoryNo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Check 1");
        if (list != null) {
            System.out.println("Check 2");
            if (list.getCd() != null) {
                System.out.println("Size : " + list.getCd().size());
                for (CdBean cdBean : list.getCd()) {
                    SystemLogger.out("CDId : " + cdBean.getCdId() + ", Title : " + cdBean.getCdTitle());
                }
            }
        }
    }

    public void testGetProductInfo(int productNo) {
        ProductModel model = new ProductModel();
        CdBean cdBean = null;
        try {
            cdBean = model.getProductInfo(productNo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Check 1");
        if (cdBean != null) {
            SystemLogger.out("CDId : " + cdBean.getCdId() + ", Title : " + cdBean.getCdTitle());
        }
    }
}
