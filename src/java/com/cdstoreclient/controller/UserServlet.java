/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.controller;

import com.cdstoreclient.ServletMappings;
import com.cdstoreclient.servicemodel.UserModel;
import com.cdstoreserver.ws.accountprocessing.AddressBean;
import com.cdstoreserver.ws.accountprocessing.UserBean;
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
 * @author Vaibhav
 */
public class UserServlet extends HttpServlet {

    
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
         
        
        if (action.equalsIgnoreCase("userlogin")){  
  
            forward = ServletMappings.USERLOGIN;
            
  
        } else if (action.equalsIgnoreCase("userregister")){  
  
            forward = ServletMappings.USERREGISTER;
  
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
        String forward="";  
  
        String action = request.getParameter("action");
        
        PrintWriter out = response.getWriter();
        
        UserModel objUser = new UserModel(); 
        
        UserBean user = new UserBean();
        
        UserBean returnUser = null;
        
        ArrayList<AddressBean> address = null;
        
        if (action.equalsIgnoreCase("login")){  
  
            forward = ServletMappings.ACCOUNT;
            
            user.setEmail(request.getParameter("email"));
            
            user.setPassword(request.getParameter("pass"));                    
            
            
            try {
                returnUser = objUser.getUserInfo(user.getEmail(),user.getPassword());
            } catch (Exception e){
                out.print("Error fetching userinfo"+ e);
            }
            int userId = returnUser.getUserId();
            
            try {
                address = objUser.getUserAddresses(userId);
            } catch (Exception ex){
                out.print("Error fetching user address"+ ex);
            }
            request.setAttribute("user",returnUser);
            request.setAttribute("address",address);
  
        } else if (action.equalsIgnoreCase("register")){  
  
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("pass"));
            user.setCardNumber(request.getParameter("cardNum"));
            user.setCardType(request.getParameter("cardType"));
            user.setCvv(Integer.parseInt(request.getParameter("cardCvv")));
            user.setExpDate(request.getParameter("cardDate"));
            try {
             returnUser = objUser.createUser(user);
            } catch (Exception e){
                out.print("Error creating user"+ e);
            }
            forward = ServletMappings.ACCOUNT;  
  
            request.setAttribute("user", user);
            request.setAttribute("address","");
  
        }  else {  
  
            forward = ServletMappings.ERROR;  
  
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
