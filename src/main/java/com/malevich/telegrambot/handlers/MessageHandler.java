package com.malevich.telegrambot.handlers;

import com.malevich.telegrambot.messagesender.MessageSender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MessageHandler implements Handler<Message> {

    private final MessageSender messageSender;

    public MessageHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(Message message) {
        if(message.hasText()) {
            if(message.getText().equals("/start")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setText("Hello! Write command /get_song to see songs.");
                messageSender.sendMessage(sendMessage);
            }
        }

        if(message.hasText()) {
            if(message.getText().equals("/get_song")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setText("Ой у лузі червона калина похилилася,\n" +
                        "Чогось наша славна Україна зажурилася,\n" +
                        "А ми тую червону калину підіймемо,\n" +
                        "А ми нашу славну Україну, гей, гей, розвеселимо!\n" +
                        "\n" +
                        "Марширують наші добровольці у кривавий тан,\n" +
                        "Визволяти братів-українців з московських кайдан.\n" +
                        "А ми тії московські кайдани розірвемо,\n" +
                        "А ми нашу славну Україну, гей, гей, розвеселимо!*\n" +
                        "\n" +
                        "Гей, у полі ярої пшенички золотистий лан,\n" +
                        "Розпочали Січовії Стрільці з москалями тан.**\n" +
                        "А ми тую ярую пшеничку ізберемо,\n" +
                        "А ми нашу славну Україну, гей, гей, розвеселимо!\n" +
                        "\n" +
                        "Як повіє буйнесенький вітер з широких степів,\n" +
                        "То прославить по всій Україні Січових Стрільців.\n" +
                        "А ми тую стрілецькую славу збережемо,\n" +
                        "А ми нашу славну Україну, гей, гей, розвеселимо");

                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                keyboard.add(
                        Collections.singletonList(
                                InlineKeyboardButton.builder()
                                        .text("New Song")
                                        .callbackData("next_song")
                                        .build()));
                inlineKeyboardMarkup.setKeyboard(keyboard);
                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                messageSender.sendMessage(sendMessage);
            }
        }
    }
}
