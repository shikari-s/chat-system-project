//package com.chatsystem.chatsystemproject;
//
//import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
//import org.apache.wicket.protocol.http.WicketFilter;
//import org.apache.wicket.protocol.ws.javax.JavaxWebSocketFilter;
//import org.apache.wicket.spring.SpringWebApplicationFactory;
//import org.springframework.boot.web.servlet.ServletContextInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.FilterRegistration;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.SessionTrackingMode;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Configuration
//public class WebInitializer implements ServletContextInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        FilterRegistration filter = servletContext.addFilter("wicket-filter", JavaxWebSocketFilter.class);
//        filter.setInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.getName());
//        filter.setInitParameter("applicationBean", "chatSystemProjectApplication");
//        filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
//        filter.addMappingForUrlPatterns(null, false, "/*");
//        filter.setInitParameter("configuration", "development");
//    }
//    @Bean
//    public ServletContextInitializer servletContextInitializer() {
//        return new ServletContextInitializer() {
//            @Override
//            public void onStartup(ServletContext ctx) throws ServletException {
//                ctx.setSessionTrackingModes(Stream.of(SessionTrackingMode.COOKIE).collect(Collectors.toSet()));
//            }
//        };
//    }
//}
