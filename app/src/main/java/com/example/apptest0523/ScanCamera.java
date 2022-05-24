package com.example.apptest0523;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.widget.RelativeLayout;

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

        //Layout 합치기
        LayoutInflater inflater = getLayoutInflater();
        View scancamera_view = inflater.inflate(R.layout.activity_scancamera,null);
        addContentView(scancamera_view,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

    }//onCreate

}//ScanCamera
