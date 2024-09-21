package ru.notif.bot;

import ru.notif.bot.logic.logic_RequestHanger;
import ru.notif.bot.platforms.pl_Bot;
import ru.notif.bot.platforms.pl_InputReader;
import ru.notif.bot.platforms.pl_OutputWriter;

public class Main {
    public static void main(String[] args) {
        pl_InputReader inputReader = new pl_InputReader();
        pl_OutputWriter outputWriter = new pl_OutputWriter();
        logic_RequestHanger requestHandler = new logic_RequestHanger();

        // Создание и запуск консольного бота
        pl_Bot bot = new pl_Bot(inputReader, requestHandler, outputWriter);
        bot.startBot();

    }
}