
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocols_app;

import BussinesLogic.Protokol;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import protocol.Universe;
import protocol.enums.Action;
import protocol.enums.Attributes;
import protocol.enums.Type;
import protocol.objects.OurObject;
import protocol.objects.SpaceObject;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class FXMLDocumentController implements Initializable {

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
    private ChoiceBox choiceActiveProtocol;
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
    
    private ChoiceBox [] AllChoiceAttributes;
    private String [] AllAttributeNames;
    private ChoiceBox [] AllChoiceObjectType;
    @FXML
    private AnchorPane ruleAnchorPane;
    @FXML
    private Group group_1;
    @FXML
    private Group group_2;
    @FXML
    private Group group_3;
    @FXML
    private Group group_4;
    @FXML
    private Group group_5;
    @FXML
    private Group group_6;
    @FXML
    private Group group_7;
    @FXML
    private Group group_8;
    @FXML
    private Group group_9;
    @FXML
    private Group group_10;
    @FXML
    private Group group_11;
    @FXML
    private Group group_12;
    @FXML
    private Group group_13;
    @FXML
    private Group group_14;
    @FXML
    private Group group_15;
    @FXML
    private Group group_16;
    @FXML
    private Group group_17;
    @FXML
    private Group group_18;
    @FXML
    private Group group_19;
    @FXML
    private Group group_20;
    @FXML
    private Group group_21;
    @FXML
    private Group group_22;
    @FXML
    private Group group_23;
    @FXML
    private Group group_24;
    @FXML
    private Group group_25;
    @FXML
    private Group group_26;
    @FXML
    private Group group_27;
    @FXML
    private Group group_28;
    @FXML
    private Group group_29;
    @FXML
    private Group group_30;
    @FXML
    private Group group_31;
    @FXML
    private Group group_32;
    @FXML
    private Group group_33;
    @FXML
    private Group group_34;
    @FXML
    private Group group_35;
    @FXML
    private Group group_36;
    @FXML
    private Group group_37;
    @FXML
    private Group group_38;
    @FXML
    private Group group_39;
    @FXML
    private Group group_40;
    @FXML
    private Group group_41;
    @FXML
    private Group group_42;
    private Group[] allGroups;
    private int lastGroupID = 2;
    private ObservableList<String> thenElseChoices = FXCollections.observableArrayList();
    private Map<String, Protokol> protokols = new LinkedHashMap<>();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setAttributeChoises(new ChoiceBox[]{choiceAttributeActive, choiceAttributeBigger, choiceAttributeComm, choiceAttributeFast, choiceAttributeLife, choiceAttributeResources, choiceAttributeWeapons});
        //o
        setTypeChoices(choiceObjectType);
        AllChoiceAttributes = (new ChoiceBox[]{choiceAttributeActive, choiceAttributeBigger, choiceAttributeComm, choiceAttributeFast, choiceAttributeLife, choiceAttributeResources, choiceAttributeWeapons});
        AllAttributeNames = (new String[] {"Active_weapons", "Bigger", "Communicates", "Fast", "Life", "Resources", "Weapons"});
        AllChoiceObjectType = (new ChoiceBox[]{choiceObjectType});
        setActiveObjectChoices(choiceActiveObject);
        allGroups = (new Group []{group_1,group_2,group_3,group_4,group_5,group_6,
        group_7,group_8,group_9,group_10,group_11,group_12,group_13,group_14,group_15,group_16,
        group_17,group_18,group_19,group_20,group_21,group_22,group_23,group_24,group_25,group_26,
        group_27,group_28,group_29,group_30,group_31,group_32,group_33,group_34,group_35,group_36,group_37,
        group_38,group_39,group_40,group_41,group_42});
        for (int i = 3; i < 42; i++) {
            hideGroup(i);
        }
        for (Action action : Action.values()) {
            thenElseChoices.add(action.toString());
        }
        initializeAllGroups();

    }

    private void setIfChoices(ChoiceBox box) {
        ObservableList<String> values = FXCollections.observableArrayList();
        for (Attributes atr : Attributes.values()) {
            values.add(atr.toString());
        }
        box.setItems(values); 
    }
    //O
    private void setTypeChoices(ChoiceBox box){
        ObservableList<String> values = FXCollections.observableArrayList();
        for (Type typ : Type.values()) {
            values.add(typ.toString());
        }
        box.setItems(values);
        box.getSelectionModel().selectLast();
        
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
    /**
    private void setAttributeChoiceToSpecific(ChoiceBox box){
        box.getSelectionModel().select(i);
    }
    */
    
    private void setActiveObjectChoices(ChoiceBox box){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(Map.Entry<Integer, SpaceObject> uniObject : universe.getObjects().entrySet()){
            Integer key = uniObject.getKey();
            OurObject value = uniObject.getValue();
            String name = value.getName() + " " + key;
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
        List<Attributes> attrs = new ArrayList<>();
        List<Attributes> missing = new ArrayList<>();
        for (ChoiceBox box : AllChoiceAttributes) {
            if(((String)box.getValue()).equals("True")){
                attrs.add(Attributes.toEnum(AttributeButtonToName(box)));
            }
            if(((String)box.getValue()).equals("Undefined")){
                missing.add(Attributes.toEnum(AttributeButtonToName(box)));
            }            
        }
        int id;
        String name = fieldObjectName.getText();
        switch((String)(AllChoiceObjectType[0].getValue())){
            case "Ship": {
                id = universe.CreateObj(Type.SHIP, attrs, missing);
                break;
            }
            case "Planet": {
                id = universe.CreateObj(Type.PLANET, attrs, missing);
                break;
            }
            case "Asteroid": {
                id = universe.CreateObj(Type.ASTEROID, attrs, missing);
                break;
            }
            default : {
                id = universe.CreateObj(Type.UNDEFINED, attrs, missing);
                break;            
            }
        }
        
        if(id>0){
            universe.getObjectByID(id).setName(name);
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
    
    private SpaceObject getActiveObject(){
        String str = (String)choiceActiveObject.getValue();
        int id = parseLastToId(str);
        return universe.getObjectByID(id);
    }

    /**
     * loads attributes of object to createobj
     * note indexes of CHoiceAttribute Selector box 0 = true 1 = false 2 = undefined
     * @param event click
     */
    @FXML
    private void LoadObjAttributes(MouseEvent event) {
        if(getActiveObject().getTrueattr() != null){
            for(Attributes trueAttr : getActiveObject().getTrueattr()){
                int i = 0;
                for(String attrName : AllAttributeNames){
                    if(trueAttr.toString().equals(attrName)){
                        AllChoiceAttributes[i].getSelectionModel().select(0);
                    }
                    i++;
                }
            }
        }
        if(getActiveObject().getMissing() != null){
            for(Attributes missAttr : getActiveObject().getMissing()){
                int i = 0;
                for(String attrName : AllAttributeNames){
                    if(missAttr.toString().equals(attrName)){
                        AllChoiceAttributes[i].getSelectionModel().select(2);
                    }
                    i++;
                }
            }
        }
        if(getActiveObject().getFalseAttr()!= null){
            for(Attributes missAttr : getActiveObject().getFalseAttr()){
                int i = 0;
                for(String attrName : AllAttributeNames){
                    if(missAttr.toString().equals(attrName)){
                        AllChoiceAttributes[i].getSelectionModel().select(1);
                    }
                    i++;
                }
            }
        }
    }
    /**
     * 
     * @param i
     * @return choiceBox [] 0 - if 1 then 2 - else 
     */
    private ChoiceBox [] getChoiceBoxesOfGroup (int i){
        ChoiceBox iff = (ChoiceBox)(allGroups[i].getChildren().get(0));
        ChoiceBox thenn = (ChoiceBox)(allGroups[i].getChildren().get(4));
        ChoiceBox elsee = (ChoiceBox)(allGroups[i].getChildren().get(5));
        return (new ChoiceBox[]{iff, thenn, elsee});
    }
    
    private TextField getTextFieldOfGroup (int i){
        TextField text = (TextField)(allGroups[i].getChildren().get(6));
        return text;
    }
    
    
    void showGroup(int i){
        allGroups[i].setVisible(true);
    }
    
    void hideGroup (int i){
        allGroups[i].setVisible(false);        
    }

    @FXML
    private void deleteLastGroup(MouseEvent event) {
        if(lastGroupID > 2){
            deleteGroupContent(lastGroupID);
            getTextFieldOfGroup(lastGroupID);
            hideGroup(lastGroupID);
            lastGroupID--;
        }
    }
    
    private void deleteGroupContent(int i){
        
    }
    
    private void updateOneThenOrElseChoice(ChoiceBox box){
        box.setItems(thenElseChoices);
        box.getSelectionModel().selectFirst();
    }
    private void updateAllThenElseChoices(){
        for (int i = 0; i < 42; i++) {
            updateOneThenOrElseChoice(getChoiceBoxesOfGroup(i)[1]);
            updateOneThenOrElseChoice(getChoiceBoxesOfGroup(i)[2]);
        }
    }
    
    
    private void initializeAllGroups(){
        for (int i = 0; i < 42; i++) {
            getTextFieldOfGroup(i).setText(Integer.toString(i+1));
            setIfChoices(getChoiceBoxesOfGroup(i)[0]);
        }
        updateAllThenElseChoices();
    }

    @FXML
    private void addNewGroup(MouseEvent event) {
        if(lastGroupID < 42){
            showGroup(lastGroupID + 1);
            lastGroupID++;
            //getTextFieldOfGroup(lastGroupID).setText(Integer.toString(lastGroupID +1));
        }
    }

    @FXML
    private void buttonActionSaveProtokol(ActionEvent event) {
        String name = fieldProtocolName.getText();
        if(name.equals("")){
            name = String.valueOf(protokols.keySet().size() + 1);
        }
        Protokol protokol = new Protokol(name);
        protokol.createFromGroup(allGroups);
        protokols.put(name, protokol);        
        
        choiceActiveProtocol.getItems().add(name);
    }

    @FXML
    private void buttonActionLoadProtokol(ActionEvent event) {
        String name =  choiceActiveProtocol.getSelectionModel().getSelectedItem().toString();
        if(name.equals("")){
            return;
        }
        Protokol protokol = protokols.get(name);
        if(protokol == null){
            return;
        }
        protokol.writeToGroup(allGroups, true);        
    }

    @FXML
    private void buttonActionDeleteProtokol(ActionEvent event) {
        if(choiceActiveProtocol.getItems().size() == 0){
            return;
        }
         String name =  choiceActiveProtocol.getSelectionModel().getSelectedItem().toString();
        if(name.equals("")){
            return;
        }
        Protokol protokol = protokols.remove(name);
        if(protokol == null){
            return;
        }
        
        choiceActiveProtocol.getItems().remove(name);
        if(choiceActiveProtocol.getItems().size() > 0){
            choiceActiveProtocol.getSelectionModel().selectFirst();
        }
    }
    
    

}