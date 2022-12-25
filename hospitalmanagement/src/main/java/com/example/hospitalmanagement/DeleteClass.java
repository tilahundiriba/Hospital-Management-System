package com.example.hospitalmanagement;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;

import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteClass {
    public static void deleteMetForPat() {

        Stage stage = new Stage();

        Pane pane = new Pane();

        Label label3 = new Label("DELETE YOUR DATA ");
        label3.setLayoutX(100);
        label3.setLayoutY(20);
        label3.setFont(Font.font("venom", 25));
        label3.setStyle(" -fx-font-weight:bold;-fx-font-size:25-fx-text-fill:#32CC99");
        Label label1 = new Label("ENTER ID");
        label1.setLayoutX(40);
        label1.setLayoutY(80);
        label1.setStyle(" -fx-font-weight:bold;-fx-font-size:15-fx-text-fill:#32CC99");

        Button button = new Button("DELETE");
        button.setLayoutX(100);
        button.setLayoutY(150);
        button.setPrefSize(100, 40);
        button.setStyle("-fx-background-color:#32CC99");
        Button b = new Button("MAINFORM");
        b.setLayoutX(240);
        b.setLayoutY(150);
        b.setPrefSize(100, 40);
        b.setStyle("-fx-background-color:#32CC99");
        b.setOnAction(event -> {
            menuPage.mainMethod();
            stage.close();
        });
        TextField textField = new TextField();
        textField.setLayoutX(130);
        textField.setLayoutY(80);
        pane.getChildren().addAll(label3,label1,textField,button,b);
        Alert ale = new Alert(Alert.AlertType.INFORMATION);
        button.setOnAction(event -> {
            String str=textField.getText();
            boolean status=false;
            String query="DELETE FROM PATEINTTABLE WHERE ID='"+str+"'";
            ConnectionClass db = new ConnectionClass();
            Connection connection = db.conMethod();
            Statement statement=null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            status=false;
            try{
                status=statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(!status){
                ale.setContentText("DELETED SUCCESSFULLY");
                ale.show();
            }
            else {
                ale.setContentText("NOT DELETED SUCCESSFULLY");
                ale.show();
            }
        });

        stage.setTitle("DELETESTAGE");
        Scene scene = new Scene(pane,200,200);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(true);
        stage.show();
    }


    public static void deleteMetForBIl() {


        Stage stage = new Stage();

        Pane pane = new Pane();

        Label label3 = new Label("DELETE YOUR DATA  ");
        label3.setLayoutX(100);
        label3.setLayoutY(20);
        label3.setFont(Font.font("venom", 25));
        label3.setStyle(" -fx-font-weight:bold;-fx-font-size:25-fx-text-fill:#32CC99");
        Label label1 = new Label("ENTER ID");
        label1.setLayoutX(40);
        label1.setLayoutY(80);
        label1.setStyle(" -fx-font-weight:bold;-fx-font-size:15-fx-text-fill:#32CC99");

        Button button = new Button("DELETE");
        button.setLayoutX(100);
        button.setLayoutY(150);
        button.setPrefSize(100, 40);
        button.setStyle("-fx-background-color:#32CC99");
        Button b = new Button("MAINFORM");
        b.setLayoutX(240);
        b.setLayoutY(150);
        b.setPrefSize(100, 40);
        b.setStyle("-fx-background-color:#32CC99");
        b.setOnAction(event -> {
            menuPage.mainMethod();
            stage.close();
        });
        TextField textField = new TextField();
        textField.setLayoutX(130);
        textField.setLayoutY(80);
        pane.getChildren().addAll(label3,label1,textField,button,b);
      Alert ale=new Alert(Alert.AlertType.INFORMATION);
        button.setOnAction(event -> {
            String str=textField.getText();
            boolean status=false;
            String query="DELETE FROM BILLINGTABLE WHERE P_ID='"+str+"'";
            ConnectionClass db = new ConnectionClass();
            Connection connection = db.conMethod();
            Statement statement=null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            status=false;
            try{
                status=statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(!status){
                ale.setContentText("DELETED SUCCESSFULLY");
                ale.show();
            }
            else {
                ale.setContentText("NOT DELETED SUCCESSFULLY");
                ale.show();
            }
        });

        stage.setTitle("DELETESTAGE");
        Scene scene = new Scene(pane,200,200);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(true);
        stage.show();
    }
    public static void deleteMetForSF() {


        Stage stage = new Stage();

        Pane pane = new Pane();

        Label label3 = new Label("DELETE YOUR DATA  ");
        label3.setLayoutX(100);
        label3.setLayoutY(20);
        label3.setFont(Font.font("venom", 25));
        label3.setStyle(" -fx-font-weight:bold;-fx-font-size:25-fx-text-fill:#32CC99");
        Label label1 = new Label("ENTER ID");
        label1.setLayoutX(40);
        label1.setLayoutY(80);
        label1.setStyle(" -fx-font-weight:bold;-fx-font-size:15-fx-text-fill:#32CC99");

        Button button = new Button("DELETE");
        button.setLayoutX(100);
        button.setLayoutY(150);
        button.setPrefSize(100, 40);
        button.setStyle("-fx-background-color:#32CC99");
        Button b = new Button("MAINFORM");
        b.setLayoutX(240);
        b.setLayoutY(150);
        b.setPrefSize(100, 40);
        b.setStyle("-fx-background-color:#32CC99");
        b.setOnAction(event -> {
            menuPage.mainMethod();
            stage.close();
        });
        TextField textField = new TextField();
        textField.setLayoutX(130);
        textField.setLayoutY(80);
        pane.getChildren().addAll(label3,label1,textField,button,b);
        Alert ale=new Alert(Alert.AlertType.INFORMATION);
        button.setOnAction(event -> {
            String str=textField.getText();
            boolean status=false;
            String query="DELETE FROM STAFFTABLE WHERE STF_ID='"+str+"'";
            ConnectionClass db = new ConnectionClass();
            Connection connection = db.conMethod();
            Statement statement=null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            status=false;
            try{
                status=statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(!status){
                ale.setContentText("DELETED SUCCESSFULLY");
                ale.show();
            }
            else {
                ale.setContentText("NOT DELETED SUCCESSFULLY");
                ale.show();
            }
        });

        stage.setTitle("DELETESTAGE");
        Scene scene = new Scene(pane,200,200);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(true);
        stage.show();
    }
}
