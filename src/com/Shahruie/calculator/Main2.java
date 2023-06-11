package com.Shahruie.calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main2 extends Activity implements OnClickListener {
Button add,sub,div,mult,equal,clear,one,two,three,foure,five,six,seven,eate,nine,zero;
TextView input;

String temp;
Boolean oprationset,clear2,clear3;
String[] endigit={"0","1","2","3","4","5","6","7","8","9"};
String[] fadigit={"0","1","2","3","4","5","6","7","8","9"};
ArrayList<String> adad=new ArrayList<String>();
ArrayList<String> op=new ArrayList<String>();
float r;
float temp2;
int num=12,m=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		input=(TextView)findViewById(R.id.input);
		add=(Button)findViewById(R.id.add);
		sub=(Button)findViewById(R.id.sub);
		mult=(Button)findViewById(R.id.mult);
		div=(Button)findViewById(R.id.div);
		clear=(Button)findViewById(R.id.clear);
		one=(Button)findViewById(R.id.one);
		two=(Button)findViewById(R.id.two);
		three=(Button)findViewById(R.id.three);
		foure=(Button)findViewById(R.id.foure);
		five=(Button)findViewById(R.id.five);
		six=(Button)findViewById(R.id.six);
		seven=(Button)findViewById(R.id.seven);
		eate=(Button)findViewById(R.id.aete);
		nine=(Button)findViewById(R.id.nine);
		zero=(Button)findViewById(R.id.zero);
		equal=(Button)findViewById(R.id.equal);
		
	
		add.setOnClickListener(this);
		clear.setOnClickListener(this);
		sub.setOnClickListener(this);
		mult.setOnClickListener(this);
		div.setOnClickListener(this);
		equal.setOnClickListener(this);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		foure.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eate.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);
		clear2=clear3=oprationset=true;
		temp="";
		input.setText("0");
		clear.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				input.setText("0");
				clear2=clear3=oprationset=true;
				temp="";
				num=12;
				return false;
			}
		});
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.one:
			addtoadadarray("1");
			break;
		case R.id.two:
			addtoadadarray("2");
			break;
		case R.id.three:
			addtoadadarray("3");
			break;
		case R.id.foure:
			addtoadadarray("4");
			break;
		case R.id.five:
			addtoadadarray("5");
			break;
		case R.id.six:
			addtoadadarray("6");
			break;
		case R.id.seven:
			addtoadadarray("7");
			break;
		case R.id.aete:
			addtoadadarray("8");
			break;
		case R.id.nine:
			addtoadadarray("9");
			break;
		case R.id.zero:
			if((!clear2)&&(!clear3)&&(!oprationset))
			addtoadadarray("0");
			break;
case R.id.add:
	addtooparray("+");
	break;
case R.id.sub:
	addtooparray("-");
	break;
case R.id.mult:
	addtooparray("*");
	break;
case R.id.div:
	addtooparray("/");
	break;
case R.id.equal:
	if((!oprationset)&&(!clear2)&&(!clear3)){
		input.append("= ");
		 clear3=true;
		 oprationset=true;
		 num=12;
		 temp="";
		calculate();}
		break;
case R.id.clear:
	if((!clear2)&&(!clear3)){
	if (lastisdigit(input.getText().toString())){
		if (adad.size()>0){
			String s=removeLastChar(adad.get(adad.size()-1));
			adad.set(adad.size()-1,s);
			if(adad.get(adad.size()-1).length()==0)
				adad.remove(adad.size()-1);
		}
		input.setText(removeLastChar(input.getText().toString()));
			
	}else
	if (lastisoprator(input.getText().toString())) {
		op.remove(op.size()-1);
		input.setText(removeLastChar(input.getText().toString()));
	}	
	
	if(input.getText().length()>0){
	if (lastisdigit(input.getText().toString())){
		oprationset=false;
	}
	else if (lastisoprator(input.getText().toString())) {
				oprationset=true;

	}
	}else{
		oprationset=clear2=clear3=true;
	temp="";
	num=12;}
	if ((adad.size()==0)&&(op.size()==0)) {
		oprationset=clear3=true;
		temp="";num=12;
	}
	}
	break;
	default:
			break;
		}
		
		
	}
	
	private void addtoadadarray(String str) {
		// TODO Auto-generated method stub
		if (num>0) {
			num-=1;
		 if (clear2) {input.setText(str);}
		else input.append(str);}
		temp=temp+str;
		if ((oprationset)||clear2) {adad.add(temp);}
		else	adad.set(adad.size()-1, temp);
		 clear2=clear3=false; oprationset=false;
	}
	
	private void addtooparray(String str) {
		// TODO Auto-generated method stub
		if ((!oprationset)&&(!clear2)&&(!clear3)) {
			input.append(str);	 oprationset=true;
			op.add(str);	temp="";	num=12;
			}
	}
	
	private Boolean lastisoprator(String str) {
		// TODO Auto-generated method stub
		 char[] s=str.toCharArray();
		 char last=s[s.length-1];

			if ((last=='+')||(last=='-')||(last=='*')||(last=='/'))
		{
			return true;
		}else return false;
	}
	
	private Boolean lastisdigit(String str) {
			char[] s=str.toCharArray();
		 char last=s[s.length-1];
		if ((last=='0')||(last=='1')||(last=='2')||(last=='3')||(last=='4')||(last=='5')||
				(last=='9')||(last=='8')||(last=='7')||(last=='6'))
					{
			return true;
		}else return false;
	}
	
	private void calculate() {
		// TODO Auto-generated method stub
		int m=0;
		Float r,n;
		r=Float.parseFloat(adad.get(0));
		for (int i = 1; i < adad.size(); i++) {
			n=Float.parseFloat(adad.get(i));
			switch (op.get(m)) {
			case "+":
				r=r+n;
				break;
			case "-":
				r=r-n;
				break;
			case "*":
				r=r*n;
				break;
			case "/":
				r=r/n;
				break;
			default:
				break;
			}
			m++;
		}
		String temp2=r+"";
 		temp2 = removeUnwantedValueInDecimal(temp2);
    	 input.append(temp2+"\n");
		op.removeAll(op);
		adad.removeAll(adad);
		
	}
	
	
	 private static String removeLastChar(String s) {
		 if (s == null || s.length() == 0) {
		        return s;
		    }
		    return s.substring(0, s.length()-1);

	    }
	 
		 private String removeUnwantedValueInDecimal(String result) {
	        String resutlTmp = result.substring(result.lastIndexOf("."),
	                result.length());
	 
	        if (this.containNumberNotZero("[1-9]", resutlTmp)) {
	            // **** OF DECIMAL VALUES CONTAIN ANY NUMBER BETWEEN 1 - 9
	            return result;
	 
	        } else {
	            // *** IF DECIMAL VALUES CONTAIN ZEROS. REMOVE DECIMAL VALUES
	            return result.substring(0, result.lastIndexOf("."));
	 
	        }
	 
	    }
	 
	 private boolean containNumberNotZero(String theRegex, String stringToCheck) {
		 
	        Pattern pattern = Pattern.compile(theRegex);
	        Matcher matcher = pattern.matcher(stringToCheck);
	 
	        while (matcher.find()) {
	            return true;
	        }
	 
	        return false;
	    }
	 
}
