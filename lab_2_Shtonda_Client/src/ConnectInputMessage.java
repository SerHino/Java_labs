import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {
    private Socket serverConnect;
    private BufferedReader userInput;
    private PrintWriter out;

    public ConnectInputMessage(Socket serverConnect) {
        this.serverConnect = serverConnect;
        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(serverConnect.getOutputStream(), true);

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(serverConnect.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            int clientNumber = Integer.parseInt(userInput.readLine());
            System.out.println("Ви підключилися як клієнт #" + clientNumber);

            String message;
            while (true) {
                message = userInput.readLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}