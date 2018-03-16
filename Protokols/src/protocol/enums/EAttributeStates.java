/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol.enums;

/**
 *
 * @author Jirka
 */
public enum EAttributeStates {
    TRUE("True", true, false),
    FALSE("False", false, true),
    UNDEFINED("I don`t care", false, false);

    boolean isTrue;
    boolean isFalse;
    String name;
    
    private EAttributeStates(String name, boolean isTrue, boolean isFalse){
        this.isTrue = isTrue;
        this.isFalse = isFalse;
        this.name = name;
    }
    
    public boolean is() {
        return isTrue;
    }
    
    public boolean isNot(){
        return isFalse;
    }
    
    public boolean isUnknown(){
        return !isFalse && !isTrue;
    }
    
    public static EAttributeStates get(boolean bool){
        if(bool){
            return TRUE;
        }else{
            return FALSE;
        }
    }
    
    public static EAttributeStates get(String pattern){
        if(pattern.equals(EAttributeStates.TRUE.toString())){
            return TRUE;
        }
        
        if(pattern.equals(EAttributeStates.FALSE.toString())){
            return FALSE;
        }
        
        if(pattern.equals(EAttributeStates.UNDEFINED.toString())){
            return UNDEFINED;
        }
        
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
