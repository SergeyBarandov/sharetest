package client;

import message.Message;

import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Message message;

    public ClientThread(Socket socket) throws IOException {
        this.message = new Message(socket);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String msg = this.message.getMessage();
                if (msg.length() > 0) {
                    this.message.sendMessage(this.message.reverseMessage(msg));
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            // empty block
        }
    }
}
