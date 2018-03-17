/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.EAction;
import protocol.enums.EAttributeStates;
import protocol.enums.EType;
import protocol.exceptions.InvalidObjectException;

/**
 *
 * @author Jirka
 */
public class GameObjectShip extends AGameObject{
    
    public GameObjectShip(String name,
            EType givenType,
            EAttributeStates life,
            EAttributeStates comunicates,
            EAttributeStates resources,
            EAttributeStates bigger,
            EAttributeStates weapons,
            EAttributeStates actWeapons,
            EAttributeStates fast) throws InvalidObjectException {
        super(name, EType.SHIP, givenType, life, comunicates, resources, bigger, weapons, actWeapons, fast);

        if (weapons.isNot()) {
            super.idGeneratorMinusOne();
            throw new InvalidObjectException();
        }
    }
    
    @Override
    public int doAction(EAction action){
        
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
        
        return -3;
    }
    
    private int contact (){
        if(isLife()){
            if(super.isActWeapons()){
                return -3;
            }
            if (super.isResources()){
                return 0;
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
                return 0;
            }
            return 0;
        }else{
            if(super.isComunicates()){
                if (super.isBigger()){
                    return 3;
                } else {
                    return 0;
                }                
            }
        return 0;    
        }
    }
    
    
    private int flyby (){
        if(isLife()){
            if(super.isActWeapons()){
                return -3;
            }
            if (super.isComunicates()){
                return 0;
            }else{
                return 3;
            }
        }else{
            if(super.isComunicates()){
                return -3;
            }
            if(!super.isResources()){
                return 3;
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
        return 0;
        }
    }
    
    private int trade (){
        if(isLife()){
            if(super.isActWeapons() || !super.isComunicates()){
                return -3;
            }
            if (super.isComunicates() && super.isResources()){
                return 3;
            }
            if(super.isComunicates() && !super.isResources()){
                return 0;
            }
            
        }else{
            if(super.isComunicates()){
                return -3;
            }
        }
        return 0;
    }
}
