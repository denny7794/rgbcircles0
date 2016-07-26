package com.denny7794.rgbcircles;

import java.util.Random;

/**
 * Created by Denis on 26.07.2016.
 */
public class EnemyCircle extends SimpleCircle{

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 15;

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }


    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y , radius);
        return enemyCircle;
    }
}
