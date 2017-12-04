/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Jirka
 */
public class Protokol {
    public class Rule{
        
        Rule(String name,String statementIf,String statementElse,String statementThen){
            this.name = name;
            this.statementElse = statementElse;
            this.statementIf = statementIf;
            this.statementThen = statementThen;
        }
        
        public String name, statementIf, statementElse, statementThen;
    }
    
    Map<String, Rule> rules = new HashMap<>();
    String protocolName;

    public Protokol(String name) {
        this.protocolName = name;
    }
    
    public void addRule(String name,String statementIf,String statementElse,String statementThen){
        rules.put(name, new Rule(name, statementIf, statementElse, statementElse));
    }
    
    public void createFromGroup(Group[] allGroups){
        for(Group group : allGroups){
            if(((ChoiceBox)(group.getChildren().get(0))).getValue() == null || group.isVisible() == false){
                break;
            }
            String staIf = ((ChoiceBox)(group.getChildren().get(0))).getValue().toString();
            String staThen = ((ChoiceBox)(group.getChildren().get(4))).getValue().toString();
            String staElse = ((ChoiceBox)(group.getChildren().get(5))).getValue().toString();
            String name = ((TextField)(group.getChildren().get(6))).getText();
            addRule(name, staIf, staElse, staThen);
        }
    }
    
   public void writeToGroup(Group[] allGroups, boolean makeVisible){
       for(Group group : allGroups){
           group.setVisible(false);
       }
       
       int i = 0;
       for(Rule rule : rules.values()){
           ((ChoiceBox)(allGroups[i].getChildren().get(0))).getSelectionModel().select(rule.statementIf);
           ((ChoiceBox)(allGroups[i].getChildren().get(4))).getSelectionModel().select(rule.statementThen);
           ((ChoiceBox)(allGroups[i].getChildren().get(5))).getSelectionModel().select(rule.statementElse);
           ((TextField)(allGroups[i].getChildren().get(6))).setText(rule.name);        
           
            allGroups[i].setVisible(true);
           i++;
       }       
    }  
    
}
