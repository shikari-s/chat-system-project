package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.UserStatus;
import com.chatsystem.chatsystemproject.service.IManageUserPageService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;


@AuthorizeInstantiation(Roles.USER)
@MountPath("ManageUser")
public class ManageUserPage extends WebPage {

    @SpringBean
    private IManageUserPageService manageUserPageService;

    public ManageUserPage(String userName){
        //var userStatusList = manageUserPageService.getUserList(userName);

        var userStatusListModel = Model.ofList(manageUserPageService.getUserList(userName));
        var userStatusListView = new ListView<>("userStatus",userStatusListModel){
            @Override
            protected void populateItem(ListItem<UserStatus> listItem){
                var itemModel = listItem.getModel();
                UserStatus userStatus = itemModel.getObject();

                var userNameModel = Model.of(userStatus.getUserName());
                var userNameLabel = new Label("userName",userNameModel);
                add(userNameLabel);

                var isFriendModel = Model.of("友達です");
                if (userStatus.isRegisteredFriend() == false){
                    isFriendModel = Model.of("友達登録");
                }
                var isFriendLabel = new Label("isFriend",isFriendModel);
                add(isFriendLabel);

                var isBlockedModel = Model.of("ブロック中です");
                if (userStatus.isBlocked() == false){
                    isBlockedModel = Model.of("ブロックする");
                }
                var isBlockedLabel = new Label("isBlocked",isBlockedModel);
                add(isBlockedLabel);
            }
        };
        add(userStatusListView);
    }
}
