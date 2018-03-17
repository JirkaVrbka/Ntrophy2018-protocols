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
public class GameObjectPlanet extends AGameObject {

    public GameObjectPlanet(String name,
            EType givenType,
            EAttributeStates life,
            EAttributeStates comunicates,
            EAttributeStates resources,
            EAttributeStates bigger,
            EAttributeStates weapons,
            EAttributeStates actWeapons,
            EAttributeStates fast) throws InvalidObjectException {
        super(name, EType.PLANET, givenType, life, comunicates, resources, bigger, weapons, actWeapons, fast);

        if (weapons.is() || actWeapons.is() || bigger.isNot() || fast.is() || (life.isNot() && comunicates.is())) {
            super.idGeneratorMinusOne();
            throw new InvalidObjectException();
        }
    }

    @Override
    public int doAction(EAction action) {
            switch (action) {
                case CONTACT: {
                    return contact();
                }
                case ESCAPE: {
                    return escape();
                }
                case FLYBY: {
                    return flyby();
                }
                case GATHER_RESOURCES: {
                    return gather();
                }
                case SHOOT: {
                    return shoot();
                }
                case TRADE: {
                    return trade();
                }
            }
            
        return -3;
    }

    private int contact() {
        if (isLife()) {
            if (!super.isResources() && super.isComunicates()) {
                return 3;
            }
        }
        return 0;
    }

    private int escape() {
        return 0;
    }

    private int flyby() {
        if (!isLife() && !isResources()) {
            return 3;
        }
        if (!isComunicates() && isLife()){
            return 3;
        }
        //TODO 3 life and doesnt comm
        return 0;
    }

    private int gather() {
        if (isLife()) {
            return -3;
        } else {
            if (super.isResources()) {
                return 3;
            }
        }
        return 0;
    }

    private int shoot() {
        if (isLife()) {
            return -3;
        }
        return 0;
    }

    private int trade() {
        if (isLife() && !super.isComunicates()) {
            return -3;
        }
        if (isLife() && super.isResources() && super.isComunicates()) {
            return 3;
        }

        return 0;
    }
}
