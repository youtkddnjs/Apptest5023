package com.example.apptest0523;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileInputOutput extends AppCompatActivity {

    Button clicksave, clickload;
    TextView filedataTV;
    EditText filenameET;

    View.OnClickListener buttonclick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.clicksave:
                    String data = filenameET.getText().toString();
                    filenameET.setText("");

                    try {
                        FileOutputStream fos = openFileOutput("filedata.txt",MODE_APPEND);
                        PrintWriter writer = new PrintWriter(fos);
                        writer.println(data);
                        writer.flush();
                        writer.close();

                        Toast.makeText(FileInputOutput.this, "Saved", Toast.LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    break;
                case R.id.clickload:

                    try {
                        FileInputStream fis = openFileInput("filedata.txt");
                        //바이트 스트림을 문자스트림으로 변환
                        InputStreamReader isr = new InputStreamReader(fis);
                        //문자 스트림을 보조문자스트림으로 변환
                        BufferedReader reader = new BufferedReader(isr);

                        StringBuffer buffer = new StringBuffer();

                        String line = reader.readLine();
                        while (line!=null){
                            buffer.append(line + "\n");
                            line = reader.readLine();
                        }

                        filedataTV.setText(buffer.toString());



                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;

            }//switch
        }//onClick
    };//buttonclick

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_input_output);

        filenameET = findViewById(R.id.filenameET);
        clicksave = findViewById(R.id.clicksave);
        clickload = findViewById(R.id.clickload);
        filedataTV = findViewById(R.id.filedataTV);


        clicksave.setOnClickListener(buttonclick);
        clickload.setOnClickListener(buttonclick);







    }//onCreate
}//FileInputOutput