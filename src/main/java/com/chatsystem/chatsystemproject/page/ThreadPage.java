package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.service.IThreadPageService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.List;

@AuthorizeInstantiation(Roles.USER)
@MountPath("Thread")
public class ThreadPage extends WebPage {

    @SpringBean
    private IThreadPageService threadPageService;

    public ThreadPage(IModel<ThreadInformation> itemModel){
        var globalMessageInformationListModel = Model.ofList(threadPageService.getPostedMessageInformation(itemModel.getObject().getThreadId()));
        //ここにThread名表示記述
        var globalMessageListView = new ListView<GlobalMessageInformation>("GlobalMessageListView",globalMessageInformationListModel){

            @Override
            protected void populateItem(ListItem<GlobalMessageInformation> listItem) {
                var senderUserNameModel = listItem.getModelObject().getSenderUserName();
                var toManageUserPageLink = new Link<>("ManageUserPageLink"){
                    @Override
                    public void onClick(){
                        /**
                         * ユーザー名の隣のManageUserPageのリンクを押すとユーザー名が送られる
                         */
                        //setResponsePage(new ManageThreadPage(senderUserNameModel));
                    }
                };
                listItem.add(new Label("SenderUserName",listItem.getModelObject().getSenderUserName()));
                listItem.add(new Label("Message",listItem.getModelObject().getMessage()));
                listItem.add(new Label("PostTime",listItem.getModelObject().getPostTime()));
                listItem.add(toManageUserPageLink);
            }
        };
        add(globalMessageListView);

    }
}