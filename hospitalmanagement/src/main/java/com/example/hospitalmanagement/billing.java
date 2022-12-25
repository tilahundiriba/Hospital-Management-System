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

public class billing  {

        public static void addbill() {
            Stage FourthStage = new Stage();
            GridPane gridPane = new GridPane();
            gridPane.setPrefWidth(800);
            gridPane.setPrefHeight(300);
            gridPane.setVgap(30);
            gridPane.setHgap(30);
            gridPane.setLayoutX(0);
            gridPane.setLayoutY(100);
            gridPane.setBackground(Background.fill(Color.LIGHTCYAN));
            Pane pane = new Pane();
            Text text = new Text("FORM OF BILLING");
            text.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
            text.setFill(Color.BROWN);
            text.setY(50);
            text.setX(200);
            // pane.setMaxSize(500,500);
            pane.setLayoutY(0);
            pane.setLayoutX(0);
            pane.setBackground(Background.fill(Color.LIGHTCYAN));


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
            ComboBox  combobox1= new ComboBox(FXCollections.observableArrayList(dates));
            combobox1.getSelectionModel().selectFirst();
            ComboBox combobox2= new ComboBox(FXCollections.observableArrayList(months));
            combobox2.getSelectionModel().selectFirst();
            ComboBox combobox3 = new ComboBox(FXCollections.observableArrayList(years));
            combobox3.getSelectionModel().selectFirst();

            String datess[]
                    = { "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31" };
            String monthss[]
                    = { "Jan", "feb", "Mar", "Apr",
                    "May", "Jun", "July", "Aug",
                    "Sup", "Oct", "Nov", "Dec" };
            String yearss[]
                    = { "1995", "1996", "1997", "1998",
                    "1999", "2000", "2001", "2002",
                    "2003", "2004", "2005", "2006",
                    "2007", "2008", "2009", "2010",
                    "2011", "2012", "2013", "2014",
                    "2015", "2016", "2017", "2018",
                    "2019" };
            ComboBox  combobox11= new ComboBox(FXCollections.observableArrayList(datess));
            combobox1.getSelectionModel().selectFirst();
            ComboBox combobox22= new ComboBox(FXCollections.observableArrayList(monthss));
            combobox2.getSelectionModel().selectFirst();
            ComboBox combobox33 = new ComboBox(FXCollections.observableArrayList(yearss));
            combobox3.getSelectionModel().selectFirst();

            Label label1 = new Label("P_NAME");
            Label label2 = new Label("P_ID");
            Label label3 = new Label("R_NO");
            Label label4 = new Label("BILL_NO");
            Label label5 = new Label("EN_DATE");
            Label label6 = new Label("DIS_DATE");
            Label label7 = new Label("DR_NAME");
            Label label8 = new Label("PR_BED");//price of bed
            Label label9 = new Label("PR_FOOD");
            Label label10 = new Label("TOTAL");


            Button button1 = new Button("ADD");
            button1.setLayoutX(80);
            button1.setLayoutY(450);
            button1.setPrefSize(100, 50);

            Button button2 = new Button("DELETE");
            button2.setLayoutX(230);
            button2.setLayoutY(450);
            button2.setPrefSize(100, 50);
            button2.setOnAction(e ->{
                DeleteClass.deleteMetForBIl();

                FourthStage.close();
            });
            Button button3 = new Button("MAIN_FROM");
            button3.setLayoutX(380);
            button3.setLayoutY(450);
            button3.setPrefSize(100, 50);
            button3.setOnAction(e ->{

                menuPage.mainMethod();
                FourthStage.close();
            });
            TextField textField1 = new TextField();
            TextField textField2 = new TextField();
            TextField textField3 = new TextField();
            TextField textField4 = new TextField();
            TextField textField7 = new TextField();
            TextField textField8 = new TextField();
            TextField textField9 = new TextField();
            TextField textField10 = new TextField();

            gridPane.addRow(2, label1, textField1, label4, textField4);
            gridPane.addRow(3, label2, textField2, label5, combobox11,combobox22,combobox33);
            gridPane.addRow(4, label3, textField3, label6, combobox1,combobox2,combobox3);
            gridPane.addRow(5, label7, textField7, label8, textField8);
            gridPane.addRow(6, label9, textField9, label10, textField10);

            button1.setOnAction(e ->{
                if("".equals(textField1.getText())||"".equals(textField2.getText())||"".equals(textField3.getText())||
                        "".equals(textField4.getText())||"".equals(textField10.getText())||
                        "".equals(textField7.getText())||"".equals(textField8.getText())||"".equals(textField9.getText()))
                {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("All feilds are required");
                    alert.show();
                }
                else {
                    ConnectionClass connection2 = new ConnectionClass();
                    connection2.conMethod();
                    String name, b_no, p_id, E_date, r_no, d_date, dr_name, pr_bed, pr_food, totl;
                    name = textField1.getText();
                    p_id = textField2.getText();
                    r_no = textField3.getText();
                    b_no = textField4.getText();
                    E_date = combobox11.getSelectionModel().getSelectedItem().toString() + "/" +
                            combobox22.getSelectionModel().getSelectedItem().toString() + "/" +
                            combobox33.getSelectionModel().getSelectedItem().toString();
                    d_date = combobox1.getSelectionModel().getSelectedItem().toString() + "/" +
                            combobox2.getSelectionModel().getSelectedItem().toString() + "/" +
                            combobox3.getSelectionModel().getSelectedItem().toString();
                    dr_name = textField7.getText();
                    pr_food = textField8.getText();
                    pr_bed = textField9.getText();
                    totl = textField10.getText();
                    try {

                        String query = "Insert into BILLINGTABLE(P_NAME,P_ID,R_NO,BILL_NO,EN_DATED,DIS_DATE,DR_NAME,PR_FOOD,PR_BED,TOTAL) " +
                                "VALUES('" + name + "','" + p_id + "','" + r_no + "'," +
                                "'" + b_no + "','" + E_date+ "','" + d_date + "'," +
                                "'" + dr_name + "','" + pr_bed + "','" + pr_food+ "','" + totl + "')";
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


            pane.getChildren().addAll(button1, button2, button3, gridPane, text);
            Scene scene = new Scene(pane, 850, 600);
            FourthStage.setScene(scene);
            FourthStage.setTitle("BILLING");
            FourthStage.setWidth(900);
            FourthStage.setHeight(600);
            FourthStage.setResizable(true);
            FourthStage.show();

        }
    }




