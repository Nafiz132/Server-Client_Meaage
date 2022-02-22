package MessageDemo.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //String message;
            while(true){
                System.out.println("input> ");
                String message = scanner.next();
              //  System.out.println();
                dataOutputStream.writeUTF(message);
                if(message.equalsIgnoreCase("_stop")){
                    break;
                }
            }
            socket.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
