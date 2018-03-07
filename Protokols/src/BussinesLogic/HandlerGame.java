/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import protocol.enums.EAttributeState;
import protocol.enums.Type;
import protocol.objects.IGameObject;

/**
 *
 * @author Jirka
 */
public class HandlerGame {
    
    Map<String, IGameObject> defaultObjects = new HashMap<>();
    Map<String, IGameObject> customObjects = new HashMap<>();
    Map<String, Protokol> customProtocols = new HashMap<>();
    String currentProtocolName;
    
    
    public HandlerGame(){
        createDefaultObjects();
    }
    
    public Set<String> getProtocolNames(){
        return customProtocols.keySet();
    }
    
    public Set<String> getObjectNames(){
        Set<String> allObjects = customObjects.keySet();
        allObjects.addAll(defaultObjects.keySet());
        
        return allObjects;
    }
    
    public Protokol getProtokol(String name){
        return customProtocols.get(name);
    }
    
    public IGameObject getCustomObject(String name){
        return customObjects.get(name);
    }
    
    public void removeObject(String name){
        if(customObjects.containsKey(name)){
            customObjects.remove(name);
        }
    }
    
    public void removeProtocol(String name){
        if(customProtocols.containsKey(name)){
            customProtocols.remove(name);
        }
    }
    
    private void createDefaultObjects(){
        IGameObject go;
        
        //obj 1 asteroid
        go = HandlerObject.createObject(
                "Default obj 1",
                Type.ASTEROID, 
                EAttributeState.FALSE, //life
                EAttributeState.FALSE, //communicates
                EAttributeState.FALSE, //resources
                EAttributeState.FALSE, //bigger
                EAttributeState.FALSE, //weapons
                EAttributeState.FALSE, //active weapons
                EAttributeState.TRUE); //fast
        
        if(go == null){
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);
        
        // obj 2 enemy live ship
        go = HandlerObject.createObject(
                "Default obj 2",
                Type.SHIP, 
                EAttributeState.TRUE, //life
                EAttributeState.TRUE, //communicates
                EAttributeState.TRUE, //resources
                EAttributeState.FALSE, //bigger
                EAttributeState.TRUE, //weapons
                EAttributeState.TRUE, //active weapons
                EAttributeState.FALSE); //fast
        
        if(go == null){
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);
        
        // obj 3 anship
        go = HandlerObject.createObject(
                "Default obj 3",
                Type.SHIP, 
                EAttributeState.FALSE, //life
                EAttributeState.TRUE, //communicates
                EAttributeState.TRUE, //resources
                EAttributeState.TRUE, //bigger
                EAttributeState.TRUE, //weapons
                EAttributeState.TRUE, //active weapons
                EAttributeState.FALSE); //fast
        
        if(go == null){
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);
        
        //obj 4 vrak
        go = HandlerObject.createObject(
                "Default obj 4",
                Type.SHIP, 
                EAttributeState.FALSE, //life
                EAttributeState.FALSE, //communicates
                EAttributeState.TRUE, //resources
                EAttributeState.TRUE, //bigger
                EAttributeState.TRUE, //weapons
                EAttributeState.FALSE, //active weapons
                EAttributeState.FALSE); //fast
        
        if(go == null){
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);
        
        // obj 5 planet
        go = HandlerObject.createObject(
                "Default obj 1",
                Type.PLANET, 
                EAttributeState.TRUE, //life
                EAttributeState.TRUE, //communicates
                EAttributeState.TRUE, //resources
                EAttributeState.TRUE, //bigger
                EAttributeState.FALSE, //weapons
                EAttributeState.FALSE, //active weapons
                EAttributeState.FALSE); //fast
        
        if(go == null){
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);
        
        go = HandlerObject.createObject(
                "Default obj 1",
                Type.ASTEROID, 
                EAttributeState.FALSE, //life
                EAttributeState.FALSE, //communicates
                EAttributeState.FALSE, //resources
                EAttributeState.FALSE, //bigger
                EAttributeState.FALSE, //weapons
                EAttributeState.FALSE, //active weapons
                EAttributeState.TRUE); //fast
        
        if(go == null){
            throw new IllegalArgumentException("Cannot create default object");
        }
        defaultObjects.put(go.getName(), go);
    }
    
    
}
