

package com.company.Application;

import com.company.Application.Commands.CommandInvoker;
import com.company.Application.Commands.ControllersProvider;
import com.company.Application.Controllers.ClientController;
import com.company.Application.Controllers.InputReader;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Class uses to start the application
 */
public class Application {
    public Application() {

    }


    /**
     * starts the application
     * exits if input stream is closed
     */
    public void start() {
        InputReader inputReader = new InputReader();
        ClientController clientController = null;
        try{
            clientController = new ClientController(InetAddress.getLocalHost(),8989);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllersProvider controllersProvider = new ControllersProvider(inputReader, clientController);
        CommandInvoker commandInvoker = new CommandInvoker(controllersProvider);
        while (inputReader.isOpened()){
            inputReader.readCommand(commandInvoker);

        }

    }
    
}
