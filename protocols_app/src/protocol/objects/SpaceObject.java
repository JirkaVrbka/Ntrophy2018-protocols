/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.Action;
import protocol.enums.Attributes;
import protocol.exceptions.InvalidActionException;
import protocol.exceptions.InvalidObjectException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ondrej Urbanovsky
 */
public abstract class SpaceObject implements Object{
    private Boolean life        = false;
    private Boolean comunicates = false;
    private Boolean resources   = false;
    private Boolean bigger      = false;
    private Boolean weapons     = false;
    private Boolean actWeapons  = false;
    private Boolean fast        = false;
    private List <Attributes> missing;
    
    
    public SpaceObject(List <Attributes> attrs, List <Attributes> missing) 
            throws InvalidObjectException{
        this.missing = missing;
        if (attrs != null && attrs.size() > 0){
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
            }
        }
        if (missing != null && this.missing.size() > 0){
            for (Attributes miss : missing) {
                switch (miss){
                    case LIFE: {
                        life = null;
                        break;
                    }
                    case COMUNICATES:{
                        comunicates = null;
                        break;
                    }
                    case BIGGER: {
                        bigger = null;
                        break;
                    }
                    case ACT_WEAPON:{
                        actWeapons = null;
                        break;
                    }
                    case WEAPONS:{
                        weapons = null;
                        break;
                    }
                    case RESOURCES:{
                        resources = null;
                        break;
                    }
                    case FAST: {
                        fast = null;
                        break;
                    }
                }
            }
        }
        if((actWeapons != null && weapons != null)){
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
    
    
}
