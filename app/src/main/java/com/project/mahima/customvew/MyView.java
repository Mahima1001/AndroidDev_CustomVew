package com.project.mahima.customvew;

import android.content.Context;
import android.widget.EditText;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.widget.EditText;
/**
 * Created by mahima on 10/11/16.
 */
public class MyView extends EditText{

    private Paint paint;
    private int dx, dy, cx, cy, rad = 30;

    public MyView(Context context) {
        super(context);

        createThread();
        initPaint();

    }

    private final void initPaint(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(cx,cy,rad,paint);

    }

    private final void createThread(){

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        while(true){

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(cx >= getWidth()) dx = -5;
                            if(cx <= 0 ) dx = 5;
                            if(cy >= getHeight()) dy = -5;
                            if(cy <= 0 ) dy = 5;

                            cx += dx;
                            cy += dy;
                        }
                    }
                }
        ).start();
    }
}
