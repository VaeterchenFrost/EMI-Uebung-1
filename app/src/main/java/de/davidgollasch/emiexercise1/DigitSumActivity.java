package de.davidgollasch.emiexercise1;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;

import static de.davidgollasch.emiexercise1.R.id.button_digitsum;
import static de.davidgollasch.emiexercise1.R.id.in_digitsum;
import static de.davidgollasch.emiexercise1.R.id.textViewdigitsum;

public class DigitSumActivity extends AppCompatActivity {

    private TextView tvOutput;
    private EditText etNumber;
    private Button btnFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_sum);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tuAkzentfarbe1BlauHell)));

        // Initialises the views and event listeners
        InitializeActivity();
    }

    /**
     * Construct the Interactive Structure
     */
    private void InitializeActivity() {

        /*
         *
         *  TODO: IMPLEMENT THIS
         *  NUMBER 2: LINK VIEWS
         */
        tvOutput = (TextView) findViewById(textViewdigitsum);
        etNumber = (EditText) findViewById(in_digitsum);
        btnFire = (Button) findViewById(button_digitsum);

        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear text view
                tvOutput.setText("");

                // Invoke calculation
                CalculateDigitSum();
            }
        });

        /*
         * Special buttons used in EditText:
         * -> ENTER, confirm input String
         */
        etNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int actionId, KeyEvent event) {
                if (actionId == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    btnFire.performClick();
                    return true; //Consumed event
                }
                return false;
            }
        });
    }

    /**
     * Trigger the Digit Sum Calculation
     */
    private void CalculateDigitSum() {
        /*
         *
         *  TODO: IMPLEMENT THIS
         *  NUMBER 3: CALCULATE AND PRINT DIGIT SUM
         */

        /*
         * a) Get entered number
         */
        String s_number = String.valueOf(etNumber.getText());

        /*
         * b) Calculate digit sum
         *    (Hint: This can be done recursively using an additional function/method
         *    private int getDigitSum(int n))
         */
        int digitsum = getDigitSum(s_number);

        /*
         * c) Print result
         */
        tvOutput.setText(Integer.toString(digitsum));

    }

    /*
     * return digit sum of a number n
     */
/*
    private int getDigitSum(int n) {
        return getDigitSum(Integer.toString(n));
    }
*/

    /**
     * Returns digit sum of a digit-string s_number.
     * This is done by looking for characters 1-9
     * and adding the value according.
     *
     * @param s_number a string to process
     * @return the integer representing the digit sum of s_number.
     **/
    private int getDigitSum(String s_number) {
        int digitsum = 0;
        // Add value of chars: 1, 2, 3, 4, 5, 6, 7, 8, 9 ; nothing else.
        for (int i = s_number.length() - 1; i >= 0; i--) {
            //Look for matching literal(s):
            switch (s_number.charAt(i)) {
                case '1':
                    digitsum += 1;
                    break;
                case '2':
                    digitsum += 2;
                    break;
                case '3':
                    digitsum += 3;
                    break;
                case '4':
                    digitsum += 4;
                    break;
                case '5':
                    digitsum += 5;
                    break;
                case '6':
                    digitsum += 6;
                    break;
                case '7':
                    digitsum += 7;
                    break;
                case '8':
                    digitsum += 8;
                    break;
                case '9':
                    digitsum += 9;
                    break;
                default:
                    break;
            }
        } //Calculated sum of digits
        return digitsum;
    }

}


