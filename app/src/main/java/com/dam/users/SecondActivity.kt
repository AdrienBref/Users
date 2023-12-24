package com.dam.users

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dam.users.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var configuration: Configuration
    //TODO: Recuerperar el usuario como objeto
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        configuration = resources.configuration
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correo = intent.getStringExtra("EXTRA_MAIL");

        binding.emailHeadline.text = correo

        binding.closeSession.setOnClickListener {
            finish()
        }

    }
}
