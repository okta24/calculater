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
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Aboutdialog  extends Dialog implements
    android.view.View.OnClickListener {

  public Aboutdialog(Activity a) {
		super(a);
		this.c=a;
		// TODO Auto-generated constructor stub
	}

public Activity c;
  public Dialog d;
  public Button close;
  ImageButton nazar; 
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.about);
  
    close=(Button)findViewById(R.id.ok);
    nazar=(ImageButton)findViewById(R.id.nazar);
    TextView txt=(TextView) findViewById(R.id.txtabout);
    
    txt.setText(R.string.darbareh);
    close.setOnClickListener(this);
    nazar.setOnClickListener(this);
      }

  private void comment() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_EDIT); 
		intent.setData(Uri.parse("bazaar://details?id=" +  "com.example.shah1")); 
		intent.setPackage("com.farsitel.bazaar"); 
		c.startActivity(intent); 
		dismiss();
	}
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	switch (arg0.getId()) {
	case R.id.ok:
		dismiss();
		break;
	case R.id.nazar:
		comment();
	default:
		break;
	}
	
}
}
