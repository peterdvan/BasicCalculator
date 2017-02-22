package com.example.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

public class BasicCalculator extends AppCompatActivity {
public static float NUMBER = 0;
    public static float NUMBER2 = 0;
    boolean CALCULATED = false;
    private TextView NUMBER_SCREEN;
    //0 is default value
    //1 == addition
    //2 == subtraction
    //3 == multiplication
    //4 == division
    public static int operatorSelection = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        NUMBER_SCREEN = (TextView) findViewById((R.id.numberHolder));
        Button one = (Button)findViewById(R.id.one);
        Button two = (Button)findViewById(R.id.two);
        Button three = (Button)findViewById(R.id.three);
        Button four = (Button)findViewById(R.id.four);
        Button five = (Button)findViewById(R.id.five);
        Button six = (Button)findViewById(R.id.six);
        Button seven = (Button)findViewById(R.id.seven);
        Button eight = (Button)findViewById(R.id.eight);
        Button nine = (Button)findViewById(R.id.nine);
        Button plus = (Button)findViewById(R.id.addition);
        Button minus = (Button)findViewById(R.id.subtraction);
        Button multiply = (Button) findViewById(R.id.multiplication);
        Button divide = (Button) findViewById(R.id.Division);
        Button zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberTransfer(0);
                printNum();
            }
        });
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(1);
                printNum();
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(2);
                printNum();
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(3);
                printNum();
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(3);
                printNum();
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(4);
                printNum();
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(5);
                printNum();
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(6);
                printNum();
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(7);
                printNum();
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(8);
                printNum();
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberTransfer(9);
                printNum();
            }
        });
        Button clr = (Button) findViewById(R.id.clear);
        clr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NUMBER = 0;
                operatorSelection = 0;
                NUMBER_SCREEN.setText("0");
            }

        });
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                operatorSelection = 1;
            }

        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                operatorSelection = 2;
            }

        });
        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                operatorSelection = 3;
            }

        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                operatorSelection = 4;
            }
        });
        Button equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                calculate();
                printNum();
                CALCULATED = true;

            }
        });

    }
    private void calculate() {
        if(operatorSelection == 1) {
            NUMBER = NUMBER + NUMBER2;
        } else if (operatorSelection == 2) {
            NUMBER = NUMBER - NUMBER2;
        } else if (operatorSelection == 3) {
            NUMBER = NUMBER * NUMBER2;
        } else if (operatorSelection == 4) {
            NUMBER = NUMBER / NUMBER2;
        }
        NUMBER2 = 0;
        operatorSelection = 0;
        CALCULATED = true;
    }
    public void numberTransfer(int num) {
        if(CALCULATED && operatorSelection == 0) {
            NUMBER = 0;
            CALCULATED = false;
        }
        if(NUMBER == 0 && operatorSelection == 0) {
            NUMBER = num;
        } else if (NUMBER != 0 && operatorSelection == 0){
            NUMBER *= 10;
            NUMBER += num;
        } else if (operatorSelection != 0 && NUMBER == 0) {
            NUMBER2 = num;
        } else if (operatorSelection != 0 && NUMBER != 0) {
            NUMBER2 *= 10;
            NUMBER2 += num;
        }
    }

    private void printNum() {
            if (operatorSelection == 0 ) {
                NUMBER_SCREEN.setText(Float.toString(NUMBER));
            } else {
                NUMBER_SCREEN.setText(Float.toString(NUMBER2));
            }
    }
}
