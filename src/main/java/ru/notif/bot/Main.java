package ru.notif.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.notif.bot.logic.EchoRequestHandler;
import ru.notif.bot.platforms.console.ConsoleBot;
import ru.notif.bot.platforms.console.ConsoleInputReader;
import ru.notif.bot.platforms.console.ConsoleOutputWriter;
import ru.notif.bot.platforms.telegrambot.TelegramBot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws TelegramApiException {

        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        EchoRequestHandler requestHandler = new EchoRequestHandler();

        // Создание и запуск консольного бота
        ConsoleBot consoleBot = new ConsoleBot(inputReader, requestHandler, outputWriter);
        Thread consoleBotThread = new Thread(consoleBot::startBot);
        consoleBotThread.start();

        // Запуск Telegram-бота
        Properties properties = getProperties();

        String token = properties.getProperty("BOT_TOKEN");
        String name = properties.getProperty("BOT_NAME");

        TelegramBot telegramBot = new TelegramBot(token, name, requestHandler);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(telegramBot);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/bot.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}