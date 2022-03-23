package com.mayday.view.login;


import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class LoginEventDefine {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;
    private ILoginMethod loginMethod;

    public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
        this.loginMethod = loginMethod;

        loginInit.move();//这是个监听事件
        min();
        quit();
        doEventLogin();
    }

    // 事件；最小化
    private void min() {
        loginInit.login_min.setOnAction(event -> {
            loginInit.setIconified(true);
        });
    }

    // 事件；退出
    private void quit() {
        loginInit.login_close.setOnAction(event -> {
            loginInit.close();//窗口关闭了，但是程序还是会继续运行，因此需要下一行代码
            System.exit(0);
        });
    }

    // 事件；登陆
    private void doEventLogin() {
        loginInit.login_button.setOnAction(event -> {
            loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
            String email = loginInit.userId.getText();
            String password = loginInit.userPassword.getText();
            if ("110@qq.com".equals(email) && "110".equals(password)) {

                loginInit.close();
            }else {
                //动画 渐变  密码错误的时候有种刷新的感觉,一闪而过,跟浏览器一样
                FadeTransition fadeTransition = new FadeTransition();
                //设置时间
                fadeTransition.setDuration(Duration.seconds(0.2));
                fadeTransition.setNode(loginInit.login);
                //设置透明度
                fadeTransition.setFromValue(0.5);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            }
        });
    }

}
