package ru.notif.bot.platforms.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.notif.bot.logic.Request;
import ru.notif.bot.logic.RequestHandler;

public class TelegramBot extends TelegramLongPollingBot {

    private final String token;
    private final String name;
    private final RequestHandler requestHandler;

    // Конструктор, принимающий токен и имя бота
    public TelegramBot(String token, String name, RequestHandler requestHandler) {
        //super(token);
        this.token = token;
        this.name = name;
        this.requestHandler = requestHandler;
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            long chatID = update.getMessage().getChatId();

            Request request = new Request(message);
            TelegramOutputWriter writer = new TelegramOutputWriter(this, chatID);
            requestHandler.handle(request, writer);
        }
    }

}

