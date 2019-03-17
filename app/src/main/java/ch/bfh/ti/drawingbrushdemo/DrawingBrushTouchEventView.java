/*
 ***************************************************************************
 * \brief   Embedded-Android (BTE5484-FS19)
 *
 * 			Drawing Brush Helper class.
 *
 * \file    DrawingBrushTouchEventView.java
 * \version 1.0
 * \date    24.01.2014
 *
 * \remark  Last Modifications:
 * \remark  V1.0, AOM1, 24.01.2014   Initial release
 ***************************************************************************/

package ch.bfh.ti.drawingbrushdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DrawingBrushTouchEventView extends View
 {
  private Paint paint = new Paint();
  private Path path = new Path();
  private Paint circlePaint = new Paint();
  private Path circlePath = new Path();

  public LinearLayout actionLayout;
  public LayoutParams layParam;
  public Button btnReset;
  public Button btnBlue;
  public Button btnGreen;
  public Button btnRed;
  public LayoutParams params;


  public DrawingBrushTouchEventView(Context context)
   {
	super(context);

	/* 
	 * Set paint attributes 
	 */
	paint.setAntiAlias(true);
	paint.setColor(Color.RED);
	paint.setStyle(Paint.Style.STROKE);
	paint.setStrokeJoin(Paint.Join.ROUND);
	paint.setStrokeWidth(15f);
		
	/*
	 * Set circle attributes
	 */
	circlePaint.setAntiAlias(true);
	circlePaint.setColor(Color.RED);
	circlePaint.setStyle(Paint.Style.STROKE);
	circlePaint.setStrokeJoin(Paint.Join.MITER);
	circlePaint.setStrokeWidth(4f);

	/*
	 * Create button
	 */
	btnReset = new Button(context);
	btnReset.setBackgroundColor(0xFFFFFFFF);
	btnReset.setText("Clear Screen");

   params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
   btnReset.setLayoutParams(params);



   btnReset.setOnClickListener(new View.OnClickListener()
   {
	   public void onClick(View v)
	   {
		   // TODO Auto-generated method stub

		   /*
			*  resets the screen
			*/
		   path.reset();

		   /*
			*  Calls the onDraw() method by invalidating the screen
			*/
		   postInvalidate();

	   }
   });

   /*
	* Create button
	*/
   btnBlue = new Button(context);
   btnBlue.setBackgroundColor(getResources().getColor(R.color.blue));
   btnBlue.setText("Blue");

   params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


   btnBlue.setLayoutParams(params);

   btnBlue.setOnClickListener(new View.OnClickListener()
   {
	   public void onClick(View v)
	   {
		   // TODO Auto-generated method stub
		   paint.setColor(Color.BLUE);
	   }
   });

	   btnGreen = new Button(context);
	   btnGreen.setBackgroundColor(getResources().getColor(R.color.green));
	   btnGreen.setText("Green");

	   params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


	   btnGreen.setLayoutParams(params);

	   btnGreen.setOnClickListener(new View.OnClickListener()
	   {
		   public void onClick(View v)
		   {
			   // TODO Auto-generated method stub
			   paint.setColor(Color.GREEN);
		   }
	   });

	   btnRed = new Button(context);
	   btnRed.setBackgroundColor(getResources().getColor(R.color.red));
	   btnRed.setText("Red");

	   params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


	   btnRed.setLayoutParams(params);

	   btnRed.setOnClickListener(new View.OnClickListener()
	   {
		   public void onClick(View v)
		   {
			   // TODO Auto-generated method stub
			   paint.setColor(Color.RED);
		   }
	   });

	   actionLayout = new LinearLayout(context);
	   layParam=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	   actionLayout.addView(btnReset);
	   actionLayout.addView(btnBlue);
	   actionLayout.addView(btnGreen);
	   actionLayout.addView(btnRed);

  }

  @Override
  protected void onDraw(Canvas canvas)
   {
	canvas.drawPath(path, paint);
	canvas.drawPath(circlePath, circlePaint);
   }

  @Override
  public boolean onTouchEvent(MotionEvent event)
   {
	/*
	 *  Gives you x and y coordinates on the Event.
	 */
	float pointX = event.getX();
	float pointY = event.getY();

	/*
	 *  Checks for the event that occurs
	 */
	switch (event.getAction())
	 {
	  case MotionEvent.ACTION_DOWN:
		path.moveTo(pointX, pointY);
	  return true;
	  
	  case MotionEvent.ACTION_MOVE:
		path.lineTo(pointX, pointY);
		circlePath.reset();

		/*
		 *  (circle's center x-coordinate, y-coordinate, radius of the circle, direction to wind the shape)
		 */
		circlePath.addCircle(pointX, pointY, 30, Path.Direction.CW);
	   break;

	   case MotionEvent.ACTION_UP:
		circlePath.reset();
	   break;
	  
	   default:
		return false;
	  }

	/*
	 *  Schedules a repaint. Force a view to draw.
	 */
	postInvalidate();
	return true;
   }
 }
