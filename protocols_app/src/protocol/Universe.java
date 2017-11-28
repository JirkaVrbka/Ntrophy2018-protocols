/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.protocols;

import cz.muni.fi.pb162.protocols.exceptions.InvalidObjectException;
import cz.muni.fi.pb162.protocols.objects.Asteroid;
import cz.muni.fi.pb162.protocols.objects.SpaceObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Universe {
    private Map <Integer, SpaceObject> objects = new HashMap<Integer, SpaceObject>();
    private int ID = 0;
    
    public int CreateObj (Type type, List<Attributes> attrs, List<Attributes> missing)
    throws InvalidObjectException{
    
    try{
        switch (type){
            case ASTEROID:
                    objects.put(ID, new Asteroid(attrs,missing));
                    ID++;
                }
                   
        } catch(InvalidObjectException e) {
            return -1;
        }
    return ID;
    }
    public String evalAction(Action action, int ID){
        return "";
    }
}
