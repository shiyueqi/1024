package com.unionpay.algorithm.command;

import com.unionpay.algorithm.common.InputType;
import com.unionpay.algorithm.numstable.NumsTable;

/**
 * date: 2017/05/09 15:10.
 * author: Yueqi Shi
 */
public class DownCommand extends AbstractCommand {

    @Override
    public void doExecuteCommand() {
        int[][] nums = NumsTable.getNumsTable();
        for (int i = 0; i < NumsTable.NUMS_TABLE_SIZE; i++) {
            int zeroCount = 0;
            for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                if (nums[j][i] == 0) {
                    zeroCount++;
                }
            }

            //均为0
            if (zeroCount == 4) {
                continue;
            }

            //只有一个不为0
            if (zeroCount == 3) {
                int first = -1;
                for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                    if (nums[j][i] != 0) {
                        first = j;
                        break;
                    }
                }

                int firstValue = nums[first][i];

                nums[first][i] = 0;

                nums[3][i] = firstValue;
            }

            //两个不为0
            if (zeroCount == 2) {
                int first = -1;
                int second = -1;
                for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                    if (nums[j][i] != 0) {
                        if (first == -1) {
                            first = j;
                        } else {
                            second = j;
                        }
                    }
                }

                if (nums[first][i] == nums[second][i]) {
                    int firstValue = nums[first][i];

                    nums[first][i] = 0;
                    nums[second][i] = 0;

                    nums[3][i] = firstValue * 2;
                } else {
                    int firstValue = nums[first][i];
                    int secondValue = nums[second][i];

                    nums[first][i] = 0;
                    nums[second][i] = 0;

                    nums[3][i] = firstValue;
                    nums[2][i] = secondValue;
                }
            }

            //三个不为0
            if (zeroCount == 1) {
                int first = -1;
                int second = -1;
                int third = -1;
                for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                    if (nums[j][i] != 0) {
                        if (first == -1) {
                            first = j;
                        } else if (second == -1) {
                            second = j;
                        } else {
                            third = j;
                        }
                    }
                }

                if (nums[first][i] == nums[second][i]) {
                    int firstValue = nums[first][i];
                    int thirdValue = nums[third][i];

                    nums[first][i] = 0;
                    nums[second][i] = 0;
                    nums[third][i] = 0;

                    nums[3][i] = firstValue * 2;
                    nums[2][i] = thirdValue;
                } else if (nums[second][i] == nums[third][i]) {
                    int firstValue = nums[first][i];
                    int thirdValue = nums[third][i];

                    nums[first][i] = 0;
                    nums[second][i] = 0;
                    nums[third][i] = 0;

                    nums[3][i] = firstValue;
                    nums[2][i] = thirdValue * 2;
                } else {
                    int firstValue = nums[first][i];
                    int secondValue = nums[second][i];
                    int thirdValue = nums[third][i];

                    nums[first][i] = 0;
                    nums[second][i] = 0;
                    nums[third][i] = 0;

                    nums[3][i] = firstValue;
                    nums[2][i] = secondValue;
                    nums[1][i] = thirdValue;
                }
            }

            //均不为0
            if (zeroCount == 0) {
                if (nums[3][i] == nums[2][i] && nums[1][i] == nums[0][i]) {
                    nums[3][i] = nums[3][i] * 2;
                    nums[2][i] = nums[1][i] * 2;

                    nums[1][i] = 0;
                    nums[0][i] = 0;
                } else if (nums[3][i] == nums[2][i] && nums[1][i] != nums[0][i]) {
                    nums[3][i] = nums[3][i] * 2;
                    nums[2][i] = nums[1][i];
                    nums[1][i] = nums[0][i];

                    nums[0][i] = 0;
                } else if (nums[3][i] != nums[2][i] && nums[2][i] == nums[1][i]) {
                    nums[2][i] = nums[2][i] * 2;
                    nums[1][i] = nums[0][i];

                    nums[0][i] = 0;
                } else if (nums[3][i] != nums[2][i] && nums[2][i] != nums[1][i] && nums[1][i] == nums[0][i]) {
                    nums[1][i] = nums[1][i] * 2;

                    nums[0][i] = 0;
                }
            }
        }
    }

    public InputType getInputType() {
        return InputType.DOWN;
    }
}
