package com.icustom.metrics.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * ClassName: MyHandler
 * Description:
 *
 * @author aGuang
 *         Date 2016/11/24
 */
public class MyHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(new String(message.asBytes()));
        TextMessage textMessage = new TextMessage("hello server");
        session.sendMessage(textMessage);
    }
}
