/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.servicemodel;

import com.cdstoreclient.exception.CDCartException;
import com.cdstoreserver.ws.accountprocessing.AccountProcessingWS;
import com.cdstoreserver.ws.accountprocessing.AccountProcessingWS_Service;
import com.cdstoreserver.ws.accountprocessing.AddressBean;
import com.cdstoreserver.ws.accountprocessing.AddressList;
import com.cdstoreserver.ws.accountprocessing.UserBean;
import java.util.ArrayList;

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
    
    public UserBean createUser(UserBean newUserInfo) throws CDCartException {
        UserBean serviceResponseObject = webServicePort.addUser(newUserInfo);
        
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
    
    public UserBean getUserInfo(String username, String password) throws CDCartException {
        UserBean serviceResponseObject = webServicePort.getUserInfo(username, password);
        
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
    
    public ArrayList<AddressBean> getUserAddresses(int userId) throws CDCartException {
        AddressList serviceResponseObject = webServicePort.getUserAddresses(userId);
        
        ArrayList<AddressBean> addressList = new ArrayList<AddressBean>();
        
        if(serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            if(!serviceResponseObject.getStatus().equals("success")) {
                throw new CDCartException(404, serviceResponseObject.getErrormessage());
            } else {
                for(AddressBean addressBean : serviceResponseObject.getAddress()) {
                    addressList.add(addressBean);
                }
                return addressList;
            }
        }
    }
    
}
