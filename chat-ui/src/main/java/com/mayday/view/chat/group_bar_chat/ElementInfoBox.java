package com.mayday.view.chat.group_bar_chat;

import com.mayday.util.AutoSizeTool;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * @Author sava
 * @Datetime 2022/3/29 16:08
 * @Version 1.0
 **/
public class ElementInfoBox {

    private Pane pane;

    private Pane head;              // 头像
    private Label nikeName;         // 昵称区
    private Label infoContentArrow; // 内容箭头
    private TextArea infoContent;   // 内容
    //TODO 详细时间填充  HH:mm:ss

    /**
     * 好友消息
     * @param userNickName
     * @param userHead
     * @param msg
     * @param msgType
     * @return
     */
    public Pane left(String userNickName, String userHead, String msg, Integer msgType) {
        double autoHeight = AutoSizeTool.getHeight(msg);
        double autoWidth = AutoSizeTool.getWidth(msg);

        pane = new Pane();
        pane.setPrefSize(500, 50 + autoHeight);
        pane.getStyleClass().add("infoBoxElement");
        ObservableList<Node> children = pane.getChildren();

        // 头像
        head = new Pane();
        head.setPrefSize(50, 50);
        head.setLayoutX(15);
        head.setLayoutY(15);
        head.getStyleClass().add("box_head");
        head.setStyle(String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", userHead));
        children.add(head);

        // 昵称
        nikeName = new Label();
        nikeName.setPrefSize(450, 20);
        nikeName.setLayoutX(75);
        nikeName.setLayoutY(5);
        nikeName.setText(userNickName);
        nikeName.getStyleClass().add("box_nikeName");
        children.add(nikeName);

        // 箭头
        infoContentArrow = new Label();
        infoContentArrow.setPrefSize(16, 16);
        infoContentArrow.setLayoutX(69);
        infoContentArrow.setLayoutY(35);
        infoContentArrow.getStyleClass().add("box_infoContent_left_arrow");
        children.add(infoContentArrow);


        switch (msgType){
            case 0:
                // 内容
                infoContent = new TextArea();
                infoContent.setPrefWidth(autoWidth);
                infoContent.setPrefHeight(autoHeight);
                infoContent.setLayoutX(80);
                infoContent.setLayoutY(30);
                infoContent.setWrapText(true);
                infoContent.setEditable(false);
                infoContent.setText(msg);
                infoContent.getStyleClass().add("box_infoContent_left");
                children.add(infoContent);
                break;
            case 1:
                ImageView emoji = new ImageView(new Image(String.format("/fxml/face/img/%s",msg)));
                emoji.setFitHeight(30);
                emoji.setFitWidth(30);
                FlowPane infoContentFace = new FlowPane();
                infoContentFace.getChildren().add(emoji);
                infoContentFace.setAlignment(Pos.CENTER);
                infoContentFace.setPrefWidth(60);
                infoContentFace.setPrefHeight(40);
                infoContentFace.setLayoutX(80);
                infoContentFace.setLayoutY(30);
                infoContentFace.setStyle("-fx-background-color: #ffffff;-fx-border-width: 0 1px 1px 0;-fx-border-radius: 8px;-fx-background-radius: 8px;");
                children.add(infoContentFace);//   #1296db
                break;
        }


        return pane;
    }

    /**
     * 个人消息
     *
     * @param userNickName  用户昵称
     * @param userHead      用户头像
     * @param msg           消息
     * @param msgType       类型；0文字消息、1固定表情
     * @return
     */

    public Pane right(String userNickName, String userHead, String msg, Integer msgType) {
        double autoHeight = AutoSizeTool.getHeight(msg);
        double autoWidth = AutoSizeTool.getWidth(msg);

        pane = new Pane();
        pane.setPrefSize(500, 50 + autoHeight);
        pane.setLayoutX(853);
        pane.setLayoutY(0);
        pane.getStyleClass().add("infoBoxElement");
        ObservableList<Node> children = pane.getChildren();

        // 头像
        head = new Pane();
        head.setPrefSize(50, 50);
        head.setLayoutX(770);
        head.setLayoutY(15);
        head.getStyleClass().add("box_head");
        head.setStyle(String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", userHead));
        children.add(head);

        // 箭头
        infoContentArrow = new Label();
        infoContentArrow.setPrefSize(16, 16);
        infoContentArrow.setLayoutX(750);
        infoContentArrow.setLayoutY(30);
        infoContentArrow.getStyleClass().add("box_infoContent_right_arrow");
        children.add(infoContentArrow);



        switch (msgType){
            case 0:
                // 内容：文字
                infoContent = new TextArea();
                infoContent.setPrefWidth(autoWidth);
                infoContent.setPrefHeight(autoHeight);
                infoContent.setLayoutX(755 - autoWidth);
                infoContent.setLayoutY(15);
                infoContent.setWrapText(true);
                infoContent.setEditable(false);
                infoContent.setText(msg);
                infoContent.getStyleClass().add("box_infoContent_right");
                children.add(infoContent);
                break;
            case 1:
                ImageView emoji = new ImageView(new Image(String.format("/fxml/face/img/%s",msg)));
                emoji.setFitHeight(30);
                emoji.setFitWidth(30);
                FlowPane infoContentFace = new FlowPane();
                infoContentFace.getChildren().add(emoji);
                infoContentFace.setAlignment(Pos.CENTER);
                infoContentFace.setPrefWidth(60);
                infoContentFace.setPrefHeight(40);
                infoContentFace.setLayoutX(755 - 60);
                infoContentFace.setLayoutY(15);
                infoContentFace.setStyle("-fx-background-color: #ffffff;-fx-border-width: 0 1px 1px 0;-fx-border-radius: 8px;-fx-background-radius: 8px;");
                children.add(infoContentFace);//   #1296db
                break;
        }
        return pane;
    }

}



