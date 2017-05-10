package com.unionpay.algorithm.command;

import com.unionpay.algorithm.numstable.NumsTable;
import com.unionpay.algorithm.util.LogUtil;

/**
 * date: 2017/05/09 15:08.
 * author: Yueqi Shi
 */
public abstract class AbstractCommand implements Command {

    public AbstractCommand() {
    }

    public void executeCommand() {
        this.doExecuteCommand();
        NumsTable.insertNewNumNode(Boolean.FALSE);
        LogUtil.logNumsTable();
    }

    public abstract void doExecuteCommand();

}
