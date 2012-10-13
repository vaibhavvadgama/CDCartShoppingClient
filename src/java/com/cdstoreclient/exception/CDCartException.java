/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreclient.exception;

/**
 *
 * @author Vaibhav
 */
public class CDCartException extends Exception {
    
    public int exceptionCode;
    public String exceptionMessage;

    public CDCartException(int exceptionCode, String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }
    
    @Override
    public String toString() {
        return exceptionMessage;
    }
    
}
