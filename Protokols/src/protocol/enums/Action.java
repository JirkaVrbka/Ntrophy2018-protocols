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
public enum Action {
    SHOOT ("Shoot"), 
    GATHER_RESOURCES ("Gather resources"), 
    CONTACT ("Contact"), 
    FLYBY ("Fly by"), 
    ESCAPE ("Escape"), 
    TRADE ("Trade");
    
    String name;
    
    Action(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
