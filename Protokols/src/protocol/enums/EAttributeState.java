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
public enum EAttributeState {
    TRUE("True", true, false),
    FALSE("False", false, true),
    UNDEFINED("Undefined", false, false);

    boolean isTrue;
    boolean isFalse;
    String name;
    
    private EAttributeState(String name, boolean isTrue, boolean isFalse){
        this.isTrue = isTrue;
        this.isFalse = isFalse;
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
    
    
    public static EAttributeState get(String pattern){
        if(pattern.equals("True")){
            return TRUE;
        }
        
        if(pattern.equals("False")){
            return FALSE;
        }
        
        if(pattern.equals("Undefined")){
            return UNDEFINED;
        }
        
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
