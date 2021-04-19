package ir.maktabkhune.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView ms_result;
    Button ms_digit[] = new Button[10];
    Button ms_multiply, ms_divide, ms_minus, ms_add, ms_equal, ms_clear;
    Double result, last_number;
    Boolean num_empty, last_key_operation;
    Integer last_operation;
    String NaN = "NaN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        result = 0.0;
        last_number = 0.0;
        num_empty = true;
        last_key_operation = false;
        last_operation = -1;

        ms_result = (TextView) findViewById(R.id.display);
        ms_result.setText(result.toString());

        ms_digit[0] = (Button) findViewById(R.id.zero);
        ms_digit[1] = (Button) findViewById(R.id.one);
        ms_digit[2] = (Button) findViewById(R.id.two);
        ms_digit[3] = (Button) findViewById(R.id.three);
        ms_digit[4] = (Button) findViewById(R.id.four);
        ms_digit[5] = (Button) findViewById(R.id.five);
        ms_digit[6] = (Button) findViewById(R.id.six);
        ms_digit[7] = (Button) findViewById(R.id.seven);
        ms_digit[8] = (Button) findViewById(R.id.eight);
        ms_digit[9] = (Button) findViewById(R.id.nine);

        ms_multiply = (Button) findViewById(R.id.multiplication);
        ms_divide = (Button) findViewById(R.id.division);
        ms_add = (Button) findViewById(R.id.plus);
        ms_minus = (Button) findViewById(R.id.subtract);
        ms_equal = (Button) findViewById(R.id.equal);
        ms_clear = (Button) findViewById(R.id.clear);

        ms_digit[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(0);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(1);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(2);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(3);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(4);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(5);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(6);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(7);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(8);
                ms_result.setText(result.toString());
            }
        });

        ms_digit[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(9);
                ms_result.setText(result.toString());
            }
        });

        ms_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(0);
                ms_result.setText("");
            }
        });

        ms_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(1);
                ms_result.setText("");
            }
        });

        ms_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(2);
                ms_result.setText("");
            }
        });

        ms_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(3);
                ms_result.setText("");
            }
        });

        ms_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processEqual();
                ms_result.setText(result.toString());
            }
        });

        ms_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processClear();
                ms_result.setText(result.toString());
            }
        });

    }

    private void processDigit(int d) {
        if (last_key_operation) {
            last_number = result;
            num_empty = false;
            last_key_operation = false;
            result = 0.0;
        }

        result = result * 10 + d;
    }

    private void processOperation(int operation) {
        if (last_operation >= 0 && !num_empty) {
            if (last_operation == 0)
                result = last_number + result;
            else if (last_operation == 1)
                result = last_number - result;
            else if (last_operation == 2)
                result = last_number * result;
            else if (last_operation == 3)
                if (result == 0) {
                    result = last_number / result;
                    last_number = 0.0;
                    num_empty = true;
                }
        }

        last_key_operation = true;
        last_operation = operation;
    }

    private void processEqual() {
        if (last_operation >= 0 && !num_empty) {
            Double backup = result;

            if (last_operation == 0)
                result = last_number + result;
            else if (last_operation == 1)
                result = last_number - result;
            else if (last_operation == 2)
                result = last_number * result;
            else if (last_operation == 3)
                result = last_number / result;

            last_number = backup;
            num_empty = true;
        } else if (last_operation >= 0 && num_empty) {
            if (last_operation == 0)
                result = result + last_number;
            else if (last_operation == 1)
                result = result - last_number;
            else if (last_operation == 2)
                result = result * last_number;
            else if (last_operation == 3)
                result = result / last_number;

        } else {
            last_key_operation = false;
            last_operation = -1;
        }
        if (last_operation == 3 && last_number == 0)
            result = Double.valueOf(NaN);
    }

    private void processClear() {
        result = 0.0;
        last_number = 0.0;
        num_empty = true;
        last_key_operation = false;
        last_operation = -1;
    }
}
