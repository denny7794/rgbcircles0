package com.denny7794.rgbcircles;

/**
 * Created by Denis on 25.07.2016.
 */
public interface ICanvasView {
    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String text);

    //void redraw();
}
