package com.example.primerparcial;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Linterna extends AppCompatActivity {

    private ImageButton btnONOF;
    Boolean flashe = false;
    Boolean on_of = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linterna);

        btnONOF = findViewById(R.id.btnLApagado);
        flashe = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        btnONOF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flashe){
                    if (on_of){
                        on_of = false;
                        btnONOF.setImageResource(R.drawable.apagado);
                        try {
                            flashapagado();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    } else {
                        on_of = true;
                        btnONOF.setImageResource(R.drawable.encendido);
                        try {
                            flashencendido();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(Linterna.this,"Flash no disponible en tu dispositivo",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void flashencendido() throws CameraAccessException {
        CameraManager cameraManager =(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId,true);
        Toast.makeText(Linterna.this, "Flash encendido", Toast.LENGTH_SHORT).show();
    }

    private void flashapagado() throws CameraAccessException {
        CameraManager cameraManager =(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId,false);
        Toast.makeText(Linterna.this, "Flash apagado", Toast.LENGTH_SHORT).show();
    }

}