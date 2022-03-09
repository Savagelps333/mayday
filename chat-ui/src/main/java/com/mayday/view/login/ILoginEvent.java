package com.mayday.view.login;

public interface ILoginEvent {
    /**
     * 登陆校验
     * @param userId
     * @param userPassword
     */
    void doLoginCheck(String userId,String userPassword);

}
