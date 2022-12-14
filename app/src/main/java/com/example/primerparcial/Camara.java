package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Camara extends AppCompatActivity {

    Button btnFoto, btnSalir;
    ImageView foto;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        foto = findViewById(R.id.imgvCImagen);

        btnFoto = findViewById(R.id.btnCTomarFoto);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    abrirCamara();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnSalir = findViewById(R.id.btnCSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Camara.this, "Regresando al menu principal", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void abrirCamara() throws IOException {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){

            File imagenArchivo = null;

            try{
                imagenArchivo = crearImagen();

            }catch (IOException ex){
                Log.e("Error", ex.toString());
            }


            if(imagenArchivo != null)
            {
                Uri fotoUri = FileProvider.getUriForFile(Camara.this, "com.example.primerparcial.fileprovider", imagenArchivo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
                startActivityForResult(intent, 1);
            }
        }
    }

    protected void onActivityResult(int resquestCode, int resultCode, Intent data) {

        super.onActivityResult(resquestCode, resultCode, data);
        if (resquestCode==1 && resultCode==RESULT_OK){
            //Bundle extras = data.getExtras();
            Bitmap imgBitMap = BitmapFactory.decodeFile(rutaImagen);
            foto.setImageURI(Uri.parse(rutaImagen));
        }
    }

    private File crearImagen() throws IOException {

        String nombreImagen = "foto_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);

        rutaImagen = imagen.getAbsolutePath();
        return imagen;
    }

}