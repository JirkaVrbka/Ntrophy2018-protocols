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
public class Asteroid extends SpaceObject{

    public Asteroid(List<Attributes> attrs, List<Attributes> missing) throws InvalidObjectException {
        super(attrs, missing);
        if(super.isLife() || super.isWeapons() || super.isComunicates()){
            throw new InvalidObjectException();
        }
       
    }

    @Override
    public int doAction(Action action) throws InvalidActionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
