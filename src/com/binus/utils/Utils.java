package com.binus.utils;

import java.util.Scanner;

public class Utils {

    public final String APP_NAME = "init app";
    private static final Utils utils = new Utils();
    private final Scanner scanner = new Scanner(System.in);

    // empty constructor for singleton
    private Utils() {}

    public static Utils getInstance() { return utils; }

    public void print(String args) { System.out.print(args); }

    public void breakLine() { System.out.print("\n"); }

    public String scanString() { return scanner.nextLine(); }

    public Integer scanInt() { return scanner.nextInt(); }

    public String intToString(Integer args){ return Integer.toString(args); }

    public Integer stringToInt(String args){
        int value = 0;

        try {
            value = Integer.parseInt(args);
        } catch (Exception e) {
            print(String.format("Invalid argument given (%s), setting the value into 0\n", args));
        }

        return value;
    }

}
