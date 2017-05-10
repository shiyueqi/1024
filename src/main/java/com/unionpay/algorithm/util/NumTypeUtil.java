package com.unionpay.algorithm.util;

import com.unionpay.algorithm.common.NumType;
import com.unionpay.algorithm.numstable.NumsTable;

import java.util.Random;

/**
 * date: 2017/05/09 15:59.
 * author: Yueqi Shi
 */
public class NumTypeUtil {

    private static final Random random = new Random();

    public static NumType getRandomNumType() {
        if (random.nextInt() % 2 == 0) {
            return NumType.TWO;
        }

        return NumType.FOUR;
    }

    public static int getRandom() {
        return random.nextInt(NumsTable.NUMS_TABLE_SIZE);
    }

}
