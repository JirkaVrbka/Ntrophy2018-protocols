/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.objects;

import java.util.ArrayList;
import java.util.List;
import protocol.enums.Attributes;
import protocol.enums.EAttributeState;
import protocol.enums.Type;

/**
 *
 * @author Jirka
 */
public abstract class AGameObject implements IGameObject {

    private static int idGenerator = 1;
    
    private final EAttributeState life;
    private final EAttributeState comunicates;
    private final EAttributeState resources;
    private final EAttributeState bigger;
    private final EAttributeState weapons;
    private final EAttributeState actWeapons;
    private final EAttributeState fast;
    private final Type type;
    private final String name;
    private final int id;
    

    public AGameObject(String name,
            Type type,
            EAttributeState life,
            EAttributeState comunicates,
            EAttributeState resources,
            EAttributeState bigger,
            EAttributeState weapons,
            EAttributeState actWeapons,
            EAttributeState fast) {

        id = idGenerator;
        idGenerator++;
        this.type = type;
        this.name = name + "_" + id;
        this.life = life;
        this.comunicates = comunicates;
        this.resources = resources;
        this.bigger = bigger;
        this.weapons = weapons;
        this.actWeapons = actWeapons;
        this.fast = fast;
        
    }
    
    protected void idGeneratorMinusOne(){
        idGenerator--;
    }
    
    @Override
    public EAttributeState getLife() {
        return life;
    }

    @Override
    public EAttributeState getComunicates() {
        return comunicates;
    }

    @Override
    public EAttributeState getResources() {
        return resources;
    }

    @Override
    public EAttributeState getBigger() {
        return bigger;
    }

    @Override
    public EAttributeState getWeapons() {
        return weapons;
    }

    @Override
    public EAttributeState getActWeapons() {
        return actWeapons;
    }

    @Override
    public EAttributeState getFast() {
        return fast;
    }

    public int getId() {
        return id;
    }

    private List<Attributes> getAttributesWithState(EAttributeState state) {
        List<Attributes> withState = new ArrayList<>();
        
        if(this.life == state){
            withState.add(Attributes.LIFE);
        }
        if(this.comunicates == state){
            withState.add(Attributes.COMUNICATES);
        }
        if(this.resources == state){
            withState.add(Attributes.RESOURCES);
        }
        if(this.bigger == state){
            withState.add(Attributes.BIGGER);
        }
        if(this.weapons == state){
            withState.add(Attributes.WEAPONS);
        }
        if(this.actWeapons == state){
            withState.add(Attributes.ACT_WEAPON);
        }
        if(this.fast == state){
            withState.add(Attributes.FAST);
        }
        
        return withState;
    }

    @Override
    public List<Attributes> getTrueAttr() {
       return getAttributesWithState(EAttributeState.TRUE);
    }

    @Override
    public List<Attributes> getMissingAttr() {
        return getAttributesWithState(EAttributeState.UNDEFINED);
    }

    @Override
    public List<Attributes> getFalseAttr() {
        return getAttributesWithState(EAttributeState.FALSE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLife() {
        return life == EAttributeState.TRUE;
    }

    @Override
    public boolean isComunicates() {
        return comunicates == EAttributeState.TRUE;
    }

    @Override
    public boolean isResources() {
        return resources == EAttributeState.TRUE;
    }

    @Override
    public boolean isBigger() {
        return bigger == EAttributeState.TRUE;
    }

    @Override
    public boolean isWeapons() {
        return weapons == EAttributeState.TRUE;
    }

    @Override
    public boolean isActWeapons() {
        return actWeapons == EAttributeState.TRUE;
    }

    @Override
    public boolean isFast() {
        return fast == EAttributeState.TRUE;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getID() {
        return id;
    }
    

}
