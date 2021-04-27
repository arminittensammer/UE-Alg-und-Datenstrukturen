package ue02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.lang.Math;

public class aufgabe02 {

    static List<Float> values = new ArrayList<Float>();
    static Float mean;
    static int len;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading values, Please enter the amount: ");
        len = scanner.nextInt();
        System.out.println("Your entry was: " + len);

        for (int i = 0; i < len; i++) {
            System.out.println("Nummer " + (i+1));
            computeStatistics();
        }

        process_data();
    }

    private static void process_data() {

        if(values.size() > 5){
            while (values.size() > 5){
                values.remove(0);
            }
        } else {
            while (values.size() < 5){
                values.add((float) 0);
            }
        }

        calc_mean();
        calc_sd();
    }

    private static void calc_mean() {
        float sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += values.get(i);
        }
        mean =  sum / 5;
        System.out.println("Mittelwert: " + mean);
    }

    private static void calc_sd() {
        float sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += (values.get(i)-mean)*(values.get(i)-mean);
        }
        System.out.println("Standartabweichung: " + Math.sqrt((double) (sum / 5)));
    }

    public static void computeStatistics() throws IOException{
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        //System.out.println("Reading input Value, Please enter: ");
        Float val = scanner.nextFloat();
        // System.out.println("User Input from console: " + val);
        values.add(val);
    }

}
