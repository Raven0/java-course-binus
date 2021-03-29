package com.binus.utils;

import java.util.Scanner;

public class Utils {

    private final Scanner scanner = new Scanner(System.in);

    protected static void print(String args) { System.out.println(args); }

    protected String scanString(String msg) {
        String value;

        try {
            print(msg);
            value = scanner.nextLine();
        } catch (Exception x) {
            print(x.getMessage());
            value = null;
        }

        return value;
    }

    protected Integer scanInt(String msg) {
        int value;

        try {
            print(msg);
            value = Integer.parseInt(scanner.nextLine());
        } catch (Exception x) {
            print(x.getMessage());
            value = 0;
        }

        return value;
    }

}
