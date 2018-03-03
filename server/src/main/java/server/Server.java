package server;

import config.Settings;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private ServerSocket socketListener;
    private boolean stopServer;

    public Server() {
    }

    public void start() {
        try {
            this.socketListener = new ServerSocket(Integer.parseInt(Settings.PORT.get()));
            while (!stopServer) {
                Socket client = null;
                while (client == null) {
                    client = socketListener.accept();
                }
                //new ClientThread(client); //Создаем новый поток, которому передаем сокет
            }
        } catch (SocketException e) {
            System.err.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O exception");
            e.printStackTrace();
        }
    }

    private void stopServer() {
        this.socketListener = null;
        this.stopServer = true;
    }
}
