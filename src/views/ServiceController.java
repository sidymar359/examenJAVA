/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import models.Employes;
import models.Service;
import services.services;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ServiceController implements Initializable {

    @FXML
    private TableView<Employes> tblvEmp;
    @FXML
    private JFXTextField addServiceFld;
    @FXML
    private JFXTextField filterField;
    @FXML
    private TableColumn<Employes, String> idCol;
    @FXML
    private TableColumn<Employes, String> nomCol;
    @FXML
    private TableColumn<Employes, String> dateCol;
    
    private services serv ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        serv = new services();
        
    }    
    
    

    @FXML
    private void HandleAddEmployes(MouseEvent event) {
    }

    @FXML
    private void handleAddService(MouseEvent event) {
      String libelle =  addServiceFld.getText();
  
      serv.saveSerice(libelle);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText(null);
        alert.setContentText("Nouveau service ajouter");

        alert.showAndWait();
    }

    @FXML
    private void HandleQuitt(MouseEvent event) {
    }
    
}
