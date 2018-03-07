package server;

import client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 5431;
    private static final String NAME_SERVER = "Plot";
    private final ThreadGroup group;

    private boolean isStop;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server() {
        this.group = new ThreadGroup("Clients");
    }

    public void start() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            System.out.printf("Server %s is start.%s", NAME_SERVER, System.lineSeparator());
            while (!this.isStop) {
                this.clientSocket = serverSocket.accept();
                new Thread(new ClientThread(this.clientSocket));
            }
        } catch (IOException e) {
            System.out.println("ERROR: The port or socket incorrect...");
        }
        stopServer();
        System.out.printf("Server %s is stop.", NAME_SERVER);
    }


    /**
     * Метод останавливает сервер, освобождая соккеты.
     */
    private void stopServer() {
        try {
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
            if (this.clientSocket != null) {
                this.clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
