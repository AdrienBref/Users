package com.dam.users.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dam.users.R
import com.dam.users.models.Contacto

class UsersAdapter(val lista : ArrayList<Contacto>,
                   var context : Context
) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {
    //TODO: Paso 4 -> Creo un elemento de la interfaz
    private lateinit var listener : OnRecyclerUsuarioListener

    //TODO PASO 5 -> inicializo la interfaz en el bloque que siempre se ejecuta

    init {
        listener = context as OnRecyclerUsuarioListener
    }
    class MyHolder(item: View) : ViewHolder(item) {

        var imagen : ImageView
        var nombre : TextView
        init{
            imagen = item.findViewById(R.id.imagen_fila)
            nombre = item.findViewById(R.id.nombre_fila)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler,parent, false)
        return  MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val usuario = lista[position]
        holder.nombre.text = usuario.nombre
        holder.imagen.setImageResource(usuario.imagen)
        holder.imagen.setOnClickListener {
            //Imagen pulsada --> borrar elemento
            lista.removeAt(position)
            notifyItemRemoved(position)
        }
        holder.nombre.setOnClickListener{
            //Texto pulsado --> sacar un snackbar
            /*Snackbar.make(holder.nombre,
                "nombre pulsado ${usuario.telefono.toString()}" ,
                Snackbar.LENGTH_SHORT).show()*/
            //Texto pulsado --> Llevar al Activity
            /*
            * TODO: PASO 3 -> llamo al metodo de la interfaz
            * */
            listener.onContactoSelected(usuario)

        }
    }
    fun addContact(contacto:Contacto) {
        this.lista.add(contacto)
        notifyItemInserted(lista.size - 1)
    }

    /*
    * INTERFAZ DE CALLBACK
    *
    * TODO: PASO 1: --> crear una interfaz en el origen de los datos
    *
    * */

    interface OnRecyclerUsuarioListener {
       /*
       * TODO: PASO 2 -> crear un metodo con el dato a comunicar en parametro
       * */

        fun onContactoSelected(contacto: Contacto)
    }
}