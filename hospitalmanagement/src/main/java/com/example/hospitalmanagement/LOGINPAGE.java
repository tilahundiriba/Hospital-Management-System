package com.example.hospitalmanagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LOGINPAGE extends Application {
    @Override
    public void start(Stage loginStage)  {
        Pane pane = new Pane();

        Label label3 = new Label("LOGIN ");
        label3.setLayoutX(100);
        label3.setLayoutY(20);
        label3.setFont(Font.font("venom",25));
       label3.setStyle(" -fx-font-weight:bold;-fx-font-size:25-fx-text-fill:#32CC99");
        Label label1 = new Label("USER NAME");
        label1.setLayoutX(40);
        label1.setLayoutY(80);
        label1.setStyle(" -fx-font-weight:bold;-fx-font-size:15-fx-text-fill:#32CC99");
        Label label2 = new Label("PASSWORD");
        label2.setLayoutX(40);
        label2.setLayoutY(125);
        label2.setStyle(" -fx-font-weight:bold;-fx-font-size:15-fx-text-fill:#32CC99");
        Button button = new Button("LOGIN");
        button.setLayoutX(70);
        button.setLayoutY(180);
        button.setPrefSize(100,40);
        button.setStyle("-fx-background-color:#32CC99");
        Button btn = new Button("CANCEL");
        btn.setLayoutX(200);
        btn.setLayoutY(180);
        btn.setPrefSize(100,40);
        btn.setStyle("-fx-background-color:#32CC99");
        btn.setOnAction(event -> {
            System.exit(0);
        });

        TextField textField = new TextField();
        textField.setLayoutX(150);
        textField.setLayoutY(70);
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(150);
        passwordField.setLayoutY(120);
        pane.getChildren().addAll(label3,label1,label2,textField,passwordField,button,btn);
        pane.setPrefSize(200,150);
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        pane.setBackground(Background.fill(Color.BEIGE));
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Scene scene = new Scene(pane,300,300);
        Stage stage = new Stage();
        button.setOnAction(e ->{
            String userName,passWord;
            userName=textField.getText();
            passWord=passwordField.getText();
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            String query="Select * from LOGINTABLE where USERNAME='"+ userName +"'and PASSWORD='"+ passWord +"'";
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection=connectionClass.conMethod();
            Statement statement;
            ResultSet re;
            try {

                statement=connection.createStatement();
                re = statement.executeQuery(query);

                try {
                    if(re.next()){
                        menuPage.mainMethod();
                    stage.close();}
                    else
                    {
                    alert1 .setContentText("Invalid usrename and password");
                    alert1.show();}
                }catch (SQLException exception){
                    alert1 .setContentText("Invalid usrename and password");
                    alert1.show();
                }
            }catch (SQLException exception)
            {
                alert1.setContentText("error in database");
                alert1.show();
            }
        });


        stage.setTitle("LOGIN_STAGE");
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(true);
        stage.show();


    }
    public static void main(String[] args){
        launch(args);
    }

}
