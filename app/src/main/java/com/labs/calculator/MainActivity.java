package com.labs.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    Button[] Buttons = new Button[18];
    EditText operation;
    TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllButtons();
    }

    public void getAllButtons() {

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button temp = (Button) v;
                String text = temp.getText().toString();
                System.out.println(text);
                if (text.equals("=")) {
                    try {
                        String Text = operation.getText().toString();
                        Expression e = new ExpressionBuilder(Text).build();
                        double result = e.evaluate();
                        results.setText(String.valueOf((Double) result));
                    } catch (Exception ex) {
                        results.setText("Invalid Expression");
                    }
                } else if (text.equals("DEL")) {
                    String Text = operation.getText().toString();
                    if (Text.length() > 0) {
                        String newText = Text.substring(0, Text.length() - 1);
                        operation.setText(newText);
                    }
                } else if (text.equals("A/C")) {
                    operation.setText("");
                    results.setText("");
                } else {
                    operation.append(text);
                }
            }
        };

        results = findViewById(R.id.results);
        Buttons[0] = findViewById(R.id.button0);
        Buttons[1] = findViewById(R.id.button2);
        Buttons[2] = findViewById(R.id.button3);
        Buttons[3] = findViewById(R.id.button4);
        Buttons[4] = findViewById(R.id.button5);
        Buttons[5] = findViewById(R.id.button5);
        Buttons[6] = findViewById(R.id.button6);
        Buttons[7] = findViewById(R.id.button7);
        Buttons[8] = findViewById(R.id.button8);
        Buttons[9] = findViewById(R.id.button9);

        Buttons[10] = findViewById(R.id.point);
        Buttons[11] = findViewById(R.id.buttonAdd);
        Buttons[12] = findViewById(R.id.buttonMinus);
        Buttons[13] = findViewById(R.id.buttonMulti);
        Buttons[14] = findViewById(R.id.buttonDiv);
        Buttons[15] = findViewById(R.id.buttonEqual);
        Buttons[16] = findViewById(R.id.buttonClearAll);
        Buttons[17] = findViewById(R.id.buttonClear);

        operation = findViewById(R.id.operation);

        for (Button b : Buttons) {
            b.setOnClickListener(myListener);
        }

    }

}
