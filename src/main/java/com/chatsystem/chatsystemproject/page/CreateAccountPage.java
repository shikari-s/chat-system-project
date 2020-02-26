package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.service.ICreateAccoountPageService;
import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("CreateAccount")
public class CreateAccountPage extends WebPage {
    @SpringBean
    private ICreateAccoountPageService createAccoountPageService;

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
                createAccoountPageService.registerUser(userName,password);
                setResponsePage(new UserPage());
            }
        });

        var userNameField = new TextField<>("UserNameField",userNameModel);
        createAccountForm.add(userNameField);

        var passwordField = new PasswordTextField("PasswordField",passwordModel);
        createAccountForm.add(passwordField);

        add(createAccountForm);

    }



}
