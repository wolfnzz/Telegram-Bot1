package ru.notif.bot.logic;

public class logic_RequestHanger implements RequestHanger {

    @Override
    public void handle(Request request, OutputWriter writer) {
        writer.write(new Responce(request.getMessage()));
    }
}
