package com.mayday.view.login;

/**

 * 页面展示元素和事件定义
 * 暂时无用
 */
public class LoginView {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }

}
