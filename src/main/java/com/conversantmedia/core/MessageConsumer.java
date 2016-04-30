package com.conversantmedia.core;

import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    public void handleMessage(String message) {
        System.out.println("PAYLOAD: " + message);
    }
}
