package com.example.appclientes.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.appclientes.Pojos.PartesHoras;
import com.example.appclientes.R;

import java.util.List;
//todo hacer el adaptador para buscar los partes de horas.
public class AdaptadorPartesHoras /**extends RecyclerView.Adapter<AdaptadorPartesHoras.RecyclerviewHolder>*/{

    Context context;
    List<PartesHoras> usuarioList;
    List<PartesHoras> filteredUsuarioList;
    RequestQueue requestQueue;

    public AdaptadorPartesHoras(Context context, List<PartesHoras> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
        this.filteredUsuarioList = usuarioList;
        requestQueue= Volley.newRequestQueue(context.getApplicationContext());
    }

   /** public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_item_recyclerview, parent, false);
        return new RecyclerviewHolder(view);
    }*/


}
