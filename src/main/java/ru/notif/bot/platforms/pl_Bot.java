package ru.notif.bot.platforms;

import ru.notif.bot.logic.OutputWriter;
import ru.notif.bot.logic.RequestHanger;

public class pl_Bot implements Bot {

    private final InputReader inputReader;
    private final RequestHanger requestHandler;
    private final OutputWriter outputWriter;

    public pl_Bot(InputReader inputReader, RequestHanger requestHandler, OutputWriter outputWriter) {
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