package com.Shahruie.calculator;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class setsounddialog  extends Dialog implements
    android.view.View.OnClickListener {

  public setsounddialog(Activity a) {
		super(a);
		this.c=a;
		// TODO Auto-generated constructor stub
	}

public Activity c;
  public Dialog d;
  public Button close;

 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.sofbdialog);
    RadioGroup sounds = (RadioGroup) findViewById(R.id.group1);
    close=(Button)findViewById(R.id.dialogsetsound);
    sounds.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			if (arg1==R.id.biseda) {
				Main3.sb=false;
			}else{Main3.sb=true;
		Main3.soundid=arg1;}
		}
	});
    close.setOnClickListener(this);
      }


@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	dismiss();
}
}
