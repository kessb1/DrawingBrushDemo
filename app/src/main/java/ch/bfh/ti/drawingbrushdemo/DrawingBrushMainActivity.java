/*
 ***************************************************************************
 * \brief   Embedded-Android (BTE5484-FS19)
 *
 * 			Drawing Brush Application.
 * 		    This Demo-App shows how to create a finger-painting app for
 * 		    Android using touch interaction
 *	       	Draw anything on the screen just by touching and move your finger.
 *	        Clear your screen by pressing the “Clear Screen” button.
 *	        In this App the buttons are programmatically added to the layout
 *          
 * \file    DrawingBrushMainActivity.java
 * \version 1.0
 * \date    24.01.2014
 *
 * \remark  Last Modifications:
 * \remark  V1.0, AOM1, 24.01.2014   Initial release
 ***************************************************************************/

package ch.bfh.ti.drawingbrushdemo;

import android.os.Bundle;
import android.app.Activity;

// Start the main activity
public class DrawingBrushMainActivity extends Activity
 {
  @Override
  public void onCreate(Bundle savedInstanceState)
   {
	super.onCreate(savedInstanceState);

	/*
	*
	*
	*
	*   HALLLO BENI
	*
	*
	*
	*
	*
	*
	*
	*
	*
	*
	* */






	/* Create new drawing brush event view instance */
	DrawingBrushTouchEventView tv = new DrawingBrushTouchEventView(this);

	/* Set display background color to black */
	tv.setBackgroundColor(getResources().getColor(R.color.black));
	setContentView(tv);
	addContentView(tv.actionLayout,tv.layParam);
 }

 @Override
 protected void onPause()
  {
   // TODO Auto-generated method stub
   super.onPause();
   finish();
  }

  private void HalloBeni(int beni){

  	int hallo = beni;

  	/* Kommentar */

  }
 }
