package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
public class login  {
    public static String guest_name,room_name;
    public static String guest_checkin;
    public static String guest_checkout;
    public static Integer room_id;
    private  Stage stage;
    @FXML
    Button mybutton;
    @FXML
    TextField username;
    @FXML
    PasswordField password;

    String un_manager="manager",pw_manager="password";
    String un_admin = "admin", pw_admin = "password";
    public static String guest_id;


    //Wrong Password or Username Warning Message
    public void wrong_un_pass()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Wrong Username and Password");
        alert.showAndWait();

    }
    //Empty Username or Password

    public void empty_un_pass()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Put both Username and Password");
        alert.showAndWait();
    }


    public String getGuest_un()
    {
        return guest_id;
    }

    //Admin

    //Admin Panel Login Check
    public void go_adm_pan(ActionEvent event)  {

        if((username.getText().isEmpty())||(password.getText().isEmpty()))
        {
            empty_un_pass();
        }
        else
        {
            validate_admin_login(event);
        }
    }
    //Validating Admin Login
    private void  validate_admin_login(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM hotel.admin Where username = '"+username.getText()+"' and password = '"+password.getText()+"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    admin_dashboard(event);
                }
                else {
                    wrong_un_pass();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    //Going to the admin dashboard
    private void admin_dashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_panel.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel Management System");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }


    //Receptionist

    //Receptionist Panel login Check
    public void go_rec_pan (ActionEvent event)  {
        if((username.getText().isEmpty())||(password.getText().isEmpty()))
        {
            empty_un_pass();
        }
        else
        {
            validate_recep_login(event);
        }

    }
    private void validate_recep_login(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM hotel.receptionist Where username = '"+username.getText()+"' and password = '"+password.getText()+"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if(queryResult.getInt(1)==1){

                    recep_dashboard(event);
                }
                else {
                    wrong_un_pass();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    private void recep_dashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("receptionist_panel.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel Management System");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }



    //Guest
    //guest_panel_login_check
    public void go_guest_pan (ActionEvent event)  {
        if((username.getText().isEmpty())||(password.getText().isEmpty()))
        {
            empty_un_pass();
        }
        else
        {
            validate_guest_login(event);
        }

    }
    private void validate_guest_login(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
       // String verifyLogin = "SELECT count(1),name,checkin,checkout FROM hotel.guest Where username = '"+username.getText()+"' and password = '"+password.getText()+"'";
        String verifyLogin = "SELECT count(1),name,checkin,checkout,rooms.room_id, rooms.room_type, guest.guest_id FROM hotel.guest JOIN hotel.rooms ON guest.guest_id = rooms.room_id Where username = '"+username.getText()+"' and password = '"+password.getText()+"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    guest_id=username.getText();
                    guest_name=queryResult.getString("name");
                    guest_checkin=queryResult.getString("checkin");
                    guest_checkout=queryResult.getString("checkout");
                    room_name=queryResult.getString("room_type");
                    room_id=queryResult.getInt("room_id");
                    guest_dashboard(event);
                }
                else {
                    wrong_un_pass();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    private void guest_dashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("guest_panel.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel Management System");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }



    //Management
    //Management Panel Login Check
    public void go_man_pan(ActionEvent event) throws IOException{

        if((username.getText().equals(un_manager)) && (password.getText().equals(pw_manager)) )
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("management_panel.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Hotel Management System");
            stage.setResizable(false);
            stage.show();
        }
        else
        {
            wrong_un_pass();
        }

    }

}
