package mobile.tiy.secondchatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by DTG2 on 09/07/16.
 */
public class ChatAppClient {
    public static void main(String[] args) /*throws Exception*/ {
//        Scanner clientInput = new Scanner(System.in);
//
//        try {
//            Socket clientSocket = new Socket("localhost", 8080);
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            while (true) {
//                String serverText;
//                serverText = in.readLine();
//                System.out.println("Server: " + serverText);
////                System.out.print(userName + ": ");
//
//                String clientText = clientInput.nextLine();
//                out.println(/*userName + ": " +*/ clientText);
//
//                clientSocket.close();
//            }
//
////            String serverResponse;
////            serverResponse = in.readLine();
////            System.out.println("Received message: " + serverResponse);
////            String userName = clientInput.nextLine();
////            out.println("name=" + userName);
////            conversationHandler(out, in, clientInput, userName);
//
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
    }

    public void clientConnector() {

        Scanner clientInput = new Scanner(System.in);

        try {
            Socket clientSocket = new Socket("10.0.0.132", 8080);
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//            while (true) {
//                String serverText;
//                serverText = in.readLine();
//                System.out.println("Server: " + serverText);
////                System.out.print(userName + ": ");
//
//                String clientText = clientInput.nextLine();
//                out.println(/*userName + ": " +*/ clientText);
//
//                clientSocket.close();
//            }
//
////            String serverResponse;
////            serverResponse = in.readLine();
////            System.out.println("Received message: " + serverResponse);
////            String userName = clientInput.nextLine();
////            out.println("name=" + userName);
////            conversationHandler(out, in, clientInput, userName);
//
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void conversationHandler(/*PrintWriter out, BufferedReader in, Scanner clientInput, String userName*/) /*throws Exception*/ {
//        while (true) {
//            String serverText;
//            serverText = in.readLine();
//            System.out.println("Server: " + serverText);
//            System.out.print(userName + ": ");
//
//            String clientText = clientInput.nextLine();
//            out.println(userName + ": " + clientText);
//        }
//    }

        Scanner clientInput = new Scanner(System.in);

        try {
            Socket clientSocket = new Socket("10.0.0.132", 8080);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                String serverText;
                serverText = in.readLine();
                System.out.println("Server: " + serverText);
//                System.out.print(userName + ": ");

                String clientText = clientInput.nextLine();
                out.println(/*userName + ": " +*/ clientText);

                clientSocket.close();
            }

//            String serverResponse;
//            serverResponse = in.readLine();
//            System.out.println("Received message: " + serverResponse);
//            String userName = clientInput.nextLine();
//            out.println("name=" + userName);
//            conversationHandler(out, in, clientInput, userName);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
