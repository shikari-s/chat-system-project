package com.chatsystem.chatsystemproject;

import com.chatsystem.chatsystemproject.session.MySession;
import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.protocol.ws.javax.WicketServerEndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

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

	// オーバーライドが必要だが、コードの実装は特に不要。
	//WebSocketConfigureのメソッド
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

	}
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	@Bean
	public WicketServerEndpointConfig myWicketServerEndpointConfig() {
		return new WicketServerEndpointConfig();
	}
}
