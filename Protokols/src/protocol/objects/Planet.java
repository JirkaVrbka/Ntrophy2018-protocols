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
import protocol.enums.Type;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Planet extends SpaceObject{

    public Planet(List<Attributes> attrs, List<Attributes> missing) throws InvalidObjectException {
        super(attrs, missing);
        try {
            if(super.isWeapons()|| !(super.isBigger()) || super.isFast()){
                throw new InvalidObjectException();                    
            }
        }catch (NullPointerException e){
            throw new InvalidObjectException();
                    
        }
    }
    @Override
    public Type getType(){
        return Type.PLANET;
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
        if(isLife()){
            if (!super.isResources() && super.isComunicates()){
                return 3;
            }
        }
        return 0;
    }
    
    private int escape (){
        return 0;
    }
    
    
    private int flyby (){
        if(!isLife() && !isResources()){
            return 3;
        }
        //TODO 3 life and doesnt comm
        return 0;
    }
    private int gather (){
        if(isLife()){
            return -3;
        }else{
            if (super.isResources()){
                return 3;
            }
        }
        return 0;
    }
    
    private int shoot (){
        if(isLife()){
            return -3;
        }
        return 0;
    }
    
    private int trade (){
        if(isLife() && !super.isComunicates()){
            return -3;
        }
        if(isLife() && super.isResources() && super.isComunicates()){
            return 3;       
        }
        
        return 0;
    }
}
