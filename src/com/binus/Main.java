package com.binus;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat formatter = new DecimalFormat("###,###,###.00");

    public static void main(String[] args) {
        String vType, tIn, tOut;

        //testing();

        do {
            vType = scanString("Jenis Kendaraan [Motor/Mobil]:");
        } while (!vType.equals("Motor") && !vType.equals("Mobil"));

        do {
            tIn = scanString("IN [hh.mm]:");
        } while (isValidTime(tIn));

        do {
            tOut = scanString("OUT [hh.mm]:");
        } while (isValidTime(tOut));

        calculateParkFee(
                vType,
                countHours(tIn, tOut)
        );

    }

    @SuppressWarnings("IntegerMultiplicationImplicitCastToLong")
    private static void calculateParkFee(String type, int hours) {
        switch (type) {
            case "Motor":
                if (hours >= 2) {
                    print("Rp " + formatter.format((3000 + (4000 * (hours - 1) ))));
                } else {
                    print("Rp 3,000.00");
                }
                break;
            case "Mobil":
                if (hours >= 2) {
                    print("Rp " + formatter.format((5000 + (6000 * (hours - 1) ))));
                } else {
                    print("Rp 5,000.00");
                }
                break;
        }
    }

    private static int countHours(String tStart, String tEnd) {
        return Integer.parseInt(tEnd.substring(0, 2)) - Integer.parseInt(tStart.substring(0, 2));
    }

    private static boolean isValidTime(String time) {
        String regex = "([01]?[0-9]|2[0-3]).[0-5][0-9]";
        Pattern p = Pattern.compile(regex);

        if (time == null) {
            return true;
        }

        Matcher m = p.matcher(time);

        return !m.matches();
    }

    private static void print(String args) { System.out.println(args); }

    private static String scanString(String msg) {
        String value;

        try {
            print(msg);
            value = scanner.nextLine();
        } catch (Exception x) {
            print(msg);
            value = scanner.nextLine();
        }

        return value;
    }

    @SuppressWarnings("unused")
    private static void testing() {
        calculateParkFee(
                "Mobil",
                countHours("07:45", "09:01")
        );

        calculateParkFee(
                "Motor",
                countHours("07:45", "08:01")
        );

        calculateParkFee(
                "Mobil",
                countHours("07:45", "12:01")
        );
    }

}
