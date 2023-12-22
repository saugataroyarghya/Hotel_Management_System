package com.example.hms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class GuestPanel implements Initializable {
    @FXML
    private TextField order_comment;

    @FXML
    private TextField order_id;
    @FXML
    private Label label_room_id;
    @FXML
    private Label checkin_date;
    @FXML
    private Label label_room_name;
    @FXML
    private Label checkout_date;
    @FXML
    private Label label_guest_name;
    @FXML
    private Button btn_dashboard;

    @FXML
    private Button btn_info;

    @FXML
    private Button btn_order;

    @FXML
    private Pane confirm_order;
    @FXML
    private TableColumn<Orders, String> order_comment_table;
    @FXML
    private TableColumn<Orders, Integer> order_id_table;
    @FXML
    private TableColumn<Orders, String> order_status_table;

    @FXML
    private TableView<Orders> order_table;
    @FXML
    private Pane order_place;

    @FXML
    private Pane pan_info;

    @FXML
    private Pane pan_order;

    @FXML
    private Pane pan_overview;

    private String guestID = login.guest_id;
    private String guest_name = login.guest_name;
    private String room_type;

    public void order_create() throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String sql="insert into orders (room_id,comment) values (?,?)";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.setString(1, String.valueOf(login.room_id));
        ptst.setString(2,order_comment.getText());
        ptst.executeUpdate();
        c.close();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Order Created");
        alert.setContentText("Check the dashboard for more info");
        alert.showAndWait();
        //confirm_order.toFront();
    }
    public void order_edit() throws SQLException {
        java.sql.Connection c;
        c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
        String comment = order_comment.getText();
        String id = order_id.getText().trim();
        String sql="UPDATE hotel.orders SET comment = '"+comment+"' WHERE order_id = "+id+" AND room_id = "+login.room_id+";";
        PreparedStatement ptst = c.prepareStatement(sql);
        ptst.executeUpdate();
        c.close();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Order Updated");
        alert.showAndWait();
    }

    public void order_show() throws SQLException {
        ObservableList<Orders> ordersObservableList= FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();

        String ordersviewQuery = "SELECT * FROM hotel.orders WHERE room_id = '"+ String.valueOf(login.room_id)+"';";

        Statement statement = connectionDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(ordersviewQuery);

        while(queryOutput.next()){
            Integer order_ID = queryOutput.getInt("order_id");
            String comment = queryOutput.getString("comment");
            String order_status = queryOutput.getString("status");


            //populate the observable list
            ordersObservableList.add(new Orders(order_ID,login.room_id,comment,order_status));

        }
        order_id_table.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        order_comment_table.setCellValueFactory(new PropertyValueFactory<>("Comment"));
        order_status_table.setCellValueFactory(new PropertyValueFactory<>("Status"));

        order_table.setItems(ordersObservableList);
        connectionDB.close();
    }

    public void handleClick(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource()==btn_dashboard) {
            pan_overview.toFront();
        }
        else if(actionEvent.getSource()==btn_info)
            pan_info.toFront();
        else if(actionEvent.getSource()==btn_order)
            pan_order.toFront();

        //else if(actionEvent.getSource()==btn_signout) {
            //return_login();

        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            label_guest_name.setText(guest_name);
            checkin_date.setText(login.guest_checkin);
            checkout_date.setText(login.guest_checkout);
            label_room_name.setText(login.room_name);
            label_room_id.setText(String.valueOf(login.room_id));
        try {
            order_show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
