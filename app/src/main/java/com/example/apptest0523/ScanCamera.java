package com.example.apptest0523;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apptest0523.utillity.PrintLog;

public class ScanCamera extends AppCompatActivity {

    public Context context;
    SurfaceView surfaceView;
    ScanCamera_SurfaceView scanCameraSurfaceView;
    ImageView scanaim;

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


        scanaim = findViewById(R.id.scanaim);
                

    }//onCreate

    void checkImage(){
        int aimWidth = scanaim.getMeasuredWidth();
        int aimHeight = scanaim.getMeasuredHeight();

        PrintLog.PrintVerbose("getMeasuredWidth : " + scanaim.getMeasuredWidth());
        PrintLog.PrintVerbose("getMeasuredHeight : " + scanaim.getMeasuredHeight());
        PrintLog.PrintVerbose("getMeasuredState : " + scanaim.getMeasuredState());
        PrintLog.PrintVerbose("getMeasuredWidthAndState : " + scanaim.getMeasuredWidthAndState());
        PrintLog.PrintVerbose("getMeasuredHeightAndState : " + scanaim.getMeasuredHeightAndState());

        PrintLog.PrintVerbose("getMeasuredWidth : " + aimWidth);
        PrintLog.PrintVerbose("getMeasuredHeight : " + aimHeight);

        int[] location = new int[2];
        scanaim.getLocationOnScreen(location);

        int aim_X = location[0];
        int aim_Y = location[1];

        PrintLog.PrintVerbose("aim_X : " + aim_X);
        PrintLog.PrintVerbose("aim_Y : " + aim_Y);
    }

}//ScanCamera
