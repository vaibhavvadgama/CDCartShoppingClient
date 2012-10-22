/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.controller;

import com.cdstoreserver.ws.accountprocessing.UserBean;
import com.cdstoreserver.ws.orderprocess.CdBean;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vaibhav
 * class to manage various session functions
 */
public class SessionController {

    HttpServletRequest pageRequest = null;
    HttpSession session = null;
    public final String KEY_USERINFO = "KEY_USERINFO";
    public final String KEY_CARTITEMS = "KEY_CARTITEMS";

    public SessionController(HttpServletRequest httpRequest) {
        this.pageRequest = httpRequest;
        session = httpRequest.getSession();
    }
    /*
     * Param: none
     * Return: session object
     * Desc: function to get http session object
     * 
     */
    public HttpSession getSession() {
        if (session == null) {
            
            session = pageRequest.getSession();
        }
        return session;
    }
    
    /*
     * Param: userbean
     * Return: none
     * Desc: function to set current user in session
     * 
     */
    public void setLoggedUser(UserBean userInfo) {
        session.setAttribute(KEY_USERINFO,userInfo);
    }
    
    /*
     * Param: none
     * Return: none
     * Desc: function to clear cart after order is processed
     * 
     */
    public void clearItems() {
        getSession().setAttribute(KEY_CARTITEMS, new ArrayList<CdBean>());
    }
    
    /*
     * Param: none
     * Return: none
     * Desc: function to get current logged in user
     * 
     */
    public UserBean getLoggedUser() {
        getSession();
        return (UserBean) session.getAttribute(KEY_USERINFO);
    }
    
    /*
     * Param: none
     * Return: boolean
     * Desc: function to get if user is logged in or not
     * 
     */
    public boolean isUserLoggedIn() {
        UserBean loggedUser = null;
        boolean exception = false;
        if (session != null) {
            try {
                loggedUser = (UserBean) session.getAttribute(KEY_USERINFO);
            } catch (Exception ex) {
                exception = true;
                ex.printStackTrace();
            }
            if (loggedUser == null || exception == true) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    
    /*
     * Param: arraylist cdbean
     * Return: cart item
     * Desc: function to add cart items in session
     * 
     */
    public ArrayList<CdBean> setCartItems(ArrayList<CdBean> cartItems) {
        getSession().setAttribute(KEY_CARTITEMS, cartItems);
        return getCartItems();
    }
   /*
     * Param: none
     * Return: cart items
     * Desc: function to get cart items in session
     * 
     */
    public ArrayList<CdBean> getCartItems() {
        ArrayList<CdBean> cartItems = (ArrayList<CdBean>) getSession().getAttribute(KEY_CARTITEMS);
        return cartItems;
    }
    
    /*
     * Param: cdbean
     * Return: list of cds in cart
     * Desc: function to add single items in session(cart)
     * 
     */
    public ArrayList<CdBean> addToCart(CdBean newItem) {
        ArrayList<CdBean> currentCart = getCartItems();
        if (currentCart == null) {
            currentCart = new ArrayList<CdBean>();
        }
        currentCart.add(newItem);
        setCartItems(currentCart);

        currentCart = getCartItems();
        return currentCart;
    }
    
    /*
     * Param: cdbean
     * Return: current cart
     * Desc: function to remove cdbean from cart
     * 
     */
    public ArrayList<CdBean> removeItemFromCart(CdBean itemToRemove) {
        int searchItemId = itemToRemove.getCdId();

        ArrayList<CdBean> currentCart = removeItemFromCart(searchItemId);

        return currentCart;
    }
   
    /*
     * Param: cdid
     * Return: current cart
     * Desc: function to remove cdbean from cart by cd id
     * 
     */
    public ArrayList<CdBean> removeItemFromCart(int itemId) {
        ArrayList<CdBean> currentCart = getCartItems();

        if (currentCart == null) {
            currentCart = new ArrayList<CdBean>();
            return currentCart;
        }

        int indexToDelete = -1;
        for (int i = 0; i < currentCart.size(); i++) {
            if (currentCart.get(i).getCdId() == itemId) {
                indexToDelete = i;
                break;
            }
        }
        currentCart.remove(indexToDelete);
        setCartItems(currentCart);
        
        return currentCart;
    }
    
   /*
     * Param: none
     * Return: none
     * Desc: function to destroy current user session or say logout
     * 
     */
   public void destroySession(){
        
        session.setAttribute(KEY_USERINFO,"");
    }
}
