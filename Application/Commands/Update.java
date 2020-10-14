
package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.Exceptions.NoConnectionException;
import com.company.Application.ProductClasses.Product;

import java.io.IOException;
import java.util.Arrays;

/**
 * uses to change value by key in collection
 */
class Update extends AbstractCommand {
    public Update(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException, ClassNotFoundException, NoConnectionException {
        int key = Integer.parseInt(args[1]);
        Data data = new Data(args);
        controllersProvider.getClientController().sendData(data);
        Data updating = controllersProvider.getClientController().receiveAndGetData();
        if (updating.getProduct()!= null) {
            Product updated = controllersProvider.getInputReader().updateProduct(updating.getProduct());
            Data response = new Data(args,key, updated);
            controllersProvider.getClientController().sendData(response);
            controllersProvider.getClientController().receiveData();
        }
        else {
            Arrays.stream(updating.getMessage()).forEach(System.out::println);
        }



    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        try{
            Integer.parseInt(args[1]);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }


}
