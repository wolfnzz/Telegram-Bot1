package ru.notif.bot.platforms.telegrambot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.notif.bot.logic.OutputWriter;
import ru.notif.bot.logic.Responce;

public class TelegramOutputWriter implements OutputWriter {
    private final TelegramBot bot;
    private final String chatId;

    public TelegramOutputWriter(TelegramBot bot, long chatId) {
        this.bot = bot;
        this.chatId = String.valueOf(chatId);
    }

    @Override
    public void write(Responce responce) {
        try {
            bot.execute(
                    SendMessage.builder()
                            .chatId(String.valueOf(chatId))
                            .text(responce.getMessage())
                            .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
