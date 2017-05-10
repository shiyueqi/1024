package com.unionpay.algorithm.command;

import com.unionpay.algorithm.common.InputType;

/**
 * date: 2017/05/09 15:25.
 * author: Yueqi Shi
 */
public class CommandFactory {

    private static final Command upCommand = new UpCommand();
    private static final Command downCommand = new DownCommand();
    private static final Command leftCommand = new LeftCommand();
    private static final Command rightCommand = new RightCommand();

    public static Command getCommand(InputType inputType) {
        if (inputType.getCommand() == InputType.UP.getCommand()) {
            return upCommand;
        } else if (inputType.getCommand() == InputType.DOWN.getCommand()) {
            return downCommand;
        } else if (inputType.getCommand() == InputType.LEFT.getCommand()) {
            return leftCommand;
        } else if (inputType.getCommand() == InputType.RIGHT.getCommand()) {
            return rightCommand;
        } else {
            return null;
        }
    }

}
