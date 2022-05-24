package com.example.apptest0523;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import androidx.annotation.NonNull;

import java.io.IOException;

public class ScanCamera_SurfaceView extends android.view.SurfaceView implements SurfaceHolder.Callback {

    Context m_context;
    Camera camera;
    SurfaceHolder surfaceHolder;

    public ScanCamera_SurfaceView(Context context) {
        super(context);
        m_context = context;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    public ScanCamera_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        try {
            camera = Camera.open(0); //카메라 렌즈 열기
            camera.setDisplayOrientation(90);
            camera.setPreviewDisplay(surfaceHolder); //미리보기 설정
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        camera.startPreview();

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        camera.release();
        camera.stopPreview();
    }
}