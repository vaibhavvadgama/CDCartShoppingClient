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
 * Desc:functions to call user related web service using rpc approach
 */
public class UserModel {
    
    static {
	    //for localhost testing only
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    new javax.net.ssl.HostnameVerifier(){
 
                @Override
	        public boolean verify(String hostname,
	                javax.net.ssl.SSLSession sslSession) {
	            return true;
	        }
	    });
	}

    AccountProcessingWS_Service serviceReference = null;
    AccountProcessingWS webServicePort = null;
    
    
    public UserModel() {
        if(serviceReference == null) {
            serviceReference = new AccountProcessingWS_Service();
            webServicePort = serviceReference.getAccountProcessingWSPort();
        }
    }
    
    //Getting service port
    public AccountProcessingWS getServicePort() {
        if(serviceReference == null) {
            serviceReference = new AccountProcessingWS_Service();
            webServicePort = serviceReference.getAccountProcessingWSPort();
        }
        return webServicePort;
    }
    //Calling create user account webservice with provided user info
    public UserBean createUser(UserBean newUserInfo) throws CDCartException {
        UserBean serviceResponseObject = webServicePort.addUser(newUserInfo);
        
        if(serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
           
                return serviceResponseObject;
            
        }
    }
    
    //Calling get user account(Information) webservice with provided username and password
    public UserBean getUserInfo(String username, String password) throws CDCartException {
        UserBean serviceResponseObject = webServicePort.getUserInfo(username, password);
        
        if(serviceResponseObject == null) {
            throw new CDCartException(404, "Web service unavailable.");
        } else {
            
                return serviceResponseObject;
            
        }
    }
    //Getting user address from provided user id
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
