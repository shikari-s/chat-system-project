package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.PersonalMessageInformation;
import com.chatsystem.chatsystemproject.bean.User;
import com.chatsystem.chatsystemproject.service.IPersonalMessagePageService;
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
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("DirectMessage")
public class PersonalMessagePage extends WebPage {

    @SpringBean
    private IPersonalMessagePageService personalMessagePageService;

    public PersonalMessagePage(IModel<User> itemModel){
        /**
         * 今回仮に引数なしの固定IDを利用しているが、本来の引数はIModel<PersonalMessageInformation> itemModelを想定
         */

        //メッセージのリアルタイム表示システム
        var personalMessageInformationListModel = Model.ofList(personalMessagePageService.getSendMessageInformation(itemModel.getObject().getId()));

        add(new Label("ReceiverUserName", itemModel.getObject().getName()));

        add(new ListView<PersonalMessageInformation>("PersonalMessageListView",personalMessageInformationListModel){

            @Override
            protected void populateItem(ListItem<PersonalMessageInformation> listItem) {
                var deleteMessageForm = new Form<>("DeleteMessage");
                listItem.add(new Label("SenderUserName",listItem.getModelObject().getSenderUserName()));
                listItem.add(new Label("Message",listItem.getModelObject().getMessage()));
                listItem.add(new Label("PostTime",listItem.getModelObject().getPostTime()));
                listItem.add(deleteMessageForm);
                deleteMessageForm.add(new Button("DeleteMessageButton"){
                    @Override
                    public void onSubmit(){
                        super.onSubmit();
                        personalMessagePageService.deleteMessage(listItem.getModelObject().getPostTime(), itemModel.getObject().getId());
                        setResponsePage(new PersonalMessagePage(itemModel));
                    }
                });
            }
        });

        //メッセージ送信用フォームとメッセージ送信のシステム
        var sendMessageModel = Model.of("");

        var sendMessageForm = new Form<>("SendMessageForm"){
            @Override
            protected void onSubmit(){
                personalMessagePageService.sendMessage(sendMessageModel.getObject(), itemModel.getObject().getId());
                setResponsePage(new PersonalMessagePage(itemModel));
            }
        };
        add(sendMessageForm);
        sendMessageForm.add(new TextField<>("SendMessage",sendMessageModel));

        var toTopPageLink = new Link<>("TopPageLink"){
            @Override
            public void onClick(){
                setResponsePage(new TopPage());
            }
        };
        add(toTopPageLink);
    }


}
