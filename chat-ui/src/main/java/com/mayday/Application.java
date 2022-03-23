package com.mayday;


import com.mayday.view.chat.ChatController;
import com.mayday.view.chat.IChatEvent;
import com.mayday.view.chat.IChatMethod;
import com.mayday.view.login.ILoginMethod;
import com.mayday.view.login.LoginController;
import javafx.stage.Stage;


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
                System.out.println("退出");
            }
        });
        chat.doShow();


//        ILoginMethod login = new LoginController((email, password) -> {
//            System.out.println("登陆 userId：" + email + "   userPassword：" + password);
//        });
//
//        login.doShow();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
