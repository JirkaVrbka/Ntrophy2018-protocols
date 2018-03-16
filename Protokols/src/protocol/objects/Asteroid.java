/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.EAction;
import protocol.enums.EAttributes;
import protocol.exceptions.InvalidActionException;
import protocol.exceptions.InvalidObjectException;
import java.util.List;
import protocol.enums.EType;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Asteroid extends SpaceObject{

    public Asteroid(List<EAttributes> attrs, List<EAttributes> missing) throws InvalidObjectException {
        super(attrs, missing);
        try {
            if(super.isLife() || super.isWeapons() || super.isComunicates() || super.isBigger() || super.isResources()){
                throw new InvalidObjectException();
            }
        }catch (NullPointerException e){
            throw new InvalidObjectException();
        }
       
    }
    @Override
    public EType getType(){
        return EType.ASTEROID;
    }

    @Override
    public int doAction(EAction action) throws InvalidActionException {
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
            return -3;
        }
        return 0;
    }
    
    
    private int flyby (){
        if (isFast()){
            return -3;
        }
        return 3;
    }
    
    private int gather (){
        if (isFast()){
            return -3;
        }
        return 0;
    }
    
    private int shoot (){
        if (super.isFast()){
            return 3;
        }
        return 0;
    }
    
    private int trade (){
        if (isFast()){
            return -3;
        }
        return 0;
    }
}
