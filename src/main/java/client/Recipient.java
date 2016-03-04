package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by igladush on 04.03.16.
 */
public class Recipient implements Runnable {
    private final String ERROR_CREATE_INPUTSTREA = "When I create data input stream i catch exception!";
    private final String ERROR_READ_ANSWER = "When I read answer I have problem";
    private final String ERROR_CLOSE = "Error when I close";
    private final String EXIT = "1234567890";

    private DataInputStream reader;
    private Socket socket;

    public Recipient(Socket socket) {
        this.socket = socket;
        try {
            reader = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(ERROR_CREATE_INPUTSTREA);

        }
    }

    public void run() {
        while (true) {
            try {
                String text = reader.readUTF();
                if (EXIT.equals(text)) {
                    break;
                }
                System.out.println(text);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalArgumentException(ERROR_READ_ANSWER);
            }
        }
        try {
            reader.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(ERROR_CLOSE);
            e.printStackTrace();
        }

    }
}
