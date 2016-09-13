package mobile.tiy.secondchatclient;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView chat;
    EditText text;
    Button sendButton;
    ArrayAdapter<String> chatList;
    final String serverIP = "10.0.0.132";
    final int portNumber = 8005;
    Socket clientSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chat = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.button);

        chatList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        chat.setAdapter(chatList);

        sendButton.setOnClickListener(this);
        chat.setOnItemLongClickListener(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        connectionOpener();
        System.out.println("connection open");

    }

    public void connectionOpener() {
        try {
            clientSocket = new Socket(serverIP, portNumber);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("connection open/closed");
    }
    @Override
    public void onClick(View v){
        System.out.println("ready to send");
        String chatline = text.getText().toString();
        chatList.add(chatline);
        System.out.println("sent to list");
        try {
            sendToServer(chatline);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        text.setText("");
        System.out.println("message sent from on click");
    }

    public void sendToServer(String chatline) throws IOException{
        System.out.println("Using output stream: " + out.toString());
        out.println(chatline);
        System.out.println("message sent from sendtoserver");
    }

    public void incomingText() {
        try {
            String serverText = in.readLine();
            System.out.println(serverText);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = chatList.getItem(position);
        chatList.remove(item);
        return true;
    }


}
