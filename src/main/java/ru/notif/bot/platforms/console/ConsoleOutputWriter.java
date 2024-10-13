package ru.notif.bot.platforms.console;

import ru.notif.bot.logic.OutputWriter;
import ru.notif.bot.logic.Responce;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void write(Responce response) {

        System.out.println("Ответ бота: " + response.getMessage());
    }
}