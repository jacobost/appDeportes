package com.svv.localsports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabHome = findViewById(R.id.tabhome);
        tabMap = findViewById(R.id.tabmap);
        tabUser = findViewById(R.id.tabuser);
        tabChat = findViewById(R.id.tabchat);


        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        barraIconos(0);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                barraIconos(position);
            }
        });
    }
    private void barraIconos(int posicionSeleccionada){
        int[] arrayIconos = {R.drawable.ic_casa, R.drawable.ic_pin, R.drawable.ic_usuario, R.drawable.ic_avion_de_papel};
        Drawable iconoMod = null;
        for (int i = 0; i<arrayIconos.length; i++) {
            if (i == posicionSeleccionada) {
                iconoMod = new VectorDrawableUtils().getDrawable(getApplicationContext(), arrayIconos[i], R.color.colorSeleccionado);
            } else {
                iconoMod = new VectorDrawableUtils().getDrawable(getApplicationContext(), arrayIconos[i], R.color.colorDeseleccionado);
            }
            tabLayout.getTabAt(i).setIcon(iconoMod);
        }
    }
    private class VectorDrawableUtils {

        Drawable getDrawable(Context context, int drawableResId) {
            return VectorDrawableCompat.create(context.getResources(), drawableResId, context.getTheme());
        }

        Drawable getDrawable(Context context, int drawableResId, int colorFilter) {
            Drawable drawable = getDrawable(context, drawableResId);
            drawable.setColorFilter(ContextCompat.getColor(context, colorFilter), PorterDuff.Mode.SRC_IN);
            return drawable;
        }
    }
}
