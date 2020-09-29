package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.io.IOException;
import java.util.Iterator;

/**
 * counts all products with manufactureCost less then entered
 */
class CountLessManCost extends AbstractCommand {
    public CountLessManCost(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) throws IOException {
        Data data = new Data(args);
        controllersProvider.getClientController().sendData(data);
    }
//        long cost = Long.parseLong(args[1]);
//        Iterator<Product> values = controllersProvider.getTreeMapController().getValueIterator();
//        long counter = 0;
//        while (values.hasNext()) {
//            Product value = values.next();
//            if (value.getManufactureCost() < cost)
//                counter++;
//        }
//        String ending = "";
//        if (counter == 1)
//            ending = "";
//        else if((counter>=2)&&(counter<=4))
//            ending = "а";
//        else
//            ending = "ов";
//
//        System.out.println("Коллекция содержит "+counter+" элемент"+ending+" с рыночной стоимостью меньше заданной ");
//    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return  args[1].matches("(\\d+)");
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("count_less_than_manufacture_cost long : выводит количество элементов, зачения поля manufectureCost которых меньше заданного");
    }
}
