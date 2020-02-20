package com.chatsystem.chatsystemproject.page;

import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;


@MountPath("CreateAccount")
public class CreateAccountPage extends WebPage {
    public CreateAccountPage(){

        var userNameModel = Model.of("");
        var passwordModel = Model.of("");


        var createAccountForm = new Form<>("CreateAccountForm");
        add(createAccountForm);
        createAccountForm.add(new Button("CreateAccountButton"){
            @Override
            public void onSubmit() {
                var userName = userNameModel.getObject();
                var password = passwordModel.getObject();
                var msg = "送信データ："
                        + userName
                        + ","
                        + password;
                System.out.println(msg);
            }
        });

        var userNameField = new TextField<>("UserNameField",userNameModel);
        createAccountForm.add(userNameField);

        var passwordField = new PasswordTextField("PasswordField",passwordModel);
        createAccountForm.add(passwordField);

        add(createAccountForm);

    }



}
