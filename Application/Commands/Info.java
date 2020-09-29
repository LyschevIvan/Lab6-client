
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

/**
 * shows information about collection
 */
class Info extends AbstractCommand {
    public Info(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException {
        Data data = new Data(args);
        controllersProvider.getClientController().sendData(data);
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("info : выводит информацию о коллекции");
    }
}
