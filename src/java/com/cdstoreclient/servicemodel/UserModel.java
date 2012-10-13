/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel;

import com.cdstoreserver.ws.accountprocessing.AccountProcessingWS;
import com.cdstoreserver.ws.accountprocessing.AccountProcessingWS_Service;
import com.cdstoreserver.ws.accountprocessing.UserBean;
import com.cdstoreserver.ws.accountprocessing.UserList;

/**
 *
 * @author Vaibhav
 */
public class UserModel {

    AccountProcessingWS_Service serviceReference = null;
    AccountProcessingWS webServicePort = null;
    
    public UserModel() {
        if(serviceReference == null) {
            serviceReference = new AccountProcessingWS_Service();
            webServicePort = serviceReference.getAccountProcessingWSPort();
        }
    }
    
    public AccountProcessingWS getServicePort() {
        if(serviceReference == null) {
            serviceReference = new AccountProcessingWS_Service();
            webServicePort = serviceReference.getAccountProcessingWSPort();
        }
        return webServicePort;
    }
    
    public UserBean createUser(UserBean newUserInfo) {
        UserBean createdUser = null;
        
        createdUser = getServicePort().addUser(newUserInfo);
        
        return createdUser;
    }
    
}
