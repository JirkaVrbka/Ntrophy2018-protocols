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
public enum EType {
    SHIP ("Ship"),
    PLANET ("Planet"),
    ASTEROID ("Asteroid"),
    UNDEFINED ("I don`t care");
    
    String name;
    
    EType(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public static EType get(String pattern){
        if(pattern.equals(EType.SHIP.toString())){
            return SHIP;
        }
        
        if(pattern.equals(EType.PLANET.toString())){
            return PLANET;
        }
        
        if(pattern.equals(EType.ASTEROID.toString())){
            return ASTEROID;
        }
        
        if(pattern.equals(EType.UNDEFINED.toString())){
            return UNDEFINED;
        }
        
        return null;
    }
}
