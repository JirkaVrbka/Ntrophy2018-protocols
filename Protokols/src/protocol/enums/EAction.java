/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.enums;

/**
 *
 * @author Ondrej Urbanovsky
 */
public enum EAction {
    SHOOT ("Shoot"), 
    GATHER_RESOURCES ("Gather resources"), 
    CONTACT ("Contact"), 
    FLYBY ("Fly by"), 
    ESCAPE ("Escape"), 
    TRADE ("Trade");
    
    String name;
    
    EAction(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    /**
     *
     * @param name
     * @return
     */
    public static EAction getValueOf(String name){
        if(name == null){
            return null;
        }
        
        switch(name){
            case "Shoot":
                return SHOOT;
            case "Gather resources":
                return GATHER_RESOURCES;
            case "Contact":
                return CONTACT;
            case "Fly by":
                return FLYBY;
            case "Escape":
                return ESCAPE;
            case "Trade":
                return TRADE;
            default:
                   return null;
        }
    }
}
