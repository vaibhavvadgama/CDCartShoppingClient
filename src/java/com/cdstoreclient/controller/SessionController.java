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

    public HttpSession getSession() {
        if (session == null) {
            session = pageRequest.getSession();
        }
        return session;
    }

    public void setLoggedUser(UserBean userInfo) {
        session.setAttribute(KEY_USERINFO, userInfo);
    }

    public UserBean getLoggedUser() {
        getSession();
        return (UserBean) session.getAttribute(KEY_USERINFO);
    }

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

    public ArrayList<CdBean> setCartItems(ArrayList<CdBean> cartItems) {
        getSession().setAttribute(KEY_CARTITEMS, cartItems);
        return getCartItems();
    }

    public ArrayList<CdBean> getCartItems() {
        ArrayList<CdBean> cartItems = (ArrayList<CdBean>) getSession().getAttribute(KEY_CARTITEMS);
        return cartItems;
    }

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

    public ArrayList<CdBean> removeItemFromCart(CdBean itemToRemove) {
        int searchItemId = itemToRemove.getCdId();

        ArrayList<CdBean> currentCart = removeItemFromCart(searchItemId);

        return currentCart;
    }

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
}
