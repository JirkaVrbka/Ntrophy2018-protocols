/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import java.util.ArrayList;
import protocol.enums.EAction;
import protocol.enums.EAttributes;
import protocol.exceptions.InvalidActionException;
import protocol.exceptions.InvalidObjectException;
import java.util.List;
import java.util.Map;
import protocol.enums.EType;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class SpaceObject implements OurObject{
    private Boolean life        = false;
    private Boolean comunicates = false;
    private Boolean resources   = false;
    private Boolean bigger      = false;
    private Boolean weapons     = false;
    private Boolean actWeapons  = false;
    private Boolean fast        = false;
    private String name         = null;
    private List <EAttributes> missing;
    private List <EAttributes> trueattr;
    private int id = -1;
    
    
    public SpaceObject(List <EAttributes> attrs, List <EAttributes> missing) 
            throws InvalidObjectException{
        this.missing = missing;
        this.trueattr = attrs;
        if (attrs != null && attrs.size() > 0){
            for (EAttributes attr : attrs) {
                switch (attr){
                    case LIFE: {
                        life = true;
                        break;
                    }
                    case COMUNICATES:{
                        comunicates = true;
                        break;
                    }
                    case BIGGER: {
                        bigger = true;
                        break;
                    }
                    case ACT_WEAPON:{
                        actWeapons = true;
                        break;
                    }
                    case WEAPONS:{
                        weapons = true;
                        break;
                    }
                    case RESOURCES:{
                        resources = true;
                        break;
                    }
                    case FAST: {
                        fast = true;
                        break;
                    }
                }
            }
        }
        if (missing != null && this.missing.size() > 0){
            for (EAttributes miss : missing) {
                switch (miss){
                    case LIFE: {
                        life = null;
                        break;
                    }
                    case COMUNICATES:{
                        comunicates = null;
                        break;
                    }
                    case BIGGER: {
                        bigger = null;
                        break;
                    }
                    case ACT_WEAPON:{
                        actWeapons = null;
                        break;
                    }
                    case WEAPONS:{
                        weapons = null;
                        break;
                    }
                    case RESOURCES:{
                        resources = null;
                        break;
                    }
                    case FAST: {
                        fast = null;
                        break;
                    }
                }
            }
        }
        if((actWeapons != null && weapons != null)){
            if (actWeapons && !weapons){
                throw new InvalidObjectException();
            }
        }
    }

    @Override
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public List<EAttributes> getTrueAttr() {
        return trueattr;
    }
    @Override
    public List<EAttributes> getMissingAttr() {
        return missing;
    }
    @Override
    public List<EAttributes> getFalseAttr() {
        List<EAttributes> falseAttr  = new ArrayList<>();
        for (EAttributes attr : EAttributes.values()) {
            if (missing != null){
                if (!missing.contains(attr) && !trueattr.contains(attr)) {
                    falseAttr.add(attr);
                }
            } else{
                if (!trueattr.contains(attr)) {
                    falseAttr.add(attr);
                }
            }
        }
        return falseAttr;
    }
    
    @Override
    public String getName() {
        return name;
    }

    
    @Override
    public boolean isLife() {
        return life;
    }

    @Override
    public boolean isComunicates() {
        return comunicates;
    }

    @Override
    public boolean isResources() {
        return resources;
    }

    @Override
    public boolean isBigger() {
        return bigger;
    }

    @Override
    public boolean isWeapons() {
        return weapons;
    }

    @Override
    public boolean isActWeapons() {
        return actWeapons;
    }

    public List<EAttributes> getMissing() {
        return missing;
    }

    @Override
    public boolean isFast() {
        return fast;
    }
    /*
    public boolean unfriendly() throws InvalidActionException{
        if (isLife() && isWeapons() && isActWeapons()){
            return true;
        }
        if (!isLife() && isWeapons() && isComunicates()){
            if(missing.contains(Attributes.LIFE)){
                throw new InvalidActionException();
            }
            return true;
        }
        throw new InvalidActionException();        
    }
    */

    @Override
    public int doAction(EAction action) throws InvalidActionException {
        throw new InvalidActionException();
    }

    @Override
    public EType getType() {
        return EType.UNDEFINED;
    }
    
    /**
     * Parses last number before to id number 
     * @param str string from name of button...
     * @return int ID
     */
    private int parseLastToId(String str){
        String [] afterSplit = str.split(" ");
        return Integer.valueOf(afterSplit[afterSplit.length -1]);
    }

    
    public void setID(int i){
        this.id = i;
    }
    @Override
    public int getID() {
        return id;
    }

    
    
    
}
