package com.svv.localsports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.svv.localsports.controlador.PagerController;
import com.svv.localsports.controlador.home.AddEntry;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    AppBarLayout appBar;
    Toolbar toolbar;
    ViewPagerMod viewPager;
    TabItem tabHome, tabMap, tabUser, tabChat;
    FloatingActionButton fab;

    PagerController pagerAdapter;

    //Guarda en qué vista estamos actualmente.
    int posicionTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(toolbar);

        appBar = findViewById(R.id.appBar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabHome = findViewById(R.id.tabhome);
        tabMap = findViewById(R.id.tabmap);
        tabUser = findViewById(R.id.tabuser);
        tabChat = findViewById(R.id.tabchat);
        fab = findViewById(R.id.fab);

        //Inicializa o tab layout.
        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        barraIconos(0);

        viewPager.addOnPageChangeListener(new ViewPagerMod.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                barraIconos(position);
            }
        });

        //Comportamiento del floating action button.
        //TODO: Implementar comportamiento. Dependerá de posicionTab.
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (posicionTab == 0) {
                    appBar.setExpanded(true, true);
                    //Coloca el fragment nuevo por encima del previo.
                    AddEntry addEntry = new AddEntry();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentHome, addEntry)
                            .addToBackStack(null)
                            .commit();
                }
                //Toast.makeText(getApplicationContext(), "No se pueden añadir por ahora.", LENGTH_LONG).show();
            }
        });
    }

    //Fai as cuestións relacionadas co cambio de tabs.
    private void barraIconos(int posicionSeleccionada){
        //Se asegura de que la toolbar está presente cuando se cambia de tab.
        appBar.setExpanded(true, true);

        posicionTab = posicionSeleccionada;

        // TODO: Actualizar estes if segundo se necesite ou non o fab
        if (posicionSeleccionada == 0) {
            fab.show();
        } else {
            fab.hide();
        }

        //Modifica a cor dos iconos do tab segundo estea ou non esa tab seleccionada.
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

    //Para hacer funcionar la flecha "back" del toolbar.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
