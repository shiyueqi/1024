package com.unionpay.algorithm;

import com.unionpay.algorithm.common.InputType;
import com.unionpay.algorithm.command.Command;
import com.unionpay.algorithm.command.CommandFactory;
import com.unionpay.algorithm.util.LogUtil;

import java.util.Scanner;

/**
 * date: 2017/05/09 14:44.
 * author: Yueqi Shi
 */
public class Algorithm1024 {


    /**
     * start algorithm
     */
    public void start() {
        LogUtil.logNumsTable();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            LogUtil.logScannerPrompt();

            int command = scanner.nextInt();
            InputType inputType = InputType.getInputType(command);
            if (inputType == null) {
                LogUtil.logErrorInput(command);
                continue;
            } else if (inputType.equals(InputType.EXIT)) {
                System.exit(0);
            }

            LogUtil.logInput(inputType);

            Command commandObj = CommandFactory.getCommand(inputType);
            commandObj.executeCommand();
        }
    }

    public static void main(String[] args) {
        Algorithm1024 algorithm1024 = new Algorithm1024();
        algorithm1024.start();
    }
}
