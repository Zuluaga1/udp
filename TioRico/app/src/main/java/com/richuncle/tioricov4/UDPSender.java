package com.richuncle.tioricov4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSender implements Runnable {

    private final String Message;
    private final int serverPort;

    public UDPSender(String message, int serverPort) {
        Message = message;
        this.serverPort = serverPort;
    }


    @Override
    public void run() {
        try(DatagramSocket clientSocket = new DatagramSocket(15015)){
            DatagramPacket datagramPacket = new DatagramPacket(
                    Message.getBytes(),
                    Message.length(),
                    InetAddress.getByName("192.168.0.15"),
                    serverPort
            );
            clientSocket.send(datagramPacket);
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}