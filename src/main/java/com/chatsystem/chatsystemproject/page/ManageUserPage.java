package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.UserStatus;
import com.chatsystem.chatsystemproject.service.IManageUserPageService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;


@AuthorizeInstantiation(Roles.USER)
@MountPath("ManageUser")
public class ManageUserPage extends WebPage {

    @SpringBean
    private IManageUserPageService manageUserPageService;

    IModel isFriendModel = Model.of("");

    public ManageUserPage(String userName){


        //var userListWMC = new WebMarkupContainer("userListWMC");
        //userListWMC.setOutputMarkupId(true);
        //add(userListWMC);
        /**

        //ユーザーの友達登録、ブロックを行うボタンのForm
        var manageUserForm = new Form<>("manageUserForm");
        add(manageUserForm);
         */

        var userStatusListModel = Model.ofList(manageUserPageService.getUserListTest(userName));
        var userStatusListView = new ListView<>("userStatus",userStatusListModel){
            @Override
            protected void populateItem(ListItem<UserStatus> listItem){
                var itemModel = listItem.getModel();
                UserStatus userStatus = itemModel.getObject();

                var userNameModel = Model.of(userStatus.getUserName());
                var userNameLabel = new Label("userName",userNameModel);
                listItem.add(userNameLabel);

                //var isFriendModel = Model.of("");
                if (userStatus.isRegisteredFriend() == false){
                    isFriendModel = Model.of("友達登録");
                }else if(userStatus.isRegisteredFriend() == true){
                    isFriendModel = Model.of("登録解除");
                }
                var isFriendLabel = new Label("isFriend",isFriendModel);
                isFriendLabel.setOutputMarkupId(true);
                //userListWMC.add(isFriendLabel);

                //isFriendLabel.setOutputMarkupPlaceholderTag(true);
                var registerFriendLink = new AjaxLink<>("registerFriend"){
                    @Override
                    public void onClick(AjaxRequestTarget target){
                        //友達登録のための機能
                        manageUserPageService.registerFriend(userStatus.getUserId());
                        //isFriendModel = Model.of("");
                        //isFriendLabelが見えなくなるように画面の一部を更新
                        target.add(isFriendLabel.setVisible(false));
                        //isFriendLabel.setOutputMarkupPlaceholderTag(false);
                    }
                };
                //var isFriendLabel = new Label("isFriend",isFriendModel);
                registerFriendLink.add(isFriendLabel);
                listItem.add(registerFriendLink);

                var isBlockedModel = Model.of("");
                if (userStatus.isBlocked() == false){
                    isBlockedModel = Model.of("ブロックする");
                }else if(userStatus.isBlocked() == true){
                    isBlockedModel = Model.of("");
                }
                var blockUserLink = new Link<>("blockUser"){
                    @Override
                    public void onClick(){
                        manageUserPageService.blockFriend(userStatus.getUserId());
                    }
                };
                var isBlockedLabel = new Label("isBlocked",isBlockedModel);
                blockUserLink.add(isBlockedLabel);
                listItem.add(blockUserLink);

                /**
                AjaxButton friendAjaxButton = new AjaxButton("friendAjaxButton"){
                  @Override
                  protected void onSubmit(AjaxRequestTarget target){
                      super.onSubmit(target);
                      target.add();

                  }
                };*/
            }
        };
        add(userStatusListView);
    }
}
