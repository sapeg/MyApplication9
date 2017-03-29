package com.example.sapeg.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.speech.tts.TextToSpeech;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by sapeg on 27.02.2017.
 */

public class MyDraw extends View {

    private Button mButton;
    private TextToSpeech mTTS;

    private Paint paint = new Paint();
    Paint p;
    Bitmap bitmap1, bitmap2;
    Rect rect;
    int x1 = 70, y1 = 20;



    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
        rect = new Rect();
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.k_w_33x33);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.k_b_33x33);

    }
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            invalidate();
        }
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Здесь рисуем, что надо.

        canvas.drawColor(Color.GREEN);
        p.setColor(Color.WHITE);

        // толщина линии = 10
        p.setStrokeWidth(11);

        // создание игровой доски
        //x=70;y=20...x=470;y=420
        int a = 0;
        int c = 0;
        int b1 = 0;
        int b2 = 0;
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {

                a = a + 50;
                b1 = i % 2;
                b2 = j % 2;
                if ((b1 == 0 & b2 == 0) | (b1 != 0 & b2 != 0)) {
                    p.setColor(Color.BLACK);
                } else {
                    p.setColor(Color.WHITE);
                }
                canvas.drawRect(20 + a, 20 + c, 70 + a, 70 + c, p);
            }
            a = 0;
            c = c + 50;
        }


        for (int i = 1; i < 2; i++) {
            Random random = new Random();

            int s;
            s = (random.nextInt(9) + 1);

            if (s == 1) {
                x1 = x1 - 50;
                y1 = y1 - 50;
            }
            if (s == 2) {
                y1 = y1 - 50;
            }
            if (s == 3) {
                x1 = x1 + 50;
                y1 = y1 - 50;
            }
            if (s == 4) {
                x1 = x1 - 50;
                y1 = y1;
            }
            if (s == 5) {
                x1 = x1;
                y1 = y1;
            }
            if (s == 6) {
                x1 = x1 + 50;
                y1 = y1;
            }
            if (s == 7) {
                x1 = x1 - 50;
                y1 = y1 + 50;
            }
            if (s == 8) {
                x1 = x1;
                y1 = y1 + 50;
            }
            if (s == 9) {
                x1 = x1 + 50;
                y1 = y1 + 50;
            }
            if (x1 < 70) x1 = x1 + 100;
            if (y1 < 20) y1 = y1 + 100;
            if (x1 >= 470) x1 = x1 - 100;
            if (y1 >= 420) y1 = y1 - 100;


            canvas.drawBitmap(bitmap1, x1, y1, paint);

            char xcoord = 0;
            int ycoord = 0;
            if (x1 == 70) xcoord = 'a';
            if (x1 == 70 + 50) xcoord = 'b';
            if (x1 == 70 + 50 * 2) xcoord = 'c';
            if (x1 == 70 + 50 * 3) xcoord = 'd';
            if (x1 == 70 + 50 * 4) xcoord = 'e';
            if (x1 == 70 + 50 * 5) xcoord = 'f';
            if (x1 == 70 + 50 * 6) xcoord = 'g';
            if (x1 == 70 + 50 * 7) xcoord = 'h';

            if (y1 == 20) ycoord = 1;
            if (y1 == 20 + 50) ycoord = 2;
            if (y1 == 20 + 50 * 2) ycoord = 3;
            if (y1 == 20 + 50 * 3) ycoord = 4;
            if (y1 == 20 + 50 * 4) ycoord = 5;
            if (y1 == 20 + 50 * 5) ycoord = 6;
            if (y1 == 20 + 50 * 6) ycoord = 7;
            if (y1 == 20 + 50 * 7) ycoord = 8;

        }

    }

}

