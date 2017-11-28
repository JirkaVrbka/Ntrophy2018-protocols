/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.protocols.exceptions;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class InvalidObjectException extends Exception{

    public InvalidObjectException() {
    }

    public InvalidObjectException(String message) {
        super(message);
    }
    
}
