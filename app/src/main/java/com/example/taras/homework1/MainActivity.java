package com.example.taras.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText etInput;
    private EditText etIndexFibonacci;
    private TextView tvResult;
    private TextView tvFibonacci;
    private static int variable = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        etInput = (EditText) findViewById(R.id.editTextTask2);
        etIndexFibonacci = (EditText) findViewById(R.id.editTextIndex);
        tvResult = (TextView) findViewById(R.id.textViewResult);
        tvFibonacci = (TextView) findViewById(R.id.tvNumberFibonacci);

        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 12)
                    tvResult.setText(++variable + "");
                if(s.length() >= 23)
                    tvResult.setText("I love GoIT so much");
            }
        });

        etIndexFibonacci.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    tvFibonacci.setText("");
                    return;
                }

                int index = Integer.valueOf(s.toString());

                if (index >= 0 && index < 104) {
                    long[] fibonacci = new long[index + 1];
                    for (int i = 1; i < fibonacci.length; i++) {
                        if (i == 1) {
                            fibonacci[i] = 1;
                            continue;
                        }
                        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
                    }

                    tvFibonacci.setText(fibonacci[index] + "");
                }
                else tvFibonacci.setText("Wrong index");
            }
        });

    }

    public void onButtonClick(View view) {
        tvResult.setText(++variable + "");
    }

}