package com.mayday.view.chat;

public class ChatView {

    private ChatInit chatInit;
    private IChatEvent chatEvent;

    public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;

        //1. 好友列表添加工具方法‘新的朋友’
        initAddFriendLuck();
        //2. 好友列表添加‘公众号’
        addFriendSubscription();
        //3. 好友群组框体
        addFriendGroupList();
        //4. 好友框体
        addFriendUserList();
    }

    private void addFriendUserList() {

    }

    private void addFriendGroupList() {

    }

    private void addFriendSubscription() {

    }

    private void initAddFriendLuck() {

    }


}
