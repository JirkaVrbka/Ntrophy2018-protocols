/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import protocol.enums.Action;
import protocol.enums.EAttributeState;
import static protocol.enums.EAttributeState.TRUE;
import static protocol.enums.EAttributeState.UNKNOWN;
import protocol.enums.Type;
import protocol.exceptions.InvalidObjectException;
import protocol.objects.AGameObject;
import protocol.objects.GameObjectAsteroid;
import protocol.objects.GameObjectPlanet;
import protocol.objects.GameObjectShip;
import protocol.objects.GameObjectUnknown;
import protocol.objects.IGameObject;

/**
 *
 * @author Jirka
 */
public final class HandlerObject {

    private HandlerObject() {
    }

    public static IGameObject createObject(
            String name,
            Type type,
            EAttributeState life,
            EAttributeState comunicates,
            EAttributeState resources,
            EAttributeState bigger,
            EAttributeState weapons,
            EAttributeState actWeapons,
            EAttributeState fast) {

        IGameObject go;

        try {
            switch (resolveType(type, life, comunicates, resources, bigger, weapons, actWeapons, fast)) {
                case ASTEROID:
                    go = new GameObjectAsteroid(name, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    break;
                case PLANET:
                    go = new GameObjectPlanet(name, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    break;
                case SHIP:
                    go = new GameObjectShip(name, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    break;
                default:
                    go = new GameObjectUnknown(name, life, comunicates, resources, bigger, weapons, actWeapons, fast);
            }
        } catch (InvalidObjectException ex) {
            go = null;
        }

        return go;
    }

    private static Type resolveType(
            Type type,
            EAttributeState life,
            EAttributeState comunicates,
            EAttributeState resources,
            EAttributeState bigger,
            EAttributeState weapons,
            EAttributeState actWeapons,
            EAttributeState fast) {

        if (type != Type.UNDEFINED) {
            return type;
        }

        if (weapons.is() || (weapons.isUnknown() && fast.is() && life.is())) {
            return Type.SHIP;
        }

        if (life.is() || comunicates.is()) {
            return Type.PLANET;
        }

        if (fast.is()) {
            return Type.ASTEROID;
        }

        return Type.UNDEFINED;
    }

    public static int evalActionOnObject(IGameObject gameObject, Action action) {
        return gameObject.doAction(action);
    }
}
