/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.controller;

import com.cdstoreclient.ServletMappings;
import com.cdstoreclient.servicemodel.CartModel;
import com.cdstoreserver.ws.orderprocess.AddressBean;
import com.cdstoreserver.ws.orderprocess.CdBean;
import com.cdstoreserver.ws.orderprocess.ProcessedOrdersBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Utkarsh
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    
    CartModel objCm = new CartModel();

   

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
        //On the  basis of action variable passed with get request it loads the relavent page
        String action = request.getParameter("action");     
        
        SessionController objSession = new SessionController(request);
        request.setAttribute("user",objSession.getLoggedUser());
        
        //Remove item from the user cart if requested
        if (action.equalsIgnoreCase("removeitem")){  
           forward = ServletMappings.USERCART;
           int cdId = Integer.parseInt(request.getParameter("cdid"));
           objSession.removeItemFromCart(cdId);
           ArrayList<CdBean> cartItems = objSession.getCartItems(); 
           request.setAttribute("items",cartItems.size());
           double totalprice = objCm.getTotalPrice(cartItems);
           request.setAttribute("totalprice", totalprice);
           request.setAttribute("cartItems", cartItems);
  
        } 
        //Show error page if unknown action
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
        String forward="";  
        
        //On the  basis of action variable passed as hidden field value it loads the relavent page
        String action = request.getParameter("action");
        
        PrintWriter out = response.getWriter();
        
        
        
        SessionController objSession = new SessionController(request);
        
        request.setAttribute("user",objSession.getLoggedUser());
        
        //Adding item to the cart if additem action is requested
        if(action.equalsIgnoreCase("additem")){
            
                 forward = ServletMappings.USERCART;
                 CdBean product = new CdBean();
                 product.setCdId(Integer.parseInt(request.getParameter("id")));
                 product.setCdImage(request.getParameter("image"));
                 product.setCdPrice(Double.parseDouble(request.getParameter("price")));
                 product.setCdTitle(request.getParameter("title"));
                 product.setTaxPer(Double.parseDouble(request.getParameter("taxper")));
                 product.setCategoryId(Integer.parseInt(request.getParameter("cat_id")));            
                 objSession.addToCart(product);            
                 ArrayList<CdBean> cartItems = objSession.getCartItems();
                 request.setAttribute("items",cartItems.size());
                 double totalprice = objCm.getTotalPrice(cartItems);
                 request.setAttribute("totalprice", totalprice);
                 request.setAttribute("cartItems", cartItems);

        } 
          //Check if user is logged in a session or not
          else if(objSession.isUserLoggedIn()){
            
            //checkout user for order and show form to ask address and payment info
            if (action.equalsIgnoreCase("checkout")){ 
                
                    request.setAttribute("userId",request.getParameter("userid"));
                    forward = ServletMappings.CHECKOUT;

            } 
            //Add order and order items and on the basis of provide payment info process order
            else if (action.equalsIgnoreCase("confirmorder")){  

                
                forward = ServletMappings.CONFIRMORDER;           

                Boolean payment = Boolean.parseBoolean(request.getParameter("payment"));

                ArrayList<CdBean> cartItems = objSession.getCartItems(); 
                request.setAttribute("items",cartItems.size());
                AddressBean address = new AddressBean();

                address.setAddressType(request.getParameter("addrtype"));
                address.setCity(request.getParameter("city"));
                address.setPhone(request.getParameter("phone"));
                address.setState(request.getParameter("state"));
                address.setStreetName(request.getParameter("streetname"));
                address.setStreetNo(request.getParameter("streetno"));
                address.setZip(request.getParameter("zip"));
                address.setUserId(Integer.parseInt(request.getParameter("userid")));
                ProcessedOrdersBean orderData = new ProcessedOrdersBean();
                
                
               
                try {
                    orderData = objCm.createOrder(cartItems,address);
                } catch (Exception e) {
                    out.print("Error creating order"+ e);
                }
                try {
                    objCm.confirmOrder(orderData,payment);
                } catch (Exception ex) {                
                    out.print("Error confirming orders"+ ex);                
                }     
                
                
                objSession.clearItems();
                
                request.setAttribute("payment",""+payment);

            } 
        } //Other wise show user login page if user is not logged and requests for checkout or confirm order
          else {
            
             
                forward = ServletMappings.USERLOGIN;
              

        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
