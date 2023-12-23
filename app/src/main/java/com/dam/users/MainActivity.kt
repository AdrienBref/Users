package com.dam.users

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.RadioButton
import com.dam.users.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var configuration: Configuration
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        configuration = resources.configuration
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonIds = mutableListOf<Button>()

        binding.javaClass.declaredFields.forEach { field ->
            if (field.type == Button::class.java) {
                field.isAccessible = true
                val button = field.get(binding) as? Button
                button?.let {
                    buttonIds.add(it)
                }
            }
        }

        buttonIds?.forEach {button ->
            button?.setOnClickListener(this)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.cleanText.id -> {

                binding.user.text = null;
                binding.password.text = null;
                binding.spinnerPerfil.setSelection(0)
                binding.profileGroup.clearCheck()

            }
            binding.Login.id -> {
                if(!binding.password.text.isEmpty()
                    && !binding.user.text.isEmpty()
                    && findViewById<RadioButton>(binding.profileGroup.checkedRadioButtonId).text.toString() != null) {

                    val correo = binding.user.text.toString()
                    val password = binding.password.text.toString()
                    val perfil = binding.spinnerPerfil.selectedItem.toString()
                    val visibilidad = findViewById<RadioButton>(binding.profileGroup.checkedRadioButtonId).text.toString()

                } else {
                    Snackbar.make(
                        binding.root, resources.getString(R.string.mensaje_datos),Snackbar.LENGTH_SHORT
                    ).show()
                }


            }
        }
    }
}