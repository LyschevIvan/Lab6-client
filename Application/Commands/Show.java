
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

/**
 * print collection content to System.out
 */
class Show extends AbstractCommand {
    public Show(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException {
//        controllersProvider.getTreeMapController().forEach((k,v)->System.out.println(k +" " + v.toString()));
        Data data = new Data(args);
        controllersProvider.getClientController().sendData(data);

    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("show : выводит элементы коллекции");
    }
}
