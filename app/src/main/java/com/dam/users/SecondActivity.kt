package com.dam.users

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import com.dam.users.databinding.ActivitySecondBinding
import com.dam.users.models.User
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable




class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var configuration: Configuration
    private lateinit var user : User
    //TODO: Recuerperar el usuario como objeto
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        configuration = resources.configuration
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correo = intent.getStringExtra("EXTRA_MAIL");
        user = intent.extras!!.getSerializable("user") as User

        binding.emailHeadline.text = correo
        binding.emailHeadline.text = user.perfil
        binding.emailHeadline.text = user.visibilidad

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

    }
}
