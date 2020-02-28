package com.chatsystem.chatsystemproject.page;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("User")
public class UserPage extends WebPage {

    public UserPage() {

        var userNameModel = Model.of("");

        //ユーザー検索フォームの処理
        var searchUserForm = new Form<>("searchUserForm");
        add(searchUserForm);

        //ユーザー検索ボタンを押した際の処理
        searchUserForm.add(new Button("searchUserButton") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                setResponsePage(new ManageUserPage(userNameModel.getObject()));
            }
        });

        searchUserForm.add(new TextField<>("inputUserName",userNameModel));

    }

}
