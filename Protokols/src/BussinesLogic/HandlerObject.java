/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.util.ArrayList;
import java.util.List;
import protocol.enums.EAction;
import protocol.enums.EAttributeStates;
import protocol.enums.EType;
import protocol.exceptions.InvalidObjectException;
import protocol.objects.GameObjectAsteroid;
import protocol.objects.GameObjectPlanet;
import protocol.objects.GameObjectShip;
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
            EType type,
            EAttributeStates life,
            EAttributeStates comunicates,
            EAttributeStates resources,
            EAttributeStates bigger,
            EAttributeStates weapons,
            EAttributeStates actWeapons,
            EAttributeStates fast) {

        IGameObject go;

        try {
            switch (type) {
                case ASTEROID:
                    go = new GameObjectAsteroid(name, type, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    break;
                case PLANET:
                    go = new GameObjectPlanet(name, type, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    break;
                case SHIP:
                    go = new GameObjectShip(name, type, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    break;
                default:
                    try {
                        go = new GameObjectShip(name, type, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                    } catch (InvalidObjectException e) {
                        go = null;
                    }

                    if (go == null) {
                        try {
                            go = new GameObjectPlanet(name, type, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                        } catch (InvalidObjectException e) {
                            go = null;
                        }
                    }

                    if (go == null) {
                        try {
                            go = new GameObjectAsteroid(name, type, life, comunicates, resources, bigger, weapons, actWeapons, fast);
                        } catch (InvalidObjectException e) {
                            go = null;
                        }
                    }
            }
        } catch (InvalidObjectException ex) {
            go = null;
        }

        return go;
    }

    private static EType resolveType(
            EType type,
            EAttributeStates life,
            EAttributeStates comunicates,
            EAttributeStates resources,
            EAttributeStates bigger,
            EAttributeStates weapons,
            EAttributeStates actWeapons,
            EAttributeStates fast) {

        if (type != EType.UNDEFINED) {
            return type;
        }

        if (weapons.is() || (weapons.isUnknown() && fast.is() && life.is())) {
            return EType.SHIP;
        }

        if (life.is() || comunicates.is()) {
            return EType.PLANET;
        }

        if (fast.is()) {
            return EType.ASTEROID;
        }

        return EType.UNDEFINED;
    }

    public static int evalActionOnObject(IGameObject gameObject, EAction action) {
        return gameObject.doAction(action);
    }
    
    public static List<IGameObject> createAllObjects(){
        List<IGameObject> objects = new ArrayList<>();
        
        for (EType t : new EType[]{EType.ASTEROID, EType.PLANET, EType.SHIP}) {
            for (boolean fast : new boolean[]{true, false}) {
                for (boolean bigger : new boolean[]{true, false}) {
                    for (boolean communicates : new boolean[]{true, false}) {
                        for (boolean resources : new boolean[]{true, false}) {
                            for (boolean weapons : new boolean[]{true, false}) {
                                for (boolean active_weapons : new boolean[]{true, false}) {
                                    for (boolean life : new boolean[]{true, false}) {

                                        String name = t.toString() + "_";

                                        if (fast) {
                                            name += "fast_";
                                        }
                                        if (bigger) {
                                            name += "bigger_";
                                        }
                                        if (communicates) {
                                            name += "communicates_";
                                        }
                                        if (resources) {
                                            name += "resources_";
                                        }
                                        if (weapons) {
                                            name += "weapons_";
                                        }
                                        if (active_weapons) {
                                            name += "active_weapons_";
                                        }
                                        if (life) {
                                            name += "life_";
                                        }

                                        IGameObject go = HandlerObject.createObject(name,
                                                t,
                                                EAttributeStates.get(life), //life
EAttributeStates.get(communicates), //communicates
EAttributeStates.get(resources), //resources
EAttributeStates.get(bigger), //bigger
EAttributeStates.get(weapons), //weapons
EAttributeStates.get(active_weapons), //active weapons
EAttributeStates.get(fast)); //fast

                                        if (go != null) {
                                            objects.add(go);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return objects;
    }
    
    
}
