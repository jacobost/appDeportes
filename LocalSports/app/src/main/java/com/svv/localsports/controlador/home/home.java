package com.svv.localsports.controlador.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.svv.localsports.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<homeItem> mItemList;

    public void insertItem (int imageResource, String textOrganizador, String textCancha, String textHora, String textFecha, String textNivel, String textAsistentes, String textComentario) {
        mItemList.add(mItemList.size(), new homeItem(imageResource, textOrganizador, textCancha, textHora, textFecha, textNivel, textAsistentes, textComentario));
        mAdapter.notifyItemInserted(mItemList.size());
    }

    public home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        mItemList = new ArrayList<>();

        mItemList.add(new homeItem(R.drawable.ic_launcher, "Pepe", "Aqui", "9:00", "2/3/20", "Bajo", "3", "Venirse"));
        mItemList.add(new homeItem(R.drawable.ic_launcher, "Pepe", "Aqui", "9:00", "2/3/20", "Bajo", "3", "Venirse"));
        mItemList.add(new homeItem(R.drawable.ic_launcher, "Pepe", "Aqui", "9:00", "2/3/20", "Bajo", "3", "Venirse"));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = getView().findViewById(R.id.recyclerview);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new homeRecyclerAdapter(mItemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_deporte) {
            Toast.makeText(getActivity(), "Filtro de deporte no disponible", Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.action_fecha) {
            Toast.makeText(getActivity(), "Filtro de fecha no disponible", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
