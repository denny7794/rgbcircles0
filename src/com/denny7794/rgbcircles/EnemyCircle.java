package com.denny7794.rgbcircles;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Denis on 26.07.2016.
 */
public class EnemyCircle extends SimpleCircle{

    public static final int FROM_RADIUS = 5;
    public static final int TO_RADIUS = 20;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int RANDOM_SPEED = 5;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }


    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = -RANDOM_SPEED + random.nextInt(RANDOM_SPEED*2);
        int dy = -RANDOM_SPEED + random.nextInt(RANDOM_SPEED*2);
        int radius = CanvasView.recalculateRadius(FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS));
        EnemyCircle enemyCircle = new EnemyCircle(x, y , radius, dx, dy);
        return enemyCircle;
    }

    public void setEnemyOfFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)){
            setColor(Color.rgb(0, 200, 0));
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    public boolean isSmallerThan(SimpleCircle circle) {
        if (radius < circle.radius){
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }
    }
}
