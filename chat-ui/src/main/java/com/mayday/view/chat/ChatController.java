package com.mayday.view.chat;

/**
 * @Author sava
 * @Datetime 2022/3/22 0:36
 * @Version 1.0
 **/
public class ChatController extends ChatInit implements IChatMethod{
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
}
