package com.mayday.view.chat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * @Author sava
 * @Datetime 2022/3/22 0:33
 * @Version 1.0
 **/
public class ChatEventDefine {
    private ChatInit chatInit;
    private IChatEvent chatEvent;
    private IChatMethod chatMethod;

    public ChatEventDefine(ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;

        chatInit.move();
        min();               // 最小化
        quit();              // 退出
        barChat();           // 聊天
        barFriend();         // 好友
        barSetting();          //设置
//        doEventTextSend();   // 发送消息事件[键盘]
//        doEventTouchSend();  // 发送消息事件[按钮]
//        doEventToolFace();   // 表情窗体
    }

    private void min() {
        chatInit.group_bar_chat_min.setOnAction(event -> {
            System.out.println(chatInit.group_bar_friend_close);
            System.out.println(chatInit.group_bar_setting_close);
            System.out.println("chat_min");
            chatInit.setIconified(true);
        });
        chatInit.group_bar_friend_min.setOnAction(event -> {
            System.out.println("friend_min");
            chatInit.setIconified(true);
        });
        chatInit.group_bar_setting_min.setOnAction(event -> {
            System.out.println("setting_min");
            chatInit.setIconified(true);
        });

    }
    private void quit() {
        chatInit.group_bar_chat_close.setOnAction(event -> {
            chatEvent.doQuit();
            chatInit.close();
            System.exit(0);
        });
        chatInit.group_bar_friend_close.setOnAction(event -> {
            chatEvent.doQuit();
            chatInit.close();
            System.exit(0);
        });
        chatInit.group_bar_setting_close.setOnAction(event -> {
            chatEvent.doQuit();
            chatInit.close();
            System.exit(0);
        });

    }

    private void barChat() {
        chatInit.bar_chat.setOnAction(event -> {
            switchBarChat(chatInit.bar_chat, chatInit.group_bar_chat, true);
            switchBarFriend(chatInit.bar_friend, chatInit.group_bar_friend, false);
            switchBarSetting(chatInit.bar_setting, chatInit.group_bar_setting, false);
        });

        chatInit.bar_chat.setOnMouseEntered(event -> {
            boolean visible = chatInit.group_bar_chat.isVisible();
            if (visible) return;
            chatInit.bar_chat.setStyle("-fx-background-color: #3f3f3f");
        });
        chatInit.bar_chat.setOnMouseExited(event -> {
            boolean visible = chatInit.group_bar_chat.isVisible();
            if (visible) return;
            chatInit.bar_chat.setStyle("-fx-background-color: #272727");
        });
    }



    private void barFriend() {
        chatInit.bar_friend.setOnAction(event -> {
            switchBarChat(chatInit.bar_chat, chatInit.group_bar_chat, false);
            switchBarFriend(chatInit.bar_friend, chatInit.group_bar_friend, true);
            switchBarSetting(chatInit.bar_setting, chatInit.group_bar_setting, false);

        });

        chatInit.bar_friend.setOnMouseEntered(event -> {
            boolean visible = chatInit.group_bar_friend.isVisible();
            if (visible) return;
            chatInit.bar_friend.setStyle("-fx-background-color: #3f3f3f");
        });
        chatInit.bar_friend.setOnMouseExited(event -> {
            boolean visible = chatInit.group_bar_friend.isVisible();
            if (visible) return;
            chatInit.bar_friend.setStyle("-fx-background-color: #272727");
        });
    }


    private void barSetting() {
        chatInit.bar_setting.setOnAction(event -> {
            switchBarChat(chatInit.bar_chat, chatInit.group_bar_chat, false);
            switchBarFriend(chatInit.bar_friend, chatInit.group_bar_friend, false);
            switchBarSetting(chatInit.bar_setting, chatInit.group_bar_setting, true);

        });

        chatInit.bar_setting.setOnMouseEntered(event -> {
            boolean visible = chatInit.group_bar_setting.isVisible();
            if (visible) return;
            chatInit.bar_setting.setStyle("-fx-background-color: #3f3f3f");
        });
        chatInit.bar_setting.setOnMouseExited(event -> {
            boolean visible = chatInit.group_bar_setting.isVisible();
            if (visible) return;
            chatInit.bar_setting.setStyle("-fx-background-color: #272727");
        });

    }

    // 切换：bar_chat
    private void switchBarChat(Button bar_chat, Pane group_bar_chat, boolean toggle) {
        if (toggle) {
            group_bar_chat.setVisible(true);
            bar_chat.setStyle("-fx-background-color: #353535");
        } else {
            group_bar_chat.setVisible(false);
            bar_chat.setStyle("-fx-background-color: #272727");
        }


    }
    //切换：bar_friend
    private void switchBarFriend(Button bar_friend, Pane group_bar_friend, boolean toggle) {
        if (toggle) {
            group_bar_friend.setVisible(true);
            bar_friend.setStyle("-fx-background-color: #353535");
        } else {
            group_bar_friend.setVisible(false);
            bar_friend.setStyle("-fx-background-color: #272727");
        }
    }
    //切换：bar_setting

    private void switchBarSetting(Button bar_setting, Pane group_bar_setting, boolean toggle) {
        if (toggle) {
            group_bar_setting.setVisible(true);
            bar_setting.setStyle("-fx-background-color: #353535");
        } else {
            group_bar_setting.setVisible(false);
            bar_setting.setStyle("-fx-background-color: #272727");
        }

    }


}
