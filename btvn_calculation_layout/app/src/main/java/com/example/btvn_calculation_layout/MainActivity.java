package com.example.btvn_calculation_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
            buttonC,buttonPlus,buttonMinus,buttonMulti,buttonDivide,buttonDot,buttonEquals;

    private TextView textViewResult,textViewHistory;

    Boolean checkClickOperator=true;

    String firstNumber="";
    String secondNumber="";
    String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0=findViewById(R.id.btn0);
        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5=findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);
        button8=findViewById(R.id.btn8);
        button9=findViewById(R.id.btn9);

        buttonC=findViewById(R.id.btnC);

        buttonPlus=findViewById(R.id.btnPlush);
        buttonMinus=findViewById(R.id.btnSubstraction);
        buttonMulti=findViewById(R.id.btnMultiply);
        buttonDivide=findViewById(R.id.btnDivide);
        buttonDot=findViewById(R.id.btnDot);
        buttonEquals=findViewById(R.id.btnEqual);

        textViewHistory=findViewById(R.id.tvExpression);
        textViewResult=findViewById(R.id.tvResult);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewHistory.getText()+"9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="\\+";
                textViewHistory.setText(textViewHistory.getText()+"+");
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="-";
                textViewHistory.setText(textViewHistory.getText()+"-");
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="x";
                textViewHistory.setText(textViewHistory.getText()+"x");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="/";
                textViewHistory.setText(textViewHistory.getText()+"/");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= (String) textViewHistory.getText();
                String[] temp=s.split(operator);

                //Log.i("tinh",operator);

                Double first=Double.parseDouble(temp[0]);
                Double second=Double.parseDouble(temp[1]);

                if(operator.equals("\\+")) textViewResult.setText(Double.toString(first+second));
                else if(operator.equals("-")) textViewResult.setText(Double.toString(first-second));
                else if(operator.equals("x")) textViewResult.setText(Double.toString(first*second));
                else if(operator.equals("/") && second!=0) textViewResult.setText(Double.toString(first/second));
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= (String) textViewHistory.getText();

                if(!s.contains(".")) {
                    if(s.isEmpty() || s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-' || s.charAt(s.length()-1)=='x'
                            || s.charAt(s.length()-1)=='/') s=s+"0.";
                    else s=s+".";
                    Log.i("tinh",s);
                    textViewHistory.setText(s);
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText("");
                textViewResult.setText("");
            }
        });
    }


}