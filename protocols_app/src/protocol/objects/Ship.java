/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.protocols.objects;

import cz.muni.fi.pb162.protocols.Action;
import cz.muni.fi.pb162.protocols.Attributes;
import cz.muni.fi.pb162.protocols.exceptions.InvalidActionException;
import cz.muni.fi.pb162.protocols.exceptions.InvalidObjectException;
import java.util.List;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Ship extends SpaceObject{

    public Ship(List<Attributes> attrs, List<Attributes> missing) throws InvalidObjectException {
        super(attrs, missing);
         if(!super.isWeapons()){
            throw new InvalidObjectException();
        }
        
    }
    
    @Override
    public int doAction(Action action) throws InvalidActionException {
        switch(action){
            case CONTACT:{
                 
            }
            case ESCAPE:{
            
            }
            case FLYBY:{
            
            }
            case GATHER_RESOURCES:{
            
            }
            case SHOOT:{
            
            }
            case TRADE:{
            
            }
            
        }
    }

    
    
    
}
