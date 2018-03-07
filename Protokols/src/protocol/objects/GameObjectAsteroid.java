/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.Action;
import protocol.enums.EAttributeState;
import protocol.enums.Type;
import protocol.exceptions.InvalidActionException;
import protocol.exceptions.InvalidObjectException;

/**
 *
 * @author Jirka
 */
public class GameObjectAsteroid extends AGameObject{
    
    public GameObjectAsteroid(String name,
            EAttributeState life,
            EAttributeState comunicates,
            EAttributeState resources,
            EAttributeState bigger,
            EAttributeState weapons,
            EAttributeState actWeapons,
            EAttributeState fast) throws InvalidObjectException {
        super(name, Type.ASTEROID, life, comunicates, resources, bigger, weapons, actWeapons, fast);

        if (super.isLife() || super.isWeapons() || super.isActWeapons() || super.isComunicates() || super.isBigger() || super.isResources()) {
            super.idGeneratorMinusOne();
            throw new InvalidObjectException();
        }
    }

    @Override
    public int doAction(Action action) throws InvalidActionException {

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
