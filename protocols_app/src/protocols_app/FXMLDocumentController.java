/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocols_app;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import protocol.enums.Attributes;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ChoiceBox<?> choiseIf;
    @FXML
    private Label labelProtokolName;
    @FXML
    private ChoiceBox<?> choiceActionTrue;
    @FXML
    private ChoiceBox<?> choiceActionFalse;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setIfChoices(new ChoiceBox[]{choiseIf});
    } 
    
    private void setIfChoices(ChoiceBox[] boxes){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(Attributes atr : Attributes.values()){
            values.add(atr.toString());
        }
        
        for(ChoiceBox box : boxes){
            box.setItems(values);
        }
    }
    
}
