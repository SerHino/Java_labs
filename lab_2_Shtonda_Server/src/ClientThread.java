import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {
    private int clientNumber;
    private Socket clientSocket;
    private ChatServer chatServer;

    public ClientThread(int clientNumber, Socket clientSocket, ChatServer chatServer) {
        this.clientNumber = clientNumber;
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Клієнт " + clientNumber + ": " + message);
                chatServer.sendMessageForAllClients(clientNumber, message);
            }

            chatServer.removeClient(clientNumber);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
