/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import protocol.enums.Action;
import protocol.enums.Attributes;

/**
 *
 * @author Jirka
 */
public class Protokol {

    private static final String PATTERN = "^protokol\\{\\nname:.+;\\n(rule\\{\\nname:[a-zA-Z0-9]+;\\nif:[a-zA-Z0-9]+;\\nthen:[a-zA-Z0-9]+;\\nelse:[a-zA-Z0-9]+;\\n\\}\\n)+\\}$";

    ///CLASS RULE
    public class Rule {

        Rule(String name, String statementIf, String statementElse, String statementThen) {
            this.name = name;
/*
            if (Action.getValueOf(statementElse) == null) {
                throw new IllegalArgumentException("No action for "+statementElse);
            } else if (Action.getValueOf(statementThen) == null) {
                throw new IllegalArgumentException("No action for "+statementThen);
            } else */if (Attributes.getValueOf(statementIf) == null) {
                throw new IllegalArgumentException("No attribute for "+statementIf);
            }

            this.statementElse = statementElse;
            this.statementIf = statementIf;
            this.statementThen = statementThen;
        }

        public String name, statementIf, statementElse, statementThen;
    }
    ///END CLASS RULE

    Map<String, Rule> rules = new HashMap<>();
    Rule startWith = null;
    String protocolName;

    public Protokol(String name) {
        this.protocolName = name;
    }
    
    public void setName(String name){
        this.protocolName = name;
    }

    public void addRule(String name, String statementIf, String statementElse, String statementThen) {
        rules.put(name, new Rule(name, statementIf, statementElse, statementThen));
    }

    public void createFromGroup(Group[] allGroups) {
        int i = 0;
        for (Group group : allGroups) {
            if (((ComboBox) (group.getChildren().get(1))).getValue() == null || group.isVisible() == false) {
                break;
            }
            String staIf = ((ComboBox) (group.getChildren().get(1))).getValue().toString();
            String staThen = ((ComboBox) (group.getChildren().get(2))).getValue().toString();
            String staElse = ((ComboBox) (group.getChildren().get(3))).getValue().toString();
            String name = ((TextField) (((Group) (group.getChildren().get(0))).getChildren().get(3))).getText();
            addRule(name, staIf, staElse, staThen);
            if (i == 0) {
                startWith = new Rule(name, staIf, staElse, staThen);
                i++;
            }
        }
    }

    public void writeToGroup(Group[] allGroups, boolean makeVisible) {
        for (Group group : allGroups) {
            group.setVisible(false);
        }

        int i = 0;
        for (Rule rule : rules.values()) {
            ((ComboBox) (allGroups[i].getChildren().get(1))).getSelectionModel().select(rule.statementIf);
            ((ComboBox) (allGroups[i].getChildren().get(2))).getSelectionModel().select(rule.statementThen);
            ((ComboBox) (allGroups[i].getChildren().get(3))).getSelectionModel().select(rule.statementElse);
            ((TextField) (((Group) (allGroups[i].getChildren().get(0))).getChildren().get(3))).setText(rule.name);

            allGroups[i].setVisible(true);
            i++;
        }
    }

    public String getFirstAsk() {
        return startWith == null ? null : startWith.statementIf;
    }

    public String getFirstResult(boolean check) {
        if (check) {
            return startWith.statementThen;
        }

        return startWith == null ? null : startWith.statementElse;
    }

    public String getAsk(String name) {
        return rules.get(name) == null ? null : rules.get(name).statementIf;
    }

    public String getResult(String name, boolean check) {
        if (check) {
            return rules.get(name) == null ? null : rules.get(name).statementThen;
        }

        return rules.get(name) == null ? null : rules.get(name).statementElse;
    }

    public String exportProtokol() {
        StringBuilder sb = new StringBuilder();

        sb.append("protokol{\n");

        sb.append("name:");
        sb.append(this.protocolName);
        sb.append(";\n");

        for (Map.Entry<String, Rule> entry : rules.entrySet()) {
            sb.append("rule").append("{\n");
            sb.append("name:").append(entry.getKey()).append(";\n");
            sb.append("if:").append(entry.getValue().statementIf).append(";\n");
            sb.append("then:").append(entry.getValue().statementThen).append(";\n");
            sb.append("else:").append(entry.getValue().statementElse).append(";\n");

            sb.append("}\n");
        }

        sb.append('}');

        String toReturn = sb.toString();

        // Create a Pattern object
        Pattern r = Pattern.compile(PATTERN);

        // Now create matcher object.
        Matcher m = r.matcher(toReturn);
        if (!m.find()) {
            throw new IllegalArgumentException("Badly created protokol to export!");
        }

        return sb.toString();
    }

    public static Protokol importProtokol(String pr) {
        // Create a Pattern object
        Pattern r = Pattern.compile(PATTERN);

        // Now create matcher object.
        Matcher m = r.matcher(pr);
        if (!m.find()) {
            throw new IllegalArgumentException("Given string is not in correct state!");
        }

        String[] splits = pr.split("\n");
        Protokol createdProtokol = new Protokol(splits[1].split(":")[1].replace(";", ""));

        for (int i = 2; i < splits.length - 1; i += 6) {
            createdProtokol.addRule(
                    splits[i + 1].split(":")[1].replace(";", ""),
                    splits[i + 2].split(":")[1].replace(";", ""),
                    splits[i + 3].split(":")[1].replace(";", ""),
                    splits[i + 4].split(":")[1].replace(";", "")
            );
        }

        return createdProtokol;
    }
    
    public String getName(){
        return protocolName;
    }
}
