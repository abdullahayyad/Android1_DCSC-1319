package com.ayyad.demoappweek2_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editNum1 = findViewById(R.id.edit_num1);
        EditText editNum2 = findViewById(R.id.edit_num2);

        Button btnSum = findViewById(R.id.btn_sum);
        Button btnSub = findViewById(R.id.btn_sub);
        Button btnDiv = findViewById(R.id.btn_div);
        Button btnMulti = findViewById(R.id.btn_multi);

        Button btnCalculation = findViewById(R.id.btn_calc);

        TextView txtOperation = findViewById(R.id.txt_operation);
        TextView txtResult = findViewById(R.id.txt_result);


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtOperation.setText("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtOperation.setText("-");

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtOperation.setText("/");

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtOperation.setText("*");

            }
        });


        btnCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNum1 = editNum1.getText().toString();
                String strNum2 = editNum2.getText().toString();

                double num1 = Double.parseDouble(strNum1);
                double num2 = Double.parseDouble(strNum2);

                String operation = txtOperation.getText().toString();

                double result = 0;
                if (operation.equals("+")) {
                     result = num1 + num2;
                } else if (operation.equals("*")) {
                     result = num1 * num2;

                } else if (operation.equals("/")) {
                     result = num1 / num2;

                } else if (operation.equals("-")) {
                     result = num1 - num2;
                }


                txtResult.setText(String.valueOf(result));

            }
        });


    }

//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//            case R.id.btn_sum:
//
//
//
//                break;
//            case R.id.btn_div:
//
//
//
//                break;
//            case R.id.btn_multi:
//
//
//                break;
//            case R.id.btn_sub:
//
//
//                break;
//        }
//
//
//    }
}