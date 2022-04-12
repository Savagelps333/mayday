package com.mayday.view.emoji;


import com.mayday.view.chat.data.TalkBoxData;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;


import java.io.File;
import java.util.Date;

public class FaceView {

    private FaceInit faceInit;

    public FaceView(FaceInit faceInit) {
        this.faceInit = faceInit;
        // 初始化表情
        initFaces();
    }

    // 初始化表情
    private void initFaces() {

        FlowPane rootPane = faceInit.rootPane;
        rootPane.setHgap(8);//水平间距
        rootPane.setVgap(8);//垂直间距
        rootPane.setPadding(new Insets(10,0,0,10));
        ObservableList<Node> children = rootPane.getChildren();

        File file = new File("chat-ui/src/main/resources/fxml/face/img");
        for (String name : file.list()) {
            ImageView image = new ImageView("file:"+file.getAbsolutePath()+"/"+name);
            image.setUserData(name);
            image.setFitHeight(30);
            image.setFitWidth(30);
            image.getStyleClass().add("look");
            children.add(image);
        }



        for (Node next : children) {
            next.setOnMouseClicked(event -> {
                MultipleSelectionModel selectionModel = faceInit.chatInit.$("talkList", ListView.class).getSelectionModel();
                Pane selectedItem = (Pane) selectionModel.getSelectedItem();
                // 对话信息
                TalkBoxData talkBoxData = (TalkBoxData) selectedItem.getUserData();
                Date msgDate = new Date();
                String faceId = (String) next.getUserData();
                faceInit.chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), faceId, 1, msgDate, true, true, false);
                // 发送消息
                faceInit.chatEvent.doSendMsg(faceInit.chatInit.userId, talkBoxData.getTalkId(), talkBoxData.getTalkType(), faceId, 1, msgDate);
            });
        }

    }

}
