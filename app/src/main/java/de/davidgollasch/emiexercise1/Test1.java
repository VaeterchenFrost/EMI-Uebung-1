package de.davidgollasch.emiexercise1;

import static java.lang.System.*;

/**
 * Created by Martin on 24.10.2016.
 */

final class Test1 {
    public static void main(String[] args) {
        int a, b;
        a = 27;
        b = 2;
        out.print(a / b);
        String s = CalculateFibonacciRow();
        out.println(s);
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
