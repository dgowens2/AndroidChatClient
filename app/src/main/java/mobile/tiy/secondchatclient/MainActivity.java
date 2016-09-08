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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView chat;
    EditText text;
    Button sendButton;
    ArrayAdapter<String> chatList;
    ChatAppClient chatApp = new ChatAppClient();

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

        try {
            Socket clientSocket = new Socket("10.0.0.132", 8080);
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String serverResponse;
            serverResponse = in.readLine();
            System.out.println("Received message: " + serverResponse);

        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void onClick(View v){
        String chatline = text.getText().toString();
        chatList.add(chatline);
//        chatApp.conversationHandler();
        text.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = chatList.getItem(position);
        chatList.remove(item);
        return true;
    }}
