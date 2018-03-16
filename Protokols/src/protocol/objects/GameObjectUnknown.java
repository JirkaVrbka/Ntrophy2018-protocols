/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.EAction;
import protocol.enums.EAttributeStates;
import static protocol.enums.EAttributeStates.FALSE;
import protocol.enums.EType;
import protocol.exceptions.InvalidObjectException;

/**
 *
 * @author Jirka
 */
public class GameObjectUnknown extends AGameObject{
    public GameObjectUnknown(String name,
            EType givenType,
            EAttributeStates life,
            EAttributeStates comunicates,
            EAttributeStates resources,
            EAttributeStates bigger,
            EAttributeStates weapons,
            EAttributeStates actWeapons,
            EAttributeStates fast) throws InvalidObjectException {
        super(name, EType.UNDEFINED, givenType, life, comunicates, resources, bigger, weapons, actWeapons, fast);

        if (weapons.isNot() && actWeapons.is()) {
            super.idGeneratorMinusOne();
            throw new InvalidObjectException();
        }
    }
    
    @Override
    public int doAction(EAction action){
            return 0;
    }
    
}
