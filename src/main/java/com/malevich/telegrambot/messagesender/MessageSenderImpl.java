package com.malevich.telegrambot.messagesender;

import com.malevich.telegrambot.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private Bot bot;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendEditMessage(EditMessageText editMessageText) {
        try {
            bot.execute(editMessageText);
        }  catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setBot(Bot bot) {
        this.bot = bot;
    }
}
