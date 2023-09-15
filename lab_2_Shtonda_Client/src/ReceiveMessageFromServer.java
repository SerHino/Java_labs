import java.io.*;
import java.net.Socket;

public class ReceiveMessageFromServer implements Runnable {
    private InputStream inputStreamServer;

    public ReceiveMessageFromServer(Socket serverConnect) {
        try {
            inputStreamServer = serverConnect.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(inputStreamServer));

            String message;
            while ((message = serverInput.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
