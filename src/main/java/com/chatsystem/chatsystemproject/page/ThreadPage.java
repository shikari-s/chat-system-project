package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.GlobalMessageInformation;
import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.service.IThreadPageService;
import org.apache.wicket.Application;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("Thread")
public class ThreadPage extends WebPage {
    @SpringBean
    private IThreadPageService threadPageService;

    public ThreadPage(IModel<ThreadInformation> itemModel){

        var globalMessageListContainer = new WebMarkupContainer("GlobalMessageListContainer"){
            @Override
            protected void onInitialize() {
                super.onInitialize();
                setOutputMarkupId(true);
            }
        };
        add(globalMessageListContainer);

        //メッセージのリアルタイム表示システム
        var globalMessageInformationListModel = Model.ofList(threadPageService.getSendMessageInformation(itemModel.getObject().getThreadId()));

        add(new Label("ThreadName", itemModel.getObject().getThreadName()));

        globalMessageListContainer.add(new ListView<GlobalMessageInformation>("GlobalMessageListView",globalMessageInformationListModel){

            @Override
            protected void onInitialize() {
                super.onInitialize();

                setOutputMarkupId(true);
            }

            @Override
            protected void populateItem(ListItem<GlobalMessageInformation> listItem) {
                var toManageUserPageLink = new Link<>("ManageUserPageLink"){
                    @Override
                    public void onClick(){
                        /**
                         * ユーザー名の隣のManageUserPageのリンクを押すとユーザー名が送られる
                         */
                        //setResponsePage(new ManageThreadPage(senderUserNameModel));
                    }
                };
                listItem.add(toManageUserPageLink.add(new Label("SenderUserName",listItem.getModelObject().getSenderUserName())));
                listItem.add(new Label("Message",listItem.getModelObject().getMessage()));
                listItem.add(new Label("PostTime",listItem.getModelObject().getPostTime()));
            }
        });

        //メッセージ送信用フォームとメッセージ送信のシステム
        var sendMessageModel = Model.of("");

        var sendMessageForm = new Form<>("SendMessageForm"){
            @Override
            protected void onSubmit(){
                threadPageService.sendMessage(sendMessageModel.getObject(), itemModel.getObject().getThreadId());
                setResponsePage(new ThreadPage(itemModel));
            }
        };
        add(sendMessageForm);
        sendMessageForm.add(new TextField<>("SendMessage",sendMessageModel));
    }
}