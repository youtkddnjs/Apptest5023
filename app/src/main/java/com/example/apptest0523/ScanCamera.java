package com.example.apptest0523;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apptest0523.utillity.PrintLog;

public class ScanCamera extends AppCompatActivity {

    public Context context;
    SurfaceView surfaceView;
    ScanCamera_SurfaceView scanCameraSurfaceView;
    ImageView scanaim,changeimage;

    boolean changeimageNum=true;

    Handler handler;

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
        changeimage = findViewById(R.id.changeimage);

        changeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(changeimageNum){
                    PrintLog.PrintDebug("직사각형 변환 전 ");
                    checkImage();
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(550,150);
                    params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                    scanaim.setLayoutParams(params);
                    PrintLog.PrintDebug("직사각형 변환 후");
                    checkImage();
                    handler.sendEmptyMessageDelayed(10,1000);
                    changeimageNum = false;
                }else{
                    PrintLog.PrintDebug("정사각형 변환 전");
                    checkImage();
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(350,350);
                    params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                    scanaim.setLayoutParams(params);
                    PrintLog.PrintDebug("정사각형 변환 후");
                    checkImage();
                    handler.sendEmptyMessageDelayed(10,1000);
                    changeimageNum =true;
                }
            }//onClick
        });//setOnClickListener


        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {

                switch (msg.what){
                    case 10:
                        autocheck();
                        checkImage();
                        break;
                }
            }
        };


        autocheck();


    }//onCreate

    void checkImage(){
        scanaim.measure(0,0);
        int aimWidth = scanaim.getMeasuredWidth();
        int aimHeight = scanaim.getMeasuredHeight();

        PrintLog.PrintVerbose("getWidth : " + scanaim.getWidth());
        PrintLog.PrintVerbose("getHeight : " + scanaim.getHeight());

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

    void autocheck(){

    }

}//ScanCamera
