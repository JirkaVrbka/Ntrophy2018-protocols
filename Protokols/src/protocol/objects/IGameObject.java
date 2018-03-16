/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import java.util.List;
import protocol.enums.EType;
import protocol.enums.EAction;
import protocol.enums.EAttributes;
import protocol.enums.EAttributeStates;
import protocol.exceptions.InvalidActionException;

/**
 *
 * @author Ondrej Urbanovsky
 */
public interface IGameObject {
    /**
     * evaluates action on this object
     * @param action enum value of what to do
     * @return points gained -3 up to +3
     * @throws InvalidActionException
     */
    int doAction(EAction action);
   
    boolean isLife(); 

    boolean isComunicates();

    boolean isResources();

    boolean isBigger();
             
    boolean isWeapons();
     
    boolean isActWeapons();
     
    boolean isFast();
    
    EType getType();
    
    EType getGivenType();
        
    String getName();
    
    List<EAttributes> getTrueAttr();
    
    public List<EAttributes> getMissingAttr();
    
    public List<EAttributes> getFalseAttr();
    
    int getID();
    
    public EAttributeStates getLife();

    public EAttributeStates getComunicates();

    public EAttributeStates getResources();

    public EAttributeStates getBigger();

    public EAttributeStates getWeapons();

    public EAttributeStates getActWeapons();

    public EAttributeStates getFast();
}
