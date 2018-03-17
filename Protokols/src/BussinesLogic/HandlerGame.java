/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import protocol.enums.EAttributeStates;
import protocol.enums.EType;
import protocol.objects.IGameObject;

/**
 *
 * @author Jirka
 */
public class HandlerGame {

    Map<String, IGameObject> defaultObjects = new LinkedHashMap<>();
    Map<String, IGameObject> customObjects = new LinkedHashMap<>();
    Map<String, Protokol> customProtocols = new LinkedHashMap<>();
    String currentProtocolName;

    public HandlerGame() {
        createDefaultObjects();
    }

    public Set<String> getProtocolNames() {
        return customProtocols.keySet();
    }

    public List<String> getObjectNames() {
        List<String> allObjects = new ArrayList<>();
        customObjects.keySet().forEach(name -> {
            allObjects.add(name);
        });
        defaultObjects.keySet().forEach(name -> {
            allObjects.add(name);
        });
        //allObjects.addAll(defaultObjects.keySet());

        return allObjects;
    }

    public Protokol getProtokol(String name) {
        return customProtocols.get(name);
    }

    public IGameObject getCustomObject(String name) {
        return customObjects.get(name);
    }

    public IGameObject getObject(String name) {
        IGameObject toReturn;
        if ((toReturn = customObjects.get(name)) == null && (toReturn = defaultObjects.get(name)) == null) {
            return null;
        }

        return toReturn;
    }

    public boolean removeCustomObject(String name) {
        boolean isThere = customObjects.remove(name) != null;
        return isThere;
    }

    public boolean removeProtocol(String name) {
        return customProtocols.remove(name) != null;
    }

    public void addProtokol(Protokol protokol) {
        customProtocols.put(protokol.getName(), protokol);
    }

    public void addCustomObject(IGameObject go) {
        customObjects.put(go.getName(), go);
    }

    public int evaluateProtokol(String protokolName, String objectName) {
        IGameObject gameObject;
        Protokol protokol;

        if ((gameObject = getObject(objectName)) == null) {
            throw new IllegalArgumentException("No object in database with name " + objectName);
        }

        if ((protokol = getProtokol(protokolName)) == null) {
            throw new IllegalArgumentException("No protokol in database with name " + protokolName);
        }

        try {
            return HandlerProtocol.evalProtokol(protokol, gameObject);
        } catch (NullPointerException ex) {
            return -999;
        }
    }

    private void createDefaultObjects() {
        IGameObject go;

        //obj 1 asteroid
        go = HandlerObject.createObject("Default obj",
                EType.ASTEROID,
                EAttributeStates.FALSE, //life
                EAttributeStates.FALSE, //communicates
                EAttributeStates.FALSE, //resources
                EAttributeStates.FALSE, //bigger
                EAttributeStates.FALSE, //weapons
                EAttributeStates.FALSE, //active weapons
                EAttributeStates.TRUE); //fast

        if (go == null) {
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);

        // obj 2 enemy live ship
        go = HandlerObject.createObject("Default obj",
                EType.SHIP,
                EAttributeStates.TRUE, //life
                EAttributeStates.TRUE, //communicates
                EAttributeStates.TRUE, //resources
                EAttributeStates.FALSE, //bigger
                EAttributeStates.TRUE, //weapons
                EAttributeStates.TRUE, //active weapons
                EAttributeStates.FALSE); //fast

        if (go == null) {
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);

        // obj 3 anship
        go = HandlerObject.createObject("Default obj",
                EType.SHIP,
                EAttributeStates.FALSE, //life
                EAttributeStates.TRUE, //communicates
                EAttributeStates.TRUE, //resources
                EAttributeStates.TRUE, //bigger
                EAttributeStates.TRUE, //weapons
                EAttributeStates.TRUE, //active weapons
                EAttributeStates.FALSE); //fast

        if (go == null) {
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);

        //obj 4 vrak
        go = HandlerObject.createObject("Default obj",
                EType.SHIP,
                EAttributeStates.FALSE, //life
                EAttributeStates.FALSE, //communicates
                EAttributeStates.TRUE, //resources
                EAttributeStates.TRUE, //bigger
                EAttributeStates.TRUE, //weapons
                EAttributeStates.FALSE, //active weapons
                EAttributeStates.FALSE); //fast

        if (go == null) {
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);

        // obj 5 planet
        go = HandlerObject.createObject("Default obj",
                EType.PLANET,
                EAttributeStates.TRUE, //life
                EAttributeStates.TRUE, //communicates
                EAttributeStates.TRUE, //resources
                EAttributeStates.TRUE, //bigger
                EAttributeStates.FALSE, //weapons
                EAttributeStates.FALSE, //active weapons
                EAttributeStates.FALSE); //fast

        if (go == null) {
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);

    }

}
