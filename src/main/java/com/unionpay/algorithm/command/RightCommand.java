package com.unionpay.algorithm.command;

import com.unionpay.algorithm.common.InputType;
import com.unionpay.algorithm.numstable.NumsTable;

/**
 * date: 2017/05/09 15:11.
 * author: Yueqi Shi
 */
public class RightCommand extends AbstractCommand {

    @Override
    public void doExecuteCommand() {
        int[][] nums = NumsTable.getNumsTable();
        for (int i = 0; i < NumsTable.NUMS_TABLE_SIZE; i++) {
            int zeroCount = 0;
            for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                if (nums[i][j] == 0) {
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
                    if (nums[i][j] != 0) {
                        first = j;
                        break;
                    }
                }

                int firstValue = nums[i][first];

                nums[i][first] = 0;

                nums[i][3] = firstValue;
            }

            //两个不为0
            if (zeroCount == 2) {
                int first = -1;
                int second = -1;
                for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                    if (nums[i][j] != 0) {
                        if (first == -1) {
                            first = j;
                        } else {
                            second = j;
                        }
                    }
                }

                if (nums[i][first] == nums[i][second]) {
                    int firstValue = nums[i][first];

                    nums[i][first] = 0;
                    nums[i][second] = 0;

                    nums[i][3] = firstValue * 2;
                } else {
                    int firstValue = nums[i][first];
                    int secondValue = nums[i][second];

                    nums[i][first] = 0;
                    nums[i][second] = 0;

                    nums[i][3] = firstValue;
                    nums[i][2] = secondValue;
                }
            }

            //三个不为0
            if (zeroCount == 1) {
                int first = -1;
                int second = -1;
                int third = -1;
                for (int j = NumsTable.NUMS_TABLE_SIZE - 1; j >= 0; j--) {
                    if (nums[i][j] != 0) {
                        if (first == -1) {
                            first = j;
                        } else if (second == -1) {
                            second = j;
                        } else {
                            third = j;
                        }
                    }
                }

                if (nums[i][first] == nums[i][second]) {
                    int firstValue = nums[i][first];
                    int thirdValue = nums[i][third];

                    nums[i][first] = 0;
                    nums[i][second] = 0;
                    nums[i][third]= 0;

                    nums[i][3] = firstValue * 2;
                    nums[i][2] = thirdValue;
                } else if (nums[i][second] == nums[i][third]) {
                    int firstValue = nums[i][first];
                    int thirdValue = nums[i][third];

                    nums[i][first] = 0;
                    nums[i][second] = 0;
                    nums[i][third] = 0;

                    nums[i][3] = firstValue;
                    nums[i][2] = thirdValue * 2;
                } else {
                    int firstValue = nums[i][first];
                    int secondValue = nums[i][second];
                    int thirdValue = nums[i][third];

                    nums[i][first] = 0;
                    nums[i][second] = 0;
                    nums[i][third] = 0;

                    nums[i][3] = firstValue;
                    nums[i][2] = secondValue;
                    nums[i][1] = thirdValue;
                }
            }

            //均不为0
            if (zeroCount == 0) {
                if (nums[i][3] == nums[i][2] && nums[i][1] == nums[i][0]) {
                    nums[i][3] = nums[i][3] * 2;
                    nums[i][2] = nums[i][1] * 2;

                    nums[i][1] = 0;
                    nums[i][0] = 0;
                } else if (nums[i][3] == nums[i][2] && nums[i][1] != nums[i][0]) {
                    nums[i][3] = nums[i][3] * 2;
                    nums[i][2] = nums[i][1];
                    nums[i][1] = nums[i][0];

                    nums[i][0] = 0;
                } else if (nums[i][3] != nums[i][2] && nums[i][2] == nums[i][1]) {
                    nums[i][2] = nums[i][2] * 2;
                    nums[i][1] = nums[i][0];

                    nums[i][0] = 0;
                } else if (nums[i][3] != nums[i][2] && nums[i][2] != nums[i][1] && nums[i][1] == nums[i][0]) {
                    nums[i][1] = nums[i][1] * 2;

                    nums[i][0] = 0;
                }
            }
        }
    }

    public InputType getInputType() {
        return InputType.RIGHT;
    }
}