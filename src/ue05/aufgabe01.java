//UE05 Aufgabe (Alg. & Datenstr.)
//Datum:    05.05.2021
//Autor:    Armin Ittensammer

package ue05;

import java.io.InputStreamReader;
import java.util.Scanner;

public class aufgabe01 {
    public static void main(String[] args) {
        System.out.println("Ausgabe der Permutation:");

        //--- keyboard
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Enter a word to permutate: ");
        String word = scanner.nextLine();
        permutateWord(word, "");

        //--- command line
        //System.out.println(args[0]);
        //permutateWord(args[0],"");
    }

    private static void permutateWord(String arg, String last) {
        if (arg.length() == 0) {
            System.out.print(last + " ");
            return;
        }
        for (int i = 0; i < arg.length(); i++) {    // for loop - all possibilites
            char ch = arg.charAt(i);                //working with first elem than iterate
            String outs = arg.substring(0, i) + arg.substring(i + 1);
            permutateWord(outs, last + ch);
        }
    }
}


