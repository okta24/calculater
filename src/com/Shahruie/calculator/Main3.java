package com.Shahruie.calculator;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Shahruie.calculator.ColorPickerDialog.OnColorChangedListener;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main3 extends Activity implements OnClickListener,OnColorChangedListener {
//Button add,sub,div,mult,equal,clear,one,two,three,foure,five,six,seven,eate,nine,zero,lang;
Button buttons[] = new Button[10];
Button oprators[]=new Button[8];
ImageButton tools[]=new ImageButton[10];
int[] themes={R.drawable.recrblue,R.drawable.rectfiruze,
		R.drawable.rectgray,R.drawable.rectgreen,R.drawable.rectorang,R.drawable.rectpinc,R.drawable.rectporgreen,
		R.drawable.rectred,
		R.drawable.rectviolet,R.drawable.rectyellow};
//TextView input;
int random2;
TextView input;
Button  sbut,sback,setbtsound;
String temp;
MediaPlayer mback=null,mp=null,sp=null;
Boolean oprationset,clear2,clear3,slang,soalison,newline,dot,signe;
static Boolean sb;
Boolean soback;
String[] endigit={"0","1","2","3","4","5","6","7","8","9"};
private static String[] persianNumbers = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
ArrayList<String> adad=new ArrayList<String>();
ArrayList<String> op=new ArrayList<String>();
float r;
float temp2;
int num=12,m=0;
Typeface font;
public static int fontsizeid,fontid,soundid;
public static int themeid;
public static int themeopid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main3);
		input=(TextView)findViewById(R.id.input);
		themeid=7;
		themeopid=0;
	//	Setfont();
		//fontid=R.id.font1;
		
	//	sbut=(Button)findViewById(R.id.sbuten);
		////sback=(Button)findViewById(R.id.SOFBACK);
		//setbtsound=(Button)findViewById(R.id.setbtsound);
		//soundid=R.id.zang1;
		tools[0]=(ImageButton)findViewById(R.id.lang);
		tools[1]=(ImageButton)findViewById(R.id.setbcolor);
		tools[2]=(ImageButton)findViewById(R.id.setbtext);
		tools[3]=(ImageButton)findViewById(R.id.settextcolor);
		tools[4]=(ImageButton)findViewById(R.id.theme);
		tools[5]=(ImageButton)findViewById(R.id.soback);
		tools[6]=(ImageButton)findViewById(R.id.sobut);
		tools[7]=(ImageButton)findViewById(R.id.ques);
		tools[8]=(ImageButton)findViewById(R.id.cards);
		tools[9]=(ImageButton)findViewById(R.id.about);
		
		oprators[0]=(Button)findViewById(R.id.add);
		oprators[1]=(Button)findViewById(R.id.sub);
		oprators[2]=(Button)findViewById(R.id.mult);
		oprators[5]=(Button)findViewById(R.id.div);
		oprators[3]=(Button)findViewById(R.id.equal);
		oprators[4]=(Button)findViewById(R.id.clear);
		oprators[6]=(Button)findViewById(R.id.dot);
		oprators[7]=(Button)findViewById(R.id.Btac);
		
		buttons[1]=(Button)findViewById(R.id.one);
		buttons[2]=(Button)findViewById(R.id.two);
		buttons[3]=(Button)findViewById(R.id.three);
		buttons[4]=(Button)findViewById(R.id.foure);
		buttons[5]=(Button)findViewById(R.id.five);
		buttons[6]=(Button)findViewById(R.id.six);
		buttons[7]=(Button)findViewById(R.id.seven);
		buttons[8]=(Button)findViewById(R.id.aete);
		buttons[9]=(Button)findViewById(R.id.nine);
		buttons[0]=(Button)findViewById(R.id.zero);
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(this);
		}
		
		for (int i = 0; i < tools.length; i++) {
			tools[i].setOnClickListener(this);
		}
		
		for (int i = 0; i < oprators.length; i++) {
			oprators[i].setOnClickListener(this);
		}
		
		for (int i = 0; i < oprators.length; i++) {
			oprators[i].setBackgroundResource(R.drawable.rectop);
		}
		
	/*	for (int i = 0; i < buttons.length; i++) {

			buttons[i].setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth()/6, getScreenHeight()/4));
		}
		lang.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth()/6, getScreenHeight()/4));
		sbut.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth()/6, getScreenHeight()/4));
		sback.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth()/6, getScreenHeight()/4));
		setbtsound.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth()/6, getScreenHeight()/4));*/
		clear2=clear3=oprationset=true;
		temp="";
	//	input.setText("0");
		/*oprators[4].setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				input.setText("");
				clear2=clear3=oprationset=true;
				temp="";
				num=12;
				signe=dot=false;
				return false;
			}
		});*/
		mback = MediaPlayer.create(Main3.this, R.raw.happy);
		signe=dot=newline=soalison=false;
		slang=sb=soback=true;
		swichlang();
		soundofback();
		settheme(themeid);
		setthemeop(themeopid);
	}
	private void setthemeop(int themeopid2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < oprators.length; i++) {
			oprators[i].setBackgroundResource(themes[themeopid2]);
		}
	}
	private void settheme(int themeid2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setBackgroundResource(themes[themeid2]);
		}
	}
	
		@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.Btac:
			input.setText("");
			clear2=clear3=oprationset=true;
			temp="";
			num=12;
			signe=dot=false;
			break;
		case R.id.lang:
			if (slang) {
				slang=false;tools[0].setImageResource(R.drawable.cards2);
			}else {slang=true;tools[0].setImageResource(R.drawable.far);}
			swichlang();
			break;
		case R.id.sobut:
			soundofbutten();
			break;
		case R.id.one:
			addtoinput("1",1);
			break;
		case R.id.two:
			addtoinput("2",2);
			break;
		case R.id.three:
			addtoinput("3",3);
			break;
		case R.id.foure:
			addtoinput("4",4);
			break;
		case R.id.five:
			addtoinput("5",5);
			break;
		case R.id.six:
			addtoinput("6",6);
			break;
		case R.id.seven:
			addtoinput("7",7);
			break;
		case R.id.aete:
			addtoinput("8",8);
			break;
		case R.id.nine:
			addtoinput("9",9);
			break;
		case R.id.zero:
			//if((!clear2)&&(!clear3))
				addtoinput("0", 0);
			break;
