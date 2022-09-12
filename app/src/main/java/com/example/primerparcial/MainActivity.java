package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAcceder, btnSalir;
    EditText txtUsuario, txtContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtMUsuario);
        txtContrasenia = findViewById(R.id.txtMContrasenia);

        btnAcceder = findViewById(R.id.btnMAcceder);
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtUsuario.getText().toString();
                String contra = txtContrasenia.getText().toString();
                if (user.equals("DM") && contra.equals("Naarai")){
                    Intent intent = new Intent(MainActivity.this, Bienvenida.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Entrando...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSalir = findViewById(R.id.btnMSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hasta Pronto", Toast.LENGTH_LONG);
                finishAffinity();
            }
        });

    }
}