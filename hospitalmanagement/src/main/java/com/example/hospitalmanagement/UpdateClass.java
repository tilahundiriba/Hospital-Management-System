package com.example.hospitalmanagement;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateClass {

        public static void updatePt(){
            Stage opt=new Stage();
            Label ennl1=new Label("Enter Name");
            TextField Id2=new TextField();
            Label agl5=new Label("Enter_age ");
            TextField age=new TextField();
            Label conl3=new Label("Enter_contact");
            TextField contact=new TextField();
            Label addl4=new Label("enter address");
            TextField add=new TextField();
            Label Idl2=new Label("p_ID");
            TextField name=new TextField();
            Label drt2=new Label("Dr_name");
            TextField drt=new TextField();
            Button save=new Button("SAVE");
            save.setStyle("-fx-background-color:#32CC99");
            Button Main=new Button("MAIN_FORM");
            Main.setPrefSize(150,30);
            Main.setLayoutX(280);
            Main.setLayoutY(250);
            Main.setStyle("-fx-background-color:#32CC99");
            Main.setOnAction(event -> {
                menuPage.mainMethod();
                opt.close();
            });

            ennl1.setLayoutY(40);
            ennl1.setLayoutX(150);
            Id2.setLayoutY(70);
            Id2.setLayoutX(240);
            Idl2.setLayoutY(70);
            Idl2.setLayoutX(150);
            age.setLayoutY(100);
            age.setLayoutX(240);
            conl3.setLayoutY(130);
            conl3.setLayoutX(150);
            contact.setLayoutY(130);
            contact.setLayoutX(240);
            addl4.setLayoutY(160);
            addl4.setLayoutX(150);
            add.setLayoutY(160);
            add.setLayoutX(240);
            agl5.setLayoutY(100);
            agl5.setLayoutX(150);
            name.setLayoutY(40);
            name.setLayoutX(240);
            drt2.setLayoutX(150);
            drt2.setLayoutY(200);
           drt.setLayoutX(240);
            drt.setLayoutY(200);
            save.setLayoutX(150);
            save.setLayoutY(250);
            save.setPrefSize(100,30);
            Alert alee  = new Alert(Alert.AlertType.INFORMATION);
            save.setOnAction(e->{
                String name2,con,ad,id,agee,drn;
                boolean status=false;
                name2=name.getText();
                agee=age.getText();
                con=contact.getText();
                ad=add.getText();
                id=Id2.getText();
                drn=drt.getText();
                String query ="UPDATE PATEINTTABLE SET NAME='"+name2+"',CONTACT='"+con+"',ADDRESS='"+ad+"',AGE='"+agee+"',D_NAME='"+drn+"' WHERE ID='"+id+"'";
                ConnectionClass db = new ConnectionClass();
                Connection connection = db.conMethod();
                Statement statement = null;
                try {
                    statement = connection.createStatement();
                } catch (SQLException ex) {
                }
                status = false;
                try {
                    status = statement.execute(query);
                } catch (SQLException ex) {
                }

                try {
                    statement.close();
                } catch (SQLException ex) {
                }
                try {
                    connection.close();
                } catch (SQLException ex) {
                }
                if(!status){
                    alee.setContentText("UPADETED SUCCESSFULLY");
                    alee.show();
                }
                else {
                    alee.setContentText("NOT UPDATED SUCCESSFULLY");
                    alee.show();
                }
            });
            Label lb0=new Label("Update Pateint information");
            lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
            lb0.setLayoutY(10);
            lb0.setLayoutX(220);


            Group gr=new Group();
            gr.getChildren().addAll(lb0,ennl1,Idl2,conl3,addl4,agl5,name,age,contact,add,Id2,drt,drt2,save,Main);

            Scene scene=new Scene(gr,600,500);
            scene.setFill(Color.web("#e6e9f0"));
            opt.setScene(scene);
            opt.setResizable(false);
            opt.setTitle("Update Info");
            opt.show();
        }

    public static void updateforSf(){
        Stage opt=new Stage();
        Label ennl1=new Label("Id");
        TextField Id2=new TextField();
        Label addl4=new Label("ADDRESS ");
        TextField adge=new TextField();
        Label conl3=new Label("PROFFESSION");
        TextField pro=new TextField();
        Label agl5=new Label("AGE");
        TextField agg=new TextField();
        Label Idl2=new Label("PHONE_NO");
        TextField phone=new TextField();
        Button save=new Button("SAVE");
        save.setStyle("-fx-background-color:#32CC99");
        Button Main=new Button("MAIN_FORM");
        Main.setPrefSize(150,30);
        Main.setLayoutX(260);
        Main.setLayoutY(230);
        Main.setStyle("-fx-background-color:#32CC99");
        Main.setOnAction(event -> {
            menuPage.mainMethod();
            opt.close();
        });
        Id2.setStyle("-fx-background-color:#a8ba9a");
        adge.setStyle("-fx-background-color:#a8ba9a");
       pro.setStyle("-fx-background-color:#a8ba9a");
        agg.setStyle("-fx-background-color:#a8ba9a");
        phone.setStyle("-fx-background-color:#a8ba9a");

        ennl1.setLayoutY(40);
        ennl1.setLayoutX(150);
        Id2.setLayoutY(40);
        Id2.setLayoutX(240);
        addl4.setLayoutY(75);
        addl4.setLayoutX(150);
        adge.setLayoutY(75);
        adge.setLayoutX(240);
        conl3.setLayoutY(110);
        conl3.setLayoutX(150);
        pro.setLayoutY(110);
        pro.setLayoutX(240);
        agl5.setLayoutY(140);
        agl5.setLayoutX(150);
        agg.setLayoutY(140);
        agg.setLayoutX(240);
        Idl2.setLayoutY(170);
        Idl2.setLayoutX(150);
        phone.setLayoutY(170);
        phone.setLayoutX(240);

        save.setLayoutX(150);
        save.setLayoutY(230);
        save.setPrefSize(100,30);
        Alert alee  = new Alert(Alert.AlertType.INFORMATION);
        save.setOnAction(e->{
            String phone1,ad,id,agee,prof1;
            boolean status=false;
            id= Id2.getText();
            agee=agg.getText();
            prof1=pro.getText();
            ad=adge.getText();
            phone1=phone.getText();
            String query ="UPDATE STAFFTABLE SET PROFFESION='"+prof1+"',PHONE_NO='"+phone1+"',ADDRESS='"+ad+"',AGE='"+agee+"' WHERE STF_ID='"+id+"'";
            ConnectionClass db = new ConnectionClass();
            Connection connection = db.conMethod();
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                System.out.println("somthing is wrong here");
            }
            status = false;
            try {
                status = statement.execute(query);
            } catch (SQLException ex) {
                System.out.println("somthing is wrong here tooo");
            }

            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("not coused");
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("not coused toooo");
            }
            if(!status){
                alee.setContentText("UPADETED SUCCESSFULLY");
                alee.show();
            }
            else {
                alee.setContentText("NOT UPDATED SUCCESSFULLY");
                alee.show();
            }
        });
        Label lb0=new Label("Update Staff information");
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutY(10);
        lb0.setLayoutX(220);


        Group gr=new Group();
        gr.getChildren().addAll(lb0,ennl1,Idl2,conl3,addl4,agl5,Id2,phone,pro,agg,adge,save,Main);

        Scene scene=new Scene(gr,600,500);
        scene.setFill(Color.web("#e6e9f0"));
        opt.setScene(scene);
        opt.setResizable(false);
        opt.setTitle("Update Info");
        opt.show();
    }

}
