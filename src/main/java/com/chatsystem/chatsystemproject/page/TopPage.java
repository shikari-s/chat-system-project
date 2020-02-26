package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;
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
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
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

       // add(new Label("createThreadLabel","スレッドを作成"));

        //スレッド作成の際のスレッド名を取得
        var createThreadModel = Model.of("");

        //フォームの匿名クラス
        // スレッド作成ボタンが押された際の処理
        var createThreadForm = new Form<>("createThread") {
          @Override
          protected void onSubmit() {
              var createThreadName = createThreadModel.getObject();
              topPageService.createThread(createThreadName);
              setResponsePage(new ThreadPage(Model.of(topPageService.getThreadInformation(MySession.get().getMyUserId()))));
          }
        };
        add(createThreadForm);

        //スレッド名を入力するテキストフィールド
        createThreadForm.add(new TextField<>("createThreadName",createThreadModel));

       // add(new Label("createdThread","作成したスレッド一覧"));

        //サービスからスレッドインフォメーションの情報をもらう
        var myCreatedThreadsListModel = Model.ofList(topPageService.myCreatedThreadList(MySession.get().getMyUserId()));

        var myCreatedThreadLV = new ListView<>("myCreatedThreads", myCreatedThreadsListModel) {
            @Override
            protected void populateItem(ListItem<ThreadInformation> listItem) {
                var itemModel = listItem.getModel();
                var threadInformation = itemModel.getObject();

                //自身が作成したスレッド名を表示
                var myCreatedThreadNameModel = Model.of(threadInformation.getThreadName());

                //スレッド名をクリックしたらスレッドページへ飛ぶ
                var toThreadPageLink = new Link<>("toThreadPage") {
                    @Override
                    public void onClick() {
                        setResponsePage(new ThreadPage(itemModel));
                    }
                };
                var myCreatedThreadNameLabel = new Label("myCreatedThreadName", myCreatedThreadNameModel);
                toThreadPageLink.add(myCreatedThreadNameLabel);
                listItem.add(toThreadPageLink);

                //自身が作成したスレッドの立ち上げ時間を表示
                var createdTimeModel = Model.of(threadInformation.getCreateTime());
                var createdTimeLabel = new Label("createdTime",createdTimeModel);
                listItem.add(createdTimeLabel);

            }
        };
        add(myCreatedThreadLV);

    }
}
