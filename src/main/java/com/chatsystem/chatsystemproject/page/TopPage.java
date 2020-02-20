package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.service.ITopPageService;
import com.chatsystem.chatsystemproject.session.MySession;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@WicketHomePage
@MountPath("Top")
public class TopPage extends WebPage {

    @SpringBean
    private ITopPageService topPageService;

    public TopPage(){
        add(new Label("UserNameLabel", MySession.get().getMyUserName()));
        add(new BookmarkablePageLink<>("CreateAccountPageLink",CreateAccountPage.class));
        add(new BookmarkablePageLink<>("EditAccountPageLink",EditAccountPage.class));
        add(new BookmarkablePageLink<>("ManageThreadPageLink", ManageThreadPage.class));
        add(new BookmarkablePageLink<>("UserPageLink",UserPage.class));
        add(new BookmarkablePageLink<>("PersonalMessagePageLink",PersonalMessagePage.class));

        add(new Label("createThreadLabel","スレッドを作成"));

        //スレッド作成の際のスレッド名を取得
        var createThreadModel = Model.of("");

        //フォームの匿名クラス
        // スレッド作成ボタンが押された際の処理
        var createThreadForm = new Form<>("createThread") {
          @Override
          protected void onSubmit() {
              var createThreadName = createThreadModel.getObject();
              var msg = "送信データ:" + createThreadName;
              System.out.println(msg);
              topPageService.createThread(createThreadName);
              setResponsePage(ThreadPage.class);
          }
        };
        add(createThreadForm);

        //スレッド名を入力するテキストフィールド
        createThreadForm.add(new TextField<>("createThreadName",createThreadModel));

        add(new Label("createdThread","作成したスレッド一覧"));

    }
}
