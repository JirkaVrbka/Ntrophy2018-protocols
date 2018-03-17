/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jirka
 */
public final class HandlerTextFieldChanged {
    public static Map<Integer, Boolean> focusedThen = new LinkedHashMap<>();
    public static Map<Integer, Boolean> focusedElse = new LinkedHashMap<>();
    public static boolean shouldFocus = true;
    
    private HandlerTextFieldChanged(){
        
    }
}
