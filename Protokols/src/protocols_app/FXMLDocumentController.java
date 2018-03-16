package protocols_app;

import BussinesLogic.HanderImportExport;
import BussinesLogic.HandlerGame;
import BussinesLogic.HandlerObject;
import BussinesLogic.Protokol;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import protocol.enums.EAction;
import protocol.enums.EAttributes;
import protocol.enums.EAttributeStates;
import protocol.enums.EType;
import protocol.objects.IGameObject;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class FXMLDocumentController implements Initializable {

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
    private ChoiceBox<String> choiceObjectType;
    @FXML
    private ChoiceBox<String> choiceActiveObject;
    @FXML
    private Button buttonObjectRun;
    @FXML
    private Button buttonObjectDelete;
    @FXML
    private Button buttonObjectLoad;
    @FXML
    private Button buttonCreateAllObject;
    @FXML
    private ChoiceBox<String> choiceActiveProtocol;
    @FXML
    private Button buttonProtocolRun;
    @FXML
    private Button buttonProtocolDelete;
    @FXML
    private Button buttonProtocolLoad;
    @FXML
    private Button buttonProtocolExport;
    @FXML
    private ChoiceBox<String> choiceAttributeLife;
    @FXML
    private ChoiceBox<String> choiceAttributeBigger;
    @FXML
    private ChoiceBox<String> choiceAttributeActive;
    @FXML
    private ChoiceBox<String> choiceAttributeWeapons;
    @FXML
    private ChoiceBox<String> choiceAttributeFast;
    @FXML
    private ChoiceBox<String> choiceAttributeResources;
    @FXML
    private ChoiceBox<String> choiceAttributeComm;
    @FXML
    private Button EraseAttrsButton;
    private ChoiceBox[] AllChoiceObjectType;
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
    @FXML
    private TextArea fieldOutput;

    private ChoiceBox[] AllChoiceAttributes;
    private String[] AllAttributeNames;
    private Group[] allGroups;
    private int lastGroupID = 2;
    private List<String> thenElseChoicesList = new ArrayList<>();
    private ObservableList<String> thenElseChoices = FXCollections.observableArrayList();
    private Map<String, Protokol> protokols = new LinkedHashMap<>();
    private HandlerGame handlerGame = new HandlerGame();
    @FXML
    private Label labelObjectCreatedCheck;
    @FXML
    private TextField fieldTeamName;
    @FXML
    private Button buttonImport;
    @FXML
    private Button buttonRunAllObjectOnAllProtokol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setAttributeChoises(new ChoiceBox[]{
            choiceAttributeActive,
            choiceAttributeBigger,
            choiceAttributeComm,
            choiceAttributeFast,
            choiceAttributeLife,
            choiceAttributeResources,
            choiceAttributeWeapons});
        //o
        setTypeChoices(choiceObjectType);
        AllChoiceAttributes = (new ChoiceBox[]{
            choiceAttributeActive,
            choiceAttributeBigger,
            choiceAttributeComm,
            choiceAttributeFast,
            choiceAttributeLife,
            choiceAttributeResources,
            choiceAttributeWeapons});

        AllAttributeNames = (new String[]{
            "Active_weapons",
            "Bigger",
            "Communicates",
            "Fast",
            "Life",
            "Resources",
            "Weapons"});

        AllChoiceObjectType = (new ChoiceBox[]{choiceObjectType});
        //setActiveObjectChoices(choiceActiveObject);

        allGroups = (new Group[]{group_1, group_2, group_3, group_4, group_5, group_6,
            group_7, group_8, group_42, group_9, group_10, group_11, group_12, group_13, group_14, group_15, group_16,
            group_17, group_18, group_19, group_20, group_21, group_22, group_23, group_24, group_25, group_26,
            group_27, group_28, group_29, group_30, group_31, group_32, group_33, group_34, group_35, group_36, group_37,
            group_38, group_39, group_40, group_41});

        for (int i = 3; i < 42; i++) {
            hideGroup(i);
        }
        for (EAction action : EAction.values()) {
            thenElseChoices.add(action.toString());
        }

        initializeAllGroups();
        addInitialRules();
        addRulesName();
        updateAllThenElseChoices();

        //hideDebugButtons();
        //DEBUG();
        choiceActiveObject.getItems().addAll(handlerGame.getObjectNames());
        choiceActiveObject.getSelectionModel().selectFirst();

        initTextFieldChangedListeners();
    }

    private void initTextFieldChangedListeners() {
        ChangeListener<String> textFieldListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                for (int i = 0; i < 42; i++) {
                    ComboBox<String> statementThen = getChoiceBoxesOfGroup(i)[1];
                    ComboBox<String> statementElse = getChoiceBoxesOfGroup(i)[2];

                    boolean selectedOldThen = false;
                    boolean selectedOldElse = false;

                    if (statementThen.getValue().equals(oldValue)) {
                        selectedOldThen = true;
                    }

                    if (statementElse.getValue().equals(oldValue)) {
                        selectedOldElse = true;
                    }

                    if (statementThen.getItems().remove(oldValue)) {
                        statementThen.getItems().add(newValue);
                        if (selectedOldThen) {
                            statementThen.getSelectionModel().select(newValue);
                        }
                    }

                    if (statementElse.getItems().remove(oldValue)) {
                        statementElse.getItems().add(newValue);
                        if (selectedOldElse) {
                            statementElse.getSelectionModel().select(newValue);
                        }
                    }
                }
            }
        };
        
        for (int i = 0; i < 42; i++) {
            getTextFieldOfGroup(i).textProperty().addListener(textFieldListener);
        }
    }

    /**
     * This method is for debug purpose only, no impact on actual program
     */
    private void DEBUG() {
        actionCreateAllObject(new ActionEvent());

        List<EAction> actions = new ArrayList<>();
        actions.add(EAction.TRADE);
        actions.add(EAction.CONTACT);
        actions.add(EAction.ESCAPE);
        actions.add(EAction.FLYBY);
        actions.add(EAction.GATHER_RESOURCES);
        actions.add(EAction.SHOOT);

        String result = "";

        for (String objectName : handlerGame.getObjectNames()) {
            IGameObject obj = handlerGame.getObject(objectName);

            result += obj.getType().toString() + "\t";
            result += obj.isFast() ? "1\t" : "0\t";
            result += obj.isBigger() ? "1\t" : "0\t";
            result += obj.isComunicates() ? "1\t" : "0\t";
            result += obj.isResources() ? "1\t" : "0\t";
            result += obj.isWeapons() ? "1\t" : "0\t";
            result += obj.isActWeapons() ? "1\t" : "0\t";
            result += obj.isLife() ? "1\t" : "0\t";

            int maxPoints = -5;
            EAction maxAction = EAction.CONTACT;

            for (EAction act : actions) {
                int currentPoints = obj.doAction(act);
                if (currentPoints > maxPoints) {
                    maxAction = act;
                    maxPoints = currentPoints;
                }
            }
            result += maxPoints + "\t";
            result += maxAction.toString().replaceAll(" ", "");
            result += "\n";
        }

        System.out.println(result);
    }

    /**
     * Hides button to import all and check
     */
    private void hideDebugButtons() {
        buttonCreateAllObject.setVisible(false);
    }

    private void addInitialRules() {
        for (EAction action : EAction.values()) {
            thenElseChoicesList.add(action.toString());
        }
    }

    private void setIfChoices(ComboBox box) {
        ObservableList<String> values = FXCollections.observableArrayList();
        for (EAttributes atr : EAttributes.values()) {
            values.add(atr.toString());
        }
        box.setItems(values);
        box.getSelectionModel().selectFirst();

    }

    private void setTypeChoices(ChoiceBox box) {
        ObservableList<String> values = FXCollections.observableArrayList();
        for (EType typ : EType.values()) {
            values.add(typ.toString());
        }
        box.setItems(values);
        box.getSelectionModel().selectLast();
    }

    private void setAttributeChoises(ChoiceBox[] boxes) {
        ObservableList<String> values = FXCollections.observableArrayList(EAttributeStates.TRUE.toString(),
                EAttributeStates.FALSE.toString(),
                EAttributeStates.UNDEFINED.toString()
        );

        for (ChoiceBox box : boxes) {
            box.setItems(values);
            box.getSelectionModel().selectLast();
        }
    }

    private String getActiveObjectName() {
        return (String) choiceActiveObject.getValue();
    }

    /**
     *
     * @param i
     * @return choiceBox [] 0 - if 1 then 2 - else
     */
    private ComboBox[] getChoiceBoxesOfGroup(int i) {
        ComboBox iff = (ComboBox) (allGroups[i].getChildren().get(1));
        ComboBox thenn = (ComboBox) (allGroups[i].getChildren().get(2));
        ComboBox elsee = (ComboBox) (allGroups[i].getChildren().get(3));
        return (new ComboBox[]{iff, thenn, elsee});
    }

    private TextField getTextFieldOfGroup(int i) {
        TextField text = (TextField) (((Group) (allGroups[i].getChildren().get(0))).getChildren().get(3));
        return text;
    }

    void showGroup(int i) {
        allGroups[i].setVisible(true);
        thenElseChoicesList.add(getTextFieldOfGroup(i).getText());
        updateAllThenElseChoices();
    }

    void hideGroup(int i) {
        allGroups[i].setVisible(false);
    }

    @FXML
    private void deleteLastGroup(MouseEvent event) {
        if (lastGroupID > 2) {
            thenElseChoicesList.remove(getTextFieldOfGroup(lastGroupID).getText());
            deleteGroupContent(lastGroupID);
            hideGroup(lastGroupID);
            updateAllThenElseChoices();
            lastGroupID--;
        }
    }

    private void deleteGroupContent(int groupId) {
        getTextFieldOfGroup(groupId).setText(Integer.toString(groupId + 1));
        setIfChoices(getChoiceBoxesOfGroup(groupId)[0]);
    }

    private void updateOneThenOrElseChoice(ComboBox box) {
        String tmp = (String) box.getValue();
        box.getItems().clear();

        for (String str : thenElseChoicesList) {
            box.getItems().add(str);
        }
        if (tmp == null) {
            box.getSelectionModel().selectFirst();
        } else {
            box.getSelectionModel().select(tmp);
        }
    }

    private void updateAllThenElseChoices() {
        for (int i = 0; i < 42; i++) {
            updateOneThenOrElseChoice(getChoiceBoxesOfGroup(i)[1]);
            updateOneThenOrElseChoice(getChoiceBoxesOfGroup(i)[2]);
        }
    }

    /**
     * TODO: co to dela?
     */
    private void initializeAllGroups() {
        for (int i = 0; i < 42; i++) {
            getTextFieldOfGroup(i).setText(Integer.toString(i + 1));
            setIfChoices(getChoiceBoxesOfGroup(i)[0]);
        }
        updateAllThenElseChoices();
    }

    /**
     * TODO: co to dela?
     *
     * @param event
     */
    @FXML
    private void addNewGroup(MouseEvent event) {
        if (lastGroupID < 42) {
            showGroup(lastGroupID + 1);
            lastGroupID++;
            //getTextFieldOfGroup(lastGroupID).setText(Integer.toString(lastGroupID +1));
        }
    }

    /**
     * TODO add comment
     */
    private void addRulesName() {
        thenElseChoicesList = new ArrayList<>();
        addInitialRules();
        for (int i = 0; i < lastGroupID + 1; i++) {
            String text = getTextFieldOfGroup(i).getText();
            if (!thenElseChoicesList.contains(text)) {
                thenElseChoicesList.add(text);
            }
        }
    }

    private String getActiveProtocolName() {
        return choiceActiveProtocol.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void actionCreateAllObject(ActionEvent event) {
        HandlerObject.createAllObjects().stream().forEach(
                go -> updateObjectsAdd(go)
        );
    }

    private void updateObjects() {
        choiceActiveObject.getItems().setAll(handlerGame.getObjectNames());
        choiceActiveObject.getSelectionModel().selectLast();
    }

    private void updateObjectsAdd(IGameObject go) {
        handlerGame.addCustomObject(go);
        choiceActiveObject.getItems().add(go.getName());
        choiceActiveObject.getSelectionModel().selectLast();
    }

    private void updateObjectsRemove(String name) {
        if (handlerGame.removeCustomObject(name)) {
            choiceActiveObject.getItems().remove(name);
            choiceActiveObject.getSelectionModel().selectLast();
        }
    }

    private void updateProtokols() {
        choiceActiveProtocol.getItems().setAll(handlerGame.getProtocolNames());
        choiceActiveProtocol.getSelectionModel().selectLast();
    }

    private void writeOutput(String output) {
        fieldOutput.setText(output);
    }

    @FXML
    private void actionObjectDelete(ActionEvent event) {
        //if deleted remove from choice box
        String activeObject = getActiveObjectName();
        updateObjectsRemove(activeObject);
    }

    @FXML
    private void actionObjectCreate(ActionEvent event) {
        //saving properties
        String name = fieldObjectName.getText();
        EType type = EType.get(choiceObjectType.getValue());
        EAttributeStates life = EAttributeStates.get(choiceAttributeLife.getValue()); //life
        EAttributeStates communicate = EAttributeStates.get(choiceAttributeComm.getValue());//communicates
        EAttributeStates resources = EAttributeStates.get(choiceAttributeResources.getValue()); //resources
        EAttributeStates bigger = EAttributeStates.get(choiceAttributeBigger.getValue()); //bigger
        EAttributeStates weapons = EAttributeStates.get(choiceAttributeWeapons.getValue()); //weapons
        EAttributeStates activeWeapons = EAttributeStates.get(choiceAttributeActive.getValue()); //active weapons
        EAttributeStates fast = EAttributeStates.get(choiceAttributeFast.getValue());

        //creating
        IGameObject go = HandlerObject.createObject(
                name,
                type,
                life,
                communicate,
                resources,
                bigger,
                weapons,
                activeWeapons,
                fast
        );

        // if null, cannot be created
        if (go == null) {
            labelObjectCreatedCheck.setTextFill(Color.RED);
            labelObjectCreatedCheck.setText("FAIL");
            //show result and save
        } else {
            updateObjectsAdd(go);

            labelObjectCreatedCheck.setTextFill(Color.GREEN);
            labelObjectCreatedCheck.setText("OK");
        }
    }

    @FXML
    private void actionObjectLoad(ActionEvent event) {
        IGameObject go = handlerGame.getCustomObject(getActiveObjectName());

        if (go == null) {
            return;
        }

        //remove id from name and save
        fieldObjectName.setText(go.getName().substring(0, go.getName().lastIndexOf("_")));

        choiceObjectType.getSelectionModel().select(go.getGivenType().toString());
        choiceAttributeLife.getSelectionModel().select(go.getLife().toString());
        choiceAttributeComm.getSelectionModel().select(go.getComunicates().toString());
        choiceAttributeResources.getSelectionModel().select(go.getResources().toString());
        choiceAttributeBigger.getSelectionModel().select(go.getBigger().toString());
        choiceAttributeWeapons.getSelectionModel().select(go.getWeapons().toString());
        choiceAttributeActive.getSelectionModel().select(go.getActWeapons().toString());
        choiceAttributeFast.getSelectionModel().select(go.getFast().toString());
    }

    @FXML
    private void actionObjectSelected(ActionEvent event) {
        if (choiceActiveObject.getSelectionModel().getSelectedIndex() < 5) {
            buttonObjectLoad.setDisable(true);
            buttonObjectDelete.setDisable(true);
        } else {
            buttonObjectLoad.setDisable(false);
            buttonObjectDelete.setDisable(false);
        }
    }

    @FXML
    private void actionProtokolRunAll(ActionEvent event) {
        String activeProtokol = getActiveProtocolName();
        if (activeProtokol == null) {
            return;
        }

        int globalResult = 0;
        String output = "";
        for (String name : handlerGame.getObjectNames()) {
            int result = handlerGame.evaluateProtokol(activeProtokol, name);
            output += String.valueOf(result) + ", ";
            globalResult += result;
        }

        output += "\r\n-------------"
                + "\r\nResult: " + globalResult;
        writeOutput(output);
    }

    @FXML
    private void actionProtokolSave(ActionEvent event) {
        //save to inner database
        Protokol protokol = new Protokol(fieldProtocolName.getText());
        protokol.createFromGroup(allGroups);
        handlerGame.addProtokol(protokol);

        //add to choice box
        choiceActiveProtocol.getItems().add(protokol.getName());
        choiceActiveProtocol.getSelectionModel().selectLast();
    }

    @FXML
    private void actionObjectRun(ActionEvent event) {
        String activeProtokol = getActiveProtocolName();

        if (activeProtokol == null) {
            writeOutput("Have to select protokol!");
            return;
        }

        int result = handlerGame.evaluateProtokol(activeProtokol, getActiveObjectName());

        writeOutput(String.valueOf(result));
    }

    @FXML
    private void actionProtokolDelete(ActionEvent event) {
        if (handlerGame.removeProtocol(getActiveProtocolName())) {
            choiceActiveProtocol.getItems().remove(getActiveProtocolName());
            choiceActiveProtocol.getSelectionModel().selectLast();
        }
    }

    @FXML
    private void actionProtokolLoad(ActionEvent event) {
        String name = getActiveProtocolName();

        //if there is no protocol selected
        if (name == null) {
            return;
        }
        Protokol protokol = handlerGame.getProtokol(name);
        //if there is no protocol in database
        if (protokol == null) {
            return;
        }

        //write protocol into panel
        protokol.writeToGroup(allGroups, true);
    }

    @FXML
    private void actionProtokolExport(ActionEvent event) throws IOException {
        String name;
        if ((name = getActiveProtocolName()) != null) {
            String teamName = fieldTeamName.getText();
            if (teamName.equals("")) {
                writeOutput("Vyplnte prosim jmeno tymu!");
            } else if (HanderImportExport.exportProtocols("", handlerGame.getProtokol(name), teamName)) {
                writeOutput("Protokol ulozen");
            } else {
                writeOutput("Neco se pokazilo, org je potreba");
            }
        } else {
            writeOutput("Ulozte protokol!");
        }
    }

    @FXML
    private void actionProtokolImport(ActionEvent event) {
        HanderImportExport.importProtocols(handlerGame);

        //add to choice box
        choiceActiveProtocol.getItems().setAll(handlerGame.getProtocolNames());
        choiceActiveProtocol.getSelectionModel().selectLast();
    }

    @FXML
    private void actionRunAllObjectOnAllProtokols(ActionEvent event) {
        int longestNameSize = 0;
        for (String protokolName : handlerGame.getProtocolNames()){
            if(longestNameSize < protokolName.length()){
                longestNameSize = protokolName.length();
            }
        }
        longestNameSize++;
        
        String output = "";
        for (String protokolName : handlerGame.getProtocolNames()) {
            int teamResult = 0;
            
            
            for (String name : handlerGame.getObjectNames()) {
                int result = handlerGame.evaluateProtokol(protokolName, name);
                teamResult += result;
            }

            output += protokolName + " :";
            for(int i = 0; i < (longestNameSize - protokolName.length()); i++){
                output += " ";
            }
            output += teamResult + "\r\n";
        }
        
        writeOutput(output);
    }

    @FXML
    private void actionEraseAll(ActionEvent event) {
        ChoiceBox atributteBox[] = new ChoiceBox[]{
            choiceObjectType,
            choiceAttributeActive,
            choiceAttributeBigger,
            choiceAttributeComm,
            choiceAttributeFast,
            choiceAttributeLife,
            choiceAttributeResources,
            choiceAttributeWeapons};

        for (ChoiceBox box : atributteBox) {
            box.getSelectionModel().select(EAttributeStates.UNDEFINED.toString());
        }
        
        
    }

    private void actionTextFieldChange(InputMethodEvent event) {
        System.out.println("pes");
        System.out.println(event.getCommitted());
        int neco1 = 5;
    }
}
