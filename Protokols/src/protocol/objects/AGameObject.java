/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import java.util.ArrayList;
import java.util.List;
import protocol.enums.EAttributes;
import protocol.enums.EAttributeStates;
import protocol.enums.EType;

/**
 *
 * @author Jirka
 */
public abstract class AGameObject implements IGameObject {

    private static int idGenerator = 1;
    
    private final EAttributeStates life;
    private final EAttributeStates comunicates;
    private final EAttributeStates resources;
    private final EAttributeStates bigger;
    private final EAttributeStates weapons;
    private final EAttributeStates actWeapons;
    private final EAttributeStates fast;
    private final EType type;
    private final EType givenType;
    private final String name;
    private final int id;
    

    public AGameObject(String name,
            EType type,
            EType givenType,
            EAttributeStates life,
            EAttributeStates comunicates,
            EAttributeStates resources,
            EAttributeStates bigger,
            EAttributeStates weapons,
            EAttributeStates actWeapons,
            EAttributeStates fast) {

        id = idGenerator;
        idGenerator++;
        this.type = type;
        this.givenType = givenType;
        this.name = name + "_" + id;
        this.life = life;
        this.comunicates = comunicates;
        this.resources = resources;
        this.bigger = bigger;
        this.weapons = weapons;
        this.actWeapons = actWeapons;
        this.fast = fast;
        
      //  this.fast = EAttributeStatesCustom.TRUE;
        
    }
    
    protected void idGeneratorMinusOne(){
        idGenerator--;
    }
    
    @Override
    public EType getGivenType(){
        return givenType;
    }
    
    @Override
    public EAttributeStates getLife() {
        return life;
    }

    @Override
    public EAttributeStates getComunicates() {
        return comunicates;
    }

    @Override
    public EAttributeStates getResources() {
        return resources;
    }

    @Override
    public EAttributeStates getBigger() {
        return bigger;
    }

    @Override
    public EAttributeStates getWeapons() {
        return weapons;
    }

    @Override
    public EAttributeStates getActWeapons() {
        return actWeapons;
    }

    @Override
    public EAttributeStates getFast() {
        return fast;
    }

    public int getId() {
        return id;
    }

    private List<EAttributes> getAttributesWithState(EAttributeStates state) {
        List<EAttributes> withState = new ArrayList<>();
        
        if(this.life == state){
            withState.add(EAttributes.LIFE);
        }
        if(this.comunicates == state){
            withState.add(EAttributes.COMUNICATES);
        }
        if(this.resources == state){
            withState.add(EAttributes.RESOURCES);
        }
        if(this.bigger == state){
            withState.add(EAttributes.BIGGER);
        }
        if(this.weapons == state){
            withState.add(EAttributes.WEAPONS);
        }
        if(this.actWeapons == state){
            withState.add(EAttributes.ACT_WEAPON);
        }
        if(this.fast == state){
            withState.add(EAttributes.FAST);
        }
        
        return withState;
    }

    @Override
    public List<EAttributes> getTrueAttr() {
       return getAttributesWithState(EAttributeStates.TRUE);
    }

    @Override
    public List<EAttributes> getMissingAttr() {
        return getAttributesWithState(EAttributeStates.UNDEFINED);
    }

    @Override
    public List<EAttributes> getFalseAttr() {
        return getAttributesWithState(EAttributeStates.FALSE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLife() {
        return life == EAttributeStates.TRUE;
    }

    @Override
    public boolean isComunicates() {
        return comunicates == EAttributeStates.TRUE;
    }

    @Override
    public boolean isResources() {
        return resources == EAttributeStates.TRUE;
    }

    @Override
    public boolean isBigger() {
        return bigger == EAttributeStates.TRUE;
    }

    @Override
    public boolean isWeapons() {
        return weapons == EAttributeStates.TRUE;
    }

    @Override
    public boolean isActWeapons() {
        return actWeapons == EAttributeStates.TRUE;
    }

    @Override
    public boolean isFast() {
        return fast == EAttributeStates.TRUE;
    }

    @Override
    public EType getType() {
        return type;
    }

    @Override
    public int getID() {
        return id;
    }
    

}
