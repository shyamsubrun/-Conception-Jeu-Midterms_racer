package com.example.tp5b_u21987540;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Plateau extends View {

    private final float MAX_X = 478;
    private final float MAX_Y = 772f;
    private float w,h;


    private Paint paint;
    private Paint paint_RED,paint_BLUE;


    private float[][] points;
    private float ray;
    private int red_loc = 0,blue_loc = 1;



    public Plateau(Context context) {
        super(context);
        paint = new Paint();
        paint_RED = new Paint();
        paint_RED.setColor(Color.RED);
        paint_BLUE = new Paint();
        paint_BLUE.setColor(Color.BLUE);
        paint.setColor(Color.BLACK);

    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        points = computeCenters();
        ray = computeRadius();
        canvas.drawLine(0, 772 / 2, 800, 772 / 2, paint);
             for(int i = 0;i < points.length;i++){
            if(i == red_loc)
                canvas.drawCircle(points[i][0],points[i][1],ray,paint_RED);
            else if(i == blue_loc)
                canvas.drawCircle(points[i][0],points[i][1],ray,paint_BLUE);
            else
                canvas.drawCircle(points[i][0],points[i][1],ray,paint);
        }

    }
        private float [ ] [ ] computeCenters() {
            float [ ] [ ] centers = new float [ 20 ] [ 2 ] ;
            float w = getWidth ( ) , h = getHeight ( ) ;
            for ( int i = 0 ; i <20; i ++){
                centers [ i ] [ 0 ] = ( ( i %5) + 1 )*w/ 6;
                centers [ i ] [ 1 ] = ( i /5 + 1 )*h/ 5;
            }
            return centers ;
        }

/*  canvas.drawCircle(points[i][0],points[i][1],ray,paint_BLUE);
    canvas.drawCircle(points[i][0],points[i][1],ray,paint_RED);

 */

        private float computeRadius () {
            return Math .min(getWidth(),getHeight())/20;}























    @Override
    public boolean onTouchEvent (MotionEvent e) {
        switch ( e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                h = e.getY();
                if(h < MAX_Y/2) {
                    red_loc++;
                    if (red_loc > 20)
                        red_loc = 0;
                    if(red_loc == blue_loc){
                        Toast.makeText(getContext(),"Les Républicains contrôlent le Sénat !!!",
                                Toast. LENGTH_SHORT).show();
                        red_loc =0;blue_loc=5;
                    }
                }
                else if(h > MAX_Y/2){
                    blue_loc++;
                    if(blue_loc > 20)
                        blue_loc = 0;
                    if(blue_loc == red_loc){
                        Toast.makeText(getContext(),"Les Démocrates contrôlent le Sénat !!!",
                                Toast. LENGTH_SHORT).show();
                        red_loc =0;blue_loc=1;
                    }

                }
            case MotionEvent.ACTION_UP:
                //w = e.getX();


            case MotionEvent.ACTION_MOVE:

        }
        invalidate();
        return true;
    }

}
