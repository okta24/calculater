package com.Shahruie.calculator;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SetfontDialog  extends Dialog implements
    android.view.View.OnClickListener {

  public SetfontDialog(Activity a) {
		super(a);
		this.c=a;
		// TODO Auto-generated constructor stub
	}

public Activity c;
  public Dialog d;
  public Button close;
Typeface fontdigital,koodak;
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.displayfontdialog);
    RadioButton font1=(RadioButton)findViewById(R.id.font1);
    RadioButton font2=(RadioButton)findViewById(R.id.font2);
    fontdigital =Typeface.createFromAsset(c.getAssets(),"font/digital.ttf");
    font1.setTypeface(fontdigital);
    font2.setTypeface(koodak);
    koodak =Typeface.createFromAsset(c.getAssets(),"font/koodak.ttf");
    RadioGroup fonts = (RadioGroup) findViewById(R.id.groupfont);
    RadioGroup fontsizes = (RadioGroup) findViewById(R.id.fontsizegroup);
    close=(Button)findViewById(R.id.dialogsetfont);
   fonts.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
		Main3.fontid=arg1;
		}
	});
   
   fontsizes.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		Main3.fontsizeid=arg1;
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
