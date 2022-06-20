package com.malevich.telegrambot.services;

import com.malevich.telegrambot.messagesender.MessageSender;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Service
public class SendMessageService {

    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void testStyle(Message message) {
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

    public void keyboardTest (Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow rowButtons = new KeyboardRow();
        KeyboardRow rowContact = new KeyboardRow();
        KeyboardRow rowLocation = new KeyboardRow();


        rowButtons.add("Button1");
        rowButtons.add("Button2");
        rowButtons.add("Button3");

        rowContact.add(KeyboardButton.builder().text("Phone Number ")
                .requestContact(true)
                .build());

        rowLocation.add(KeyboardButton.builder()
                .requestLocation(true)
                .text("Location ")
                .build());
        keyboardRows.add(rowButtons);
        keyboardRows.add(rowContact);
        keyboardRows.add(rowLocation);

        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Test");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(markup);
        messageSender.sendMessage(sendMessage);
    }
}
