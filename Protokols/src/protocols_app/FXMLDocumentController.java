/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocols_app;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;
import javax.rmi.CORBA.Util;
import protocol.Universe;
import protocol.enums.Attributes;
import protocol.enums.Type;
import protocol.objects.OurObject;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    private ChoiceBox ifChoice;
    @FXML
    private ChoiceBox<?> choiseIf;
    @FXML
    private ChoiceBox<?> choiceActionTrue;
    @FXML
    private ChoiceBox<?> choiceActionFalse;
    @FXML
    private Button buttonSaveProtocol;
    @FXML
    private Button buttonAddLineProtocol;
    @FXML
    private Button buttonRemoveLineProtocol;
    @FXML
    private TextField fieldProtocolName;
    @FXML
    private Label labelIfID;
    @FXML
    private ChoiceBox<?> choiseIf1;
    @FXML
    private ChoiceBox<?> choiceActionTrue1;
    @FXML
    private ChoiceBox<?> choiceActionFalse1;
    @FXML
    private Label labelIfID1;
    @FXML
    private ChoiceBox<?> choiseIf11;
    @FXML
    private ChoiceBox<?> choiceActionTrue11;
    @FXML
    private ChoiceBox<?> choiceActionFalse11;
    @FXML
    private Label labelIfID11;
    @FXML
    private Button buttonObjectCreate;
    @FXML
    private TextField fieldObjectName;
    @FXML
    private ChoiceBox<?> choiceObjectType;
    @FXML
    private ChoiceBox<?> choiceActiveObject;
    @FXML
    private Button buttonObjectRun;
    @FXML
    private Button buttonObjectDelete;
    @FXML
    private Button buttonObjectLoad;
    @FXML
    private Button buttonCreateAllObject;
    @FXML
    private ChoiceBox<?> choiceActiveProtocol;
    @FXML
    private Button buttonProtocolRun;
    @FXML
    private Button buttonProtocolDelete;
    @FXML
    private Button buttonProtocolLoad;
    @FXML
    private Button buttonProtocolExport;
    @FXML
    private Button buttonImportAndExecute;
    @FXML
    private ChoiceBox<?> choiceAttributeLife;
    @FXML
    private ChoiceBox<?> choiceAttributeBigger;
    @FXML
    private ChoiceBox<?> choiceAttributeActive;
    @FXML
    private ChoiceBox<?> choiceAttributeWeapons;
    @FXML
    private ChoiceBox<?> choiceAttributeFast;
    @FXML
    private ChoiceBox<?> choiceAttributeResources;
    @FXML
    private ChoiceBox<?> choiceAttributeComm;
    
    
    @FXML
    private Button EraseAttrsButton;

    private Universe universe = new Universe();
    private Map<Integer, Pair<String, OurObject>> objectsWithName = new HashMap<>();
    
    private ChoiceBox [] AllChoiceAttributes;
    private String [] AllAttributeNames;
    private ChoiceBox [] AllChoiceObjectType;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setIfChoices(new ChoiceBox[]{choiseIf});
        setAttributeChoises(new ChoiceBox[]{choiceAttributeActive, choiceAttributeBigger, choiceAttributeComm, choiceAttributeFast, choiceAttributeLife, choiceAttributeResources, choiceAttributeWeapons});
        //o
        setTypeChoices(new ChoiceBox[]{choiceObjectType});
        AllChoiceAttributes = (new ChoiceBox[]{choiceAttributeActive, choiceAttributeBigger, choiceAttributeComm, choiceAttributeFast, choiceAttributeLife, choiceAttributeResources, choiceAttributeWeapons});
        AllAttributeNames = (new String[] {"Active_weapons", "Bigger", "Communicates", "Fast", "Life", "Resources", "Weapons"});
        AllChoiceObjectType = (new ChoiceBox[]{choiceObjectType});
        setInitialActiveObjectChoices();
    }

    private void setIfChoices(ChoiceBox[] boxes) {
        ObservableList<String> values = FXCollections.observableArrayList();
        for (Attributes atr : Attributes.values()) {
            values.add(atr.toString());
        }

        for (ChoiceBox box : boxes) {
            box.setItems(values);
        }
    }
    //O
    private void setInitialActiveObjectChoices(){
        for (int i = 0; i < 5; i++) {
            objectsWithName.put(i, new Pair("Default obj", universe.getObjectByID(i)));
        }
        setActiveObjectChoices(choiceActiveObject);
    }
    private void setTypeChoices(ChoiceBox [] boxes){
        ObservableList<String> values = FXCollections.observableArrayList();
        for (Type typ : Type.values()) {
            values.add(typ.toString());
        }
        for (ChoiceBox box : boxes) {
            box.setItems(values);
            box.getSelectionModel().selectLast();
        }
    }
    
   
    private void setAttributeChoises(ChoiceBox[] boxes) {
        ObservableList<String> values = FXCollections.observableArrayList(
                "True", "False", "Undefined"
        );

        for (ChoiceBox box : boxes) {
            box.setItems(values);
            box.getSelectionModel().selectLast();
        }
    }
    private void setActiveObjectChoices(ChoiceBox box){
        ObservableList<String> values = FXCollections.observableArrayList();
        for (Map.Entry<Integer, Pair<String, OurObject>> entry : objectsWithName.entrySet()) {
            Integer key = entry.getKey();
            Pair<String, OurObject> value = entry.getValue();
            String name = value.getKey() + " " + key; 
            values.add(name);
        }
        box.setItems(values);
        box.getSelectionModel().selectLast();
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
    
    @FXML
    private void EraseObject(MouseEvent event) {
        String str = (String)choiceActiveObject.getValue();
        int id = parseLastToId(str);
        if (id > 4){
            universe.removeObj(id);
            objectsWithName.remove(id);
            setActiveObjectChoices(choiceActiveObject);
        }
    }

    @FXML
    private void EraseAllObjectAttributes(MouseEvent event) {
        setUndefined(AllChoiceAttributes);
        setUndefined(AllChoiceObjectType);
        
    }
     private void setUndefined(ChoiceBox[] boxes){
        for (ChoiceBox box : boxes) {
            box.getSelectionModel().selectLast();
        }
    }

    @FXML
    private void CreateObjectButtonMC(MouseEvent event) {
        List<Attributes> trueAttrs = new ArrayList<>();
        List<Attributes> undefAttrs = new ArrayList<>();
        for (ChoiceBox box : AllChoiceAttributes) {
            if(((String)box.getValue()).equals("True")){
                trueAttrs.add(Attributes.toEnum(AttributeButtonToName(box)));
            }
            if(((String)box.getValue()).equals("Undefined")){
                undefAttrs.add(Attributes.toEnum(AttributeButtonToName(box)));
            }            
        }
        int id;
        String name = fieldObjectName.getText();
        switch((String)(AllChoiceObjectType[0].getValue())){
            case "Ship": {
                id = universe.CreateObj(Type.SHIP, trueAttrs, undefAttrs);
                break;
            }
            case "Planet": {
                id = universe.CreateObj(Type.PLANET, trueAttrs, undefAttrs);
                break;
            }
            case "Asteroid": {
                id = universe.CreateObj(Type.ASTEROID, trueAttrs, undefAttrs);
                break;
            }
            default : {
                if (trueAttrs.contains(Attributes.WEAPONS) ||
                        (trueAttrs.contains(Attributes.LIFE)&& trueAttrs.contains(Attributes.FAST) && undefAttrs.contains(Attributes.WEAPONS))){
                    id = universe.CreateObj(Type.SHIP, trueAttrs, undefAttrs);
                    break;
                }
                if(trueAttrs.contains(Attributes.LIFE) || trueAttrs.contains(Attributes.COMUNICATES)){
                    id = universe.CreateObj(Type.PLANET, trueAttrs, undefAttrs);
                    break;
                }
                if(trueAttrs.contains(Attributes.FAST) || 
                        (!trueAttrs.contains(Attributes.BIGGER) && !undefAttrs.contains(Attributes.BIGGER))){
                    id = universe.CreateObj(Type.ASTEROID, trueAttrs, undefAttrs);
                    break;
                }
                id = universe.CreateObj(Type.UNDEFINED, trueAttrs, undefAttrs);
                break;            
            }
        }
        
        if(id>0){
            objectsWithName.put(id, new Pair<>(name, universe.getObjectByID(id)));
            setActiveObjectChoices(choiceActiveObject);
        }
    }
    
    private String AttributeButtonToName (ChoiceBox box){
        int i = 0;
        for (ChoiceBox attr : AllChoiceAttributes) {
            if (attr.equals(box)){
                return AllAttributeNames[i];
            }
            i++;
        }
        return null;
    }
    
    

}
