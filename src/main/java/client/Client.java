package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.Thread.sleep;

/**
 * Created by igladush on 04.03.16.
 */
public class Client {
    private final String BUY = "Buy";
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public void runClient(int serverPort, String address) {

        String message;


        try {
            Socket socket = new Socket( InetAddress.getByName(address), serverPort);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Recipient(socket)).start();
            System.out.println("Type your message I send it to the server if you want exit write Buy");

            while (true) {
                message = keyboard.readLine();
                out.writeUTF(message);
                out.flush();
                if (BUY.equals(message)) {
                    break;
                }
            }

            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
