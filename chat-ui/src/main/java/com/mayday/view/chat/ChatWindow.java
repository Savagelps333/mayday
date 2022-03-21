package com.mayday.view.chat;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @Author sava
 * @Datetime 2022/3/17 19:03
 * @Version 1.0
 **/
public class ChatWindow {
    private static Stage stageWindow = new Stage();

    public ChatWindow(String username, String password) {
        BorderPane b1 = new BorderPane();
        b1.setPrefWidth(80);
        b1.setPrefHeight(80);
        b1.setStyle("-fx-background-color: coral");
        BorderPane b2 = new BorderPane();
        b2.setPrefWidth(220);
        b2.setPrefHeight(220);
        b2.setStyle("-fx-background-color: deeppink");
        BorderPane b3 = new BorderPane();
        b3.setPrefWidth(700);
        b3.setPrefHeight(700);
        b3.setStyle("-fx-background-color: darkcyan");


        BorderPane b1_b4 = new BorderPane();
        b1_b4.setStyle("-fx-background-color: darkred");
        b1_b4.setPrefHeight(100);
        b1_b4.setPrefWidth(100);
        BorderPane b1_b5 = new BorderPane();
        b1_b5.setStyle("-fx-background-color: forestgreen");
        b1.setTop(b1_b4);
        b1.setCenter(b1_b5);

        BorderPane b2_b6 = new BorderPane();
        b2_b6.setStyle("-fx-background-color: darkgray");
        b2_b6.setPrefHeight(80);
        b2_b6.setPrefWidth(80);
        BorderPane b2_b7 = new BorderPane();
        b2_b6.setStyle("-fx-background-color: #330021");
        b2.setTop(b2_b6);
        b2.setCenter(b2_b7);


        BorderPane b3_b8 = new BorderPane();
        b3_b8.setStyle("-fx-background-color: #432001");
        b3_b8.setPrefHeight(80);
        b3_b8.setPrefWidth(80);
        BorderPane b3_b9 = new BorderPane();
        b3_b9.setStyle("-fx-background-color: #666444");
        BorderPane b3_b10 = new BorderPane();
        b3_b10.setStyle("-fx-background-color: pink");
        b3_b10.setPrefHeight(300);
        b3_b10.setPrefWidth(300);
        b3.setTop(b3_b8);
        b3.setCenter(b3_b9);
        b3.setBottom(b3_b10);

        Text text = new Text("账户:" + username + "\n密码:" + password);
        b3_b10.setCenter(text);
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: cornflowerblue");

        bp.setLeft(b1);
        bp.setCenter(b2);
        bp.setRight(b3);
        Scene scene = new Scene(bp);
        stageWindow.setScene(scene);
        stageWindow.setResizable(false);
        stageWindow.setWidth(1000);
        stageWindow.setHeight(800);
        stageWindow.setTitle("MayDay");
        stageWindow.getIcons().add(new Image("/fxml/login/img/system/icon.png"));
        stageWindow.show();
    }
}