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

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Asteroid extends SpaceObject{

    public Asteroid(List<Attributes> attrs, List<Attributes> missing) throws InvalidObjectException {
        super(attrs, missing);
        if(!missing.contains(Attributes.LIFE) && !missing.contains(Attributes.WEAPONS) && !missing.contains(Attributes.COMUNICATES)){
            if(super.isLife() || super.isWeapons() || super.isComunicates()){
                throw new InvalidObjectException();
            }
        }
       
    }

    @Override
    public int doAction(Action action) throws InvalidActionException {
        try{
            switch(action){
                case CONTACT:{
                   return contact();
                }
                case ESCAPE:{
                    return escape();
                }
                case FLYBY:{
                    return flyby();
                }
                case GATHER_RESOURCES:{
                    return gather();
                }
                case SHOOT:{
                    return shoot();
                }
                case TRADE:{
                    return trade();
                }
            }
        } catch (NullPointerException e){
            throw new InvalidActionException();
        }
        return -3;
    }
    private int contact (){
        if(isFast()){
            return -3;
        }
        return 0;
    }
    private int escape (){
        if (isFast()){
            if (isBigger()) {
                return 3;                
            }
            return 2;
        }
        return -1;
    }
    
    
    private int flyby (){
        if (isFast()){
            return -3;
        }
        return 0;
    }
    private int gather (){
        if (isFast()){
            return -3;
        }
        if (isResources()){
            return 3;
        }
        return -1;
    }
    
    private int shoot (){
        if (super.isFast()){
            if(super.isBigger()){
                return -3;
            }
            return 3;
        }
        return -1;
    }
    
    private int trade (){
        if (isFast()){
            return -3;
        }
        if (isResources()){
            return 3;
        }
        return -1;
    }
}
