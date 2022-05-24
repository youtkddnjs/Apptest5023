package com.example.apptest0523;

import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScanCamera extends AppCompatActivity {

    public Context context;
    SurfaceView surfaceView;
    ScanCamera_SurfaceView scanCameraSurfaceView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        scanCameraSurfaceView = findViewById(R.id.sv);
        context = this;

    }//onCreate

}//ScanCamera
