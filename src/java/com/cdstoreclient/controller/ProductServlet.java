/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.controller;

import com.cdstoreclient.ServletMappings;
import com.cdstoreclient.servicemodel.ProductModel;
import com.cdstoreserver.ws.productcatalog.CategoryBean;
import com.cdstoreserver.ws.productcatalog.CdBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Utkarsh
 */
public class ProductServlet extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";  
  
        String action = request.getParameter("action");
        
        PrintWriter out = response.getWriter();
        
        ProductModel objPm = new ProductModel();
        
        if (action.equalsIgnoreCase("showcategories")){  
  
            forward = ServletMappings.HomePage;
            ArrayList<CategoryBean> categories = null;
            
            try {
                categories = objPm.getCategoryList(); 
            } catch (Exception e){
                out.print("Error fetching categoeries"+ e);
            }
  
            request.setAttribute("categories", categories);
  
        } else if (action.equalsIgnoreCase("showproducts")){  
  
           int categoryId = Integer.parseInt(request.getParameter("catid"));
           ArrayList<CdBean> products = null;
            try {
            products = objPm.getProductList(categoryId);
            } catch (Exception e){
                out.print("Error fetching products"+ e);
            }
            forward = ServletMappings.LIST_PRODUCTS;  
  
            request.setAttribute("products", products);     
  
        } else if (action.equalsIgnoreCase("showproductinfo")){  
  
            forward = ServletMappings.PRODUCTINFO;  
  
            int productId = Integer.parseInt(request.getParameter("prodId"));  
            
            CdBean proddata = null;
            
            try {
                proddata = objPm.getProductInfo(productId);  
            } catch (Exception e){
                out.print("Error fetching products"+ e);
            }
            request.setAttribute("proddata", proddata); 
  
        }  else {  
  
            forward = ServletMappings.ERROR;  
  
        }  
  
  
  
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
