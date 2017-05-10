package com.unionpay.algorithm.command;

import com.unionpay.algorithm.common.InputType;

/**
 * date: 2017/05/09 15:14.
 * author: Yueqi Shi
 */
public interface Command {
    InputType getInputType();

    void executeCommand();
}
