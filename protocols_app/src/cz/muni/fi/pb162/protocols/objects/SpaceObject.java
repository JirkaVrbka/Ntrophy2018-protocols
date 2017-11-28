/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.protocols.objects;

import cz.muni.fi.pb162.protocols.Action;
import cz.muni.fi.pb162.protocols.Attributes;
import cz.muni.fi.pb162.protocols.exceptions.InvalidActionException;
import cz.muni.fi.pb162.protocols.exceptions.InvalidObjectException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ondrej Urbanovsky
 */
public abstract class SpaceObject implements Object{
    private boolean life;
    private boolean comunicates;
    private boolean resources;
    private boolean bigger;
    private boolean weapons;
    private boolean actWeapons;
    private boolean fast;
    private List <Attributes> missing;
    
    
    public SpaceObject(List <Attributes> attrs, List <Attributes> missing) 
            throws InvalidObjectException{
        this.missing = missing;
        for (Attributes attr : attrs) {
            switch (attr){
                case LIFE: {
                    life = true;
                    break;
                }
                case COMUNICATES:{
                    comunicates = true;
                    break;
                }
                case BIGGER: {
                    bigger = true;
                    break;
                }
                case ACT_WEAPON:{
                    actWeapons = true;
                    break;
                }
                case WEAPONS:{
                    weapons = true;
                    break;
                }
                case RESOURCES:{
                    resources = true;
                    break;
                }
                case FAST: {
                    fast = true;
                    break;
                }
                
            }
            if (actWeapons && !weapons){
                throw new InvalidObjectException();
            }
        }
    }

    
    
    public boolean isLife() {
        return life;
    }

    public boolean isComunicates() {
        return comunicates;
    }

    public boolean isResources() {
        return resources;
    }

    public boolean isBigger() {
        return bigger;
    }

    public boolean isWeapons() {
        return weapons;
    }

    public boolean isActWeapons() {
        return actWeapons;
    }

    public List<Attributes> getMissing() {
        return missing;
    }

    public boolean isFast() {
        return fast;
    }
    
    public boolean unfriendly() throws InvalidActionException{
        if (isLife() && isWeapons() && isActWeapons()){
            return true;
        }
        if (!isLife() && isWeapons() && isComunicates()){
            if(missing.contains(Attributes.LIFE)){
                throw new InvalidActionException();
            }
            return true;
        }
        throw new InvalidActionException();        
    }
    
    
        @Override
    public boolean enoughInformation(Action action) throws InvalidActionException {
        switch(action){
            case CONTACT:{
                if(isLife()){
                    return !(missing.contains(Attributes.ACT_WEAPON) ||
                            missing.contains(Attributes.COMUNICATES) ||
                            missing.contains(Attributes.RESOURCES));
                } else{
                  return !(missing.contains(Attributes.WEAPONS) || 
                          missing.contains(Attributes.COMUNICATES));  
                }
            }
            case ESCAPE:{
            
            }
            case FLYBY:{
            
            }
            case GATHER_RESOURCES:{
            
            }
            case SHOOT:{
            
            }
            case TRADE:{
            
            }
            
        }
    }
    
    
}
