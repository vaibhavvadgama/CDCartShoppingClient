/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.controller;

import com.cdstoreclient.ServletMappings;
import com.cdstoreclient.servicemodel.CartModel;
import com.cdstoreclient.servicemodel.UserModel;
import com.cdstoreserver.ws.accountprocessing.AddressBean;
import com.cdstoreserver.ws.accountprocessing.UserBean;
import com.cdstoreserver.ws.orderprocess.CdBean;
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
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    UserModel objUser = new UserModel();
        
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
        
        String forward = "";
        //On the  basis of action variable passed with get request it loads the relavent page
        String action = request.getParameter("action");

        PrintWriter out = response.getWriter();

        

        ArrayList<AddressBean> address = null;
        //Creating session controller object
        SessionController objSession = new SessionController(request);
        
        //Checking if user is logged in or not
        if (objSession.isUserLoggedIn()) {

            //If action is equal to logout destroy current logged in user's session
            if (action.equalsIgnoreCase("logout")) {
                objSession.destroySession();
                forward = ServletMappings.USERLOGIN;
            } else {
            //Display user account with cart items
                //Getting cart items and total price of cds
                ArrayList<CdBean> cartItems = objSession.getCartItems();
                double totalprice = objCm.getTotalPrice(cartItems);
                request.setAttribute("totalprice", totalprice);
                request.setAttribute("cartItems", cartItems);
                forward = ServletMappings.ACCOUNT;
                UserBean user = objSession.getLoggedUser();
                int userId = user.getUserId();
                try {
                    //Get user addresses
                    address = objUser.getUserAddresses(userId);
                } catch (Exception ex) {
                    out.print("Error fetching user address" + ex);
                }
                request.setAttribute("user", user);

            }

        } else {
            //Display user login form
            if (action.equalsIgnoreCase("userlogin")) {


                forward = ServletMappings.USERLOGIN;


            } 
            //Display new user registration form
            else if (action.equalsIgnoreCase("userregister")) {

                forward = ServletMappings.USERREGISTER;

            } 
            //Display error page if action doesn't match with anything at all
            else {

                forward = ServletMappings.ERROR;

            }

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
        
        String forward = "";
        
        //On the  basis of action variable passed as hidden field value it loads the relavent page
        String action = request.getParameter("action");

        PrintWriter out = response.getWriter();

        UserBean user = new UserBean();

        UserBean returnUser = null;

        ArrayList<AddressBean> address = null;

        SessionController objSession = new SessionController(request);
        
        CartModel objCm = new CartModel();
        //If action is login and username and password is post as form data validate user
        if (action.equalsIgnoreCase("login")) {

            user.setEmail(request.getParameter("email"));

            user.setPassword(request.getParameter("pass"));


            try {
                //Check if combination of username and password exists or not
                returnUser = objUser.getUserInfo(user.getEmail(), user.getPassword());
            } catch (Exception e) {
                out.print("Error fetching userinfo" + e);
            }
            int userId = returnUser.getUserId();
            //If user exists then get his/her address and show account page otherwise show error message on userlogin page
            if (userId != 0) {
                try {
                    address = objUser.getUserAddresses(userId);
                } catch (Exception ex) {
                    out.print("Error fetching user address" + ex);
                }
                objSession.setLoggedUser(returnUser);
                request.setAttribute("user", returnUser);
                request.setAttribute("address", address);
                ArrayList<CdBean> cartItems = objSession.getCartItems();
                double totalprice = objCm.getTotalPrice(cartItems);
                request.setAttribute("totalprice", totalprice);
                request.setAttribute("cartItems", cartItems);
                forward = ServletMappings.ACCOUNT;
            } else {
                request.setAttribute("error", "Username and Password combination doen't match");
                forward = ServletMappings.USERLOGIN;
            }

        }  //If action is register then get new user registration values and register him on website
           else if (action.equalsIgnoreCase("register")) {

            UserBean newuser = new UserBean();
            newuser.setFirstName(request.getParameter("firstName"));
            newuser.setLastName(request.getParameter("lastName"));
            newuser.setEmail(request.getParameter("email"));
            newuser.setPassword(request.getParameter("pass"));

            try {
                returnUser = objUser.createUser(newuser);
            } catch (Exception e) {
                out.print("Error creating user" + e);
            }
            int userId = returnUser.getUserId();
            //If user registration is successful the show user account page with his provided info 
            //Otherwise if user is already registered show error on user registartion page
            if (userId != 0) {
                newuser.setUserId(userId);
                forward = ServletMappings.ACCOUNT;
                request.setAttribute("user", newuser);
                request.setAttribute("address", "");
                ArrayList<CdBean> cartItems = objSession.getCartItems();
                double totalprice = objCm.getTotalPrice(cartItems);
                request.setAttribute("totalprice", totalprice);
                request.setAttribute("cartItems", cartItems);
                objSession.setLoggedUser(newuser);

            } 
              else {
                request.setAttribute("error", "Username already exists");
                forward = ServletMappings.USERREGISTER;
            }
        //In case of unidentified action show error page
        } else {

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
