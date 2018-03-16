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
public enum EAttributes {
    LIFE ("Life"),
    COMUNICATES ("Communicates"), 
    RESOURCES ("Resources"), 
    BIGGER ("Bigger"), 
    WEAPONS ("Weapons"), 
    ACT_WEAPON ("Active_weapons"), 
    FAST ("Fast");
    
    String name;
    
    EAttributes(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    public static EAttributes toEnum (String name){
        for (EAttributes attr : EAttributes.values()) {
            if (name.equals(attr.name)) {
                return attr;
            }
        }
        return null;
    }
    
    public static EAttributes getValueOf(String name){
        if(name == null ){
            return null;
        }
        switch(name){
            case "Life":
                return LIFE;
            case "Communicates":
                return COMUNICATES;
            case "Resources":
                return RESOURCES;
            case "Bigger":
                return BIGGER;
            case "Weapons":
                return WEAPONS;
            case "Active_weapons":
                return ACT_WEAPON;
            case "Fast":
                return FAST;
            default:
                   return null;
        }
    }
}
