package de.davidgollasch.emiexercise1;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
         *
         *
         */
        tvOutput = (TextView) findViewById(textViewdigitsum);
        etNumber = (EditText) findViewById(in_digitsum);
        btnFire = (Button) findViewById(button_digitsum);

    }

    /**
     * Trigger the Digit Sum Calculation
     */
    private void CalculateDigitSum() {
        /*
         *
         *  TODO: IMPLEMENT THIS
         *  NUMBER 3: CALCULATE AND PRINT DIGIT SUM
         *
         *
         */

        /*
         * a) Get entered number
         */


        /*
         * b) Calculate digit sum
         *    (Hint: This can be done recursively using an additional function/method
         *    private int getDigitSum(int n))
         */

        /*
         * c) Print result
         */

        }

}
