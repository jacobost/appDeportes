package com.svv.localsports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.svv.localsports.controlador.PagerController;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabHome, tabMap, tabUser, tabChat;

    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabHome = findViewById(R.id.tabhome);
        tabMap = findViewById(R.id.tabmap);
        tabUser = findViewById(R.id.tabuser);
        tabChat = findViewById(R.id.tabchat);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pin);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_usuario);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_avion_de_papel);
    }
}
