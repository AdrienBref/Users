package com.dam.users

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dam.users.adapter.UsersAdapter
import com.dam.users.databinding.ActivitySecondBinding
import com.dam.users.models.Contacto
import com.dam.users.models.User
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable


// TODO: PASO 5: Implemento la interfaz en el destino de la comunicaion

class SecondActivity : AppCompatActivity(), UsersAdapter.OnRecyclerUsuarioListener {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var configuration: Configuration
    private lateinit var user : User
    private lateinit var usersAdapter : UsersAdapter
    private lateinit var listaUsuarios : ArrayList<Contacto>
    //TODO: Recuerperar el usuario como objeto
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        configuration = resources.configuration
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaUsuarios = ArrayList()
        usersAdapter = UsersAdapter(listaUsuarios, this)

        usersAdapter.addContact(Contacto("Adrian", "Bernabeu",1234, R.drawable.useremail))
        usersAdapter.addContact(Contacto("AdrianII", "Bernabeu",1234, R.drawable.useremail2))
        usersAdapter.addContact(Contacto("AdrianIII", "Bernabeu",1234, R.drawable.useremail3))

        val correo = intent.getStringExtra("EXTRA_MAIL");
        user = intent.extras!!.getSerializable("user") as User

        binding.emailHeadline.text = correo
        binding.emailHeadline.text = user.perfil
        binding.emailHeadline.text = user.visibilidad
        binding.recyclerUsuarios.adapter = usersAdapter
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        binding.closeSession.setOnClickListener {
            finish()
        }
        binding.SpinnerGenero.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val seleccionado = parent!!.adapter.getItem(position).toString()
                Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.agregar.setOnClickListener {
            usersAdapter.addContact(Contacto("Gema", "Martinez", 123456, R.drawable.useremail))
        }

    }

    override fun onContactoSelected(contacto: Contacto) {
        Snackbar.make(binding.root,"Contacto recibido", Snackbar.LENGTH_SHORT).show()
    }
}
