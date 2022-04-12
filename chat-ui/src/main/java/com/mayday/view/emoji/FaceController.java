package com.mayday.view.emoji;


import com.mayday.view.UIObject;
import com.mayday.view.chat.ChatInit;
import com.mayday.view.chat.IChatEvent;
import com.mayday.view.chat.IChatMethod;

public class FaceController extends FaceInit implements IFaceMethod {

    private FaceView faceView;

    public FaceController(UIObject obj, ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        super(obj);
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;
    }

    @Override
    public void initView() {
        faceView = new FaceView(this);
    }

    @Override
    public void initEventDefine() {
        new FaceEventDefine(this);
    }

    @Override
    public void doShowFace(Double x, Double y) {
        setX(x + 100 * (1 - 0.618));  // 设置位置X
        setY(y - 250);                      // 设置位置Y
        show();                             // 展示窗口
    }

}
