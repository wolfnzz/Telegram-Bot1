package ru.notif.bot.logic;

public class EchoRequestHandler implements RequestHandler {

    @Override
    public void handle(Request request, OutputWriter writer) {

        writer.write(new Responce(request.getMessage()));
    }
}
