import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private static final int PORT = 12345;
    private ServerSocket serverSocket;
    private Map<Integer, Socket> clients = new HashMap<>();
    private int clientCounter = 1;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущено на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Під'єднався новий клієнт");

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(clientCounter);

                clients.put(clientCounter, clientSocket);

                ClientThread clientThread = new ClientThread(clientCounter, clientSocket, this);
                Thread thread = new Thread(clientThread);
                thread.setDaemon(true);
                thread.start();

                clientCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMessageForAllClients(int sender, String message) {
        for (Map.Entry<Integer, Socket> entry : clients.entrySet()) {
            int clientNumber = entry.getKey();
            Socket clientSocket = entry.getValue();

            if (clientNumber != sender) {
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Клієнт " + sender + ": " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void removeClient(int clientNumber) {
        clients.remove(clientNumber);
        System.out.println("Клієнт " + clientNumber + " покинув чат.");
    }

    public static void main(String[] args) {
        new ChatServer().run();
    }

    public void run() {

    }
}