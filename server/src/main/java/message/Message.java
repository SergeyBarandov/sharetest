package message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Message {
    private final Scanner inMessage;
    private final PrintWriter outMessage;
    private final StringBuilder sb;

    public Message(Socket clientSocket) throws IOException {
        this.sb = new StringBuilder();
        this.inMessage = new Scanner(clientSocket.getInputStream());
        this.outMessage = new PrintWriter(clientSocket.getOutputStream());
    }

    public boolean sendMessage(String message) {
        boolean result;
        if (result = message != null && message.length() > 0) {
            this.outMessage.println(message);
            this.outMessage.flush();
        }
        return result;
    }

    public String getMessage() {
        this.sb.delete(0, sb.length());
        if (inMessage.hasNext()) {
            sb.append(this.inMessage.nextLine());
        }
        return this.sb.toString();
    }

    public String reverseMessage(String message) {
        this.sb.delete(0, sb.length());
        return sb.append(message).reverse().toString();
    }
}
