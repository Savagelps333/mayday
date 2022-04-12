package com.mayday.view.chat;

import com.mayday.view.chat.data.TalkBoxData;
import com.mayday.view.emoji.FaceController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.Date;

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
        doEventTextSend();   // 发送消息事件[键盘]
        doEventTouchSend();  // 发送消息事件[按钮]

        friendPage();
        groupPage();
        doEventToolFace();   // 表情窗体
    }

    private void min() {
        chatInit.group_bar_chat_min.setOnAction(event -> {
//            System.out.println(chatInit.group_bar_friend_close);
//            System.out.println(chatInit.group_bar_setting_close);
            chatInit.setIconified(true);
        });
        chatInit.group_bar_friend_min.setOnAction(event -> {
            chatInit.setIconified(true);
        });
        chatInit.group_bar_setting_min.setOnAction(event -> {
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


    /**
     * 为什么需要setOnMouseEntered、setOnMouseExited。因为设置了在该按钮的点击事件里面，设置
     * 了button的样式，对CSS的选择器造成了一定的疑惑，因此css的伪类选择器失效了
     */
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


    //好友页按钮点击事件
    public void friendPage(){
        chatInit.group_bar_friend_user_btn.setOnAction(event -> {
            switchFriendPage(chatInit.group_bar_friend_user_btn,chatInit.group_bar_friend_userPage,true);
            switchGroupPage(chatInit.group_bar_friend_group_btn,chatInit.group_bar_friend_groupPage,false);
        });

        chatInit.group_bar_friend_user_btn.setOnMouseEntered(event -> {
            boolean visible = chatInit.group_bar_friend_userPage.isVisible();
            if (visible) return;
            chatInit.group_bar_friend_user_btn.setStyle("-fx-background-color: #3f3f3f");
        });
        chatInit.group_bar_friend_user_btn.setOnMouseExited(event -> {
            boolean visible = chatInit.group_bar_friend_userPage.isVisible();
            if (visible) return;
            chatInit.group_bar_friend_user_btn.setStyle("-fx-background-color: #272727");
        });
    }


    //群组页按钮点击事件
    public void groupPage(){
        chatInit.group_bar_friend_group_btn.setOnAction(event -> {
            switchFriendPage(chatInit.group_bar_friend_user_btn,chatInit.group_bar_friend_userPage,false);
            switchGroupPage(chatInit.group_bar_friend_group_btn,chatInit.group_bar_friend_groupPage,true);
        });
        chatInit.group_bar_friend_group_btn.setOnMouseEntered(event -> {
            boolean visible = chatInit.group_bar_friend_groupPage.isVisible();
            if (visible) return;
            chatInit.group_bar_friend_group_btn.setStyle("-fx-background-color: #3f3f3f");
        });
        chatInit.group_bar_friend_group_btn.setOnMouseExited(event -> {
            boolean visible = chatInit.group_bar_friend_groupPage.isVisible();
            if (visible) return;
            chatInit.group_bar_friend_group_btn.setStyle("-fx-background-color: #272727");
        });
    }

    //切换friendPage
    public void switchFriendPage(Button user_btn, Pane friendPage, boolean toggle){
        if (toggle) {
            friendPage.setVisible(true);
            user_btn.setStyle("-fx-background-color: #353535");
        } else {
            friendPage.setVisible(false);
            user_btn.setStyle("-fx-background-color: #272727");
        }
    }

    //切换groupPage
    public void switchGroupPage(Button group_btn, Pane groupPage, boolean toggle){
        if (toggle) {
            groupPage.setVisible(true);
            group_btn.setStyle("-fx-background-color: #353535");
        } else {
            groupPage.setVisible(false);
            group_btn.setStyle("-fx-background-color: #272727");
        }
    }


    // 发送消息事件[键盘]
    private void doEventTextSend() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        txt_input.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                doEventSendMsg();
            }
        });
    }

    // 发送消息事件[按钮]
    private void doEventTouchSend() {
        Label touch_send = chatInit.$("touch_send", Label.class);
        touch_send.setOnMousePressed(event -> {
            doEventSendMsg();
        });
    }

    private void doEventSendMsg() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        MultipleSelectionModel selectionModel = chatInit.$("talkList", ListView.class).getSelectionModel();
        Pane selectedItem = (Pane) selectionModel.getSelectedItem();
        // 对话信息
        TalkBoxData talkBoxData = (TalkBoxData) selectedItem.getUserData();
        System.out.println(txt_input.getText());
        StringBuilder msg = new StringBuilder(txt_input.getText());
        if (null == msg || "".equals(msg) || "".equals(msg.toString().trim())) {
            return;
        }
        Date msgDate = new Date();
        // 发送消息
        chatEvent.doSendMsg(chatInit.userId, talkBoxData.getTalkId(), talkBoxData.getTalkType(), msg.toString(), 0, msgDate);
        // 发送事件给自己添加消息
        if (msg.toString().indexOf("\n") == 0){
            chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), msg.toString().replaceFirst("\n",""), 0,msgDate, true, true, false);
        }else{
            chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), msg.toString(), 0,msgDate, true, true, false);
        }
        txt_input.clear();
    }


    // 好友；开启与好友发送消息 [点击发送消息时候触发 -> 添加到对话框、选中、展示对话列表]
    public void doEventOpenFriendUserSendMsg(Button sendMsgButton, String userFriendId, String userFriendNickName, String userFriendHead) {
        sendMsgButton.setOnAction(event -> {
            // 1. 添加好友到对话框
            chatMethod.addTalkBox(0, 0, userFriendId, userFriendNickName, userFriendHead, null, null, true);
            // 2. 切换到对话框窗口
            switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), true);
            switchBarFriend(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);
            // 3. 事件处理；填充到对话框
            chatEvent.doEventAddTalkUser(chatInit.userId, userFriendId);
        });
    }



    // 群组；开启与群组发送消息
    public void doEventOpenFriendGroupSendMsg(Button sendMsgButton, String groupId, String groupName, String groupHead) {
        sendMsgButton.setOnAction(event -> {
            // 1. 添加好友到对话框
            chatMethod.addTalkBox(0, 1, groupId, groupName, groupHead, null, null, true);
            // 2. 切换到对话框窗口
            switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), true);
            switchBarFriend(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);
            // 3. 事件处理；填充到对话框
            chatEvent.doEventAddTalkGroup(chatInit.userId, groupId);
        });
    }

    // 表情
    private void doEventToolFace() {
        FaceController face = new FaceController(chatInit, chatInit, chatEvent, chatMethod);
        Button tool_face = chatInit.$("tool_face", Button.class);
        tool_face.setOnMousePressed(event -> {
            face.doShowFace(chatMethod.getToolFaceX(), chatMethod.getToolFaceY());
        });
    }

}
