package com.Shahruie.calculator;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.text.method.DigitsKeyListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


import android.widget.TextView;

public class MainActivity2 extends Activity {

        TextView edittest1;

        Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, cancel, equal;

        ArrayList<Float> math = new ArrayList<Float>();
        float m1;
        float m2;
        float temp;

        int currentOperation = 0;
        int nextOperation;

        final static int ADD = 1;
        final static int SUBTRACT = 2;
        final static int MULTIPLY =3;
        final static int DIVISION = 4;
        final static int EQUALS = 0;
        final static int CLEAR = 1;
        final static int DONT_CLEAR = 0;
        int clearDisplay = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

            edittest1 = (TextView) findViewById(R.id.input);
     add=(Button)findViewById(R.id.add);
    		sub=(Button)findViewById(R.id.sub);
    		//mul=(Button)findViewById(R.id.mult);
    		div=(Button)findViewById(R.id.div);
    		cancel=(Button)findViewById(R.id.clear);
    		one=(Button)findViewById(R.id.one);
    		two=(Button)findViewById(R.id.two);
    		three=(Button)findViewById(R.id.three);
    		four=(Button)findViewById(R.id.foure);
    		five=(Button)findViewById(R.id.five);
    		six=(Button)findViewById(R.id.six);
    		seven=(Button)findViewById(R.id.seven);
    		eight=(Button)findViewById(R.id.aete);
    		nine=(Button)findViewById(R.id.nine);
    		zero=(Button)findViewById(R.id.zero);
    		equal=(Button)findViewById(R.id.equal);

            edittest1.setKeyListener(DigitsKeyListener.getInstance(true,true));

            registerListeners();


    }

    private void registerListeners() {
        // TODO Auto-generated method stub

        one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
               edittest1.append("1");

            }
        });

        two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("2");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                   edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("3");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                  edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("4");

            }
        });

        five.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                   edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                   edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("7");

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("8");

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("9");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    edittest1.setText("");
                }
                clearDisplay = DONT_CLEAR;
                edittest1.append("0");

            }
        });
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            	if (clearDisplay== DONT_CLEAR) {
					edittest1.append("+");
				}
                calcLogic(ADD);
                }
            }
        );

        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(SUBTRACT);
            }               
        });
        mul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(MULTIPLY);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(DIVISION);                    
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                calcLogic(EQUALS);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                edittest1.setText("0");
                m1 = 0;
                m2 = 0;
                math.removeAll(math);
                currentOperation = 0;
                nextOperation = 0;    

            }
        });


}
    private void calcLogic(int operator){
    	
         math.add(Float.parseFloat(edittest1.getText().toString()));

            if (operator != EQUALS) {
                nextOperation = operator;
            }
            else if  (operator == EQUALS){
                nextOperation = 0;
                //operator=' ';
            }



            switch (currentOperation) {
            case ADD:               
                m1 = math.get(0);
                m2 = math.get(1);

                math.removeAll(math);

                math.add(m1 + m2);


                edittest1.setText(String.format("%.3f", math.get(0)));



                break;
            case SUBTRACT:
                m1 = math.get(0);
                m2 = math.get(1);

                math.removeAll(math);

                math.add(m1 - m2);

                edittest1.setText(String.format("%.3f", math.get(0)));
                break;
            case MULTIPLY:
                m1 = math.get(0);
                m2 = math.get(1);

                math.removeAll(math);

                math.add(m1 * m2);

                edittest1.setText(String.format("%.3f", math.get(0)));
                break;
            case DIVISION:
                m1 = math.get(0);
                m2 = math.get(1);

                math.removeAll(math);

                math.add(m1 / m2);

                edittest1.setText(String.format("%.3f", math.get(0)));
                break;
            }

            clearDisplay = CLEAR;
	            currentOperation = nextOperation;
	            if (operator == EQUALS) {
	                m1 = 0;
	                m2 = 0;
	                math.removeAll(math);
	            }

        }

    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
  

}