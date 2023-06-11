
package com.Shahruie.calculator;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ViewFlipper;

public class Gallery  extends Dialog implements
    android.view.View.OnClickListener {

  public Gallery(Activity a) {
		super(a);
		this.c=a;
		// TODO Auto-generated constructor stub
	}
  private float lastX;
public Activity c;
  public Dialog d;
  public Button close;
  private ViewFlipper viewFlipper;
  int gallery_grid_Images[]={
		R.drawable.gallery_image_01,R.drawable.gallery_image_09 ,	R.drawable.gallery_image_08,
		R.drawable.gallery_image_07,R.drawable.gallery_image_06,R.drawable.gallery_image_05,
		R.drawable.gallery_image_04,R.drawable.gallery_image_03,
  		R.drawable.gallery_image_02,
  	};
 


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main2);
    
    viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
   
  
    close=(Button)findViewById(R.id.galleryclose);
     close.setOnClickListener(this);
    
    for(int i=0;i<gallery_grid_Images.length;i++)
    {
    //  This will create dynamic image view and add them to ViewFlipper
        setFlipperImage(gallery_grid_Images[i]);
    }
 
     
   
}
private void setFlipperImage(int res) {

    ImageView image = new ImageView(c.getApplicationContext());
    image.setScaleType(ScaleType.FIT_XY);
    image.setBackgroundResource(res);
    viewFlipper.addView(image);
}
// Using the following method, we will handle all screen swaps.
public boolean onTouchEvent(MotionEvent touchevent) {
switch (touchevent.getAction()) {

case MotionEvent.ACTION_DOWN: 
	lastX = touchevent.getX();
    break;
case MotionEvent.ACTION_UP: 
    float currentX = touchevent.getX();
    
    // Handling left to right screen swap.
    if (lastX < currentX) {
    	
    	// If there aren't any other children, just break.
        if (viewFlipper.getDisplayedChild() == 0)
        	break;
        //m=viewFlipper.getDisplayedChild();
        // Next screen comes in from left.
      //  viewFlipper.stopFlipping();
        viewFlipper.setInAnimation(c, R.anim.slide_in_from_left);
        // Current screen goes out from right. 
        viewFlipper.setOutAnimation(c, R.anim.slide_out_to_right);
        
        // Display next screen.
        viewFlipper.showNext();
   //     viewFlipper.startFlipping();
     }
                             
    // Handling right to left screen swap.
     if (lastX > currentX) {
    	 
    	 // If there is a child (to the left), kust break.
    	 if (viewFlipper.getDisplayedChild() == 1)
    		 break;
    	 // Next screen comes in from right.
    	 viewFlipper.setInAnimation(c, R.anim.slide_in_from_right);
    	// Current screen goes out from left. 
    	 viewFlipper.setOutAnimation(c, R.anim.slide_out_to_left);
         
    	// Display previous screen.
         viewFlipper.showPrevious();
     }
     break;
 }
 return false;
 
}
    
      


@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	dismiss();
	
}
}
