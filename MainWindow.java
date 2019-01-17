package com.example.j4011.testapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class MainWindow extends AppCompatActivity {

    Context context = null;


    TextView text,text2;
    String input;
    String input2;
    EditText userInput;
    EditText fileName;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        context = MainWindow.this;
        System.out.println("KANSION SIJAINTI: "+context.getFilesDir());

        text = (TextView) findViewById(R.id.tvHelloWorld);
        btn = (Button) findViewById(R.id.btnClick);
        text2 = (TextView) findViewById(R.id.tvOmaValintainen);
        userInput = (EditText) findViewById(R.id.textField);
        fileName = (EditText) findViewById(R.id.editText2);

    }

    public void readFile(View v) {
        try {
            InputStream ins = context.openFileInput(input2);// TODO Tälle arvo!
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            ins.close();

        } catch (IOException e) {
            Log.e("IOExcinput = userInput.getText().toString();eption", "Virhe syötteessä");
        } finally{
            System.out.println("READ");
        }
    }

    public void writeFile(View v) {
        try {
            input2 = userInput.getText().toString();

            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(input2, Context.MODE_PRIVATE));
            String s = "";

            input = userInput.getText().toString();
            s = input;
            osw.write(s);
            osw.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }finally{
            System.out.println("WRITTEN");
        }
    }
}

        /*userInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                input = userInput.getText().toString();
                switch(keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                        text2.setText(input);
                        return true;
                    default:
                        break;
                }return false;
            }*/
        //});
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. tehtävä
                //text.setVisibility(View.VISIBLE);
                //2. tehtävä
                //text2.setText("Hello World!");
                //3. tehtävä


           }
        });*/
    //}



