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
public class Ship extends SpaceObject{

    public Ship(List<Attributes> attrs, List<Attributes> missing) throws InvalidObjectException {
        super(attrs, missing);
        if(missing != null && !missing.contains(Attributes.WEAPONS)){
            if(!super.isWeapons()){
               throw new InvalidObjectException();
            }
        }
    }
    @Override
    public Type getType(){
        return Type.SHIP;
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
            if(super.isActWeapons()){
                return -3;
            }
            if (super.isResources()){
                return 1;
            }
            if (super.isComunicates()){
                return 3;
            }
        }else{
            if(super.isComunicates()){
                return -3;
            }
        }
        return 0;
    }
    private int escape (){
        if(isLife()){
            if(super.isActWeapons()){
                if(super.isBigger()){
                    return 3;
                }
                return 1;
            }
            return -1;
        }else{
            if(super.isComunicates()){
                if (super.isBigger()){
                    return 3;
                } else {
                    return 1;
                }                
            }
        return -1;    
        }
    }
    
    
    private int flyby (){
        if(isLife()){
            if(super.isActWeapons()){
                return -3;
            }
            if (super.isComunicates()){
                return -1;
            }
        }else{
            if(super.isComunicates()){
                return -3;
            }
        }
        return 0;
    }
    private int gather (){
        if(isLife()){
            return -3;
        }else{
            if(super.isComunicates()){
                return -3;
            }
            if (super.isResources()){
                return 3;
            }
        }
        return 0;
    }
    
    private int shoot (){
        if(isLife()){
            if(super.isActWeapons()){
                if (super.isBigger()){
                    return -3;
                }
                return 3;
            }else{
                return -3;
            }
        } else {
            if(isComunicates()){
                if(isBigger()){
                    return -3;
                }
                return 3;
            }
        return -1;
        }
    }
    
    private int trade (){
        if(isLife()){
            if(super.isActWeapons()){
                return -3;
            }
            if (super.isResources()){
                if (super.isComunicates()){
                    return 3;
                }
                return -1;
            }            
        }else{
            if(super.isComunicates()){
                return -3;
            }
        }
        return -1;
    }
        
    /*
    @Override
    public boolean enoughInformation(Action action) throws InvalidActionException {
        if(super.getMissing().contains(Attributes.LIFE)){
            return false;
        }
        switch(action){
            case CONTACT:{
                if(super.isLife()){
                    return (!(super.getMissing().contains(Attributes.COMUNICATES)||
                            super.getMissing().contains(Attributes.RESOURCES) ||
                            super.getMissing().contains(Attributes.ACT_WEAPON)));
                } else{
                    return !(super.getMissing().contains(Attributes.COMUNICATES));
                    }
            }
            case ESCAPE:{
                if(super.isLife()){
                    return (!(super.getMissing().contains(Attributes.BIGGER)||
                            super.getMissing().contains(Attributes.ACT_WEAPON)));
                } else{
                    return !(super.getMissing().contains(Attributes.COMUNICATES) ||
                            super.getMissing().contains(Attributes.BIGGER));
                }                    
                
            }
            case FLYBY:{
                if(super.isLife()){
                    return (!(super.getMissing().contains(Attributes.RESOURCES)||
                            super.getMissing().contains(Attributes.COMUNICATES)||
                            super.getMissing().contains(Attributes.ACT_WEAPON)));
                } else{
                    return !(super.getMissing().contains(Attributes.COMUNICATES) ||
                            super.getMissing().contains(Attributes.RESOURCES));
                }
            
            }
            case GATHER_RESOURCES:{
            
            }
            case SHOOT:{
            
            }
            case TRADE:{
            
            }
            
        }
        return false;
    }
*/    
}
