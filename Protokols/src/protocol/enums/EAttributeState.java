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
    TRUE(true, false),
    FALSE(false, true),
    UNKNOWN(false, false);

    boolean isTrue;
    boolean isFalse;
    
    private EAttributeState(boolean isTrue, boolean isFalse){
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
    
    
}
