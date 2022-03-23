package com.mayday.view.chat;

/**
 * @Author sava
 * @Datetime 2022/3/22 0:41
 * @Version 1.0
 **/
public class ChatView {
    private ChatInit chatInit;
    private IChatEvent chatEvent;

    public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;

    }
}
