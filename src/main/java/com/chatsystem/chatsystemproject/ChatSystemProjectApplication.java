package com.chatsystem.chatsystemproject;

import com.chatsystem.chatsystemproject.session.MySession;
import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@SpringBootApplication
public class ChatSystemProjectApplication extends WicketBootSecuredWebApplication implements WebSocketConfigurer {

//	@Autowired
//	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(ChatSystemProjectApplication.class, args);
	}

	// 認証OK/NGを判定するセッションクラスを返値にする
	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return MySession.class;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// ここなにするん？
	}

}
