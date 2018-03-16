/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import protocol.enums.EType;
import java.util.ArrayList;
import protocol.enums.EAction;
import protocol.enums.EAttributes;
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
     */
    public Universe(){
            int i;
            //obj 1 asteroid
            List <EAttributes> astAttr = new ArrayList<>();
            List <EAttributes> astmissing = new ArrayList<>();
            astAttr.add(EAttributes.FAST);
            i = CreateObj(EType.ASTEROID, astAttr, astmissing);
            getObjectByID(i).setName("Default obj");
            getObjectByID(i).setID(i);

            // obj 2 enemy live ship
            List <EAttributes> enship = new ArrayList<>();
            List <EAttributes> enshipmiss = new ArrayList<>();
            enship.add(EAttributes.RESOURCES);
            enship.add(EAttributes.LIFE);
            enship.add(EAttributes.WEAPONS);
            enship.add(EAttributes.ACT_WEAPON);
            enship.add(EAttributes.COMUNICATES);
            i = CreateObj(EType.SHIP, enship, enshipmiss);
            getObjectByID(i).setName("Default obj");
            getObjectByID(i).setID(i);

            // obj 3 anship
            List <EAttributes> anship = new ArrayList<>();
            List <EAttributes> anshipmiss = new ArrayList<>();
            anship.add(EAttributes.WEAPONS);
            anship.add(EAttributes.ACT_WEAPON);
            anship.add(EAttributes.COMUNICATES);
            anship.add(EAttributes.RESOURCES);
            anship.add(EAttributes.BIGGER);
            i = CreateObj(EType.SHIP, anship, anshipmiss);
            getObjectByID(i).setName("Default obj");
            getObjectByID(i).setID(i);

            // obj 4 vrak
            List <EAttributes> vrak = new ArrayList<>();
            vrak.add(EAttributes.WEAPONS);
            vrak.add(EAttributes.BIGGER);
            vrak.add(EAttributes.RESOURCES);
            i = CreateObj(EType.SHIP, vrak, anshipmiss);
            getObjectByID(i).setName("Default obj");
            getObjectByID(i).setID(i);

            // obj 5 planet
            List <EAttributes> planet = new ArrayList<>();
            planet.add(EAttributes.RESOURCES);
            planet.add(EAttributes.LIFE);
            planet.add(EAttributes.COMUNICATES);
            planet.add(EAttributes.BIGGER);
            i = CreateObj(EType.PLANET, planet, anshipmiss);
            getObjectByID(i).setName("Default obj");
            getObjectByID(i).setID(i);
            //createAll();
            
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
     */
    public final int CreateObj (EType type, List<EAttributes> attrs, List<EAttributes> missing){
    
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
                default:{
                    if (attrs.contains(EAttributes.WEAPONS) ||
                        (attrs.contains(EAttributes.LIFE)&& attrs.contains(EAttributes.FAST) && missing.contains(EAttributes.WEAPONS))){
                        objects.put(ID, new Ship(attrs,missing));
                        ID++;
                        break;
                    }
                    if(attrs.contains(EAttributes.LIFE) || attrs.contains(EAttributes.COMUNICATES)){
                        objects.put(ID, new Planet(attrs,missing));
                        ID++;
                        break;
                    }
                    if(attrs.contains(EAttributes.FAST) || 
                        (!attrs.contains(EAttributes.BIGGER) && !missing.contains(EAttributes.BIGGER))){
                        objects.put(ID, new Asteroid(attrs,missing));
                        ID++;
                        break;
                    }
                    objects.put(ID, new SpaceObject(attrs,missing));
                    ID++;
                }
            }
        } catch(InvalidObjectException e) {
        return -1;
        }
        return ID - 1;
    }
    
    public final SpaceObject getObjectByID (int id){
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
    public Pair<Integer, Boolean> evalAction(EAction action, int objectID){
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
    public boolean ask (EAttributes attribute, int objectID){
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
        Set <List<EAttributes>> allAttr = new HashSet<>();
        List <boolean []> allBool = new ArrayList<>();
        EAttributes [] attributes = EAttributes.values();
        
        for (int i = 0; i < Math.pow(2.0, (double) EAttributes.values().length); i++){
            boolean [] arr = new boolean[EAttributes.values().length];
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
            List<EAttributes> toAdd = new ArrayList<>();
            int i = 0;
            for (boolean b : bs) {
                if (b){
                    toAdd.add(attributes[i]);
                }
                i++;
            }
            allAttr.add(toAdd);
        }
        for (List<EAttributes> toCreate: allAttr) {
            CreateObj(EType.SHIP, toCreate, null);
            CreateObj(EType.PLANET, toCreate, null);
            CreateObj(EType.ASTEROID, toCreate, null);
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
