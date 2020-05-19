package com.svv.localsports.controlador.home;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.svv.localsports.DatePickerFragment;
import com.svv.localsports.R;
import com.svv.localsports.TimePickerFragment;
import com.svv.localsports.ViewPagerMod;

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
    EditText addFecha, addHora;

    private int hora;
    private int minuto;
    private int dia;
    private int mes;
    private int anho;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addFecha = (EditText) view.findViewById(R.id.addFecha);
        addHora = (EditText) view.findViewById(R.id.addHora);

        addFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        addHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
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

    private void showDatePickerDialog() {
        //Esta función crea el diálogo para escoger fecha y pone esa fecha en el editText correspondiente.
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                dia = day;
                mes = month + 1;
                anho = year;
                // +1 because January is zero
                final String selectedDate = day + " / " + (month + 1) + " / " + year;
                addFecha.setText(selectedDate);
            }
        });
        //Si se pone 0 en la fecha máxima o mínima se ignora.
        newFragment.setFechasMinMax(System.currentTimeMillis()-1000,0);

        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    private void showTimePickerDialog() {
        //Esta función crea el diálogo para escoger hora y pone esa hora en el editText correspondiente.
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hora = hourOfDay;
                minuto = minute;
                final String selectedTime = hourOfDay + " : " + minute;
                addHora.setText(selectedTime);
            }
        });

        newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
    }
}