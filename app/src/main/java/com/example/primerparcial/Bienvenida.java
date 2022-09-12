package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {

    ImageButton btnAcercade, btnTelevision, btnGaleria, btnCamara, btnPestanias, btnSalir, btnLinterna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        btnAcercade = findViewById(R.id.btnMPAcercade);
        btnAcercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCreditos();
            }
        });

        btnTelevision = findViewById(R.id.btnMPTelevision);
        btnTelevision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), Television.class);
                startActivity(intent);
            }
        });

        btnGaleria = findViewById(R.id.btnMPGaleria);
        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), Galeria.class);
                startActivity(intent);
            }
        });

        btnCamara = findViewById(R.id.btnMPCamara);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), Camara.class);
                startActivity(intent);
            }
        });

        btnLinterna = findViewById(R.id.btnMPLinterna);
        btnLinterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), Linterna.class);
                startActivity(intent);
            }
        });

        btnPestanias = findViewById(R.id.btnMPPestanias);
        btnPestanias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), Pestanitas.class);
                startActivity(intent);
            }
        });

        btnSalir = findViewById(R.id.btnMPSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Bienvenida.this, "Terminando Aplicacion :) Vuleva pronto...", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public void getCreditos(){
        new AlertDialog.Builder(this)
                .setTitle("ACERCA DE..")
                .setMessage("" +
                        "Salma Naarai Gasca Mendoza \n" +
                        "Profesora: Rocio Elizabeth Pulido Alba \n" +
                        "Movil 2022-B \n" +
                        "PRIMER PARCIAL").setPositiveButton("Aceptar", null).show();
    }

}