package com.chatsystem.chatsystemproject.page;

import com.chatsystem.chatsystemproject.service.ISignInPageService;
import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@WicketSignInPage
@MountPath("SignIn")
public class SignInPage extends WebPage {

    @SpringBean
    private ISignInPageService signInPageService;

    public SignInPage(){
        var signInForm = new Form("SignInForm");
        add(signInForm);
        var userNameModel = Model.of("");
        var passwordModel = Model.of("");
        signInForm.add(new TextField<String>("UserNameField",userNameModel));
        signInForm.add(new PasswordTextField("PasswordField",passwordModel));
        signInForm.add(new Button("SignInButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                if(signInPageService.authenticate(userNameModel.getObject(),passwordModel.getObject())){
                    setResponsePage(new TopPage());
                }
            }
        });
    }
}
