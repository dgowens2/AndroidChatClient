//package mobile.tiy.secondchatclient;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
///**
// * Created by DTG2 on 09/07/16.
// */
//public class ChatAppClient {
//    public static void main(String[] args) throws Exception {
//        connectionStarter();
//
//    }
//
//    public static void connectionStarter() {
//        Scanner clientInput = new Scanner(System.in);
//
//        try {
//            Socket clientSocket = new Socket("10.0.0.132", 8080);
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            String serverResponse;
//            serverResponse = in.readLine();
//            System.out.println("Received message: " + serverResponse);
//            String userName = clientInput.nextLine();
//            out.println("name=" + userName);
//            try {
//                conversationHandler(out, in, clientInput, userName);
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//
//            clientSocket.close();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//
//    }
//
//    public static void conversationHandler(PrintWriter out, BufferedReader in, Scanner clientInput, String userName) throws Exception{
//
////        while (true) {
////            String serverText;
////            serverText = in.readLine();
////            System.out.println("Server: " + serverText);
////            System.out.print(userName + ": ");
//
//            String clientText = clientInput.nextLine();
//            out.println(clientText);
////        }
//    }
//}