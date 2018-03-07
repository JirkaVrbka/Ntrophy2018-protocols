/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import protocol.enums.Action;
import protocol.enums.EAttributeState;
import static protocol.enums.EAttributeState.FALSE;
import protocol.enums.Type;
import protocol.exceptions.InvalidObjectException;

/**
 *
 * @author Jirka
 */
public class GameObjectUnknown extends AGameObject{
    public GameObjectUnknown(String name,
            EAttributeState life,
            EAttributeState comunicates,
            EAttributeState resources,
            EAttributeState bigger,
            EAttributeState weapons,
            EAttributeState actWeapons,
            EAttributeState fast) throws InvalidObjectException {
        super(name, Type.SHIP, life, comunicates, resources, bigger, weapons, actWeapons, fast);

        if (weapons == FALSE && actWeapons.is()) {
            super.idGeneratorMinusOne();
            throw new InvalidObjectException();
        }
    }
    
    @Override
    public int doAction(Action action){
            return 0;
    }
    
}
