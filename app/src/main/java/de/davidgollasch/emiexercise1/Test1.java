package de.davidgollasch.emiexercise1;

import java.text.NumberFormat;

import static java.lang.System.*;

/**
 * Created by Martin on 24.10.2016.
 */

final class Test1 {
    public static void main(String[] args) {
        int a, b;
        a = 27;
        b = 2;
        out.println(a / b);
//        String s = CalculateFibonacciRow();
//        out.println(s);
        for (char k : "alpha".toCharArray()
                ) {
            out.print(k + "0");
        }
        String s_zahl = "12345";
//        int zahl = Integer.parseInt(s_zahl);
        int quersumme = 0;
        // Add value of 1 to 9, nothing else.
        for (int i = s_zahl.length() - 1; i >= 0; i--) {
            switch (s_zahl.charAt(i)) {
                case '1':
                    quersumme += 1;
                    break;
                case '2':
                    quersumme += 2;
                    break;
                case '3':
                    quersumme += 3;
                    break;
                case '4':
                    quersumme += 4;
                    break;
                case '5':
                    quersumme += 5;
                    break;
                case '6':
                    quersumme += 6;
                    break;
                case '7':
                    quersumme += 7;
                    break;
                case '8':
                    quersumme += 8;
                    break;
                case '9':
                    quersumme += 9;
                    break;
                default:
                    break;
            }

        }
        out.print(quersumme);
    }

    private static String CalculateFibonacciRow() {
        String output = "";
        int max_n = 29;
        /* further use unconnected to specific 'max_n'
        * give every 2, starting with 0 like:
        * F_0, F_1
        * F_2, F_3
        *
        * times: ('max_n'+1)/2
        * if not max_n%2 then append one more number. (first column)
        *
        /* TODO: IMPLEMENT THIS */

        if (max_n < 0) return output;

        int a, b;
        a = 0;
        b = 1;


        for (int i = 1; i <= (max_n + 1) / 2; i++) {
            output += Integer.toString(a) + " ";
            output += Integer.toString(b) + " ";
            a = a + b;
            b = a + b;
        }
        if ((max_n % 2) == 0) output += Integer.toString(a) + " ";
        return output;
    }
}

