package com.dam.users.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dam.users.R

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.MyHolder>(){

    class MyHolder(item: View) : ViewHolder(item) {

        var imagen : ImageView
        var nombre : TextView
        init{
            imagen = item.findViewById(R.id.imagen_fila)
            nombre = item.findViewById(R.id.nombre_fila)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }
}