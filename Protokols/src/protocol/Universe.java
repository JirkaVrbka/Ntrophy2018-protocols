/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import protocol.enums.Type;
import java.util.ArrayList;
import java.util.Arrays;
import protocol.enums.Action;
import protocol.enums.Attributes;
import protocol.exceptions.InvalidObjectException;
import protocol.objects.Asteroid;
import protocol.objects.SpaceObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;
import protocol.exceptions.InvalidActionException;
import protocol.objects.Planet;
import protocol.objects.Ship;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Universe {
    private Map <Integer, SpaceObject> objects = new HashMap<>();
    private int ID = 0;
    
    /**
     * creates first 5 testing objects
     * @throws InvalidObjectException wont actually do it...
     */
    public Universe(){
            
            //obj 1 asteroid
            List <Attributes> astAttr = new ArrayList<>();
            List <Attributes> astmissing = new ArrayList<>();
            astAttr.add(Attributes.RESOURCES);
            CreateObj(Type.ASTEROID, astAttr, astmissing);

            // obj 2 enemy live ship
            List <Attributes> enship = new ArrayList<>();
            List <Attributes> enshipmiss = new ArrayList<>();
            enship.add(Attributes.RESOURCES);
            enship.add(Attributes.LIFE);
            enship.add(Attributes.WEAPONS);
            enship.add(Attributes.ACT_WEAPON);
            enship.add(Attributes.COMUNICATES);
            CreateObj(Type.SHIP, enship, enshipmiss);

            // obj 3 anship
            List <Attributes> anship = new ArrayList<>();
            List <Attributes> anshipmiss = new ArrayList<>();
            anship.add(Attributes.WEAPONS);
            anship.add(Attributes.ACT_WEAPON);
            anship.add(Attributes.COMUNICATES);
            anship.add(Attributes.RESOURCES);
            anship.add(Attributes.BIGGER);
            CreateObj(Type.SHIP, anship, anshipmiss);

            // obj 4 vrak
            List <Attributes> vrak = new ArrayList<>();
            vrak.add(Attributes.WEAPONS);
            vrak.add(Attributes.BIGGER);
            vrak.add(Attributes.RESOURCES);
            CreateObj(Type.SHIP, vrak, anshipmiss);

            // obj 5 planet
            List <Attributes> planet = new ArrayList<>();
            planet.add(Attributes.RESOURCES);
            planet.add(Attributes.LIFE);
            planet.add(Attributes.COMUNICATES);
            planet.add(Attributes.BIGGER);
            CreateObj(Type.PLANET, planet, anshipmiss);
            
    }

    public Map<Integer, SpaceObject> getObjects() {
        return objects;
    }

    public int getID() {
        return ID;
    }
    
    
    /**
     * creates specified object
     * @param type enum Type
     * @param attrs attributes that are true
     * @param missing attributes that are missing
     * @return id of object upon success else -1;
     * @throws InvalidObjectException 
     */
    public final int CreateObj (Type type, List<Attributes> attrs, List<Attributes> missing){
    
        try{
            switch (type){
                case ASTEROID:{
                        objects.put(ID, new Asteroid(attrs,missing));
                        ID++;
                        break;
                }
                case PLANET:{
                        objects.put(ID, new Planet(attrs,missing));
                        ID++;
                        break;
                }
                case SHIP:{
                        objects.put(ID, new Ship(attrs,missing));
                        ID++;
                        break;
                }
            }
        } catch(InvalidObjectException e) {
        return -1;
        }
        return ID;
    }
    
    public SpaceObject getObjectByID (int id){
        return objects.get(id);
    }
    
    
    /**
     * removes object with spec ID (cant erase object created in constructor ID<4)
     * @param objectID 
     * @return  true upon succes 
     */
    public boolean removeObj (int objectID){
        if(objectID < 4){
            return false;
        }
        objects.remove(objectID);
        return true;
    }
    
    /**
     * Does action on specified obj.
     * @param action enum action
     * @param objectID int ID
     * @return Pair (points, true if everything ok, if false then points is unusable)
     */
    public Pair<Integer, Boolean> evalAction(Action action, int objectID){
        Pair <Integer, Boolean> rt;
        try{
            rt = new Pair((Integer)objects.get(objectID).doAction(action), true);
        } catch(InvalidActionException e){
            return  new Pair(-42, false);
        }
        return rt;        
    }
   
    /**
     * asks object question Question is specified with same enum as attribute
     * @param attribute enum attribute
     * @param objectID id
     * @return t/f
     */
    public boolean ask (Attributes attribute, int objectID){
        try{
            switch (attribute){
                    case LIFE: {
                        return objects.get(objectID).isLife();
                    }
                    case COMUNICATES:{
                        return objects.get(objectID).isComunicates();
                    }
                    case BIGGER: {
                        return objects.get(objectID).isBigger();
                    }
                    case ACT_WEAPON:{
                        return objects.get(objectID).isActWeapons();
                    }
                    case WEAPONS:{
                        return objects.get(objectID).isWeapons();
                    }
                    case RESOURCES:{
                        return objects.get(objectID).isResources();
                    }
                    case FAST: {
                        return objects.get(objectID).isFast();
                    }
            }
            return false;
        }catch (NullPointerException e){
            return false;
        }
    }
    /**
     * creates All possible objects and puts them to universe.objects
     */
    public void createAll(){
        Set <List<Attributes>> allAttr = new HashSet<>();
        List <boolean []> allBool = new ArrayList<>();
        Attributes [] attributes = Attributes.values();
        
        for (int i = 0; i < Math.pow(2.0, (double) Attributes.values().length); i++){
            boolean [] arr = new boolean[Attributes.values().length];
            int pos = 0;
            int num = i;
            while(num > 0){
                if (num % 2 == 1){
                    arr[pos] = true;
                    num--;
                    num = (int)(num /2);
                    pos++;
                } else{
                    num = (int) (num/2);
                    pos++;
                }
            }
            allBool.add(arr);
        }
        for (boolean[] bs : allBool) {
            List<Attributes> toAdd = new ArrayList<>();
            int i = 0;
            for (boolean b : bs) {
                if (b){
                    toAdd.add(attributes[i]);
                }
                i++;
            }
            allAttr.add(toAdd);
        }
        for (List<Attributes> toCreate: allAttr) {
            CreateObj(Type.SHIP, toCreate, null);
            CreateObj(Type.PLANET, toCreate, null);
            CreateObj(Type.ASTEROID, toCreate, null);
        }
    }
    /**
    public void createAll(){
        Set <List<Attributes>> allAttr = new HashSet<>();
        //Set <Set<Attributes>> allMissing = new HashSet<>();
        //Set <Attributes> aMissing = new HashSet<>();
        List <Attributes> aAttr = new ArrayList<>();
        allAttr.add(null);
        
        for (Attributes st : Attributes.values()) {
            aAttr.add(st);
            for (Attributes nd : Attributes.values()) {
                if(!(aAttr.contains(nd))){
                    aAttr.add(nd);
                } 
                allAttr.add(aAttr);
            }
            aAttr.removeAll(aAttr);
        }
        for (Type type : Type.values()) {
            for (List <Attributes> oneList: allAttr) {
                CreateObj(type, oneList, null);
            }
        }
    }*/
}
