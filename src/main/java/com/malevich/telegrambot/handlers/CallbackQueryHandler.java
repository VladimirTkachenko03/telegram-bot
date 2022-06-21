package com.malevich.telegrambot.handlers;

import com.malevich.telegrambot.messagesender.MessageSender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;

@Component
public class CallbackQueryHandler implements Handler<CallbackQuery> {

    private MessageSender messageSender;

    public CallbackQueryHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(CallbackQuery callbackQuery) {
        if (callbackQuery.getData().equals("next_song")) {
            String songText = "Ой що ж то за шум учинився?\n" +
                    "Що Комарик до повстанців зголосився.\n" +
                    "\n" +
                    "Зголосився комар до повстанців.\n" +
                    "Щоби бити москалів-голодранців.\n" +
                    "\n" +
                    "Щоби бити москалів, ще й німоту –\n" +
                    "Щоб не було на Вкраїні той гидоти.\n" +
                    "\n" +
                    "Примостився наш комар на дубочку.\n" +
                    "Прикріпив скоростріл на листочку.\n" +
                    "\n" +
                    "Та зірвалася нараз шура-бура.\n" +
                    "Вона того комарика з дуба здула.\n" +
                    "\n" +
                    "Як упав же наш комар на помості –\n" +
                    "Поламав москалю ребра й кості.\n" +
                    "\n" +
                    "Поховали москаля не по людськи –\n" +
                    "Видно руки, видно ноги, видно пупці.\n" +
                    "\n" +
                    "Поховали москаля, як собаку –\n" +
                    "Видно руки, видно ноги, видно... спину.\n" +
                    "\n" +
                    "Поховали москаля край дороги –\n" +
                    "Видно руки, видно ноги, видно роги.\n" +
                    "\n" +
                    "Поховали москаля у куфайці –\n" +
                    "Видно руки, видно ноги, видно... пальці.\n" +
                    "\n" +
                    "Поховали москаля, мов буржуя –\n" +
                    "Видно руки, видно ноги, видно... паспорт!";
            Integer messageId = callbackQuery.getMessage().getMessageId();
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
            editMessageText.setMessageId(messageId);
            editMessageText.setText(songText);
            editMessageText.setReplyMarkup(
                    InlineKeyboardMarkup.builder()
                            .keyboardRow(Collections.singletonList(InlineKeyboardButton.builder()
                                    .text("Link to download songs")
                                    .url("https://drive.google.com/drive/folders/1AIqirnQdq_UoKwmWEvbfRbavBoUQcVe2")
                                    .build()
                            )).build());

            messageSender.sendEditMessage(editMessageText);
        }
    }
}
