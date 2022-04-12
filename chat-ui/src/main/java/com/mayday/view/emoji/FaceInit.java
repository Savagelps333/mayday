package com.mayday.view.emoji;

import com.mayday.view.UIObject;
import com.mayday.view.chat.ChatInit;
import com.mayday.view.chat.IChatEvent;
import com.mayday.view.chat.IChatMethod;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.IOException;

public abstract class FaceInit extends UIObject {

    private static final String RESOURCE_NAME = "/fxml/face/face.fxml";

    public FlowPane rootPane;

    public ChatInit chatInit;
    public IChatEvent chatEvent;
    public IChatMethod chatMethod;

    FaceInit(final UIObject obj) {
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        // 模态窗口
        initModality(Modality.APPLICATION_MODAL);
        initOwner(obj);
        // 初始化页面&事件
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        rootPane = $("face", FlowPane.class);
    }

    public Parent root(){
        return super.root;
    }

}
