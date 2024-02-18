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
import com.dam.users.models.User

class UsersAdapter(val lista : ArrayList<User>,
                   var context : Context
) : RecyclerView.Adapter<UsersAdapter.MyHolder>(){

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
        TODO("Not yet implemented")
    }
}