package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.bean.ThreadInformation;
import com.chatsystem.chatsystemproject.service.ITopPageService;
import com.chatsystem.chatsystemproject.session.MySession;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
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

        //スレッド作成の際のスレッド名を取得
        var createThreadNameModel = Model.of("");

        //フォームの匿名クラス
        // スレッド作成ボタンが押された際の処理
        var createThreadForm = new Form<>("createThreadForm");
        add(createThreadForm);

        createThreadForm.add(new Button("createThreadButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                topPageService.createThread(createThreadNameModel.getObject());
                setResponsePage(new ThreadPage(Model.of(topPageService.getThreadInformation(MySession.get().getMyUserId()))));
            }
        });

        //スレッド名を入力するテキストフィールド
        createThreadForm.add(new TextField<>("createThreadName",createThreadNameModel));

        //サービスからスレッドインフォメーションの情報をもらう
        var myThreadsListModel = Model.ofList(topPageService.getMyThreadList(MySession.get().getMyUserId()));

        //自身が作成したスレッド一覧を表示
        var myThreadListView = new ListView<>("MyThreadListView", myThreadsListModel) {
            @Override
            protected void populateItem(ListItem<ThreadInformation> listItem) {
                var itemModel = listItem.getModel();
                var threadInformation = itemModel.getObject();

                //スレッド名（リンク）をクリックしたらスレッドページへ飛ぶ
                listItem.add(new Link<>("toThreadPage") {
                    @Override
                    public void onClick() {
                        setResponsePage(new ThreadPage(itemModel));
                    }
                }.add(new Label("MyThreadName", Model.of(threadInformation.getThreadName())))); //自身が作成したスレッド名を表示

                //自身が作成したスレッドの立ち上げ時間を表示
                listItem.add(new Label("createdTime", Model.of(threadInformation.getCreateTime())));
            }
        };
        add(myThreadListView);

    }
}
