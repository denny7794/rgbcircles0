package com.denny7794.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Denis on 25.07.2016.
 */
public class GameManager {
    private MainCircle mainCircle;
    private CanvasView canvasView;
    private static int width;
    private static int height;
    private Paint paint;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initPaint();
    }

    private void initMainCircle(){
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
