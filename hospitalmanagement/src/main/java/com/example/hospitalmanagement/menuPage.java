package com.example.hospitalmanagement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class menuPage {
    public static void mainMethod(){
Stage primarystage = new Stage();
        primarystage.setTitle("HOSPITAL");
        Pane pane = new Pane();
        ImageView imageView = new ImageView("C:\\Users\\tilish\\Pictures\\mypicture.jpg");
        imageView.setX(10);
        imageView.setY(150);
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        Button button1 = new Button("PATIENT ENTITY");
        button1.setLayoutX(350);
        button1.setLayoutY(150);
        button1.setBackground(Background.fill(Color.DARKORANGE));
        button1.setPrefSize(200,50);
        button1.setFont(Font.font("tahoma",20));
            button1.setOnAction(e ->{
                    pateintAdd.p_add();
                    primarystage.close();
            });
        Button button2 = new Button("STAFF ENTITY");
        button2.setLayoutX(350);
        button2.setLayoutY(280);
        button2.setBackground(Background.fill(Color.DARKORANGE));
        button2.setPrefSize(200,50);
        button2.setFont(Font.font("tahoma",20));
            button2.setOnAction(e ->{
                     staffEntity.ataffdd();
                    primarystage.close();
            });
        Button button3 = new Button("BILLING");
        button3.setLayoutX(350);
        button3.setLayoutY(400);
        button3.setBackground(Background.fill(Color.DARKORANGE));
        button3.setPrefSize(200,50);
        button3.setFont(Font.font("tahoma",20));
            button3.setOnAction(e ->{

                    billing.addbill();
                    primarystage.close();
            });
         Button exit = new Button("EXIT");
            exit.setLayoutX(200);
            exit.setLayoutY(470);
            exit.setBackground(Background.fill(Color.RED));
            exit.setFont(Font.font("tahoma",20));
            exit.setPrefSize(150,50);
            exit.setOnAction(event -> {
                    System.exit(0);
            });
        pane.setBackground(Background.fill(Color.DEEPSKYBLUE));
        Text text= new Text("WELLCOME TO");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        text.setFill(Color.BROWN);
        text.setLayoutX(200);
        text.setLayoutY(50);

        Text text2 = new Text("HOSPITAL MANAGEMENT SYSTEM");
        text2.setFill(Color.BROWN);
        text2.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        text2.setLayoutX(50);
        text2.setLayoutY(90);

        pane.setPrefSize(400,400);
        pane.setLayoutX(2);
        pane.setLayoutY(2);

        pane.getChildren().addAll(imageView,button1,button2,button3,text,text2,exit);
        Scene scene = new Scene(pane,500,500);
        primarystage.setScene(scene);
        primarystage.setHeight(600);
        primarystage.setWidth(600);
        primarystage.setResizable(false);
        primarystage.show();
    }

    }

