package com.Shahruie.calculator;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Themedialog  extends Dialog implements
    android.view.View.OnClickListener {

  public Themedialog(Activity a) {
		super(a);
		this.c=a;
		// TODO Auto-generated constructor stub
	}

public Activity c;
  public Dialog d;
  Button[] themeofop=new Button[10];
  Button[] themes=new Button[10];
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.themelayuote);
  
    themeofop[0]=(Button)findViewById(R.id.Bb);
    themeofop[1]=(Button)findViewById(R.id.Br);
    themeofop[2]=(Button)findViewById(R.id.By);
    themeofop[3]=(Button)findViewById(R.id.Bgr);
    themeofop[4]=(Button)findViewById(R.id.Bg);
    themeofop[5]=(Button)findViewById(R.id.Bf);
    themeofop[6]=(Button)findViewById(R.id.Bo);
    themeofop[7]=(Button)findViewById(R.id.Bv);
    themeofop[8]=(Button)findViewById(R.id.Bpg);
    themeofop[9]=(Button)findViewById(R.id.Bp);
    
    themes[0]=(Button)findViewById(R.id.Btblue);
    themes[1]=(Button)findViewById(R.id.Btred);
    themes[2]=(Button)findViewById(R.id.Btyellow);
    themes[3]=(Button)findViewById(R.id.Btgray);
    themes[4]=(Button)findViewById(R.id.Btgreen);
    themes[5]=(Button)findViewById(R.id.Btfiruze);
    themes[6]=(Button)findViewById(R.id.Btorange);
    themes[7]=(Button)findViewById(R.id.Btviolet);
    themes[8]=(Button)findViewById(R.id.Btporgreen);
    themes[9]=(Button)findViewById(R.id.Btpinc);

    for (int i = 0; i < themes.length; i++) {
		themes[i].setOnClickListener(this);
	}
    
    for (int i = 0; i < themeofop.length; i++) {
		themeofop[i].setOnClickListener(this);
	}
    
    
  }

 
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	switch (arg0.getId()) {
	case R.id.Btblue:
		Main3.themeid=0;	dismiss();
		break;
	case R.id.Btyellow:
		Main3.themeid=9;	dismiss();
		break;
	case R.id.Btfiruze:
		Main3.themeid=1;	dismiss();
		break;
	case R.id.Btgray:
		Main3.themeid=2;	dismiss();
		break;
	case R.id.Btgreen:
		Main3.themeid=3;	dismiss();
		break;
	case R.id.Btorange:
		Main3.themeid=4;	dismiss();
		break;
	case R.id.Btpinc:
		Main3.themeid=5;	dismiss();
		break;
	case R.id.Btporgreen:
		Main3.themeid=6;	dismiss();
		break;
	case R.id.Btred:
		Main3.themeid=7;	dismiss();
		break;
	case R.id.Btviolet:
		Main3.themeid=8;	dismiss();
		break;
		
	case R.id.Bb:
		Main3.themeopid=0;	dismiss();
		break;
	case R.id.By:
		Main3.themeopid=9;	dismiss();
		break;
	case R.id.Bf:
		Main3.themeopid=1;	dismiss();
		break;
	case R.id.Bgr:
		Main3.themeopid=2;	dismiss();
		break;
	case R.id.Bg:
		Main3.themeopid=3;	dismiss();
		break;
	case R.id.Bo:
		Main3.themeopid=4;	dismiss();
		break;
	case R.id.Bp:
		Main3.themeopid=5;	dismiss();
		break;
	case R.id.Bpg:
		Main3.themeopid=6;	dismiss();
		break;
	case R.id.Br:
		Main3.themeopid=7;	dismiss();
		break;
	case R.id.Bv:
		Main3.themeopid=8;	dismiss();
		break;
	default:
		break;
	}
	
}
}
