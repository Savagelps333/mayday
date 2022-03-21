package com.mayday.view.chat;

import java.util.Date;

public class ChatController extends ChatInit implements IChatMethod {

    private ChatView chatView;
    private ChatEventDefine chatEventDefine;

    public ChatController(IChatEvent chatEvent) {
        super(chatEvent);
    }

    @Override
    public void initView() {
        chatView = new ChatView(this, chatEvent);
    }

    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this, chatEvent, this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void setUserInfo(String userId, String userNickName, String userHead) {

    }

    @Override
    public void addTalkBox(int talkIdx, Integer talkType, String talkId, String talkName, String talkHead, String talkSketch, Date talkDate, Boolean selected) {

    }

    @Override
    public void addTalkMsgUserLeft(String talkId, String msg, Integer msgType, Date msgData, Boolean idxFirst, Boolean selected, Boolean isRemind) {

    }

    @Override
    public void addTalkMsgGroupLeft(String talkId, String userId, String userNickName, String userHead, String msg, Integer msgType, Date msgDate, Boolean idxFirst, Boolean selected, Boolean isRemind) {

    }

    @Override
    public void addTalkMsgRight(String talkId, String msg, Integer msgType, Date msgData, Boolean idxFirst, Boolean selected, Boolean isRemind) {

    }

    @Override
    public void addFriendGroup(String groupId, String groupName, String groupHead) {

    }

    @Override
    public void addFriendUser(boolean selected, String userId, String userNickName, String userHead) {

    }

    @Override
    public void addLuckFriend(String userId, String userNickName, String userHead, Integer status) {

    }


    @Override
    public double getToolFaceX() {
        return x() + width() - 960;
    }

    @Override
    public double getToolFaceY() {
        return y() + height() - 180;
    }

}
