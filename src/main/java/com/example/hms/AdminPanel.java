
package com.example.hms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {


    @FXML
    private RadioButton telephone_radio;

    @FXML
    private RadioButton television_radio;
    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button btn_booking;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_guest;

    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_manager;

    @FXML
    private Button btn_overview;

    @FXML
    private Button btn_recep;

    @FXML
    private Button btn_room;

    @FXML
    private Button btn_signout;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_view;

    @FXML
    private Button btn_room_delete;

    @FXML
    private Button btn_room_insert;

    @FXML
    private Button btn_room_update;

    @FXML
    private Button btn_room_view;
    @FXML
    private Pane pan_booking;

    @FXML
    private Pane pan_guest;

    @FXML
    private Pane pan_manager;

    @FXML
    private Pane pan_receptionist;

    @FXML
    private Pane pan_rooms;

    @FXML
    private Pane pane_overview;

    @FXML
    private TextField roomTF_ID;
    @FXML
    private TextField recep_id;

    @FXML
    private TextField recep_name;

    @FXML
    private TextField recep_pw;
    @FXML
    private TextField roomTF_ExclusiveView;
    @FXML
    private TextField recep_un;
    @FXML
    private TableView<Guests> guest_table;
    @FXML
    private TableView<Receptionist> recep_table;
    @FXML
    private TableColumn<Receptionist,Integer>recep_tableID;
    @FXML
    private TableColumn<Receptionist,String>recep_tablename;
    @FXML
    private TableColumn<Receptionist,String>recep_tableusername;
    @FXML
    private TableColumn<Receptionist,String>recep_tablepassword;

    @FXML
    private TableColumn<Guests, String> guest_ccn;

    @FXML
    private TableColumn<Guests, String> guest_cct;

    @FXML
    private TableColumn<Guests, Date> guest_check_in;

    @FXML
    private TableColumn<Guests, Date> guest_check_out;

    @FXML
    private TableColumn<Guests, Integer> guest_city;
    @FXML
    private TableColumn<Guests, Integer> guest_address;

    @FXML
    private TableColumn<Guests, String> guest_company;

    @FXML
    private TableColumn<Guests, String> guest_country;
    @FXML
    private TableColumn<Guests, Date> guest_date_of_birth;

    @FXML
    private TableColumn<Guests, Integer> guest_id;

    @FXML
    private TableColumn<Guests, String> guest_job_title;

    @FXML
    private TableColumn<Guests, String> guest_name;

    @FXML
    private TableColumn<Guests, String> guest_phone;

    @FXML
    private TableColumn<Guests, String> guest_pw;

    @FXML
    private TableColumn<Guests, String> guest_un;

    @FXML
    private DatePicker TF_Guest_CHECKIN;

    @FXML
    private DatePicker TF_Guest_CHECKOUT;

    @FXML
    private TextField TF_Guest_Credit_Card;

    @FXML
    private DatePicker TF_Guest_DOB;

    @FXML
    private TextField TF_guest_city;

    @FXML
    private TextField TF_guest_country;

    @FXML
    private TextField TF_guest_name;

    @FXML
    private TextField TF_guestid;
    @FXML
    private TableView<Rooms>room_table;
    @FXML
    private TableColumn<Rooms,Integer>room_tableID;
    @FXML
    private TableColumn<Rooms,String>room_tabletype;
    @FXML
    private TableColumn<Rooms,String>room_tabletelephone;
    @FXML
    private TableColumn<Rooms,String>room_tabletelevision;
    @FXML
    private TableColumn<Rooms,String>room_tableExclusiveView;

    @FXML
    public ChoiceBox<String> cb= new ChoiceBox<String>();

    //methods for rooms
    public String get_television(){
        if(television_radio.isSelected())
            return "Yes";
        else
            return "No";

    }
    public String get_telephone(){
        if(telephone_radio.isSelected())
            return "Yes";
        else
            return "No";
    }
    String[] opts = {"Adjoining Room","Apartment-Styled Room","Delux Room","Duplex","Junior Suite","Presidential Suite","Studio Room","Suite"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb.getItems().addAll(opts);
    }

    //SignOut Method
    public void return_login() throws IOException {

    }

    //Guest Panel
    public void guest_search() throws SQLException {
        ObservableList<Guests> GuestObservableList= FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();

        String guestviewQuery = "SELECT * FROM guest WHERE ";

        boolean first = true;
        if(!TF_guest_name.getText().isEmpty()){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" name = '"+TF_guest_name.getText()+"'");
            first=false;
        }
        if(!TF_guest_city.getText().isEmpty()){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" city = '"+TF_guest_city.getText()+"'");
            first=false;
        }
        if(!TF_guest_country.getText().isEmpty()){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" country = '"+TF_guest_country.getText()+"'");
            first=false;
        }
        if(!TF_guestid.getText().isEmpty()){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" guest_id = '"+TF_guestid.getText()+"'");
            first=false;
        }
        if(!TF_Guest_Credit_Card.getText().isEmpty()){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" credit_card_type = '"+TF_Guest_Credit_Card.getText()+"'");
            first=false;
        }
        if(TF_Guest_DOB.getValue()!=null){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" date_of_birth = '"+TF_Guest_DOB.getValue().toString()+"'");
            first=false;
        }
        if(TF_Guest_CHECKIN.getValue()!=null){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" checkin = '"+TF_Guest_CHECKIN.getValue().toString()+"'");
            first=false;
        }
        if(TF_Guest_CHECKOUT.getValue()!=null){
            if (!first)
            {
                guestviewQuery+=" AND ";
            }
            guestviewQuery+=(" checkout = '"+TF_Guest_CHECKOUT.getValue().toString()+"'");
            first=false;
        }

        System.out.println(guestviewQuery);

        Statement statement = connectionDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(guestviewQuery);

        while(queryOutput.next()) {
            Integer guest_ID = queryOutput.getInt("guest_id");
            String guest_name = queryOutput.getString("name");
            String guest_username = queryOutput.getString("username");
            String guest_password = queryOutput.getString("password");
            String guest_address = queryOutput.getString("address");
            String guest_city = queryOutput.getString("city");
            String guest_country = queryOutput.getString("country");
            String guest_phone = queryOutput.getString("phone");
            String guest_company = queryOutput.getString("company");
            String guest_job = queryOutput.getString("job_title");
            String guest_credit_card_no = queryOutput.getString("credit_card_no");
            String guest_credit_card_type = queryOutput.getString("credit_card_type");
            Date guest_date_of_birth = queryOutput.getDate("date_of_birth");
            Date guest_checkin = queryOutput.getDate("checkin");
            Date guest_checkout = queryOutput.getDate("checkout");

            //populate the observable list
            GuestObservableList.add(new Guests(guest_ID, guest_name, guest_username, guest_password, guest_address, guest_city, guest_country, guest_phone, guest_job, guest_company, guest_credit_card_no, guest_credit_card_type, guest_date_of_birth, guest_checkin, guest_checkout));
        }
        guest_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        guest_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        guest_un.setCellValueFactory(new PropertyValueFactory<>("username"));
        guest_pw.setCellValueFactory(new PropertyValueFactory<>("password"));
        guest_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        guest_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        guest_country.setCellValueFactory(new PropertyValueFactory<>("country"));
        guest_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        guest_job_title.setCellValueFactory(new PropertyValueFactory<>("job_title"));
        guest_company.setCellValueFactory(new PropertyValueFactory<>("company"));
        guest_ccn.setCellValueFactory(new PropertyValueFactory<>("credit_card_no"));
        guest_cct.setCellValueFactory(new PropertyValueFactory<>("credit_card_type"));
        guest_date_of_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        guest_check_in.setCellValueFactory(new PropertyValueFactory<>("checking_in"));
        guest_check_out.setCellValueFactory(new PropertyValueFactory<>("checking_out"));

        guest_table.setItems(GuestObservableList);
        connectionDB.close();
    }
    public void guest_show() throws SQLException {
        //System.out.println("Hello");
        ObservableList<Guests> GuestObservableList= FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();

        String guestviewQuery = "SELECT * FROM guest;";

        Statement statement = connectionDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(guestviewQuery);

        while(queryOutput.next()) {
            Integer guest_ID = queryOutput.getInt("guest_id");
            String guest_name = queryOutput.getString("name");
            String guest_username = queryOutput.getString("username");
            String guest_password = queryOutput.getString("password");
            String guest_address = queryOutput.getString("address");
            String guest_city = queryOutput.getString("city");
            String guest_country = queryOutput.getString("country");
            String guest_phone = queryOutput.getString("phone");
            String guest_company = queryOutput.getString("company");
            String guest_job = queryOutput.getString("job_title");
            String guest_credit_card_no = queryOutput.getString("credit_card_no");
            String guest_credit_card_type = queryOutput.getString("credit_card_type");
            Date guest_date_of_birth = queryOutput.getDate("date_of_birth");
            Date guest_checkin = queryOutput.getDate("checkin");
            Date guest_checkout = queryOutput.getDate("checkout");

            //populate the observable list
            GuestObservableList.add(new Guests(guest_ID, guest_name, guest_username, guest_password, guest_address, guest_city, guest_country, guest_phone, guest_job, guest_company, guest_credit_card_no, guest_credit_card_type, guest_date_of_birth, guest_checkin, guest_checkout));
        }
        guest_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        guest_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        guest_un.setCellValueFactory(new PropertyValueFactory<>("username"));
        guest_pw.setCellValueFactory(new PropertyValueFactory<>("password"));
        guest_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        guest_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        guest_country.setCellValueFactory(new PropertyValueFactory<>("country"));
        guest_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        guest_job_title.setCellValueFactory(new PropertyValueFactory<>("job_title"));
        guest_company.setCellValueFactory(new PropertyValueFactory<>("company"));
        guest_ccn.setCellValueFactory(new PropertyValueFactory<>("credit_card_no"));
        guest_cct.setCellValueFactory(new PropertyValueFactory<>("credit_card_type"));
        guest_date_of_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        guest_check_in.setCellValueFactory(new PropertyValueFactory<>("checking_in"));
        guest_check_out.setCellValueFactory(new PropertyValueFactory<>("checking_out"));

        guest_table.setItems(GuestObservableList);
        connectionDB.close();
    }

    //Reception Panel
    public void recep_refresh() throws SQLException{
        ObservableList<Receptionist> ReceptionistObservableList= FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();

        String receptionistviewQuery = "SELECT * FROM hotel.receptionist;";

        Statement statement = connectionDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(receptionistviewQuery);

        while(queryOutput.next()){
            Integer recep_ID = queryOutput.getInt("ID");
            String recep_name = queryOutput.getString("Name");
            String recep_username = queryOutput.getString("username");
            String recep_password = queryOutput.getString("password");

            //populate the observable list
            ReceptionistObservableList.add(new Receptionist(recep_ID,recep_name,recep_username,recep_password));

        }
        recep_tableID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        recep_tablename.setCellValueFactory(new PropertyValueFactory<>("Name"));
        recep_tableusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        recep_tablepassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        recep_table.setItems(ReceptionistObservableList);
        connectionDB.close();
    }
    public void re_insert(ActionEvent event) throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String sql="insert into receptionist (ID,Name,username,password) values (?,?,?,?)";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.setString(1,recep_id.getText());
        ptst.setString(2,recep_name.getText());
        ptst.setString(3,recep_un.getText());
        ptst.setString(4,recep_pw.getText());
        ptst.executeUpdate();
        c.close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Data Inserted");
        alert.showAndWait();
        recep_refresh();

    }
    public void re_update(ActionEvent event) throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String Name = recep_name.getText().trim();
        String un = recep_un.getText().trim();
        String pw = recep_pw.getText().trim();
        String id = recep_id.getText().trim();
        String sql="UPDATE hotel.receptionist SET Name = '"+Name+"', username = '"+un+"',password = '"+pw+"' WHERE ID = "+id+";";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.executeUpdate();
        c.close();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Data Updated");
        alert.showAndWait();
        recep_refresh();
    }
    public void re_delete(ActionEvent event) throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String id = recep_id.getText().trim();
        String sql="DELETE FROM receptionist WHERE ID="+id+";";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.executeUpdate();
        c.close();


        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Data Deleted");
        alert.showAndWait();
        recep_refresh();
    }
    public void re_view(ActionEvent event) throws SQLException {
        recep_refresh();
    }

    //Room List
    public void room_refresh() throws SQLException {

        ObservableList<Rooms> RoomsObservableList= FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();

        String roomsviewQuery = "SELECT * FROM hotel.rooms;";

        Statement statement = connectionDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(roomsviewQuery);

        while(queryOutput.next()){
            Integer room_ID = queryOutput.getInt("room_id");
            String room_type = queryOutput.getString("room_type");
            String room_telephone = queryOutput.getString("telephone");
            String room_television = queryOutput.getString("television");
            String room_exclusive = queryOutput.getString("exclusive_view");

            //populate the observable list
            RoomsObservableList.add(new Rooms(room_ID,room_type,room_telephone,room_television,room_exclusive));

        }
        room_tableID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        room_tabletype.setCellValueFactory(new PropertyValueFactory<>("Type"));
        room_tabletelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        room_tabletelevision.setCellValueFactory(new PropertyValueFactory<>("television"));
        room_tableExclusiveView.setCellValueFactory(new PropertyValueFactory<>("Exclusive_View"));

        room_table.setItems(RoomsObservableList);
        connectionDB.close();
    }
    public void room_insert(ActionEvent event1) throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String sql="insert into rooms (room_id,room_type,telephone,television,exclusive_view) values (?,?,?,?,?)";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.setString(1,roomTF_ID.getText());
        ptst.setString(2,cb.getValue());
        ptst.setString(3,get_telephone());
        ptst.setString(4,get_television());
        ptst.setString(5,roomTF_ExclusiveView.getText());
        ptst.executeUpdate();
        c.close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Data Inserted");
        alert.showAndWait();
        room_refresh();
    }
    public void room_update(ActionEvent event) throws SQLException {

        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String id = roomTF_ID.getText().trim();
        String room_type = cb.getValue().trim();
        String telephone =get_telephone().trim();
        String television= get_television().trim();
        String exclusive=roomTF_ExclusiveView.getText();
        String sql="UPDATE hotel.rooms SET room_type = '"+room_type+"', telephone = '"+telephone+"',television = '"+television+"', exclusive_view = '"+exclusive+"' WHERE room_id = "+id+";";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.executeUpdate();
        c.close();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Data Updated");
        alert.showAndWait();
        room_refresh();
    }
    public void room_delete(ActionEvent event) throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String id = roomTF_ID.getText().trim();
        String sql="DELETE FROM rooms WHERE room_id="+id+";";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.executeUpdate();
        c.close();


        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Data Deleted");
        alert.showAndWait();
        room_refresh();
    }
    public void room_view(ActionEvent event) throws SQLException {
        room_refresh();
    }

    //DashBoard changing
    public void handleClick(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource()==btn_booking)
            pan_booking.toFront();
        else if(actionEvent.getSource()==btn_guest)
            pan_guest.toFront();
        else if(actionEvent.getSource()==btn_recep)
            pan_receptionist.toFront();
        else if(actionEvent.getSource()==btn_manager)
            pan_manager.toFront();
        else if(actionEvent.getSource()==btn_overview)
            pane_overview.toFront();
        else if(actionEvent.getSource()==btn_room)
            pan_rooms.toFront();
        else if(actionEvent.getSource()==btn_room)
            pan_rooms.toFront();
        else if(actionEvent.getSource()==btn_signout) {
            return_login();

        }

    }
}
