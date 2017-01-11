package com.example.joseantonio.proyecto2;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by JoseAntonio on 11/01/2017.
 */
public class Adaptador extends RecyclerView.Adapter<Adaptador.ContactoViewHolder> {

    private List<Contacto> items;
    private static ContactoViewHolder.OnItemClickListener onItemClickListener;

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre;
        public TextView estado;
        public View v;
        private final Context context;

        public interface OnItemClickListener {

        }

        public ContactoViewHolder(View v) {
            super(v);
            this.v=v;
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            estado = (TextView) v.findViewById(R.id.estado);
            context = itemView.getContext();


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(context.getApplicationContext(), alarmas.class);
                    detail.putExtra("id", imagen.getId());
                    context.startActivity(detail);
                }
            });
        }


    }


    public Adaptador(List<Contacto> items) {
        this.items = items;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card, viewGroup, false);
        return new ContactoViewHolder(v);
    }




        @Override
        public void onBindViewHolder(ContactoViewHolder viewHolder, int i) {

        final int pos=i;

        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.estado.setText("Estado:"+(items.get(i).getEstado()));


        viewHolder.v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialegConfirmaEliminacio(v, pos);
                return true;
            }
        });

    }


    public void dialegConfirmaEliminacio(View v, final int posicio){

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

        String contact = "<b>"+items.get(posicio).getNombre()+"</b>";
        String msg = "Estas seguro que quieres eliminar el contacto " + contact+"?";
        builder.setMessage(Html.fromHtml(msg));
        builder.setTitle("Eliminar Contacto");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                items.remove(posicio);
                notifyItemRemoved(posicio);
                notifyItemRangeChanged(posicio, getItemCount());
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();

    }
}
