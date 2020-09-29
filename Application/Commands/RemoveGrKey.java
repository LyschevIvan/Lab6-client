
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;
import java.util.Iterator;

/**
 * remove if key is greater
 */
class RemoveGrKey extends AbstractCommand {
    public RemoveGrKey(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException {
        Data data = new Data(args);
        controllersProvider.getClientController().sendData(data);
//        Integer key = Integer.valueOf(args[1]);
//        Iterator<Integer> keyIterator = controllersProvider.getTreeMapController().getKeyIterator();
//        while (keyIterator.hasNext()){
//            Integer k = keyIterator.next();
//            if(k>key)
//                keyIterator.remove();
//        }
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].matches("\\d+");

        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_greater_key key : удалить из коллекции все элементы, ключ которых превышает заданный");
    }
}
