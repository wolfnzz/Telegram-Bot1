package ru.notif.bot.platforms.console;

import java.util.Scanner;
import ru.notif.bot.logic.Request;

public class ConsoleInputReader implements InputReader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Request read() {
        System.out.println("Введите сообщение: ");
        String message = scanner.nextLine();
        return new Request(message);
    }
}
