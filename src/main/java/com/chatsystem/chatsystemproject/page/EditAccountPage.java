package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.service.IEditAccountPageService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("EditAccount")
public class EditAccountPage extends WebPage {
    @SpringBean
    private IEditAccountPageService editAccountPageService;

    public EditAccountPage(){
        var user = editAccountPageService.getMySessionUser();
        var userNameModel = Model.of(user.getName());
        var passwordModel = Model.of("");
        var userIdModel = Model.of(user.getId());//UserのIdを持ってくる

        var editAccountForm = new Form<>("EditAccountForm");
        add(editAccountForm);
        editAccountForm.add(new Button("EditAccountButton"){
            @Override
            public void onSubmit() {
                var userName = userNameModel.getObject();
                var password = passwordModel.getObject();
                var userId = userIdModel.getObject();
                editAccountPageService.Update(userName,password,userId);
                setResponsePage(new TopPage());
            }
        });

        var userNameField = new TextField<>("UserNameField",userNameModel);
        editAccountForm.add(userNameField);

        var passwordField = new PasswordTextField("PasswordField",passwordModel);
        editAccountForm.add(passwordField);

        add(editAccountForm);

        var toTopPageLink = new Link<>("TopPageLink"){
            @Override
            public void onClick(){
                setResponsePage(new TopPage());
            }
        };
        add(toTopPageLink);
    }

}
