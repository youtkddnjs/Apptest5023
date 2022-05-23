package com.example.apptest0523;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileInputOutput_External extends AppCompatActivity {

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
                    //SDcard 존재 여부 확인
                    String state = Environment.getExternalStorageState();

                    if(!state.equals(Environment.MEDIA_MOUNTED)){
                        Toast.makeText(FileInputOutput_External.this, "SDcard가 없습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    }//if(state.equals(Environment.MEDIA_MOUNTED))


                    // /storage/emulated/0/Android/data/com.example.apptest0523/files/mydir
                    //  /sdcard/Android/data/com.example.apptest0523/files/mydir
                    File path;
                    File[] dirs = getExternalFilesDirs("mydir");
                    path = dirs[0];
                    filedataTV.setText(path.getPath());

                    File file = new File(path, "externalData.txt");


                    try {
                        FileWriter fw = new FileWriter(file, true);
                        PrintWriter writer = new PrintWriter(fw);

                        writer.println(data);
                        writer.flush();
                        writer.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;

                case R.id.clickload:
                    
                    String state2 = Environment.getExternalStorageState();
                    if(!state2.equals(Environment.MEDIA_MOUNTED)){
                        Toast.makeText(FileInputOutput_External.this, "SDcard가 없습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    }//if(state.equals(Environment.MEDIA_MOUNTED))

                    File path2;
                    File[] dirs2 = getExternalFilesDirs("mydir");
                    path2 = dirs2[0];
                    File file2 = new File(path2, "externalData.txt");
                    try {
                        FileReader fr = new FileReader(file2);
                        BufferedReader reader = new BufferedReader(fr);
                        StringBuffer buffer = new StringBuffer();

                        String line = reader.readLine();
                        while (line!=null){
                            buffer.append(line+"\n");
                            line=reader.readLine();
                        }

                        filedataTV.setText(buffer.toString());
                        reader.close();


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;
            }//switch
        }
    };//buttonclick

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_input_output_external);

        filenameET = findViewById(R.id.filenameET);
        clicksave = findViewById(R.id.clicksave);
        clickload = findViewById(R.id.clickload);
        filedataTV = findViewById(R.id.filedataTV);


        clicksave.setOnClickListener(buttonclick);
        clickload.setOnClickListener(buttonclick);

    }//onCreate
}//FileInputOutput_External