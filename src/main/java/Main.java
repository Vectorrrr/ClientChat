import client.Client;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by igladush on 04.03.16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input port:\t");
        int serverPort=Integer.valueOf(sc.nextLine());
        System.out.println("Input address:\t");
        String address = sc.nextLine();
        new Client().runClient(serverPort, address);



    }
    private void m(){

    }
}
