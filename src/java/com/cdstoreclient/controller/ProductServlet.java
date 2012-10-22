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
    
    ProductModel objPm = new ProductModel();

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
        String forward = "";
        //On the  basis of action variable passed with get request it loads the relavent page and it also acts as front controller too
        String action = request.getParameter("action");

        PrintWriter out = response.getWriter();

        

        SessionController objSession = new SessionController(request);

        request.setAttribute("user", objSession.getLoggedUser());
        //Show all available cd categories on website
        if (action.equalsIgnoreCase("showcategories")) {

            forward = ServletMappings.HomePage;
            ArrayList<CategoryBean> categories = null;

            try {
                categories = objPm.getCategoryList();
            } catch (Exception e) {
                out.print("Error fetching categoeries" + e);
            }

            request.setAttribute("categories", categories);

        }
        //Show all the cds(products) associated with passed or provided category id on website
        else if (action.equalsIgnoreCase("showproducts")) {

            int categoryId = Integer.parseInt(request.getParameter("catid"));
            ArrayList<CdBean> products = null;
            try {
                products = objPm.getProductList(categoryId);
            } catch (Exception e) {
                out.print("Error fetching products" + e);
            }
            forward = ServletMappings.LISTPRODUCTS;

            request.setAttribute("products", products);

        } 
        //Show product info of passed or provided product id
        else if (action.equalsIgnoreCase("showproductinfo")) {

            forward = ServletMappings.PRODUCTINFO;

            int productId = Integer.parseInt(request.getParameter("prodId"));

            CdBean proddata = null;

            try {
                proddata = objPm.getProductInfo(productId);
            } catch (Exception e) {
                out.print("Error fetching products" + e);
            }
            request.setAttribute("proddata", proddata);

        } 
        //show error page in case of unknown request
        else {

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

    public CdBean findProductById(int id, ArrayList<CdBean> Product) {
        for (int i = 0; i < Product.size(); i++) {
            CdBean product = Product.get(i);
            if (product.getCdId() == id) {
                return product;
            }
        }
        return null; // no Customer found with this ID; maybe throw an exception
    }
}
