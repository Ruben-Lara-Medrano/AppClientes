package com.example.appclientes.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.appclientes.Conexion.ConexionCAD;
import com.example.appclientes.Perfil;
import com.example.appclientes.Pojos.Usuarios;
import com.example.appclientes.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorUsuarios extends RecyclerView.Adapter<AdaptadorUsuarios.RecyclerviewHolder> {

    Context context;
    List<Usuarios> usuarioList;
    List<Usuarios> filteredUsuarioList;
    RequestQueue requestQueue;
    ConexionCAD direciones = new ConexionCAD();
    public AdaptadorUsuarios(Context context, List<Usuarios> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
        this.filteredUsuarioList = usuarioList;
        requestQueue= Volley.newRequestQueue(context.getApplicationContext());

    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_partes_horas, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, final int position) {

        holder.userName.setText(filteredUsuarioList.get(position).getNombre());
        holder.userDesc.setText(filteredUsuarioList.get(position).getPuesto());


        //ItemAnimation.animateFadeIn(holder.itemView, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//metodo para el onclick en cada card del buscador
                Intent intent = new Intent(context, Perfil.class);
               // intent.putExtra("usuarioId", filteredUsuarioList.get(position).getId());

                //intent.putExtra("userDesc", filteredUsuarioList.get(position).getDescp());
                context.startActivity(intent);
            }
        });

        /*holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "User Name Clicked", Toast.LENGTH_SHORT).show();

            }
        });*/


    }


    @Override
    public int getItemCount() {
        return filteredUsuarioList.size();
    }

    public  class RecyclerviewHolder extends RecyclerView.ViewHolder {


        CircleImageView userImage;
        TextView userName, userDesc;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.NombreUsuario);
            userDesc = itemView.findViewById(R.id.Horas);


        }
       /* void bindata (final Usuario sacarUsuario){
        cargarImagen(userImage, direciones.actualizarFoto()+sacarUsuario.getImagen());
        }*/
    }
    /* private void cargarImagen(CircleImageView imagenPerfil, String url){
         ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
             @Override
             public void onResponse(Bitmap response) {
                 imagenPerfil.setImageBitmap(response);
             }
         }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 //Poner una imagen por defecto
             }
         });
         requestQueue.add(imageRequest);
     }*/
    public Filter getFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if(Key.isEmpty()){
                    filteredUsuarioList = usuarioList;
                }
                else{

                    List<Usuarios> lstFiltered = new ArrayList<>();
                    for(Usuarios row: usuarioList){
                        if(row.getNombre().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);

                        }
                    }

                    filteredUsuarioList = lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUsuarioList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredUsuarioList = (List<Usuarios>)filterResults.values;
                notifyDataSetChanged();

            }
        };

    }


}
