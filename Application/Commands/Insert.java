
package com.company.Application.Commands;


import com.company.Application.Controllers.ClientController;
import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * insert with key
 */
class Insert extends AbstractCommand {
    public Insert(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException {
        Product product = controllersProvider.readProduct();
        ArrayList<Product> products = new ArrayList();
        products.add(product);
        Data data = new Data(args,products);
        controllersProvider.getClientController().sendData(data);
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].matches("\\d+");
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("insert int: команда служит для добавления элемента в коллекцию");
    }
}
