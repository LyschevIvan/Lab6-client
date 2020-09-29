
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

/**
 * saves collection to file
 */
class Save extends AbstractCommand {
    public Save(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException {
//        Data data = new Data(args);
//        controllersProvider.getClientController().sendData(data);
//        controllersProvider.getXmlController().convertToXml(controllersProvider.getTreeMapController());
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("save : сохраняет коллекцию в файл");
    }
}
