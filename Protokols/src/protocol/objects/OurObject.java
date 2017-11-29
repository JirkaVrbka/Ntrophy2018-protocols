/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.Type;
import protocol.enums.Action;
import protocol.exceptions.InvalidActionException;

/**
 *
 * @author Ondrej Urbanovsky
 */
public interface OurObject {
    /**
     * evaluates action on this object
     * @param action enum value of what to do
     * @return points gained -3 up to +3
     * @throws InvalidActionException
     */
    int doAction(Action action) throws InvalidActionException;
   
    boolean isLife(); 

    boolean isComunicates();

    boolean isResources();

    boolean isBigger();
             
    boolean isWeapons();
     
    boolean isActWeapons();
     
    boolean isFast();
    
    Type getType();
    
    void setName(String name);
    
    String getName();
     
}
