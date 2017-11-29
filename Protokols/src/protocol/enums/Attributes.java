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
public enum Attributes {
    LIFE ("Life"),
    COMUNICATES ("Comunicates"), 
    RESOURCES ("Resources"), 
    BIGGER ("Bigger"), 
    WEAPONS ("Weapons"), 
    ACT_WEAPON ("Active weapons"), 
    FAST ("Fast");
    
    String name;
    
    Attributes(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
