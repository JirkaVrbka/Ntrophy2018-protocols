package BussinesLogic;

import javafx.util.Pair;
import protocol.enums.Action;
import protocol.enums.Attributes;
import protocol.objects.IGameObject;
import protocol.objects.SpaceObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jirka
 */
public class HandlerProtocol {
    
    /**
     * Evaluate protocol with given object
     *
     * @param protokol to eval
     * @param spaceObject to be checked
     * @return number of points
     */
    public static int evalProtokol(Protokol protokol, IGameObject gameObject) {
        String firstAsk = protokol.getFirstAsk();
        boolean res = hasAttribute(firstAsk, gameObject);
        String answer = protokol.getFirstResult(res);

        Action action = Action.getValueOf(answer);

        int i = 0;
        //iterate until some action
        while (action == null) {
            res = hasAttribute(protokol.getAsk(answer), gameObject);
            answer = protokol.getResult(answer, res);
            action = Action.getValueOf(answer);
            i++;
            if (i > 500) {
                //too many cycles, there is a problem there
                return -500000;
            }
        }

        //Pair<Integer, Boolean> result = universe.evalAction(action, spaceObject.getID());

        //cannot decide -> kill
       /* if (result.getValue() == false) {
            return -9999;
        }*/

        //I can decide -> value of decision
       // return result.getKey();
       return gameObject.doAction(action);
    }
    
    private static boolean hasAttribute(String attribute, IGameObject gameObject){
        Attributes att = Attributes.getValueOf(attribute);
        
        switch (att){
                    case LIFE: {
                        return gameObject.isLife();
                    }
                    case COMUNICATES:{
                        return gameObject.isComunicates();
                    }
                    case BIGGER: {
                        return gameObject.isBigger();
                    }
                    case ACT_WEAPON:{
                        return gameObject.isActWeapons();
                    }
                    case WEAPONS:{
                        return gameObject.isWeapons();
                    }
                    case RESOURCES:{
                        return gameObject.isResources();
                    }
                    case FAST: {
                        return gameObject.isFast();
                    }
        }
        
        return false;
    }
}
