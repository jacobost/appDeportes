package com.svv.localsports.controlador.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svv.localsports.R;

import java.util.ArrayList;

public class homeRecyclerAdapter extends RecyclerView.Adapter<homeRecyclerAdapter.homeViewHolder> {
    private ArrayList<homeItem> mHomeList;

    public static class homeViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewOrganizador, mTextViewCancha, mTextViewHora, mTextViewFecha, mTextViewNivel, mTextViewAsistentes, mTextViewComentario;

        public homeViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imagenItem);
            mTextViewOrganizador = itemView.findViewById(R.id.organizadorEdit);
            mTextViewCancha = itemView.findViewById(R.id.canchaEdit);
            mTextViewHora = itemView.findViewById(R.id.horaEdit);
            mTextViewFecha = itemView.findViewById(R.id.fechaEdit);
            mTextViewNivel = itemView.findViewById(R.id.nivelEdit);
            mTextViewAsistentes = itemView.findViewById(R.id.asistentesEdit);
            mTextViewComentario = itemView.findViewById(R.id.comentarioEdit);
        }
    }

    public homeRecyclerAdapter(ArrayList<homeItem> homeList) {
        mHomeList = homeList;
    }

    @NonNull
    @Override
    public homeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        homeViewHolder evh = new homeViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull homeViewHolder holder, int position) {
        homeItem currentItem = mHomeList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextViewOrganizador.setText(currentItem.getTextOrganizador());
        holder.mTextViewCancha.setText(currentItem.getTextCancha());
        holder.mTextViewHora.setText(currentItem.getTextHora());
        holder.mTextViewFecha.setText(currentItem.getTextFecha());
        holder.mTextViewNivel.setText(currentItem.getTextNivel());
        holder.mTextViewAsistentes.setText(currentItem.getTextAsistentes());
        holder.mTextViewComentario.setText(currentItem.getTextComentario());
    }

    @Override
    public int getItemCount() {
        return mHomeList.size();
    }
}
