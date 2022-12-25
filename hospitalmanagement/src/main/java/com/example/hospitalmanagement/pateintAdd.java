package com.example.hospitalmanagement;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.Statement;


public class pateintAdd  {

    public static void p_add(){
        Stage Secondstage = new Stage();
        Pane pane = new Pane();
        Text text = new Text();
        text.setText("NEW PATIENT REGISTRATION");
        text.setX(80);
        text.setY(50);
        text.setFont(Font.font("Thoma", FontWeight.BOLD, 25));

        Button button =  new Button("ADD");
        button.setLayoutX(60);
        button.setLayoutY(430);
        button.setPrefSize(100,40);
        button.setStyle("-fx-background-color:#32CC99");

        Button button2 =  new Button("DELETE");
        button2.setLayoutX(210);
        button2.setLayoutY(430);
        button2.setPrefSize(100,40);
        button2.setStyle("-fx-background-color:#32CC99");
        button2.setOnAction(e ->{
            DeleteClass.deleteMetForPat();

            Secondstage.close();
        });
        Button button3 =  new Button("UPDATE");
        button3.setLayoutX(380);
        button3.setLayoutY(430);
        button3.setPrefSize(100,40);
        button3.setStyle("-fx-background-color:#32CC99");
        button3.setOnAction(e ->{
            UpdateClass.updatePt();

            Secondstage.close();
        });
        Button button4 =  new Button("MAIN FORM");
        button4.setLayoutX(210);
        button4.setLayoutY(490);
        button4.setPrefSize(100,40);
        button4.setStyle("-fx-background-color:#32CC99");
        button4.setOnAction(e ->{

            menuPage.mainMethod();
            Secondstage.close();
        });
        pane.getChildren().addAll(button,button2,button3,button4);


        Label label = new Label("NAME");
        label.setLayoutX(20);
        label.setLayoutY(120);
        Label label2 = new Label("ID");
        label2.setLayoutX(400);
        label2.setLayoutY(120);
        Label label3 = new Label("AGE");
        label3.setLayoutX(20);
        label3.setLayoutY(180);
        Label label4 = new Label("SEX");
        label4.setLayoutX(150);
        label4.setLayoutY(180);
        RadioButton radioButton1 = new RadioButton("Male");

        RadioButton radioButton2 = new RadioButton("Female");

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        HBox hBox = new HBox();
        hBox.setLayoutY(180);
       hBox.setLayoutX(190);
       hBox.setSpacing(20);
       hBox.setPrefSize(200,60);
       //hBox.setBackground(Background.fill(Color.BROWN));
        hBox.getChildren().addAll(radioButton1,radioButton2);
        Label label5 = new Label("CONTACT");
        label5.setLayoutX(400);
        label5.setLayoutY(180);
        Label label6 = new Label("ADDRESS");
        label6.setLayoutX(300);
        label6.setLayoutY(320);
        Label label7 = new Label("DISEASE");
        label7.setLayoutX(10);
        label7.setLayoutY(280);
        Label label8 = new Label("DOCTOR's NAME");
        label8.setLayoutX(10);
        label8.setLayoutY(320);
        Label label9 = new Label("BLOOD GROUP");
        label9.setLayoutX(300);
        label9.setLayoutY(280);

        pane.getChildren().addAll(label,label2,label3,label4,label5,label6,label7,label8,label9);

        TextField textField = new TextField();
        textField.setLayoutX(70);
        textField.setLayoutY(120);
        textField.setPrefWidth(150);
        TextField textField2 = new TextField();
        textField2.setLayoutX(500);
        textField2.setLayoutY(120);
        textField2.setPrefWidth(150);
        TextField textField3 = new TextField();
        textField3.setLayoutX(70);
        textField3.setLayoutY(180);
        textField3.setPrefWidth(60);
        TextField textField5 = new TextField();
        textField5.setLayoutX(500);
        textField5.setLayoutY(180);
        textField5.setPrefWidth(150);
        TextField textField6 = new TextField();
        textField6.setLayoutX(400);
        textField6.setLayoutY(320);
        textField6.setPrefWidth(150);
        TextField textField7 = new TextField();
        textField7.setLayoutX(110);
        textField7.setLayoutY(280);
        textField7.setPrefWidth(150);
        TextField textField8 = new TextField();
        textField8.setLayoutX(110);
        textField8.setLayoutY(320);
        textField8.setPrefWidth(150);
        TextField textField9 = new TextField();
        textField9.setLayoutX(400);
        textField9.setLayoutY(280);
        textField9.setPrefWidth(150);
        pane.getChildren().addAll(textField,textField2,textField3,hBox,textField5,textField6,textField7,textField8,textField9);

        button.setOnAction(e -> {
            if("".equals(textField.getText())||"".equals(textField2.getText())||"".equals(textField3.getText())||
                    "".equals(textField6.getText())||"".equals(textField5.getText())||
                    "".equals(textField7.getText())||"".equals(textField8.getText())||"".equals(textField9.getText()))
            {
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setContentText("All feilds are required");
                alert.show();
            }
            else{
            ConnectionClass connection2 = new ConnectionClass();
            connection2.conMethod();
            String name, id, age, sex = "", cont, dis, blg, drn, add;
            name = textField.getText();
            id = textField2.getText();
            age = textField3.getText();
            if (radioButton1.isSelected())
                sex = "Male";
            else if (radioButton2.isSelected())
                sex = "Female";
            else {
                Alert al = new Alert(Alert.AlertType.WARNING);
                al.setContentText("please select your sex");
                al.show();
            }
            cont = textField5.getText();
            dis = textField6.getText();
            blg = textField7.getText();
            drn = textField8.getText();
            add = textField9.getText();
            try {

                String query = "Insert into PATEINTTABLE(NAME,ID,AGE,GENDER,CONTACT,DISEASE,BLOODGROUP,D_NAME,ADDRESS) " +
                        "VALUES('" + name + "','" + id + "','" + age + "'," +
                        "'" + sex + "','" + cont + "','" + dis + "'," +
                        "'" + blg + "','" + drn + "','" + add + "')";
                ConnectionClass db = new ConnectionClass();
                Connection connection = db.conMethod();
                Statement statement = connection.createStatement();
                boolean status = statement.execute(query);
                ;
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                if (!status) {
                    al.setContentText("successfully inserted");
                    al.showAndWait();
                } else {
                    al.setContentText("Not successfully inserted");
                    al.showAndWait();
                }

            } catch (Exception event) {
                System.out.println("error" + event);
            }
        }
        });

        Text text2 = new Text();
        text2.setText(" PATIENT's_DETAILS");
        text2.setX(20);
        text2.setY(90);
        text2.setFont(Font.font("Thoma", FontWeight.BOLD, 15));


        Text text3 = new Text();
        text3.setText("REFERENCES");
        text3.setX(20);
        text3.setY(250);
        text3.setFont(Font.font("Thoma", FontWeight.BOLD, 15));


        Text text4 = new Text();
        text4.setText("ACTIONS");
        text4.setX(20);
        text4.setY(400);
        text4.setFont(Font.font("Thoma", FontWeight.BOLD, 15));

        pane.setPrefSize(600,600);
        pane.getChildren().addAll(text,text2,text3,text4);
        pane.setBackground(Background.fill(Color.DARKSALMON));
        pane.setLayoutX(5);
        pane.setLayoutY(5);
        Scene scene = new Scene(pane,700,500);


        Secondstage.setScene(scene);
        Secondstage.setTitle("PATIENT ENTITY");
        Secondstage.setWidth(800);
        Secondstage.setHeight(700);
        Secondstage.setResizable(false);
        Secondstage.show();

    }


    }



