package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.session.MySession;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

//@AuthorizeInstantiation(Roles.USER)
@WicketHomePage
@MountPath("Top")
public class TopPage extends WebPage {
    public TopPage(){
        add(new Label("UserNameLabel", MySession.get().getMyUserName()));
        add(new BookmarkablePageLink<>("CreateAccountPageLink",CreateAccountPage.class));
        add(new BookmarkablePageLink<>("EditAccountPageLink",EditAccountPage.class));
        add(new BookmarkablePageLink<>("ManageThreadPageLink", ManageThreadPage.class));
        add(new BookmarkablePageLink<>("UserPageLink",UserPage.class));
        add(new BookmarkablePageLink<>("PersonalMessagePageLink",PersonalMessagePage.class));
    }
}
