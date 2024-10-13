package ru.notif.bot.platforms.console;

import ru.notif.bot.logic.OutputWriter;
import ru.notif.bot.logic.RequestHandler;
import ru.notif.bot.platforms.telegrambot.Bot;

public class ConsoleBot implements Bot {

    private final InputReader inputReader;
    private final RequestHandler requestHandler;
    private final OutputWriter outputWriter;

    public ConsoleBot(InputReader inputReader, RequestHandler requestHandler, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.requestHandler = requestHandler;
        this.outputWriter = outputWriter;
    }

    @Override
    public void startBot() {
        while (true) {
            var request = inputReader.read(); // Чтение запроса от пользователя
            requestHandler.handle(request, outputWriter); // Обработка запроса и вывод ответа
        }
    }
}