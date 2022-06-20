package com.malevich.telegrambot.services;

import com.malevich.telegrambot.messagesender.MessageSender;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class SendMessageService {

    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void test(Message message) {
        SendMessage message1 = SendMessage.builder()
                .text("<b> Bold </b>" +
                        "<i> italic </i>" +
                         "<code> mono </code>" +
                        "<a href=\"google.com\"> Google </a>")
                .parseMode("HTML")
                .chatId(String.valueOf(message.getChatId()) )
                .build();

        messageSender.sendMessage(message1);
    }
}
