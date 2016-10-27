package de.davidgollasch.emiexercise1;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;
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
         *
         *
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

        etNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int actionId, KeyEvent event) {
                tvOutput.setText("lol");
                if (event == null) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) ;
                        // Capture soft enters in a singleLine EditText that is the last EditText.
                    else if (actionId == EditorInfo.IME_ACTION_NEXT) ;
                        // Capture soft enters in other singleLine EditTexts
                    else return false;  // Let system handle all other null KeyEvents
                } else if (actionId == EditorInfo.IME_NULL) {
                    // Capture most soft enters in multi-line EditTexts and all hard enters.
                    // They supply a zero actionId and a valid KeyEvent rather than
                    // a non-zero actionId and a null event like the previous cases.
                    if (event.getAction() == KeyEvent.ACTION_DOWN) ;
                        // We capture the event when key is first pressed.
                    else return true;   // We consume the event when the key is released.
                } else return false;
                btnFire.performClick();
                return true;
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
         *
         *
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
        int digitsum = 0;
        // Add value of 1 to 9, nothing else.
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

        /*
         * c) Print result
         */
        tvOutput.setText(Integer.toString(digitsum));


    }

}
