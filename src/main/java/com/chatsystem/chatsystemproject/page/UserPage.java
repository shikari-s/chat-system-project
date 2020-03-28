package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.RegisteredFriend;
import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.service.IUserPageService;
import com.chatsystem.chatsystemproject.session.MySession;
import org.apache.wicket.DefaultMapperContext;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("User")
public class UserPage extends WebPage {

    @SpringBean
    private IUserPageService userPageService;

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
        }).add(new TextField<>("inputUserName",userNameModel));


        //友達一覧をserviceページを通してRepositoryから受け取る
        var friendListModel = Model.ofList(userPageService.getFriendList(MySession.get().getMyUserId()));

        //友達一覧を表示
        var friendListView = new ListView<>("friendListView", friendListModel) {

            @Override
            protected void populateItem(ListItem<User> listItem) {
                var itemModel = listItem.getModel();
                var friendIdInformation = itemModel.getObject();

                //友達の名前を表示
                listItem.add(new Label("friendName", Model.of(friendIdInformation.getName())));

                //PersonalMessagePageへのリンク
                listItem.add(new Link<>("toPersonalMessagePage") {
                    @Override
                    public void onClick() {
                        setResponsePage((new PersonalMessagePage(itemModel)));
                    }
                }.add(new Label("personalMessage", Model.of("DMページへ"))));
            }
        };
        add(friendListView);

    }

}
