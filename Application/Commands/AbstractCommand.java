
package com.company.Application.Commands;

import java.io.IOException;

/**
 * designate all Commands interface
 */
abstract public class AbstractCommand {

    protected ControllersProvider controllersProvider;

    public AbstractCommand(ControllersProvider controllersProvider) {
        this.controllersProvider = controllersProvider;
    }

    /**
     * executes command
     * @param args String[]
     */
    abstract void execute(String[] args) throws IOException;

    /**
     * checks if arguments are correct for
     * @param args String[]
     * @return boolean
     */
    abstract boolean argsIsCorrect(String[] args);

    /**
     * print info about command
     */
    abstract void getInfo();
}
