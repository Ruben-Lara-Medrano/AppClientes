package com.example.appclientes.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.appclientes.Pojos.PartesHoras;
import com.example.appclientes.R;

import java.util.ArrayList;
import java.util.List;
//todo hacer el adaptador para buscar los partes de horas.
public class AdaptadorPartesHoras extends RecyclerView.Adapter<AdaptadorPartesHoras.RecyclerviewHolder> {

    Context context;
    List<PartesHoras> informacionUsuarioList;
    List<PartesHoras> filteredInformacionUsuarioList;

    public AdaptadorPartesHoras(Context context, List<PartesHoras> informacionUsuarioList) {
        this.context = context;
        this.informacionUsuarioList = informacionUsuarioList;
        this.filteredInformacionUsuarioList = informacionUsuarioList;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_partes_horas, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, final int position) {

        /**holder.userName.setText(filteredInformacionUsuarioList.get(position).getUserName());
        holder.userDesc.setText(filteredInformacionUsuarioList.get(position).getDescp());
        holder.userImage.setImageResource(filteredInformacionUsuarioList.get(position).getImageUrl());*/

        /*ItemAnimation.animateFadeIn(holder.itemView, position);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//metodo para el onclick en cada card del buscador
                Intent intent = new Intent(context, PartesHoras.class);
                intent.putExtra("Fecha inicial", filteredInformacionUsuarioList.get(position).getFechaInicio());
                intent.putExtra("fecha final", filteredInformacionUsuarioList.get(position).getFechaFinal());
                intent.putExtra("Hora Inicial", filteredInformacionUsuarioList.get(position).getHoraInicio());
                intent.putExtra("Hora inicial", filteredInformacionUsuarioList.get(position).getHoraFinal());
                context.startActivity(intent);
            }
        });

        /**holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "User Name Clicked", Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return filteredInformacionUsuarioList.size();
    }

    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {


        TextView userName, fechaFinal,horas;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            /**userName = itemView.findViewById(R.id.NombreEmpleado);
            fechaFinal = itemView.findViewById(R.id.tabDeDate);
            horas = itemView.findViewById(R.id.tabDeTiempo);
*/

        }
    }

    public Filter getFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if(Key.isEmpty()){
                    filteredInformacionUsuarioList = informacionUsuarioList;
                }
                else{

                    List<PartesHoras> lstFiltered = new ArrayList<>();
                    for(PartesHoras row: informacionUsuarioList){
                      /**  if(row.getFechaInicio().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);

                        }*/
                    }

                    filteredInformacionUsuarioList = lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredInformacionUsuarioList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredInformacionUsuarioList = (List<PartesHoras>)filterResults.values;
                notifyDataSetChanged();

            }
        };

    }


}