case R.id.add:
	addtooparray2("+");
	break;
case R.id.sub:
	addtooparray2("-");
	break;
case R.id.mult:
	addtooparray2("*");
	break;
case R.id.div:
	addtooparray2("/");
	break;
case R.id.dot:
	if(!dot){clear2=clear3=false;
	if (newline) {
		input.append("\n.");
		newline=false;
	}else input.append(".");
		dot=true;
		temp+=".";
	}
	break;
case R.id.equal:
	if((!oprationset)&&(!clear2)&&(!clear3)){
		input.append("= ");
		 clear3=true;
		 oprationset=true;
		 num=12;
		 temp="";
		dot=false;
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
		temp=removeLastChar(temp);
			
	}else
	if (lastisoprator(input.getText().toString())) {
		if((op.size()==1)&&(signe)) {signe=false;temp="";}
		op.remove(op.size()-1);
		input.setText(removeLastChar(input.getText().toString()));
		if(adad.size()>0){temp=adad.get(adad.size()-1);}else temp="";
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
	dot=false;
	temp="";
	num=12;}
	if ((adad.size()==0)&&(op.size()==0)) {
		oprationset=clear3=true;
		dot=false;
		temp="";num=12;
	}
	}
	break;
		case R.id.soback:
			if (soback) {
				soback=false;tools[5].setImageResource(R.drawable.um4);
			}else {soback=true;tools[5].setImageResource(R.drawable.um);}
			soundofback();
			break;
		case R.id.cards:
			Gallery cards=new Gallery(Main3.this);
			cards.show();
			break;
		case R.id.about:
			Aboutdialog about=new  Aboutdialog(Main3.this);
			about.show();
			break;
		/*case R.id.setbtsound:
			setsounddialog dialog=new setsounddialog(Main3.this);
			dialog.show();
			break;
		case R.id.btnsetfont:
			SetfontDialog fontdiaog=new SetfontDialog(Main3.this);
			fontdiaog.show();
			fontdiaog.setOnDismissListener(new OnDismissListener() {
				
				@Override
				public void onDismiss(DialogInterface arg0) {
					// TODO Auto-generated method stub
				//	Setfont();
				}
			});
			break; */
		case R.id.setbtext:
			ColorPickerDialog color = new ColorPickerDialog(this,this, "inputbackcolor",Color.BLACK,Color.WHITE);
            color.show();
		break;
		case R.id.settextcolor:
			ColorPickerDialog fontcolor = new ColorPickerDialog(this,this, "inputfontcolor",Color.BLACK,Color.WHITE);
            fontcolor.show();
            break;
		case R.id.ques:
			if(soalison){
			soalison=false;
			tools[7].setImageResource(R.drawable.cal);}
			else{soalison=false;
			tools[7].setImageResource(R.drawable.ques3);
			saol();}break;
		case R.id.setbcolor:
			ColorPickerDialog backgroundcolor = new ColorPickerDialog(this,this, "mainbackcolor",Color.BLACK,Color.WHITE);
            backgroundcolor.show();
            break;
		case R.id.theme:
		Themedialog theme=new Themedialog(Main3.this);
		theme.show();
		theme.setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss(DialogInterface arg0) {
				// TODO Auto-generated method stub
			settheme(themeid);
			setthemeop(themeopid);
			}
		});
		
		default:
			break;
		}
	}
	
	
	private void addtoadadarray(String str, int i) {
		// TODO Auto-generated method stub
		if (num>0) {
			num-=1;
			if(newline) input.append("\n"+str);
			else
					input.append(str);scrull();
		temp=temp+endigit[i];
		if ((oprationset)||clear2) {adad.add(temp);}
		else	adad.set(adad.size()-1, temp);
		 newline=clear2=clear3=false; oprationset=false;}
	}
	
	private void scrull() {
		// TODO Auto-generated method stub
		 int scroll_amount = input.getBottom();
		    input.scrollTo(0, scroll_amount);
	}
	
	private void addtooparray2(String str) {
		// TODO Auto-generated method stub
		if ((!oprationset)&&(!clear2)&&(!clear3)&&(!newline)) { 
			if (str=="*")  input.append("×");else
			if (str=="/")  input.append("÷");else
			input.append(str);
			scrull();
			oprationset=true;
			temp="";	num=12;dot=false;op.add(str);
			}else
		if ((clear2)||(clear3)||(newline)) {
			if (newline) {
			input.append("\n-");newline=false;
			}else input.append(str);
			signe=true;
			scrull();
			oprationset=true;
			temp="";	num=12;dot=false;op.add(str);
		}
			
			
	}
	private Boolean lastisoprator(String str) {
		// TODO Auto-generated method stub
		 char[] s=str.toCharArray();
		 char last=s[s.length-1];

			if ((last=='+')||(last=='-')||(last=='×')||(last=='÷'))
		{
			return true;
		}else return false;
	}
	
	private Boolean lastisdigit(String str) {
			char[] s=str.toCharArray();
		 char last=s[s.length-1];
		 char[] en={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		 char[] farsi={'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};
		 for (int i = 0; i < farsi.length; i++) {
			if (last==farsi[i])
				return true;
		}
		 for (int i = 0; i < en.length; i++) {
				if (last==en[i])
					return true;
			}
		 if (last=='.') {
			dot=false;
			return true;
		}
		 return false;
	}
	
	private void calculate() {
		// TODO Auto-generated method stub
		int m=0;
		Double r,n;
		r=Double.parseDouble(adad.get(0));
		if (signe){r=-1*r;m=1;}
		for (int i = 1; i < adad.size(); i++) {
			n=Double.parseDouble(adad.get(i));
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
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(12);
        
		String temp2=df.format(r);
 	//	temp2 = removeUnwantedValueInDecimal(temp2);
 	/*	if(slang)
 			temp2=settextlang(temp2);*/
		
		temp2=setzero(temp2);
    	 input.append(temp2);scrull();
		op.removeAll(op);
		adad.removeAll(adad);
		newline=true;
		
	}
	
	
	 private String setzero(String temp22) {
		 if (temp22.indexOf('.')==0)
				temp22="0"+temp22;
				return temp22;
	}
	private String settextlang(String temp22) {
		// TODO Auto-generated method stub
		 //char[] temp3=temp22.toCharArray();
		/* char[] farsi={'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹','.','-'};
		 char[] en={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','.','-'};
		 String m="";
		 for (int j = 0; j < temp3.length; j++) {
			for (int i = 0; i < en.length; i++) {
			if (temp3[j]==en[i]) {
					m+=farsi[i];break;
			}
		}
		}*/
	if (temp22.lastIndexOf('.')==0)
		temp22="0"+temp22;
	
	//temp22=temp22.substring(0, i-1)+"/"+temp22.substring(i+1, temp22.length());
	/*	 for (int i = 0; i < temp3.length; i++) {
			 if (temp3[i]=='.') {temp3[i]='/';}
		}*/
		 
		return temp22;
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
	
	private void addtoinput(String string, int i) {
		// TODO Auto-generated method stub
		if(!soalison){
			if(sb)
			 setsoundlang(i);
			 if (slang){font =Typeface.createFromAsset(getAssets(),"font/arial.otf");
				 addtoadadarray(persianNumbers[i],i);input.setTypeface(font);}
			 else {addtoadadarray(string,i);input.setTypeface(Typeface.SERIF);}
			 }else{
				 if (sp != null) {
			          
			           sp  = null;}
			if(random2==i){ sp = MediaPlayer.create(Main3.this, R.raw.carrect2);
				}else
					 sp = MediaPlayer.create(Main3.this, R.raw.fail);
			sp.setOnCompletionListener(new OnCompletionListener() {
				 
		        @Override
		        public void onCompletion(MediaPlayer sp) {
		            // TODO Auto-generated method stub
		            sp.release();saol();
		        }
		    }); 
			sp.start(); }
	}
	private void setsoundlang(int i) {
		// TODO Auto-generated method stub
		if (mp != null) {
	          
	           mp  = null;}
		if (slang) {
			switch (i) {
			case 1:
				mp = MediaPlayer.create(Main3.this, R.raw.f1);
				break;
			case 2:
				mp = MediaPlayer.create(Main3.this, R.raw.f2);
				break;
			case 3:
				mp = MediaPlayer.create(Main3.this, R.raw.f3);
				break;
			case 4:
				mp = MediaPlayer.create(Main3.this, R.raw.f4);
				break;
			case 5:
				mp = MediaPlayer.create(Main3.this, R.raw.f5);
				break;
			case 6:
				mp = MediaPlayer.create(Main3.this, R.raw.f6);
				break;
			case 7:
				mp = MediaPlayer.create(Main3.this, R.raw.f7);
				break;
			case 8:
				mp = MediaPlayer.create(Main3.this, R.raw.f8);
				break;
			case 9:
				mp = MediaPlayer.create(Main3.this, R.raw.f9);
				break;
			case 0:
				mp = MediaPlayer.create(Main3.this, R.raw.f0);
				break;
			default:
				break;
			}
			
		}else{
			switch (i) {
			case 1:
				mp = MediaPlayer.create(Main3.this, R.raw.e1);
				break;
			case 2:
				mp = MediaPlayer.create(Main3.this, R.raw.e2);
				break;
			case 3:
				mp = MediaPlayer.create(Main3.this, R.raw.e3);
				break;
			case 4:
				mp = MediaPlayer.create(Main3.this, R.raw.e4);
				break;
			case 5:
				mp = MediaPlayer.create(Main3.this, R.raw.e5);
				break;
			case 6:
				mp = MediaPlayer.create(Main3.this, R.raw.e6);
				break;
			case 7:
				mp = MediaPlayer.create(Main3.this, R.raw.e7);
				break;
			case 8:
				mp = MediaPlayer.create(Main3.this, R.raw.e8);
				break;
			case 9:
				mp = MediaPlayer.create(Main3.this, R.raw.e9);
				break;
			case 0:
				mp = MediaPlayer.create(Main3.this, R.raw.e0);
				break;
			default:
				break;
			}
		}
		mp.setOnCompletionListener(new OnCompletionListener() {
			 
	        @Override
	        public void onCompletion(MediaPlayer mp) {
	            // TODO Auto-generated method stub
	            mp.release();
	        }
	    }); 
		mp.start();
	}
	
	
	private void saol() {
		// TODO Auto-generated method stub
			
		Random rand=new Random();
		 random2=rand.nextInt(10);
		 setsoundlang(random2);
		 soalison=true;
	}
	/*private void setspound(int soundid2) {
		// TODO Auto-generated method stub
		switch (soundid2) {
		case 0:
			
			break;

		default:
			break;
		}
	}*/
	private void soundofback() {
		// TODO Auto-generated method stub
		if(soback){
			 
			 mback.setOnCompletionListener(new OnCompletionListener() {
				 
			        @Override
			        public void onCompletion(MediaPlayer mp) {
			            // TODO Auto-generated method stub
			            mp.release();
			        }
			    }); 
			 try {
                 mback.prepare();
             } catch (IllegalStateException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
			 mback.setLooping(true);
			 mback.start();}else{ mback.pause();}
	}
	private void stopPlaying() {
        if (mback != null) {
           mback.stop();
           mback.release();
           mback  = null;}
                    
   }
	
	public static int getScreenWidth() {
	    return Resources.getSystem().getDisplayMetrics().widthPixels;
	}

	public static int getScreenHeight() {
	    return Resources.getSystem().getDisplayMetrics().heightPixels;
	}
	
	private void stopbtnsound() {
		// TODO Auto-generated method stub
		 if (mp != null) {
	          
	           mp  = null;}
	}
	private void soundofbutten() {
		// TODO Auto-generated method stub
		
		if (sb) {sb=false;tools[6].setImageResource(R.drawable.mut2);	}
		
		else{sb=true;tools[6].setImageResource(R.drawable.unmut2);}
		/*if(sb) {stopbtnsound();
			switch (soundid) {
			case R.id.zang1:
				 mp = MediaPlayer.create(Main3.this, R.raw.seven);
				break;
			case R.id.zang2:
				 mp = MediaPlayer.create(Main3.this, R.raw.light_switch_on);
				 break;
			case R.id.zang3:
				 mp = MediaPlayer.create(Main3.this, R.raw.light_switch_off);
				 break;
			default:
				break;
			}
		
		 mp.setOnCompletionListener(new OnCompletionListener() {
			 
		        @Override
		        public void onCompletion(MediaPlayer mp) {
		            // TODO Auto-generated method stub
		            mp.release();
		        }
		    }); 
		    mp.start();
    }*/
   
	}
	private void swichlang() {
		// TODO Auto-generated method stub
		if (slang) {
			for (int i = 0; i < 10; i++) {
				buttons[i].setText(persianNumbers[i]);
			}
			}
			else
				for (int i = 0; i < 10; i++) {
					buttons[i].setText(endigit[i]);
				}
		if (soalison) {
			saol();
		}
	}
	@Override
	public void colorChanged(String key, int color) {
		// TODO Auto-generated method stub
		if(key=="inputbackcolor")
		input.setBackgroundColor(color);
		else if(key=="inputfontcolor")
			input.setTextColor(color);
		else if(key=="mainbackcolor"){
			LinearLayout main=(LinearLayout) findViewById(R.id.main);
			main.setBackgroundColor(color);
		}
		
	}
	
	
	public void onBackPressed() {
		 
		
		exit();
		
	 }
	
	 @Override
	    protected void onPause() {
		 
	        super.onPause();
	        if (mback != null) {
	            mback.stop();
	            mback.release();
	            mback  = null;}
		 mp.release();
		 sp.release();
	        }
	
	private void exit() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				Main3.this);
				
				alertDialog.setTitle(R.string.exit);
				alertDialog.setMessage(R.string.mayel);

				
				alertDialog.setPositiveButton(R.string.yes,
				new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					 if (mback != null) {
				            mback.stop();
				            mback.release();
				            mback  = null;}
					 mp.release();
					 sp.release();
				finish();
				}
				});
				alertDialog.setNegativeButton(R.string.no2,
				new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {

				dialog.cancel();
				}
				});
			
				alertDialog.show();
	}	
}
