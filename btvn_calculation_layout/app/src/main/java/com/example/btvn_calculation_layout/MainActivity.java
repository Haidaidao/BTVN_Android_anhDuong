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
                //operator="\\+";
                String s= (String) textViewHistory.getText();
                if(!checkClickOperator) {

                  String[] temp=s.split(operator);

                  if(Double.parseDouble(temp[1])==0 && operator.equals("/")) {
                      checkClickOperator=true;
                      textViewResult.setText("");
                      textViewHistory.setText("");
                      operator="";
                  }
                  else {
                      Double resultNumber = calculator(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]),
                              operator);

                      textViewHistory.setText(resultNumber + "+");
                  }
                }
                else {
                    checkClickOperator=false;
                    textViewHistory.setText(s+"+");
                }
                operator="\\+";
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operator="-";
                String s= (String) textViewHistory.getText();
                if(!checkClickOperator) {

                    String[] temp=s.split(operator);

                    if(Double.parseDouble(temp[1])==0 && operator.equals("/")) {
                        checkClickOperator=true;
                        textViewResult.setText("");
                        textViewHistory.setText("");
                        operator="";
                    }
                    else {
                        Double resultNumber = calculator(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]),
                                operator);

                        textViewHistory.setText(resultNumber + "-");
                    }
                }
                else{
                    checkClickOperator=false;
                    textViewHistory.setText(s+"-");
                }
                operator="-";
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operator="x";

                String s= (String) textViewHistory.getText();
                if(!checkClickOperator) {

                    String[] temp=s.split(operator);

                    if(Double.parseDouble(temp[1])==0 && operator.equals("/")) {
                        checkClickOperator=true;
                        textViewResult.setText("");
                        textViewHistory.setText("");
                        operator="";
                    }
                    else {
                        Double resultNumber = calculator(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]),
                                operator);

                        textViewHistory.setText(resultNumber + "x");
                    }
                }
                else{
                    checkClickOperator=false;
                    textViewHistory.setText(s+"x");
                }
                operator="x";

            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operator="/";

                String s= (String) textViewHistory.getText();
                if(!checkClickOperator) {

                    String[] temp=s.split(operator);

                    if(Double.parseDouble(temp[1])==0) {
                        checkClickOperator=true;
                        textViewResult.setText("");
                        textViewHistory.setText("");
                        operator="";
                    }
                    else {
                        Double resultNumber = calculator(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]),
                                operator);

                        textViewHistory.setText(resultNumber + "/");
                    }
                }
                else{
                    checkClickOperator=false;
                    textViewHistory.setText(s+"/");
                }
                operator="/";

            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= (String) textViewHistory.getText();

                String lastValue = s.substring(s.length()-1);
                if(Character.isDigit(lastValue.charAt(0))) {
                    //Log.i("tinh","Vao");
                    if(s.contains("\\+")) operator="\\+";
                    else if(s.contains("-")) operator="-";
                    else if(s.contains("x")) operator="x";
                    else if(s.contains("/")) operator="/";

                    String[] temp=s.split(operator);

                    if(Double.parseDouble(temp[1])==0 && operator.equals("/")) {
                        checkClickOperator=true;
                        textViewResult.setText("");
                        textViewHistory.setText("");
                        operator="";
                    }
                    else {
                        Double resultNumber = calculator(Double.parseDouble(temp[0]),Double.parseDouble(temp[1]),
                                operator);
                        textViewResult.setText(resultNumber+"");
                    }
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= (String) textViewHistory.getText();
                //Log.i("tinh",s);

                if(checkDot(operator)) {
                    String lastValue = "";
                    if(!s.isEmpty()) lastValue=s.substring(s.length()-1);
                    Log.i("tinh",lastValue);
                    if(s.isEmpty() || !Character.isDigit(lastValue.charAt(0)))
                        textViewHistory.setText("0.");
                    else textViewHistory.setText(s+".");

                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkClickOperator=true;
                textViewResult.setText("");
                textViewHistory.setText("");
                operator="";
            }
        });
    }

    public Double calculator(Double a, Double b,String operator) {
        if(operator.equals("\\+")) return a+b;
        else if(operator.equals("-")) return a-b;
        else if(operator.equals("/")) return a/b;
        return a*b;
    }

    public boolean checkDot(String operator) {

        String s= (String) textViewHistory.getText();

        int pos=-1;
        for(int i=0;i<s.length();i++)
            if(!Character.isDigit(s.charAt(i))) {
                pos=i;
                break;
            }
        //Log.i("tinh",pos+"");
        if(pos==-1) return true;

        if(pos<s.length()-1) return true;

        return false;
    }
}