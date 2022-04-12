package com.mayday.view.chat;

import com.mayday.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;


import java.io.IOException;

/**
 * @Author sava
 * @Datetime 2022/3/22 0:14
 * @Version 1.0
 **/
public abstract class ChatInit extends UIObject {
    private static final String RESOURCE_NAME = "/fxml/chat/chat.fxml";
    public String userId;// 用户ID
    public String userNickName; // 用户昵称
    public String userHead;     // 用户头像

    public IChatEvent chatEvent;

    public Pane main_view;//聊天主界面
    public Pane side_bar;//侧边栏
    public Pane bar_portrait;//头像
    public Button bar_chat;//聊天
    public Button bar_friend;//好友
    public Button bar_setting;//设置
    public Pane group_bar_chat;//聊天界面
    public Pane group_bar_friend;//好友界面
    public Pane group_bar_setting;//设置界面
    public Button group_bar_chat_min;//聊天界面的最小化
    public Button group_bar_friend_min;//好友界面的最小化
    public Button group_bar_setting_min;//设置界面的最小化
    public Button group_bar_chat_close;//聊天界面的关闭
    public Button group_bar_friend_close;//好友界面的关闭
    public Button group_bar_setting_close;//设置界面的关闭

    public Button group_bar_friend_user_btn;//好友分页按钮
    public Button group_bar_friend_group_btn;//群组分页按钮
    public Pane group_bar_friend_userPage;//好友分页
    public Pane group_bar_friend_groupPage;//群组分页



    public ChatInit(IChatEvent chatEvent) {
        this.chatEvent = chatEvent;
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
        this.setTitle("NetTalk - A terrible communication tool");
        this.getIcons().add(new Image("/fxml/login/img/system/logo.png"));
        obtain();
        initView();
        initEventDefine();

    }

    private void obtain() {
        main_view = $("main_view",Pane.class);
        side_bar = $("side_bar",Pane.class);
        bar_portrait = $("bar_portrait",Pane.class);
        bar_chat = $("bar_chat",Button.class);
        bar_friend = $("bar_friend",Button.class);
        bar_setting = $("bar_setting",Button.class);
        group_bar_chat = $("group_bar_chat",Pane.class);
        group_bar_friend = $("group_bar_friend",Pane.class);
        group_bar_setting = $("group_bar_setting",Pane.class);
        group_bar_chat_min = $("group_bar_chat_min",Button.class);
        group_bar_friend_min = $("group_bar_friend_min",Button.class);
        group_bar_setting_min = $("group_bar_setting_min",Button.class);
        group_bar_chat_close = $("group_bar_chat_close",Button.class);
        group_bar_friend_close = $("group_bar_friend_close",Button.class);
        group_bar_setting_close = $("group_bar_setting_close",Button.class);
        group_bar_friend_user_btn = $("group_bar_friend_user_btn",Button.class);
        group_bar_friend_group_btn = $("group_bar_friend_group_btn",Button.class);
        group_bar_friend_userPage = $("group_bar_friend_userPage",Pane.class);
        group_bar_friend_groupPage = $("group_bar_friend_groupPage",Pane.class);


    }
}
