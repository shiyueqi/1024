package com.unionpay.algorithm.numstable;

import com.unionpay.algorithm.util.LogUtil;
import com.unionpay.algorithm.util.NumTypeUtil;

/**
 * date: 2017/05/09 19:24.
 * author: Yueqi Shi
 */
public class NumsTable {
    public static final int NUMS_TABLE_SIZE = 4;

    private final static int[][] NUMS_TABLE = new int[NUMS_TABLE_SIZE][NUMS_TABLE_SIZE];

    public NumsTable() {
    }

    static {
        insertNewNumNode(Boolean.TRUE);
    }

    public static int[][] getNumsTable() {
        return NUMS_TABLE;
    }

    /**
     * 插入新的结点
     * @param isInit 是否初始化，若初始化，插入2个结点。非初始化，插入一个结点
     */
    public static void insertNewNumNode(boolean isInit) {
        int numNodesCount = 0;
        for (int i = 0; i < NUMS_TABLE_SIZE; i++) {
            for (int j = 0; j < NUMS_TABLE_SIZE; j++) {
                if (NUMS_TABLE[i][j] != 0) {
                    numNodesCount++;
                }
            }
        }

        if (numNodesCount == NUMS_TABLE_SIZE * NUMS_TABLE_SIZE) {
            LogUtil.logNumsTableFull();
            System.exit(0);
        }

        if (isInit) {
            NUMS_TABLE[NumTypeUtil.getRandom()][NumTypeUtil.getRandom()] = NumTypeUtil.getRandomNumType().getNum();
        }

        int posX = NumTypeUtil.getRandom();
        int posY = NumTypeUtil.getRandom();
        while (NUMS_TABLE[posX][posY] != 0) {
            posX = NumTypeUtil.getRandom();
            posY = NumTypeUtil.getRandom();
        }

        NUMS_TABLE[posX][posY] = NumTypeUtil.getRandomNumType().getNum();

        LogUtil.logRandomNode(posX, posY);
    }
}
