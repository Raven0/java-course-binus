package com.binus;

public class Main {

    public static void main(String[] args) {
        fib(10);
    }

    static void fib(int n) {
        int num1 = 0;
        int num2 = 1;
        int counter = 0;

        if (counter < n) {
            do {
                print(String.valueOf(num1));

                int num3;
                num3 = num2 + num1;
                num1 = num2;
                num2 = num3;
                counter = counter + 1;
            } while (counter < n);
        }
    }

    private static void print(String args){
        System.out.println(args);
    }

}
