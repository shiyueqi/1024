package com.unionpay.algorithm.common;

/**
 * date: 2017/05/09 14:53.
 * author: Yueqi Shi
 */
public enum InputType {
    /**
     * 小键盘以5为中心，8为上
     */
    UP(8, "up"),

    /**
     * 小键盘以5为中心，2为上
     */
    DOWN(2, "down"),

    /**
     * 小键盘以5为中心，4为上
     */
    LEFT(4, "left"),

    /**
     * 小键盘以5为中心，6为上
     */
    RIGHT(6, "right"),

    EXIT(0, "exit");

    private int command;

    private String desc;

    private InputType(int command, String desc) {
        this.command = command;
        this.desc = desc;
    }

    public static InputType getInputType(int command) {
        final InputType[] inputTypes = InputType.values();

        for (InputType inputType : inputTypes) {
            if (inputType.command == command) {
                return inputType;
            }
        }

        return null;
    }

    public int getCommand() {
        return command;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "InputType{" +
                "command=" + command +
                ", desc='" + desc + '\'' +
                '}';
    }
}
