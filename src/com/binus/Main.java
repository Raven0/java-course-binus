package com.binus;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String s = "This is a sample sentence.";
        String[] words = s.split("\\s+");

        IntStream.range(0, words.length).forEach(i -> print(i + ": " + words[i]));
        print("Total word: "+words.length);
    }

    private static void print(String args){
        System.out.println(args);
    }

}
