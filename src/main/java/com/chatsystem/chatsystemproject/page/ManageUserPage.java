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

    public ManageUserPage(String userName){

        var userStatusListModel = Model.ofList(manageUserPageService.getUserListTest(userName));
        var userStatusListView = new ListView<>("userStatus",userStatusListModel){
            @Override
            protected void populateItem(ListItem<UserStatus> listItem){
                var itemModel = listItem.getModel();
                UserStatus userStatus = itemModel.getObject();

                var userNameModel = Model.of(userStatus.getUserName());
                var userNameLabel = new Label("userName",userNameModel);
                listItem.add(userNameLabel);

                //友達登録機能に用いるラベル
                var isFriendModel = Model.of("友達登録");
                var isFriendLabel = new Label("isFriend",isFriendModel);
                isFriendLabel.setOutputMarkupId(true);
                //登録済みなら表示しない
                if (userStatus.isRegisteredFriend() == true){
                    isFriendLabel.setOutputMarkupPlaceholderTag(true);
                    isFriendLabel.setVisible(false);
                }

                //登録解除機能に用いるラベル
                var removeRegisterModel = Model.of("登録解除");
                var removeRegisterLabel = new Label("removeRegister",removeRegisterModel);
                removeRegisterLabel.setOutputMarkupId(true);
                //友達登録をまだしていないなら表示しない
                if (userStatus.isRegisteredFriend() == false){
                    removeRegisterLabel.setOutputMarkupPlaceholderTag(true);
                    removeRegisterLabel.setVisible(false);
                }

                //ブロック機能に用いるラベル
                var isBlockedModel = Model.of("ブロックする");
                var isBlockedLabel = new Label("isBlocked",isBlockedModel);
                isBlockedLabel.setOutputMarkupId(true);
                //ブロック中なら、ブロックするリンク(ラベル)を表示しない
                if (userStatus.isBlocked() == true){
                    //表示を切り替える前にPlaceholderTagでリンクが存在していた位置を記憶させる
                    isBlockedLabel.setOutputMarkupPlaceholderTag(true);
                    isBlockedLabel.setVisible(false);
                }

                //ブロック解除の機能に用いるラベル
                var unBlockedModel = Model.of("ブロック解除");
                var removeBlockedLabel = new Label("removeBlocked",unBlockedModel);
                removeBlockedLabel.setOutputMarkupId(true);
                //ブロックしていないなら、ブロック解除するリンク(ラベル)を表示しない
                if(userStatus.isBlocked() == false){
                    removeBlockedLabel.setOutputMarkupPlaceholderTag(true);
                    removeBlockedLabel.setVisible(false);
                }

                //友達登録を行うリンク
                var registerFriendLink = new AjaxLink<>("registerFriend"){
                    @Override
                    public void onClick(AjaxRequestTarget target){
                        //友達登録のための機能
                        manageUserPageService.registerFriend(userStatus.getUserId());
                        //isFriendLabelが見えなくなるように画面の一部を更新
                        target.add(isFriendLabel.setOutputMarkupPlaceholderTag(true),isFriendLabel.setVisible(false),removeRegisterLabel.setVisible(true));

                    }
                };
                registerFriendLink.add(isFriendLabel);
                listItem.add(registerFriendLink);

                //友達登録の解除を行うリンク
                var removeRegisterLink = new AjaxLink<>("removeRegisterUser"){
                    @Override
                    public void onClick(AjaxRequestTarget target){
                        //登録解除機能
                        manageUserPageService.removeRegister(userStatus.getUserId());
                        //removeRegisterLabelが見えなくなるように画面の一部を更新
                        target.add(removeRegisterLabel.setOutputMarkupPlaceholderTag(true),removeRegisterLabel.setVisible(false),isFriendLabel.setVisible(true));
                    }
                };
                removeRegisterLink.add(removeRegisterLabel);
                listItem.add(removeRegisterLink);

                //ブロックを行うリンク
                var blockUserLink = new AjaxLink<>("blockUser"){
                    @Override
                    public void onClick(AjaxRequestTarget target){
                        //ブロックの機能
                        manageUserPageService.blockFriend(userStatus.getUserId());
                        //isBlockLabelが見えなくなるように画面の一部を更新
                        target.add(isBlockedLabel.setOutputMarkupPlaceholderTag(true),isBlockedLabel.setVisible(false),removeBlockedLabel.setVisible(true));
                    }
                };
                blockUserLink.add(isBlockedLabel);
                listItem.add(blockUserLink);

                //ブロック解除を行うリンク
                var removeBlockUserLink = new AjaxLink<>("removeBlockUser"){
                    @Override
                    public void onClick(AjaxRequestTarget target){
                        //ブロック解除の機能
                        manageUserPageService.removeBlock(userStatus.getUserId());
                        //removeBlockLabelが見えなくなるように画面の一部を更新
                        target.add(removeBlockedLabel.setOutputMarkupPlaceholderTag(true),removeBlockedLabel.setVisible(false),isBlockedLabel.setVisible(true));

                    }
                };
                removeBlockUserLink.add(removeBlockedLabel);
                listItem.add(removeBlockUserLink);

            }
        };
        add(userStatusListView);
    }
}
