package ru.notif.bot.platforms.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TgBot extends TelegramLongPollingBot{
    final private String BOT_TOKEN = System.getenv("BOT_TOKEN");
    final private String BOT_NAME = System.getenv("BOT_NAME");

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }


}
