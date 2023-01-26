package com.noah.solo.global.util;

import java.util.Random;

public class RandomUtil {

    public static Integer generateAuth6Number() {
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());
        return generator.nextInt(1000000) % 1000000;
    }

}
