package com.example.primerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Pestanitas extends AppCompatActivity {

    ViewPagerAdapter mAdapter;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestanitas);

        viewPager2 = findViewById(R.id.viewPager2xml);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        //AGREGAR LOS FRAGMENTOS
        mAdapter.addFragments(new ProgressBarItem()); //0
        mAdapter.addFragments(new HoraActual()); //1
        mAdapter.addFragments(new MiUbicacion()); //2

        viewPager2.setAdapter(mAdapter);


        //SINCRONIZAMOS EL VIEWPAGER2 CON EL TABLAYOUT
        TabLayout tabtab = findViewById(R.id.tabLayoutxml);
        new TabLayoutMediator(tabtab, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("PROGRESS BAR");
                        break;
                    case 1:
                        tab.setText("HORA ACTUAL");
                        break;
                    case 2:
                        tab.setText("UBICACION");
                        break;
                }
            }
        }).attach();
    }
}