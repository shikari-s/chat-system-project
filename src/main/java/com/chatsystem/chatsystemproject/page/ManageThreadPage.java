package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.Thread;
import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.service.IManageThreadPageService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.time.LocalDateTime;

@AuthorizeInstantiation(Roles.USER)
@MountPath("ManageThreadPage")
public class ManageThreadPage extends WebPage {

    @SpringBean
    private IManageThreadPageService manageThreadPageService;

    public ManageThreadPage(){
        var threadModel = Model.ofList(manageThreadPageService.selectBy());

        var threadLV = new ListView<>("thread",threadModel){
            @Override
            protected void populateItem(ListItem<ThreadInformation> listItem){
                var itemModel = listItem.getModel();
                ThreadInformation threadInformation = itemModel.getObject();

                var threadNameModel = Model.of(threadInformation.getThreadName());
                var toThreadPageLink = new Link<>("toThreadPage"){
                  @Override
                  public void onClick(){
                      setResponsePage(new ThreadPage(itemModel));
                  }
                };
                var threadNameLabel = new Label("threadName",threadNameModel);
                toThreadPageLink.add(threadNameLabel);
                listItem.add(toThreadPageLink);

                var creatorUserNameModel = Model.of(threadInformation.getCreatorUserName());
                var creatorUserNameLabel = new Label("creatorUserName",creatorUserNameModel);
                listItem.add(creatorUserNameLabel);

                var createTimeModel = Model.of(threadInformation.getCreateTime());
                var createTimeLabel = new Label("createTime",createTimeModel);
                listItem.add(createTimeLabel);
            }
        };
        add(threadLV);
    }

}
