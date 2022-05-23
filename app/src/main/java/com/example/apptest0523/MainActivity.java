package com.example.apptest0523;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button fileinternal,fileexternal;
    Intent intent;




    View.OnClickListener nextActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.fileinternal:
                    intent = new Intent(MainActivity.this, FileInputOutput.class);
                    startActivity(intent);
                    break;
                case R.id.fileexternal:
                    intent = new Intent(MainActivity.this, FileInputOutput_External.class);
                    startActivity(intent);
                    break;
            }//switch
        }//onClick
    };//nextActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileinternal = findViewById(R.id.fileinternal);
        fileexternal = findViewById(R.id.fileexternal);

        fileinternal.setOnClickListener(nextActivity);
        fileexternal.setOnClickListener(nextActivity);


    }//onCreate
}//MainActivity