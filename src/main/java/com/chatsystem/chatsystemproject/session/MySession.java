package com.chatsystem.chatsystemproject.session;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import java.util.Objects;

public class MySession extends AbstractAuthenticatedWebSession {

    private Long myUserId;
    private String myUserName;

    public MySession(Request request) {
        // コンストラクタ。初期状態は認証NG（userName = null）
        super(request);
        this.setMyUserId(null);
        this.setMyUserName(null);
    }

    @Override
    public Roles getRoles() {

        if (isSignedIn()) {
            return new Roles(Roles.USER);
        }
        return new Roles();

    }

    @Override
    public boolean isSignedIn() {
        return Objects.nonNull(this.getMyUserId()) && Objects.nonNull(this.getMyUserName());
    }

    public void signIn(Long userId, String userName) {

        changeSessionId();
        this.setMyUserId(userId);
        this.setMyUserName(userName);

    }

    public static MySession get() {
        return (MySession) Session.get();
    }


    public Long getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(Long myUserId) {
        this.myUserId = myUserId;
    }

    public String getMyUserName() {
        return myUserName;
    }

    public void setMyUserName(String myUserName) {
        this.myUserName = myUserName;
    }
}
