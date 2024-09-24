package ru.notif.bot;

import ru.notif.bot.logic.echo_RequestHanger;
import ru.notif.bot.platforms.console.Console_Bot;
import ru.notif.bot.platforms.console.Console_InputReader;
import ru.notif.bot.platforms.console.Console_OutputWriter;

public class Main {
    public static void main(String[] args) {
        Console_InputReader inputReader = new Console_InputReader();
        Console_OutputWriter outputWriter = new Console_OutputWriter();
        echo_RequestHanger requestHandler = new echo_RequestHanger();

        // Создание и запуск консольного бота
        Console_Bot bot = new Console_Bot(inputReader, requestHandler, outputWriter);
        bot.startBot();

    }
}