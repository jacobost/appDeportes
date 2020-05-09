package com.svv.localsports.controlador.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.svv.localsports.R;
import com.svv.localsports.ViewPagerMod;

import static android.widget.Toast.LENGTH_LONG;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEntry extends Fragment {

    public AddEntry() {
        // Required empty public constructor
    }

    TabLayout tabLayout;
    ViewPagerMod viewPager;
    RecyclerView recyclerView;
    FloatingActionButton fab;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tabLayout = (TabLayout) getActivity().findViewById(R.id.tablayout);
        viewPager = (ViewPagerMod) getActivity().findViewById(R.id.viewpager);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        //Evita o scroll vertical.
        recyclerView.setNestedScrollingEnabled(false);

        //Fai aparecer a flecha "back" na toolbar.
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Esconde os tabs.
        tabLayout.setVisibility(View.GONE);
        //Evita o swipe entre tabs.
        viewPager.setPagingEnabled(false);

        fab.hide();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_entry, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //Evita o scroll vertical.
        recyclerView.setNestedScrollingEnabled(true);
        //Elimina flecha "back" en toolbar.
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //Mostra os tabs.
        tabLayout.setVisibility(View.VISIBLE);
        //Fai que se poda facer swipe entre tabs.
        viewPager.setPagingEnabled(true);

        fab.show();
    }

    //Evita que se muestre el menú de opciones del toolbar.
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}
