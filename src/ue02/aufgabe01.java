package ue02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class aufgabe01 {

    static String[] input;

    static int len = 0;

    public static void main(String args[]) throws IOException  {
        wordsOfLength();
    }

    private static void get_length() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading word length, Please enter: ");
        len = scanner.nextInt();
        System.out.println("Your entry was: " + len);
    }

    public static void get_input(){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading input Sring (Text), Please enter: ");
        String input_sting = scanner.nextLine();
        System.out.println("User Input from console: " + input_sting);
        input = input_sting.split(" ");
    }

    public static void wordsOfLength() {
        get_input();
        get_length();

        System.out.println("Ausgabe:");
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() == len) {
                System.out.println(input[i] + ", ");
            }
        }
    }
}
