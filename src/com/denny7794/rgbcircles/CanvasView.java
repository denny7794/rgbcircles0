package com.denny7794.rgbcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Denis on 25.07.2016.
 */
public class CanvasView extends View implements ICanvasView{
    private static int width;
    private static int height;
    private GameManager gameManager;
    private Paint paint;
    private Canvas canvas;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidthAndHeight(context);
        initPaint();
        gameManager = new GameManager(this, width, height);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initWidthAndHeight(Context context) {
        WindowManager  windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        //Point point = new Point();
        width = display.getWidth();
        height = display.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //gameManager.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            gameManager.onTouchEvent(x, y);
        }
        invalidate();
        return true;
    }
}
