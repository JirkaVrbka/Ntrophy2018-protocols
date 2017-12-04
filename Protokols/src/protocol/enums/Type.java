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
public enum Type {
    SHIP ("Ship"),
    PLANET ("Planet"),
    ASTEROID ("Asteroid"),
    UNDEFINED ("Undefined");
    
    String name;
    
    Type(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
