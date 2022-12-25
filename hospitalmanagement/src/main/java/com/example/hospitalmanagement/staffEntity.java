package com.example.hospitalmanagement;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class staffEntity  {
        public static void ataffdd() {

            Stage Thridstage = new Stage();
            GridPane gridPane = new GridPane();
            Pane pane = new Pane();
            pane.setPrefSize(900, 500);
            pane.setLayoutX(0);
            pane.setLayoutY(0);
            pane.setBackground(Background.fill(Color.LIGHTCYAN));
            gridPane.setLayoutX(1);
            gridPane.setLayoutY(100);
            gridPane.setPrefSize(800, 300);
            gridPane.setHgap(20);
            gridPane.setVgap(20);
            Label label1 = new Label("NAME");
            Label label2 = new Label("ADDRESS");
            Label label3 = new Label("JOIN_DATE");
            Label label4 = new Label("STF_ID");
            Label label5 = new Label("AGE");
            Label label6 = new Label("GENDER");
            Label label17 = new Label("PHONE_NO");
            Label label8 = new Label("PROFESSION");
            Text text = new Text();
            RadioButton radioButton1 = new RadioButton("Male");
            RadioButton radioButton2 = new RadioButton("Female");
            ToggleGroup toggleGroup = new ToggleGroup();
            radioButton1.setToggleGroup(toggleGroup);
            radioButton2.setToggleGroup(toggleGroup);
            text.setText("STAFF REGISTRATION FORM");
            text.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
            text.setFill(Color.BROWN);
            text.setY(50);
            text.setX(100);


            String dates[]
                    = { "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31" };
            String months[]
                    = { "Jan", "feb", "Mar", "Apr",
                    "May", "Jun", "July", "Aug",
                    "Sup", "Oct", "Nov", "Dec" };
            String years[]
                    = { "1995", "1996", "1997", "1998",
                    "1999", "2000", "2001", "2002",
                    "2003", "2004", "2005", "2006",
                    "2007", "2008", "2009", "2010",
                    "2011", "2012", "2013", "2014",
                    "2015", "2016", "2017", "2018",
                    "2019" };
            ComboBox combobox1= new ComboBox(FXCollections.observableArrayList(dates));
            combobox1.getSelectionModel().selectFirst();
            ComboBox combobox2= new ComboBox(FXCollections.observableArrayList(months));
            combobox2.getSelectionModel().selectFirst();
            ComboBox combobox3 = new ComboBox(FXCollections.observableArrayList(years));
            combobox3.getSelectionModel().selectFirst();

            TextField name2 = new TextField();
            TextField addres = new TextField();
            TextField stafid = new TextField();
            TextField age2 = new TextField();
            TextField proff = new TextField();
            TextField phone2 = new TextField();

            Button button1 = new Button("ADD");
            button1.setPrefSize(100, 30);
            button1.setLayoutX(60);
            button1.setLayoutY(420);
            button1.setOnAction(e ->{
                if("".equals(name2.getText())||"".equals(addres.getText())||"".equals(stafid.getText())||
                        "".equals(age2.getText())||"".equals(proff.getText())||"".equals(phone2.getText())||"".equals(name2.getText()))
                {
                   Alert alert=new Alert(Alert.AlertType.WARNING);
                   alert.setContentText("All feilds are required");
                   alert.show();
                }
                else {
                    ConnectionClass connection2 = new ConnectionClass();
                    connection2.conMethod();
                    String name, id, age, date, sex = "", profession, phone, add;
                    name = name2.getText();
                    add = addres.getText();
                    date = combobox1.getSelectionModel().getSelectedItem().toString() + "/" +
                            combobox2.getSelectionModel().getSelectedItem().toString() + "/" +
                            combobox3.getSelectionModel().getSelectedItem().toString();
                    id = stafid.getText();
                    age = age2.getText();
                    if (radioButton1.isSelected())
                        sex = "Male";
                    else if (radioButton2.isSelected())
                        sex = "Female";
                    else {
                        Alert al = new Alert(Alert.AlertType.WARNING);
                        al.setContentText("please select your sex");
                        al.show();
                    }
                    profession = proff.getText();
                    phone = phone2.getText();
                    try {

                        String query = "Insert into STAFFTABLE(NAME,ADDRESS,JOIN_DATE,STF_ID,AGE,GENDER,PROFFESION,PHONE_NO) " +
                                "VALUES('" + name + "','" + add + "','" + date + "'," +
                                "'" + id + "','" + age + "','" + sex + "'," +
                                "'" + profession + "','" + phone + "')";
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
                } });




            Button button2 = new Button("DELETE");
            button2.setPrefSize(100, 30);
            button2.setLayoutX(190);
            button2.setLayoutY(420);
            button2.setOnAction(e ->{
                DeleteClass.deleteMetForSF();

                Thridstage.close();
            });
            Button button3 = new Button("MAIN-FORM");
            button3.setPrefSize(100, 30);
            button3.setLayoutX(330);
            button3.setLayoutY(420);

            button3.setOnAction(e ->{

                menuPage.mainMethod();
                Thridstage.close();
            });
            Button button4 = new Button("UPDATE");
            button4.setPrefSize(100, 30);
            button4.setLayoutX(450);
            button4.setLayoutY(420);
            button4.setOnAction(e ->{

                UpdateClass.updateforSf();
                Thridstage.close();
            });

            gridPane.addRow(3, label1, name2, label4, stafid);
            gridPane.addRow(4, label2, addres, label5, age2);
            gridPane.addRow(5, label3, combobox1,combobox2,combobox3, label6, radioButton1,radioButton2);
            gridPane.addRow(6, label8, proff, label17, phone2);



            gridPane.setBackground(Background.fill(Color.LIGHTCYAN));
            pane.getChildren().addAll(text, button1, button2, button3, gridPane,button4);
            Scene scene = new Scene(pane, 950, 600);


            Thridstage.setScene(scene);
            Thridstage.setTitle("STAFF ENTITY");
            Thridstage.setWidth(1000);
            Thridstage.setHeight(700);
            Thridstage.setResizable(true);
            Thridstage.show();
        }


    }



