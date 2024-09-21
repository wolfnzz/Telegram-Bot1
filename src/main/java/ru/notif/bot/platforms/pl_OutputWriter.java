package ru.notif.bot.platforms;

import ru.notif.bot.logic.OutputWriter;
import ru.notif.bot.logic.Responce;

public class pl_OutputWriter implements OutputWriter {

    @Override
    public void write(Responce response) {

        System.out.println("Ответ бота: " + response.getMessage());
    }
}