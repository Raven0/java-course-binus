package com.binus;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        int n = 1;
        while (primes.size() != 5) {
            if (isPrime(n)){
                primes.add(n);
            }
            n++;
        }

        print(primes.toString());
    }

    static boolean isPrime(int n)
    {
        boolean result = true;

        // untuk validasi angka 1
        if (n < 2) {
            result = false;
        }

        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void print(String args){
        System.out.println(args);
    }

}
