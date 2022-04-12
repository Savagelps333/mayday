package com.mayday;


import com.mayday.view.chat.ChatController;
import com.mayday.view.chat.IChatEvent;
import com.mayday.view.chat.IChatMethod;
import com.mayday.view.chat.group_bar_friend.ElementFriendLuckUser;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Date;


/**
 * 窗口          Stage
 * -场景       Scene
 * -布局     stackPane
 * -控件   Button
 */
public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        IChatMethod chat = new ChatController(new IChatEvent() {
            @Override
            public void doQuit() {
                System.out.println("退出操作！");
            }

            @Override
            public void doSendMsg(String userId, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate) {
//                System.out.println("发送消息");
//                System.out.println("userId：" + userId);
//                System.out.println("talkType[0好友/1群组]：" + talkType);
//                System.out.println("talkId：" + talkId);
//                System.out.println("msg：" + msg);
//                System.out.println("msgType[0文字消息/1固定表情]：" + msgType);
            }

            @Override
            public void doEventAddTalkUser(String userId, String userFriendId) {
                System.out.println("填充到聊天窗口[好友] userFriendId：" + userFriendId);
            }

            @Override
            public void doEventAddTalkGroup(String userId, String groupId) {
                System.out.println("填充到聊天窗口[群组] groupId：" + groupId);
            }

            @Override
            public void doEventDelTalkUser(String userId, String talkId) {
                System.out.println("删除对话框：" + talkId);
            }

            @Override
            public void addFriendLuck(String userId, ListView<Pane> listView) {
                System.out.println("新的朋友");
                // 添加朋友
                listView.getItems().add(new ElementFriendLuckUser("1000005", "小次郎", "head_05", 0).pane());
                listView.getItems().add(new ElementFriendLuckUser("1000006", "武藏", "head_06", 1).pane());
                listView.getItems().add(new ElementFriendLuckUser("1000007", "石男", "head_07", 2).pane());
            }

            @Override
            public void doFriendLuckSearch(String userId, String text) {
                System.out.println("搜索好友：" + text);
            }

            @Override
            public void doEventAddLuckUser(String userId, String friendId) {
                System.out.println("添加好友：" + friendId);
            }
        });
        chat.doShow();
        // 填充对话框测试数据
        chat.setUserInfo("1000001", "Akira", "head");
        // 好友 - 对话框
        chat.addTalkBox(-1, 0, "1000004", "杰哥", "head_02", null, null, false);
        chat.addTalkMsgUserLeft("1000004", "009.png",1, new Date(), true, false, true);
        chat.addTalkMsgRight("1000004", "013.png",1, new Date(), true, true, false);
        chat.addTalkBox(-1, 0, "1000002", "阿伟", "head_04", "秋风扫过树叶落，哪有棋盘哪有我", new Date(), false);
        chat.addTalkMsgUserLeft("1000002", "梦里寻她千百度,蓦然回首,那人却在灯火阑珊处",0, new Date(), true, false, true);
        chat.addTalkMsgRight("1000002", "江湖路远，且行且珍惜",0, new Date(), true, true, false);


//        chat.addTalkBox(-1, 0, "1000005", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "1000006", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "1000007", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "1000008", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "1000009", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "10000012", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "10000013", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "1000010", "杰哥", "head_02", null, null, false);
//        chat.addTalkBox(-1, 0, "1000011", "杰哥", "head_02", null, null, false);


        // 群组 - 对话框
        chat.addTalkBox(0, 1, "5307397", "GD - wefun", "group_01", "", new Date(), true);
        chat.addTalkMsgRight("5307397", "朋友们，老地方，来一杯嘛", 0,new Date(), true, true, false);
        chat.addTalkMsgGroupLeft("5307397", "1000002", "阿伟", "head_04", "Windows，macOSX和Linux下启动时去除黑屏的问题：\n" +
                "一个常见的萌新问题是，在win下，通过javafx-maven-plugin生成的启动文件是一个bat批处理文件，双击启动的时候，会有黑屏跳出，该如何将其屏蔽？\n" +
                "这个其实是windows本身的问题，跟java并无直接关联，你可以在网络上搜索，bat to exe，就能找到很多工具，一个常见的工具是bat to exe converter，就能将bat文件转换成exe文件，其中有一个选项是invisible mode，不可见模式，点选该模式之后，生成的exe文件，双击后就不会出现黑屏即可启动。\n" +
                "该工具我有下载并上传到群里，但是随着时间推移，可能失效，如已经失效，萌新可自行搜索并下载该工具\n" +
                "与Windows下双击启动不打开终端类似，mac下也有相应的工具，而且是开源的工具，链接如下：\n" +
                "http://sveinbjorn.org/platypus\n" +
                "有图形界面，按提示操作即可\n" +
                "Linux相对复杂一点，要使用到.desktop，搜索一下即可，有些linux的distro，例如树莓派，可以通过右键点击启动图形界面来设置，但是原理上，还是通过.desktop，可根据该关键字自行搜索不同linux下的双击启动方案",0, new Date(), true, false, true);
        chat.addTalkMsgGroupLeft("5307397", "1000002", "阿伟", "head_04", "AAAAAAAAAAAA", 0,new Date(), true, false, true);
        chat.addTalkMsgGroupLeft("5307397", "1000003", "云枫", "head_03", "aaaaaaaaaaaa",0, new Date(), true, false, true);
        chat.addTalkMsgGroupLeft("5307397", "1000004", "杰哥", "head_02", "寻寻觅觅，冷冷清清，凄凄惨惨戚戚。乍暖还寒时候，最难将息。三杯两盏淡酒，怎敌他、晚来风急！雁过也，正伤心，却是旧时相识。",0, new Date(), true, false, true);

        //群组
        chat.addFriendGroup("5307397", "开黑啦！", "group_01");
        chat.addFriendGroup("5307392", "保乐网吧", "group_01");
        chat.addFriendGroup("5307399", "温州城", "group_01");
        chat.addFriendGroup("5307369", "绅士日报", "group_01");


        // 好友
        chat.addFriendUser(false, "1000004", "杰哥", "head_02");
        chat.addFriendUser(false, "1000001", "耶路撒冷", "head_02");
        chat.addFriendUser(false, "1000002", "阿伟", "head_04");
        chat.addFriendUser(true, "1000003", "金田", "head_02");
    }

//        ILoginMethod login = new LoginController((email, password) -> {
//            System.out.println("登陆 userId：" + email + "   userPassword：" + password);
//        });
//
//        login.doShow();


    public static void main(String[] args) {
        launch(args);
        //hello
    }

}
