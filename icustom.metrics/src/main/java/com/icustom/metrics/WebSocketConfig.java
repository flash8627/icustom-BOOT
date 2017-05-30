package com.icustom.metrics;

import com.icustom.metrics.handler.MyHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * ClassName: WebSocketConfig
 * Description:
 *
 * @author aGuang
 *         Date 2016/11/24
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(), "/hello");
    }

    @Bean
    public MyHandler myHandler() {
        return new MyHandler();
    }
}
