/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.Action;
import protocol.exceptions.InvalidActionException;

/**
 *
 * @author Ondrej Urbanovsky
 */
public interface Object {
    /**
     * evaluates action on this object
     * @param action enum value of what to do
     * @return points gained -3 up to +3
     * @throws InvalidActionException
     */
    int doAction(Action action) throws InvalidActionException;
    
}
