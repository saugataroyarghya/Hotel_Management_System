package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController extends Component implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button mybutton = new Button();
    @FXML
    public ChoiceBox<String> cb= new ChoiceBox<String>();

    String[] opts = {"Admin Panel","Management Panel","Receptionist Panel","Guest Panel"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb.getItems().addAll(opts);
    }


    public void login(ActionEvent event) throws IOException {

            if (cb.getValue() == "Admin Panel") {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_login.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Hotel Management System");
                stage.setResizable(false);
                stage.show();
            } else if (cb.getValue() == "Management Panel") {
                Parent root = FXMLLoader.load(getClass().getResource("manage_login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Hotel Management System");
                stage.setResizable(false);
                stage.show();
            } else if (cb.getValue() == "Guest Panel") {
                Parent root = FXMLLoader.load(getClass().getResource("guest_login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Hotel Management System");
                stage.setResizable(false);
                stage.show();
            }
            else if (cb.getValue() == "Receptionist Panel") {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("receptionist_login.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Hotel Management System");
                stage.setResizable(false);
                stage.show();
            }

        else{
            //JOptionPane.showMessageDialog(this,"Select any Option");
                /*
            String toastMsg = "Select any Option";
            int toastMsgTime = 3500; //3.5 seconds
            int fadeInTime = 500; //0.5 seconds
            int fadeOutTime= 500; //0.5 seconds
            Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            */
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Please select any Option");
            alert.showAndWait();
        }
    }
}
