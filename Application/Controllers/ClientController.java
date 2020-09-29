package com.company.Application.Controllers;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientController {
    private final static int BUFFER_SIZE = 2048;
    Data data;
    DatagramChannel datagramChannel;
    SocketAddress socketAddress;
    ByteBuffer byteBuffer;
    public ClientController(InetAddress address, int port) throws IOException {
        socketAddress = new InetSocketAddress(address, port);
        datagramChannel = DatagramChannel.open();
        datagramChannel.connect(socketAddress);

    }

    public void sendData(Data data) throws IOException {
        byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
        byte[] buf = byteArrayOutputStream.toByteArray();
        byteBuffer.put(buf).flip();
        datagramChannel.write(byteBuffer);
//        datagramChannel.send(byteBuffer, socketAddress);
        System.out.println("sent");
        try {
            receiveData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void receiveData() throws IOException, ClassNotFoundException {
        byteBuffer.clear();
        datagramChannel.receive(byteBuffer);
        byteBuffer.flip();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Data response = (Data) objectInputStream.readObject();
        for (Product x : response.getProducts()){
            System.out.println(x.toString());
        }
    }

}
