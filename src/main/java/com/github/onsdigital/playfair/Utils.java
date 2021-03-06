package com.github.onsdigital.playfair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thomasridd on 07/12/2015.
 */
public class Utils {
    public static List<String> commandArguments(String command) {

        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find())
            list.add(m.group(1).replace("\"", ""));
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while(!command.equalsIgnoreCase("exit")) {
            command = scanner.nextLine();
            List<String> strings = Utils.commandArguments(command);

            String out = "";
            for (String s : strings) {
                out = out + "[" + s + "] ";
            }
            System.out.println(out);
        }
    }
}
