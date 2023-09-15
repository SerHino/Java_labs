import java.io.IOException;
import java.net.Socket;

public class Program {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 12345;

        try {
            Socket serverConnect = new Socket(serverAddress, serverPort);

            Thread inputThread = new Thread(new ConnectInputMessage(serverConnect));
            Thread receiveThread = new Thread(new ReceiveMessageFromServer(serverConnect));

            inputThread.start();
            receiveThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

