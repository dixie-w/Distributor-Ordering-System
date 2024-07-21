package com.example.newcustomerscreen2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("New Customer");
        stage.setScene(scene);
        stage.show();
    }
    public void addCustomer()
    {
        String user;
        String pass;
        String query = "INSERT INTO Customer VALUES(?,?,?)";

        try(Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps = conn.prepareStatement(query)){
              pstmt.setString(1,name);
              pstmt.setString(2,email);
              pstmt.setString(3,phone);
              pstmt.setString(4,address);
              ps.executeUpdate();
              System.out.println("Customer Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
